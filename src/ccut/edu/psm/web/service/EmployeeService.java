package ccut.edu.psm.web.service;

import ccut.edu.psm.dao.IEmployeeDAO;

/**
 * Created by HIPAA on 20152015/12/24.
 * Time : 15:37
 * ${}
 */

public class EmployeeService {
    private static final double Employee_MINIMUM = 100.0;

    private IEmployeeDAO employeeDAO;

    public IEmployeeDAO getEmployeeDAO(){
        return employeeDAO;
    }

    public void setEmployeeDAO(IEmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }
}
