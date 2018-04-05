package com.demo.user;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	public EntityManager em;

	public UserService(EntityManager em) {
		this.em = em;
	}
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}
	public User save(User user){
		return  userRepository.save(user);		
	}
}
