package com.example.lab08_2.controller;

import com.example.lab08_2.model.Employee;
import com.example.lab08_2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    public EmployeeService service;

    @RequestMapping(value = { "/employees", "/home" })
    public String viewHomePage(Model model) {
        List<Employee> listEmployees = service.listAll();
        model.addAttribute("listEmployees", listEmployees);
        return "employees";
    }

    @RequestMapping("/add")
    public String showNewEmployeesPage(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("pageTitle", "Add New Employee");
        return "add";
    }

    @RequestMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String showEditEmployeePage(@PathVariable(name = "id") int id, Model model) {
        Employee employee = service.get(id);
        model.addAttribute("employee", employee);
        model.addAttribute("pageTitle", "Edit Employee (ID: " + id + ")");
        return "add";
    }

    @PostMapping("edit/{id}")
    public String editEmployee(@PathVariable(name = "id") int id, @ModelAttribute("employee") Employee employee) {
        employee.setId(id);
        service.save(employee);
        return "redirect:/employees";
    }

}
