package com.hit.dao;

import com.hit.bean.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lilj
 * @date 18/07/20
 * 在Dao层写Mybatis接口（不需要写实现类，mybatis不需要）
 */
@Repository
public interface StudentMapper {
    int deleteByPrimaryKey(byte[] uid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(byte[] uid);

    List<Student> selectByCondition(Student record);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}
