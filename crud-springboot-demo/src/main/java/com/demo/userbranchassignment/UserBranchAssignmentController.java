package com.demo.userbranchassignment;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserBranchAssignmentController {
	
	@Autowired
	private UserBranchAssignmentService userBranchAssignmentService;
	
	@RequestMapping(method=RequestMethod.GET,value="/user-branch-assignment/all")
	public List<UserBranchAssignment> get() {	
		return userBranchAssignmentService.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/user-branch-assignment/save")
	public UserBranchAssignment save(@RequestBody UserBranchAssignment userBranchAssignment) {		
		return userBranchAssignmentService.save(userBranchAssignment);
	}
}
