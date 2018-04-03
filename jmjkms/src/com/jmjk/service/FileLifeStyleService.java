package com.jmjk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jmjk.dao.FileLifeStyleDao;
import com.jmjk.entity.TFileLifeStyle;
import com.jmjk.iservice.IFileLifeStyleService;
@Controller("fileLifeStyleService")
public class FileLifeStyleService implements IFileLifeStyleService{
	@Autowired
	private  FileLifeStyleDao fileLifeStyleDao ;

	@Override
	public void saveFileLifeStyle(TFileLifeStyle fileLifeStyle) {
		fileLifeStyleDao.Save(fileLifeStyle);
		
	}

	@Override
	public void deleteFileLifeStyle(int hFileid) {
		String hql="delete from TFileLifeStyle tp where tp.THealthFile.healthFileId="+hFileid;
		fileLifeStyleDao.delete(hql);
		
	}

	@Override
	public TFileLifeStyle getFileLifeStyleByhealthID(int hFileId) {
		String hql="from TFileLifeStyle tp where  tp.THealthFile.healthFileId="+hFileId;
		return fileLifeStyleDao.Get(hql);
	}
	@Override
	public List<TFileLifeStyle> getFileLifeStyleListByhealthID(int hFileId) {
		String hql="from TFileLifeStyle tp where  tp.THealthFile.healthFileId="+hFileId;
		return fileLifeStyleDao.find(hql);
	}
}
