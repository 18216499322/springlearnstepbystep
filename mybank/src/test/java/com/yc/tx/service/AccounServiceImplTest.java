package com.yc.tx.service;

import com.yc.tx.bean.Accounts;
import com.yc.tx.bean.OpTypes;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccounServiceImplTest {

    @Autowired
    private AccountService accountService;

    @Test
    @Transactional
    public void openAccount() {
        Integer i = accountService.openAccount(new Accounts(), 1);
        System.out.println(i);
        Assert.assertNotNull(i);
    }

    @Test
    public void deposite() {
        Accounts a = new Accounts();
        a.setAccountId(2);
        Accounts aa = accountService.deposite(a, 100, OpTypes.desposite.getName(), null);
        System.out.println(aa);

    }

    @Test
    public void withdraw() {
        Accounts a = new Accounts();
        a.setAccountId(2);
        Accounts aa = accountService.withdraw(a, 10, OpTypes.withdraw.getName(), null);
        System.out.println(aa);
    }

    @Test
    public void transfer() {
        Accounts out = new Accounts();
        out.setAccountId(2);

        Accounts in = new Accounts();
        in.setAccountId(3);

        this.accountService.transfer(in, out, 5);
    }

    @Test
    public void showBanlance() {
        Accounts a = new Accounts();
        a.setAccountId(1);
        a = this.accountService.showBanlance(a);
        System.out.println(a);
    }

    @Test
    public void findById() {
    }
}