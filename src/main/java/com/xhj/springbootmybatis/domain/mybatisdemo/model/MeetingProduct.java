package com.xhj.springbootmybatis.domain.mybatisdemo.model;

import lombok.Data;

@Data
public class MeetingProduct extends BaseObject{

    private Long id;

    private Long meetingId;

    private Long productId;


    private String productName;

    private Integer isMainProduct;


}