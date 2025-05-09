package com.example.ManagerService.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ManagerService.Models.Task;

import java.util.List;




public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByManagerId(int managerId);
    List<Task> findByManagerIdAndStatus(int managerId, String status);

}
