package com.jh.kdh_project.repository;

import com.jh.kdh_project.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Integer> {
}
