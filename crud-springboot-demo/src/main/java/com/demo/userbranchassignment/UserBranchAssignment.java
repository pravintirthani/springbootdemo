package com.demo.userbranchassignment;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import com.demo.branch.Branch;
import com.demo.user.User;

@Entity
@Table(name = "USER_BRANCH_ASSIGNMENT")
public class UserBranchAssignment  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "COL_GEN", sequenceName = "USER_BRANCH_ASSIGNMENT_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COL_GEN")
	@Column(name = "ID")
	private long id;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	@ManyToOne
	@JoinColumn(name = "BRANCH_ID")
	private Branch branch;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

}
