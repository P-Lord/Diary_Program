package com.plord.diary.controller;


import com.fasterxml.jackson.databind.util.JSONPObject;
import com.plord.diary.entity.User;
import com.plord.diary.service.UserService;
import com.plord.diary.vo.ConstsVo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

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
    public List<User> test() {
        return service.list();
    }

    @PostMapping("/login")
    public Object login(HttpServletRequest request, HttpSession session){
        JSONObject jsonObject = new JSONObject();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean flag = service.vertify(username,password);
        if(flag){
            jsonObject.put(ConstsVo.CODE,520);
            jsonObject.put(ConstsVo.MSG,"登录成功");
            session.setAttribute("username",username);
            return jsonObject;
        }
        jsonObject.put(ConstsVo.CODE,250);
        jsonObject.put(ConstsVo.MSG,"用户名或密码错误");
        return jsonObject;


    }


}


