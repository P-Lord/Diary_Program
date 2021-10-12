package com.plord.diary.controller;



import com.plord.diary.entity.Diary;
import com.plord.diary.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2021-10-10
 */
@RestController
@RequestMapping("//diary")
public class DiaryController {

    @Autowired
    DiaryService service;

    @GetMapping("/diarydata")
    public Object getBlogList(){
        return service.getById(1);
    }

    @PostMapping("/insert")
    public boolean add(@RequestBody Diary diary){
        return service.save(diary);
    }


}

