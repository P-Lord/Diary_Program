package com.plord.diary.service.impl;


import com.plord.diary.entity.Diary;
import com.plord.diary.mapper.DiaryMapper;
import com.plord.diary.service.DiaryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2021-10-10
 */
@Service
public class DiaryServiceImpl extends ServiceImpl<DiaryMapper, Diary> implements DiaryService {

    @Autowired
    DiaryMapper mapper;

}
