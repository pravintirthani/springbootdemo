package com.demo.company;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
	
	public EntityManager em;

	public CompanyService(EntityManager em) {
		this.em = em;
	}
	@Autowired
	private CompanyRepository companyRepository;
	
	public List findAll() {
		return (List) companyRepository.findAll();
	}
	
	public Company save(Company company){
		return  companyRepository.save(company);		
	}

	public Optional<Company> findById(long id) {
		// TODO Auto-generated method stub
		System.out.println(id);
		
		Optional<Company> c= companyRepository.findById(id);
		try {
		 System.out.println(c.get());
		} catch(Exception e) {
			e.printStackTrace();
		}
		return c;
	}
}
