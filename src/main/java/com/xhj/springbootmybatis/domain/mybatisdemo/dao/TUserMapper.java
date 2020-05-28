package com.xhj.springbootmybatis.domain.mybatisdemo.dao;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * @author xhj
 */
@Repository
@Mapper
public interface TUserMapper {


    /**
     * 加钱
     *
     * @param userIdA
     * @param money
     * @return
     */
    int updateUserMoneyMinus(Long userIdA, BigDecimal money);


    /**
     * 减钱
     *
     * @param userIdB
     * @param money
     * @return
     */
    int updateUserMoneyAdd(Long userIdB, BigDecimal money);

}