package com.example.ManagerService.Repositories;

import com.example.ManagerService.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
}


