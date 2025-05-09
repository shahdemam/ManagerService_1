package com.example.ManagerService.Services;

import com.example.ManagerService.DTOS.TaskManagerDto;
import com.example.ManagerService.Repositories.UserRepository;
import com.example.ManagerService.Repositories.TaskRepository;
import com.example.ManagerService.Models.Task;
import org.springframework.stereotype.Service;
import com.example.ManagerService.Models.User;
import java.util.List;


@Service
public class TaskService {

    private final TaskRepository taskRepo;
    private final UserRepository userRepo;

    public TaskService(TaskRepository taskRepo, UserRepository userRepo) {
        this.taskRepo = taskRepo;
        this.userRepo = userRepo;
    }

    public Task createTask(TaskManagerDto dto, int managerId) {
        User employee = userRepo.findById(dto.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        User manager = userRepo.findById(managerId)
                .orElseThrow(() -> new RuntimeException("Manager not found"));

        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus("pending");
        task.setDeadline(dto.getDeadline());
        task.setEmployee(employee);
        task.setManager(manager);

        return taskRepo.save(task);
    }

    public List<Task> getTasksByManager(int managerId) {
        return taskRepo.findByManagerId(managerId);
    }

    public List<Task> getTasksByManagerAndStatus(int managerId, String status) {
        return taskRepo.findByManagerIdAndStatus(managerId, status.toUpperCase());
    }
}
