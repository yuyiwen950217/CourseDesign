package ccut.edu.psm.web.service;

import ccut.edu.psm.dao.IDepartmentDAO;

/**
 * Created by HIPAA on 20152015/12/24.
 * Time : 15:35
 * ${}
 */

public interface IDepartmentService {
    public abstract void setDepartmentDAO(IDepartmentDAO departmentDAO);

    public abstract IDepartmentDAO getDepartmentDAO();

}
