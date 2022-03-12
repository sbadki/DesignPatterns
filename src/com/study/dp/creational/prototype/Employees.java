package com.study.dp.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class Employees implements Cloneable {

    private List<String> empList;

    public Employees() {
        empList = new ArrayList<>();
    }

    public Employees(List<String> list) {
        this.empList = list;
    }

    public List<String> getEmpList() {
        return empList;
    }

    public void loadData() {
        empList.add("John");
        empList.add("Merry");
        empList.add("Dane");
        empList.add("Adam");
        empList.add("Stacey");
    }

    @Override
    public Object clone() {
        List<String> list = new ArrayList<>();
        for(String emp : this.empList) {
            list.add(emp);
        }
        return new Employees(list);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("employees=").append(empList);
        sb.append('}');
        return sb.toString();
    }
}

class Demo {
    public static void main(String[] args) {
        Employees emp = new Employees();
        emp.loadData();
        System.out.println(emp.getEmpList());

        Employees cloneEmp1 = (Employees) emp.clone();
        List<String> list = cloneEmp1.getEmpList();
        list.add("James");
        System.out.println(list);

        Employees cloneEmp2 = (Employees) emp.clone();
        List<String> list2 = cloneEmp2.getEmpList();
        list2.remove("John");
        System.out.println(list2);
    }
}
