package com.example.demo.Controllers.Employees;

import com.example.apps2.Employees.EmployeeService;
import com.example.apps2.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController()
public class EmployeeController {

    @Autowired
    private EmployeeService service;
    @GetMapping("/AllEmployees")
    List<Employee> getAllEmployees(){
        return service.getAllEmployees();
    }
    @PostMapping("/AddEmployee")
    void addEmployee(@RequestBody Employee Employee){
        service.addEmployee(Employee);
    }
    @PutMapping("/EditEmployee")
    List<Employee> editEmployee(@RequestBody Employee Employee){
       return service.editEmployee(Employee);
    }
    @DeleteMapping("/deleteEmployee/{id}")
    void deleteEmployee(@PathVariable String id){
        service.deleteEmployee(id);
    }


}
