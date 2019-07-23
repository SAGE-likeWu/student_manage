package com.stu.manage.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 成绩
 *
 * @author wzh
 */

@Data
public class Score {
    @TableId(type = IdType.AUTO)
    private Integer examId;
    @NotNull
    private String examInformation;
    @NotNull
    private Integer studentId;
    @NotNull
    private String studentName;
    @NotNull
    private String gradeId;
    @NotNull
    private String classId;
    @NotNull
    private float chineseScore;
    @NotNull
    private float mathScore;
    @NotNull
    private float englishScore;
    @NotNull
    private float compositeScore;

    private float total;
}