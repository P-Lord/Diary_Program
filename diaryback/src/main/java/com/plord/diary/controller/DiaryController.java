package com.plord.diary.controller;



import com.plord.diary.entity.Diary;
import com.plord.diary.service.DiaryService;
import com.plord.diary.vo.ConstsVo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@RequestMapping("/diary")
public class DiaryController {

    @Autowired
    DiaryService service;

    @GetMapping("/alldiary")
    public List<Diary> getDiaryList(){
        return service.list();
    }

    @PostMapping("/insertdiary")
    public Object InsertDiary(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String username = request.getParameter("username").trim();
        String title = request.getParameter("title").trim();
        String weather = request.getParameter("weather").trim();
        String content = request.getParameter("content").trim();
        String date = request.getParameter("date").trim();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date editordate = new Date();
        try {
            editordate = sdf.parse(date);
        }catch (ParseException e){
            e.printStackTrace();
        }
        Diary diary = new Diary();
        diary.setDate(editordate);
        diary.setContent(content);
        diary.setUsername(username);
        diary.setTitle(title);
        diary.setWeather(weather);
        boolean flag = service.save(diary);

        if (flag) {
            jsonObject.put(ConstsVo.CODE, 520);
            jsonObject.put(ConstsVo.MSG, "提交成功");
            return jsonObject;
        }
        jsonObject.put(ConstsVo.CODE,250);
        jsonObject.put(ConstsVo.MSG,"提交失败");
        return jsonObject;
    }

    @PostMapping("/getDiaryDetail/{id}")
    public Diary getDiaryDetail(@PathVariable(name = "id") Integer id){
        return service.getById(id);
    }

    @GetMapping("/getUserDiary/{username}")
    public List<Diary> getUserDiary(@PathVariable(name = "username") String username){
        return service.getListByUserName(username);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteDiary(@PathVariable(name = "id") Integer id){
        return service.removeById(id);
    }

    @PutMapping("update")
    public boolean update(@RequestBody Diary diary){
        return service.updateById(diary);
    }

}



