package ccut.edu.psm.dao;

import ccut.edu.psm.util.PageBean;
import ccut.edu.psm.web.bean.Department;

import java.util.List;

/**
 * Created by HIPAA on 20152015/12/24.
 * Time : 15:49
 * ${}
 */

public interface IDepartmentDAO {
    public abstract List getDepartment(PageBean pb);

    public boolean saveDepartment(Department department);

    public boolean updateDepartment(Department department);

    public boolean delDepartment(String id);
}
