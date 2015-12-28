package ccut.edu.psm.dao.impl;

import ccut.edu.psm.dao.IEmployeeDAO;
import ccut.edu.psm.util.PageBean;
import ccut.edu.psm.web.bean.Employee;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by HIPAA on 20152015/12/24.
 * Time : 22:57
 * ${}
 */

public class EmployeeDAO extends HibernateDaoSupport
        implements IEmployeeDAO{

    String condition = new String();


    //得到员工信息
    @Override
    public List getEmployee(PageBean pb) {

        int pageNum = pb.getPageNum();
        int currPage = pb.getCurrPage();
        condition = pb.getCondition();

        return getHibernateTemplate().executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session)
                    throws HibernateException, SQLException {
                String sql;
                if(condition.equals("")) {
                    sql="select {e.*} from Emploree e";
                } else {
                    sql="select {e.*} from emploree e where (e.id like '%"+condition+"%' or e.name like '%"+condition+"%'" +
                            "or e.sex like '%"+condition+"%' or e.salary like '%"+condition+"%'" +
                            "or e.fund like '%\"+condition+\"%'or e.salary like '%\"+condition+\"%'" +
                            "or e.training like '%\"+condition+\"%'or e.rating like '%\"+condition+\"%')";
                }
                SQLQuery query = session.createSQLQuery(sql);
                query.addEntity("e", Employee.class);
                List al = query.list();
                PageBean.setRecordNum(al.size());
                return al;
            }
        });


    }


    //保存员工信息
    @Override
    public boolean saveEmployee(Employee employee) {

        getHibernateTemplate().save(employee);

        return true;
    }


    //修改员工信息
    @Override
    public boolean updateEmployee(Employee employee) {

        getHibernateTemplate().update(employee);
        return true;
    }


    //删除员工信息
    @Override
    public boolean delEmployee(String id) {

        Employee employee =
                (Employee)getHibernateTemplate().load(Employee.class,Integer.valueOf(id));

        getHibernateTemplate().delete(employee);

        return true;
    }


}
