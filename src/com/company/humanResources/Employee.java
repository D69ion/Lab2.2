package com.company.humanResources;

public class Employee {
    private String name;
    private String surname;
    private String jobTitle;
    private int salary;

    /*private static final String DEFAULT_NAME = null; //""
    private static final String DEFAULT_SURNAME = null; // ""*/
    private static final String DEFAULT_JOBTITLE = ""; //""
    private static final int DEFAULT_SALARY = 0;

    /*public Employee(){//???
        this (DEFAULT_NAME, DEFAULT_SURNAME, DEFAULT_JOBTITLE, DEFAULT_SALARY);
    }*/

    public Employee(String name, String surname) {
        this(name, surname, DEFAULT_JOBTITLE, DEFAULT_SALARY);
    }

    public Employee(String name, String surname, String jobTitle, int salary) {
        this.name = name;
        this.surname = surname;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
