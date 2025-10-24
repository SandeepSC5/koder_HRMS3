package com.EmpMan.Controller;

import com.EmpMan.Model.EmployeeCheckin;
import com.EmpMan.Service.EmployeeCheckinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class EmployeeCheckinController {

    @Autowired
    private EmployeeCheckinService service; //to reach out to Service layer created an object

    @PostMapping("/checkin")
    public String handleCheckin(@ModelAttribute EmployeeCheckin checkin) { //model EmployeeCheckin is storing object value to pass in Service)
        service.saveCheckin(checkin);
        return "redirect:/"; // or return a success page
    }
}
