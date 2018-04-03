package com.jmjk.utils;

import java.util.List;

import com.jmjk.entity.THealthFile;
import com.jmjk.entity.TMedicalPayMethod;
import com.jmjk.entity.TPastHistory;

/**
 *  用来暂存健康档案盒健康档案所对应的付费方式和
 * @author 刘凤双
 *
 */
public class AllInfoBean {
	
	private int isError = -1; //是否出错
	private int X = -1; //错X行
	private int Y = -1; //错Y列
	private THealthFile heathFile;  //一个健康档案实体
	private List<TPastHistory> pasts;  //既往史实体列表,跟随这个档案实体的
	private TMedicalPayMethod medicalPay;  //医疗付费方式  , 跟随这个档案实体的
	
	public int getIsError() {
		return isError;
	}

	public void setIsError(int isError) {
		this.isError = isError;
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}



	public THealthFile getHeathFile() {
		return heathFile;
	}

	public void setHeathFile(THealthFile heathFile) {
		this.heathFile = heathFile;
	}

	public List<TPastHistory> getPasts() {
		return pasts;
	}

	public void setPasts(List<TPastHistory> pasts) {
		this.pasts = pasts;
	}

	public TMedicalPayMethod getMedicalPay() {
		return medicalPay;
	}

	public void setMedicalPay(TMedicalPayMethod medicalPay) {
		this.medicalPay = medicalPay;
	}

	public AllInfoBean(){}
	
}
