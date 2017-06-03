package cn.howso.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class TestController {
    @RequestMapping("test")
    @ResponseBody
    public Object test(HttpServletRequest req){
    	//验证session共享
        Object obj = SecurityUtils.getSubject().getSession().getAttribute("my-key");
        System.out.println(obj);
        SecurityUtils.getSubject().getSession().setAttribute("my-key", req.getContextPath());
        return "test";
    }
}
