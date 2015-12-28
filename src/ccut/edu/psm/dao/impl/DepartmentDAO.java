package ccut.edu.psm.dao.impl;

import java.util.ArrayList;

import ccut.edu.psm.dao.IDepartmentDAO;
import ccut.edu.psm.util.PageBean;
import ccut.edu.psm.web.bean.Department;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by HIPAA on 20152015/12/24.
 * Time : 22:56
 * ${}
 */

public class DepartmentDAO extends HibernateDaoSupport
    implements IDepartmentDAO{
    String condition = "";
    int start, end;

    public List getDepartment(PageBean pageBean) {

        int pageNum = pageBean.getPageNum();
        int currPage = pageBean.getCurrPage();
        condition = pageBean.getCondition();
        start = currPage * pageNum;
        end = start + pageNum;

        return getHibernateTemplate().executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session)
                    throws HibernateException, SQLException {
                String sql;
                if(condition.equals("")) {
                    sql="select {e.*} from employee e";
                }else{
                    sql="select {e.*} from employee e where (e.id like '%"+condition+"%' or e.name like '%"+condition+"%'"
                            +"or e.brief like '%"+condition+"%')";
                }

                SQLQuery query = session.createSQLQuery(sql);
                query.addEntity("e", Department.class);

                java.util.List al = (List) query.list();
                PageBean.setRecordNum(al.size());
                return al;

            }
        });


    }

    public boolean saveDepartment(Department department) {

        getHibernateTemplate().save(department);

        return true;
    }

    public boolean updateDepartment(Department department){
        getHibernateTemplate().update(department);
        return true;
    }

    public boolean delDepartment(String id) {

        Department department =
                (Department) getHibernateTemplate().load(Department.class, Integer.valueOf(id));

        getHibernateTemplate().delete(department);

        return true;
    }


}
