package ccut.edu.psm.web.structs.actions;

import ccut.edu.psm.dao.IDepartmentDAO;
import ccut.edu.psm.util.PageBean;
import ccut.edu.psm.web.bean.Department;
import ccut.edu.psm.web.service.DepartmentService;
import ccut.edu.psm.web.structs.form.DepartmentForm;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by HIPAA on 20152015/12/24.
 * Time : 11:05
 * ${}
 */

public class DepartmentAction extends Action {
    private static final String CONTENT_TYPE = "text/html; charset=GB2312";


    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {


        DepartmentForm departmentForm = (DepartmentForm) form;

        request.setCharacterEncoding("gb2312");

        HttpSession session = request.getSession();

        String mark = new String();

        String id = departmentForm.getId();

        String name = departmentForm.getName();
            if(name!=null ) name = new String(name.getBytes("iso8859_1"), "gb2312");
            if (name == null) {
            name = "";
        }


        String brief = departmentForm.getBrief();
            if(brief!=null ) brief = new String(brief.getBytes("iso8859_1"), "gb2312");
            if (brief == null) {
            brief = "";
        }


        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();

        String command = departmentForm.getCommand();
        if(command!=null) {
            command = command.trim();
            command = new String(command.getBytes("iso8859_1"), "gb2312");
        }

        System.out.println("要执行的操作是：" + command);

        boolean bool = false;


        Department department = new Department();

        department.setId(id);
        department.setName(name);
        department.setBrief(brief);

        IDepartmentDAO departmentDAO = new DepartmentService().getDepartmentDAO();

        String condition = new String();
        PageBean pageBean = new PageBean();

        //添加信息

        if (command.equals("add")) {

            bool = departmentDAO.saveDepartment(department);

            if (bool) {
                out.println("<script language=javascript>alert('添加成功！')");
             //// TODO: 2015/12/28
                out.close();

            } else {
                out.println("<script language=javascript>alert('错误！添加未成功！')");
            //// TODO: 2015/12/28
                out.close();

            }
        }

        //查询
        if (command.equals("query")) {

            // PageBean pageBean = new PageBean();

            condition = departmentForm.getCondition();
            //if(condition!=null) condition = new String(condition.getBytes("iso8859_1"),"gb2312");
            System.out.println("The query condition is: "+condition);
            if(condition==null) condition="";

            session.setAttribute("condition", condition);


            int pageNum = 5;
            int currPage;
            // String url = "query.jsp";

            if (request.getParameter("pages")==null){
                currPage =0;
            }else{
                currPage = new Integer(request.getParameter("pages")).intValue();
            }

            System.out.println("Here is currPage!");

            pageBean.setPageNum(pageNum);
            pageBean.setCurrPage(currPage);
            pageBean.setCondition(condition);

            ArrayList ls = (ArrayList)departmentDAO.getDepartment(pageBean);
            session.setAttribute("queryResult2", ls);
            mark = "queryPage";

        }




        //更新信息

        if (command.equals("update")) {

            bool = departmentDAO.updateDepartment(department);

            if (bool) {
                out.println("<script language=javascript>alert('修改成功！')");
            //// TODO: 2015/12/28
                out.close();

            } else {
                out.println("<script language=javascript>alert('错误！修改未成功！')");
            //// TODO: 2015/12/28
                out.close();

            }
        }





//删除信息

        if (command.equals("delete")){
            bool = departmentDAO.delDepartment(id);
            if (bool){
                out.println("<script language=javascript>alert('删除成功！')");
                //out.println("window.close()</script>");
                //// TODO: 2015/12/28
                out.close();
            }else{
                out.println("<script language=javascript>alert('错误！删除未成功！')");
                //out.println("window.close()</script>");
                //// TODO: 2015/12/28
                out.close();
            }

                }







        return mapping.findForward(mark);
    }






}
