package ru.kirill.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kirill.dao.EmployeeBuilder;
import ru.kirill.models.Employee;

@Controller
@RequestMapping("/builder")
public class BuilderController {


    @GetMapping("/employee1")
    public String getEmployee1(Model model) {
        model.addAttribute("employee", new Employee());
        return "builder/employee1";
    }

    @PostMapping("/result")
    public String postEmployee(@ModelAttribute("employee") Employee employee) {

        EmployeeBuilder employeeBuilder1 = new EmployeeBuilder();
        employeeBuilder1.setEmployeeId(employee.getEmployeeId())
                .setEmail(employee.getEmail())
                .setFirstName(employee.getFirstName())
                .setLastName(employee.getLastName())
                .buildEmployee();

        return "builder/result";
    }


}
