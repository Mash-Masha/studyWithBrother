package com.study.task3pageobject;

public class EmployeeInfo extends Employee{
    private int age;
    private int salary;
    private String startDate;

    public int getAge() {return age;}

    public void setAge(int age) {this.age=age;}

    public int getSalary() {return salary; }

    public void setSalary(int salary) {this.salary=salary;}

    public String getStartDate() {return startDate;}

    public void setStartDate(String startDate) {this.startDate=startDate;}

    public EmployeeInfo(String name, String possition, String office, int age, int salary, String startDate) {
        super(name,possition,office);
        this.age=age;
        this.salary=salary;
        this.startDate=startDate;
    }

}
