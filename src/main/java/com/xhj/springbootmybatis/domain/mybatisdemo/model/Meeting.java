package com.xhj.springbootmybatis.domain.mybatisdemo.model;

import lombok.Data;
import java.util.Date;


@Data
public class Meeting {


    private Long id;


    private String meetingName;


    private Date startTime;

    private Date endTime;

    private String qrCode;

}