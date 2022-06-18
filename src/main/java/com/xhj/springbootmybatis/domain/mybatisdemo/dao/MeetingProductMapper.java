package com.xhj.springbootmybatis.domain.mybatisdemo.dao;


import com.xhj.springbootmybatis.domain.mybatisdemo.model.Meeting;
import com.xhj.springbootmybatis.domain.mybatisdemo.model.MeetingProduct;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xhj
 */
@Repository
@Mapper
public interface MeetingProductMapper {


    List<MeetingProduct> queryAllByMeetingId(Long id);


}