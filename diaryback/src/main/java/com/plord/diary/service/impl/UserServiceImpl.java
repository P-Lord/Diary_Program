package com.plord.diary.service.impl;

import com.plord.diary.entity.User;
import com.plord.diary.mapper.UserMapper;
import com.plord.diary.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2021-10-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper mapper;

    @Override
    public Boolean vertify(String username,String password) {
        return mapper.verify(username, password) > 0;
    }

    @Override
    public User getByUserName(String username) {
        return mapper.selectByUserName(username);
    }

    @Override
    public int updateUserPhoto(User user) {
        return mapper.updateUserPhoto(user);
    }
}
