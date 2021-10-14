package com.plord.diary.mapper;

import com.plord.diary.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author admin
 * @since 2021-10-10
 */
@Component
public interface UserMapper extends BaseMapper<User> {
    int verify(String username,String password);
    User selectByUserName(String username);
    int updateUserPhoto(User user);
}
