package com.example.demo;

import com.example.demo.domain.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    public String sumOfSalariesForAllJobTypes(List<Employee> listOfEmployees) {
        if (listOfEmployees == null || listOfEmployees.size() == 0) {
            return null;
        }
        List<String> listOfJobsTypes = listOfEmployees.stream()
                .map(Employee::getJob)
                .distinct()
                .collect(Collectors.toList());
        StringBuilder returnedVal = new StringBuilder();

        for (String jobType : listOfJobsTypes) {
            returnedVal
                    .append(jobType).append(": ")
                    .append(String.format("%.2f", getSalaryForJobType(jobType, listOfEmployees)))
                    .append("\n");
        }
        return returnedVal.toString();
    }

    private double getSalaryForJobType(String job, List<Employee> employeesList) {
        return employeesList.stream()
                .filter(employee -> employee.getJob().equals(job))
                .mapToDouble(employee -> Double.parseDouble(employee.getSalary().replace(",", ".")))
                .sum();
    }
}
