package com.demo.user;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.demo.userbranchassignment.UserBranchAssignment;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "COMPANY_USER")
public class User  implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "COL_GEN", sequenceName = "COMPANY_USER_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COL_GEN")
	@Column(name="ID")
	private Long id;
	
	@Column(name="NAME")
	private String name;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	@JsonBackReference(value="_userBranchAssignment")
	private List<UserBranchAssignment> userBranchAssignment;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<UserBranchAssignment> getUserBranchAssignment() {
		return userBranchAssignment;
	}
	public void setUserBranchAssignment(List<UserBranchAssignment> userBranchAssignment) {
		this.userBranchAssignment = userBranchAssignment;
	}	
	
}
