package com.xhj.springbootmybatis.domain.mybatisdemo.model;

import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
public class MeetingModel {


    private Long meetingId;

    private String meetingName;

    private Date startTime;

    private Date endTime;

    private String qrCode;

    private Product majorProduct;

    private List<Product> products;



}


