package com.stu.manage.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.stu.manage.demo.entity.GradeClass;
import com.stu.manage.demo.entity.Score;
import com.stu.manage.demo.mapper.ScoreMapper;
import com.stu.manage.demo.service.ScoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wzh
 */

@Slf4j
@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreMapper scoreMapper;


    @Override
    public List<Score> getAllScore() {
        Map<String,Object> map =new HashMap<>(1);
        map.put("is_valid",1);
        return scoreMapper.selectByMap(map);
    }

    @Override
    public List<Score> getByExamId(Integer examId) {
        Map<String,Object> map =new HashMap<>(2);
        map.put("is_valid",1);
        map.put("exam_id",examId);
        return scoreMapper.selectByMap(map);
    }

    @Override
    public List<Score> getByStudentId(Integer studentId) {
        Map<String,Object> map =new HashMap<>(2);
        map.put("is_valid",1);
        map.put("student_id",studentId);
        return scoreMapper.selectByMap(map);
    }

    @Override
    public List<Score> getByGradeClass(GradeClass gradeclass) {
        Map<String,Object> map =new HashMap<>(3);
        map.put("is_valid",1);
        map.put("class_id",gradeclass.getClassId());
        map.put("grade_id",gradeclass.getGradeId());
        return scoreMapper.selectByMap(map);
    }

    @Override
    public List<Score> getByGradeId(String gradeId) {
        Map<String,Object> map =new HashMap<>(2);
        map.put("is_valid",1);
        map.put("grade_id",gradeId);
        return scoreMapper.selectByMap(map);
    }

    @Override
    public int insertScore(Score score) {
       return scoreMapper.insert(score);
    }

    @Override
    public void updateScore(Score score) {
        QueryWrapper<Score> updateWrapper= new QueryWrapper<>();
        updateWrapper.eq("is_valid",1);
        updateWrapper.eq("exam_id",score.getExamId());
        scoreMapper.update(score,updateWrapper);
    }

    @Override
    public void deleteExam(Integer examId) {
        scoreMapper.deleteExam(examId);
    }

    @Override
    public void deleteStudent(Integer studentId) {
        scoreMapper.deleteStudent(studentId);
    }
}