package com.xhj.springbootmybatis.controller;

import com.xhj.springbootmybatis.domain.mybatisdemo.dao.MeetingMapper;
import com.xhj.springbootmybatis.domain.mybatisdemo.dao.MeetingProductMapper;
import com.xhj.springbootmybatis.domain.mybatisdemo.model.Meeting;
import com.xhj.springbootmybatis.domain.mybatisdemo.model.MeetingModel;
import com.xhj.springbootmybatis.domain.mybatisdemo.model.MeetingProduct;
import com.xhj.springbootmybatis.domain.mybatisdemo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MeetingController {

    @Autowired
    private MeetingMapper meetingMapper;

    @Autowired
    private MeetingProductMapper meetingProductMapper;


    @RequestMapping("/meeting/{id}")
    public MeetingModel meeting(@PathVariable("id") Long meetingId) {
/*        if(xxx==null){
            return "";
        }*/

        MeetingModel model = new MeetingModel();

        //查找meeting
        Meeting meeting = meetingMapper.findById(meetingId);
        //查找产品
        List<MeetingProduct> productList = meetingProductMapper.queryAllByMeetingId(meetingId);
        //组装
        model.setMeetingId(meetingId);
        model.setMeetingName(meeting.getMeetingName());
        model.setStartTime(meeting.getStartTime());
        model.setEndTime(meeting.getEndTime());
        model.setQrCode(meeting.getQrCode());

        Product majorProduct = productList.stream().filter(m -> m.getIsMainProduct().equals(1))
                .map(m -> {
                    Product product = new Product();
                    product.setProductId(m.getProductId());
                    product.setProductName(m.getProductName());
                    return product;
                }).findAny().get();
        model.setMajorProduct(majorProduct);

        List<Product> products = productList.stream().filter(m -> m.getIsMainProduct().equals(0))
                .map(m -> {
                    Product product = new Product();
                    product.setProductId(m.getProductId());
                    product.setProductName(m.getProductName());
                    return product;
                }).collect(Collectors.toList());
        model.setProducts(products);
        return model;
    }

}