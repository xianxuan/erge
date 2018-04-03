package com.jmjk.export;

import com.jmjk.entity.TStaff;
/**
 * 导出类
 * @author Liufengshuang
 *
 */
public class StaffExport {
	//1员工编号
	public String staffNumber;
	//2员工身份证号
	public String idCardNum;
	//3员工姓名
	public String name;
	//4员工性别
	public String  sex;
	//5状态
	public String state;
	//6电话
	public String phone;
	//7出生日期
	public String birthDate;
	//8毕业院校
	public String graduateSchool;
	//9学历
	public String eduBackground;
	//10专业
	public String professional;
	//11毕业时间
	public String graduateDate;
	//12职务
	public String job;
	//13入职时间
	public String cometoOfficeDate;
	//14聘用类型
	public String hireType;
	//15聘用到期时间
	public String  hireEndDate;
	//16聘用开始时间
	public String hireStratDate;
	//17部门
	public String department;
	//18职业证书类型
	public String certificateType;
	//19职业证书名称
	public String certificateName;
	//20职称等级
	public String jobTitleLevel;
	//21职称证书名称
	public String jobTitleCertificate;
	//22职称证书编号
	public String jobTitleNum;
	public String[] getTitles(){
		String [] titles = {//22g
			"员工编号","身份证号","姓名","性别","状态","电话","出生日期","毕业院校","学历",	
			"专业","毕业时间","职务","入职时间","聘用类型","聘用到期时间","聘用开始时间","部门","职业证书类型","职业证书名称",
			"职称等级","职称证书名称","职称证书编号"
		};
		return titles;
	}

	public StaffExport() {}
	public StaffExport(TStaff staff) {
		super();
		this.staffNumber = staff.getStaffNumber();
		this.idCardNum = staff.getIdCardNum();
		this.name = staff.getName();
		if(staff.getSex() != null){
			if(staff.getSex() == true){
				this.sex = "女";
			}else{
				this.sex = "男";
			}
		}
		if(staff.getState() != null ){
			if(staff.getState().equals("3")){
				this.state = "退休";
			}else if(staff.getState().equals("4")){
				this.state = "实习";
			}else if(staff.getState().equals("5")){
				this.state = "在职";
			}else if(staff.getState().equals("6")){
				this.state = "离职";
			}else{
				this.state = "异常";
			}
		}
		this.phone =staff.getPhone();
		if(staff.getBirthDate() != null){
			this.birthDate = staff.getBirthDate().toString();
		}
		this.graduateSchool = staff.getGraduateSchool();
		this.eduBackground = staff.getEduBackground();
		this.professional = staff.getProfessional();
		if(staff.getGraduateDate() != null){
			this.graduateDate = staff.getGraduateDate().toString();
		}
		this.job = staff.getJob();
		if(staff.getCometoOfficeDate() != null){
			this.cometoOfficeDate = staff.getCometoOfficeDate().toString();
		}
		this.hireType = staff.getHireType();
		if(staff.getHireEndDate() != null){
			this.hireEndDate = staff.getHireEndDate().toString();
		}
		if(staff.getHireStratDate() != null){
			this.hireStratDate = staff.getHireStratDate().toString();
		}
		this.department = staff.getDepartment();
		this.certificateType = staff.getCertificateType();
		this.certificateName = staff.getCertificateName();
		this.jobTitleLevel = staff.getJobTitleLevel();
		this.jobTitleCertificate = staff.getJobTitleCertificate();
		this.jobTitleNum = staff.getJobTitleNum();
	}



	public String getStaffNumber() {
		return staffNumber;
	}



	public void setStaffNumber(String staffNumber) {
		this.staffNumber = staffNumber;
	}



	public String getIdCardNum() {
		return idCardNum;
	}



	public void setIdCardNum(String idCardNum) {
		this.idCardNum = idCardNum;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSex() {
		return sex;
	}



	public void setSex(String sex) {
		this.sex = sex;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getBirthDate() {
		return birthDate;
	}



	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}



	public String getGraduateSchool() {
		return graduateSchool;
	}



	public void setGraduateSchool(String graduateSchool) {
		this.graduateSchool = graduateSchool;
	}



	public String getEduBackground() {
		return eduBackground;
	}



	public void setEduBackground(String eduBackground) {
		this.eduBackground = eduBackground;
	}



	public String getProfessional() {
		return professional;
	}



	public void setProfessional(String professional) {
		this.professional = professional;
	}



	public String getGraduateDate() {
		return graduateDate;
	}



	public void setGraduateDate(String graduateDate) {
		this.graduateDate = graduateDate;
	}



	public String getJob() {
		return job;
	}



	public void setJob(String job) {
		this.job = job;
	}



	public String getCometoOfficeDate() {
		return cometoOfficeDate;
	}



	public void setCometoOfficeDate(String cometoOfficeDate) {
		this.cometoOfficeDate = cometoOfficeDate;
	}



	public String getHireType() {
		return hireType;
	}



	public void setHireType(String hireType) {
		this.hireType = hireType;
	}



	public String getHireEndDate() {
		return hireEndDate;
	}



	public void setHireEndDate(String hireEndDate) {
		this.hireEndDate = hireEndDate;
	}



	public String getHireStratDate() {
		return hireStratDate;
	}



	public void setHireStratDate(String hireStratDate) {
		this.hireStratDate = hireStratDate;
	}



	public String getDepartment() {
		return department;
	}



	public void setDepartment(String department) {
		this.department = department;
	}



	public String getCertificateType() {
		return certificateType;
	}



	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}



	public String getCertificateName() {
		return certificateName;
	}



	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}



	public String getJobTitleLevel() {
		return jobTitleLevel;
	}



	public void setJobTitleLevel(String jobTitleLevel) {
		this.jobTitleLevel = jobTitleLevel;
	}



	public String getJobTitleCertificate() {
		return jobTitleCertificate;
	}



	public void setJobTitleCertificate(String jobTitleCertificate) {
		this.jobTitleCertificate = jobTitleCertificate;
	}



	public String getJobTitleNum() {
		return jobTitleNum;
	}



	public void setJobTitleNum(String jobTitleNum) {
		this.jobTitleNum = jobTitleNum;
	}

	

}
