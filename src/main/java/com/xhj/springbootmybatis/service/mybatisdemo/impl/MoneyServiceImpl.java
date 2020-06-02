package com.xhj.springbootmybatis.service.mybatisdemo.impl;

import com.xhj.springbootmybatis.domain.mybatisdemo.dao.TUserMapper;
import com.xhj.springbootmybatis.service.mybatisdemo.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author xhj
 */
@Service
public class MoneyServiceImpl implements MoneyService {

    @Autowired
    private TUserMapper userMapper;


    @Override
    @Transactional
    public String changeUserMoney(Long userIdA, Long userIdB, BigDecimal money) throws InterruptedException {

        //账户A减去money
        userMapper.updateUserMoneyMinus(userIdA, money);
        //账户B加money
        userMapper.updateUserMoneyAdd(userIdB, money);
        if (true) {
            //throw new InterruptedException("jack xu帅哥");
            throw new RuntimeException("jack xu帅哥");
        }

        return "转账成功";
    }

}