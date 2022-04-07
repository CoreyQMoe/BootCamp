package com.test.hib.controller;

public class Runs {
    public static void main(String[] args) {
        findUser_HQL objHQL = new findUser_HQL();
//        objHQL.findAllUser();
//        objHQL.getRecordByID();
//        objHQL.getMaxSalary();
//        objHQL.getAllUsers(3);
//        objHQL.getUsersData();
        EmployeeController e = new EmployeeController();
//        e.createEmployeeTable();
//        e.findEmployeeByname();
//        e.findEmployeeById();
//        e.ShowOfficeCodes_AsDepartment();
//        e.populateEmployeeTable();
        e.updateTable();
    }
}
