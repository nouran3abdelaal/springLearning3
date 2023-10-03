package com.example.demo.Controllers.Employees;

import com.example.demo.Services.Employees.employeeService;
import com.example.demo.models.employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController()

//@RestController("/Employee")
public class employeeController {
    @Autowired
    private employeeService service;
    @GetMapping("/AllEmployees")
    List<employee> getAllEmployees(){
        return service.getAllEmployees();
    }
    @PostMapping("/AddEmployee")
    void addEmployee(@RequestBody employee employee){
        service.addEmployee(employee);
    }
    @PutMapping("/EditEmployee")
    List<employee> editEmployee(@RequestBody employee employee){
       return service.editEmployee(employee);
    }
    @DeleteMapping("/deleteEmployee/{id}")
    void deleteEmployee(@PathVariable String id){
        service.deleteEmployee(id);
    }


}
