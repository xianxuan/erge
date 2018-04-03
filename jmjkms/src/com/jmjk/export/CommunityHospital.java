package com.jmjk.export;

/**
 * 提供甲方接口,社区医院实体需要输出的字段
 * @author 李利聪
 *
 */
public class CommunityHospital {
		private Integer communityHospitalId;
		private String hospitalCode;
		private String hospitalLevel;
		private String communityHospital;
		private String address;
		private String longitude;
		private String latitude;
		private String name;
		private String login;
		private String phone;
	
		private String note;
		public CommunityHospital(){}
		public CommunityHospital(Integer communityHospitalId,
				String hospitalCode, String hospitalLevel,
				String communityHospital, String address, String longitude,
				String latitude, String name, String login, String phone,
				 String note) {
			super();
			this.communityHospitalId = communityHospitalId;
			this.hospitalCode = hospitalCode;
			this.hospitalLevel = hospitalLevel;
			this.communityHospital = communityHospital;
			this.address = address;
			this.longitude = longitude;
			this.latitude = latitude;
			this.name = name;
			this.login = login;
			this.phone = phone;
			
			this.note = note;
		}
		public Integer getCommunityHospitalId() {
			return communityHospitalId;
		}
		public void setCommunityHospitalId(Integer communityHospitalId) {
			this.communityHospitalId = communityHospitalId;
		}
		public String getHospitalCode() {
			return hospitalCode;
		}
		public void setHospitalCode(String hospitalCode) {
			this.hospitalCode = hospitalCode;
		}
		public String getHospitalLevel() {
			return hospitalLevel;
		}
		public void setHospitalLevel(String hospitalLevel) {
			this.hospitalLevel = hospitalLevel;
		}
		public String getCommunityHospital() {
			return communityHospital;
		}
		public void setCommunityHospital(String communityHospital) {
			this.communityHospital = communityHospital;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getLongitude() {
			return longitude;
		}
		public void setLongitude(String longitude) {
			this.longitude = longitude;
		}
		public String getLatitude() {
			return latitude;
		}
		public void setLatitude(String latitude) {
			this.latitude = latitude;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getLogin() {
			return login;
		}
		public void setLogin(String login) {
			this.login = login;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
	
		public String getNote() {
			return note;
		}
		public void setNote(String note) {
			this.note = note;
		}
		
	
}
