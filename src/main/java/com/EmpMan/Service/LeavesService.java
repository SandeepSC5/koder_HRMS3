package com.EmpMan.Service;

import com.EmpMan.Exceptions.Unexpected_hr;
import com.EmpMan.Model.LeavesModel;
import com.EmpMan.Repository.LeavesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeavesService {

	@Autowired
	private LeavesRepository leavesrepository;
	public void addleaves(LeavesModel leavesmodel) {
		// TODO Auto-generated method stub


        if(leavesmodel.getTotal_days()>3) throw new Unexpected_hr("Take Approval Via Admin Team for Leaves >3 ");
		leavesrepository.save(leavesmodel);
	}


}
