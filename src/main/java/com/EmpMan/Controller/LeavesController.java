package com.EmpMan.Controller;

import com.EmpMan.Model.LeavesModel;
import com.EmpMan.Service.LeavesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LeavesController {
	
	@Autowired
	private LeavesService leavesservice;
	@PostMapping("/leaves")
	public String leavesApply(@ModelAttribute LeavesModel leavesmodel)
	{
		leavesservice.addleaves(leavesmodel);
		return "redirect:/";
	}
}
