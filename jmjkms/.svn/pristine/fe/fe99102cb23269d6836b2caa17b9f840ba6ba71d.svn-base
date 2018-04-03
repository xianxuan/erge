package com.jmjk.utils;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;




import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import jxl.Cell;
import jxl.CellView;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * jxl写入excel文件
 * @author liufengshuang
 * 
 */
public class JxlExcel {
	
	private String[] titles;
	private int j;
	
	//构造函数中,所有的标题头传进来
	public JxlExcel(String[] titles){
		this.titles = titles;
	}

	public JxlExcel(){}
/**
 * @param peos   实体的List
 * @param fileAbPath  绝对路径 写入 本地
 * @throws Exception
 */
	public  void writeExcel(List<?> peos, String fileAbPath) throws Exception {
		// 列数
		int columnNum;
		int rows = peos.size(); // 行数
		File file;
		// 判断文件类型,如果不是以.xls结尾，那么停止执行
		file = new File(fileAbPath);
		if (!file.exists()) {// 如果文件不存在，则重新创建
			file.createNewFile();
		}
		if (!file.getName().endsWith("xls")) {
			return;
		}
		if ( peos == null||peos.size() == 0 || peos.equals("") ) {
			return;
		}
		// 反射获得类的属性个数 ,也就得到了你要打印的列数
		Class obClass = peos.get(0).getClass();
		Field[] fields = obClass.getDeclaredFields();
		columnNum = fields.length;
		//如果标题头和传入的对象属性参数不对应,函数结束
		if(columnNum != titles.length){
			return ;
		}
		// 创建工作簿
		WritableWorkbook workbook = Workbook.createWorkbook(file);
		// 创建sheet
		WritableSheet sheet = workbook.createSheet("sheetOne", 0);
		Label label =null;
		for(int i = 0; i<peos.size(); i++){
			//写入标题
			if(i == 0){
				for(int j = 0; j<columnNum; j++){
					label = new Label(j,0,titles[j]);
					sheet.addCell(label);
				}
			}
			Object people = peos.get(i);
			//读取每个实体中的字段上的值
			for(int j = 0; j<columnNum; j++){
				String value = (String)fields[j].get((Object)people);
				label = new Label(j,i+1,value);
				sheet.addCell(label);
			}
		}
		//写入
		workbook.write(); 
		// 关闭 
		workbook.close();
	}
	
	/**
	 * 传入实体列表,打印  用于写入客户端
	 * @param peos
	 * @param output
	 * @return
	 * @throws Exception
	 */
	public int write(List<?> peos, ServletOutputStream output) throws Exception{
		if(peos == null){return -1;}//避免程序瘫了,加的判断
		int columnNum;
		if ( peos == null || peos.size() == 0 || peos.equals("") ) {
			return -1;
		}
		// 反射获得类的属性个数 , 也就得到了你要打印的列数
		Class obClass = peos.get(0).getClass();
		Field[] fields = obClass.getDeclaredFields();
		columnNum = fields.length;
		//如果标题头和传入的对象属性参数不对应,函数结束
		if(columnNum != titles.length){
			return -1;
		}
		// 创建工作簿
		WritableWorkbook workbook = Workbook.createWorkbook(output);
		//WritableWorkbook workbook = Workbook.
		// 创建sheet
		WritableSheet sheet = workbook.createSheet("sheetOne", 0);
		Label label =null;
	    String head = "社区居民管理系统";
		
		//把水平对齐方式指定为居中 
		WritableCellFormat wcf = new WritableCellFormat();  
	    wcf.setAlignment(Alignment.CENTRE);

	    //自动设置列宽
	    CellView cellView = new CellView();  
	    cellView.setSize(4000); //设置固定列宽
	    for(int i = 0; i < columnNum; i++){
	    	sheet.setColumnView(i, cellView);//根据内容自动设置列宽   
	    }

        //设置head字体;  
        WritableFont font1 = new WritableFont(WritableFont.ARIAL,14,WritableFont.BOLD,false,UnderlineStyle.NO_UNDERLINE,Colour.RED); 
        WritableCellFormat color = new WritableCellFormat(font1); 
        color.setAlignment(Alignment.CENTRE);
        //开始插入
		for(int i = 0; i<peos.size(); i++){
			//写入标题 还有表头
			if(i == 0){
				//合并单元行 ,加head,第0行
				sheet.mergeCells(0, 0, columnNum-1, 0);
				label = new Label(0,0,head,color);
				sheet.addCell(label);
				//第一行 加表头
				for(int j = 0; j<columnNum; j++){
					label = new Label(j,1,titles[j],wcf);
					sheet.addCell(label);
				}
			}
			Object people = peos.get(i);
			//读取每个实体中的字段上的值
			for(int j = 0; j<columnNum; j++){
				String value = (String)fields[j].get((Object)people);
				label = new Label(j,i+2,value,wcf);
				sheet.addCell(label);
			}
		}
		//写入
		workbook.write(); 
		// 关闭 
		workbook.close();
		output.flush();
		output.close();
				
		return 0;
	}
	
	
	/**
	 * 从客户端读取Excel文件 --OK, 能实现, 开始写逻辑 哈哈哈哈哈哈!
	 * 返回结果集beans
	 * @return 传入
	 */
	public List<AllInfoBean> getExcelByClient(File file)throws Exception{
		//如果文件为空,返回NULL
		if(file == null){
			return null;
		}
		//0.查看文件类型是否匹配
		try {
			Workbook workBook = Workbook.getWorkbook(file) ;
		} catch (Exception e) {
			return null;
		}
		if(Workbook.getWorkbook(file)==null){
			return null;
		}
		
		Workbook workBook = Workbook.getWorkbook(file) ;
		//1
		List<CheckInfo> cks = new ArrayList<CheckInfo>();
		List<AllInfoBean> beans = new ArrayList<AllInfoBean>();
		// 获得sheet
		Sheet sheet = workBook.getSheet(0);
		if(sheet.getColumns()!=65){
			return null;
		}
		// 变
		for (int i = 1; i < sheet.getRows(); i++) { //i是行 j是列
			CheckInfo ck=new CheckInfo();
			AllInfoBean bean = new AllInfoBean();
			for ( j = 0; j < sheet.getColumns(); j++) {
				Cell cell = sheet.getCell(j, i);// 注意这里的j,i的位置
				Field[] field=ck.getClass().getDeclaredFields();
				//反射 将一行数据 放进 临时 封装类 CheckInfo
				try {
			       String name = field[j].getName();  // 属性的名字  
			       name = name.substring(0, 1).toUpperCase() + name.substring(1);// 将属性的首字符大写，
			       String type = field[j].getGenericType().toString(); // 属性的类型
			       if (type.equals("class java.lang.String")) { 		// 判断属性类型
				       if (cell.getContents().trim()!= null) {
				           Method m = ck.getClass().getMethod("set"+name,String.class);
				           m.invoke(ck, cell.getContents());
				       }
			       }
				} catch (Exception e){
					return null;
				}
			}
			int a=ck.check();
			if(a!=1){ //报错,然后存储错误点坐标
				bean.setX(i+1);
				bean.setY(-a);
				beans.add(bean);
				return beans;//到时候取一下最后一个,看是否有错
			}
			if(a==1){
				ck.zhuanhuan();
				bean.setHeathFile(ck.getTHealthFile());
				bean.setMedicalPay(ck.getMedicalPayMethod());
				bean.setPasts(ck.getTPastHistory());
				beans.add(bean);
			}
			//一个实体检查完成
		}
		//遍历结束
		return beans;
	}
}
