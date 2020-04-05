package com.example.demo;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.example.demo.FileReader.parseFile;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FileReaderTest {

    @Test
    void shouldReturnEmptyArrayWhenGivenNull() throws IOException {
        assertEquals(0, parseFile(null).size());
    }

    @Test
    void shouldReturnCorrectValuesFromJSONFIle() throws IOException {
        String valueToReturn = "[Employee(id=1, name=Mark, surname=Green, job=Teacher, salary=3540,20), " +
                "Employee(id=2, name=Oscar, surname=Mustache, job=Janitor, salary=13460.45), " +
                "Employee(id=3, name=Adalbert, surname=Kidney, job=Priest, salary=15240.00), " +
                "Employee(id=4, name=Christopher, surname=Głuś, job=Teacher, salary=2700,10), " +
                "Employee(id=5, name=Michael, surname=Spear, job=Janitor, salary=13460,45)]";
        assertEquals(valueToReturn, parseFile("employees.json").toString());
    }

    @Test
    void shouldReturnCorrectValuesFromCSVFIle() throws IOException {
        String valueToReturn = "[Employee(id=1, name=Mark, surname=Green, job=Teacher, salary=3540,20), " +
                "Employee(id=2, name=Oscar, surname=Mustache, job=Janitor, salary=13460.45), " +
                "Employee(id=3, name=Adalbert, surname=Kidney, job=Priest, salary=15240.00), " +
                "Employee(id=4, name=Christopher, surname=Głuś, job=Teacher, salary=2700,10), " +
                "Employee(id=5, name=Michael, surname=Spear, job=Janitor, salary=13460,45)]";
        assertEquals(valueToReturn, parseFile("employees.csv").toString());
    }
}