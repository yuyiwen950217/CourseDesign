package ccut.edu.psm.web.structs.form;

import org.apache.struts.action.ActionForm;

/**
 * Created by HIPAA on 20152015/12/24.
 * Time : 11:06
 * ${}
 */

public class EmployeeForm extends ActionForm{
    String     id = "";    //员工编号
    String     name;        //姓名
    String     sex;         //性别
    String     training;    //员工培训
    String     rating;      //员工考核
    String     command;     //操作名称.add,update,delete,query,statistic
    String     condition;   //查询条件.more,less,equal
    String     option;      //employee,department
    Float      salary;      //工资
    Float      fund;        //公积金

    public String getId(){
        return id;
    }

    public void setId(String param){
        id = param;
    }

    public String getName(){
        return name;
    }

    public void setName(String param){
        name = param;
    }

    public String getSex(){
        return sex;
    }

    public void setSex(String param){
        sex = param;
    }

    public String getTraining(){
        return training;
    }

    public void setTraining(String param){
        training = param;
    }

    public String getRating(){
        return rating;
    }

    public void setRating(String param){
        rating = param;
    }

    public Float getSalary(){
        return salary;
    }

    public void setSalary(Float param){
        salary = param;
    }

    public Float getFund(){
        return fund;
    }

    public void setFund(Float param){
        fund = param;
    }

    public String getCommand(){
        return command;
    }

    public void setCommand(String sample){
        this.command = sample;
    }

    public String getCondition(){
        return condition;
    }

    public void setCondition(String sample){
        this.condition = sample;
    }

    public String getOption(){return option;}

    public void setOption(String sample){this.option = sample;}


}
