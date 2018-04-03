package com.jmjk.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

/**
 *  上传下载方法
 * @author 张晓光
 *
 */
public class UploadAndDownload {
	/**
	 * 文件上传,上传单个文件(可以上传图片或者其他)
	 * 
	 * @param upload
	 *            从前台获取参数
	 * @param uploadFileName
	 *            从前台获取参数
	 * @param savaPartPath
	 *            最终保存在服务其上的路径参数的一部分,例如 /jsp/images/test/
	 * @return
	 */

	public static String upload(File upload, String uploadFileName,
			String savaPartPath) {
		int size = (int) (upload.length() / 1024) + 1;
		if (size <= 1024*100) {
			String fileType = uploadFileName.substring(uploadFileName
					.lastIndexOf("."));
			String path = upload.getPath();
			String fileName = upload.getName();
			String uploadContentType = fileName.substring(fileName
					.lastIndexOf(".") + 1);
			Random r = new Random();
			int n = r.nextInt(900) + 100;
			String uploadPath = ""
					+ savaPartPath
					+ TypeConverter.convertDate2String(Calendar.getInstance()
							.getTime(), "yyyyMMddHHmmss") + n;

			HttpServletRequest request = ServletActionContext.getRequest();
			String realPath = request.getSession().getServletContext()
					.getRealPath(uploadPath);
			File file = new File(realPath);
			if (!file.exists()) {
				file.mkdirs();
			}
			String fn = "";
			uploadFileName = TypeConverter.convertDate2String(Calendar
					.getInstance().getTime(), "yyyyMMddHHmmss")
					+ n + fileType;
			fn = realPath + File.separator + uploadFileName;
			String filePath = uploadPath + "/" + uploadFileName;
			String filePos = filePath.substring(1);

			FileOutputStream fos = null;
			InputStream is = null;
			try {
				fos = new FileOutputStream(fn);

				is = new FileInputStream(upload);
				byte[] buffer = new byte[8192];
				int count = 0;
				while ((count = is.read(buffer)) > 0) {
					fos.write(buffer, 0, count);
				}
			} catch (Exception e) {
			} finally {
				try {
					fos.close();
					is.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return filePos;
		} 
		else {
			return "error";
		}
	}
		
		
public static String uploadImage(File upload,String uploadFileName,String savaPartPath) {
			
			String fileType = uploadFileName.substring(uploadFileName.lastIndexOf(".")); 
			String path = upload.getPath();
			String fileName=upload.getName();
			String uploadContentType=fileName.substring(fileName.lastIndexOf(".")+1);
			List<String> allowTypesList= new ArrayList<String>();
			allowTypesList.add(".jpeg");
			allowTypesList.add(".gif");
			allowTypesList.add(".pjpeg");
			allowTypesList.add(".jpg");
			allowTypesList.add(".png");
			allowTypesList.add(".bmp");
			if(!allowTypesList.contains(fileType))
			{
				
				return null;
			}
			//if(uploadContentType.contains("jpg"))
			Random r = new Random();
			int n = r.nextInt(900) + 100;
			String uploadPath = ""+savaPartPath 
					+ TypeConverter.convertDate2String(Calendar.getInstance()
							.getTime(), "yyyyMMddHHmmss") + n;

			HttpServletRequest request = ServletActionContext.getRequest();
			String realPath = request.getSession().getServletContext()
					.getRealPath(uploadPath);
			File file = new File(realPath);
			if (!file.exists()) {
				file.mkdirs();
			}
			String fn = "";
			uploadFileName=TypeConverter.convertDate2String(Calendar.getInstance()
					.getTime(), "yyyyMMddHHmmss") + n+fileType;
			fn = realPath + File.separator + uploadFileName;
			String filePath = uploadPath + "/" + uploadFileName;
			String filePos= filePath.substring(1);

			FileOutputStream fos = null;
			InputStream is = null;
			try {
				fos = new FileOutputStream(fn);

				is = new FileInputStream(upload);
				byte[] buffer = new byte[8192];
				int count = 0;
				while ((count = is.read(buffer)) > 0) {
					fos.write(buffer, 0, count);
				}
			} catch (Exception e) {
			}finally{
				try {
					fos.close();
					is.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return filePos;
		}
		
		/**
		 *  文件下载
		 * @param inputPath 文件所在路径(文件路径是包括文件名路径,例如 /jsp/test/**.txt)
		 * @param filename 设定文件名(设定下载的文件名,带扩展名的 例如: **.txt)
		 */
		public static void download(String inputPath,String filename){
			
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setHeader("content-disposition", "attachment;filename=" +filename);
			byte[] buf = new byte[1000];
			FileInputStream fis = null;
			try {
				String file=ServletActionContext.getServletContext().getRealPath("/"+inputPath);
				fis = new FileInputStream(file); 
				ServletOutputStream out = response.getOutputStream();
				while (fis.read(buf) != -1) {
					out.write(buf);
				}
				response.flushBuffer();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					fis.close();
				} catch (Exception f) {
				}
			}
		}
}
