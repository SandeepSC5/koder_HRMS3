package com.EmpMan.Repository;

import com.EmpMan.Model.EmployeeCheckin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmployeeCheckinRepository extends JpaRepository<EmployeeCheckin, Long>{}
