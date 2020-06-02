package com.xhj.springbootmybatis.service.mybatisdemo;

import java.math.BigDecimal;

/**
 * @author xhj
 */
public interface MoneyService {

    /**
     * 转账
     *
     * @param userIdA
     * @param userIdB
     * @param money
     * @return
     */
    String changeUserMoney(Long userIdA, Long userIdB, BigDecimal money) throws InterruptedException;

}