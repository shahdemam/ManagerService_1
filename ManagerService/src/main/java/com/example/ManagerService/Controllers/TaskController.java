package com.example.ManagerService.Controllers;
import com.example.ManagerService.Models.Task;
import com.example.ManagerService.DTOS.TaskManagerDto;
import com.example.ManagerService.Services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/manager/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/create-task/{managerId}")
    public ResponseEntity<Task> createTask(@RequestBody TaskManagerDto dto, @PathVariable int managerId)
    {
        Task task = taskService.createTask(dto, managerId);
        return ResponseEntity.ok(task);
    }

    @GetMapping("/show-tasks/{managerId}")
    public ResponseEntity<List<Task>> getTasksByManager(@PathVariable int managerId) {
        return ResponseEntity.ok(taskService.getTasksByManager(managerId));
    }

    @GetMapping("/filter/{managerId}")
    public ResponseEntity<List<Task>> getTasksByManagerAndStatus(@PathVariable int managerId, @RequestParam String status) {
        return ResponseEntity.ok(taskService.getTasksByManagerAndStatus(managerId, status));
    }

}
