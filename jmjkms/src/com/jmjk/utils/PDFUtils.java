package com.jmjk.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

/**
 * 程序操作pdf工具类
 *
 */
public class PDFUtils {
	
	/**
	 * 向pdf中写入程序数据
	 * @param pdfFormFile       pdf模板路径（被写入数据pdf路径）
	 * @param fields            需要写入的数据字段名称
	 * @param aimPdfPath        数据写入pdf后，新pdf保存路径
	 * @param healthFileName    健康档案编号，新pdf文件名
	 * @return
	 */
	public static String fromPDFTempletToPdfWithValue(String pdfFormFile,
			Map<String, String> fields, String aimPdfPath, int healthFileName) {

		String path = "";// 目标pdf的路径
		String formFileName = ""; //
		String font_path = "";// 字体的路径
		try {
			path = ServletActionContext.getServletContext().getRealPath(
					aimPdfPath);
			formFileName = ServletActionContext.getServletContext()
					.getRealPath(pdfFormFile);
			font_path = ServletActionContext.getServletContext().getRealPath(
					"/font");
		} catch (Exception e) {
			try {
				path = ServletActionContext.getServletContext().getRealPath(
						aimPdfPath);
				formFileName = ServletActionContext.getServletContext()
						.getRealPath(pdfFormFile);
				font_path = ServletActionContext.getServletContext()
						.getRealPath("/font");
			} catch (Exception f) {
			}
		}
		
		//获取当前时间为文件夹名
		long currentTime = System.currentTimeMillis();
		Date date = new Date(currentTime);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		
		
		//Linux服务器需要将路径符号转换为'/'
		path = path.replace('\\', '/');
		
		//增加系统时间的文件夹
		path += "/" + dateFormat.format(date);

		String output = path + File.separatorChar + healthFileName + ".pdf";	
		
		try {
			// 检测文件夹是否存在,不存在，则建立文件夹
			File file = new File(path);
			if (!file.exists()) {
				file.mkdirs();
			}
			PdfReader reader = new PdfReader(formFileName);			
			FileOutputStream fos = new FileOutputStream(output);
			PdfStamper ps = new PdfStamper(reader, fos);			
			AcroFields s = ps.getAcroFields();
			BaseFont bf = BaseFont.createFont(font_path + File.separatorChar
					+ "simsun.ttc,1", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			s.addSubstitutionFont(bf);
			Font font = new Font(bf, 12, Font.UNDERLINE);
			for (String key : fields.keySet()) {
				s.setFieldProperty(key, "textfont", bf, null);
				s.setFieldProperty(key, "textsize", 12f, null);
				s.setField(key, fields.get(key));
			}
			ps.setFormFlattening(false);
			ps.close();
			reader.close();
			fos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (IOException | DocumentException e) {
			e.printStackTrace();
			System.out.println(((Throwable) e).getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			// doc.close();

		}
		return output;
	}

}
