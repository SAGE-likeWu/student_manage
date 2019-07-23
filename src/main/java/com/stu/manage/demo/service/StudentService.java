package com.stu.manage.demo.service;

import com.stu.manage.demo.entity.GradeClass;
import com.stu.manage.demo.entity.Student;

import java.util.List;

/**
 * @author wzh
 */

public interface StudentService {
     /**
      * 通过学生id查询学生信息
      *
      * @param studentId
      * @return List<Student>
      */
     List<Student> getStudentById(Integer studentId);

     /**
      * 通过姓名查询学生信息
      *
      * @param name
      * @return List<Student>
      */
     List<Student> getStudentByName(String name);

     /**
      * 查询某班学生成绩
      *
      * @param classId
      * @return List<Student>
      */
     List<Student> getStudentByClass(String classId);

     /**
      * 通过身份证查询学生信息
      *
      * @param idCard
      * @return List<Student>
      */
     List<Student> getStudentByIdCard(String idCard);

     /**
      * 查询所有学生信息
      *
      * @return List<Student>
      */
     List<Student> getAllStudents();

     /**
      * 查询某年级某班学生信息
      *
      * @param gradeclass
      * @return List<Student>
      */
     List<Student> getStudentByGradeClass(GradeClass gradeclass);

     /**
      * 创建一条学生信息
      *
      * @param student
      * @return int
      */
     int insertStudent(Student student);

     /**
      * 更新学生信息
      *
      * @param student
      * @return int
      */
     int updateStudent(Student student);

     /**
      * 删除
      *
      * @param studentId
      */
     void deleteStudentById(Integer studentId);

}