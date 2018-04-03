package com.jmjk.pojo;

import java.util.ArrayList;

public class HealthFileSingleCloud {

	public int code;
	public String message;
    public HealthFile item;
	
	
	@Override
	public String toString() {
		return "HealthFileSingleCloud [code=" + code + ", message=" + message + ", item=" + item + "]";
	}


	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public HealthFile getItem() {
		return item;
	}


	public void setItem(HealthFile item) {
		this.item = item;
	}


	public HealthFileSingleCloud() {
		super();
		// TODO Auto-generated constructor stub
	}


	public HealthFileSingleCloud(int code, String message, HealthFile item) {
		super();
		this.code = code;
		this.message = message;
		this.item = item;
	}


	public class HealthFile {

		public int age;
		public String allergyName;
		public String belongSystem;
		public String birthDate;
		public String bloodTypr;
		public String borSisDisease;
		public String childDisease;
		public String country;
		public String createtime;
		public String crowdClass;
		public String currentCity;
		public String currentCommunity;
		public String currentCounty;
		public String currentOffice;
		public String currentProvince;
		public String currentResidentCommittee;
		public String diastolicBloodPressure;
		public String disabilitity;
		public String disabilityName;
		public String drinkWater;
		public String eduLevel;
		public String email;
		public String enterPeople;
		public String exposeName;
		public String exposeNote;
		public String fatherDisease;
		public String fileDate;
		public String fileNum;
		public String filePerson;
		public String five;
		public ArrayList<String> flsList;
		public ArrayList<String> fmrList;
		public String four;
		public ArrayList<String> fphList;
		public String fuelType;
		public String geneticHistory;
		public int healthFileId;
		public String healthFileType;
		public double height;
		public double hipline;
		public String hospital;
		public String iPhone;
		public int id;
		public String idNum;
		public String job;
		public String kitVenFac;
		public String livestockBar;
		public String maritalStatus;
		public String motherDisease;
		public ArrayList<String> mpmList;
		public String name;
		public String nation;
		public String nfc;
		public String one;
		public String otherAddressType;
		public String otherCity;
		public String otherCommunity;
		public String otherCounty;
		public String otherDisease;
		public String otherName;
		public String otherPhone;
		public String otherProvince;
        public String permanentType;
        public String pic;
        public String rhNegative;
        public boolean sex;
		public double systolicBloodPressure;
        public String three;
        public String toilet;
        public String two;
        public double waistline;
        public double weihth;
        public String work;
        public String workUnit;
        
        
        
		@Override
		public String toString() {
			return "HealthFile [age=" + age + ", allergyName=" + allergyName + ", belongSystem=" + belongSystem
					+ ", birthDate=" + birthDate + ", bloodTypr=" + bloodTypr + ", borSisDisease=" + borSisDisease
					+ ", childDisease=" + childDisease + ", country=" + country + ", createtime=" + createtime
					+ ", crowdClass=" + crowdClass + ", currentCity=" + currentCity + ", currentCommunity="
					+ currentCommunity + ", currentCounty=" + currentCounty + ", currentOffice=" + currentOffice
					+ ", currentProvince=" + currentProvince + ", currentResidentCommittee="
					+ currentResidentCommittee + ", diastolicBloodPressure=" + diastolicBloodPressure
					+ ", disabilitity=" + disabilitity + ", disabilityName=" + disabilityName + ", drinkWater="
					+ drinkWater + ", eduLevel=" + eduLevel + ", email=" + email + ", enterPeople=" + enterPeople
					+ ", exposeName=" + exposeName + ", exposeNote=" + exposeNote + ", fatherDisease="
					+ fatherDisease + ", fileDate=" + fileDate + ", fileNum=" + fileNum + ", filePerson="
					+ filePerson + ", five=" + five + ", flsList=" + flsList + ", fmrList=" + fmrList + ", four="
					+ four + ", fphList=" + fphList + ", fuelType=" + fuelType + ", geneticHistory="
					+ geneticHistory + ", healthFileId=" + healthFileId + ", healthFileType=" + healthFileType
					+ ", height=" + height + ", hipline=" + hipline + ", hospital=" + hospital + ", iPhone="
					+ iPhone + ", id=" + id + ", idNum=" + idNum + ", job=" + job + ", kitVenFac=" + kitVenFac
					+ ", livestockBar=" + livestockBar + ", maritalStatus=" + maritalStatus + ", motherDisease="
					+ motherDisease + ", mpmList=" + mpmList + ", name=" + name + ", nation=" + nation + ", nfc="
					+ nfc + ", one=" + one + ", otherAddressType=" + otherAddressType + ", otherCity=" + otherCity
					+ ", otherCommunity=" + otherCommunity + ", otherCounty=" + otherCounty + ", otherDisease="
					+ otherDisease + ", otherName=" + otherName + ", otherPhone=" + otherPhone + ", otherProvince="
					+ otherProvince + ", permanentType=" + permanentType + ", pic=" + pic + ", rhNegative="
					+ rhNegative + ", sex=" + sex + ", systolicBloodPressure=" + systolicBloodPressure + ", three="
					+ three + ", toilet=" + toilet + ", two=" + two + ", waistline=" + waistline + ", weihth="
					+ weihth + ", work=" + work + ", workUnit=" + workUnit + "]";
		}
		public HealthFile() {
			super();
			// TODO Auto-generated constructor stub
		}
		public HealthFile(int age, String allergyName, String belongSystem, String birthDate, String bloodTypr,
				String borSisDisease, String childDisease, String country, String createtime, String crowdClass,
				String currentCity, String currentCommunity, String currentCounty, String currentOffice,
				String currentProvince, String currentResidentCommittee, String diastolicBloodPressure,
				String disabilitity, String disabilityName, String drinkWater, String eduLevel, String email,
				String enterPeople, String exposeName, String exposeNote, String fatherDisease, String fileDate,
				String fileNum, String filePerson, String five, ArrayList<String> flsList,
				ArrayList<String> fmrList, String four, ArrayList<String> fphList, String fuelType,
				String geneticHistory, int healthFileId, String healthFileType, double height, double hipline,
				String hospital, String iPhone, int id, String idNum, String job, String kitVenFac,
				String livestockBar, String maritalStatus, String motherDisease, ArrayList<String> mpmList,
				String name, String nation, String nfc, String one, String otherAddressType, String otherCity,
				String otherCommunity, String otherCounty, String otherDisease, String otherName, String otherPhone,
				String otherProvince, String permanentType, String pic, String rhNegative, boolean sex,
				double systolicBloodPressure, String three, String toilet, String two, double waistline,
				double weihth, String work, String workUnit) {
			super();
			this.age = age;
			this.allergyName = allergyName;
			this.belongSystem = belongSystem;
			this.birthDate = birthDate;
			this.bloodTypr = bloodTypr;
			this.borSisDisease = borSisDisease;
			this.childDisease = childDisease;
			this.country = country;
			this.createtime = createtime;
			this.crowdClass = crowdClass;
			this.currentCity = currentCity;
			this.currentCommunity = currentCommunity;
			this.currentCounty = currentCounty;
			this.currentOffice = currentOffice;
			this.currentProvince = currentProvince;
			this.currentResidentCommittee = currentResidentCommittee;
			this.diastolicBloodPressure = diastolicBloodPressure;
			this.disabilitity = disabilitity;
			this.disabilityName = disabilityName;
			this.drinkWater = drinkWater;
			this.eduLevel = eduLevel;
			this.email = email;
			this.enterPeople = enterPeople;
			this.exposeName = exposeName;
			this.exposeNote = exposeNote;
			this.fatherDisease = fatherDisease;
			this.fileDate = fileDate;
			this.fileNum = fileNum;
			this.filePerson = filePerson;
			this.five = five;
			this.flsList = flsList;
			this.fmrList = fmrList;
			this.four = four;
			this.fphList = fphList;
			this.fuelType = fuelType;
			this.geneticHistory = geneticHistory;
			this.healthFileId = healthFileId;
			this.healthFileType = healthFileType;
			this.height = height;
			this.hipline = hipline;
			this.hospital = hospital;
			this.iPhone = iPhone;
			this.id = id;
			this.idNum = idNum;
			this.job = job;
			this.kitVenFac = kitVenFac;
			this.livestockBar = livestockBar;
			this.maritalStatus = maritalStatus;
			this.motherDisease = motherDisease;
			this.mpmList = mpmList;
			this.name = name;
			this.nation = nation;
			this.nfc = nfc;
			this.one = one;
			this.otherAddressType = otherAddressType;
			this.otherCity = otherCity;
			this.otherCommunity = otherCommunity;
			this.otherCounty = otherCounty;
			this.otherDisease = otherDisease;
			this.otherName = otherName;
			this.otherPhone = otherPhone;
			this.otherProvince = otherProvince;
			this.permanentType = permanentType;
			this.pic = pic;
			this.rhNegative = rhNegative;
			this.sex = sex;
			this.systolicBloodPressure = systolicBloodPressure;
			this.three = three;
			this.toilet = toilet;
			this.two = two;
			this.waistline = waistline;
			this.weihth = weihth;
			this.work = work;
			this.workUnit = workUnit;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getAllergyName() {
			return allergyName;
		}
		public void setAllergyName(String allergyName) {
			this.allergyName = allergyName;
		}
		public String getBelongSystem() {
			return belongSystem;
		}
		public void setBelongSystem(String belongSystem) {
			this.belongSystem = belongSystem;
		}
		public String getBirthDate() {
			return birthDate;
		}
		public void setBirthDate(String birthDate) {
			this.birthDate = birthDate;
		}
		public String getBloodTypr() {
			return bloodTypr;
		}
		public void setBloodTypr(String bloodTypr) {
			this.bloodTypr = bloodTypr;
		}
		public String getBorSisDisease() {
			return borSisDisease;
		}
		public void setBorSisDisease(String borSisDisease) {
			this.borSisDisease = borSisDisease;
		}
		public String getChildDisease() {
			return childDisease;
		}
		public void setChildDisease(String childDisease) {
			this.childDisease = childDisease;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getCreatetime() {
			return createtime;
		}
		public void setCreatetime(String createtime) {
			this.createtime = createtime;
		}
		public String getCrowdClass() {
			return crowdClass;
		}
		public void setCrowdClass(String crowdClass) {
			this.crowdClass = crowdClass;
		}
		public String getCurrentCity() {
			return currentCity;
		}
		public void setCurrentCity(String currentCity) {
			this.currentCity = currentCity;
		}
		public String getCurrentCommunity() {
			return currentCommunity;
		}
		public void setCurrentCommunity(String currentCommunity) {
			this.currentCommunity = currentCommunity;
		}
		public String getCurrentCounty() {
			return currentCounty;
		}
		public void setCurrentCounty(String currentCounty) {
			this.currentCounty = currentCounty;
		}
		public String getCurrentOffice() {
			return currentOffice;
		}
		public void setCurrentOffice(String currentOffice) {
			this.currentOffice = currentOffice;
		}
		public String getCurrentProvince() {
			return currentProvince;
		}
		public void setCurrentProvince(String currentProvince) {
			this.currentProvince = currentProvince;
		}
		public String getCurrentResidentCommittee() {
			return currentResidentCommittee;
		}
		public void setCurrentResidentCommittee(String currentResidentCommittee) {
			this.currentResidentCommittee = currentResidentCommittee;
		}
		public String getDiastolicBloodPressure() {
			return diastolicBloodPressure;
		}
		public void setDiastolicBloodPressure(String diastolicBloodPressure) {
			this.diastolicBloodPressure = diastolicBloodPressure;
		}
		public String getDisabilitity() {
			return disabilitity;
		}
		public void setDisabilitity(String disabilitity) {
			this.disabilitity = disabilitity;
		}
		public String getDisabilityName() {
			return disabilityName;
		}
		public void setDisabilityName(String disabilityName) {
			this.disabilityName = disabilityName;
		}
		public String getDrinkWater() {
			return drinkWater;
		}
		public void setDrinkWater(String drinkWater) {
			this.drinkWater = drinkWater;
		}
		public String getEduLevel() {
			return eduLevel;
		}
		public void setEduLevel(String eduLevel) {
			this.eduLevel = eduLevel;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getEnterPeople() {
			return enterPeople;
		}
		public void setEnterPeople(String enterPeople) {
			this.enterPeople = enterPeople;
		}
		public String getExposeName() {
			return exposeName;
		}
		public void setExposeName(String exposeName) {
			this.exposeName = exposeName;
		}
		public String getExposeNote() {
			return exposeNote;
		}
		public void setExposeNote(String exposeNote) {
			this.exposeNote = exposeNote;
		}
		public String getFatherDisease() {
			return fatherDisease;
		}
		public void setFatherDisease(String fatherDisease) {
			this.fatherDisease = fatherDisease;
		}
		public String getFileDate() {
			return fileDate;
		}
		public void setFileDate(String fileDate) {
			this.fileDate = fileDate;
		}
		public String getFileNum() {
			return fileNum;
		}
		public void setFileNum(String fileNum) {
			this.fileNum = fileNum;
		}
		public String getFilePerson() {
			return filePerson;
		}
		public void setFilePerson(String filePerson) {
			this.filePerson = filePerson;
		}
		public String getFive() {
			return five;
		}
		public void setFive(String five) {
			this.five = five;
		}
		public ArrayList<String> getFlsList() {
			return flsList;
		}
		public void setFlsList(ArrayList<String> flsList) {
			this.flsList = flsList;
		}
		public ArrayList<String> getFmrList() {
			return fmrList;
		}
		public void setFmrList(ArrayList<String> fmrList) {
			this.fmrList = fmrList;
		}
		public String getFour() {
			return four;
		}
		public void setFour(String four) {
			this.four = four;
		}
		public ArrayList<String> getFphList() {
			return fphList;
		}
		public void setFphList(ArrayList<String> fphList) {
			this.fphList = fphList;
		}
		public String getFuelType() {
			return fuelType;
		}
		public void setFuelType(String fuelType) {
			this.fuelType = fuelType;
		}
		public String getGeneticHistory() {
			return geneticHistory;
		}
		public void setGeneticHistory(String geneticHistory) {
			this.geneticHistory = geneticHistory;
		}
		public int getHealthFileId() {
			return healthFileId;
		}
		public void setHealthFileId(int healthFileId) {
			this.healthFileId = healthFileId;
		}
		public String getHealthFileType() {
			return healthFileType;
		}
		public void setHealthFileType(String healthFileType) {
			this.healthFileType = healthFileType;
		}
		public double getHeight() {
			return height;
		}
		public void setHeight(double height) {
			this.height = height;
		}
		public double getHipline() {
			return hipline;
		}
		public void setHipline(double hipline) {
			this.hipline = hipline;
		}
		public String getHospital() {
			return hospital;
		}
		public void setHospital(String hospital) {
			this.hospital = hospital;
		}
		public String getiPhone() {
			return iPhone;
		}
		public void setiPhone(String iPhone) {
			this.iPhone = iPhone;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getIdNum() {
			return idNum;
		}
		public void setIdNum(String idNum) {
			this.idNum = idNum;
		}
		public String getJob() {
			return job;
		}
		public void setJob(String job) {
			this.job = job;
		}
		public String getKitVenFac() {
			return kitVenFac;
		}
		public void setKitVenFac(String kitVenFac) {
			this.kitVenFac = kitVenFac;
		}
		public String getLivestockBar() {
			return livestockBar;
		}
		public void setLivestockBar(String livestockBar) {
			this.livestockBar = livestockBar;
		}
		public String getMaritalStatus() {
			return maritalStatus;
		}
		public void setMaritalStatus(String maritalStatus) {
			this.maritalStatus = maritalStatus;
		}
		public String getMotherDisease() {
			return motherDisease;
		}
		public void setMotherDisease(String motherDisease) {
			this.motherDisease = motherDisease;
		}
		public ArrayList<String> getMpmList() {
			return mpmList;
		}
		public void setMpmList(ArrayList<String> mpmList) {
			this.mpmList = mpmList;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getNation() {
			return nation;
		}
		public void setNation(String nation) {
			this.nation = nation;
		}
		public String getNfc() {
			return nfc;
		}
		public void setNfc(String nfc) {
			this.nfc = nfc;
		}
		public String getOne() {
			return one;
		}
		public void setOne(String one) {
			this.one = one;
		}
		public String getOtherAddressType() {
			return otherAddressType;
		}
		public void setOtherAddressType(String otherAddressType) {
			this.otherAddressType = otherAddressType;
		}
		public String getOtherCity() {
			return otherCity;
		}
		public void setOtherCity(String otherCity) {
			this.otherCity = otherCity;
		}
		public String getOtherCommunity() {
			return otherCommunity;
		}
		public void setOtherCommunity(String otherCommunity) {
			this.otherCommunity = otherCommunity;
		}
		public String getOtherCounty() {
			return otherCounty;
		}
		public void setOtherCounty(String otherCounty) {
			this.otherCounty = otherCounty;
		}
		public String getOtherDisease() {
			return otherDisease;
		}
		public void setOtherDisease(String otherDisease) {
			this.otherDisease = otherDisease;
		}
		public String getOtherName() {
			return otherName;
		}
		public void setOtherName(String otherName) {
			this.otherName = otherName;
		}
		public String getOtherPhone() {
			return otherPhone;
		}
		public void setOtherPhone(String otherPhone) {
			this.otherPhone = otherPhone;
		}
		public String getOtherProvince() {
			return otherProvince;
		}
		public void setOtherProvince(String otherProvince) {
			this.otherProvince = otherProvince;
		}
		public String getPermanentType() {
			return permanentType;
		}
		public void setPermanentType(String permanentType) {
			this.permanentType = permanentType;
		}
		public String getPic() {
			return pic;
		}
		public void setPic(String pic) {
			this.pic = pic;
		}
		public String getRhNegative() {
			return rhNegative;
		}
		public void setRhNegative(String rhNegative) {
			this.rhNegative = rhNegative;
		}
		public double getSystolicBloodPressure() {
			return systolicBloodPressure;
		}
		public void setSystolicBloodPressure(double systolicBloodPressure) {
			this.systolicBloodPressure = systolicBloodPressure;
		}
		public String getThree() {
			return three;
		}
		public void setThree(String three) {
			this.three = three;
		}
		public String getToilet() {
			return toilet;
		}
		public void setToilet(String toilet) {
			this.toilet = toilet;
		}
		public String getTwo() {
			return two;
		}
		public void setTwo(String two) {
			this.two = two;
		}
		public double getWaistline() {
			return waistline;
		}
		public void setWaistline(double waistline) {
			this.waistline = waistline;
		}
		public double getWeihth() {
			return weihth;
		}
		public void setWeihth(double weihth) {
			this.weihth = weihth;
		}
		public String getWork() {
			return work;
		}
		public void setWork(String work) {
			this.work = work;
		}
		public String getWorkUnit() {
			return workUnit;
		}
		public void setWorkUnit(String workUnit) {
			this.workUnit = workUnit;
		}
		
		 public void setSex(boolean sex) {
			    this.sex = sex;
		    }
	      public boolean getSex(){
	        	return sex;
	        }
	}
}
