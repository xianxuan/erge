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
 * TCommunityHospitalGroup entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_COMMUNITY_HOSPITAL_GROUP", catalog = "jmjk")
public class TCommunityHospitalGroup implements java.io.Serializable {

	// Fields


	private Integer GId;                      //集团ID
	private String groupName; 				  //集团名称
	private String groupAddress;              //集团地址
	private String groupLongitude;            //经度
	private String groupLatitude;             //纬度
	private String groupPhone;
	private String groupHostName;
	private String groupLoginname;
	private String groupPassword;
	private String groupStatus;
	private Integer isCopy;//0,代表该集团不是复制过来的;如果是复制的那就存的是复制的那个集团的id
	private Integer groupHosptialCurrentNum; //集团当前医院个数
	private Integer groupHosptialNum;  //集团医院个数上限
	private String groupNote;
	private String groupOne;
	private String groupTwo;
	private String groupThree;
	private String groupFour;
	private String groupFive;
	private Set<TCommunityHospital> TCommunityHospitals = new HashSet<TCommunityHospital>(
			0);

	// Constructors

	/** default constructor */
	public TCommunityHospitalGroup() {
	}

	/** full constructor */
	public TCommunityHospitalGroup(Integer gId, String groupName, String groupAddress, String groupLongitude,
            String groupLatitude, String groupPhone, String groupHostName, String groupLoginname, String groupPassword,
            String groupStatus, Integer isCopy, Integer groupHosptialCurrentNum, Integer groupHosptialNum,
            String groupNote, String groupOne, String groupTwo, String groupThree, String groupFour, String groupFive,
            Set<TCommunityHospital> tCommunityHospitals) {
        super();
        GId = gId;
        this.groupName = groupName;
        this.groupAddress = groupAddress;
        this.groupLongitude = groupLongitude;
        this.groupLatitude = groupLatitude;
        this.groupPhone = groupPhone;
        this.groupHostName = groupHostName;
        this.groupLoginname = groupLoginname;
        this.groupPassword = groupPassword;
        this.groupStatus = groupStatus;
        this.isCopy = isCopy;
        this.groupHosptialCurrentNum = groupHosptialCurrentNum;
        this.groupHosptialNum = groupHosptialNum;
        this.groupNote = groupNote;
        this.groupOne = groupOne;
        this.groupTwo = groupTwo;
        this.groupThree = groupThree;
        this.groupFour = groupFour;
        this.groupFive = groupFive;
        TCommunityHospitals = tCommunityHospitals;
    }

    // Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "G_ID", unique = true, nullable = false)
	public Integer getGId() {
		return this.GId;
	}

	public void setGId(Integer GId) {
		this.GId = GId;
	}

	@Column(name = "GROUP_NAME")
	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Column(name = "GROUP_ADDRESS")
	public String getGroupAddress() {
		return this.groupAddress;
	}

	public void setGroupAddress(String groupAddress) {
		this.groupAddress = groupAddress;
	}

	@Column(name = "GROUP_LONGITUDE")
	public String getGroupLongitude() {
		return this.groupLongitude;
	}

	public void setGroupLongitude(String groupLongitude) {
		this.groupLongitude = groupLongitude;
	}

	@Column(name = "GROUP_LATITUDE")
	public String getGroupLatitude() {
		return this.groupLatitude;
	}

	public void setGroupLatitude(String groupLatitude) {
		this.groupLatitude = groupLatitude;
	}

	@Column(name = "GROUP_PHONE")
	public String getGroupPhone() {
		return this.groupPhone;
	}

	public void setGroupPhone(String groupPhone) {
		this.groupPhone = groupPhone;
	}
	
	@Column(name = "GROUP_HOST_NAME")
    public String getGroupHostName() {
        return groupHostName;
    }

    public void setGroupHostName(String groupHostName) {
        this.groupHostName = groupHostName;
    }

	@Column(name = "GROUP_LOGINNAME")
	public String getGroupLoginname() {
		return this.groupLoginname;
	}

	public void setGroupLoginname(String groupLoginname) {
		this.groupLoginname = groupLoginname;
	}

	@Column(name = "GROUP_PASSWORD")
	public String getGroupPassword() {
		return this.groupPassword;
	}

	public void setGroupPassword(String groupPassword) {
		this.groupPassword = groupPassword;
	}

	@Column(name = "GROUP_STATUS", length = 1)
	public String getGroupStatus() {
		return this.groupStatus;
	}

	public void setGroupStatus(String groupStatus) {
		this.groupStatus = groupStatus;
	}

	@Column(name = "GROUP_HOSPTIAL_CURRENT_NUM")
	public Integer getGroupHosptialCurrentNum() {
		return this.groupHosptialCurrentNum;
	}

	public void setGroupHosptialCurrentNum(Integer groupHosptialCurrentNum) {
		this.groupHosptialCurrentNum = groupHosptialCurrentNum;
	}

	@Column(name = "GROUP_HOSPTIAL_NUM")
	public Integer getGroupHosptialNum() {
		return this.groupHosptialNum;
	}

	public void setGroupHosptialNum(Integer groupHosptialNum) {
		this.groupHosptialNum = groupHosptialNum;
	}

	@Column(name = "GROUP_NOTE", length = 65535)
	public String getGroupNote() {
		return this.groupNote;
	}

	public void setGroupNote(String groupNote) {
		this.groupNote = groupNote;
	}

	@Column(name = "GROUP_ONE")
	public String getGroupOne() {
		return this.groupOne;
	}

	public void setGroupOne(String groupOne) {
		this.groupOne = groupOne;
	}

	@Column(name = "GROUP_TWO")
	public String getGroupTwo() {
		return this.groupTwo;
	}

	public void setGroupTwo(String groupTwo) {
		this.groupTwo = groupTwo;
	}

	@Column(name = "GROUP_THREE")
	public String getGroupThree() {
		return this.groupThree;
	}

	public void setGroupThree(String groupThree) {
		this.groupThree = groupThree;
	}

	@Column(name = "GROUP_FOUR")
	public String getGroupFour() {
		return this.groupFour;
	}

	public void setGroupFour(String groupFour) {
		this.groupFour = groupFour;
	}

	@Column(name = "GROUP_FIVE")
	public String getGroupFive() {
		return this.groupFive;
	}

	public void setGroupFive(String groupFive) {
		this.groupFive = groupFive;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TCommunityHospitalGroup")
	public Set<TCommunityHospital> getTCommunityHospitals() {
		return this.TCommunityHospitals;
	}

	public void setTCommunityHospitals(
			Set<TCommunityHospital> TCommunityHospitals) {
		this.TCommunityHospitals = TCommunityHospitals;
	}
    
	@Column(name = "GROUP_IS_COPY")
	public Integer getIsCopy() {
        return isCopy;
    }

    public void setIsCopy(Integer isCopy) {
        this.isCopy = isCopy;
    }


}