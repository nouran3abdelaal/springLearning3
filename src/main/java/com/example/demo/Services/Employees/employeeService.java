package com.example.demo.Services.Employees;

import com.example.demo.models.employee;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//@Service
public class employeeService {
    @Setter
    List<employee> employeeList = new ArrayList<>(
            List.of(
                    new employee("1","Ahmed",26, 'M'),
                    new employee("2","Nouran",23, 'F')

            )
    );
    @Autowired
    @Qualifier("List1")
    List<employee> myList1;
    @Autowired
    @Qualifier("List2")
    List<employee> myList2;
    public List<employee> getAllEmployees() {
        System.out.println(myList1);
        System.out.println(myList2);

        return employeeList;
    }

    public void addEmployee(employee employee) {
        employeeList.add(employee);
    }

    public List<employee> editEmployee(employee employee) {
       employeeList= employeeList.stream()
                .map(existingEmployee -> {
                    if (existingEmployee.getId().equals(employee.getId())) {

                        return employee;
                    } else {
                        return existingEmployee;
                    }
                }).collect(Collectors.toList());
        return employeeList;

    }

    public void deleteEmployee(String id) {
        employeeList.removeIf(existingEmployee->existingEmployee.getId().equals(id));
    }
}
