package com.eastday.demo.controller;

import com.eastday.demo.entity.RetDto;
import com.eastday.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping(value = "/user")
@EnableAutoConfiguration
public class UserController {

    @Autowired
    private UserService userService;

    /**
     *手机验证码登录
     * @param phone
     * @param code
     * @return
     */
    @RequestMapping(value="smsLogin")
    public RetDto smsLogin(String phone,String code){
        return userService.smsLogin(phone,code);
    }

    /**
     * 模拟发送短信验证码
     * @param phone
     * @return
     */
    @RequestMapping(value="sendCode")
    public RetDto sendCode(String phone){
        return userService.sendCode(phone);
    }


    /**
     * 验证图像验证码
     * @param code
     * @return
     */
    @RequestMapping(value = "checkKaptcha")
    public RetDto kaptchaLogin(String code, HttpServletRequest request){
        return userService.checkKaptcha(code,request);
    }

}
