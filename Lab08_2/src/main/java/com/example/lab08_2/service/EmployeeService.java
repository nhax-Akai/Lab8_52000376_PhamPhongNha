package com.example.lab08_2.service;

import com.example.lab08_2.model.Employee;
import com.example.lab08_2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public List<Employee> listAll() {
        return repository.findAll();
    }

    public void save(Employee employee) {
        repository.save(employee);
    }

    public Employee get(int id) {
        return repository.findById(id).get();
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void update(Employee employee) {
        Employee existingEmployee = repository.findById(employee.getId()).orElse(null);
        if (existingEmployee != null) {
            existingEmployee.setName(employee.getName());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setOffice(employee.getOffice());
            existingEmployee.setPhone(employee.getPhone());
            repository.save(existingEmployee);
        }
    }

}
