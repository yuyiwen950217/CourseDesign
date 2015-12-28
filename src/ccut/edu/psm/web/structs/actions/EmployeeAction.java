package ccut.edu.psm.web.structs.actions;


import ccut.edu.psm.dao.IEmployeeDAO;
import ccut.edu.psm.dao.impl.EmployeeDAO;
import ccut.edu.psm.util.PageBean;
import ccut.edu.psm.web.bean.Employee;
import ccut.edu.psm.web.service.EmployeeService;
import ccut.edu.psm.web.structs.form.EmployeeForm;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.mock.MockHttpServletRequest;
import org.apache.struts.mock.MockHttpServletResponse;

import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by HIPAA on 20152015/12/24.
 * Time : 11:05
 * ${}
 */

public class EmployeeAction extends Action {
        private static final String CONTENT_TYPE = "text/html;charset = UTF-8";

    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 MockHttpServletRequest request,
                                 MockHttpServletResponse response)throws Exception{

        EmployeeForm employeeForm = (EmployeeForm)form;

            request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        String mark = new String();

        String id = employeeForm.getId();

        String name = employeeForm.getName();
            if(name != null)name = new String(name.getBytes("iso8859_1"),"UTF-8");
            if(name == null){
                name = "";
            }

        String sex = employeeForm.getSex();
            if (sex != null)sex = new String(sex.getBytes("iso8859_1"),"UTF-8");
            if (sex == null){
                sex = "";
            }

        String training = employeeForm.getTraining();
            if (training !=null)training = new String(training.getBytes("iso8859_1"),"UTF-8");
            if (training == null){
                training = "";
            }

        String rating = employeeForm.getRating();
            if (rating != null)training = new String(rating.getBytes("iso8859_1"),"UTF-8");
            if (rating == null){
            rating = "";
        }

        Float salary = employeeForm.getSalary();
            if (salary == null){
                salary = new Float(0);
            }

        Float fund = employeeForm.getFund();
            if (fund == null){
                fund = new Float(0);
            }


        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();

        String command = employeeForm.getCommand();
            if (command != null){
                command = command.trim();
                command = new String(command.getBytes("iso8859_1"),"UTF-8");
            }

        System.out.println("要执行的操作是："+command);
            boolean bool = false;

        Employee employee = new Employee();
            employee.setId(id);
            employee.setName(name);
            employee.setSex(sex);
            employee.setSalary(salary);
            employee.setFund(fund);
            employee.setRating(rating);
            employee.setTraining(training);

        IEmployeeDAO employeeDAO = new EmployeeService().getEmployeeDAO();

        String condition = new String();
        PageBean pageBean = new PageBean();


        //添加信息
        if (command.equals("add")){
            bool = employeeDAO.saveEmployee(employee);
            if (bool){
                out.println("<script language = javascript>alter('添加成功! ')");
                // TODO: 2015/12/28
                out.close();
            }else{
                out.println("<script language = javascript>alter('错误添加未成功！ ')");
                // TODO: 2015/12/28
                out.close();
            }

        }

        //查询
        if (command.equals("query")){
            System.out.println("Here is EmployeeAction");
            condition = employeeForm.getCondition();
                System.out.println("The query condition is:"+condition);
            if (condition == null)
            condition = "";
            session.setAttribute("condition",condition);

            int pageNum = 5;
            int currPage=0;

            pageBean.setPageNum(pageNum);
            pageBean.setCurrPage(currPage);
            pageBean.setCondition(condition);

            ArrayList ls = (ArrayList) new EmployeeDAO().getEmployee(pageBean);

            session.setAttribute("queryResult", ls);

            mark = "queryPage";

        }

        //更新信息
        if (command.equals("update")){
            bool = employeeDAO.updateEmployee(employee);
            if (bool){
                out.println("<script language=javascript>alert('修改成功！')");
                //out.println("window.close()</script>");
                //// TODO: 2015/12/28
                out.close();
            }else{
                out.println("<script language=javascript>alert('错误！修改未成功！')");
                //out.println("window.close()</script>");
                //// TODO: 2015/12/28
                out.close();
            }
        }

        //删除信息
        if (command.equals("delete")){
            bool = employeeDAO.delEmployee(id);
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



