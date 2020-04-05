package com.example.demo;

import com.example.demo.domain.Employee;
import com.example.demo.domain.EmployeeWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public static List<Employee> parseFile(String filename) throws IOException {
        if (filename == null) {
            return new ArrayList<>();
        }
        if (filename.contains(".json")) {
            System.out.println("Parsing json file");
            return parseJSONFile(filename);
        } else
            System.out.println("Parsing csv file");
        return parseCSVFile(filename);
    }

    private static List<Employee> parseCSVFile(String fileName) throws IOException {
        Path myPath = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(myPath,
                StandardCharsets.UTF_8)) {

            ColumnPositionMappingStrategy<Employee> strategy = new ColumnPositionMappingStrategy<>();
            strategy.setType(Employee.class);
            String[] fields = {"id", "name", "surname", "job", "salary"};
            strategy.setColumnMapping(fields);

            CsvToBean<Employee> csvToBean = new CsvToBeanBuilder<Employee>(br)
                    .withType(Employee.class)
                    .withMappingStrategy(strategy)
                    .build();

            return csvToBean.parse();
        }
    }

    private static List<Employee> parseJSONFile(String fileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        EmployeeWrapper employeesList = objectMapper.readValue(new File(fileName), EmployeeWrapper.class);

        return employeesList.getEmployees();
    }
}