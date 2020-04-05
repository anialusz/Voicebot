package com.example.demo;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.example.demo.FileReader.parseFile;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CalculatorTest {
    @Test
    void shouldReturnCorrectValuesForJSONFile() throws IOException {
        Calculator calculator = new Calculator();

        assertEquals("Teacher: 6240,30\n" +
                        "Janitor: 26920,90\n" +
                        "Priest: 15240,00\n",
                calculator.sumOfSalariesForAllJobTypes(parseFile("employees.json")));
    }

    @Test
    void shouldReturnCorrectValuesForCSVFile() throws IOException {
        Calculator calculator = new Calculator();

        assertEquals("Teacher: 6240,30\n" +
                        "Janitor: 26920,90\n" +
                        "Priest: 15240,00\n",
                calculator.sumOfSalariesForAllJobTypes(parseFile("employees.csv")));
    }

    @Test
    void shouldReturnNullWhenFileNull() throws IOException {
        Calculator calculator = new Calculator();

        assertNull(calculator.sumOfSalariesForAllJobTypes(parseFile(null)));
    }
}