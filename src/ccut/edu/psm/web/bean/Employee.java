package ccut.edu.psm.web.bean;

/**
 * Created by HIPAA on 20152015/12/24.
 * Time : 11:11
 * ${}
 */

public class Employee {
    String id = "";              //雇员编号
    String name;            //雇员姓名
    String sex;             //雇员性别
    Float salary;          //雇员工资
    Float fund;            //公积金
    String training;        //雇员培训
    String rating;          //雇员考核

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

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

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Float getFund() {
        return fund;
    }

    public void setFund(Float fund) {
        this.fund = fund;
    }

    public String getTraining() {
        return training;
    }

    public void setTraining(String training) {
        this.training = training;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }



}
