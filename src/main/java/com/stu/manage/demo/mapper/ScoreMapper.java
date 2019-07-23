package com.stu.manage.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stu.manage.demo.entity.Score;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


/**
 * @author wzh
 */

@Component
@Mapper
public interface ScoreMapper extends BaseMapper<Score> {

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


//    /**
//     * 通过成绩编码查询成绩
//     *
//     * @param examId
//     * @return List<Score>
//     */
//    List<Score> getByExamId(Integer examId);
//
//    /**
//     * 通过学生id查询成绩
//     *
//     * @param studentId
//     * @return List<Score>
//     */
//    List<Score> getByStudentId(Integer studentId);
//
//    /**
//     * 通过学生id和成绩id联合查询
//     *
//     * @param examId
//     * @param studentId
//     * @return Score
//     */
//    Score getByEsId(Integer examId, Integer studentId);
//
//    /**
//     * 查询某年级某班的成绩
//     *
//     * @param gradeclass
//     * @return List<Score>
//     */
//    List<Score> getByGradeClass(GradeClass gradeclass);
//
//    /**
//     * 查询某个年级的成绩
//     *
//     * @param gradeId
//     * @return List<Score>
//     */
//    List<Score> getBygradeId(String gradeId);
//
//    /**
//     * 查询所有成绩
//     *
//     * @return List<Score>
//     */
//    List<Score> getAllScore();
//
//    /**
//     * 删除
//     *
//     * @param examId
//     * @param studentId
//     */
//    void deleteEs(Integer examId, Integer studentId);
//    /**
//     * 更新
//     *
//     * @param score
//     */
//    void updateScore(Score score);




}