package com.xhj.springbootmybatis.service;

import com.xhj.springbootmybatis.domain.jack.dao.UserMapper;
import com.xhj.springbootmybatis.domain.jack.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findByUsername(String username) {
        return userMapper.find(username);
    }


    public List<User> listUser() {
        return userMapper.list();
    }


    public int insertUser(User user) {
        return userMapper.insert(user);
    }


    public int updateUser(User user) {
        return userMapper.update(user);
    }


    public int delete(int id) {
        return userMapper.delete(id);
    }
}
