package com.example.demo.domain;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class Employee {

    @CsvBindByName
    private int id;

    @CsvBindByName
    private String name;

    @CsvBindByName
    private String surname;

    @CsvBindByName
    private String job;

    @CsvBindByName
    private String salary;
}
