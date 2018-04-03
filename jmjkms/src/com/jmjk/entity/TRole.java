package com.jmjk.entity;
// default package

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TRole entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_ROLE", catalog = "jmjk")
public class TRole implements java.io.Serializable {

	// Fields

	private Integer roleId;
	private Integer communityId;
	private String roleName;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;
	private Set<TRights> TRightses = new HashSet<TRights>(0);
	private Set<TStaff> TStaffs = new HashSet<TStaff>(0);

	// Constructors

	/** default constructor */
	public TRole() {
	}

	/** minimal constructor */
	public TRole(String roleName) {
		this.roleName = roleName;
	}

	/** full constructor */
	public TRole(Integer commId, String roleName, String one, String two,
			String three, String four, String five, Set<TRights> TRightses,
			Set<TStaff> TStaffs) {
		this.communityId = commId;
		this.roleName = roleName;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
		this.TRightses = TRightses;
		this.TStaffs = TStaffs;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ROLE_ID", unique = true, nullable = false)
	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}


	@Column(name = "COMM_ID")
	public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    @Column(name = "ROLE_NAME", nullable = false)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(name = "ONE", length = 1000)
	public String getOne() {
		return this.one;
	}

	public void setOne(String one) {
		this.one = one;
	}

	@Column(name = "TWO", length = 1000)
	public String getTwo() {
		return this.two;
	}

	public void setTwo(String two) {
		this.two = two;
	}

	@Column(name = "THREE", length = 1000)
	public String getThree() {
		return this.three;
	}

	public void setThree(String three) {
		this.three = three;
	}

	@Column(name = "FOUR", length = 1000)
	public String getFour() {
		return this.four;
	}

	public void setFour(String four) {
		this.four = four;
	}

	@Column(name = "FIVE", length = 1000)
	public String getFive() {
		return this.five;
	}

	public void setFive(String five) {
		this.five = five;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TRole")
	public Set<TRights> getTRightses() {
		return this.TRightses;
	}

	public void setTRightses(Set<TRights> TRightses) {
		this.TRightses = TRightses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TRole")
	public Set<TStaff> getTStaffs() {
		return this.TStaffs;
	}

	public void setTStaffs(Set<TStaff> TStaffs) {
		this.TStaffs = TStaffs;
	}

}