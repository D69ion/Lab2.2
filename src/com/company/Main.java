package com.company;

public class Main {
    public static void main(String[] args) {
	TestClass testClass = new TestClass();
	boolean test = testClass.testEmployee();
	System.out.println("Employee constructors: " + test);
	test = testClass.testDepartmentConstructors();
	System.out.println("Department constructors: " + test);
	test = testClass.testOrganizationConstructors();
	System.out.println("Organization constructors: " + test);
	test = testClass.testDepartment();
	System.out.println("Department methods: " + test);
	test =testClass.testOrganization();
	System.out.println("Organization methods: " + test);
    }
}
