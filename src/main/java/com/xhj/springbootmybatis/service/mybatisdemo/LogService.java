package com.xhj.springbootmybatis.service.mybatisdemo;

import java.math.BigDecimal;

/**
 * @author xhj
 */
public interface LogService {

    /**
     * 记录转账日志
     *
     * @param userIdA
     * @param userIdB
     * @param money
     * @return
     */
    int addChangeLog(Long userIdA, Long userIdB, BigDecimal money);

}