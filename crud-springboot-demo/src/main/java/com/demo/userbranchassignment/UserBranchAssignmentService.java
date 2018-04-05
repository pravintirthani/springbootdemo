package com.demo.userbranchassignment;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBranchAssignmentService {
	
	public EntityManager em;

	public UserBranchAssignmentService(EntityManager em) {
		this.em = em;
	}
	@Autowired
	private UserBranchAssignmentRepository userBranchAssignmentRepository;
	
	public List<UserBranchAssignment> findAll() {
		return (List<UserBranchAssignment>) userBranchAssignmentRepository.findAll();
	}
	public UserBranchAssignment save(UserBranchAssignment userBranchAssignment){
		return userBranchAssignmentRepository.save(userBranchAssignment);		
	}
}
