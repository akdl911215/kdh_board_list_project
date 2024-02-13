package com.jh.kdh_project.repository;

import com.jh.kdh_project.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    @Query("SELECT d FROM Department d WHERE d.deptName = :deptName")
    Department getFindByDeptName(@Param("deptName") String deptName);
}
