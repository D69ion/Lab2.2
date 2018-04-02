package com.company.humanResources;

public class Department {
    private String departmentName;
    private Employee[] employees;
    private int size;

    private static final String DEFAULT_DEPARTMENT_NAME = "";
    private static final int DEFAULT_SIZE = 8;

    public Department(String departmentName) {
        this(departmentName, DEFAULT_SIZE);
    }

    public Department(String departmentName, int employeesCount) {
        this(departmentName, new Employee[employeesCount]);
        /*this.size = employeesCount;
        this.departmentName = departmentName;
        this.employees = new Employee[employeesCount];*/
    }

    public Department(String departmentName, Employee[] employees) {
        this.size = employees.length;
        this.departmentName = departmentName;
        this.employees = employees;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public int getSize() {
        return size;
    }

    public Employee[] getEmployees() {
        Employee[] resEmployees = removeNullElements(employees);
        return resEmployees;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void addEmployee(Employee newEmployee) {
        if(newEmployee == null)
            return;
        if (size >= employees.length) {
            Employee[] resEmployees = new Employee[employees.length * 2];
            System.arraycopy(employees, 0, resEmployees, 0, employees.length);
            resEmployees[employees.length] = newEmployee;
            this.employees = resEmployees;
            this.size++;
        } else {
            for (int i = size - 1; i < employees.length; i++) {
                if (employees[i] == null) {
                    employees[i] = newEmployee;
                    this.size++;
                    break;
                }
            }
        }
    }

    public boolean removeEmployee(String name, String surname) {
        int temp = -1;
        for (int i = 0; i < size; i++){
            if (employees[i].getName().equals(name) && employees[i].getSurname().equals(surname)) {
                temp = i;
                break;
            }
        }
        if(temp == -1)
            return false;
        System.arraycopy(employees, temp + 1, employees, temp, size - temp - 1);
        for (int i = size - 1; i > -1; i--){
            if(employees[i] == null)
                continue;
            else {
                employees[i] = null;
                size--;
                break;
            }
        }
        return true;
    }

    public Employee[] getEmployees(String jobTitle) {
        Employee[] resEmployees = new Employee[size];
        for(int i = 0; i < size; i++){
            if(employees[i] != null && employees[i].getJobTitle().equals(jobTitle)){
                resEmployees[i] = employees[i];
            }
        }
        resEmployees = removeNullElements(resEmployees);
        return resEmployees;
    }

    public Employee[] employeesSortedBySalary() {
        Employee[] resEmployees = getEmployees();
        QSort(resEmployees, 0, resEmployees.length - 1);
        return resEmployees;
    }

    private Employee[] removeNullElements(Employee[] employees) {
        int count = 0;
        for (Employee e : employees
                ) {
            if (e == null)
                count++;
        }
        Employee[] resEmployees = new Employee[employees.length - count];
        count = 0;
        for (Employee e : employees
                ) {
            if (e != null) {
                resEmployees[count] = e;
                count++;
            }
        }
        return resEmployees;
    }

    private void QSort(Employee[] employees, int low, int high) {
        int i = low, j = high; //low = 0; high = array.Length-1
        int pivot = employees[low + (high - low) / 2].getSalary();
        while (i <= j) {
            while (employees[i].getSalary() > pivot)
                i++;
            while (employees[j].getSalary() < pivot)
                j--;
            if (i <= j) {
                Swap(employees, i, j);
                i++;
                j--;
            }
        }
        if (low < j)
            QSort(employees, low, j);
        if (i < high)
            QSort(employees, i, high);
    }

    private static void Swap(Employee[] array, int i, int j) {
        Employee temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
