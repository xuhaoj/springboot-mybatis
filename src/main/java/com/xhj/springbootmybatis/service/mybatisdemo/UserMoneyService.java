package com.xhj.springbootmybatis.service.mybatisdemo;

import java.math.BigDecimal;

/**
 * @author xhj
 */
public interface UserMoneyService {

    /**
     * 转账
     *
     * @param userIdA
     * @param userIdB
     * @param money
     * @return
     */
    String changeUserMoneyByService(Long userIdA, Long userIdB, BigDecimal money);

}