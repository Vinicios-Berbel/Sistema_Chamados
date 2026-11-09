package com.vinicios.sistema_chamados.model;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Tickets")
public class Ticket {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    private String title;
    private String description;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDateTime openingDate;
    private LocalDateTime closingDate;

    public Ticket(String title, String description, User user, Status status, LocalDateTime openingDate){
        this.title = title;
        this.description = description;
        this.user = user;
        this.status = status;
        this.openingDate = openingDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getOpeningDate(){
        return openingDate;
    }

    public void setOpeningDate(LocalDateTime openingDate){
        this.openingDate = openingDate;
    }

    public LocalDateTime getClosingDate(){
        return closingDate;
    }

    public void setClosingDate(LocalDateTime closingdate){
        this.closingDate = closingdate;
    }

}
