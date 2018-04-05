package com.demo.branch;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BranchController {
	
	@Autowired
	private BranchService branchService;
	
	@RequestMapping(method=RequestMethod.GET,value="/branch/all")
	public List<Branch> get() {	
		return branchService.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/branch/save")
	public Branch save(@RequestBody Branch branch) {		
		return branchService.save(branch);
	}
}
