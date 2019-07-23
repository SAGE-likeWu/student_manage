package com.stu.manage.demo.mapper;

import com.stu.manage.demo.entity.GradeClass;
import com.stu.manage.demo.entity.Student;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wzh
 */

@Component
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    /**
     * 通过学生id删除学生
     *
     * @param studentId
     */
    void deleteStudentById(Integer studentId);

//
//    /**
//     * 查询所有学生信息
//     *
//     * @return List<Student>
//     */
//    List<Student> getAllStudents();
//
//    /**
//     * 通过姓名查询学生成绩
//     *
//     * @param name
//     * @return List<Student>
//     */
//    List<Student> getStudentByName(String name);
//
//    /**
//     * 查询某班级学生信息
//     *
//     * @param classId
//     * @return List<Student>
//     */
//    List<Student> getStudentByClass(String classId);
//
//    /**
//     * 通过身份证查询学生信息
//     *
//     * @param idCard
//     * @return
//     */
//    List<Student> getStudentByIdCard(String idCard);
//
//    /**
//     * 查询某年级某班学生信息
//     *
//     * @param gradeClass
//     * @return List<Student>
//     */
//    List<Student> getStudentByGradeClass(GradeClass gradeClass);
//
//
//
//    /**
//     * 通过学生id查询学生信息
//     *
//     * @param studentId
//     * @return List<Student>
//     */
//    List<Student> getStudentById(Integer studentId);
//
//    /**
//     * 更新
//     *
//     * @param student
//     */
//    void updateStudent(Student student);


}