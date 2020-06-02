package com.xhj.springbootmybatis.service.mybatisdemo.impl;

import com.xhj.springbootmybatis.service.mybatisdemo.UserMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author xhj
 */
@Service
public class UserMoneyServiceImpl implements UserMoneyService {

    @Autowired
    LogServiceImpl logService;

    @Autowired
    MoneyServiceImpl moneyService;

    @Override
    @Transactional
    public String changeUserMoneyByService(Long userIdA, Long userIdB, BigDecimal money) throws InterruptedException {

        //记录日志
        logService.addChangeLog(userIdA, userIdB, money);

        //转账操作
        moneyService.changeUserMoney(userIdA, userIdB, money);

        return "转账成功";
    }

}