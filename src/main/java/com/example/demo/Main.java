package com.example.demo;

import java.io.IOException;

import static com.example.demo.FileReader.parseFile;

public class Main {

    public static void main(String[] args) throws IOException {

        Calculator calculator = new Calculator();
        System.out.println(calculator.sumOfSalariesForAllJobTypes(parseFile("employees.csv")));
        System.out.println(calculator.sumOfSalariesForAllJobTypes(parseFile("employees.json")));

    }
}
