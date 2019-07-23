package com.stu.manage.demo.controller;

import com.stu.manage.demo.entity.GradeClass;
import com.stu.manage.demo.entity.Score;
import com.stu.manage.demo.result.Result;
import com.stu.manage.demo.result.ResultEnum;
import com.stu.manage.demo.result.ResultUtil;
import com.stu.manage.demo.service.ScoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wzh
 */


@Slf4j
@RestController
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    private void setTotal(List<Score> res){
        if (res == null || res.isEmpty()) {
            return;
        }
        int size = res.size();

        for(int i=0;i<size;i++){
            float total=res.get(i).getChineseScore()+res.get(i).getMathScore()+res.get(i).getEnglishScore()+res.get(i).getCompositeScore();
            Score score= res.get(i);
            score.setTotal(total);
        }
    }

    @GetMapping("/get/all")
    public Result allScore(){

        List<Score> res =scoreService.getAllScore();
        setTotal(res);
        if(!res.isEmpty()) {
            return ResultUtil.success(res);
        }else {
            return ResultUtil.error(ResultEnum.DATA_IS_NULL.getCode(),ResultEnum.DATA_IS_NULL.getMsg());
        }
    }

    @GetMapping("/get/exam/{examID}")
    public Result byExamId(@PathVariable("examID")Integer examId){
        List<Score> res = scoreService.getByExamId(examId);
        setTotal(res);
        if(!res.isEmpty()) {
            return ResultUtil.success(res);
        }else {
            return ResultUtil.error(ResultEnum.DATA_IS_NULL.getCode(),ResultEnum.DATA_IS_NULL.getMsg());
        }
    }

    @GetMapping("get/student/{studentID}")
    public Result byStudentId(@PathVariable("studentID")Integer studentId){
        List<Score> res = scoreService.getByStudentId(studentId);
        setTotal(res);
        if(!res.isEmpty()) {
            return ResultUtil.success(res);
        }else {
            return ResultUtil.error(ResultEnum.DATA_IS_NULL.getCode(),ResultEnum.DATA_IS_NULL.getMsg());
        }
    }

    @PostMapping("get/gradeclass")
    public Result byClassId(@RequestBody @Valid GradeClass gradeClass){
        List<Score> res= scoreService.getByGradeClass(gradeClass);
        setTotal(res);
        if(!res.isEmpty()) {
            return ResultUtil.success(res);
        }else {
            return ResultUtil.error(ResultEnum.DATA_IS_NULL.getCode(),ResultEnum.DATA_IS_NULL.getMsg());
        }
    }

    @GetMapping("get/grade/{gradeID}")
    public Result byGradeId(@PathVariable("gradeID")String gradeId){
        List<Score> res= scoreService.getByGradeId(gradeId);
        setTotal(res);
        if(!res.isEmpty()) {
            return ResultUtil.success(res);
        }else {
            return ResultUtil.error(ResultEnum.DATA_IS_NULL.getCode(),ResultEnum.DATA_IS_NULL.getMsg());
        }
    }

    @PostMapping("/insert")
    public Result insert(@RequestBody @Valid Score score){

        int res= scoreService.insertScore(score);
        if(res==1){
            return ResultUtil.success(res);
        }else {
            return ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(),ResultEnum.UNKNOWN_ERROR.getMsg());
        }

    }

    @PostMapping("/update")
    public Result update(@RequestBody @Valid  Score score){
        scoreService.updateScore(score);
        List<Score> res=new ArrayList<>();
        res.add(score);
        if(res.equals(scoreService.getByExamId(score.getExamId()))){
            return ResultUtil.success();
        }else {
            return ResultUtil.error(ResultEnum.UPDATE_FAIL.getCode(),ResultEnum.UPDATE_FAIL.getMsg());
        }
    }


    @DeleteMapping("delete/exam/{examID}")
    public void deleteExam(@PathVariable("examID")Integer examId){
        scoreService.deleteExam(examId);
    }


    @DeleteMapping("delete/student/{studentID}")
    public Result deleteStudent(@PathVariable("studentID")Integer studentId){
        scoreService.deleteStudent(studentId);
        List<Score> res=scoreService.getByStudentId(studentId);
        if(res.isEmpty()){
            return ResultUtil.success(res);
        }else {
            return ResultUtil.error(ResultEnum.DELETE_FAIL.getCode(),ResultEnum.DELETE_FAIL.getMsg());
        }
    }
}