package com.yc.test;

import com.yc.myspringframework.MyApplicationContext;
import com.yc.myspringframework.stereotype.*;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;

/**
 * program:testspring
 * description:
 * author:lsj
 * create:2021-04-05 19:20
 */
public class MyAnnotationConfigApplicationContext implements MyApplicationContext {
    @Override
    public Object getBean(String id) {
        return beanMap.get(id);
    }

    Map<String, Object> beanMap = new HashMap<String, Object>();

    public MyAnnotationConfigApplicationContext(Class<?>... componentClasses) throws Exception {
        this.register(componentClasses);
    }

    private void register(Class<?>[] componentClasses) throws Exception {
        if (componentClasses == null || componentClasses.length <= 0) {
            throw new RuntimeException("没有指定配置类");
        }
        for (Class cls : componentClasses) {
            if (!cls.isAnnotationPresent(MyConfiguration.class)) {
                continue;
            }
            String[] basePackages = getAppConfigBasePackages(cls);
            if (cls.isAnnotationPresent(MyComponentScan.class)) {
                MyComponentScan mcs = (MyComponentScan) cls.getAnnotation(MyComponentScan.class);
                if (mcs.basePackages() != null && mcs.basePackages().length > 0) {
                    basePackages = mcs.basePackages();
                }
            }
            for (String basePackage : basePackages) {
                scanPackageAndSubpackage(basePackage);
            }
            handAtScanBean();
            Object obj = cls.newInstance();
            handleAtMyBean(cls, obj);
            //版本2di
            heandDi();
        }
    }

    private void heandDi() throws Exception {
        Collection<Object> collection = beanMap.values();
        for (Object o : collection) {
            Class cls = o.getClass();
            Method[] methods = cls.getDeclaredMethods();
            for (Method m : methods) {
                if (m.isAnnotationPresent(MyAutowired.class)) {
                    invokeAutowiredMethod(m, o);
                } else if (m.isAnnotationPresent(MyResource.class)) {
                    invokeResourceMethod(m, o);
                }
            }
            Field[] fs = cls.getDeclaredFields();
            for (Field f : fs) {
                if (f.isAnnotationPresent(MyAutowired.class)) {

                } else if (f.isAnnotationPresent(MyResource.class)) {

                }
            }
        }
    }

    private void invokeResourceMethod(Method m, Object o) throws InvocationTargetException, IllegalAccessException {
        MyResource mr = m.getAnnotation(MyResource.class);
        String beanId = mr.name();
        if (beanId == null || beanId.equalsIgnoreCase("")) {
            String pname = m.getParameterTypes()[0].getSimpleName();
            beanId = pname.substring(0, 1).toLowerCase() + pname.substring(1);
        }
        Object oo = beanMap.get(beanId);
        m.invoke(o, oo);
    }

    private void invokeAutowiredMethod(Method m, Object o) throws Exception {
        Class typeClass = m.getParameterTypes()[0];
        Collection<Object> collection = beanMap.values();
        for (Object oo : collection) {
            if (oo.getClass().getName().equalsIgnoreCase(typeClass.getName())) {
                m.invoke(o, oo);
            }
//            Class[] interfaces = oo.getClass().getInterfaces();
//            System.out.println(interfaces[0].getName());
//            for (Class c : interfaces) {
//                System.out.println(c.getName());
//                if (c == typeClass) {
//                    m.invoke(o, oo);
//                    break;
//                }
//            }
        }
    }

    private void handAtScanBean() throws Exception {
        for (Class cls : set) {
            if (cls.isAnnotationPresent(MyComponent.class)) {
                Object o = cls.newInstance();
                String beanId = cls.getSimpleName().replace(".class", "");
                beanId = beanId.substring(0, 1).toLowerCase() + beanId.substring(1);
                MyComponent myComponent = (MyComponent) cls.getAnnotation(MyComponent.class);
                String str = myComponent.value();
                if (str != null && str.length() > 0) {
                    beanId = str;
                }
                handlePostConstruct(o, o.getClass());
                beanMap.put(beanId, o);
            } else if (cls.isAnnotationPresent(MyRepository.class)) {
                Object o = cls.newInstance();
                String beanId = cls.getSimpleName().replace(".class", "");
                beanId = beanId.substring(0, 1).toLowerCase() + beanId.substring(1);
                MyRepository myRepository = (MyRepository) cls.getAnnotation(MyRepository.class);
                String str = myRepository.value();
                if (str != null && str.length() > 0) {
                    beanId = str;
                }
                handlePostConstruct(o, o.getClass());
                beanMap.put(beanId, o);
            } else if (cls.isAnnotationPresent(MyService.class)) {
                Object o = cls.newInstance();
                String beanId = cls.getSimpleName().replace(".class", "");
                beanId = beanId.substring(0, 1).toLowerCase() + beanId.substring(1);
                MyService myService = (MyService) cls.getAnnotation(MyService.class);
                String str = myService.value();
                if (str != null && str.length() > 0) {
                    beanId = str;
                }
                handlePostConstruct(o, o.getClass());
                beanMap.put(beanId, o);
            } else if (cls.isAnnotationPresent(MyController.class)) {
                Object o = cls.newInstance();
                String beanId = cls.getSimpleName().replace(".class", "");
                beanId = beanId.substring(0, 1).toLowerCase() + beanId.substring(1);
                MyController myController = (MyController) cls.getAnnotation(MyController.class);
                String str = myController.value();
                if (str != null && str.length() > 0) {
                    beanId = str;
                }
                handlePostConstruct(o, o.getClass());
                beanMap.put(beanId, o);
            }
        }
    }

    private void scanPackageAndSubpackage(String basePackage) throws Exception {
        String bp = basePackage.replaceAll("\\.", "/");
        Enumeration<URL> files = Thread.currentThread().getContextClassLoader().getResources(bp);
        while (files.hasMoreElements()) {
            URL url = files.nextElement();
            findClassFilesOrDirectory(url.getFile(), basePackage);
        }
    }

    Set<Class> set = new HashSet<Class>();

    private void findClassFilesOrDirectory(String file, String basePackage) throws Exception {
        File f = new File(file);
        File[] files = f.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".class") || pathname.isDirectory();
            }
        });
        for (File ff : files) {
            if (ff.isDirectory()) {
                basePackage += "." + ff.getName().substring(ff.getName().lastIndexOf("/") + 1);
                findClassFilesOrDirectory(ff.getAbsolutePath(), basePackage);
                basePackage.replace("." + ff.getName().substring(ff.getName().lastIndexOf("/") + 1), "");
            } else {
                URL[] urls = new URL[]{};
                URLClassLoader loader = new URLClassLoader(urls);
                String clsName = basePackage + "." + (ff.getName().replace(".class", ""));
                Class cls = loader.loadClass(clsName);
                set.add(cls);
            }
        }
    }

    private void handleAtMyBean(Class cls, Object obj) throws Exception {
        Method[] ms = cls.getDeclaredMethods();
        for (Method m : ms) {
            if (m.isAnnotationPresent(MyBean.class)) {
                Object o = m.invoke(obj);
                handlePostConstruct(o, o.getClass());
                beanMap.put(m.getName(), o);
            }
        }
    }

    private void handlePostConstruct(Object o, Class<?> aClass) throws Exception {
        Method[] ms = aClass.getDeclaredMethods();
        for (Method m : ms) {
            if (m.isAnnotationPresent(MyPostConstruct.class)) {
                m.invoke(o);
            }
        }
    }

    private String[] getAppConfigBasePackages(Class cls) {
        String[] paths = new String[1];
        paths[0] = cls.getPackage().getName();
        return paths;
    }
}
