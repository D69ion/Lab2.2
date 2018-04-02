package com.company;

import com.company.humanResources.*;

public class TestClass {
    public boolean testEmployee(){
        String name = "name", surname = "surname", jobTitle = "jobTitle";
        int salary = 0;
        Employee Employee1 = new Employee(name, surname);
        Employee Employee2 = new Employee(name, surname, jobTitle, salary);
        if (!(Employee1.getName().equals(name) & Employee1.getSurname().equals(surname)
                & Employee1.getJobTitle().equals("") & Employee1.getSalary() == 0)) return false;
        if (!(Employee2.getName().equals(name) & Employee2.getSurname().equals(surname)
                & Employee2.getJobTitle().equals(jobTitle) & Employee2.getSalary() == 0)) return false;
        return true;
    }

    public boolean testDepartmentConstructors(){
        String departmentName = "Department";
        int numberOfEmployees = 10;
        Employee[] employees = new Employee[numberOfEmployees];
        for(int i = 0; i < numberOfEmployees; i++){
            employees[i] = new Employee("name"+i,"surname"+i, "jobTitle"+i, i);
        }
        Department department1 = new Department(departmentName);
        Department department2 = new Department(departmentName, numberOfEmployees);
        Department department3 = new Department(departmentName, employees);
        if (!(department1.getDepartmentName().equals(departmentName) & department1.getSize() == 8)) return false;
        if (!(department2.getDepartmentName().equals(departmentName) & department2.getSize() == 10)) return false;
        if (!(department3.getDepartmentName().equals(departmentName) & department3.getSize() == 10
				& department3.getEmployees().equals(employees))) return false; //переделать срвнение массивов
        return true;
    }

    public boolean testOrganizationConstructors(){
        String organizationName = "organization";
        Department[] departments = new Department[5];
        for (int i = 0; i < 5; i++){
            departments[i] = new Department("departmentName" + i, i);
        }
        Organization organization1 = new Organization(organizationName);
        Organization organization2 = new Organization(organizationName, departments);
        if (!(organization1.getOrganizationName().equals(organizationName) & organization1.getEmployeesCount() == 0)) return false;
        if (!(organization2.getOrganizationName().equals(organizationName) & organization2.getSize() == 5)) return false;
        return true;
    }

    public boolean testDepartment(){
        int numberOfEmployees = 10;
        Employee[] employees = new Employee[numberOfEmployees];
        for(int i = 0; i < numberOfEmployees; i++){
            employees[i] = new Employee("name"+i,"surname"+i, "jobTitle"+i, i);
        }
        Department department = new Department("departmentName", employees);
        department.removeEmployee("name3", "surname3");
        if (!(employees[employees.length - 1] == null)) return false;
        Employee employee = new Employee("name10", "surname10", "jobTitle10", 10);
        department.addEmployee(employee);
        if (!(employees[9].getName().equals("name10") & employees.length == 10)) return false;
        employee = new Employee("name11", "surname11", "jobTitle11", 11);
        department.addEmployee(employee);
        if (!(department.getEmployees()[10].getName().equals("name11") & department.getEmployees().length == 11)) return false;
        Employee[] employees1 = department.getEmployees("jobTitle8");
        if (!(employees1[0].getName().equals("name8"))) return false;
        Employee[] employees2 = department.employeesSortedBySalary();
        if (!(employees2[0].getSalary() == 11)) return false;
        return true;
    }

    public boolean testOrganization(){
        Department[] departments = new Department[10];
        Employee[] employees = new Employee[10];
        for(int j = 0; j < 10; j++) {
            employees[j] = new Employee("name" + j, "surname" + j, "jobTitle" + j, j);
        }
        for (int i = 0; i < 10; i++){
            departments[i] = new Department("department"+i, employees);
        }
        Organization organization = new Organization("organization", departments);
        if (!(organization.getEmployeesCount() == 100 & organization.getSize() == 10)) return false;
        if (!(organization.getEmployees("jobTitle4") == 10)) return false;
        organization.removeDepartment("department4");
        if (organization.getDepartments()[4].getDepartmentName().equals("department4")) return false;
        organization.addDepartment(new Department("department10", employees));
        if (!(organization.getDepartments()[9].getDepartmentName().equals("department10")
                & organization.getDepartments().length == 10)) return false;
        organization.addDepartment( new Department("department11", employees));
        if (!(organization.getDepartments()[10].getDepartmentName().equals("department11")
                & organization.getDepartments().length == 20)) return false;
        if (!(organization.getEmployeesDepartment("name3", "surname3").getDepartmentName().equals("department0"))) return false;
        if (!(organization.searchDepartment("department3").getDepartmentName().equals("department3"))) return false;
        if (!(organization.employeesMaxSalary().getName().equals("name9"))) return false;
        return true;
    }
}
