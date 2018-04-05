package com.demo.company;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company,Long> {
	
	Optional<Company> findById(long id);
}
