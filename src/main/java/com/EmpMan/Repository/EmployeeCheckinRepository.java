package com.EmpMan.Repository;

import com.EmpMan.Model.EmployeeCheckin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface EmployeeCheckinRepository extends JpaRepository<EmployeeCheckin, Long>{
    boolean existsByEmployeeidAndDate(Long employeeid, LocalDate date);
}
