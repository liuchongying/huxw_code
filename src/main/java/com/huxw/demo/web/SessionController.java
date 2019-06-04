package com.huxw.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试session缓存
 * @Author: huxw
 * @Date: 2019-5-12 17:04
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/session")
public class SessionController {
    /**
     * @Author huxw
     * @Description 设置session
     * @Date 2019-5-12 12:27
     * @Param
     * @return
     **/
    @RequestMapping(value = "/setSession")
    public Map<String, Object> setSession (HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        request.getSession().setAttribute("message", request.getRequestURL());
        map.put("request Url", request.getRequestURL());
        return map;
    }

    /**
     * @Author huxw
     * @Description 获取session
     * @Date 2019-5-12 12:27
     * @Param
     * @return
     **/
    @RequestMapping(value = "/getSession")
    public Object getSession (HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        map.put("sessionId", request.getSession().getId());
        map.put("message", request.getSession().getAttribute("message"));
        return map;
    }
}
