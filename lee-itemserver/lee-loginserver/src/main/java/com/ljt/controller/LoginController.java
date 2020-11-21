package com.ljt.controller;

import com.ljt.base.BaseRequest;
import com.ljt.base.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/login.do")
    public BaseResponse<String> login(@RequestBody BaseRequest baseRequest){
        LOGGER.info("进入登录页面,请求tokenKey:{}",baseRequest.getTokenKey());
        try{
            Thread.sleep(5000);
        }catch (Exception e){
            LOGGER.error("线程异常:",e);
        }
        LOGGER.info("请求数据:{}",baseRequest.getRequestData());
        return BaseResponse.onSuccess("登录成功，尽情享受吧！");
    }

}
