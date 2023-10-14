package com.employee_management_backend_Application.repository;

import com.employee_management_backend_Application.entity.CurrentProject;
import com.employee_management_backend_Application.service.CurrentProjectResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CurrentProjectRepository extends JpaRepository<CurrentProject,Integer> {
    @Query("select currentProject from CurrentProject  currentProject where currentProject.employeeId=: employeeId")
    public Optional<CurrentProject> getCurrentProjectByEmployeeId(Integer employeeId);
}
