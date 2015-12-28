package ccut.edu.psm.util;

/**
 * Created by HIPAA on 20152015/12/25.
 * Time : 9:31
 * ${}
 */

public class PageBean {

    int currPage;
    int pageNum;
    static int recordNum;
    String condition;

    public PageBean() {
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int sample) {
        this.currPage = sample;
    }


    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int sample) {
        this.pageNum = sample;
    }

    public static int getRecordNum() {
        return recordNum;
    }

    public static void setRecordNum(int sample) {
        recordNum = sample;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String sample) {
        this.condition = sample;
    }
}
