package com.xhj.springbootmybatis.service.mybatisdemo;

import java.math.BigDecimal;

/**
 * @author xhj
 */
public interface LogService {

    /**
     * 记日志
     *
     * @param userIdA
     * @param userIdB
     * @param money
     */
    void addChangeLog(Long userIdA, Long userIdB, BigDecimal money);

}