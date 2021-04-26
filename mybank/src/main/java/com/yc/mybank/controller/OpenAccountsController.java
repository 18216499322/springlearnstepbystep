package com.yc.mybank.controller;

import com.yc.tx.bean.Accounts;
import com.yc.tx.service.AccountService;
import com.yc.tx.vo.AccountVO;
import com.yc.tx.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * program:testspring
 * description:openaccountscontroller
 * author:lsj
 * create:2021-04-24 21:10
 */
@RestController
@Api(value = "开户")
public class OpenAccountsController {
    @Autowired
    AccountService service;

    @RequestMapping(method = {RequestMethod.POST}, path = "/openaccounts")
    @ApiOperation(value = "开户", notes = "默认开户金额1元")
    @ApiImplicitParam(name = "money", required = true, dataType = "double")
    public @ResponseBody
    ResultVO openAccounts(AccountVO accountVO, @ApiIgnore ResultVO resultVO, @ApiIgnore Accounts accounts) {
        Double money = 1.0;
        try {
            if (accountVO.getMoney() != null && accountVO.getMoney() > 0) {
                money = accountVO.getMoney();
            }
            int accountId = service.openAccount(accounts, money);
            accounts.setAccountId(accountId);
            accounts.setBalance(money);
            resultVO.setCode(1);
            resultVO.setData(accounts);
        } catch (Exception e) {
            e.printStackTrace();
            resultVO.setCode(0);
            resultVO.setMessage(e.getMessage());
        }
        return resultVO;
    }
}
