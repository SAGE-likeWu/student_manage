package com.stu.manage.demo.service;

import com.stu.manage.demo.entity.GradeClass;
import com.stu.manage.demo.entity.Score;

import java.util.List;

/**
 * @author wzh
 */

public interface ScoreService {

    /**
     * 查询所有成绩
     *
     * @return List<Score>
     */
     List<Score> getAllScore();

    /**
     * 查询
     *
     * @param examId
     * @return List<Score>
     */
     List<Score> getByExamId(Integer examId);

    /**
     * 通过学号查询成绩
     *
     * @param studentId
     * @return List<Score>
     */
     List<Score> getByStudentId(Integer studentId);



    /**
     * 查询某年级某班成绩
     *
     * @param gradeclass
     * @return List<Score>
     */
     List<Score> getByGradeClass(GradeClass gradeclass);

    /**
     * 查询某年级成绩
     *
     * @param gradeId
     * @return List<Score>
     */
     List<Score> getByGradeId(String gradeId);

    /**
     * 插入
     *
     * @param score
     * @return int
     */
     int insertScore(Score score);

    /**
     * 更新成绩
     *
     * @param score
     */
     void updateScore(Score score);



    /**
     * 删除
     *
     * @param examId
     */
     void deleteExam(Integer examId);

    /**
     * 删除
     *
     * @param studentId
     */
     void deleteStudent(Integer studentId);

}