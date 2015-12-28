package ccut.edu.psm.web.service;

import ccut.edu.psm.dao.IEmployeeDAO;

/**
 * Created by HIPAA on 20152015/12/24.
 * Time : 15:34
 * ${}
 */

public interface IEmployeeService {
    public abstract void setEmployeeDAO(IEmployeeDAO employeeDAO);

    public abstract IEmployeeDAO getEmployeeDAO();
}
