package cn.shuangze.assetsms.entity;

import java.io.Serializable;
/**
 * 人员信息类
 */
public class PersonType implements Serializable{
    private int personID;
    private String name;
    private String sex;
    private String dept;
    private String job;
    private String other;

    public PersonType(int personID, String name, String sex, String dept, String job, String other) {
        this.personID = personID;
        this.name = name;
        this.sex = sex;
        this.dept = dept;
        this.job = job;
        this.other = other;
    }

    public PersonType(String name, String sex, String dept, String job, String other) {
        this.name = name;
        this.sex = sex;
        this.dept = dept;
        this.job = job;
        this.other = other;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
    
    @Override
    public String toString() {
        return "人员编号："+personID+", 姓名："+name +",性别："+sex+"部门："+dept+",职位：" +job +",其他：" +other;
    }   
}
