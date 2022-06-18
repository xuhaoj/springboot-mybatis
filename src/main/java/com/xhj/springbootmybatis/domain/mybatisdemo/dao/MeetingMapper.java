package com.xhj.springbootmybatis.domain.mybatisdemo.dao;


import com.xhj.springbootmybatis.domain.mybatisdemo.model.Meeting;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author xhj
 */
@Repository
@Mapper
public interface MeetingMapper {


    Meeting findById(Long id);


}