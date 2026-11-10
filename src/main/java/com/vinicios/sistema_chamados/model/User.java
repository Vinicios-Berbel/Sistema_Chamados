package com.vinicios.sistema_chamados.model;


import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    private final Long identifier;
    private String name;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    @OneToMany(mappedBy = "user")
    private List<Ticket> tickets = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public User(Builder builder){
        this.id = builder.id;
        this.identifier = builder.identifier;
        this.name = builder.name;
        this.email = builder.email;
        this.password = builder.password;
        this.department = builder.department;
        this.userRole = builder.userRole;
    }

    public static class Builder {
        private UUID id;
        private Long identifier;
        private String name;
        private String email;
        private String password;
        private Department department;
        private UserRole userRole;

        public Builder id(UUID id){
            this.id = id;
            return this;
        }

        public Builder identifier(Long identifier){
            this.identifier = identifier;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder email(String email){
            this.email = email;
            return this;
        }

        public Builder password(String password){
            this.password = password;
            return this;
        }

        public Builder department(Department department){
            this.department = department;
            return this;
        }

        public Builder userRole(UserRole userRole){
            this.userRole = userRole;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }

    public UUID getId(){
        return id;
    }

    public Long getIdentifier() {
        return identifier;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public List<Ticket> getTickets(){
        return tickets;
    }

    public void setTickets(List<Ticket> tickets){
        this.tickets = tickets;
    }

    public Department getDepartment(){
        return department;
    }

    public void setDepartment(Department department){
        this.department = department;
    }

    public UserRole getUserRole(){
        return userRole;
    }

    public void setUserRole(UserRole userRole){
        this.userRole = userRole;
    }
}
