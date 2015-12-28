package ccut.edu.psm.dao;

import ccut.edu.psm.util.PageBean;
import ccut.edu.psm.web.bean.Employee;

import java.util.List;

/**
 * Created by HIPAA on 20152015/12/24.
 * Time : 15:51
 * ${}
 */

public interface IEmployeeDAO {
    public abstract List getEmployee(PageBean pb);

    public abstract boolean saveEmployee(final Employee employee);

    public abstract boolean updateEmployee(final Employee employee);

    public abstract boolean delEmployee(final String id);
}
