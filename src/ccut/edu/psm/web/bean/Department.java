package ccut.edu.psm.web.bean;

/**
 * Created by HIPAA on 20152015/12/24.
 * Time : 11:11
 * ${}
 */

public class Department {
    String id = "";
    String name;                     //部门名称
    String brief;                    //部门简介

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }
}
