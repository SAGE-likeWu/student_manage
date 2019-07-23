package com.stu.manage.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.stu.manage.demo.entity.GradeClass;
import com.stu.manage.demo.entity.Student;
import com.stu.manage.demo.mapper.StudentMapper;
import com.stu.manage.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wzh
 */

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;


    @Override
    public List<Student> getAllStudents() {
        Map<String,Object> map = new HashMap<>(1);
        map.put("is_valid",1);
       return studentMapper.selectByMap(map);
    }

    @Override
    public List<Student> getStudentByGradeClass(GradeClass gradeClass) {
        Map<String,Object> map = new HashMap<>(3);
        map.put("is_valid",1);
        map.put("grade_id",gradeClass.getGradeId());
        map.put("class_id",gradeClass.getClassId());
        return studentMapper.selectByMap(map);
    }

    @Override
    public List<Student> getStudentByName(String name) {
        Map<String,Object> map = new HashMap<>(2);
        map.put("is_valid",1);
        map.put("student_name",name);
        return studentMapper.selectByMap(map);
    }

    @Override
    public List<Student> getStudentByClass(String classId) {
        Map<String,Object> map = new HashMap<>(2);
        map.put("is_valid",1);
        map.put("class_id",classId);
        return studentMapper.selectByMap(map);
    }

    @Override
    public List<Student> getStudentByIdCard(String idCard) {
        Map<String,Object> map = new HashMap<>(2);
        map.put("is_valid",1);
        map.put("id_card",idCard);
        return studentMapper.selectByMap(map);
    }

    @Override
    public List<Student> getStudentById(Integer id) {
        Map<String,Object> map = new HashMap<>(2);
        map.put("is_valid",1);
        map.put("student_id",id);
        return studentMapper.selectByMap(map);
    }


    @Override
    public int insertStudent(Student s) {

       return studentMapper.insert(s);
    }

    @Override
    public int updateStudent(Student student) {
        //创建条件构造器
        QueryWrapper<Student> updateWrapper=new QueryWrapper<>();
        //指定条件
        updateWrapper.eq("student_id",student.getStudentId());
        updateWrapper.eq("is_valid",1);
        return studentMapper.update(student,updateWrapper);
    }

    @Override
    public void deleteStudentById(Integer studentId) {
        studentMapper.deleteStudentById(studentId);
    }
}