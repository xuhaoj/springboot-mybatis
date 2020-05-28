package com.xhj.springbootmybatis.domain.mybatisdemo.dao;

import com.xhj.springbootmybatis.domain.mybatisdemo.model.MoneyChangeLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author xhj
 */
@Repository
@Mapper
public interface MoneyChangeLogMapper {

    /**
     * 记录日志
     *
     * @param moneyChangeLog
     * @return
     */
    int addChangeLog(MoneyChangeLog moneyChangeLog);

}