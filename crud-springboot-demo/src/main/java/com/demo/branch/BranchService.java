package com.demo.branch;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BranchService {
	@Autowired
	private BranchRepository branchRepository;
	
	public List<Branch> findAll() {
		return (List<Branch>) branchRepository.findAll();
	}
	public Branch save(Branch branch){
		return branchRepository.save(branch);		
	}
}
