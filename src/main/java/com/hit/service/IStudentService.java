package com.hit.service;

import com.hit.bean.Student;

import java.util.List;

/**
 * @author lilj
 * @date 18/07/20
 */
public interface IStudentService {
    int deleteByPrimaryKey(byte[] uid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(byte[] uid);

    List<Student> selectByCondition(Student record);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}
