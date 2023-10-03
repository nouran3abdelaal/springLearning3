package com.example.demo.Services.Employees;

import com.example.demo.models.employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class employeeService {
    List<employee> employeeList = new ArrayList<>(
            List.of(
                    new employee("1","Ahmed",26, 'M'),
                    new employee("2","Nouran",23, 'F')

            )
    );
    public List<employee> getAllEmployees() {

        return employeeList;
    }

    public void addEmployee(employee employee) {
        employeeList.add(employee);
    }

    public void editEmployee(employee employee) {
        employeeList.stream()
                .map(existingEmployee -> {
                    if (existingEmployee.getId().equals(employee.getId())) {
                        return employee;
                    } else {
                        return existingEmployee;
                    }
                });

    }

    public void deleteEmployee(String id) {
        employeeList.removeIf(existingEmployee->existingEmployee.getId().equals(id));
    }
}
