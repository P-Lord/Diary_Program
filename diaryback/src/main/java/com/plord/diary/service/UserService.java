package com.plord.diary.service;

import com.plord.diary.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2021-10-10
 */


public interface UserService extends IService<User> {
    public Boolean vertify(String username,String password);

    public User getByUserName(String username);

    public int updateUserPhoto(User user);

}
