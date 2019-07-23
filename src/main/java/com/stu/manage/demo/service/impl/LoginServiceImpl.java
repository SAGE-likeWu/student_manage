package com.stu.manage.demo.service.impl;


import com.stu.manage.demo.mapper.LoginMapper;
import com.stu.manage.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wzh
 */

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public String getAdmin(String name){
        return loginMapper.getAdmin(name);
    }
}
