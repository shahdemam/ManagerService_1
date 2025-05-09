package com.example.ManagerService.DTOS;

import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TaskManagerDto {
    private String title;
    private String description;
    //private String status;
    private Date deadline;
    private int employeeId;
    private int managerId;

    public TaskManagerDto(String title, String description, String status, Date deadline, int employeeId, int managerId) {
        this.title = title;
        this.description = description;
        //this.status = status;
        this.deadline = deadline;
        this.employeeId = employeeId;
        this.managerId = managerId;
    }



}