package com.EmpMan.Service;

import java.time.Duration;
import java.time.LocalDate;


import com.EmpMan.Exceptions.Unexpected_hr;
import com.EmpMan.Repository.EmployeeCheckinRepository;
import com.EmpMan.Model.EmployeeCheckin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeCheckinService{
     @Autowired
	private EmployeeCheckinRepository repository;

	public void saveCheckin(EmployeeCheckin checkin) //checkin(obj) came from previous layer : controller
     {
		//Hrs of work employee did as per the feed
		long i=Duration.between(checkin.getCheckinTime(),checkin.getCheckoutTime()).toHours();
		if(i<0)
		{checkin.setTotalHr(0);}
		else checkin.setTotalHr(i);

		//status: A=absent; P=Present; H=halfday
		if((i<4)&&(i>1)) checkin.setStatus('H');
		else if(i<1) checkin.setStatus('A');
		else checkin.setStatus('P');
        LocalDate t=LocalDate.now();
        //You cant fill the Timesheet for Past
        if(checkin.getDate().isBefore(t))
        {throw new Unexpected_hr("Can't fill out the Past!");}
        else {
            //total hours should not be more than 9 hr or less than 0
            if (i > 9) throw new Unexpected_hr("Time Should not be greater than 9 Hr");
            else if (i < 0) throw new Unexpected_hr("filling 0 hrs is not allowed !");
            else repository.save(checkin);    //final submission
        }
	}
}
