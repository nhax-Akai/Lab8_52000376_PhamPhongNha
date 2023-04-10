package com.example.lab08_2.model;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@Setter @Getter
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String office;
    private String phone;

    public Employee(int id, String name, String email, String office, String phone)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.office = office;
        this.phone = phone;
    }
}
