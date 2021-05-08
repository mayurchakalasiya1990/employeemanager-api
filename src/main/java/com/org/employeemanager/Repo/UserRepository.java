package com.org.employeemanager.Repo;

import com.org.employeemanager.model.Employee;
import com.org.employeemanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    public User findByUsername(String username);
}
