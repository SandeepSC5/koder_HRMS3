package com.EmpMan.Repository;

import java.time.LocalDate;
import java.util.List;

import com.EmpMan.Model.EmployeeSummary;
import com.EmpMan.Model.EmployeeCheckin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepo extends JpaRepository<EmployeeCheckin, Long> {
@Query("SELECT e.name AS name, e.employeeid AS employeeid, e.totalHr AS totalHr " +
        "FROM EmployeeCheckin e " +
        "WHERE e.date BETWEEN :startDate AND :endDate")
List<EmployeeSummary> findByDateBetween(LocalDate startDate, LocalDate endDate);
}
