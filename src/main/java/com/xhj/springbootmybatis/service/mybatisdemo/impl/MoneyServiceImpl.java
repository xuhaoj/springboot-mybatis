package com.xhj.springbootmybatis.service.mybatisdemo.impl;

import com.xhj.springbootmybatis.domain.mybatisdemo.dao.TUserMapper;
import com.xhj.springbootmybatis.service.mybatisdemo.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author xhj
 */
@Service
public class MoneyServiceImpl implements MoneyService {

    @Autowired
    private TUserMapper userMapper;


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public String changeUserMoney(Long userIdA, Long userIdB, BigDecimal money) {

        //账户A减去money
        userMapper.updateUserMoneyMinus(userIdA, money);

        //账户B加money
        userMapper.updateUserMoneyAdd(userIdB, money);

        return "转账成功";
    }

}