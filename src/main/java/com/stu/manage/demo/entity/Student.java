package com.stu.manage.demo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 学生
 *
 * @author wzh
 */


@Data
public class Student {

    /**
     *  配置主键生成策略
     */
    @TableId(type = IdType.AUTO)
    private Integer studentId;
    @NotBlank(message = "姓名不能为空")
    private String studentName;
    @NotBlank(message = "身份证不能为空")
    private String idCard;
    @NotNull
    private String sex;
    @NotNull
    private String gradeId;
    @NotNull
    private String classId;
}