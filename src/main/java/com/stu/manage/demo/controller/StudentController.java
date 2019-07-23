package com.stu.manage.demo.controller;

import com.stu.manage.demo.entity.GradeClass;
import com.stu.manage.demo.result.Result;
import com.stu.manage.demo.result.ResultEnum;
import com.stu.manage.demo.result.ResultUtil;
import com.stu.manage.demo.service.StudentService;
import com.stu.manage.demo.entity.Student;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author wzh
 */

@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getAll")
    public Result getAllStudents(){
        List<Student> res = studentService.getAllStudents();
        if(res!=null) {
            return ResultUtil.success(res);
        }else {
            return ResultUtil.error(ResultEnum.DATA_IS_NULL.getCode(),ResultEnum.DATA_IS_NULL.getMsg());
        }
    }

    @GetMapping("/find/id/{id}")
    public Result studentById(@PathVariable("id")Integer id){
        List<Student> res=studentService.getStudentById(id);

        if(!res.isEmpty()){
            return ResultUtil.success(res);
        }else {
            return ResultUtil.error(ResultEnum.STUDENT_NOT_EXIST.getCode(),ResultEnum.STUDENT_NOT_EXIST.getMsg());
        }

    }

    @GetMapping("/find/name/{name}")
    public Result getStudentByName(@PathVariable("name")String name){
        List<Student> res=studentService.getStudentByName(name);
        if(res!=null){
            return ResultUtil.success(res);
        }else {
            return ResultUtil.error(ResultEnum.STUDENT_NOT_EXIST.getCode(),ResultEnum.STUDENT_NOT_EXIST.getMsg());
        }
    }

    @GetMapping("/find/classid/{classid}")
    public Result getStudentByClassid(@PathVariable("classid")String classid){
        List<Student> res = studentService.getStudentByClass(classid);
        if(res!=null) {
            return ResultUtil.success(res);
        }else {
            return ResultUtil.error(ResultEnum.DATA_IS_NULL.getCode(),ResultEnum.DATA_IS_NULL.getMsg());
        }
    }

    @GetMapping("/find/idcard/{idcard}")
    public Result studentByIdCard(@PathVariable("idcard")String idcard){
        List<Student> res=studentService.getStudentByIdCard(idcard);
        if(res!=null){
            return ResultUtil.success(res);
        }else {
            return ResultUtil.error(ResultEnum.STUDENT_NOT_EXIST.getCode(),ResultEnum.STUDENT_NOT_EXIST.getMsg());
        }
    }

    @PostMapping("get/gradeclass")
    public Result byClassId(@RequestBody @Valid GradeClass gradeClass){
        List<Student> res= studentService.getStudentByGradeClass(gradeClass);
        if(!res.isEmpty()) {
            return ResultUtil.success(res);
        }else {
            return ResultUtil.error(ResultEnum.DATA_IS_NULL.getCode(),ResultEnum.DATA_IS_NULL.getMsg());
        }
    }

    @PostMapping ("/insert")
    public Result insert(@RequestBody @Valid Student student){
        int res=studentService.insertStudent(student);
        if(res==1){
            return ResultUtil.success(res);
        }else {
            return ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(),ResultEnum.UNKNOWN_ERROR.getMsg());
        }
    }

    @PostMapping("/update")
    public Result update(@RequestBody @Valid Student student){
         int res=studentService.updateStudent(student);
         if(res>0){
             return ResultUtil.success();
         }else {
             return ResultUtil.error(ResultEnum.UPDATE_FAIL.getCode(),ResultEnum.UPDATE_FAIL.getMsg());
         }
    }

    @DeleteMapping("/delete/id/{id}")
    public Result delete(@PathVariable("id")Integer studentId){
        studentService.deleteStudentById(studentId);
        List<Student> res=studentService.getStudentById(studentId);
        if(res.isEmpty()){
            return ResultUtil.success(res);
        }else {
            return ResultUtil.error(ResultEnum.DELETE_FAIL.getCode(),ResultEnum.DELETE_FAIL.getMsg());
        }
    }

}