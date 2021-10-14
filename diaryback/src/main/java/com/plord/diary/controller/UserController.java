package com.plord.diary.controller;

import com.plord.diary.entity.User;
import com.plord.diary.service.UserService;
import com.plord.diary.vo.ConstsVo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2021-10-10
 */
@RestController
@RequestMapping("//user")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping("/list")
    public Object test() {
        return service.list();
    }

    @GetMapping("/getUser/{username}")
    public Object getUse(@PathVariable("username") String username) {
        return service.getByUserName(username);
    }

    @PostMapping("/login")
    public Object login(HttpServletRequest request, HttpSession session){
        JSONObject jsonObject = new JSONObject();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean flag = service.vertify(username,password);
        User user = service.getByUserName(username);
        if(flag){
            jsonObject.put(ConstsVo.CODE,520);
            jsonObject.put(ConstsVo.MSG,"登录成功");
            session.setAttribute("user",user);
            return jsonObject;
        }
        jsonObject.put(ConstsVo.CODE,250);
        jsonObject.put(ConstsVo.MSG,"用户名或密码错误");
        return jsonObject;
    }





    @PostMapping("/register")
    public Object register(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        String id = request.getParameter("id").trim();
        String email = request.getParameter("email").trim();
        String location = request.getParameter("location").trim();
        String firstday = request.getParameter("firstday").trim();
        String sex = request.getParameter("sex").trim();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date firstdaydate = new Date();
        try {
            firstdaydate = sdf.parse(firstday);
        }catch (ParseException e){
            e.printStackTrace();
        }
        User user = new User();
        user.setEmail(email);
        user.setFirstday(firstdaydate);
        user.setId(id);
        user.setLocation(location);
        user.setPassword(password);
        user.setSex(new Integer(sex));
        user.setUsername(username);
        boolean flag = service.save(user);
        if (flag) {
            jsonObject.put(ConstsVo.CODE, 520);
            jsonObject.put(ConstsVo.MSG, "注册成功");
            return jsonObject;
        }
        jsonObject.put(ConstsVo.CODE,250);
        jsonObject.put(ConstsVo.MSG,"注册失败");
        return jsonObject;
    }




    @PostMapping("/updata")
    public Object updataUser(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String username = request.getParameter("username").trim();
        String passward = request.getParameter("password").trim();
        String email = request.getParameter("email");
        String location = request.getParameter("location");
        String sex = request.getParameter("sex");
        DateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
        User user = new User();
        user.setEmail(email);
        user.setLocation(location);
        user.setPassword(passward);
        user.setSex(new Integer(sex));
        user.setUsername(username);
        boolean flag = service.update(user,null);
        if (flag) {
            jsonObject.put(ConstsVo.CODE, 520);
            jsonObject.put(ConstsVo.MSG, "修改成功");
            return jsonObject;
        }
        jsonObject.put(ConstsVo.CODE,250);
        jsonObject.put(ConstsVo.MSG,"修改失败");
        return jsonObject;
    }

    @PutMapping("/UpdateUserPhoto/{username}/{photopath}")
    public int UpdateUserPhoto(@PathVariable("username") String username,@PathVariable("photopath") String photopath){
        User user = new User();
        user.setUsername(username);
        user.setPhotopath(photopath);
        return service.updateUserPhoto(user);
    }




}


