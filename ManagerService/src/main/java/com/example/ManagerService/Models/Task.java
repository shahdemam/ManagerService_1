package com.example.ManagerService.Models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private Date deadline;

    @ManyToOne
    @JoinColumn(name = "employeeId", foreignKey = @ForeignKey(name = "FK_Employee"))
    private User employee;

    @ManyToOne
    @JoinColumn(name = "managerId", foreignKey = @ForeignKey(name = "FK_Manager"))
    private User manager;
}