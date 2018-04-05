package com.demo.branch;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import com.demo.company.Company;
import com.demo.userbranchassignment.UserBranchAssignment;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "COMPANY_BRANCH")
public class Branch   implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "COL_GEN", sequenceName = "COMPANY_BRANCH_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COL_GEN")
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@ManyToOne
	@JoinColumn(name = "COMPANY_ID")
	private Company company;

	@OneToMany(mappedBy = "branch",cascade=CascadeType.ALL)
	@JsonBackReference(value = "_userBranchAssignment")
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<UserBranchAssignment> getUserBranchAssignment() {
		return userBranchAssignment;
	}

	public void setUserBranchAssignment(List<UserBranchAssignment> userBranchAssignment) {
		this.userBranchAssignment = userBranchAssignment;
	}
	
}	
