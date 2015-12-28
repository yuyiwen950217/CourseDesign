package ccut.edu.psm.web.structs.form;

import org.apache.struts.action.ActionForm;
import org.hibernate.loader.custom.Return;

/**
 * Created by HIPAA on 20152015/12/24.
 * Time : 11:06
 * ${}
 */

public class DepartmentForm extends ActionForm {
    String id = "";     //部门编号
    String name;        //部门名称
    String brief;      //部门简介
    String command;     //操作名称.add,update,delete,query,statistic
    String condition;   //查询条件.more,less,equal
    String option;      //employee,department

    public String getId(){return id;}

    public void setId(String param){id = param;}

    public String getName(){return name;}

    public void setName(String param){name = param;}

    public String getBrief(){return brief;}

    public void setBrief(String param){brief = param;}

    public String getCommand(){return command;}

    public void setCommand(String sample){command = sample;}

    public String getCondition(){return condition;}

    public void getCondition(String sample){condition = sample;}

}
