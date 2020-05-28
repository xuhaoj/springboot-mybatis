package com.xhj.springbootmybatis.domain.mybatisdemo.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xhj
 */
@Data
public class MoneyChangeLog {

    private Long id;

    private Long userida;

    private Long useridb;

    private BigDecimal money;

    private Date createTime;

}
