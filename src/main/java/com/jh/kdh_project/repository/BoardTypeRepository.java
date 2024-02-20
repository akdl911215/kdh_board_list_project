package com.jh.kdh_project.repository;

import com.jh.kdh_project.entity.BoardTypeList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardTypeRepository extends JpaRepository<BoardTypeList, Integer> {
}
