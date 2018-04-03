package com.jmjk.entity.view;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VChronic entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "V_CHRONIC", catalog = "jmjk")
public class VChronic implements java.io.Serializable {

	// Fields

	private Integer chronicDiseaseId;
	private String name;
	private Integer oldStaffHosId;
	private Integer staffId;
	private Integer communityHospitalId;
	private String fileNum;
	private Integer healthFileId;
	private Integer highBloodPressureId;
	private Integer diabeteId;
	private Integer insanityId;
	private Integer coronaryDiseaseId;
	private Integer hvcdId;
	private Integer tumourId;
	private Integer chronicBronchialDiseaseId;
	private Integer disabilityObstacleId;
	private String fileName;
	private Timestamp fileFileDate;
	private String enterPeople;
	private String filePerson;
	private Boolean sex;
	private String idNum;
	private Timestamp birthDate;
	private Integer age;
	private String workUnit;
	private String IPhone;
	private String pic;
	private String otherName;
	private String otherPhone;
	private String hospital;
	private String permanentType;
	private String nation;
	private String eduLevel;
	private String job;
	private String bloodTypr;
	private String rhNegative;
	private String maritalStatus;
	private String email;
	private String currentProvince;
	private String currentOffice;
	private String currentResidentCommittee;
	private String currentCommunity;
	private String otherAddressType;
	private String otherProvince;
	private String otherCity;
	private String otherCounty;
	private String otherCommunity;
	private String allergyName;
	private String exposeName;
	private String exposeNote;
	private String fatherDisease;
	private String motherDisease;
	private String borSisDisease;
	private String childDisease;
	private String otherDisease;
	private String disabilityName;
	private String geneticHistory;
	private String kitVenFac;
	private String fuelType;
	private String drinkWater;
	private String toilet;
	private String livestockBar;
	private String crowdClass;
	private String healthFileType;
	private String healthFileOne;
	private String healthFileTwo;
	private String healthFileThree;
	private String healthFileFour;
	private String healthFileFive;
	private String currentCity;
	private String currentCounty;
	private String icd;
	private String diseaseName;
	private Timestamp chronicDiseaseFileDate;
	private String chronicDiseaseFileName;
	private Integer status;
	private String chronicDiseaseOne;
	private String chronicDiseaseTwo;
	private String chronicDiseaseThree;
	private String chronicDiseaseFour;
	private String chronicDiseaseFive;
	private String highBloodTypr;
	private String managementClass;
	private Timestamp highBloodInitialDiagnosisTime;
	private String mainSymptoms;
	private String hypertensionComplication;
	private String howLongTakeBlood;
	private String takeMedication;
	private String notTakeReason;
	private Double drugCost;
	private String nonDrugTreatment;
	private String familyWhitHighBlood;
	private Timestamp highBloodFilingDate;
	private String highBloodBookrunner;
	private String highBloodPressureOne;
	private String highBloodPressureTwo;
	private String highBloodPressureThree;
	private String highBloodPressureFour;
	private String highBloodPressureFive;
	private Timestamp diabeteInitialDiagnosisTime;
	private String coOfDia;
	private String typOfDia;
	private Double costPerMonth;
	private String mainSyptm;
	private String diaCompl;
	private String diaHistory;
	private String faMem;
	private Timestamp diabeteFilingDate;
	private String diabeteBookrunner;
	private String diabeteOne;
	private String diabeteTwo;
	private String diabeteThree;
	private String diabeteFour;
	private String diabeteFive;
	private String guardianName;
	private String patientRelation;
	private String guardianAddress;
	private String guardianPhone;
	private String neighborhoodLinkman;
	private String neighborhoodPhone;
	private Timestamp firstAttackTime;
	private String beforeSymptom;
	private String beforeCureOutpatient;
	private String beforeCureHospital;
	private String recentlyDiagnose;
	private String affirmHospital;
	private Timestamp confirmedDate;
	private String recentlyCureEffect;
	private String influence;
	private String locks;
	private Timestamp insanityFormFilingDate;
	private String insanityFormBookrunner;
	private String insanityFormOne;
	private String insanityFormTwo;
	private String insanityFormThree;
	private String insanityFormFour;
	private String insanityFormFive;
	private String coronaryDiseaseType;
	private String coronaryDiseaseFristDiagnose;
	private String coronaryDiseaseCause;
	private String coronaryDiseaseForm;
	private String coronaryDiseaseComplication;
	private String coronaryDiseaseUseDrug;
	private String electrocardiogram;
	private String electroencephalogram;
	private String coronaryDiseaseX;
	private String coronaryDiseaseCt;
	private String coronaryDiseaseCerebralBloodVessel;
	private String coronaryDiseaseRemarks;
	private String ivestingPerson;
	private Timestamp coronaryDiseaseFilingDate;
	private String coronaryDiseaseBookrunner;
	private String coronaryDiseaseOne;
	private String coronaryDiseaseTwo;
	private String coronaryDiseaseThree;
	private String coronaryDiseaseFour;
	private String coronaryDiseaseFive;
	private String hcvdType;
	private String hcvdFristDiagnose;
	private String hcvdForm;
	private String hcvdComplication;
	private String hcvdUseDrug;
	private String hcvdElectrocardiogram;
	private String hcvdElectroencephalogram;
	private String hcvdCause;
	private String hcvdX;
	private String hcvdCt;
	private String hcvdCerebralBloodVessel;
	private String hcvdRemarks;
	private String hcvdInvestigatedPerson;
	private Timestamp hcvdFilingDate;
	private String hcvdBookrunner;
	private String hcvdOne;
	private String hcvdTwo;
	private String hcvdThree;
	private String hcvdFour;
	private String hcvdFive;
	private String diagnosticInformation;
	private Timestamp emergenceDate;
	private Timestamp treatmentDate;
	private Timestamp tumourDiagnosisDate;
	private String tumourDiagnosedHospital;
	private String tumourPathologicalType;
	private String confirmationBasis;
	private String diagnosisPeriod;
	private String outpatientNumber;
	private String inpatientNumber;
	private Timestamp tumourSignatureDate;
	private Timestamp reviewDate;
	private String tumourInvestigatedPerson;
	private String reviewperson;
	private String treatment;
	private String tranferSituation;
	private String onceTreatment;
	private String currentTreatmentSituation;
	private String cancerFamilyHistory;
	private String withdrawalDate;
	private String withdrawalReason;
	private String findWay;
	private String registrationWay;
	private String diagnosisBasis;
	private String cytology;
	private String hyphology;
	private String tumourHistologicalType;
	private String byStage;
	private Timestamp tumourFileDate;
	private String tumourFileName;
	private String tumourOne;
	private String tumourTwo;
	private String tumourThree;
	private String tumourFour;
	private String tumourFive;
	private Timestamp chronicBronchialDiseaseDiagnosisDate;
	private String diagnosedHospital;
	private Integer annualIncidence;
	private String eachTimeTreatment;
	private String mainCausesDisease;
	private String coughDegree;
	private String coughColor;
	private String isAccompaniedWheezing;
	private String routineBloodTest;
	private String XRay;
	private String sputumSmearCulture;
	private String lungFunctionTest;
	private String chronicBronchialDiseaseComplication;
	private String selefBreath;
	private String heartClass;
	private String chronicBronchialDiseaseRemarks;
	private String chronicBronchialDiseaseInvestigatedPerson;
	private Timestamp chronicBronchialDiseaseFileDate;
	private String chronicBronchialDiseaseFileName;
	private String chronicBronchialDiseaseOne;
	private String chronicBronchialDiseaseTwo;
	private String chronicBronchialDiseaseThree;
	private String chronicBronchialDiseaseFour;
	private String chronicBronchialDiseaseFive;
	private String residualVisionGrading;
	private String visionDisabilityReason;
	private String visualImpairment;
	private String gradingOfAuditusDeformity;
	private String theHearingDisabilityReason;
	private String hearingDisorder;
	private Boolean hearingAid;
	private String speechResidualClassification;
	private String speechDisabilityReason;
	private String speechDisorder;
	private String intelligenceResidualClassification;
	private String intellectualDisabilityReason;
	private String dysgnosia;
	private String bodyResidualClassification;
	private String physicalCauses;
	private String mutilation;
	private String bodyResidualClassificatio;
	private String psychiatricClassification;
	private String causesMentalIllness;
	private String psychogeny;
	private String psychiatricDiagnosis;
	private String diagnoseOrganization;
	private Boolean whetheDisability;
	private Boolean whetheGoRecovery;
	private String recoveryOrganization;
	private String noRecoverReason;
	private String remark;
	private Timestamp disabilityObstacleSignatureDate;
	private Timestamp checkDate;
	private Timestamp fileDate;
	private String disabilityObstacleFileName;
	private String respondent;
	private String checker;
	private String disabilityObstacleOne;
	private String disabilityObstacleTwo;
	private String disabilityObstacleThree;
	private String disabilityObstacleFour;
	private String disabilityObstacleFive;
	private Double temperature;
	private Integer breathingRate;
	private Double diastolicPressure;
	private Double systolicPressure;
	private Integer pulseRate;
	private Double height;
	private Double weight;
	private Double bmi;
	private Double waistline;
	private Double hip;
	private Double ratio;
	private String healthAssessment;
	private String selfAssessment;
	private String cognitiveFunction;
	private String emotion;
	private String generalConditionOne;
	private String generalConditionTwo;
	private String generalConditionThree;
	private String generalConditionFour;
	private String generalConditionFive;
	private String exerciseFrequency;
	private String exerciseTime;
	private String allExerciseTime;
	private String lifeStyleExerciseType;
	private String dietaryHabit;
	private String smokingStatus;
	private Double smokingOneday;
	private Integer startsmokingAge;
	private Integer giveupSmokingAge;
	private String drinkingFrequency;
	private Double monthlyDrinking;
	private String abstinence;
	private Integer startDrinkingAge;
	private Boolean recentlyYearDrinking;
	private String lifeStyleDrinkingType;
	private String occupationalDisease;
	private String typeWork;
	private Timestamp year;
	private String dust;
	private String dustFence;
	private String chemicalSubstances;
	private String chSubFence;
	private String radiogen;
	private String radiogenFence;
	private String physicalFactor;
	private String physicalFactorFence;
	private String other;
	private String otherFence;
	private String lifeStyleOne;
	private String lifeStyleTwo;
	private String lifeStyleThree;
	private String lifeStyleFour;
	private String lifeStyleFive;
	private Double fbg;
	private Double glycatedHemoglobin;
	private String hbsag;
	private Double hemoglobin;
	private Double leukocyte;
	private Double platelet;
	private String othersRb;
	private String urineProtein;
	private String urineGlucose;
	private String ketone;
	private String ery;
	private String othersRu;
	private Double mau;
	private Boolean sedOccultBlood;
	private Double serumAlanineAminoAcid;
	private Double serumAspertateAminoAcid;
	private Double albumin;
	private Double tbil;
	private Double dbil;
	private Double cr;
	private Double bun;
	private Double serumPotassiumLevel;
	private Double serumNatriumLevel;
	private Double totalCholesterol;
	private Double ldlC;
	private Double triglyceride;
	private Double hdlC;
	private String papSmear;
	private String ecg;
	private String chestXRay;
	private String BScanUltrasonography;
	private String others;
	private String auxiliaryExaminationOne;
	private String auxiliaryExaminationTwo;
	private String auxiliaryExaminationThree;
	private String auxiliaryExaminationFour;
	private String auxiliaryExaminationFive;
	private String chemotherapyHospital;
	private String radiotherapyHospital;
	private String surgicalHospital;
	private Timestamp operateTime;
	private String operateHospital;
	private String admissionNum;
	private String operateProperty;
	private Timestamp firstTime;
	private Timestamp secondTime;
	private Timestamp thirdTime;
	private Timestamp changeDate;
	private String changeDepartment;
	private String deathAddress;
	private String deathReason;
	private Timestamp deathDate;
	private String TTumourYear;
	private String mounth;
	private Integer lifeId;
	private Integer auxiliaryExaminationId;
	private Integer generalConditionId;
	private Integer GId;

	// Constructors

	/** default constructor */
	public VChronic() {
	}

	/** minimal constructor */
	public VChronic(Integer chronicDiseaseId, String name,
			Integer oldStaffHosId, Integer healthFileId, String fileName,
			String idNum, String IPhone, String diseaseName,
			Timestamp chronicDiseaseFileDate, String chronicDiseaseFileName) {
		this.chronicDiseaseId = chronicDiseaseId;
		this.name = name;
		this.oldStaffHosId = oldStaffHosId;
		this.healthFileId = healthFileId;
		this.fileName = fileName;
		this.idNum = idNum;
		this.IPhone = IPhone;
		this.diseaseName = diseaseName;
		this.chronicDiseaseFileDate = chronicDiseaseFileDate;
		this.chronicDiseaseFileName = chronicDiseaseFileName;
	}

	/** full constructor */
//	public VChronic(Integer chronicDiseaseId, String name,
//			Integer oldStaffHosId, Integer staffId,
//			Integer communityHospitalId, String fileNum, Integer healthFileId,
//			Integer highBloodPressureId, Integer diabeteId, Integer insanityId,
//			Integer coronaryDiseaseId, Integer hvcdId, Integer tumourId,
//			Integer chronicBronchialDiseaseId, Integer disabilityObstacleId,
//			String fileName, Timestamp fileFileDate, String enterPeople,
//			String filePerson, Boolean sex, String idNum, Timestamp birthDate,
//			Integer age, String workUnit, String IPhone, String pic,
//			String otherName, String otherPhone, String hospital,
//			String permanentType, String nation, String eduLevel, String job,
//			String bloodTypr, String rhNegative, String maritalStatus,
//			String email, String currentProvince, String currentOffice,
//			String currentResidentCommittee, String currentCommunity,
//			String otherAddressType, String otherProvince, String otherCity,
//			String otherCounty, String otherCommunity, String allergyName,
//			String exposeName, String exposeNote, String fatherDisease,
//			String motherDisease, String borSisDisease, String childDisease,
//			String otherDisease, String disabilityName, String geneticHistory,
//			String kitVenFac, String fuelType, String drinkWater,
//			String toilet, String livestockBar, String crowdClass,
//			String healthFileType, String healthFileOne, String healthFileTwo,
//			String healthFileThree, String healthFileFour,
//			String healthFileFive, String currentCity, String currentCounty,
//			String icd, String diseaseName, Timestamp chronicDiseaseFileDate,
//			String chronicDiseaseFileName, Integer status,
//			String chronicDiseaseOne, String chronicDiseaseTwo,
//			String chronicDiseaseThree, String chronicDiseaseFour,
//			String chronicDiseaseFive, String highBloodTypr,
//			String managementClass, Timestamp highBloodInitialDiagnosisTime,
//			String mainSymptoms, String hypertensionComplication,
//			String howLongTakeBlood, String takeMedication,
//			String notTakeReason, Double drugCost, String nonDrugTreatment,
//			String familyWhitHighBlood, Timestamp highBloodFilingDate,
//			String highBloodBookrunner, String highBloodPressureOne,
//			String highBloodPressureTwo, String highBloodPressureThree,
//			String highBloodPressureFour, String highBloodPressureFive,
//			Timestamp diabeteInitialDiagnosisTime, String coOfDia,
//			String typOfDia, Double costPerMonth, String mainSyptm,
//			String diaCompl, String diaHistory, String faMem,
//			Timestamp diabeteFilingDate, String diabeteBookrunner,
//			String diabeteOne, String diabeteTwo, String diabeteThree,
//			String diabeteFour, String diabeteFive, String guardianName,
//			String patientRelation, String guardianAddress,
//			String guardianPhone, String neighborhoodLinkman,
//			String neighborhoodPhone, Timestamp firstAttackTime,
//			String beforeSymptom, String beforeCureOutpatient,
//			String beforeCureHospital, String recentlyDiagnose,
//			String affirmHospital, Timestamp confirmedDate,
//			String recentlyCureEffect, String influence, String locks,
//			Timestamp insanityFormFilingDate, String insanityFormBookrunner,
//			String insanityFormOne, String insanityFormTwo,
//			String insanityFormThree, String insanityFormFour,
//			String insanityFormFive, String coronaryDiseaseType,
//			String coronaryDiseaseFristDiagnose, String coronaryDiseaseCause,
//			String coronaryDiseaseForm, String coronaryDiseaseComplication,
//			String coronaryDiseaseUseDrug, String electrocardiogram,
//			String electroencephalogram, String coronaryDiseaseX,
//			String coronaryDiseaseCt,
//			String coronaryDiseaseCerebralBloodVessel,
//			String coronaryDiseaseRemarks, String ivestingPerson,
//			Timestamp coronaryDiseaseFilingDate,
//			String coronaryDiseaseBookrunner, String coronaryDiseaseOne,
//			String coronaryDiseaseTwo, String coronaryDiseaseThree,
//			String coronaryDiseaseFour, String coronaryDiseaseFive,
//			String hcvdType, String hcvdFristDiagnose, String hcvdForm,
//			String hcvdComplication, String hcvdUseDrug,
//			String hcvdElectrocardiogram, String hcvdElectroencephalogram,
//			String hcvdCause, String hcvdX, String hcvdCt,
//			String hcvdCerebralBloodVessel, String hcvdRemarks,
//			String hcvdInvestigatedPerson, Timestamp hcvdFilingDate,
//			String hcvdBookrunner, String hcvdOne, String hcvdTwo,
//			String hcvdThree, String hcvdFour, String hcvdFive,
//			String diagnosticInformation, Timestamp emergenceDate,
//			Timestamp treatmentDate, Timestamp tumourDiagnosisDate,
//			String tumourDiagnosedHospital, String tumourPathologicalType,
//			String confirmationBasis, String diagnosisPeriod,
//			String outpatientNumber, String inpatientNumber,
//			Timestamp tumourSignatureDate, Timestamp reviewDate,
//			String tumourInvestigatedPerson, String reviewperson,
//			String treatment, String tranferSituation, String onceTreatment,
//			String currentTreatmentSituation, String cancerFamilyHistory,
//			String withdrawalDate, String withdrawalReason, String findWay,
//			String registrationWay, String diagnosisBasis, String cytology,
//			String hyphology, String tumourHistologicalType, String byStage,
//			Timestamp tumourFileDate, String tumourFileName, String tumourOne,
//			String tumourTwo, String tumourThree, String tumourFour,
//			String tumourFive, Timestamp chronicBronchialDiseaseDiagnosisDate,
//			String diagnosedHospital, Integer annualIncidence,
//			String eachTimeTreatment, String mainCausesDisease,
//			String coughDegree, String coughColor,
//			String isAccompaniedWheezing, String routineBloodTest, String XRay,
//			String sputumSmearCulture, String lungFunctionTest,
//			String chronicBronchialDiseaseComplication, String selefBreath,
//			String heartClass, String chronicBronchialDiseaseRemarks,
//			String chronicBronchialDiseaseInvestigatedPerson,
//			Timestamp chronicBronchialDiseaseFileDate,
//			String chronicBronchialDiseaseFileName,
//			String chronicBronchialDiseaseOne,
//			String chronicBronchialDiseaseTwo,
//			String chronicBronchialDiseaseThree,
//			String chronicBronchialDiseaseFour,
//			String chronicBronchialDiseaseFive, String residualVisionGrading,
//			String visionDisabilityReason, String visualImpairment,
//			String gradingOfAuditusDeformity,
//			String theHearingDisabilityReason, String hearingDisorder,
//			Boolean hearingAid, String speechResidualClassification,
//			String speechDisabilityReason, String speechDisorder,
//			String intelligenceResidualClassification,
//			String intellectualDisabilityReason, String dysgnosia,
//			String bodyResidualClassification, String physicalCauses,
//			String mutilation, String bodyResidualClassificatio,
//			String psychiatricClassification, String causesMentalIllness,
//			String psychogeny, String psychiatricDiagnosis,
//			String diagnoseOrganization, Boolean whetheDisability,
//			Boolean whetheGoRecovery, String recoveryOrganization,
//			String noRecoverReason, String remark,
//			Timestamp disabilityObstacleSignatureDate, Timestamp checkDate,
//			Timestamp fileDate, String disabilityObstacleFileName,
//			String respondent, String checker, String disabilityObstacleOne,
//			String disabilityObstacleTwo, String disabilityObstacleThree,
//			String disabilityObstacleFour, String disabilityObstacleFive,
//			Double temperature, Integer breathingRate,
//			Double diastolicPressure, Double systolicPressure,
//			Integer pulseRate, Double height, Double weight, Double bmi,
//			Double waistline, Double hip, Double ratio,
//			String healthAssessment, String selfAssessment,
//			String cognitiveFunction, String emotion,
//			String generalConditionOne, String generalConditionTwo,
//			String generalConditionThree, String generalConditionFour,
//			String generalConditionFive, String exerciseFrequency,
//			String exerciseTime, String allExerciseTime,
//			String lifeStyleExerciseType, String dietaryHabit,
//			String smokingStatus, Double smokingOneday,
//			Integer startsmokingAge, Integer giveupSmokingAge,
//			String drinkingFrequency, Double monthlyDrinking,
//			String abstinence, Integer startDrinkingAge,
//			Boolean recentlyYearDrinking, String lifeStyleDrinkingType,
//			String occupationalDisease, String typeWork, Timestamp year,
//			String dust, String dustFence, String chemicalSubstances,
//			String chSubFence, String radiogen, String radiogenFence,
//			String physicalFactor, String physicalFactorFence, String other,
//			String otherFence, String lifeStyleOne, String lifeStyleTwo,
//			String lifeStyleThree, String lifeStyleFour, String lifeStyleFive,
//			Double fbg, Double glycatedHemoglobin, String hbsag,
//			Double hemoglobin, Double leukocyte, Double platelet,
//			String othersRb, String urineProtein, String urineGlucose,
//			String ketone, String ery, String othersRu, Double mau,
//			Boolean sedOccultBlood, Double serumAlanineAminoAcid,
//			Double serumAspertateAminoAcid, Double albumin, Double tbil,
//			Double dbil, Double cr, Double bun, Double serumPotassiumLevel,
//			Double serumNatriumLevel, Double totalCholesterol, Double ldlC,
//			Double triglyceride, Double hdlC, String papSmear, String ecg,
//			String chestXRay, String BScanUltrasonography, String others,
//			String auxiliaryExaminationOne, String auxiliaryExaminationTwo,
//			String auxiliaryExaminationThree, String auxiliaryExaminationFour,
//			String auxiliaryExaminationFive, String chemotherapyHospital,
//			String radiotherapyHospital, String surgicalHospital,
//			Timestamp operateTime, String operateHospital, String admissionNum,
//			String operateProperty, Timestamp firstTime, Timestamp secondTime,
//			Timestamp thirdTime, Timestamp changeDate, String changeDepartment,
//			String deathAddress, String deathReason, Timestamp deathDate,
//			String TTumourYear, String mounth, Integer lifeId,
//			Integer auxiliaryExaminationId, Integer generalConditionId,
//			Integer GId) {
//		this.chronicDiseaseId = chronicDiseaseId;
//		this.name = name;
//		this.oldStaffHosId = oldStaffHosId;
//		this.staffId = staffId;
//		this.communityHospitalId = communityHospitalId;
//		this.fileNum = fileNum;
//		this.healthFileId = healthFileId;
//		this.highBloodPressureId = highBloodPressureId;
//		this.diabeteId = diabeteId;
//		this.insanityId = insanityId;
//		this.coronaryDiseaseId = coronaryDiseaseId;
//		this.hvcdId = hvcdId;
//		this.tumourId = tumourId;
//		this.chronicBronchialDiseaseId = chronicBronchialDiseaseId;
//		this.disabilityObstacleId = disabilityObstacleId;
//		this.fileName = fileName;
//		this.fileFileDate = fileFileDate;
//		this.enterPeople = enterPeople;
//		this.filePerson = filePerson;
//		this.sex = sex;
//		this.idNum = idNum;
//		this.birthDate = birthDate;
//		this.age = age;
//		this.workUnit = workUnit;
//		this.IPhone = IPhone;
//		this.pic = pic;
//		this.otherName = otherName;
//		this.otherPhone = otherPhone;
//		this.hospital = hospital;
//		this.permanentType = permanentType;
//		this.nation = nation;
//		this.eduLevel = eduLevel;
//		this.job = job;
//		this.bloodTypr = bloodTypr;
//		this.rhNegative = rhNegative;
//		this.maritalStatus = maritalStatus;
//		this.email = email;
//		this.currentProvince = currentProvince;
//		this.currentOffice = currentOffice;
//		this.currentResidentCommittee = currentResidentCommittee;
//		this.currentCommunity = currentCommunity;
//		this.otherAddressType = otherAddressType;
//		this.otherProvince = otherProvince;
//		this.otherCity = otherCity;
//		this.otherCounty = otherCounty;
//		this.otherCommunity = otherCommunity;
//		this.allergyName = allergyName;
//		this.exposeName = exposeName;
//		this.exposeNote = exposeNote;
//		this.fatherDisease = fatherDisease;
//		this.motherDisease = motherDisease;
//		this.borSisDisease = borSisDisease;
//		this.childDisease = childDisease;
//		this.otherDisease = otherDisease;
//		this.disabilityName = disabilityName;
//		this.geneticHistory = geneticHistory;
//		this.kitVenFac = kitVenFac;
//		this.fuelType = fuelType;
//		this.drinkWater = drinkWater;
//		this.toilet = toilet;
//		this.livestockBar = livestockBar;
//		this.crowdClass = crowdClass;
//		this.healthFileType = healthFileType;
//		this.healthFileOne = healthFileOne;
//		this.healthFileTwo = healthFileTwo;
//		this.healthFileThree = healthFileThree;
//		this.healthFileFour = healthFileFour;
//		this.healthFileFive = healthFileFive;
//		this.currentCity = currentCity;
//		this.currentCounty = currentCounty;
//		this.icd = icd;
//		this.diseaseName = diseaseName;
//		this.chronicDiseaseFileDate = chronicDiseaseFileDate;
//		this.chronicDiseaseFileName = chronicDiseaseFileName;
//		this.status = status;
//		this.chronicDiseaseOne = chronicDiseaseOne;
//		this.chronicDiseaseTwo = chronicDiseaseTwo;
//		this.chronicDiseaseThree = chronicDiseaseThree;
//		this.chronicDiseaseFour = chronicDiseaseFour;
//		this.chronicDiseaseFive = chronicDiseaseFive;
//		this.highBloodTypr = highBloodTypr;
//		this.managementClass = managementClass;
//		this.highBloodInitialDiagnosisTime = highBloodInitialDiagnosisTime;
//		this.mainSymptoms = mainSymptoms;
//		this.hypertensionComplication = hypertensionComplication;
//		this.howLongTakeBlood = howLongTakeBlood;
//		this.takeMedication = takeMedication;
//		this.notTakeReason = notTakeReason;
//		this.drugCost = drugCost;
//		this.nonDrugTreatment = nonDrugTreatment;
//		this.familyWhitHighBlood = familyWhitHighBlood;
//		this.highBloodFilingDate = highBloodFilingDate;
//		this.highBloodBookrunner = highBloodBookrunner;
//		this.highBloodPressureOne = highBloodPressureOne;
//		this.highBloodPressureTwo = highBloodPressureTwo;
//		this.highBloodPressureThree = highBloodPressureThree;
//		this.highBloodPressureFour = highBloodPressureFour;
//		this.highBloodPressureFive = highBloodPressureFive;
//		this.diabeteInitialDiagnosisTime = diabeteInitialDiagnosisTime;
//		this.coOfDia = coOfDia;
//		this.typOfDia = typOfDia;
//		this.costPerMonth = costPerMonth;
//		this.mainSyptm = mainSyptm;
//		this.diaCompl = diaCompl;
//		this.diaHistory = diaHistory;
//		this.faMem = faMem;
//		this.diabeteFilingDate = diabeteFilingDate;
//		this.diabeteBookrunner = diabeteBookrunner;
//		this.diabeteOne = diabeteOne;
//		this.diabeteTwo = diabeteTwo;
//		this.diabeteThree = diabeteThree;
//		this.diabeteFour = diabeteFour;
//		this.diabeteFive = diabeteFive;
//		this.guardianName = guardianName;
//		this.patientRelation = patientRelation;
//		this.guardianAddress = guardianAddress;
//		this.guardianPhone = guardianPhone;
//		this.neighborhoodLinkman = neighborhoodLinkman;
//		this.neighborhoodPhone = neighborhoodPhone;
//		this.firstAttackTime = firstAttackTime;
//		this.beforeSymptom = beforeSymptom;
//		this.beforeCureOutpatient = beforeCureOutpatient;
//		this.beforeCureHospital = beforeCureHospital;
//		this.recentlyDiagnose = recentlyDiagnose;
//		this.affirmHospital = affirmHospital;
//		this.confirmedDate = confirmedDate;
//		this.recentlyCureEffect = recentlyCureEffect;
//		this.influence = influence;
//		this.locks = locks;
//		this.insanityFormFilingDate = insanityFormFilingDate;
//		this.insanityFormBookrunner = insanityFormBookrunner;
//		this.insanityFormOne = insanityFormOne;
//		this.insanityFormTwo = insanityFormTwo;
//		this.insanityFormThree = insanityFormThree;
//		this.insanityFormFour = insanityFormFour;
//		this.insanityFormFive = insanityFormFive;
//		this.coronaryDiseaseType = coronaryDiseaseType;
//		this.coronaryDiseaseFristDiagnose = coronaryDiseaseFristDiagnose;
//		this.coronaryDiseaseCause = coronaryDiseaseCause;
//		this.coronaryDiseaseForm = coronaryDiseaseForm;
//		this.coronaryDiseaseComplication = coronaryDiseaseComplication;
//		this.coronaryDiseaseUseDrug = coronaryDiseaseUseDrug;
//		this.electrocardiogram = electrocardiogram;
//		this.electroencephalogram = electroencephalogram;
//		this.coronaryDiseaseX = coronaryDiseaseX;
//		this.coronaryDiseaseCt = coronaryDiseaseCt;
//		this.coronaryDiseaseCerebralBloodVessel = coronaryDiseaseCerebralBloodVessel;
//		this.coronaryDiseaseRemarks = coronaryDiseaseRemarks;
//		this.ivestingPerson = ivestingPerson;
//		this.coronaryDiseaseFilingDate = coronaryDiseaseFilingDate;
//		this.coronaryDiseaseBookrunner = coronaryDiseaseBookrunner;
//		this.coronaryDiseaseOne = coronaryDiseaseOne;
//		this.coronaryDiseaseTwo = coronaryDiseaseTwo;
//		this.coronaryDiseaseThree = coronaryDiseaseThree;
//		this.coronaryDiseaseFour = coronaryDiseaseFour;
//		this.coronaryDiseaseFive = coronaryDiseaseFive;
//		this.hcvdType = hcvdType;
//		this.hcvdFristDiagnose = hcvdFristDiagnose;
//		this.hcvdForm = hcvdForm;
//		this.hcvdComplication = hcvdComplication;
//		this.hcvdUseDrug = hcvdUseDrug;
//		this.hcvdElectrocardiogram = hcvdElectrocardiogram;
//		this.hcvdElectroencephalogram = hcvdElectroencephalogram;
//		this.hcvdCause = hcvdCause;
//		this.hcvdX = hcvdX;
//		this.hcvdCt = hcvdCt;
//		this.hcvdCerebralBloodVessel = hcvdCerebralBloodVessel;
//		this.hcvdRemarks = hcvdRemarks;
//		this.hcvdInvestigatedPerson = hcvdInvestigatedPerson;
//		this.hcvdFilingDate = hcvdFilingDate;
//		this.hcvdBookrunner = hcvdBookrunner;
//		this.hcvdOne = hcvdOne;
//		this.hcvdTwo = hcvdTwo;
//		this.hcvdThree = hcvdThree;
//		this.hcvdFour = hcvdFour;
//		this.hcvdFive = hcvdFive;
//		this.diagnosticInformation = diagnosticInformation;
//		this.emergenceDate = emergenceDate;
//		this.treatmentDate = treatmentDate;
//		this.tumourDiagnosisDate = tumourDiagnosisDate;
//		this.tumourDiagnosedHospital = tumourDiagnosedHospital;
//		this.tumourPathologicalType = tumourPathologicalType;
//		this.confirmationBasis = confirmationBasis;
//		this.diagnosisPeriod = diagnosisPeriod;
//		this.outpatientNumber = outpatientNumber;
//		this.inpatientNumber = inpatientNumber;
//		this.tumourSignatureDate = tumourSignatureDate;
//		this.reviewDate = reviewDate;
//		this.tumourInvestigatedPerson = tumourInvestigatedPerson;
//		this.reviewperson = reviewperson;
//		this.treatment = treatment;
//		this.tranferSituation = tranferSituation;
//		this.onceTreatment = onceTreatment;
//		this.currentTreatmentSituation = currentTreatmentSituation;
//		this.cancerFamilyHistory = cancerFamilyHistory;
//		this.withdrawalDate = withdrawalDate;
//		this.withdrawalReason = withdrawalReason;
//		this.findWay = findWay;
//		this.registrationWay = registrationWay;
//		this.diagnosisBasis = diagnosisBasis;
//		this.cytology = cytology;
//		this.hyphology = hyphology;
//		this.tumourHistologicalType = tumourHistologicalType;
//		this.byStage = byStage;
//		this.tumourFileDate = tumourFileDate;
//		this.tumourFileName = tumourFileName;
//		this.tumourOne = tumourOne;
//		this.tumourTwo = tumourTwo;
//		this.tumourThree = tumourThree;
//		this.tumourFour = tumourFour;
//		this.tumourFive = tumourFive;
//		this.chronicBronchialDiseaseDiagnosisDate = chronicBronchialDiseaseDiagnosisDate;
//		this.diagnosedHospital = diagnosedHospital;
//		this.annualIncidence = annualIncidence;
//		this.eachTimeTreatment = eachTimeTreatment;
//		this.mainCausesDisease = mainCausesDisease;
//		this.coughDegree = coughDegree;
//		this.coughColor = coughColor;
//		this.isAccompaniedWheezing = isAccompaniedWheezing;
//		this.routineBloodTest = routineBloodTest;
//		this.XRay = XRay;
//		this.sputumSmearCulture = sputumSmearCulture;
//		this.lungFunctionTest = lungFunctionTest;
//		this.chronicBronchialDiseaseComplication = chronicBronchialDiseaseComplication;
//		this.selefBreath = selefBreath;
//		this.heartClass = heartClass;
//		this.chronicBronchialDiseaseRemarks = chronicBronchialDiseaseRemarks;
//		this.chronicBronchialDiseaseInvestigatedPerson = chronicBronchialDiseaseInvestigatedPerson;
//		this.chronicBronchialDiseaseFileDate = chronicBronchialDiseaseFileDate;
//		this.chronicBronchialDiseaseFileName = chronicBronchialDiseaseFileName;
//		this.chronicBronchialDiseaseOne = chronicBronchialDiseaseOne;
//		this.chronicBronchialDiseaseTwo = chronicBronchialDiseaseTwo;
//		this.chronicBronchialDiseaseThree = chronicBronchialDiseaseThree;
//		this.chronicBronchialDiseaseFour = chronicBronchialDiseaseFour;
//		this.chronicBronchialDiseaseFive = chronicBronchialDiseaseFive;
//		this.residualVisionGrading = residualVisionGrading;
//		this.visionDisabilityReason = visionDisabilityReason;
//		this.visualImpairment = visualImpairment;
//		this.gradingOfAuditusDeformity = gradingOfAuditusDeformity;
//		this.theHearingDisabilityReason = theHearingDisabilityReason;
//		this.hearingDisorder = hearingDisorder;
//		this.hearingAid = hearingAid;
//		this.speechResidualClassification = speechResidualClassification;
//		this.speechDisabilityReason = speechDisabilityReason;
//		this.speechDisorder = speechDisorder;
//		this.intelligenceResidualClassification = intelligenceResidualClassification;
//		this.intellectualDisabilityReason = intellectualDisabilityReason;
//		this.dysgnosia = dysgnosia;
//		this.bodyResidualClassification = bodyResidualClassification;
//		this.physicalCauses = physicalCauses;
//		this.mutilation = mutilation;
//		this.bodyResidualClassificatio = bodyResidualClassificatio;
//		this.psychiatricClassification = psychiatricClassification;
//		this.causesMentalIllness = causesMentalIllness;
//		this.psychogeny = psychogeny;
//		this.psychiatricDiagnosis = psychiatricDiagnosis;
//		this.diagnoseOrganization = diagnoseOrganization;
//		this.whetheDisability = whetheDisability;
//		this.whetheGoRecovery = whetheGoRecovery;
//		this.recoveryOrganization = recoveryOrganization;
//		this.noRecoverReason = noRecoverReason;
//		this.remark = remark;
//		this.disabilityObstacleSignatureDate = disabilityObstacleSignatureDate;
//		this.checkDate = checkDate;
//		this.fileDate = fileDate;
//		this.disabilityObstacleFileName = disabilityObstacleFileName;
//		this.respondent = respondent;
//		this.checker = checker;
//		this.disabilityObstacleOne = disabilityObstacleOne;
//		this.disabilityObstacleTwo = disabilityObstacleTwo;
//		this.disabilityObstacleThree = disabilityObstacleThree;
//		this.disabilityObstacleFour = disabilityObstacleFour;
//		this.disabilityObstacleFive = disabilityObstacleFive;
//		this.temperature = temperature;
//		this.breathingRate = breathingRate;
//		this.diastolicPressure = diastolicPressure;
//		this.systolicPressure = systolicPressure;
//		this.pulseRate = pulseRate;
//		this.height = height;
//		this.weight = weight;
//		this.bmi = bmi;
//		this.waistline = waistline;
//		this.hip = hip;
//		this.ratio = ratio;
//		this.healthAssessment = healthAssessment;
//		this.selfAssessment = selfAssessment;
//		this.cognitiveFunction = cognitiveFunction;
//		this.emotion = emotion;
//		this.generalConditionOne = generalConditionOne;
//		this.generalConditionTwo = generalConditionTwo;
//		this.generalConditionThree = generalConditionThree;
//		this.generalConditionFour = generalConditionFour;
//		this.generalConditionFive = generalConditionFive;
//		this.exerciseFrequency = exerciseFrequency;
//		this.exerciseTime = exerciseTime;
//		this.allExerciseTime = allExerciseTime;
//		this.lifeStyleExerciseType = lifeStyleExerciseType;
//		this.dietaryHabit = dietaryHabit;
//		this.smokingStatus = smokingStatus;
//		this.smokingOneday = smokingOneday;
//		this.startsmokingAge = startsmokingAge;
//		this.giveupSmokingAge = giveupSmokingAge;
//		this.drinkingFrequency = drinkingFrequency;
//		this.monthlyDrinking = monthlyDrinking;
//		this.abstinence = abstinence;
//		this.startDrinkingAge = startDrinkingAge;
//		this.recentlyYearDrinking = recentlyYearDrinking;
//		this.lifeStyleDrinkingType = lifeStyleDrinkingType;
//		this.occupationalDisease = occupationalDisease;
//		this.typeWork = typeWork;
//		this.year = year;
//		this.dust = dust;
//		this.dustFence = dustFence;
//		this.chemicalSubstances = chemicalSubstances;
//		this.chSubFence = chSubFence;
//		this.radiogen = radiogen;
//		this.radiogenFence = radiogenFence;
//		this.physicalFactor = physicalFactor;
//		this.physicalFactorFence = physicalFactorFence;
//		this.other = other;
//		this.otherFence = otherFence;
//		this.lifeStyleOne = lifeStyleOne;
//		this.lifeStyleTwo = lifeStyleTwo;
//		this.lifeStyleThree = lifeStyleThree;
//		this.lifeStyleFour = lifeStyleFour;
//		this.lifeStyleFive = lifeStyleFive;
//		this.fbg = fbg;
//		this.glycatedHemoglobin = glycatedHemoglobin;
//		this.hbsag = hbsag;
//		this.hemoglobin = hemoglobin;
//		this.leukocyte = leukocyte;
//		this.platelet = platelet;
//		this.othersRb = othersRb;
//		this.urineProtein = urineProtein;
//		this.urineGlucose = urineGlucose;
//		this.ketone = ketone;
//		this.ery = ery;
//		this.othersRu = othersRu;
//		this.mau = mau;
//		this.sedOccultBlood = sedOccultBlood;
//		this.serumAlanineAminoAcid = serumAlanineAminoAcid;
//		this.serumAspertateAminoAcid = serumAspertateAminoAcid;
//		this.albumin = albumin;
//		this.tbil = tbil;
//		this.dbil = dbil;
//		this.cr = cr;
//		this.bun = bun;
//		this.serumPotassiumLevel = serumPotassiumLevel;
//		this.serumNatriumLevel = serumNatriumLevel;
//		this.totalCholesterol = totalCholesterol;
//		this.ldlC = ldlC;
//		this.triglyceride = triglyceride;
//		this.hdlC = hdlC;
//		this.papSmear = papSmear;
//		this.ecg = ecg;
//		this.chestXRay = chestXRay;
//		this.BScanUltrasonography = BScanUltrasonography;
//		this.others = others;
//		this.auxiliaryExaminationOne = auxiliaryExaminationOne;
//		this.auxiliaryExaminationTwo = auxiliaryExaminationTwo;
//		this.auxiliaryExaminationThree = auxiliaryExaminationThree;
//		this.auxiliaryExaminationFour = auxiliaryExaminationFour;
//		this.auxiliaryExaminationFive = auxiliaryExaminationFive;
//		this.chemotherapyHospital = chemotherapyHospital;
//		this.radiotherapyHospital = radiotherapyHospital;
//		this.surgicalHospital = surgicalHospital;
//		this.operateTime = operateTime;
//		this.operateHospital = operateHospital;
//		this.admissionNum = admissionNum;
//		this.operateProperty = operateProperty;
//		this.firstTime = firstTime;
//		this.secondTime = secondTime;
//		this.thirdTime = thirdTime;
//		this.changeDate = changeDate;
//		this.changeDepartment = changeDepartment;
//		this.deathAddress = deathAddress;
//		this.deathReason = deathReason;
//		this.deathDate = deathDate;
//		this.TTumourYear = TTumourYear;
//		this.mounth = mounth;
//		this.lifeId = lifeId;
//		this.auxiliaryExaminationId = auxiliaryExaminationId;
//		this.generalConditionId = generalConditionId;
//		this.GId = GId;
//	}

	// Property accessors
	@Id
	@Column(name = "CHRONIC_DISEASE_ID", nullable = false)
	public Integer getChronicDiseaseId() {
		return this.chronicDiseaseId;
	}

	public void setChronicDiseaseId(Integer chronicDiseaseId) {
		this.chronicDiseaseId = chronicDiseaseId;
	}

	@Column(name = "NAME", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "OLD_STAFF_HOS_ID", nullable = false)
	public Integer getOldStaffHosId() {
		return this.oldStaffHosId;
	}

	public void setOldStaffHosId(Integer oldStaffHosId) {
		this.oldStaffHosId = oldStaffHosId;
	}

	@Column(name = "STAFF_ID")
	public Integer getStaffId() {
		return this.staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	@Column(name = "COMMUNITY_HOSPITAL_ID")
	public Integer getCommunityHospitalId() {
		return this.communityHospitalId;
	}

	public void setCommunityHospitalId(Integer communityHospitalId) {
		this.communityHospitalId = communityHospitalId;
	}

	@Column(name = "FILE_NUM")
	public String getFileNum() {
		return this.fileNum;
	}

	public void setFileNum(String fileNum) {
		this.fileNum = fileNum;
	}

	@Column(name = "HEALTH_FILE_ID", nullable = false)
	public Integer getHealthFileId() {
		return this.healthFileId;
	}

	public void setHealthFileId(Integer healthFileId) {
		this.healthFileId = healthFileId;
	}

	@Column(name = "HIGH_BLOOD_PRESSURE_ID")
	public Integer getHighBloodPressureId() {
		return this.highBloodPressureId;
	}

	public void setHighBloodPressureId(Integer highBloodPressureId) {
		this.highBloodPressureId = highBloodPressureId;
	}

	@Column(name = "DIABETE_ID")
	public Integer getDiabeteId() {
		return this.diabeteId;
	}

	public void setDiabeteId(Integer diabeteId) {
		this.diabeteId = diabeteId;
	}

	@Column(name = "INSANITY_ID")
	public Integer getInsanityId() {
		return this.insanityId;
	}

	public void setInsanityId(Integer insanityId) {
		this.insanityId = insanityId;
	}

	@Column(name = "CORONARY_DISEASE_ID")
	public Integer getCoronaryDiseaseId() {
		return this.coronaryDiseaseId;
	}

	public void setCoronaryDiseaseId(Integer coronaryDiseaseId) {
		this.coronaryDiseaseId = coronaryDiseaseId;
	}

	@Column(name = "HVCD_ID")
	public Integer getHvcdId() {
		return this.hvcdId;
	}

	public void setHvcdId(Integer hvcdId) {
		this.hvcdId = hvcdId;
	}

	@Column(name = "TUMOUR_ID")
	public Integer getTumourId() {
		return this.tumourId;
	}

	public void setTumourId(Integer tumourId) {
		this.tumourId = tumourId;
	}

	@Column(name = "CHRONIC_BRONCHIAL_DISEASE_ID")
	public Integer getChronicBronchialDiseaseId() {
		return this.chronicBronchialDiseaseId;
	}

	public void setChronicBronchialDiseaseId(Integer chronicBronchialDiseaseId) {
		this.chronicBronchialDiseaseId = chronicBronchialDiseaseId;
	}

	@Column(name = "DISABILITY_OBSTACLE_ID")
	public Integer getDisabilityObstacleId() {
		return this.disabilityObstacleId;
	}

	public void setDisabilityObstacleId(Integer disabilityObstacleId) {
		this.disabilityObstacleId = disabilityObstacleId;
	}

	@Column(name = "FILE_NAME", nullable = false)
	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name = "FILE_FILE_DATE", length = 19)
	public Timestamp getFileFileDate() {
		return this.fileFileDate;
	}

	public void setFileFileDate(Timestamp fileFileDate) {
		this.fileFileDate = fileFileDate;
	}

	@Column(name = "ENTER_PEOPLE")
	public String getEnterPeople() {
		return this.enterPeople;
	}

	public void setEnterPeople(String enterPeople) {
		this.enterPeople = enterPeople;
	}

	@Column(name = "FILE_PERSON")
	public String getFilePerson() {
		return this.filePerson;
	}

	public void setFilePerson(String filePerson) {
		this.filePerson = filePerson;
	}

	@Column(name = "SEX")
	public Boolean getSex() {
		return this.sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	@Column(name = "ID_NUM", nullable = false)
	public String getIdNum() {
		return this.idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	@Column(name = "BIRTH_DATE", length = 19)
	public Timestamp getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Timestamp birthDate) {
		this.birthDate = birthDate;
	}

	@Column(name = "AGE")
	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Column(name = "WORK_UNIT")
	public String getWorkUnit() {
		return this.workUnit;
	}

	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}

	@Column(name = "I_PHONE", nullable = false)
	public String getIPhone() {
		return this.IPhone;
	}

	public void setIPhone(String IPhone) {
		this.IPhone = IPhone;
	}

	@Column(name = "PIC")
	public String getPic() {
		return this.pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	@Column(name = "OTHER_NAME")
	public String getOtherName() {
		return this.otherName;
	}

	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}

	@Column(name = "OTHER_PHONE")
	public String getOtherPhone() {
		return this.otherPhone;
	}

	public void setOtherPhone(String otherPhone) {
		this.otherPhone = otherPhone;
	}

	@Column(name = "HOSPITAL")
	public String getHospital() {
		return this.hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	@Column(name = "PERMANENT_TYPE", length = 1)
	public String getPermanentType() {
		return this.permanentType;
	}

	public void setPermanentType(String permanentType) {
		this.permanentType = permanentType;
	}

	@Column(name = "NATION")
	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	@Column(name = "EDU_LEVEL")
	public String getEduLevel() {
		return this.eduLevel;
	}

	public void setEduLevel(String eduLevel) {
		this.eduLevel = eduLevel;
	}

	@Column(name = "JOB")
	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Column(name = "BLOOD_TYPR", length = 1)
	public String getBloodTypr() {
		return this.bloodTypr;
	}

	public void setBloodTypr(String bloodTypr) {
		this.bloodTypr = bloodTypr;
	}

	@Column(name = "RH_NEGATIVE", length = 1)
	public String getRhNegative() {
		return this.rhNegative;
	}

	public void setRhNegative(String rhNegative) {
		this.rhNegative = rhNegative;
	}

	@Column(name = "MARITAL_STATUS")
	public String getMaritalStatus() {
		return this.maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	@Column(name = "EMAIL")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "CURRENT_PROVINCE")
	public String getCurrentProvince() {
		return this.currentProvince;
	}

	public void setCurrentProvince(String currentProvince) {
		this.currentProvince = currentProvince;
	}

	@Column(name = "CURRENT_OFFICE")
	public String getCurrentOffice() {
		return this.currentOffice;
	}

	public void setCurrentOffice(String currentOffice) {
		this.currentOffice = currentOffice;
	}

	@Column(name = "CURRENT_RESIDENT_COMMITTEE")
	public String getCurrentResidentCommittee() {
		return this.currentResidentCommittee;
	}

	public void setCurrentResidentCommittee(String currentResidentCommittee) {
		this.currentResidentCommittee = currentResidentCommittee;
	}

	@Column(name = "CURRENT_COMMUNITY")
	public String getCurrentCommunity() {
		return this.currentCommunity;
	}

	public void setCurrentCommunity(String currentCommunity) {
		this.currentCommunity = currentCommunity;
	}

	@Column(name = "OTHER_ADDRESS_TYPE")
	public String getOtherAddressType() {
		return this.otherAddressType;
	}

	public void setOtherAddressType(String otherAddressType) {
		this.otherAddressType = otherAddressType;
	}

	@Column(name = "OTHER_PROVINCE")
	public String getOtherProvince() {
		return this.otherProvince;
	}

	public void setOtherProvince(String otherProvince) {
		this.otherProvince = otherProvince;
	}

	@Column(name = "OTHER_CITY")
	public String getOtherCity() {
		return this.otherCity;
	}

	public void setOtherCity(String otherCity) {
		this.otherCity = otherCity;
	}

	@Column(name = "OTHER_COUNTY")
	public String getOtherCounty() {
		return this.otherCounty;
	}

	public void setOtherCounty(String otherCounty) {
		this.otherCounty = otherCounty;
	}

	@Column(name = "OTHER_COMMUNITY")
	public String getOtherCommunity() {
		return this.otherCommunity;
	}

	public void setOtherCommunity(String otherCommunity) {
		this.otherCommunity = otherCommunity;
	}

	@Column(name = "ALLERGY_NAME")
	public String getAllergyName() {
		return this.allergyName;
	}

	public void setAllergyName(String allergyName) {
		this.allergyName = allergyName;
	}

	@Column(name = "EXPOSE_NAME")
	public String getExposeName() {
		return this.exposeName;
	}

	public void setExposeName(String exposeName) {
		this.exposeName = exposeName;
	}

	@Column(name = "EXPOSE_NOTE", length = 65535)
	public String getExposeNote() {
		return this.exposeNote;
	}

	public void setExposeNote(String exposeNote) {
		this.exposeNote = exposeNote;
	}

	@Column(name = "FATHER_DISEASE")
	public String getFatherDisease() {
		return this.fatherDisease;
	}

	public void setFatherDisease(String fatherDisease) {
		this.fatherDisease = fatherDisease;
	}

	@Column(name = "MOTHER_DISEASE")
	public String getMotherDisease() {
		return this.motherDisease;
	}

	public void setMotherDisease(String motherDisease) {
		this.motherDisease = motherDisease;
	}

	@Column(name = "BOR_SIS_DISEASE")
	public String getBorSisDisease() {
		return this.borSisDisease;
	}

	public void setBorSisDisease(String borSisDisease) {
		this.borSisDisease = borSisDisease;
	}

	@Column(name = "CHILD_DISEASE")
	public String getChildDisease() {
		return this.childDisease;
	}

	public void setChildDisease(String childDisease) {
		this.childDisease = childDisease;
	}

	@Column(name = "OTHER_DISEASE", length = 1000)
	public String getOtherDisease() {
		return this.otherDisease;
	}

	public void setOtherDisease(String otherDisease) {
		this.otherDisease = otherDisease;
	}

	@Column(name = "DISABILITY_NAME")
	public String getDisabilityName() {
		return this.disabilityName;
	}

	public void setDisabilityName(String disabilityName) {
		this.disabilityName = disabilityName;
	}

	@Column(name = "GENETIC_HISTORY")
	public String getGeneticHistory() {
		return this.geneticHistory;
	}

	public void setGeneticHistory(String geneticHistory) {
		this.geneticHistory = geneticHistory;
	}

	@Column(name = "KIT_VEN_FAC")
	public String getKitVenFac() {
		return this.kitVenFac;
	}

	public void setKitVenFac(String kitVenFac) {
		this.kitVenFac = kitVenFac;
	}

	@Column(name = "FUEL_TYPE")
	public String getFuelType() {
		return this.fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	@Column(name = "DRINK_WATER")
	public String getDrinkWater() {
		return this.drinkWater;
	}

	public void setDrinkWater(String drinkWater) {
		this.drinkWater = drinkWater;
	}

	@Column(name = "TOILET")
	public String getToilet() {
		return this.toilet;
	}

	public void setToilet(String toilet) {
		this.toilet = toilet;
	}

	@Column(name = "LIVESTOCK_BAR")
	public String getLivestockBar() {
		return this.livestockBar;
	}

	public void setLivestockBar(String livestockBar) {
		this.livestockBar = livestockBar;
	}

	@Column(name = "CROWD_CLASS", length = 1)
	public String getCrowdClass() {
		return this.crowdClass;
	}

	public void setCrowdClass(String crowdClass) {
		this.crowdClass = crowdClass;
	}

	@Column(name = "HEALTH_FILE_TYPE", length = 1)
	public String getHealthFileType() {
		return this.healthFileType;
	}

	public void setHealthFileType(String healthFileType) {
		this.healthFileType = healthFileType;
	}

	@Column(name = "HEALTH_FILE_ONE", length = 1000)
	public String getHealthFileOne() {
		return this.healthFileOne;
	}

	public void setHealthFileOne(String healthFileOne) {
		this.healthFileOne = healthFileOne;
	}

	@Column(name = "HEALTH_FILE_TWO", length = 1000)
	public String getHealthFileTwo() {
		return this.healthFileTwo;
	}

	public void setHealthFileTwo(String healthFileTwo) {
		this.healthFileTwo = healthFileTwo;
	}

	@Column(name = "HEALTH_FILE_THREE", length = 1000)
	public String getHealthFileThree() {
		return this.healthFileThree;
	}

	public void setHealthFileThree(String healthFileThree) {
		this.healthFileThree = healthFileThree;
	}

	@Column(name = "HEALTH_FILE_FOUR", length = 1000)
	public String getHealthFileFour() {
		return this.healthFileFour;
	}

	public void setHealthFileFour(String healthFileFour) {
		this.healthFileFour = healthFileFour;
	}

	@Column(name = "HEALTH_FILE_FIVE", length = 1000)
	public String getHealthFileFive() {
		return this.healthFileFive;
	}

	public void setHealthFileFive(String healthFileFive) {
		this.healthFileFive = healthFileFive;
	}

	@Column(name = "CURRENT_CITY")
	public String getCurrentCity() {
		return this.currentCity;
	}

	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}

	@Column(name = "CURRENT_COUNTY")
	public String getCurrentCounty() {
		return this.currentCounty;
	}

	public void setCurrentCounty(String currentCounty) {
		this.currentCounty = currentCounty;
	}

	@Column(name = "ICD")
	public String getIcd() {
		return this.icd;
	}

	public void setIcd(String icd) {
		this.icd = icd;
	}

	@Column(name = "DISEASE_NAME", nullable = false)
	public String getDiseaseName() {
		return this.diseaseName;
	}

	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}

	@Column(name = "CHRONIC_DISEASE_FILE_DATE", nullable = false, length = 19)
	public Timestamp getChronicDiseaseFileDate() {
		return this.chronicDiseaseFileDate;
	}

	public void setChronicDiseaseFileDate(Timestamp chronicDiseaseFileDate) {
		this.chronicDiseaseFileDate = chronicDiseaseFileDate;
	}

	@Column(name = "CHRONIC_DISEASE_FILE_NAME", nullable = false)
	public String getChronicDiseaseFileName() {
		return this.chronicDiseaseFileName;
	}

	public void setChronicDiseaseFileName(String chronicDiseaseFileName) {
		this.chronicDiseaseFileName = chronicDiseaseFileName;
	}

	@Column(name = "STATUS")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "CHRONIC_DISEASE_ONE", length = 1000)
	public String getChronicDiseaseOne() {
		return this.chronicDiseaseOne;
	}

	public void setChronicDiseaseOne(String chronicDiseaseOne) {
		this.chronicDiseaseOne = chronicDiseaseOne;
	}

	@Column(name = "CHRONIC_DISEASE_TWO", length = 1000)
	public String getChronicDiseaseTwo() {
		return this.chronicDiseaseTwo;
	}

	public void setChronicDiseaseTwo(String chronicDiseaseTwo) {
		this.chronicDiseaseTwo = chronicDiseaseTwo;
	}

	@Column(name = "CHRONIC_DISEASE_THREE", length = 1000)
	public String getChronicDiseaseThree() {
		return this.chronicDiseaseThree;
	}

	public void setChronicDiseaseThree(String chronicDiseaseThree) {
		this.chronicDiseaseThree = chronicDiseaseThree;
	}

	@Column(name = "CHRONIC_DISEASE_FOUR", length = 1000)
	public String getChronicDiseaseFour() {
		return this.chronicDiseaseFour;
	}

	public void setChronicDiseaseFour(String chronicDiseaseFour) {
		this.chronicDiseaseFour = chronicDiseaseFour;
	}

	@Column(name = "CHRONIC_DISEASE_FIVE", length = 1000)
	public String getChronicDiseaseFive() {
		return this.chronicDiseaseFive;
	}

	public void setChronicDiseaseFive(String chronicDiseaseFive) {
		this.chronicDiseaseFive = chronicDiseaseFive;
	}

	@Column(name = "HIGH_BLOOD_TYPR")
	public String getHighBloodTypr() {
		return this.highBloodTypr;
	}

	public void setHighBloodTypr(String highBloodTypr) {
		this.highBloodTypr = highBloodTypr;
	}

	@Column(name = "MANAGEMENT_CLASS")
	public String getManagementClass() {
		return this.managementClass;
	}

	public void setManagementClass(String managementClass) {
		this.managementClass = managementClass;
	}

	@Column(name = "HIGH_BLOOD_INITIAL_DIAGNOSIS_TIME", length = 19)
	public Timestamp getHighBloodInitialDiagnosisTime() {
		return this.highBloodInitialDiagnosisTime;
	}

	public void setHighBloodInitialDiagnosisTime(
			Timestamp highBloodInitialDiagnosisTime) {
		this.highBloodInitialDiagnosisTime = highBloodInitialDiagnosisTime;
	}

	@Column(name = "MAIN_SYMPTOMS")
	public String getMainSymptoms() {
		return this.mainSymptoms;
	}

	public void setMainSymptoms(String mainSymptoms) {
		this.mainSymptoms = mainSymptoms;
	}

	@Column(name = "HYPERTENSION_COMPLICATION")
	public String getHypertensionComplication() {
		return this.hypertensionComplication;
	}

	public void setHypertensionComplication(String hypertensionComplication) {
		this.hypertensionComplication = hypertensionComplication;
	}

	@Column(name = "HOW_LONG_TAKE_BLOOD")
	public String getHowLongTakeBlood() {
		return this.howLongTakeBlood;
	}

	public void setHowLongTakeBlood(String howLongTakeBlood) {
		this.howLongTakeBlood = howLongTakeBlood;
	}

	@Column(name = "TAKE_MEDICATION")
	public String getTakeMedication() {
		return this.takeMedication;
	}

	public void setTakeMedication(String takeMedication) {
		this.takeMedication = takeMedication;
	}

	@Column(name = "NOT_TAKE_REASON", length = 65535)
	public String getNotTakeReason() {
		return this.notTakeReason;
	}

	public void setNotTakeReason(String notTakeReason) {
		this.notTakeReason = notTakeReason;
	}

	@Column(name = "DRUG_COST", precision = 22, scale = 0)
	public Double getDrugCost() {
		return this.drugCost;
	}

	public void setDrugCost(Double drugCost) {
		this.drugCost = drugCost;
	}

	@Column(name = "NON_DRUG_TREATMENT")
	public String getNonDrugTreatment() {
		return this.nonDrugTreatment;
	}

	public void setNonDrugTreatment(String nonDrugTreatment) {
		this.nonDrugTreatment = nonDrugTreatment;
	}

	@Column(name = "FAMILY_WHIT_HIGH_BLOOD")
	public String getFamilyWhitHighBlood() {
		return this.familyWhitHighBlood;
	}

	public void setFamilyWhitHighBlood(String familyWhitHighBlood) {
		this.familyWhitHighBlood = familyWhitHighBlood;
	}

	@Column(name = "HIGH_BLOOD_FILING_DATE", length = 19)
	public Timestamp getHighBloodFilingDate() {
		return this.highBloodFilingDate;
	}

	public void setHighBloodFilingDate(Timestamp highBloodFilingDate) {
		this.highBloodFilingDate = highBloodFilingDate;
	}

	@Column(name = "HIGH_BLOOD_BOOKRUNNER")
	public String getHighBloodBookrunner() {
		return this.highBloodBookrunner;
	}

	public void setHighBloodBookrunner(String highBloodBookrunner) {
		this.highBloodBookrunner = highBloodBookrunner;
	}

	@Column(name = "HIGH_BLOOD_PRESSURE_ONE", length = 1000)
	public String getHighBloodPressureOne() {
		return this.highBloodPressureOne;
	}

	public void setHighBloodPressureOne(String highBloodPressureOne) {
		this.highBloodPressureOne = highBloodPressureOne;
	}

	@Column(name = "HIGH_BLOOD_PRESSURE_TWO", length = 1000)
	public String getHighBloodPressureTwo() {
		return this.highBloodPressureTwo;
	}

	public void setHighBloodPressureTwo(String highBloodPressureTwo) {
		this.highBloodPressureTwo = highBloodPressureTwo;
	}

	@Column(name = "HIGH_BLOOD_PRESSURE_THREE", length = 1000)
	public String getHighBloodPressureThree() {
		return this.highBloodPressureThree;
	}

	public void setHighBloodPressureThree(String highBloodPressureThree) {
		this.highBloodPressureThree = highBloodPressureThree;
	}

	@Column(name = "HIGH_BLOOD_PRESSURE_FOUR", length = 1000)
	public String getHighBloodPressureFour() {
		return this.highBloodPressureFour;
	}

	public void setHighBloodPressureFour(String highBloodPressureFour) {
		this.highBloodPressureFour = highBloodPressureFour;
	}

	@Column(name = "HIGH_BLOOD_PRESSURE_FIVE", length = 1000)
	public String getHighBloodPressureFive() {
		return this.highBloodPressureFive;
	}

	public void setHighBloodPressureFive(String highBloodPressureFive) {
		this.highBloodPressureFive = highBloodPressureFive;
	}

	@Column(name = "DIABETE_INITIAL_DIAGNOSIS_TIME", length = 19)
	public Timestamp getDiabeteInitialDiagnosisTime() {
		return this.diabeteInitialDiagnosisTime;
	}

	public void setDiabeteInitialDiagnosisTime(
			Timestamp diabeteInitialDiagnosisTime) {
		this.diabeteInitialDiagnosisTime = diabeteInitialDiagnosisTime;
	}

	@Column(name = "CO_OF_DIA")
	public String getCoOfDia() {
		return this.coOfDia;
	}

	public void setCoOfDia(String coOfDia) {
		this.coOfDia = coOfDia;
	}

	@Column(name = "TYP_OF_DIA")
	public String getTypOfDia() {
		return this.typOfDia;
	}

	public void setTypOfDia(String typOfDia) {
		this.typOfDia = typOfDia;
	}

	@Column(name = "COST_PER_MONTH", precision = 22, scale = 0)
	public Double getCostPerMonth() {
		return this.costPerMonth;
	}

	public void setCostPerMonth(Double costPerMonth) {
		this.costPerMonth = costPerMonth;
	}

	@Column(name = "MAIN_SYPTM", length = 65535)
	public String getMainSyptm() {
		return this.mainSyptm;
	}

	public void setMainSyptm(String mainSyptm) {
		this.mainSyptm = mainSyptm;
	}

	@Column(name = "DIA_COMPL")
	public String getDiaCompl() {
		return this.diaCompl;
	}

	public void setDiaCompl(String diaCompl) {
		this.diaCompl = diaCompl;
	}

	@Column(name = "DIA_HISTORY", length = 65535)
	public String getDiaHistory() {
		return this.diaHistory;
	}

	public void setDiaHistory(String diaHistory) {
		this.diaHistory = diaHistory;
	}

	@Column(name = "FA_MEM")
	public String getFaMem() {
		return this.faMem;
	}

	public void setFaMem(String faMem) {
		this.faMem = faMem;
	}

	@Column(name = "DIABETE_FILING_DATE", length = 19)
	public Timestamp getDiabeteFilingDate() {
		return this.diabeteFilingDate;
	}

	public void setDiabeteFilingDate(Timestamp diabeteFilingDate) {
		this.diabeteFilingDate = diabeteFilingDate;
	}

	@Column(name = "DIABETE_BOOKRUNNER")
	public String getDiabeteBookrunner() {
		return this.diabeteBookrunner;
	}

	public void setDiabeteBookrunner(String diabeteBookrunner) {
		this.diabeteBookrunner = diabeteBookrunner;
	}

	@Column(name = "DIABETE_ONE", length = 1000)
	public String getDiabeteOne() {
		return this.diabeteOne;
	}

	public void setDiabeteOne(String diabeteOne) {
		this.diabeteOne = diabeteOne;
	}

	@Column(name = "DIABETE_TWO", length = 1000)
	public String getDiabeteTwo() {
		return this.diabeteTwo;
	}

	public void setDiabeteTwo(String diabeteTwo) {
		this.diabeteTwo = diabeteTwo;
	}

	@Column(name = "DIABETE_THREE", length = 1000)
	public String getDiabeteThree() {
		return this.diabeteThree;
	}

	public void setDiabeteThree(String diabeteThree) {
		this.diabeteThree = diabeteThree;
	}

	@Column(name = "DIABETE_FOUR", length = 1000)
	public String getDiabeteFour() {
		return this.diabeteFour;
	}

	public void setDiabeteFour(String diabeteFour) {
		this.diabeteFour = diabeteFour;
	}

	@Column(name = "DIABETE_FIVE", length = 1000)
	public String getDiabeteFive() {
		return this.diabeteFive;
	}

	public void setDiabeteFive(String diabeteFive) {
		this.diabeteFive = diabeteFive;
	}

	@Column(name = "GUARDIAN_NAME")
	public String getGuardianName() {
		return this.guardianName;
	}

	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}

	@Column(name = "PATIENT_RELATION")
	public String getPatientRelation() {
		return this.patientRelation;
	}

	public void setPatientRelation(String patientRelation) {
		this.patientRelation = patientRelation;
	}

	@Column(name = "GUARDIAN_ADDRESS")
	public String getGuardianAddress() {
		return this.guardianAddress;
	}

	public void setGuardianAddress(String guardianAddress) {
		this.guardianAddress = guardianAddress;
	}

	@Column(name = "GUARDIAN_PHONE")
	public String getGuardianPhone() {
		return this.guardianPhone;
	}

	public void setGuardianPhone(String guardianPhone) {
		this.guardianPhone = guardianPhone;
	}

	@Column(name = "NEIGHBORHOOD_LINKMAN")
	public String getNeighborhoodLinkman() {
		return this.neighborhoodLinkman;
	}

	public void setNeighborhoodLinkman(String neighborhoodLinkman) {
		this.neighborhoodLinkman = neighborhoodLinkman;
	}

	@Column(name = "NEIGHBORHOOD_PHONE")
	public String getNeighborhoodPhone() {
		return this.neighborhoodPhone;
	}

	public void setNeighborhoodPhone(String neighborhoodPhone) {
		this.neighborhoodPhone = neighborhoodPhone;
	}

	@Column(name = "FIRST_ATTACK_TIME", length = 19)
	public Timestamp getFirstAttackTime() {
		return this.firstAttackTime;
	}

	public void setFirstAttackTime(Timestamp firstAttackTime) {
		this.firstAttackTime = firstAttackTime;
	}

	@Column(name = "BEFORE_SYMPTOM", length = 65535)
	public String getBeforeSymptom() {
		return this.beforeSymptom;
	}

	public void setBeforeSymptom(String beforeSymptom) {
		this.beforeSymptom = beforeSymptom;
	}

	@Column(name = "BEFORE_CURE_OUTPATIENT", length = 65535)
	public String getBeforeCureOutpatient() {
		return this.beforeCureOutpatient;
	}

	public void setBeforeCureOutpatient(String beforeCureOutpatient) {
		this.beforeCureOutpatient = beforeCureOutpatient;
	}

	@Column(name = "BEFORE_CURE_HOSPITAL", length = 65535)
	public String getBeforeCureHospital() {
		return this.beforeCureHospital;
	}

	public void setBeforeCureHospital(String beforeCureHospital) {
		this.beforeCureHospital = beforeCureHospital;
	}

	@Column(name = "RECENTLY_DIAGNOSE", length = 65535)
	public String getRecentlyDiagnose() {
		return this.recentlyDiagnose;
	}

	public void setRecentlyDiagnose(String recentlyDiagnose) {
		this.recentlyDiagnose = recentlyDiagnose;
	}

	@Column(name = "AFFIRM_HOSPITAL")
	public String getAffirmHospital() {
		return this.affirmHospital;
	}

	public void setAffirmHospital(String affirmHospital) {
		this.affirmHospital = affirmHospital;
	}

	@Column(name = "CONFIRMED_DATE", length = 19)
	public Timestamp getConfirmedDate() {
		return this.confirmedDate;
	}

	public void setConfirmedDate(Timestamp confirmedDate) {
		this.confirmedDate = confirmedDate;
	}

	@Column(name = "RECENTLY_CURE_EFFECT", length = 65535)
	public String getRecentlyCureEffect() {
		return this.recentlyCureEffect;
	}

	public void setRecentlyCureEffect(String recentlyCureEffect) {
		this.recentlyCureEffect = recentlyCureEffect;
	}

	@Column(name = "INFLUENCE", length = 65535)
	public String getInfluence() {
		return this.influence;
	}

	public void setInfluence(String influence) {
		this.influence = influence;
	}

	@Column(name = "LOCKS", length = 65535)
	public String getLocks() {
		return this.locks;
	}

	public void setLocks(String locks) {
		this.locks = locks;
	}

	@Column(name = "INSANITY_FORM_FILING_DATE", length = 19)
	public Timestamp getInsanityFormFilingDate() {
		return this.insanityFormFilingDate;
	}

	public void setInsanityFormFilingDate(Timestamp insanityFormFilingDate) {
		this.insanityFormFilingDate = insanityFormFilingDate;
	}

	@Column(name = "INSANITY_FORM_BOOKRUNNER")
	public String getInsanityFormBookrunner() {
		return this.insanityFormBookrunner;
	}

	public void setInsanityFormBookrunner(String insanityFormBookrunner) {
		this.insanityFormBookrunner = insanityFormBookrunner;
	}

	@Column(name = "INSANITY_FORM_ONE", length = 1000)
	public String getInsanityFormOne() {
		return this.insanityFormOne;
	}

	public void setInsanityFormOne(String insanityFormOne) {
		this.insanityFormOne = insanityFormOne;
	}

	@Column(name = "INSANITY_FORM_TWO", length = 1000)
	public String getInsanityFormTwo() {
		return this.insanityFormTwo;
	}

	public void setInsanityFormTwo(String insanityFormTwo) {
		this.insanityFormTwo = insanityFormTwo;
	}

	@Column(name = "INSANITY_FORM_THREE", length = 1000)
	public String getInsanityFormThree() {
		return this.insanityFormThree;
	}

	public void setInsanityFormThree(String insanityFormThree) {
		this.insanityFormThree = insanityFormThree;
	}

	@Column(name = "INSANITY_FORM_FOUR", length = 1000)
	public String getInsanityFormFour() {
		return this.insanityFormFour;
	}

	public void setInsanityFormFour(String insanityFormFour) {
		this.insanityFormFour = insanityFormFour;
	}

	@Column(name = "INSANITY_FORM_FIVE", length = 1000)
	public String getInsanityFormFive() {
		return this.insanityFormFive;
	}

	public void setInsanityFormFive(String insanityFormFive) {
		this.insanityFormFive = insanityFormFive;
	}

	@Column(name = "CORONARY_DISEASE_TYPE")
	public String getCoronaryDiseaseType() {
		return this.coronaryDiseaseType;
	}

	public void setCoronaryDiseaseType(String coronaryDiseaseType) {
		this.coronaryDiseaseType = coronaryDiseaseType;
	}

	@Column(name = "CORONARY_DISEASE_FRIST_DIAGNOSE", length = 65535)
	public String getCoronaryDiseaseFristDiagnose() {
		return this.coronaryDiseaseFristDiagnose;
	}

	public void setCoronaryDiseaseFristDiagnose(
			String coronaryDiseaseFristDiagnose) {
		this.coronaryDiseaseFristDiagnose = coronaryDiseaseFristDiagnose;
	}

	@Column(name = "CORONARY_DISEASE_CAUSE")
	public String getCoronaryDiseaseCause() {
		return this.coronaryDiseaseCause;
	}

	public void setCoronaryDiseaseCause(String coronaryDiseaseCause) {
		this.coronaryDiseaseCause = coronaryDiseaseCause;
	}

	@Column(name = "CORONARY_DISEASE_FORM")
	public String getCoronaryDiseaseForm() {
		return this.coronaryDiseaseForm;
	}

	public void setCoronaryDiseaseForm(String coronaryDiseaseForm) {
		this.coronaryDiseaseForm = coronaryDiseaseForm;
	}

	@Column(name = "CORONARY_DISEASE_COMPLICATION")
	public String getCoronaryDiseaseComplication() {
		return this.coronaryDiseaseComplication;
	}

	public void setCoronaryDiseaseComplication(
			String coronaryDiseaseComplication) {
		this.coronaryDiseaseComplication = coronaryDiseaseComplication;
	}

	@Column(name = "CORONARY_DISEASE_USE_DRUG", length = 65535)
	public String getCoronaryDiseaseUseDrug() {
		return this.coronaryDiseaseUseDrug;
	}

	public void setCoronaryDiseaseUseDrug(String coronaryDiseaseUseDrug) {
		this.coronaryDiseaseUseDrug = coronaryDiseaseUseDrug;
	}

	@Column(name = "ELECTROCARDIOGRAM")
	public String getElectrocardiogram() {
		return this.electrocardiogram;
	}

	public void setElectrocardiogram(String electrocardiogram) {
		this.electrocardiogram = electrocardiogram;
	}

	@Column(name = "ELECTROENCEPHALOGRAM")
	public String getElectroencephalogram() {
		return this.electroencephalogram;
	}

	public void setElectroencephalogram(String electroencephalogram) {
		this.electroencephalogram = electroencephalogram;
	}

	@Column(name = "CORONARY_DISEASE_X")
	public String getCoronaryDiseaseX() {
		return this.coronaryDiseaseX;
	}

	public void setCoronaryDiseaseX(String coronaryDiseaseX) {
		this.coronaryDiseaseX = coronaryDiseaseX;
	}

	@Column(name = "CORONARY_DISEASE_CT")
	public String getCoronaryDiseaseCt() {
		return this.coronaryDiseaseCt;
	}

	public void setCoronaryDiseaseCt(String coronaryDiseaseCt) {
		this.coronaryDiseaseCt = coronaryDiseaseCt;
	}

	@Column(name = "CORONARY_DISEASE_CEREBRAL_BLOOD_VESSEL")
	public String getCoronaryDiseaseCerebralBloodVessel() {
		return this.coronaryDiseaseCerebralBloodVessel;
	}

	public void setCoronaryDiseaseCerebralBloodVessel(
			String coronaryDiseaseCerebralBloodVessel) {
		this.coronaryDiseaseCerebralBloodVessel = coronaryDiseaseCerebralBloodVessel;
	}

	@Column(name = "CORONARY_DISEASE_REMARKS", length = 65535)
	public String getCoronaryDiseaseRemarks() {
		return this.coronaryDiseaseRemarks;
	}

	public void setCoronaryDiseaseRemarks(String coronaryDiseaseRemarks) {
		this.coronaryDiseaseRemarks = coronaryDiseaseRemarks;
	}

	@Column(name = "IVESTING_PERSON")
	public String getIvestingPerson() {
		return this.ivestingPerson;
	}

	public void setIvestingPerson(String ivestingPerson) {
		this.ivestingPerson = ivestingPerson;
	}

	@Column(name = "CORONARY_DISEASE_FILING_DATE", length = 19)
	public Timestamp getCoronaryDiseaseFilingDate() {
		return this.coronaryDiseaseFilingDate;
	}

	public void setCoronaryDiseaseFilingDate(Timestamp coronaryDiseaseFilingDate) {
		this.coronaryDiseaseFilingDate = coronaryDiseaseFilingDate;
	}

	@Column(name = "CORONARY_DISEASE_BOOKRUNNER")
	public String getCoronaryDiseaseBookrunner() {
		return this.coronaryDiseaseBookrunner;
	}

	public void setCoronaryDiseaseBookrunner(String coronaryDiseaseBookrunner) {
		this.coronaryDiseaseBookrunner = coronaryDiseaseBookrunner;
	}

	@Column(name = "CORONARY_DISEASE_ONE", length = 1000)
	public String getCoronaryDiseaseOne() {
		return this.coronaryDiseaseOne;
	}

	public void setCoronaryDiseaseOne(String coronaryDiseaseOne) {
		this.coronaryDiseaseOne = coronaryDiseaseOne;
	}

	@Column(name = "CORONARY_DISEASE_TWO", length = 1000)
	public String getCoronaryDiseaseTwo() {
		return this.coronaryDiseaseTwo;
	}

	public void setCoronaryDiseaseTwo(String coronaryDiseaseTwo) {
		this.coronaryDiseaseTwo = coronaryDiseaseTwo;
	}

	@Column(name = "CORONARY_DISEASE_THREE", length = 1000)
	public String getCoronaryDiseaseThree() {
		return this.coronaryDiseaseThree;
	}

	public void setCoronaryDiseaseThree(String coronaryDiseaseThree) {
		this.coronaryDiseaseThree = coronaryDiseaseThree;
	}

	@Column(name = "CORONARY_DISEASE_FOUR", length = 1000)
	public String getCoronaryDiseaseFour() {
		return this.coronaryDiseaseFour;
	}

	public void setCoronaryDiseaseFour(String coronaryDiseaseFour) {
		this.coronaryDiseaseFour = coronaryDiseaseFour;
	}

	@Column(name = "CORONARY_DISEASE_FIVE", length = 1000)
	public String getCoronaryDiseaseFive() {
		return this.coronaryDiseaseFive;
	}

	public void setCoronaryDiseaseFive(String coronaryDiseaseFive) {
		this.coronaryDiseaseFive = coronaryDiseaseFive;
	}

	@Column(name = "HCVD_TYPE")
	public String getHcvdType() {
		return this.hcvdType;
	}

	public void setHcvdType(String hcvdType) {
		this.hcvdType = hcvdType;
	}

	@Column(name = "HCVD_FRIST_DIAGNOSE", length = 65535)
	public String getHcvdFristDiagnose() {
		return this.hcvdFristDiagnose;
	}

	public void setHcvdFristDiagnose(String hcvdFristDiagnose) {
		this.hcvdFristDiagnose = hcvdFristDiagnose;
	}

	@Column(name = "HCVD_FORM")
	public String getHcvdForm() {
		return this.hcvdForm;
	}

	public void setHcvdForm(String hcvdForm) {
		this.hcvdForm = hcvdForm;
	}

	@Column(name = "HCVD_COMPLICATION")
	public String getHcvdComplication() {
		return this.hcvdComplication;
	}

	public void setHcvdComplication(String hcvdComplication) {
		this.hcvdComplication = hcvdComplication;
	}

	@Column(name = "HCVD_USE_DRUG", length = 65535)
	public String getHcvdUseDrug() {
		return this.hcvdUseDrug;
	}

	public void setHcvdUseDrug(String hcvdUseDrug) {
		this.hcvdUseDrug = hcvdUseDrug;
	}

	@Column(name = "HCVD_ELECTROCARDIOGRAM", length = 65535)
	public String getHcvdElectrocardiogram() {
		return this.hcvdElectrocardiogram;
	}

	public void setHcvdElectrocardiogram(String hcvdElectrocardiogram) {
		this.hcvdElectrocardiogram = hcvdElectrocardiogram;
	}

	@Column(name = "HCVD_ELECTROENCEPHALOGRAM", length = 65535)
	public String getHcvdElectroencephalogram() {
		return this.hcvdElectroencephalogram;
	}

	public void setHcvdElectroencephalogram(String hcvdElectroencephalogram) {
		this.hcvdElectroencephalogram = hcvdElectroencephalogram;
	}

	@Column(name = "HCVD_CAUSE", length = 65535)
	public String getHcvdCause() {
		return this.hcvdCause;
	}

	public void setHcvdCause(String hcvdCause) {
		this.hcvdCause = hcvdCause;
	}

	@Column(name = "HCVD_X", length = 65535)
	public String getHcvdX() {
		return this.hcvdX;
	}

	public void setHcvdX(String hcvdX) {
		this.hcvdX = hcvdX;
	}

	@Column(name = "HCVD_CT", length = 65535)
	public String getHcvdCt() {
		return this.hcvdCt;
	}

	public void setHcvdCt(String hcvdCt) {
		this.hcvdCt = hcvdCt;
	}

	@Column(name = "HCVD_CEREBRAL_BLOOD_VESSEL", length = 65535)
	public String getHcvdCerebralBloodVessel() {
		return this.hcvdCerebralBloodVessel;
	}

	public void setHcvdCerebralBloodVessel(String hcvdCerebralBloodVessel) {
		this.hcvdCerebralBloodVessel = hcvdCerebralBloodVessel;
	}

	@Column(name = "HCVD_REMARKS", length = 65535)
	public String getHcvdRemarks() {
		return this.hcvdRemarks;
	}

	public void setHcvdRemarks(String hcvdRemarks) {
		this.hcvdRemarks = hcvdRemarks;
	}

	@Column(name = "HCVD_INVESTIGATED_PERSON")
	public String getHcvdInvestigatedPerson() {
		return this.hcvdInvestigatedPerson;
	}

	public void setHcvdInvestigatedPerson(String hcvdInvestigatedPerson) {
		this.hcvdInvestigatedPerson = hcvdInvestigatedPerson;
	}

	@Column(name = "HCVD_FILING_DATE", length = 19)
	public Timestamp getHcvdFilingDate() {
		return this.hcvdFilingDate;
	}

	public void setHcvdFilingDate(Timestamp hcvdFilingDate) {
		this.hcvdFilingDate = hcvdFilingDate;
	}

	@Column(name = "HCVD_BOOKRUNNER")
	public String getHcvdBookrunner() {
		return this.hcvdBookrunner;
	}

	public void setHcvdBookrunner(String hcvdBookrunner) {
		this.hcvdBookrunner = hcvdBookrunner;
	}

	@Column(name = "HCVD_ONE", length = 1000)
	public String getHcvdOne() {
		return this.hcvdOne;
	}

	public void setHcvdOne(String hcvdOne) {
		this.hcvdOne = hcvdOne;
	}

	@Column(name = "HCVD_TWO", length = 1000)
	public String getHcvdTwo() {
		return this.hcvdTwo;
	}

	public void setHcvdTwo(String hcvdTwo) {
		this.hcvdTwo = hcvdTwo;
	}

	@Column(name = "HCVD_THREE", length = 1000)
	public String getHcvdThree() {
		return this.hcvdThree;
	}

	public void setHcvdThree(String hcvdThree) {
		this.hcvdThree = hcvdThree;
	}

	@Column(name = "HCVD_FOUR", length = 1000)
	public String getHcvdFour() {
		return this.hcvdFour;
	}

	public void setHcvdFour(String hcvdFour) {
		this.hcvdFour = hcvdFour;
	}

	@Column(name = "HCVD_FIVE", length = 1000)
	public String getHcvdFive() {
		return this.hcvdFive;
	}

	public void setHcvdFive(String hcvdFive) {
		this.hcvdFive = hcvdFive;
	}

	@Column(name = "DIAGNOSTIC_INFORMATION")
	public String getDiagnosticInformation() {
		return this.diagnosticInformation;
	}

	public void setDiagnosticInformation(String diagnosticInformation) {
		this.diagnosticInformation = diagnosticInformation;
	}

	@Column(name = "EMERGENCE_DATE", length = 19)
	public Timestamp getEmergenceDate() {
		return this.emergenceDate;
	}

	public void setEmergenceDate(Timestamp emergenceDate) {
		this.emergenceDate = emergenceDate;
	}

	@Column(name = "TREATMENT_DATE", length = 19)
	public Timestamp getTreatmentDate() {
		return this.treatmentDate;
	}

	public void setTreatmentDate(Timestamp treatmentDate) {
		this.treatmentDate = treatmentDate;
	}

	@Column(name = "TUMOUR_DIAGNOSIS_DATE", length = 19)
	public Timestamp getTumourDiagnosisDate() {
		return this.tumourDiagnosisDate;
	}

	public void setTumourDiagnosisDate(Timestamp tumourDiagnosisDate) {
		this.tumourDiagnosisDate = tumourDiagnosisDate;
	}

	@Column(name = "TUMOUR_DIAGNOSED_HOSPITAL")
	public String getTumourDiagnosedHospital() {
		return this.tumourDiagnosedHospital;
	}

	public void setTumourDiagnosedHospital(String tumourDiagnosedHospital) {
		this.tumourDiagnosedHospital = tumourDiagnosedHospital;
	}

	@Column(name = "TUMOUR_PATHOLOGICAL_TYPE")
	public String getTumourPathologicalType() {
		return this.tumourPathologicalType;
	}

	public void setTumourPathologicalType(String tumourPathologicalType) {
		this.tumourPathologicalType = tumourPathologicalType;
	}

	@Column(name = "CONFIRMATION_BASIS", length = 65535)
	public String getConfirmationBasis() {
		return this.confirmationBasis;
	}

	public void setConfirmationBasis(String confirmationBasis) {
		this.confirmationBasis = confirmationBasis;
	}

	@Column(name = "DIAGNOSIS_PERIOD", length = 65535)
	public String getDiagnosisPeriod() {
		return this.diagnosisPeriod;
	}

	public void setDiagnosisPeriod(String diagnosisPeriod) {
		this.diagnosisPeriod = diagnosisPeriod;
	}

	@Column(name = "OUTPATIENT_NUMBER")
	public String getOutpatientNumber() {
		return this.outpatientNumber;
	}

	public void setOutpatientNumber(String outpatientNumber) {
		this.outpatientNumber = outpatientNumber;
	}

	@Column(name = "INPATIENT_NUMBER")
	public String getInpatientNumber() {
		return this.inpatientNumber;
	}

	public void setInpatientNumber(String inpatientNumber) {
		this.inpatientNumber = inpatientNumber;
	}

	@Column(name = "TUMOUR_SIGNATURE_DATE", length = 19)
	public Timestamp getTumourSignatureDate() {
		return this.tumourSignatureDate;
	}

	public void setTumourSignatureDate(Timestamp tumourSignatureDate) {
		this.tumourSignatureDate = tumourSignatureDate;
	}

	@Column(name = "REVIEW_DATE", length = 19)
	public Timestamp getReviewDate() {
		return this.reviewDate;
	}

	public void setReviewDate(Timestamp reviewDate) {
		this.reviewDate = reviewDate;
	}

	@Column(name = "TUMOUR_INVESTIGATED_PERSON")
	public String getTumourInvestigatedPerson() {
		return this.tumourInvestigatedPerson;
	}

	public void setTumourInvestigatedPerson(String tumourInvestigatedPerson) {
		this.tumourInvestigatedPerson = tumourInvestigatedPerson;
	}

	@Column(name = "REVIEWPERSON")
	public String getReviewperson() {
		return this.reviewperson;
	}

	public void setReviewperson(String reviewperson) {
		this.reviewperson = reviewperson;
	}

	@Column(name = "TREATMENT")
	public String getTreatment() {
		return this.treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	@Column(name = "TRANFER_SITUATION")
	public String getTranferSituation() {
		return this.tranferSituation;
	}

	public void setTranferSituation(String tranferSituation) {
		this.tranferSituation = tranferSituation;
	}

	@Column(name = "ONCE_TREATMENT", length = 65535)
	public String getOnceTreatment() {
		return this.onceTreatment;
	}

	public void setOnceTreatment(String onceTreatment) {
		this.onceTreatment = onceTreatment;
	}

	@Column(name = "CURRENT_TREATMENT_SITUATION", length = 65535)
	public String getCurrentTreatmentSituation() {
		return this.currentTreatmentSituation;
	}

	public void setCurrentTreatmentSituation(String currentTreatmentSituation) {
		this.currentTreatmentSituation = currentTreatmentSituation;
	}

	@Column(name = "CANCER_FAMILY_HISTORY", length = 65535)
	public String getCancerFamilyHistory() {
		return this.cancerFamilyHistory;
	}

	public void setCancerFamilyHistory(String cancerFamilyHistory) {
		this.cancerFamilyHistory = cancerFamilyHistory;
	}

	@Column(name = "WITHDRAWAL_DATE")
	public String getWithdrawalDate() {
		return this.withdrawalDate;
	}

	public void setWithdrawalDate(String withdrawalDate) {
		this.withdrawalDate = withdrawalDate;
	}

	@Column(name = "WITHDRAWAL_REASON", length = 65535)
	public String getWithdrawalReason() {
		return this.withdrawalReason;
	}

	public void setWithdrawalReason(String withdrawalReason) {
		this.withdrawalReason = withdrawalReason;
	}

	@Column(name = "FIND_WAY")
	public String getFindWay() {
		return this.findWay;
	}

	public void setFindWay(String findWay) {
		this.findWay = findWay;
	}

	@Column(name = "REGISTRATION_WAY")
	public String getRegistrationWay() {
		return this.registrationWay;
	}

	public void setRegistrationWay(String registrationWay) {
		this.registrationWay = registrationWay;
	}

	@Column(name = "DIAGNOSIS_BASIS")
	public String getDiagnosisBasis() {
		return this.diagnosisBasis;
	}

	public void setDiagnosisBasis(String diagnosisBasis) {
		this.diagnosisBasis = diagnosisBasis;
	}

	@Column(name = "CYTOLOGY")
	public String getCytology() {
		return this.cytology;
	}

	public void setCytology(String cytology) {
		this.cytology = cytology;
	}

	@Column(name = "HYPHOLOGY")
	public String getHyphology() {
		return this.hyphology;
	}

	public void setHyphology(String hyphology) {
		this.hyphology = hyphology;
	}

	@Column(name = "TUMOUR_HISTOLOGICAL_TYPE")
	public String getTumourHistologicalType() {
		return this.tumourHistologicalType;
	}

	public void setTumourHistologicalType(String tumourHistologicalType) {
		this.tumourHistologicalType = tumourHistologicalType;
	}

	@Column(name = "BY_STAGE")
	public String getByStage() {
		return this.byStage;
	}

	public void setByStage(String byStage) {
		this.byStage = byStage;
	}

	@Column(name = "TUMOUR_FILE_DATE", length = 19)
	public Timestamp getTumourFileDate() {
		return this.tumourFileDate;
	}

	public void setTumourFileDate(Timestamp tumourFileDate) {
		this.tumourFileDate = tumourFileDate;
	}

	@Column(name = "TUMOUR_FILE_NAME")
	public String getTumourFileName() {
		return this.tumourFileName;
	}

	public void setTumourFileName(String tumourFileName) {
		this.tumourFileName = tumourFileName;
	}

	@Column(name = "TUMOUR_ONE", length = 1000)
	public String getTumourOne() {
		return this.tumourOne;
	}

	public void setTumourOne(String tumourOne) {
		this.tumourOne = tumourOne;
	}

	@Column(name = "TUMOUR_TWO", length = 1000)
	public String getTumourTwo() {
		return this.tumourTwo;
	}

	public void setTumourTwo(String tumourTwo) {
		this.tumourTwo = tumourTwo;
	}

	@Column(name = "TUMOUR_THREE", length = 1000)
	public String getTumourThree() {
		return this.tumourThree;
	}

	public void setTumourThree(String tumourThree) {
		this.tumourThree = tumourThree;
	}

	@Column(name = "TUMOUR_FOUR", length = 1000)
	public String getTumourFour() {
		return this.tumourFour;
	}

	public void setTumourFour(String tumourFour) {
		this.tumourFour = tumourFour;
	}

	@Column(name = "TUMOUR_FIVE", length = 1000)
	public String getTumourFive() {
		return this.tumourFive;
	}

	public void setTumourFive(String tumourFive) {
		this.tumourFive = tumourFive;
	}

	@Column(name = "CHRONIC_BRONCHIAL_DISEASE_DIAGNOSIS_DATE", length = 19)
	public Timestamp getChronicBronchialDiseaseDiagnosisDate() {
		return this.chronicBronchialDiseaseDiagnosisDate;
	}

	public void setChronicBronchialDiseaseDiagnosisDate(
			Timestamp chronicBronchialDiseaseDiagnosisDate) {
		this.chronicBronchialDiseaseDiagnosisDate = chronicBronchialDiseaseDiagnosisDate;
	}

	@Column(name = "DIAGNOSED_HOSPITAL")
	public String getDiagnosedHospital() {
		return this.diagnosedHospital;
	}

	public void setDiagnosedHospital(String diagnosedHospital) {
		this.diagnosedHospital = diagnosedHospital;
	}

	@Column(name = "ANNUAL_INCIDENCE")
	public Integer getAnnualIncidence() {
		return this.annualIncidence;
	}

	public void setAnnualIncidence(Integer annualIncidence) {
		this.annualIncidence = annualIncidence;
	}

	@Column(name = "EACH_TIME_TREATMENT")
	public String getEachTimeTreatment() {
		return this.eachTimeTreatment;
	}

	public void setEachTimeTreatment(String eachTimeTreatment) {
		this.eachTimeTreatment = eachTimeTreatment;
	}

	@Column(name = "MAIN_CAUSES_DISEASE", length = 65535)
	public String getMainCausesDisease() {
		return this.mainCausesDisease;
	}

	public void setMainCausesDisease(String mainCausesDisease) {
		this.mainCausesDisease = mainCausesDisease;
	}

	@Column(name = "COUGH_DEGREE")
	public String getCoughDegree() {
		return this.coughDegree;
	}

	public void setCoughDegree(String coughDegree) {
		this.coughDegree = coughDegree;
	}

	@Column(name = "COUGH_COLOR")
	public String getCoughColor() {
		return this.coughColor;
	}

	public void setCoughColor(String coughColor) {
		this.coughColor = coughColor;
	}

	@Column(name = "IS_ACCOMPANIED_WHEEZING")
	public String getIsAccompaniedWheezing() {
		return this.isAccompaniedWheezing;
	}

	public void setIsAccompaniedWheezing(String isAccompaniedWheezing) {
		this.isAccompaniedWheezing = isAccompaniedWheezing;
	}

	@Column(name = "ROUTINE_BLOOD_TEST")
	public String getRoutineBloodTest() {
		return this.routineBloodTest;
	}

	public void setRoutineBloodTest(String routineBloodTest) {
		this.routineBloodTest = routineBloodTest;
	}

	@Column(name = "X_RAY")
	public String getXRay() {
		return this.XRay;
	}

	public void setXRay(String XRay) {
		this.XRay = XRay;
	}

	@Column(name = "SPUTUM_SMEAR_CULTURE", length = 65535)
	public String getSputumSmearCulture() {
		return this.sputumSmearCulture;
	}

	public void setSputumSmearCulture(String sputumSmearCulture) {
		this.sputumSmearCulture = sputumSmearCulture;
	}

	@Column(name = "LUNG_FUNCTION_TEST", length = 65535)
	public String getLungFunctionTest() {
		return this.lungFunctionTest;
	}

	public void setLungFunctionTest(String lungFunctionTest) {
		this.lungFunctionTest = lungFunctionTest;
	}

	@Column(name = "CHRONIC_BRONCHIAL_DISEASE_COMPLICATION", length = 65535)
	public String getChronicBronchialDiseaseComplication() {
		return this.chronicBronchialDiseaseComplication;
	}

	public void setChronicBronchialDiseaseComplication(
			String chronicBronchialDiseaseComplication) {
		this.chronicBronchialDiseaseComplication = chronicBronchialDiseaseComplication;
	}

	@Column(name = "SELEF_BREATH", length = 65535)
	public String getSelefBreath() {
		return this.selefBreath;
	}

	public void setSelefBreath(String selefBreath) {
		this.selefBreath = selefBreath;
	}

	@Column(name = "HEART_CLASS", length = 65535)
	public String getHeartClass() {
		return this.heartClass;
	}

	public void setHeartClass(String heartClass) {
		this.heartClass = heartClass;
	}

	@Column(name = "CHRONIC_BRONCHIAL_DISEASE_REMARKS", length = 65535)
	public String getChronicBronchialDiseaseRemarks() {
		return this.chronicBronchialDiseaseRemarks;
	}

	public void setChronicBronchialDiseaseRemarks(
			String chronicBronchialDiseaseRemarks) {
		this.chronicBronchialDiseaseRemarks = chronicBronchialDiseaseRemarks;
	}

	@Column(name = "CHRONIC_BRONCHIAL_DISEASE_INVESTIGATED_PERSON")
	public String getChronicBronchialDiseaseInvestigatedPerson() {
		return this.chronicBronchialDiseaseInvestigatedPerson;
	}

	public void setChronicBronchialDiseaseInvestigatedPerson(
			String chronicBronchialDiseaseInvestigatedPerson) {
		this.chronicBronchialDiseaseInvestigatedPerson = chronicBronchialDiseaseInvestigatedPerson;
	}

	@Column(name = "CHRONIC_BRONCHIAL_DISEASE_FILE_DATE", length = 19)
	public Timestamp getChronicBronchialDiseaseFileDate() {
		return this.chronicBronchialDiseaseFileDate;
	}

	public void setChronicBronchialDiseaseFileDate(
			Timestamp chronicBronchialDiseaseFileDate) {
		this.chronicBronchialDiseaseFileDate = chronicBronchialDiseaseFileDate;
	}

	@Column(name = "CHRONIC_BRONCHIAL_DISEASE_FILE_NAME")
	public String getChronicBronchialDiseaseFileName() {
		return this.chronicBronchialDiseaseFileName;
	}

	public void setChronicBronchialDiseaseFileName(
			String chronicBronchialDiseaseFileName) {
		this.chronicBronchialDiseaseFileName = chronicBronchialDiseaseFileName;
	}

	@Column(name = "CHRONIC_BRONCHIAL_DISEASE_ONE", length = 1000)
	public String getChronicBronchialDiseaseOne() {
		return this.chronicBronchialDiseaseOne;
	}

	public void setChronicBronchialDiseaseOne(String chronicBronchialDiseaseOne) {
		this.chronicBronchialDiseaseOne = chronicBronchialDiseaseOne;
	}

	@Column(name = "CHRONIC_BRONCHIAL_DISEASE_TWO", length = 1000)
	public String getChronicBronchialDiseaseTwo() {
		return this.chronicBronchialDiseaseTwo;
	}

	public void setChronicBronchialDiseaseTwo(String chronicBronchialDiseaseTwo) {
		this.chronicBronchialDiseaseTwo = chronicBronchialDiseaseTwo;
	}

	@Column(name = "CHRONIC_BRONCHIAL_DISEASE_THREE", length = 1000)
	public String getChronicBronchialDiseaseThree() {
		return this.chronicBronchialDiseaseThree;
	}

	public void setChronicBronchialDiseaseThree(
			String chronicBronchialDiseaseThree) {
		this.chronicBronchialDiseaseThree = chronicBronchialDiseaseThree;
	}

	@Column(name = "CHRONIC_BRONCHIAL_DISEASE_FOUR", length = 1000)
	public String getChronicBronchialDiseaseFour() {
		return this.chronicBronchialDiseaseFour;
	}

	public void setChronicBronchialDiseaseFour(
			String chronicBronchialDiseaseFour) {
		this.chronicBronchialDiseaseFour = chronicBronchialDiseaseFour;
	}

	@Column(name = "CHRONIC_BRONCHIAL_DISEASE_FIVE", length = 1000)
	public String getChronicBronchialDiseaseFive() {
		return this.chronicBronchialDiseaseFive;
	}

	public void setChronicBronchialDiseaseFive(
			String chronicBronchialDiseaseFive) {
		this.chronicBronchialDiseaseFive = chronicBronchialDiseaseFive;
	}

	@Column(name = "RESIDUAL_VISION_GRADING")
	public String getResidualVisionGrading() {
		return this.residualVisionGrading;
	}

	public void setResidualVisionGrading(String residualVisionGrading) {
		this.residualVisionGrading = residualVisionGrading;
	}

	@Column(name = "VISION_DISABILITY_REASON", length = 65535)
	public String getVisionDisabilityReason() {
		return this.visionDisabilityReason;
	}

	public void setVisionDisabilityReason(String visionDisabilityReason) {
		this.visionDisabilityReason = visionDisabilityReason;
	}

	@Column(name = "VISUAL_IMPAIRMENT")
	public String getVisualImpairment() {
		return this.visualImpairment;
	}

	public void setVisualImpairment(String visualImpairment) {
		this.visualImpairment = visualImpairment;
	}

	@Column(name = "GRADING_OF_AUDITUS_DEFORMITY")
	public String getGradingOfAuditusDeformity() {
		return this.gradingOfAuditusDeformity;
	}

	public void setGradingOfAuditusDeformity(String gradingOfAuditusDeformity) {
		this.gradingOfAuditusDeformity = gradingOfAuditusDeformity;
	}

	@Column(name = "THE_HEARING_DISABILITY_REASON", length = 65535)
	public String getTheHearingDisabilityReason() {
		return this.theHearingDisabilityReason;
	}

	public void setTheHearingDisabilityReason(String theHearingDisabilityReason) {
		this.theHearingDisabilityReason = theHearingDisabilityReason;
	}

	@Column(name = "HEARING_DISORDER")
	public String getHearingDisorder() {
		return this.hearingDisorder;
	}

	public void setHearingDisorder(String hearingDisorder) {
		this.hearingDisorder = hearingDisorder;
	}

	@Column(name = "HEARING_AID")
	public Boolean getHearingAid() {
		return this.hearingAid;
	}

	public void setHearingAid(Boolean hearingAid) {
		this.hearingAid = hearingAid;
	}

	@Column(name = "SPEECH_RESIDUAL_CLASSIFICATION")
	public String getSpeechResidualClassification() {
		return this.speechResidualClassification;
	}

	public void setSpeechResidualClassification(
			String speechResidualClassification) {
		this.speechResidualClassification = speechResidualClassification;
	}

	@Column(name = "SPEECH_DISABILITY_REASON", length = 65535)
	public String getSpeechDisabilityReason() {
		return this.speechDisabilityReason;
	}

	public void setSpeechDisabilityReason(String speechDisabilityReason) {
		this.speechDisabilityReason = speechDisabilityReason;
	}

	@Column(name = "SPEECH_DISORDER")
	public String getSpeechDisorder() {
		return this.speechDisorder;
	}

	public void setSpeechDisorder(String speechDisorder) {
		this.speechDisorder = speechDisorder;
	}

	@Column(name = "INTELLIGENCE_RESIDUAL_CLASSIFICATION")
	public String getIntelligenceResidualClassification() {
		return this.intelligenceResidualClassification;
	}

	public void setIntelligenceResidualClassification(
			String intelligenceResidualClassification) {
		this.intelligenceResidualClassification = intelligenceResidualClassification;
	}

	@Column(name = "INTELLECTUAL_DISABILITY_REASON", length = 65535)
	public String getIntellectualDisabilityReason() {
		return this.intellectualDisabilityReason;
	}

	public void setIntellectualDisabilityReason(
			String intellectualDisabilityReason) {
		this.intellectualDisabilityReason = intellectualDisabilityReason;
	}

	@Column(name = "DYSGNOSIA")
	public String getDysgnosia() {
		return this.dysgnosia;
	}

	public void setDysgnosia(String dysgnosia) {
		this.dysgnosia = dysgnosia;
	}

	@Column(name = "BODY_RESIDUAL_CLASSIFICATION")
	public String getBodyResidualClassification() {
		return this.bodyResidualClassification;
	}

	public void setBodyResidualClassification(String bodyResidualClassification) {
		this.bodyResidualClassification = bodyResidualClassification;
	}

	@Column(name = "PHYSICAL_CAUSES", length = 65535)
	public String getPhysicalCauses() {
		return this.physicalCauses;
	}

	public void setPhysicalCauses(String physicalCauses) {
		this.physicalCauses = physicalCauses;
	}

	@Column(name = "MUTILATION")
	public String getMutilation() {
		return this.mutilation;
	}

	public void setMutilation(String mutilation) {
		this.mutilation = mutilation;
	}

	@Column(name = "BODY_RESIDUAL_CLASSIFICATIO")
	public String getBodyResidualClassificatio() {
		return this.bodyResidualClassificatio;
	}

	public void setBodyResidualClassificatio(String bodyResidualClassificatio) {
		this.bodyResidualClassificatio = bodyResidualClassificatio;
	}

	@Column(name = "PSYCHIATRIC_CLASSIFICATION")
	public String getPsychiatricClassification() {
		return this.psychiatricClassification;
	}

	public void setPsychiatricClassification(String psychiatricClassification) {
		this.psychiatricClassification = psychiatricClassification;
	}

	@Column(name = "CAUSES_MENTAL_ILLNESS", length = 65535)
	public String getCausesMentalIllness() {
		return this.causesMentalIllness;
	}

	public void setCausesMentalIllness(String causesMentalIllness) {
		this.causesMentalIllness = causesMentalIllness;
	}

	@Column(name = "PSYCHOGENY")
	public String getPsychogeny() {
		return this.psychogeny;
	}

	public void setPsychogeny(String psychogeny) {
		this.psychogeny = psychogeny;
	}

	@Column(name = "PSYCHIATRIC_DIAGNOSIS")
	public String getPsychiatricDiagnosis() {
		return this.psychiatricDiagnosis;
	}

	public void setPsychiatricDiagnosis(String psychiatricDiagnosis) {
		this.psychiatricDiagnosis = psychiatricDiagnosis;
	}

	@Column(name = "DIAGNOSE_ORGANIZATION")
	public String getDiagnoseOrganization() {
		return this.diagnoseOrganization;
	}

	public void setDiagnoseOrganization(String diagnoseOrganization) {
		this.diagnoseOrganization = diagnoseOrganization;
	}

	@Column(name = "WHETHE_DISABILITY")
	public Boolean getWhetheDisability() {
		return this.whetheDisability;
	}

	public void setWhetheDisability(Boolean whetheDisability) {
		this.whetheDisability = whetheDisability;
	}

	@Column(name = "WHETHE_GO_RECOVERY")
	public Boolean getWhetheGoRecovery() {
		return this.whetheGoRecovery;
	}

	public void setWhetheGoRecovery(Boolean whetheGoRecovery) {
		this.whetheGoRecovery = whetheGoRecovery;
	}

	@Column(name = "RECOVERY_ORGANIZATION", length = 65535)
	public String getRecoveryOrganization() {
		return this.recoveryOrganization;
	}

	public void setRecoveryOrganization(String recoveryOrganization) {
		this.recoveryOrganization = recoveryOrganization;
	}

	@Column(name = "NO_RECOVER_REASON")
	public String getNoRecoverReason() {
		return this.noRecoverReason;
	}

	public void setNoRecoverReason(String noRecoverReason) {
		this.noRecoverReason = noRecoverReason;
	}

	@Column(name = "REMARK", length = 65535)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "DISABILITY_OBSTACLE_SIGNATURE_DATE", length = 19)
	public Timestamp getDisabilityObstacleSignatureDate() {
		return this.disabilityObstacleSignatureDate;
	}

	public void setDisabilityObstacleSignatureDate(
			Timestamp disabilityObstacleSignatureDate) {
		this.disabilityObstacleSignatureDate = disabilityObstacleSignatureDate;
	}

	@Column(name = "CHECK_DATE", length = 19)
	public Timestamp getCheckDate() {
		return this.checkDate;
	}

	public void setCheckDate(Timestamp checkDate) {
		this.checkDate = checkDate;
	}

	@Column(name = "FILE_DATE", length = 19)
	public Timestamp getFileDate() {
		return this.fileDate;
	}

	public void setFileDate(Timestamp fileDate) {
		this.fileDate = fileDate;
	}

	@Column(name = "DISABILITY_OBSTACLE_FILE_NAME")
	public String getDisabilityObstacleFileName() {
		return this.disabilityObstacleFileName;
	}

	public void setDisabilityObstacleFileName(String disabilityObstacleFileName) {
		this.disabilityObstacleFileName = disabilityObstacleFileName;
	}

	@Column(name = "RESPONDENT")
	public String getRespondent() {
		return this.respondent;
	}

	public void setRespondent(String respondent) {
		this.respondent = respondent;
	}

	@Column(name = "CHECKER")
	public String getChecker() {
		return this.checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
	}

	@Column(name = "DISABILITY_OBSTACLE_ONE", length = 1000)
	public String getDisabilityObstacleOne() {
		return this.disabilityObstacleOne;
	}

	public void setDisabilityObstacleOne(String disabilityObstacleOne) {
		this.disabilityObstacleOne = disabilityObstacleOne;
	}

	@Column(name = "DISABILITY_OBSTACLE_TWO", length = 1000)
	public String getDisabilityObstacleTwo() {
		return this.disabilityObstacleTwo;
	}

	public void setDisabilityObstacleTwo(String disabilityObstacleTwo) {
		this.disabilityObstacleTwo = disabilityObstacleTwo;
	}

	@Column(name = "DISABILITY_OBSTACLE_THREE", length = 1000)
	public String getDisabilityObstacleThree() {
		return this.disabilityObstacleThree;
	}

	public void setDisabilityObstacleThree(String disabilityObstacleThree) {
		this.disabilityObstacleThree = disabilityObstacleThree;
	}

	@Column(name = "DISABILITY_OBSTACLE_FOUR", length = 1000)
	public String getDisabilityObstacleFour() {
		return this.disabilityObstacleFour;
	}

	public void setDisabilityObstacleFour(String disabilityObstacleFour) {
		this.disabilityObstacleFour = disabilityObstacleFour;
	}

	@Column(name = "DISABILITY_OBSTACLE_FIVE", length = 1000)
	public String getDisabilityObstacleFive() {
		return this.disabilityObstacleFive;
	}

	public void setDisabilityObstacleFive(String disabilityObstacleFive) {
		this.disabilityObstacleFive = disabilityObstacleFive;
	}

	@Column(name = "TEMPERATURE", precision = 22, scale = 0)
	public Double getTemperature() {
		return this.temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	@Column(name = "BREATHING_RATE")
	public Integer getBreathingRate() {
		return this.breathingRate;
	}

	public void setBreathingRate(Integer breathingRate) {
		this.breathingRate = breathingRate;
	}

	@Column(name = "DIASTOLIC_PRESSURE", precision = 22, scale = 0)
	public Double getDiastolicPressure() {
		return this.diastolicPressure;
	}

	public void setDiastolicPressure(Double diastolicPressure) {
		this.diastolicPressure = diastolicPressure;
	}

	@Column(name = "SYSTOLIC_PRESSURE", precision = 22, scale = 0)
	public Double getSystolicPressure() {
		return this.systolicPressure;
	}

	public void setSystolicPressure(Double systolicPressure) {
		this.systolicPressure = systolicPressure;
	}

	@Column(name = "PULSE_RATE")
	public Integer getPulseRate() {
		return this.pulseRate;
	}

	public void setPulseRate(Integer pulseRate) {
		this.pulseRate = pulseRate;
	}

	@Column(name = "HEIGHT", precision = 22, scale = 0)
	public Double getHeight() {
		return this.height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	@Column(name = "WEIGHT", precision = 22, scale = 0)
	public Double getWeight() {
		return this.weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	@Column(name = "BMI", precision = 22, scale = 0)
	public Double getBmi() {
		return this.bmi;
	}

	public void setBmi(Double bmi) {
		this.bmi = bmi;
	}

	@Column(name = "WAISTLINE", precision = 22, scale = 0)
	public Double getWaistline() {
		return this.waistline;
	}

	public void setWaistline(Double waistline) {
		this.waistline = waistline;
	}

	@Column(name = "HIP", precision = 22, scale = 0)
	public Double getHip() {
		return this.hip;
	}

	public void setHip(Double hip) {
		this.hip = hip;
	}

	@Column(name = "RATIO", precision = 22, scale = 0)
	public Double getRatio() {
		return this.ratio;
	}

	public void setRatio(Double ratio) {
		this.ratio = ratio;
	}

	@Column(name = "HEALTH_ASSESSMENT", length = 65535)
	public String getHealthAssessment() {
		return this.healthAssessment;
	}

	public void setHealthAssessment(String healthAssessment) {
		this.healthAssessment = healthAssessment;
	}

	@Column(name = "SELF_ASSESSMENT", length = 65535)
	public String getSelfAssessment() {
		return this.selfAssessment;
	}

	public void setSelfAssessment(String selfAssessment) {
		this.selfAssessment = selfAssessment;
	}

	@Column(name = "COGNITIVE_FUNCTION", length = 65535)
	public String getCognitiveFunction() {
		return this.cognitiveFunction;
	}

	public void setCognitiveFunction(String cognitiveFunction) {
		this.cognitiveFunction = cognitiveFunction;
	}

	@Column(name = "EMOTION", length = 1000)
	public String getEmotion() {
		return this.emotion;
	}

	public void setEmotion(String emotion) {
		this.emotion = emotion;
	}

	@Column(name = "GENERAL_CONDITION_ONE", length = 1000)
	public String getGeneralConditionOne() {
		return this.generalConditionOne;
	}

	public void setGeneralConditionOne(String generalConditionOne) {
		this.generalConditionOne = generalConditionOne;
	}

	@Column(name = "GENERAL_CONDITION_TWO", length = 1000)
	public String getGeneralConditionTwo() {
		return this.generalConditionTwo;
	}

	public void setGeneralConditionTwo(String generalConditionTwo) {
		this.generalConditionTwo = generalConditionTwo;
	}

	@Column(name = "GENERAL_CONDITION_THREE", length = 1000)
	public String getGeneralConditionThree() {
		return this.generalConditionThree;
	}

	public void setGeneralConditionThree(String generalConditionThree) {
		this.generalConditionThree = generalConditionThree;
	}

	@Column(name = "GENERAL_CONDITION_FOUR", length = 1000)
	public String getGeneralConditionFour() {
		return this.generalConditionFour;
	}

	public void setGeneralConditionFour(String generalConditionFour) {
		this.generalConditionFour = generalConditionFour;
	}

	@Column(name = "GENERAL_CONDITION_FIVE", length = 1000)
	public String getGeneralConditionFive() {
		return this.generalConditionFive;
	}

	public void setGeneralConditionFive(String generalConditionFive) {
		this.generalConditionFive = generalConditionFive;
	}

	@Column(name = "EXERCISE_FREQUENCY")
	public String getExerciseFrequency() {
		return this.exerciseFrequency;
	}

	public void setExerciseFrequency(String exerciseFrequency) {
		this.exerciseFrequency = exerciseFrequency;
	}

	@Column(name = "EXERCISE_TIME")
	public String getExerciseTime() {
		return this.exerciseTime;
	}

	public void setExerciseTime(String exerciseTime) {
		this.exerciseTime = exerciseTime;
	}

	@Column(name = "ALL_EXERCISE_TIME")
	public String getAllExerciseTime() {
		return this.allExerciseTime;
	}

	public void setAllExerciseTime(String allExerciseTime) {
		this.allExerciseTime = allExerciseTime;
	}

	@Column(name = "LIFE_STYLE_EXERCISE_TYPE")
	public String getLifeStyleExerciseType() {
		return this.lifeStyleExerciseType;
	}

	public void setLifeStyleExerciseType(String lifeStyleExerciseType) {
		this.lifeStyleExerciseType = lifeStyleExerciseType;
	}

	@Column(name = "DIETARY_HABIT")
	public String getDietaryHabit() {
		return this.dietaryHabit;
	}

	public void setDietaryHabit(String dietaryHabit) {
		this.dietaryHabit = dietaryHabit;
	}

	@Column(name = "SMOKING_STATUS")
	public String getSmokingStatus() {
		return this.smokingStatus;
	}

	public void setSmokingStatus(String smokingStatus) {
		this.smokingStatus = smokingStatus;
	}

	@Column(name = "SMOKING_ONEDAY", precision = 22, scale = 0)
	public Double getSmokingOneday() {
		return this.smokingOneday;
	}

	public void setSmokingOneday(Double smokingOneday) {
		this.smokingOneday = smokingOneday;
	}

	@Column(name = "STARTSMOKING_AGE")
	public Integer getStartsmokingAge() {
		return this.startsmokingAge;
	}

	public void setStartsmokingAge(Integer startsmokingAge) {
		this.startsmokingAge = startsmokingAge;
	}

	@Column(name = "GIVEUP_SMOKING_AGE")
	public Integer getGiveupSmokingAge() {
		return this.giveupSmokingAge;
	}

	public void setGiveupSmokingAge(Integer giveupSmokingAge) {
		this.giveupSmokingAge = giveupSmokingAge;
	}

	@Column(name = "DRINKING_FREQUENCY")
	public String getDrinkingFrequency() {
		return this.drinkingFrequency;
	}

	public void setDrinkingFrequency(String drinkingFrequency) {
		this.drinkingFrequency = drinkingFrequency;
	}

	@Column(name = "MONTHLY_DRINKING", precision = 22, scale = 0)
	public Double getMonthlyDrinking() {
		return this.monthlyDrinking;
	}

	public void setMonthlyDrinking(Double monthlyDrinking) {
		this.monthlyDrinking = monthlyDrinking;
	}

	@Column(name = "ABSTINENCE")
	public String getAbstinence() {
		return this.abstinence;
	}

	public void setAbstinence(String abstinence) {
		this.abstinence = abstinence;
	}

	@Column(name = "START_DRINKING_AGE")
	public Integer getStartDrinkingAge() {
		return this.startDrinkingAge;
	}

	public void setStartDrinkingAge(Integer startDrinkingAge) {
		this.startDrinkingAge = startDrinkingAge;
	}

	@Column(name = "RECENTLY_YEAR_DRINKING")
	public Boolean getRecentlyYearDrinking() {
		return this.recentlyYearDrinking;
	}

	public void setRecentlyYearDrinking(Boolean recentlyYearDrinking) {
		this.recentlyYearDrinking = recentlyYearDrinking;
	}

	@Column(name = "LIFE_STYLE_DRINKING_TYPE")
	public String getLifeStyleDrinkingType() {
		return this.lifeStyleDrinkingType;
	}

	public void setLifeStyleDrinkingType(String lifeStyleDrinkingType) {
		this.lifeStyleDrinkingType = lifeStyleDrinkingType;
	}

	@Column(name = "OCCUPATIONAL_DISEASE", length = 65535)
	public String getOccupationalDisease() {
		return this.occupationalDisease;
	}

	public void setOccupationalDisease(String occupationalDisease) {
		this.occupationalDisease = occupationalDisease;
	}

	@Column(name = "TYPE_WORK")
	public String getTypeWork() {
		return this.typeWork;
	}

	public void setTypeWork(String typeWork) {
		this.typeWork = typeWork;
	}

	@Column(name = "YEAR", length = 19)
	public Timestamp getYear() {
		return this.year;
	}

	public void setYear(Timestamp year) {
		this.year = year;
	}

	@Column(name = "DUST")
	public String getDust() {
		return this.dust;
	}

	public void setDust(String dust) {
		this.dust = dust;
	}

	@Column(name = "DUST_FENCE")
	public String getDustFence() {
		return this.dustFence;
	}

	public void setDustFence(String dustFence) {
		this.dustFence = dustFence;
	}

	@Column(name = "CHEMICAL_SUBSTANCES")
	public String getChemicalSubstances() {
		return this.chemicalSubstances;
	}

	public void setChemicalSubstances(String chemicalSubstances) {
		this.chemicalSubstances = chemicalSubstances;
	}

	@Column(name = "CH_SUB_FENCE")
	public String getChSubFence() {
		return this.chSubFence;
	}

	public void setChSubFence(String chSubFence) {
		this.chSubFence = chSubFence;
	}

	@Column(name = "RADIOGEN")
	public String getRadiogen() {
		return this.radiogen;
	}

	public void setRadiogen(String radiogen) {
		this.radiogen = radiogen;
	}

	@Column(name = "RADIOGEN_FENCE")
	public String getRadiogenFence() {
		return this.radiogenFence;
	}

	public void setRadiogenFence(String radiogenFence) {
		this.radiogenFence = radiogenFence;
	}

	@Column(name = "PHYSICAL_FACTOR")
	public String getPhysicalFactor() {
		return this.physicalFactor;
	}

	public void setPhysicalFactor(String physicalFactor) {
		this.physicalFactor = physicalFactor;
	}

	@Column(name = "PHYSICAL_FACTOR_FENCE")
	public String getPhysicalFactorFence() {
		return this.physicalFactorFence;
	}

	public void setPhysicalFactorFence(String physicalFactorFence) {
		this.physicalFactorFence = physicalFactorFence;
	}

	@Column(name = "OTHER", length = 65535)
	public String getOther() {
		return this.other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	@Column(name = "OTHER_FENCE", length = 65535)
	public String getOtherFence() {
		return this.otherFence;
	}

	public void setOtherFence(String otherFence) {
		this.otherFence = otherFence;
	}

	@Column(name = "LIFE_STYLE_ONE", length = 1000)
	public String getLifeStyleOne() {
		return this.lifeStyleOne;
	}

	public void setLifeStyleOne(String lifeStyleOne) {
		this.lifeStyleOne = lifeStyleOne;
	}

	@Column(name = "LIFE_STYLE_TWO", length = 1000)
	public String getLifeStyleTwo() {
		return this.lifeStyleTwo;
	}

	public void setLifeStyleTwo(String lifeStyleTwo) {
		this.lifeStyleTwo = lifeStyleTwo;
	}

	@Column(name = "LIFE_STYLE_THREE", length = 1000)
	public String getLifeStyleThree() {
		return this.lifeStyleThree;
	}

	public void setLifeStyleThree(String lifeStyleThree) {
		this.lifeStyleThree = lifeStyleThree;
	}

	@Column(name = "LIFE_STYLE_FOUR", length = 1000)
	public String getLifeStyleFour() {
		return this.lifeStyleFour;
	}

	public void setLifeStyleFour(String lifeStyleFour) {
		this.lifeStyleFour = lifeStyleFour;
	}

	@Column(name = "LIFE_STYLE_FIVE", length = 1000)
	public String getLifeStyleFive() {
		return this.lifeStyleFive;
	}

	public void setLifeStyleFive(String lifeStyleFive) {
		this.lifeStyleFive = lifeStyleFive;
	}

	@Column(name = "FBG", precision = 22, scale = 0)
	public Double getFbg() {
		return this.fbg;
	}

	public void setFbg(Double fbg) {
		this.fbg = fbg;
	}

	@Column(name = "GLYCATED_HEMOGLOBIN", precision = 22, scale = 0)
	public Double getGlycatedHemoglobin() {
		return this.glycatedHemoglobin;
	}

	public void setGlycatedHemoglobin(Double glycatedHemoglobin) {
		this.glycatedHemoglobin = glycatedHemoglobin;
	}

	@Column(name = "HBSAG")
	public String getHbsag() {
		return this.hbsag;
	}

	public void setHbsag(String hbsag) {
		this.hbsag = hbsag;
	}

	@Column(name = "HEMOGLOBIN", precision = 22, scale = 0)
	public Double getHemoglobin() {
		return this.hemoglobin;
	}

	public void setHemoglobin(Double hemoglobin) {
		this.hemoglobin = hemoglobin;
	}

	@Column(name = "LEUKOCYTE", precision = 22, scale = 0)
	public Double getLeukocyte() {
		return this.leukocyte;
	}

	public void setLeukocyte(Double leukocyte) {
		this.leukocyte = leukocyte;
	}

	@Column(name = "PLATELET", precision = 22, scale = 0)
	public Double getPlatelet() {
		return this.platelet;
	}

	public void setPlatelet(Double platelet) {
		this.platelet = platelet;
	}

	@Column(name = "OTHERS_RB", length = 65535)
	public String getOthersRb() {
		return this.othersRb;
	}

	public void setOthersRb(String othersRb) {
		this.othersRb = othersRb;
	}

	@Column(name = "URINE_PROTEIN")
	public String getUrineProtein() {
		return this.urineProtein;
	}

	public void setUrineProtein(String urineProtein) {
		this.urineProtein = urineProtein;
	}

	@Column(name = "URINE_GLUCOSE")
	public String getUrineGlucose() {
		return this.urineGlucose;
	}

	public void setUrineGlucose(String urineGlucose) {
		this.urineGlucose = urineGlucose;
	}

	@Column(name = "KETONE")
	public String getKetone() {
		return this.ketone;
	}

	public void setKetone(String ketone) {
		this.ketone = ketone;
	}

	@Column(name = "ERY")
	public String getEry() {
		return this.ery;
	}

	public void setEry(String ery) {
		this.ery = ery;
	}

	@Column(name = "OTHERS_RU", length = 65535)
	public String getOthersRu() {
		return this.othersRu;
	}

	public void setOthersRu(String othersRu) {
		this.othersRu = othersRu;
	}

	@Column(name = "MAU", precision = 22, scale = 0)
	public Double getMau() {
		return this.mau;
	}

	public void setMau(Double mau) {
		this.mau = mau;
	}

	@Column(name = "SED_OCCULT_BLOOD")
	public Boolean getSedOccultBlood() {
		return this.sedOccultBlood;
	}

	public void setSedOccultBlood(Boolean sedOccultBlood) {
		this.sedOccultBlood = sedOccultBlood;
	}

	@Column(name = "SERUM_ALANINE_AMINO_ACID", precision = 22, scale = 0)
	public Double getSerumAlanineAminoAcid() {
		return this.serumAlanineAminoAcid;
	}

	public void setSerumAlanineAminoAcid(Double serumAlanineAminoAcid) {
		this.serumAlanineAminoAcid = serumAlanineAminoAcid;
	}

	@Column(name = "SERUM_ASPERTATE_AMINO_ACID", precision = 22, scale = 0)
	public Double getSerumAspertateAminoAcid() {
		return this.serumAspertateAminoAcid;
	}

	public void setSerumAspertateAminoAcid(Double serumAspertateAminoAcid) {
		this.serumAspertateAminoAcid = serumAspertateAminoAcid;
	}

	@Column(name = "ALBUMIN", precision = 22, scale = 0)
	public Double getAlbumin() {
		return this.albumin;
	}

	public void setAlbumin(Double albumin) {
		this.albumin = albumin;
	}

	@Column(name = "TBIL", precision = 22, scale = 0)
	public Double getTbil() {
		return this.tbil;
	}

	public void setTbil(Double tbil) {
		this.tbil = tbil;
	}

	@Column(name = "DBIL", precision = 22, scale = 0)
	public Double getDbil() {
		return this.dbil;
	}

	public void setDbil(Double dbil) {
		this.dbil = dbil;
	}

	@Column(name = "CR", precision = 22, scale = 0)
	public Double getCr() {
		return this.cr;
	}

	public void setCr(Double cr) {
		this.cr = cr;
	}

	@Column(name = "BUN", precision = 22, scale = 0)
	public Double getBun() {
		return this.bun;
	}

	public void setBun(Double bun) {
		this.bun = bun;
	}

	@Column(name = "SERUM_POTASSIUM_LEVEL", precision = 22, scale = 0)
	public Double getSerumPotassiumLevel() {
		return this.serumPotassiumLevel;
	}

	public void setSerumPotassiumLevel(Double serumPotassiumLevel) {
		this.serumPotassiumLevel = serumPotassiumLevel;
	}

	@Column(name = "SERUM_NATRIUM_LEVEL", precision = 22, scale = 0)
	public Double getSerumNatriumLevel() {
		return this.serumNatriumLevel;
	}

	public void setSerumNatriumLevel(Double serumNatriumLevel) {
		this.serumNatriumLevel = serumNatriumLevel;
	}

	@Column(name = "TOTAL_CHOLESTEROL", precision = 22, scale = 0)
	public Double getTotalCholesterol() {
		return this.totalCholesterol;
	}

	public void setTotalCholesterol(Double totalCholesterol) {
		this.totalCholesterol = totalCholesterol;
	}

	@Column(name = "LDL_C", precision = 22, scale = 0)
	public Double getLdlC() {
		return this.ldlC;
	}

	public void setLdlC(Double ldlC) {
		this.ldlC = ldlC;
	}

	@Column(name = "TRIGLYCERIDE", precision = 22, scale = 0)
	public Double getTriglyceride() {
		return this.triglyceride;
	}

	public void setTriglyceride(Double triglyceride) {
		this.triglyceride = triglyceride;
	}

	@Column(name = "HDL_C", precision = 22, scale = 0)
	public Double getHdlC() {
		return this.hdlC;
	}

	public void setHdlC(Double hdlC) {
		this.hdlC = hdlC;
	}

	@Column(name = "PAP_SMEAR")
	public String getPapSmear() {
		return this.papSmear;
	}

	public void setPapSmear(String papSmear) {
		this.papSmear = papSmear;
	}

	@Column(name = "ECG")
	public String getEcg() {
		return this.ecg;
	}

	public void setEcg(String ecg) {
		this.ecg = ecg;
	}

	@Column(name = "CHEST_X_RAY")
	public String getChestXRay() {
		return this.chestXRay;
	}

	public void setChestXRay(String chestXRay) {
		this.chestXRay = chestXRay;
	}

	@Column(name = "B_SCAN_ULTRASONOGRAPHY")
	public String getBScanUltrasonography() {
		return this.BScanUltrasonography;
	}

	public void setBScanUltrasonography(String BScanUltrasonography) {
		this.BScanUltrasonography = BScanUltrasonography;
	}

	@Column(name = "OTHERS", length = 65535)
	public String getOthers() {
		return this.others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	@Column(name = "AUXILIARY_EXAMINATION_ONE", length = 1000)
	public String getAuxiliaryExaminationOne() {
		return this.auxiliaryExaminationOne;
	}

	public void setAuxiliaryExaminationOne(String auxiliaryExaminationOne) {
		this.auxiliaryExaminationOne = auxiliaryExaminationOne;
	}

	@Column(name = "AUXILIARY_EXAMINATION_TWO", length = 1000)
	public String getAuxiliaryExaminationTwo() {
		return this.auxiliaryExaminationTwo;
	}

	public void setAuxiliaryExaminationTwo(String auxiliaryExaminationTwo) {
		this.auxiliaryExaminationTwo = auxiliaryExaminationTwo;
	}

	@Column(name = "AUXILIARY_EXAMINATION_THREE", length = 1000)
	public String getAuxiliaryExaminationThree() {
		return this.auxiliaryExaminationThree;
	}

	public void setAuxiliaryExaminationThree(String auxiliaryExaminationThree) {
		this.auxiliaryExaminationThree = auxiliaryExaminationThree;
	}

	@Column(name = "AUXILIARY_EXAMINATION_FOUR", length = 1000)
	public String getAuxiliaryExaminationFour() {
		return this.auxiliaryExaminationFour;
	}

	public void setAuxiliaryExaminationFour(String auxiliaryExaminationFour) {
		this.auxiliaryExaminationFour = auxiliaryExaminationFour;
	}

	@Column(name = "AUXILIARY_EXAMINATION_FIVE", length = 1000)
	public String getAuxiliaryExaminationFive() {
		return this.auxiliaryExaminationFive;
	}

	public void setAuxiliaryExaminationFive(String auxiliaryExaminationFive) {
		this.auxiliaryExaminationFive = auxiliaryExaminationFive;
	}

	@Column(name = "CHEMOTHERAPY_HOSPITAL", length = 65535)
	public String getChemotherapyHospital() {
		return this.chemotherapyHospital;
	}

	public void setChemotherapyHospital(String chemotherapyHospital) {
		this.chemotherapyHospital = chemotherapyHospital;
	}

	@Column(name = "RADIOTHERAPY_HOSPITAL", length = 65535)
	public String getRadiotherapyHospital() {
		return this.radiotherapyHospital;
	}

	public void setRadiotherapyHospital(String radiotherapyHospital) {
		this.radiotherapyHospital = radiotherapyHospital;
	}

	@Column(name = "SURGICAL_HOSPITAL", length = 65535)
	public String getSurgicalHospital() {
		return this.surgicalHospital;
	}

	public void setSurgicalHospital(String surgicalHospital) {
		this.surgicalHospital = surgicalHospital;
	}

	@Column(name = "OPERATE_TIME", length = 19)
	public Timestamp getOperateTime() {
		return this.operateTime;
	}

	public void setOperateTime(Timestamp operateTime) {
		this.operateTime = operateTime;
	}

	@Column(name = "OPERATE_HOSPITAL", length = 65535)
	public String getOperateHospital() {
		return this.operateHospital;
	}

	public void setOperateHospital(String operateHospital) {
		this.operateHospital = operateHospital;
	}

	@Column(name = "ADMISSION_NUM")
	public String getAdmissionNum() {
		return this.admissionNum;
	}

	public void setAdmissionNum(String admissionNum) {
		this.admissionNum = admissionNum;
	}

	@Column(name = "OPERATE_PROPERTY")
	public String getOperateProperty() {
		return this.operateProperty;
	}

	public void setOperateProperty(String operateProperty) {
		this.operateProperty = operateProperty;
	}

	@Column(name = "FIRST_TIME", length = 19)
	public Timestamp getFirstTime() {
		return this.firstTime;
	}

	public void setFirstTime(Timestamp firstTime) {
		this.firstTime = firstTime;
	}

	@Column(name = "SECOND_TIME", length = 19)
	public Timestamp getSecondTime() {
		return this.secondTime;
	}

	public void setSecondTime(Timestamp secondTime) {
		this.secondTime = secondTime;
	}

	@Column(name = "THIRD_TIME", length = 19)
	public Timestamp getThirdTime() {
		return this.thirdTime;
	}

	public void setThirdTime(Timestamp thirdTime) {
		this.thirdTime = thirdTime;
	}

	@Column(name = "CHANGE_DATE", length = 19)
	public Timestamp getChangeDate() {
		return this.changeDate;
	}

	public void setChangeDate(Timestamp changeDate) {
		this.changeDate = changeDate;
	}

	@Column(name = "CHANGE_DEPARTMENT")
	public String getChangeDepartment() {
		return this.changeDepartment;
	}

	public void setChangeDepartment(String changeDepartment) {
		this.changeDepartment = changeDepartment;
	}

	@Column(name = "DEATH_ADDRESS")
	public String getDeathAddress() {
		return this.deathAddress;
	}

	public void setDeathAddress(String deathAddress) {
		this.deathAddress = deathAddress;
	}

	@Column(name = "DEATH_REASON")
	public String getDeathReason() {
		return this.deathReason;
	}

	public void setDeathReason(String deathReason) {
		this.deathReason = deathReason;
	}

	@Column(name = "DEATH_DATE", length = 19)
	public Timestamp getDeathDate() {
		return this.deathDate;
	}

	public void setDeathDate(Timestamp deathDate) {
		this.deathDate = deathDate;
	}

	@Column(name = "T_TUMOUR_YEAR")
	public String getTTumourYear() {
		return this.TTumourYear;
	}

	public void setTTumourYear(String TTumourYear) {
		this.TTumourYear = TTumourYear;
	}

	@Column(name = "MOUNTH")
	public String getMounth() {
		return this.mounth;
	}

	public void setMounth(String mounth) {
		this.mounth = mounth;
	}

	@Column(name = "LIFE_ID")
	public Integer getLifeId() {
		return this.lifeId;
	}

	public void setLifeId(Integer lifeId) {
		this.lifeId = lifeId;
	}

	@Column(name = "AUXILIARY_EXAMINATION_ID")
	public Integer getAuxiliaryExaminationId() {
		return this.auxiliaryExaminationId;
	}

	public void setAuxiliaryExaminationId(Integer auxiliaryExaminationId) {
		this.auxiliaryExaminationId = auxiliaryExaminationId;
	}

	@Column(name = "GENERAL_CONDITION_ID")
	public Integer getGeneralConditionId() {
		return this.generalConditionId;
	}

	public void setGeneralConditionId(Integer generalConditionId) {
		this.generalConditionId = generalConditionId;
	}

	@Column(name = "G_ID")
	public Integer getGId() {
		return this.GId;
	}

	public void setGId(Integer GId) {
		this.GId = GId;
	}

}