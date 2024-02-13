package com.jh.kdh_project.repository;

import com.jh.kdh_project.entity.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class DepartmentRepositoryTests {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    public void readDepartment() {
        String deptName = "depart1";

        Department department = departmentRepository.getFindByDeptName(deptName);
        System.out.println(department);
    }

    @Test
    public void insertDepartment() {

        String[] department = {"depart1", "depart2", "depart3"};

        for (int i = 0; i < 3; ++i) {
            Department entity = Department.builder()
                    .deptName(department[i])
                    .build();

            departmentRepository.save(entity);
        }
    }
}
