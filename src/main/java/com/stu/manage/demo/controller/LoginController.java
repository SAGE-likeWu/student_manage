package com.stu.manage.demo.controller;

import com.stu.manage.demo.entity.Login;
import com.stu.manage.demo.entity.LoginToken;
import com.stu.manage.demo.result.Result;
import com.stu.manage.demo.result.ResultEnum;
import com.stu.manage.demo.result.ResultUtil;
import com.stu.manage.demo.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author wzh
 */


@RestController
@Slf4j
public class LoginController {

   @Autowired
   private LoginService loginService;

    @PostMapping("/login")
    public Result getadmin(@RequestBody @Valid Login login){
        log.info("/login start");
       if(login.getPassWord().equals(loginService.getAdmin(login.getAdminName()))){
           LoginToken res=new LoginToken();
           res.setName(login.getAdminName());
           res.setToken("pass");
           return ResultUtil.success(res);
       }else {
           return ResultUtil.error(ResultEnum.VERIFY_FAIL.getCode(),ResultEnum.VERIFY_FAIL.getMsg());
       }
    }

}
