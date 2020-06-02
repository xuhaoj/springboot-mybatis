package com.xhj.springbootmybatis.controller;

import com.xhj.springbootmybatis.service.mybatisdemo.MoneyService;
import com.xhj.springbootmybatis.service.mybatisdemo.UserMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/tuser", method = {RequestMethod.GET, RequestMethod.POST})
public class UserController {


    @Autowired
    private UserMoneyService userMoneyService;

    @Autowired
    private MoneyService moneyService;


    @RequestMapping("/zhuanzhang")
    public String zhuanzhang(@RequestParam("userIdA") Long userIdA,
                             @RequestParam("userIdB") Long userIdB,
                             @RequestParam("money") BigDecimal money) throws InterruptedException {
        return userMoneyService.changeUserMoneyByService(userIdA, userIdB, money);

    }

    @RequestMapping("/testException")
    public String testException(@RequestParam("userIdA") Long userIdA,
                                @RequestParam("userIdB") Long userIdB,
                                @RequestParam("money") BigDecimal money) throws InterruptedException {
        return moneyService.changeUserMoney(userIdA, userIdB, money);

    }

}