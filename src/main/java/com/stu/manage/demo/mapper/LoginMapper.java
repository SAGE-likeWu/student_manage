package com.stu.manage.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stu.manage.demo.entity.Login;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author wzh
 */

@Component
@Mapper
public interface LoginMapper extends BaseMapper<Login> {

    /**
     * 查询管理员对应的密码
     *
     * @param name
     * @return String
     */
    String getAdmin(String name);

}
