package com.demo.company;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.demo.branch.Branch;
import com.demo.product.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "COMPANY")
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
//	@GeneratedValue( strategy=GenerationType.AUTO )
	@SequenceGenerator(name = "COL_GEN", sequenceName = "COMPANY_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COL_GEN")
	@Column(name="ID")
	private Long id;
	
	@NotNull
	@Size(min=3, message="Name should have atleast 3 characters")
	@Column(name="NAME")
	private String name;
	
	@OneToMany(mappedBy="company",cascade=CascadeType.ALL)
	@JsonBackReference(value="_branch")
	private List<Branch> branch;
	
	@OneToMany(mappedBy="company",cascade=CascadeType.ALL)
	@JsonBackReference(value="_product")
	private List<Product> product;
	
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
	public List<Branch> getBranch() {
		return branch;
	}
	public void setBranch(List<Branch> branch) {
		this.branch = branch;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}	
	
}
