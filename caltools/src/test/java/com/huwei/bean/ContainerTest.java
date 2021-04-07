package com.huwei.bean;

import com.Config;
import com.mimi.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.DependsOn;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
@DependsOn
public class ContainerTest implements BeanNameAware {
    @Override
    public void setBeanName(String s) {
        System.out.println(s);
    }

    @Autowired
    ApplicationContext context;
    @Autowired
    Random r;
    @Autowired
    Container c;
    @Autowired
    Container c2;
    @Autowired
    @Qualifier("personBmiTool")
    Measurable pbt;

//    @Before
//    public void setUp() throws Exception {
//        context = new AnnotationConfigApplicationContext(Config.class);
//        c = (Container) context.getBean("container");
//        r = (Random) context.getBean("r");
//        pbt = (Measurable) context.getBean("personBmiTool");
//    }

    @Test
    public void save() {
        System.out.println(c == c2);
        System.out.println(c2);
        System.out.println(context.getEnvironment().getProperty("user.home"));
        System.out.println(context.getEnvironment().getProperty("user.dir"));
        System.out.println(context.getEnvironment().getProperty("JAVA_HOME"));
        Person p1 = new Person("张三", 1.70, 80);
        Person p2 = new Person("李四", 1.70, 60);     //bmi最小
        Person p3 = new Person("王五", 1.60, 90);     // bmi值大
        Person p4 = new Person("赵六", 1.66, 90);
        Person p5 = new Person("田七", 1.65, 90);
        Person p6 = new Person("王八", 1.67, 190);

        c.save(p1);
        c.save(p2);
        c.save(p3);
        c.save(p4);
        c.save(p5);
        c.save(p6);

        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            //  Math.random()   生成 0-1之间的小数
            Person p7 = new Person("王八" + i, 1 + Math.random(), r.nextInt(80) + 30);
            c.save(p7);
        }


        Person max = (Person) c.getMax();   //取最大值
        Person min = (Person) c.getMin();   //最最小值

        System.out.println("最大值:" + max.getName());
        System.out.println("最小值:" + min.getName());

        System.out.println("平均bmi:" + c.getAvg());

        Object[] objs = c.getObjs();
        for (Object o : objs) {
            Person pp = (Person) o;
            System.out.println(pp.getName() + "\t" + pp.getHeight() + "\t" + pp.getWeight() + "\t" + pbt.measure(pp));
        }
    }

//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        this.context = applicationContext;
//    }
}