package ccut.edu.psm.web.service;

import ccut.edu.psm.dao.IDepartmentDAO;

/**
 * Created by HIPAA on 20152015/12/24.
 * Time : 15:37
 * ${}
 */

public class DepartmentService {
    private static final double department_MINIMUM = 100.0;

    private IDepartmentDAO departmentDAO;

    public IDepartmentDAO getDepartmentDAO() {
        return departmentDAO;
    }

    public void setDepartmentDAO(IDepartmentDAO departmentDAO) {
        this.departmentDAO = departmentDAO;
    }



}
