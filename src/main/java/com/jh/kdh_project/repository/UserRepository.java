package com.jh.kdh_project.repository;

import com.jh.kdh_project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
