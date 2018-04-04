package com.company.humanResources;

public class Organization {
    private String organizationName;
    private Department[] departments;
    private int size;

    private static final String DEFAULT_ORGANIZATION_NAME = "";
    private static final int DEFAULT_SIZE = 0;

    public Organization(String organizationName){
        this(organizationName, new Department[DEFAULT_SIZE]);
        /*this.organizationName = organizationName;
        this.size = DEFAULT_SIZE;
        departments = new Department[DEFAULT_SIZE];*/
    }

    public Organization(String organizationName, Department[] departments){
        this.organizationName = organizationName;
        this.departments = departments;
        this.size = departments.length;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public Department[] getDepartments() {
        return departments;
    }

    public void setDepartments(Department[] departments) {
        this.departments = departments;
    }

    public int getSize(){
        return this.size;
    }

    public void setSize(int size){
        this.size = size;
    }

    public int getEmployeesCount(){
        int res = 0;
        for (Department d: departments
             ) {
            res += d.getSize();
        }
        return res;
    }

    public int getEmployees(String jobTitle){
        int res = 0;
        for (Department d: departments
                ) {
            for (Employee e: d.getEmployees()
                 ) {
                if(e.getJobTitle().equals(jobTitle))
                    res++;
            }
        }
        return res;
    }

    public void addDepartment(Department newDepartment){
        if (size >= departments.length){
            Department[] resDepartments = new Department[departments.length * 2];
            System.arraycopy(departments, 0, resDepartments, 0, departments.length);
            resDepartments[departments.length] = newDepartment;
            this.departments = resDepartments;
            this.size++;
        }
        else{
            for (int i = size - 1; i < departments.length; i++){
                if (departments[i] == null){
                    departments[i] = newDepartment;
                    this.size++;
                    break;
                }
            }
        }
    }

    public void removeDepartment(String departmentName){
        int tempi = 0;
        for (int i = 0; i < size; i++){
            if (departments[i].getDepartmentName().equals(departmentName))
                    tempi = i;
        }
        System.arraycopy(departments, tempi + 1, departments, tempi, size - tempi - 1);
        for (int i = size - 1; i > -1; i--){
            if(departments[i] == null)
                continue;
            else {
                departments[i] = null;
                size--;
                break;
            }
        }
    }

    public Department searchDepartment(String departmentName){
        for (Department d: departments
                ) {
            if(d.getDepartmentName().equals(departmentName))
                return d;
        }
        return null;
    }

    public Employee employeesMaxSalary(){
        int max = 0;
        Employee employee = null;
        for (Department d: departments
             ) {
            if (d == null)
                continue;
            for (Employee e: d.getEmployees()
                 ) {
                if(e.getSalary() > max) {
                    max = e.getSalary();
                    employee = e;
                }
            }
        }
        return employee;
    }

    public Department getEmployeesDepartment(String name, String surname){
        for (Department d: departments
                ) {
            for (Employee e: d.getEmployees()
                    ) {
                if (e.getName().equals(name))
                    if (e.getSurname().equals(surname))
                        return d;
            }
        }
        return null;
    }
    
        public int getEmployeesTaxes(){
        int res = 0;
        Employee[] employees = null;
        for(int i = 0; i < size; i++){
            if(departments[i].getSize() == 0)
                continue;
            employees = departments[i].getEmployees();
            for(int j = 0; j < employees.length; j++){
                res += employees[j].getSalary();
            }
        }
        return (int)(res * 0.13);
    }
}
