package com.jh.kdh_project.repository;

import com.jh.kdh_project.entity.Department;
import com.jh.kdh_project.entity.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TeamRepositoryTests {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    public void insertTeam() {

        String[] departmentArr = {"depart1", "depart2", "depart3"};
        String[] teamArr = {"team1", "team2", "team3"};


        for (int i = 0; i < 3; ++i) {
            Department department = departmentRepository.getFindByDeptName(departmentArr[i]);
            System.out.println("department : " + department);

            Team entity = Team.builder()
                    .teamName(teamArr[i])
                    .department(department)
                    .build();
            System.out.println("entity : " + entity);

            teamRepository.save(entity);
        }
    }
}
