package com.xhj.springbootmybatis.domain.mybatisdemo.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author xhj
 */
@Data
public class TUser {

    private Long id;

    private String name;

    private BigDecimal salary;

}