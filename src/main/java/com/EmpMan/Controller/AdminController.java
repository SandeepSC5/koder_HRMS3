package com.EmpMan.Controller;
import java.time.LocalDate;

import java.util.List;

import com.EmpMan.Service.AdminService1;
import com.EmpMan.Model.EmployeeSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
public class AdminController {
    @Autowired
	private AdminService1 adminservice1;

    @GetMapping("/admin1")
    public List<EmployeeSummary> getAlluser(@RequestParam LocalDate startDate,
                                            @RequestParam LocalDate endDate) {
    	System.out.println("Start: " + startDate + ", End: " + endDate);
        return adminservice1.employeedetails(startDate, endDate);}
                /* public interface EmployeeSummary {
                 *String getName();
            String getEmployeeid();
            String getTotalHr();* */
}
