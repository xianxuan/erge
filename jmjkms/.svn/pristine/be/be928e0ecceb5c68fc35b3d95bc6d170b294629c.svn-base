package com.jmjk.iservice;

import java.util.List;

import com.jmjk.entity.TFileMedicalRecord;

public interface IFileMedicalRecordService {
	/***
	 * 添加用药记录子表
	 * @param fileMedicalRecord
	 */
	public void saveFileMedicalRecord(TFileMedicalRecord fileMedicalRecord);
	/**
	 * 删除用药记录子表
	 * @param fileMedicalRecordId
	 */
	public void deleteFileMedicalRecord(int hFileid);
	/**
	 * 根据健康档案id得到对应的所有用药记录子表
	 * @param hFileId
	 * @return
	 */
	public List<TFileMedicalRecord> getFileMedicalRecordList(int hFileId);
}
