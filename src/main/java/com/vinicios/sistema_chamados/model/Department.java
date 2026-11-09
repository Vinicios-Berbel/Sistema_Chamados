package com.vinicios.sistema_chamados.model;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Departments")
public class Department {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    private String name;
    @OneToMany(mappedBy = "department")
    private List<User> users = new ArrayList<>();

    public Department(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers(){
        return users;
    }

    public void setUsers(List<User> users){
        this.users = users;
    }
}
