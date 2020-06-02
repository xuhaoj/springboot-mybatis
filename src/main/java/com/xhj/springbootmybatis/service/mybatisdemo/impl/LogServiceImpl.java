package com.xhj.springbootmybatis.service.mybatisdemo.impl;

import com.xhj.springbootmybatis.domain.mybatisdemo.dao.MoneyChangeLogMapper;
import com.xhj.springbootmybatis.domain.mybatisdemo.model.MoneyChangeLog;
import com.xhj.springbootmybatis.service.mybatisdemo.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xhj
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private MoneyChangeLogMapper moneyChangeLogMapper;

    @Override
    @Transactional
    public int addChangeLog(Long userIdA, Long userIdB, BigDecimal money) {
        try {
            MoneyChangeLog moneyChangeLog = new MoneyChangeLog();
            moneyChangeLog.setUserida(userIdA);
            moneyChangeLog.setUseridb(userIdB);
            moneyChangeLog.setMoney(money);
            moneyChangeLog.setCreateTime(new Date());
            int i = moneyChangeLogMapper.addChangeLog(moneyChangeLog);

            return i;
        }catch (Exception ex){
            return 0;
        }
    }

}