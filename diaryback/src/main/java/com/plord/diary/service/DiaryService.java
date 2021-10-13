package com.plord.diary.service;

import com.plord.diary.entity.Diary;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2021-10-10
 */

public interface DiaryService extends IService<Diary> {

    List<Diary> getListByUserName(String username);

}
