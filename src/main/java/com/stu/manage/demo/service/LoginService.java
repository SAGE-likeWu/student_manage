package com.stu.manage.demo.service;

/**
 * @author wzh
 */

public interface LoginService {

    /**
     * 查询管理员对应的密码
     *
     * @param name
     * @return String
     */
    String getAdmin(String name);
}
