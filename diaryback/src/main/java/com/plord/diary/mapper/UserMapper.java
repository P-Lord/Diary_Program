package com.plord.diary.mapper;

import com.plord.diary.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author admin
 * @since 2021-10-10
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    public int verify(String username,String password);

}
