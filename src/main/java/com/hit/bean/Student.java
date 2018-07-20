package com.hit.bean;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author lilj
 * @date 18/07/20
 */
public class Student {
    private Integer uid;
    private String name;
    private Integer age;
    private Integer classid;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
