package com.huxw.demo.web;

import com.huxw.demo.entity.User;
import com.huxw.demo.service.IPlanService;
import com.huxw.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: huxw
 * @Date: 2019-4-19 17:17
 * @Version 1.0
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("/login")
    /**
     * @Author huxw
     * @Description 登录页面
     * @Date 2019-4-20 8:09
     * @Param []
     * @return java.lang.String
     **/
    public String login() throws Exception{
        return "user/login";
    }

    @GetMapping("/checkUserName")
    /**
     * @Author huxw
     * @Description 查询数据库用户名
     * @Date 2019-4-20 8:24
     * @Param [userName]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @ResponseBody
    public Map<String, Object> checkUserName(String userName) throws Exception{
        Map<String, Object> map = new HashMap<String, Object>();
        User user = iUserService.queryUserByName(userName);
        if (user != null){
            map.put("flag", "has");
        }else {
            map.put("flag", "noHas");
        }
        return map;
    }

    @PostMapping("/submit")
    /**
     * @Author huxw
     * @Description 用户登录
     * @Date 2019-4-20 11:02
     * @Param [user]
     * @return java.lang.String
     **/
    public String submit(User user) throws Exception{
        User u = iUserService.queryUserByNamePassword(user);
        if(u != null){
            return "redirect:/user/list";
        }else {
            return "user/login";
        }
    }

    @GetMapping("/regist")
    /**
     * @Author huxw
     * @Description 跳转用户注册页面
     * @Date 2019-4-20 11:13
     * @Param []
     * @return java.lang.String
     **/
    public String regist() throws Exception{
        return "user/regist";
    }

    @PostMapping("/registSubmit")
    /**
     * @Author huxw
     * @Description 插入用户数据
     * @Date 2019-4-20 15:25
     * @Param [user]
     * @return java.lang.String
     **/
    public String registSubmit(User user)throws Exception{
        if (user != null){
            iUserService.insertUser(user);
        }
        return "redirect:/user/list";
    }

    @GetMapping("/list")
    /**
     * @Author huxw
     * @Description 获取所有用户
     * @Date 2019-4-20 15:38
     * @Param
     * @return
     **/
    public String list(HttpServletRequest request) throws Exception{
        List<User> list = iUserService.queryUser();
        request.setAttribute("list", list);
        return "user/list";
    }

    /**
     * @Author huxw
     * @Description 删除用户
     * @Date 2019-4-20 16:11
     * @Param
     * @return
     **/
    @PostMapping("/delete")
    public String delete(int id) throws Exception{
        iUserService.deleteUser(id);
        return "redirect:/user/list";
    }


}
