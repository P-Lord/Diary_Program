package com.plord.diary.mapper;

import com.plord.diary.entity.Diary;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author admin
 * @since 2021-10-10
 */
@Component
public interface DiaryMapper extends BaseMapper<Diary> {

    List<Diary> getListByUserName(String username);

}
