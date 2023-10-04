package com.example.demo.conf;

import com.example.demo.Services.Employees.employeeService;
import com.example.demo.models.employee;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class EmployeeServiceConf {
    @Value("${employee1.id}")
    private String employee1Id;

    @Value("${employee1.name}")
    private String employee1Name;

    @Value("${employee1.age}")
    private int employee1Age;

    @Value("${employee1.gender}")
    private char employee1Gender;

    @Value("${employee2.id}")
    private String employee2Id;

    @Value("${employee2.name}")
    private String employee2Name;

    @Value("${employee2.age}")
    private int employee2Age;

    @Value("${employee2.gender}")
    private char employee2Gender;
    @Bean
    employeeService getEmployeeService(){
        return new employeeService();
    }

    @Bean(value = "List1")
    List<employee> getEmployeeList1(){

        return List.of(
                new employee(employee1Id,employee1Name,employee1Age, employee1Gender),
                new employee(employee2Id,employee2Name,employee2Age, employee2Gender)

        );
    }
    @Bean(value = "List2")
    List<employee> getEmployeeList2(){
        return List.of(
                new employee("1","Ahmed2",26, 'M'),
                new employee("2","Nouran2",23, 'F')

        );
    }
}
