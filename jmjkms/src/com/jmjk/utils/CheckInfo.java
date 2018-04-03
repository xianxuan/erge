package com.jmjk.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.struts2.el.parser.ParseException;

import com.jmjk.entity.THealthFile;
import com.jmjk.entity.TMedicalPayMethod;
import com.jmjk.entity.TPastHistory;

/**
 * 
 * 用于上传居民健康档案的信息验证  未完ing
 * @author liufengshuang
 *
 */
public class CheckInfo {
	
	private String bianhao; // 居民档案编号    可选项,如果不填档案编号，系统会按照居民健康档案的规则自动生成档案编号，如果填写了档案编号则以填写的档案编号为准
	private String name; //姓名  必填项
	private String juweihui; //所在居委会   必填项
	private String xianzhuzhi;//现住址   必选项
	private String jiandangriqi;//建档日期
	private String xingbie; //性别 男 女
	private String shenfenzhenghao;//身份证号  可选项
	private String birth; //出生日期 可选
	private String gongzuodanwei;//工作单位  可选项
	private String phone; //本人电话  必填项
	private String lianName; //联系人姓名  必填
	private String lianPhone; //联系人 电话  必填
	private String minzu; //民族
	private String guoji; //国籍  可选
	private String xueli; //学历   
	private String zhiye; //职业
	private String yiliaofufei;//医疗付费方式
	private String hunyin;//婚姻状况
	private String jiandangren;//建档人
	private String zerenyisheng;//责任医生
	private String guominshi;//过敏史
	private String baolushi;//暴露史
	private String baolushibeizhu;//暴露史备注
	private String renqun;//人群分类
	private String gaoxueyaTime;//高血压确认时间
	private String tangTime;//糖尿病确认时间
	private String guanTime;//冠心病确认时间
	private String exingTime;//恶性肿瘤确认时间
	private String naoTime;//脑卒确认时间
	private String jieTime;//结核病确认时间
	private String jingTime;//精神分裂症确认时间
	private String ganTime;//肝炎确认时间
	private String qitaTime;//其他法定传染病确认时间
	private String zhiyeTime;//职业病确认时间
	private String COPOTime;//COPO确认时间
	private String taJiTime;//其他既往史确认时间
	private String taJiName;//其他疾病名称
	private String shuJi;//输血既往史
	private String waiJi;//外伤既往史
	private String shouJi;//手术既往史
	private String fatherInfo;//父亲患病情况
	private String fatherOther;//父亲患其他病情况
	private String motherInfo;//母亲患病情况
	private String motherOther;//母亲患其他病情况
	private String broAnSisInfo;//兄弟姐妹患病情况
	private String broAnSisOther;//兄弟姐妹患其他病情况
	private String sonInfo;//子女患病情况
	private String sonOther;//子女患其他病情况
	private String yichuanbing;//遗传病名称
	private String canji;//残疾
	private String canjiOther;//残疾其他
	private String canjiNum;//残疾证号
	private String chufang;//厨房排风设施
	private String ranliao;//燃料类型
	private String ranliaoOther;//燃料类型其他
	private String yinshui;//饮水类型
	private String yinsuiOther;//饮水类型其他
	private String cesuo;//厕所
	private String qinchulan;//禽畜栏
	private String high;//身高
	private String weight;//体重
	private String tunwei;//臀围
	private String yaowei;//腰围
	private String shousuoya;//收缩压
	private String shuzhangya;//舒张压
	
	
	public CheckInfo(){
	 
	}
	
	
	/**
	 * 格式正确 返回+1  格式错误 返回-1
	 * @return
	 * @throws ParseException 
	 */
	public int check() throws ParseException{
		//1.验证档案编号是否重复 ,前题取出编号的list, 查看当前编号是否在这个list中
		
		//2.姓名
		if(this.name == null ){
			return -2;
		}else{
			//如果为空
			if(this.name.equals("") || this.name == ""){
				return -2;
			}	
			//字符长度过长
			if(this.name.length() > 10){
				return -2;
			}
		}
		
		//3.所在居委会
		if(this.juweihui == null){
			return -3;
		}else{
			//如果为空
			if(this.juweihui.equals("") || this.juweihui == ""){
				return -3; 
			}
			//长度
			if(this.juweihui.length() > 50){
				return -3;
			}
		}
		
		//4.现住址
		if(this.xianzhuzhi == null){
			return -4;
		}else{
			//如果为空
			if(this.xianzhuzhi.equals("") || this.xianzhuzhi == ""){
				return -4; 
			}
			//长度
			if(this.xianzhuzhi.length() > 50){
				return -4;
			}
		}
		
		//5.建档日期
		if(this.jiandangriqi == null){
			return -5;
		}else{
			//如果为空
			if(this.jiandangriqi.equals("") || this.jiandangriqi == ""){
				return -5; 
			}
			//日期格式不对
			if(isDate(jiandangriqi) == false){
				return -5;
			}
			//长度
			if(this.jiandangriqi.length() > 20){
				return -5;
			}
		}
		
		//6.性别
		if(this.xingbie == null){
			return -6;
		}else{
			//如果为空
			if(this.xingbie.equals("") || this.xingbie == ""){
				return -6; 
			}
			//格式
			if(this.xingbie != "男" && this.xingbie != "女" && !this.xingbie.equals("男") && !this.xingbie.equals("女")){
				return -6;
			}
			//长度
			if(this.xingbie.length() > 3){
				return -6;
			}
		}
		//7.身份证号
		if(this.shenfenzhenghao == null){
		}else{
			//如果为不空,判断格式
			if(!this.shenfenzhenghao.equals("") && this.shenfenzhenghao != ""){
				if(IDCardValidate(shenfenzhenghao) == "" || IDCardValidate(shenfenzhenghao).equals("")){
					return -7;
				}
			}
			//长度
			if(this.shenfenzhenghao.length() > 20){
				return -7;
			}
		}
		
		//8.出生日期
		if(this.birth != null){
			//如果bu为空
			if(!this.birth.equals("") && this.birth != ""){
				//日期格式不对
				if(isDate(birth) == false){
					return -8;
				}
			}
			//长度
			if(this.birth.length() > 20){
				return -8;
			}
		}
		
		//9.工作单位
		if(gongzuodanwei != null){
			if(this.gongzuodanwei.length() > 40){
				return -9;
			}
		}
		
		//10.本人电话 必填
		if(phone == null){
			return -10;
		}else{
			if(this.phone.equals("") || this.phone == ""){
				return -10; 
			}
			if(this.phone.length() > 20){
				return -10;
			}
			//格式不对
			if(!isMobile(this.phone) && !isPhone(this.phone)){
				return -10;
			}
		}
		
		//11.联系人姓名
		if(lianName == null){
			return -11;
		}else{
			if(this.lianName.equals("") || this.lianName == ""){
				return -11; 
			}
			//长度
			if(this.lianName.length() > 20){
				return -11;
			}
		}
		
		//12.lianPhone 联系人电话
		if(lianPhone == null){
			return -12;
		}else{
			if(this.lianPhone.equals("") || this.lianPhone == ""){
				return -12; 
			}
			//长度
			if(this.lianPhone.length() > 20){
				return -12;
			}
			if(!isMobile(this.lianPhone) && !isPhone(this.lianPhone)){
				return -12;
			}
		}
		 
		//13民族 minzu
		if(minzu != null){
			//长度
			if(!minzu.equals("") && minzu != ""){
				if(minzu.length() > 4){
					return -13;
				}
				//是否是民族
				if(isMinZu(minzu) == false){
					return -13;
				}
			}
			
		}
		//14 guoji 国籍
		if(guoji != null){
			//长度
			if(guoji.length() > 10){
				return -14;
			}
		}
		//15 xueli学历 
		if(xueli != null){
			if(!xueli.equals("") && xueli != null){
				if(xueli.length() > 10){
					return -15;
				}
				if(isXueLi(xueli) == false){
					return -15;
				}
			}
		
			
		}
		//16 zhiye职业
		if(zhiye != null){
			if(!zhiye.equals("") && zhiye != ""){
				//长度
				if(zhiye.length() > 4){
					return -16;
				}
				//内容
				if(isZhiYe(zhiye) == false){
					return  -16;
				}
				
			}
			
		}
		//17.医疗付费方式
		if(yiliaofufei != null){
			if(!yiliaofufei.equals("")&& yiliaofufei != ""){
				//长度
				if(yiliaofufei.length() >4){
					return -17;
				}
				//格式
				if(isXueLi(yiliaofufei) == false){
					return -17;
				}
			}
		
			
		}
		
		//18.婚姻状况
		if(hunyin != null){
			if(!hunyin.equals("") && hunyin != ""){
				//长度
				if(hunyin.length() > 4){
					return -18;
				}
				if(isHunYin(hunyin) == false){
					return -18;
				}
			}
		
		}
		//19.建档人, 必填项
		if(jiandangren != null){
			//为空
			if(jiandangren == "" || jiandangren.equals("")){
				return -19;
			}
			//长度
			if(jiandangren.length() > 10){
				return -19;
			}
		}else{
			return -1;
		}
		//20.责任医生 必填项
		if(zerenyisheng != null){
			//为空
			if(zerenyisheng.equals("") || zerenyisheng == ""){
				return -20;
			}
			//长度
			if(zerenyisheng.length()>10){
				return -20;
			}
		}else{
			return -20;
		}
		//21.过敏史
		if(guominshi != null){
			//长度
			if(guominshi.length() >100){
				return -21;
			}
		}
		//22.暴露史
		if(baolushi != null){
			if(!baolushi.equals("") && baolushi != ""){
				//长度
				if(baolushi.length() >4){
					return -22;
				}
				//内容
				if(baolushi != "1" && baolushi != "2" && baolushi != "3" && !baolushi.equals("1")&&!baolushi.equals("3")&&!baolushi.equals("3")){
					return -22;
				}
			}
		}
		//23.暴露史备注
		if(baolushibeizhu != null){
			//长度
			if(baolushibeizhu.length() >100){
				return -23;
			}
		}
		//24.人群分类
		if(renqun != null){
			if(!renqun.equals("") && renqun != ""){
				//长度
				if(renqun.length() >20){
					return -24;
				}
				//内容
				if(renqun != "1" && renqun != "2" && renqun != "3"&&!renqun.equals("1")&&!renqun.equals("2")&&!renqun.equals("3")){
					return -24;
				}
			}
		}
		//25.高血压确认时间
		if(gaoxueyaTime != null){
			if(!gaoxueyaTime.equals("") && gaoxueyaTime != ""){
				if(gaoxueyaTime.length() >20){
					return -25;
				}
				if(isValidDate(gaoxueyaTime) == false){
					return -25;
				}
			}
		}
		//26.糖尿病确认时间
		if(tangTime != null){
			if(!tangTime.equals("") && tangTime !=""){
				if(tangTime.length() > 20){
					return -26;
				}
				if(isValidDate(tangTime) == false){
					return -26;
				}
			}
		}
		//27.冠心病确认时间
		if(guanTime != null){
			if(!guanTime.equals("") && guanTime != ""){
				if(guanTime.length() >20){
					return -27;
				}
				if(isValidDate(guanTime) == false){
					return -27;
				}
			}
		}
		
		//28.恶性肿瘤确认时间
		if(exingTime != null){
			if(!exingTime.equals("") && exingTime != ""){
				if(exingTime.length() >20){
					return -28;
				}
				if(isValidDate(exingTime) == false){
					return -28;
				}
			}
		}
		//29.脑卒中确认时间
		if(naoTime != null){
			if(!naoTime.equals("") && naoTime != ""){
				if(naoTime.length() >20){
					return -29;
				}
				if(isValidDate(naoTime) == false){
					return -29;
				}
			}
		}
		//30.结合病确认时间
		if(jieTime != null){
			if(!jieTime.equals("") && jieTime != ""){
				if(jieTime.length() >20){
					return -30;
				}
				if(isValidDate(jieTime) == false){
					return -30;
				}
			}
		}
		//31.精神分裂确认时间
		if(jingTime != null){
			if(!jingTime.equals("") && jingTime != ""){
				if(jingTime.length() >20){
					return -31;
				}
				if(isValidDate(jingTime) == false){
					return -31;
				}
			}
		}
		//32.肝炎确认时间
		if(ganTime != null){
			if(!ganTime.equals("") && ganTime != ""){
				if(ganTime.length() >20){
					return -32;
				}
				if(isValidDate(ganTime) == false){
					return -32;
				}	
			}
		}
		//33.其它法定传染病确认时间
		if(qitaTime != null){
			if(!qitaTime.equals("") && qitaTime != ""){
				if(qitaTime.length() > 20){
					return -33;
				}
				if(isValidDate(qitaTime) == false){
					return -33;
				}
			}
		}
		//34.职业病确认时间
		if(zhiyeTime != null){
			if(!zhiyeTime.equals("") && zhiyeTime != ""){
				if(zhiyeTime.length() > 20){
					return -34;
				}
				if(isValidDate(zhiyeTime) == false){
					return -34;
				}
			}
		}
		//35.COPO确认时间
		if(COPOTime != null){
			if(!COPOTime.equals("") && COPOTime != ""){
				if(COPOTime.length() >20){
					return -35;
				}
				if(isValidDate(COPOTime) == false){
					return -35;
				}
			}
		}
		//36.其他既往史确认时间
		if(taJiTime != null){
			if(!taJiTime.equals("") && taJiTime !=""){
				if(taJiTime.length() >20){
					return -36;
				}
				if(isValidDate(taJiTime) == false){
					return -36;
				}
			}
		}
		//37.其他疾病名称
		if(taJiName != null){
			//长度
			if(taJiName.length() >20){
				return -37;
			}
		}
		//38.输血既往史
		if(shuJi != null){
			//长度
			if(shuJi.length() >40){
				return -38;
			}
		}
		//39.外伤既往史
		if(waiJi != null){
			//长度
			if(waiJi.length() >40){
				return -39;
			}
		}
		//40.手术既往史
		if(shouJi != null){
			//长度
			if(shouJi.length() > 40){
				return -40;
			}
		}
		//41.父亲患病情况
		if(fatherInfo != null){
			if(!fatherInfo.equals("") && fatherInfo != ""){
				//长度
				if(fatherInfo.length() > 40){
					return -41;
				}
				if(checksource(fatherInfo)==false){
					return -41;
				}else{//往上拼字符串
				
				}	
			}
			
			
		}
		
		//42.父亲患其他病情况
		if(fatherOther != null){
			//长度
			if(fatherOther.length() > 50){
				return -42;
			}
			
			
			
		}
		//43母亲患病情况
		if(motherInfo!=null){
			if(!motherInfo.equals("") && motherInfo != ""){
				if(motherInfo.length() > 40){
					return -43;
				}
				if(checksource(motherInfo)==false){
					return -43;
				}else{
					
				}
			}
		}
		//44母亲其他患病情况
		if(motherOther!=null){
			if(motherOther.length() > 50){
				return -44;
			}
		}
		//45 兄弟姐妹患病情况
		if(broAnSisInfo!=null){
			if(!broAnSisInfo.equals("") && broAnSisInfo != ""){
				if(broAnSisInfo.length()>40){
					return -45;
				}
				if(checksource(broAnSisInfo)==false){
					return -45;
				}	
			}
		}
		//46  兄弟姐妹患其他病情况
		if(broAnSisOther!=null){
			if(broAnSisOther.length()>50){
				return -46;
			}
		}
		//47 private String sonInfo; 子女患病情况
		if(sonInfo!=null){
			if(!sonInfo.equals("") && sonInfo != ""){
				if(sonInfo.length()>40){
					return -47;
				}
				if(checksource(sonInfo)==false){
					return -47;
				}
			}
		}
	//48 private String sonOther;//子女患其他病情况
		if(sonOther!=null){
			if(sonOther.length()>50){
				return -48;
			}
		}
	//49 private String yichuanbing;//遗传病名称
		if(yichuanbing!=null){
			if(yichuanbing.length()>50){
				return -49;
			}
		}
	//50 private String canji;//残疾
		if(canji!=null){
			if(canji.length()>50){
				return -50;
			}
		}
		
	//51 private String canjiOther;//残疾其他
		if(canjiOther!=null){
			if(canjiOther.length()>50){
				return -51;
			}
		}
	//52 private String canjiNum;//残疾证号
		if(canjiNum !=null){
			if(canjiNum.length()>50){
				return -52;
			}
		}
	//53 private String chufang;//厨房排风设施
		if(chufang!=null){
			if(chufang.length()>50){
				return -53;
			}
		}
	//54 private String ranliao;//燃料类型
		if(ranliao!=null){
			if(ranliao.length()>50){
				return -54;
			}
		}
		
	//55 private String ranliaoOther;//燃料类型其他
		if(ranliaoOther!=null){
			if(ranliaoOther.length()>50){
				return -55;
			}
		}
	//56 private String yinshui;//饮水类型
		if(yinshui!=null){
			if(yinshui.length()>50){
				return -56;
			}
		}
	//57 private String yinsuiOther;//饮水类型其他
		if(yinsuiOther!=null){
			if(yinsuiOther.length()>50){
				return -57;	
			}
		}
	//58 private String cesuo;//厕所
		if(cesuo!=null){
			if(cesuo.length()>50){
				return -58;
			}
		}
	//59 private String qinchulan;//禽畜栏
		if(qinchulan!=null){
			if(qinchulan.length()>50){
				return -59;
			}
		}
	//60 private String high;//身高
		if(high!=null){
			if(high.length()>50){
				return -60;
			}
		}
	//61 private String weight;//体重
		if(weight!=null){
			if(weight.length()>50){
				return -61;
			}
		}
	//62 private String tunwei;//臀围
		if(tunwei!=null){
			if(tunwei.length()>50){
				return -62;
			}
		}
	//63 private String yaowei;//腰围
		if(yaowei!=null){
			if(yaowei.length()>50){
				return -63;
			}
		}
	//64 private String shousuoya;//收缩压
		if(shousuoya!=null){
			if(shousuoya.length()>50){
				return -64;
			}
		}
	//65 private String shuzhangya;//舒张压
		if(shuzhangya!=null){
			if(shuzhangya.length()>50){
				return -65;
			}
		}
		return 1;
	}
	

	
	
	//	private String zerenyisheng;//责任医生  这个在老人员工关系表    
	
	/**
	 * 获得医疗付费实体
	 * @return
	 */
	public TMedicalPayMethod getMedicalPayMethod(){
		if(yiliaofufei != "" && !yiliaofufei.equals("")){
			TMedicalPayMethod m = new TMedicalPayMethod();
			m.setName(yiliaofufei);
			return m;
		}else{
			return null;
		}
	}
	/**
	 * 获得既往史的list列表
	 */
	public List<TPastHistory> getTPastHistory(){
		List<TPastHistory> list = new ArrayList<TPastHistory>();
		if(gaoxueyaTime != "" && !gaoxueyaTime.equals("")){
			gaoxueyaTime = gaoxueyaTime.replace("/", "-");
			TPastHistory his = new TPastHistory();
			his.setPastDate(TypeConverter.date2Timestamp(TypeConverter.strToDate(gaoxueyaTime)));
			his.setPastName("高血压");
			his.setPastType("疾病");
			list.add(his);
		}
		if(tangTime != "" && !tangTime.equals("")){
			tangTime = tangTime.replace("/", "-");
			TPastHistory his = new TPastHistory();
			his.setPastDate(TypeConverter.date2Timestamp(TypeConverter.strToDate(tangTime)));
			his.setPastName("糖尿病");
			his.setPastType("疾病");
			list.add(his);
		}
		if(guanTime != "" && !guanTime.equals("")){
			guanTime = guanTime.replace("/", "-");
			TPastHistory his = new TPastHistory();
			his.setPastDate(TypeConverter.date2Timestamp(TypeConverter.strToDate(guanTime)));
			his.setPastName("冠心病");
			his.setPastType("疾病");
			list.add(his);
		}
		if(exingTime != "" && !exingTime.equals("")){
			exingTime = exingTime.replace("/", "-");
			TPastHistory his = new TPastHistory();
			his.setPastDate(TypeConverter.date2Timestamp(TypeConverter.strToDate(exingTime)));
			his.setPastName("恶性肿瘤");
			his.setPastType("疾病");
			list.add(his);
		}
		if(naoTime != "" && !naoTime.equals("")){
			naoTime = naoTime.replace("/", "-");
			TPastHistory his = new TPastHistory();
			his.setPastDate(TypeConverter.date2Timestamp(TypeConverter.strToDate(naoTime)));
			his.setPastName("脑卒");
			his.setPastType("疾病");
			list.add(his);
		}
		if(jieTime != "" && !jieTime.equals("")){
			jieTime = jieTime.replace("/", "-");
			TPastHistory his = new TPastHistory();
			his.setPastDate(TypeConverter.date2Timestamp(TypeConverter.strToDate(jieTime)));
			his.setPastName("结核病");
			his.setPastType("疾病");
			list.add(his);
		}
		if(jingTime != "" && !jingTime.equals("")){
			jingTime = jingTime.replace("/", "-");
			TPastHistory his = new TPastHistory();
			his.setPastDate(TypeConverter.date2Timestamp(TypeConverter.strToDate(jingTime)));
			his.setPastName("精神分裂症");
			his.setPastType("疾病");
			list.add(his);
		}
		if(ganTime != "" && !ganTime.equals("")){
			ganTime = ganTime.replace("/", "-");
			TPastHistory his = new TPastHistory();
			his.setPastDate(TypeConverter.date2Timestamp(TypeConverter.strToDate(ganTime)));
			his.setPastName("肝炎");
			his.setPastType("疾病");
			list.add(his);
		}
		if(qitaTime != "" && !qitaTime.equals("")){
			qitaTime = qitaTime.replace("/", "-");
			TPastHistory his = new TPastHistory();
			his.setPastDate(TypeConverter.date2Timestamp(TypeConverter.strToDate(qitaTime)));
			his.setPastName("其他法定传染病");
			his.setPastType("疾病");
			list.add(his);
		}
		if(zhiyeTime != "" && !zhiyeTime.equals("")){
			zhiyeTime = zhiyeTime.replace("/", "-");
			TPastHistory his = new TPastHistory();
			his.setPastDate(TypeConverter.date2Timestamp(TypeConverter.strToDate(zhiyeTime)));
			his.setPastName("职业病");
			his.setPastType("疾病");
			list.add(his);
		}
		if(COPOTime != "" && !COPOTime.equals("")){
			COPOTime = COPOTime.replace("/", "-");
			TPastHistory his = new TPastHistory();
			his.setPastDate(TypeConverter.date2Timestamp(TypeConverter.strToDate(COPOTime)));
			his.setPastName("COPO");
			his.setPastType("疾病");
			list.add(his);
		}
		if(taJiTime != "" && !taJiTime.equals("")){
			taJiTime = taJiTime.replace("/", "-");
			TPastHistory his = new TPastHistory();
			his.setPastDate(TypeConverter.date2Timestamp(TypeConverter.strToDate(taJiTime)));
			his.setPastName(taJiName);
			his.setPastType("疾病");
			list.add(his);
		}
		//以下是既往史
		if(shuJi != "" && !shuJi.equals("")){
			TPastHistory his = new TPastHistory();
			his.setPastType("输血");
			his.setPastName(shuJi);
			list.add(his);
		}
		
		if(waiJi != "" && !waiJi.equals("")){
			TPastHistory his = new TPastHistory();
			his.setPastType("外伤");
			his.setPastName(waiJi);
			list.add(his);
		}
		
		if(shouJi != "" && !shouJi.equals("")){
			TPastHistory his = new TPastHistory();
			his.setPastType("手术");
			his.setPastName(shouJi);
			list.add(his);
		}
		return list;
	}
	
	public THealthFile getTHealthFile(){
		this.zhuanhuan();
		THealthFile file = new THealthFile();
		//		private String bianhao; // 居民档案编号    可选项,如果不填档案编号，系统会按照居民健康档案的规则自动生成档案编号，如果填写了档案编号则以填写的档案编号为准
		file.setFileNum(bianhao);
		//		private String name; //姓名  必填项
		file.setName(name);
		//		private String juweihui; //所在居委会   必填项 CURRENT_RESIDENT_COMMITTEE
		file.setCurrentResidentCommittee(juweihui);
		//		private String xianzhuzhi;//现住址   必选项 CURRENT_COMMUNITY
		file.setCurrentCommunity(xianzhuzhi);
		//		private String jiandangriqi;//建档日期  FILE_DATE  
		file.setFileDate(TypeConverter.date2Timestamp(TypeConverter.strToDate(jiandangriqi)));
		//		private String xingbie; //性别 男 女
		if(xingbie == "男" || xingbie.equals("男")){
			file.setSex(false);
		}else if(xingbie == "女" || xingbie.equals("女")){
			file.setSex(true);
		}else{
			file.setSex(null);
		}
		//		private String shenfenzhenghao;//身份证号  可选项
		file.setIdNum(shenfenzhenghao);
		//		private String birth; //出生日期 可选  
		file.setBirthDate(TypeConverter.date2Timestamp(TypeConverter.strToDate(birth)));
		//		private String gongzuodanwei;//工作单位  可选项  WORK_UNIT
		file.setWorkUnit(gongzuodanwei);
		//		private String phone; //本人电话  必填项
		file.setIPhone(phone);
		//		private String lianName; //联系人姓名  必填  OTHER_NAME
		file.setOtherName(lianName);
		//		private String lianPhone; //联系人 电话  必填
		file.setOtherPhone(lianPhone);
		//		private String minzu; //民族  NATION
		file.setNation(minzu);
		//		private String guoji; //国籍  可选  COUNTRY
		file.setCountry(guoji);
		//		private String xueli; //学历    EDU_LEVEL
		file.setEduLevel(xueli);
		//		private String zhiye; //职业
		file.setJob(zhiye);
		//		private String hunyin;//婚姻状况   MARITAL_STATUS
		file.setMaritalStatus(hunyin);
		//		private String jiandangren;//建档人  ENTER_PEOPLE
		file.setEnterPeople(jiandangren);
		//		private String guominshi;//过敏史  ALLERGY_NAME
		file.setExposeNote(guominshi);
		//		private String baolushi;//暴露史
		file.setAllergyName(guominshi);
		//		private String baolushibeizhu;//暴露史备注  EXPOSE_NOTE
		file.setExposeNote(baolushibeizhu);
		//		private String renqun;//人群分类  CROWD_CLASS
		file.setCrowdClass(renqun);
		//		private String fatherInfo;//父亲患病情况 FATHER_DISEASE
		file.setFatherDisease(fatherInfo);
		//		private String fatherOther;//父亲患其他病情况   *****************************
		//		private String motherInfo;//母亲患病情况
		file.setMotherDisease(motherInfo);
		//		private String motherOther;//母亲患其他病情况 *******************************
		//		private String broAnSisInfo;//兄弟姐妹患病情况
		file.setBorSisDisease(broAnSisInfo);
		//		private String broAnSisOther;//兄弟姐妹患其他病情况 ****************************
		//		private String sonInfo;//子女患病情况
		file.setChildDisease(sonInfo);
		//		private String sonOther;//子女患其他病情况 ******************************
		//		private String yichuanbing;//遗传病名称   GENETIC_HISTORY
		file.setGeneticHistory(yichuanbing);
		//		private String canji;//残疾  DISABILITY_NAME
		file.setDisabilityName(canji);
		//		private String canjiOther;//残疾其他
		//		private String canjiNum;//残疾证号
		//		private String chufang;//厨房排风设施  KIT_VEN_FAC
		file.setKitVenFac(chufang);
		//		private String ranliao;//燃料类型   FUEL_TYPE
		file.setFuelType(ranliao);
		//		private String ranliaoOther;//燃料类型其他
		//		private String yinshui;//饮水类型  DRINK_WATER
		file.setDrinkWater(yinshui);
		//		private String yinsuiOther;//饮水类型其他
		//		private String cesuo;//厕所  TOILET
		file.setToilet(cesuo);
		//		private String qinchulan;//禽畜栏  LIVESTOCK_BAR
		file.setLivestockBar(qinchulan);
		//		private String high;//身高
		file.setHeight(Double.parseDouble(high));
		//		private String weight;//体重
		file.setWeihth(Double.parseDouble(weight));
		//		private String tunwei;//臀围
		file.setHipline(Double.parseDouble(tunwei));
		//		private String yaowei;//腰围
		file.setWaistline(Double.parseDouble(yaowei));
		//		private String shousuoya;//收缩压
		file.setSystolicBloodPressure(Double.parseDouble(shousuoya));
		//		private String shuzhangya;//舒张压
		file.setDiastolicBloodPressure(Double.parseDouble(shuzhangya));
		return file;
	}
	
	
	/**
	 * 以逗号分割字符串
	 * @param str
	 * @return
	 */
	public boolean checksource(String str){
		if(str.trim().equals("") || str.trim().length()==0){
			return false;
		}
		String[] a=str.split(",");
		int m;
		for(String s : a){
			try {
				m=Integer.valueOf(s);
			} catch (Exception e) {  
				return false;
			}
			if(m<=0 || m>=13){
				return false;
			}
		}
		return true;
	} 
	
	
	
	//判断婚姻格式
	public boolean isHunYin(String str){
		if(str == "10" || str =="21"||str == "22" || str =="23" || str == "30"){
			return true;
		}
		if(str.equals("10") || str.equals("21")||str.equals("22") ||str.equals("23") ||str.equals("30") ){
			return true;
		}
		return false;
	}
	//判断职业格式
	public boolean isZhiYe(String str){
		if(this.isNumeric(str) == true){
			try{	
				int i = Integer.parseInt(str);
				if(i >= 0 && i<9){
					return true;
				}
			}catch(Exception e){
				return false;
			}
		}
		return false;
	}
	
	//判断是否是民族
	public boolean isMinZu(String str){
		if(this.isNumeric(str) == true){
			try{	
				int i = Integer.parseInt(str);
				if(i >= 0 && i<60){
					return true;
				}
			}catch(Exception e){
				return false;
			}
		}
		return false;
	}
	//判断是否是学历的范围
	public boolean isXueLi(String str){
		if(str.equals("") || str == ""){
			return false;
		}else{
			try{
				int i = Integer.parseInt(str);
				if(i < 0 || i >10){
					return false;
				}
			}catch(Exception e){
				return false;
			}
			
		}
		return true;
	}

	
	/** 
     * 4  手机号验证 
     * @param  str 
     * @return 验证通过返回true 
     */  
    public  boolean isMobile(String str) {   
        Pattern p = null;  
        Matcher m = null;  
        boolean b = false;   
        p = Pattern.compile("^[1][3,4,5,8][0-9]{9}$"); // 验证手机号  
        m = p.matcher(str);  
        b = m.matches();   
        return b;  
    }  
    
    /** 
     *3   电话号码验证 
     * @param  str 
     * @return 验证通过返回true 
     */  
    public  boolean isPhone(String str) {   
        Pattern p1 = null,p2 = null;  
        Matcher m = null;  
        boolean b = false;    
        p1 = Pattern.compile("^[0][1-9]{2,3}-[0-9]{5,10}$");  // 验证带区号的  
        p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$");         // 验证没有区号的  
        if(str.length() >9)  
        {   m = p1.matcher(str);  
            b = m.matches();    
        }else{  
            m = p2.matcher(str);  
            b = m.matches();   
        }    
        return b;  
    }  
    
	/**
	 * 2 . 判断是否是合法日期
	 * @param str
	 * @return
	 * @throws Exception
	 */
	 public  boolean isValidDate(String sDate){
		 sDate = sDate.replace("/", "-");
		 	 String datePattern1 = "\\d{4}-\\d{2}-\\d{2}";
		     String datePattern2 = "^((\\d{2}(([02468][048])|([13579][26]))"
		             + "[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|"
		             + "(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?"
		             + "((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?("
		             + "(((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?"
		             + "((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";
		     if ((sDate != null)) {
		         Pattern pattern = Pattern.compile(datePattern1);
		         Matcher match = pattern.matcher(sDate);
		         if (match.matches()) {
		             pattern = Pattern.compile(datePattern2);
		             match = pattern.matcher(sDate);
		             return match.matches();
		         }
		         else {
		             return false;
		         }
		     }
		     return false;
	 }
	
	/**   1.
	 * 判断是否是身份证号  不是返回""
	 * @param IDStr
	 * @return
	 * @throws ParseException
	 */
    public  String IDCardValidate(String IDStr) throws ParseException {
        String errorInfo = "";// 记录错误信息
        String[] ValCodeArr = { "1", "0", "x", "9", "8", "7", "6", "5", "4",
                "3", "2" };
        String[] Wi = { "7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7",
                "9", "10", "5", "8", "4", "2" };
        String Ai = "";
        // ================ 号码的长度 15位或18位 ================
        if (IDStr.length() != 15 && IDStr.length() != 18) {
            errorInfo = "身份证号码长度应该为15位或18位。";
            return errorInfo;
        }
        // =======================(end)========================

        // ================ 数字 除最后以为都为数字 ================
        if (IDStr.length() == 18) {
            Ai = IDStr.substring(0, 17);
        } else if (IDStr.length() == 15) {
            Ai = IDStr.substring(0, 6) + "19" + IDStr.substring(6, 15);
        }
        if (isNumeric(Ai) == false) {
            errorInfo = "身份证15位号码都应为数字 ; 18位号码除最后一位外，都应为数字。";
            return errorInfo;
        }
        // =======================(end)========================

        // ================ 出生年月是否有效 ================
        String strYear = Ai.substring(6, 10);// 年份
        String strMonth = Ai.substring(10, 12);// 月份
        String strDay = Ai.substring(12, 14);// 月份
        if (isDate(strYear + "-" + strMonth + "-" + strDay) == false) {
            errorInfo = "身份证生日无效。";
            return errorInfo;
        }
        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if ((gc.get(Calendar.YEAR) - Integer.parseInt(strYear)) > 150
                    || (gc.getTime().getTime() - s.parse(
                            strYear + "-" + strMonth + "-" + strDay).getTime()) < 0) {
                errorInfo = "身份证生日不在有效范围。";
                return errorInfo;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        if (Integer.parseInt(strMonth) > 12 || Integer.parseInt(strMonth) == 0) {
            errorInfo = "身份证月份无效";
            return errorInfo;
        }
        if (Integer.parseInt(strDay) > 31 || Integer.parseInt(strDay) == 0) {
            errorInfo = "身份证日期无效";
            return errorInfo;
        }
        // =====================(end)=====================

        // ================ 地区码时候有效 ================
        Hashtable h = GetAreaCode();
        if (h.get(Ai.substring(0, 2)) == null) {
            errorInfo = "身份证地区编码错误。";
            return errorInfo;
        }
        // ==============================================

        // ================ 判断最后一位的值 ================
        int TotalmulAiWi = 0;
        for (int i = 0; i < 17; i++) {
            TotalmulAiWi = TotalmulAiWi
                    + Integer.parseInt(String.valueOf(Ai.charAt(i)))
                    * Integer.parseInt(Wi[i]);
        }
        int modValue = TotalmulAiWi % 11;
        String strVerifyCode = ValCodeArr[modValue];
        Ai = Ai + strVerifyCode;

        if (IDStr.length() == 18) {
            if (Ai.equals(IDStr) == false) {
                errorInfo = "身份证无效，不是合法的身份证号码";
                return errorInfo;
            }
        } else {
            return "";
        }
        // =====================(end)=====================
        return IDStr;
    }

    /**
     * 功能：设置地区编码
     * @return Hashtable 对象
     */
 //  @SuppressWarnings("unchecked")
    private  Hashtable GetAreaCode() {
        Hashtable<String, String> hashtable = new Hashtable();
        hashtable.put("11", "北京");
        hashtable.put("12", "天津");
        hashtable.put("13", "河北");
        hashtable.put("14", "山西");
        hashtable.put("15", "内蒙古");
        hashtable.put("21", "辽宁");
        hashtable.put("22", "吉林");
        hashtable.put("23", "黑龙江");
        hashtable.put("31", "上海");
        hashtable.put("32", "江苏");
        hashtable.put("33", "浙江");
        hashtable.put("34", "安徽");
        hashtable.put("35", "福建");
        hashtable.put("36", "江西");
        hashtable.put("37", "山东");
        hashtable.put("41", "河南");
        hashtable.put("42", "湖北");
        hashtable.put("43", "湖南");
        hashtable.put("44", "广东");
        hashtable.put("45", "广西");
        hashtable.put("46", "海南");
        hashtable.put("50", "重庆");
        hashtable.put("51", "四川");
        hashtable.put("52", "贵州");
        hashtable.put("53", "云南");
        hashtable.put("54", "西藏");
        hashtable.put("61", "陕西");
        hashtable.put("62", "甘肃");
        hashtable.put("63", "青海");
        hashtable.put("64", "宁夏");
        hashtable.put("65", "新疆");
        hashtable.put("71", "台湾");
        hashtable.put("81", "香港");
        hashtable.put("82", "澳门");
        hashtable.put("91", "国外");
        return hashtable;
    }

    /**
     * 功能：判断字符串是否为数字
     * 
     * @param str
     * @return
     */
    private  boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (isNum.matches()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 功能：判断字符串是否为日期格式
     * @param str
     * @return
     */
    public  boolean isDate(String strDate) {
        Pattern pattern = Pattern
                .compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
        Matcher m = pattern.matcher(strDate);
        if (m.matches()) {
            return true;
        } else {
            return false;
        }
    }
	public String getBianhao() {
		return bianhao;
	}
	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJuweihui() {
		return juweihui;
	}
	public void setJuweihui(String juweihui) {
		this.juweihui = juweihui;
	}
	public String getXianzhuzhi() {
		return xianzhuzhi;
	}
	public void setXianzhuzhi(String xianzhuzhi) {
		this.xianzhuzhi = xianzhuzhi;
	}
	public String getJiandangriqi() {
		return jiandangriqi;
	}
	public void setJiandangriqi(String jiandangriqi) {
		this.jiandangriqi = jiandangriqi;
	}
	public String getXingbie() {
		return xingbie;
	}
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	public String getShenfenzhenghao() {
		return shenfenzhenghao;
	}

	public void setShenfenzhenghao(String shenfenzhenghao) {
		this.shenfenzhenghao = shenfenzhenghao;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGongzuodanwei() {
		return gongzuodanwei;
	}
	public void setGongzuodanwei(String gongzuodanwei) {
		this.gongzuodanwei = gongzuodanwei;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLianName() {
		return lianName;
	}
	public void setLianName(String lianName) {
		this.lianName = lianName;
	}
	public String getLianPhone() {
		return lianPhone;
	}
	public void setLianPhone(String lianPhone) {
		this.lianPhone = lianPhone;
	}
	public String getMinzu() {
		return minzu;
	}
	public void setMinzu(String minzu) {
		this.minzu = minzu;
	}
	public String getGuoji() {
		return guoji;
	}

	public void setGuoji(String guoji) {
		this.guoji = guoji;
	}

	public String getXueli() {
		return xueli;
	}
	public void setXueli(String xueli) {
		this.xueli = xueli;
	}
	public String getZhiye() {
		return zhiye;
	}
	public void setZhiye(String zhiye) {
		this.zhiye = zhiye;
	}
	public String getYiliaofufei() {
		return yiliaofufei;
	}
	public void setYiliaofufei(String yiliaofufei) {
		this.yiliaofufei = yiliaofufei;
	}
	public String getHunyin() {
		return hunyin;
	}
	public void setHunyin(String hunyin) {
		this.hunyin = hunyin;
	}
	public String getJiandangren() {
		return jiandangren;
	}
	public void setJiandangren(String jiandangren) {
		this.jiandangren = jiandangren;
	}
	public String getZerenyisheng() {
		return zerenyisheng;
	}
	public void setZerenyisheng(String zerenyisheng) {
		this.zerenyisheng = zerenyisheng;
	}
	public String getGuominshi() {
		return guominshi;
	}
	public void setGuominshi(String guominshi) {
		this.guominshi = guominshi;
	}
	public String getBaolushi() {
		return baolushi;
	}
	public void setBaolushi(String baolushi) {
		this.baolushi = baolushi;
	}
	public String getBaolushibeizhu() {
		return baolushibeizhu;
	}
	public void setBaolushibeizhu(String baolushibeizhu) {
		this.baolushibeizhu = baolushibeizhu;
	}
	public String getRenqun() {
		return renqun;
	}
	public void setRenqun(String renqun) {
		this.renqun = renqun;
	}
	public String getGaoxueyaTime() {
		return gaoxueyaTime;
	}
	public void setGaoxueyaTime(String gaoxueyaTime) {
		this.gaoxueyaTime = gaoxueyaTime;
	}
	public String getTangTime() {
		return tangTime;
	}
	public void setTangTime(String tangTime) {
		this.tangTime = tangTime;
	}
	public String getGuanTime() {
		return guanTime;
	}
	public void setGuanTime(String guanTime) {
		this.guanTime = guanTime;
	}
	public String getExingTime() {
		return exingTime;
	}
	public void setExingTime(String exingTime) {
		this.exingTime = exingTime;
	}
	public String getNaoTime() {
		return naoTime;
	}
	public void setNaoTime(String naoTime) {
		this.naoTime = naoTime;
	}
	public String getJieTime() {
		return jieTime;
	}
	public void setJieTime(String jieTime) {
		this.jieTime = jieTime;
	}
	public String getJingTime() {
		return jingTime;
	}
	public void setJingTime(String jingTime) {
		this.jingTime = jingTime;
	}
	public String getGanTime() {
		return ganTime;
	}
	public void setGanTime(String ganTime) {
		this.ganTime = ganTime;
	}
	public String getQitaTime() {
		return qitaTime;
	}
	public void setQitaTime(String qitaTime) {
		this.qitaTime = qitaTime;
	}
	public String getZhiyeTime() {
		return zhiyeTime;
	}
	public void setZhiyeTime(String zhiyeTime) {
		this.zhiyeTime = zhiyeTime;
	}
	public String getCOPOTime() {
		return COPOTime;
	}
	public void setCOPOTime(String cOPOTime) {
		COPOTime = cOPOTime;
	}
	public String getTaJiTime() {
		return taJiTime;
	}
	public void setTaJiTime(String taJiTime) {
		this.taJiTime = taJiTime;
	}
	public String getTaJiName() {
		return taJiName;
	}
	public void setTaJiName(String taJiName) {
		this.taJiName = taJiName;
	}
	public String getShuJi() {
		return shuJi;
	}
	public void setShuJi(String shuJi) {
		this.shuJi = shuJi;
	}
	public String getWaiJi() {
		return waiJi;
	}
	public void setWaiJi(String waiJi) {
		this.waiJi = waiJi;
	}
	public String getShouJi() {
		return shouJi;
	}
	public void setShouJi(String shouJi) {
		this.shouJi = shouJi;
	}
	public String getFatherInfo() {
		return fatherInfo;
	}
	public void setFatherInfo(String fatherInfo) {
		this.fatherInfo = fatherInfo;
	}
	public String getFatherOther() {
		return fatherOther;
	}
	public void setFatherOther(String fatherOther) {
		this.fatherOther = fatherOther;
	}
	public String getMotherInfo() {
		return motherInfo;
	}
	public void setMotherInfo(String motherInfo) {
		this.motherInfo = motherInfo;
	}
	public String getMotherOther() {
		return motherOther;
	}
	public void setMotherOther(String motherOther) {
		this.motherOther = motherOther;
	}
	public String getBroAnSisInfo() {
		return broAnSisInfo;
	}
	public void setBroAnSisInfo(String broAnSisInfo) {
		this.broAnSisInfo = broAnSisInfo;
	}
	public String getBroAnSisOther() {
		return broAnSisOther;
	}
	public void setBroAnSisOther(String broAnSisOther) {
		this.broAnSisOther = broAnSisOther;
	}
	public String getSonInfo() {
		return sonInfo;
	}
	public void setSonInfo(String sonInfo) {
		this.sonInfo = sonInfo;
	}
	public String getSonOther() {
		return sonOther;
	}
	public void setSonOther(String sonOther) {
		this.sonOther = sonOther;
	}
	public String getYichuanbing() {
		return yichuanbing;
	}
	public void setYichuanbing(String yichuanbing) {
		this.yichuanbing = yichuanbing;
	}
	public String getCanji() {
		return canji;
	}
	public void setCanji(String canji) {
		this.canji = canji;
	}
	public String getCanjiOther() {
		return canjiOther;
	}
	public void setCanjiOther(String canjiOther) {
		this.canjiOther = canjiOther;
	}
	public String getCanjiNum() {
		return canjiNum;
	}
	public void setCanjiNum(String canjiNum) {
		this.canjiNum = canjiNum;
	}
	public String getChufang() {
		return chufang;
	}
	public void setChufang(String chufang) {
		this.chufang = chufang;
	}
	public String getRanliao() {
		return ranliao;
	}
	public void setRanliao(String ranliao) {
		this.ranliao = ranliao;
	}
	public String getRanliaoOther() {
		return ranliaoOther;
	}
	public void setRanliaoOther(String ranliaoOther) {
		this.ranliaoOther = ranliaoOther;
	}
	public String getYinshui() {
		return yinshui;
	}
	public void setYinshui(String yinshui) {
		this.yinshui = yinshui;
	}
	public String getYinsuiOther() {
		return yinsuiOther;
	}
	public void setYinsuiOther(String yinsuiOther) {
		this.yinsuiOther = yinsuiOther;
	}
	public String getCesuo() {
		return cesuo;
	}
	public void setCesuo(String cesuo) {
		this.cesuo = cesuo;
	}
	public String getQinchulan() {
		return qinchulan;
	}
	public void setQinchulan(String qinchulan) {
		this.qinchulan = qinchulan;
	}
	public String getHigh() {
		return high;
	}
	public void setHigh(String high) {
		this.high = high;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getTunwei() {
		return tunwei;
	}
	public void setTunwei(String tunwei) {
		this.tunwei = tunwei;
	}
	public String getYaowei() {
		return yaowei;
	}
	public void setYaowei(String yaowei) {
		this.yaowei = yaowei;
	}
	public String getShousuoya() {
		return shousuoya;
	}
	public void setShousuoya(String shousuoya) {
		this.shousuoya = shousuoya;
	}
	public String getShuzhangya() {
		return shuzhangya;
	}
	public void setShuzhangya(String shuzhangya) {
		this.shuzhangya = shuzhangya;
	}
	
	/**
	 * 用于转换相关格式  将数字代码转成汉字
	 */
	public void zhuanhuan(){
		/*
		 * 可选项
			代码 名称
			1 化学品
			2 毒物
			3 射线
		 * */
		if(baolushi == "1" || baolushi.equals("1")){
			baolushi = "单设";
		}else if(baolushi == "2" || baolushi.equals("2")){
			baolushi = "室内";
		}else if(baolushi == "3" || baolushi.equals("3")){
			baolushi = "室外";
		}
		
		/*
		 * 人群分类
			可选项
			代码 名称
			1 健康人群
			2 慢病高危人群
			3 慢病患者人群
			默认为
			1 健康人群
		 * */
		if(renqun == "1" || renqun.equals("1")){
			renqun = "0";
		}else if(renqun == "2" || renqun.equals("2")){
			renqun = "1";
		}else if(qinchulan == "3" || qinchulan.equals("3")){
			renqun = "2";
		}else{
			renqun="健康人群";
		}
		/*
		 * 禽畜栏
			可选项
			代码 名称
			1 单设
			2 室内
			3 室外
		 * 
		 * */
		if(qinchulan == "1" || qinchulan.equals("1")){
			qinchulan = "单设";
		}else if(qinchulan == "2" || qinchulan.equals("2")){
			qinchulan = "室内";
		}else if(qinchulan == "3" || qinchulan.equals("3")){
			qinchulan = "室外";
		}
		
		/*
		 * 厕所
			可选项
			代码 名称
			1 卫生厕所
			2 一格或二格粪池式
			3 马桶
			4 露天粪坑
			5 简易棚厕  
		 * */
		if(cesuo == "1" || cesuo.equals("1")){
			cesuo = "卫生厕所";
		}else if(cesuo == "2" || cesuo.equals("2")){
			cesuo = "一格或二格粪池式";
		}else if(cesuo == "3" || cesuo.equals("3")){
			cesuo = "马桶";
		}else if(cesuo == "4" || cesuo.equals("4")){
			cesuo = "露天粪坑";
		}else if(cesuo == "5" || cesuo.equals("5")){
			cesuo = "简易棚厕 ";
		}
		
		/*
		 * 饮水类型
			可选项
			代码 名称
			1 自来水
			2 经净化过滤的水
			3 井水
			4 河湖水
			5 塘水
			6 其他
		 * 
		 * */
		if(yinshui == "1" || yinshui.equals("1")){
			yinshui = "自来水";
		}else if(yinshui == "2" || yinshui.equals("2")){
			yinshui = "经净化过滤的水";
		}else if(yinshui == "3" || yinshui.equals("3")){
			yinshui = "井水";
		}else if(yinshui == "4" || yinshui.equals("4")){
			yinshui = "河湖水";
		}else if(yinshui == "5" || yinshui.equals("5")){
			yinshui = "塘水";
		}else if(yinshui == "6" || yinshui.equals("6")){
			yinshui = "其他";
		}
			
		/*
			可选项
			代码 名称
			1 液化气
			2 煤
			3 天然气
			4 沼气
			5 柴火
			6 其他   
		 * */
		if(ranliao == "1" || ranliao.equals("1")){
			ranliao = "液化气";
		}else if(ranliao == "2" || ranliao.equals("2")){
			ranliao = "煤";
		}else if(ranliao == "3" || ranliao.equals("3")){
			ranliao = "天然气";
		}else if(yinshui == "4" || ranliao.equals("4")){
			yinshui = "沼气";
		}else if(ranliao == "5" || ranliao.equals("5")){
			ranliao = "柴火";
		}else if(ranliao == "6" || ranliao.equals("6")){
			ranliao = "其他";
		}
		
		/*
		 * 厨房排风设施
			可选项
			代码 名称
			1 无
			2 油烟机
			3 换气扇
			4 烟囱
		 * */
		if(chufang == "1" || chufang.equals("1")){
			chufang = "无";
		}else if(chufang == "2" || chufang.equals("2")){
			chufang = "油烟机";
		}else if(chufang == "3" || chufang.equals("3")){
			chufang = "换气扇";
		}else if(chufang == "4" || chufang.equals("4")){
			chufang = "烟囱";
		}
		
		/*
		 * 残疾
			可选项
			代码 名称
			1 耳残疾
			2 语言残疾
			3 肢体残疾
			4 智力残疾
			5 眼残疾
			6 精神残疾
		 * 
		 * */
		if(canji == "1" || canji.equals("1")){
			canji = "耳残疾";
		}else if(canji == "2" || canji.equals("2")){
			canji = "语言残疾";
		}else if(canji == "3" || canji.equals("3")){
			canji = "肢体残疾";
		}else if(canji == "4" || canji.equals("4")){
			canji = "智力残疾";
		}else if(canji == "5" || canji.equals("5")){
			canji = "眼残疾";
		}else if(canji == "6" || canji.equals("6")){
			canji = "精神残疾";
		}
		
		/*  学历
		 * 代码  名称
			1 博士
			2 硕士
			3 学士/本科
			4 大专
			5 中专
			6 高中
			7 初中
			8 小学
			9 文盲及半文盲
			0 不详
		 * */
		if(xueli == "1" || xueli.equals("1")){
			xueli = "博士";
		}else if(xueli == "2"|| xueli.equals("2")){
			xueli = "硕士";
		}else if(xueli == "3"|| xueli.equals("3")){
			xueli = "学士/本科";
		}else if(xueli == "4"|| xueli.equals("4")){
			xueli = "大专";
		}else if(xueli == "5"|| xueli.equals("5")){
			xueli = "中专";
		}else if(xueli == "6"|| xueli.equals("6")){
			xueli = "高中";
		}else if(xueli == "7"|| xueli.equals("7")){
			xueli = "初中";
		}else if(xueli == "8"|| xueli.equals("8")){
			xueli = "小学";
		}else if(xueli == "9"|| xueli.equals("9")){
			xueli = "文盲及半文盲";
		}else if(xueli == "0"|| xueli.equals("0")){
			xueli = "不详";
		}
		/*     职业
		 * 1 国家机关、党群组织、企业、事业单位负责人    
		 * 2 专业技术人员                              
		 * 3 办事人员和有关人员                        
		 * 4 商业、服务业人员                          
		 * 5 农、林、牧、渔、水利业生产人员             
		 * 6 生产、运输设备操作人员及有关人员            
		 * 7 军人                                      
		 * 8 不便分类的其他从业人员
		 * */
		if(zhiye == "1" || zhiye.equals("1")){
			zhiye = "国家机关、党群组织、企业、事业单位负责人";
		}else if(zhiye == "2"|| zhiye.equals("2")){
			zhiye = "专业技术人员";
		}else if(zhiye == "3" || zhiye.equals("3")){
			zhiye = "办事人员和有关人员 ";
		}else if(zhiye == "4"|| zhiye.equals("4")){
			zhiye = "商业、服务业人员";
		}else if(zhiye == "5"|| zhiye.equals("5")){
			zhiye = "农、林、牧、渔、水利业生产人员";
		}else if(zhiye == "6"|| zhiye.equals("6")){
			zhiye = "生产、运输设备操作人员及有关人员 ";
		}else if(zhiye == "7" || zhiye.equals("7")){
			zhiye = "军人";
		}else if(zhiye == "8" || zhiye.equals("8")){
			xueli = "不便分类的其他从业人员";
		}	
		
		/*     婚姻状况
		 *  10 已婚
			21 未婚
			22 离婚
			23 丧偶
			30 分居
		 * */
		if(hunyin == "10" || hunyin.equals("10") ){
			hunyin = "已婚";
		}else if(hunyin == "21" || hunyin.equals("21") ){
			hunyin = "未婚";
		}else if(hunyin == "22" || hunyin.equals("22") ){
			hunyin = "离婚";
		}else if(hunyin == "23"|| hunyin.equals("23") ){
			hunyin = "丧偶";
		}else if(hunyin == "30" || hunyin.equals("30") ){
			hunyin = "分居";
		}
		/*     医疗付费方式
	    1 全公费
		2 部分公费
		3 城镇职工医疗保险
		4 城镇居民医疗保险
		5 商业医疗保险
		6 新型农村合作医疗
		7 贫困救助
		8 全自费
		9 其他
	 * */
		if(yiliaofufei == "1"|| yiliaofufei.equals("1")){
			yiliaofufei = "全公费";
		}else if(yiliaofufei == "2"|| yiliaofufei.equals("2")){
			yiliaofufei = "部分公费";
		}else if(yiliaofufei == "3" || yiliaofufei.equals("3")){
			yiliaofufei = "城镇职工医疗保险 ";
		}else if(yiliaofufei == "4" || yiliaofufei.equals("4")){
			yiliaofufei = "城镇居民医疗保险";
		}else if(yiliaofufei == "5" || yiliaofufei.equals("5")){
			yiliaofufei = "商业医疗保险";
		}else if(yiliaofufei == "6" || yiliaofufei.equals("6")){
			yiliaofufei = "新型农村合作医疗";
		}else if(yiliaofufei == "7" || yiliaofufei.equals("7")){
			yiliaofufei = "贫困救助";
		}else if(zhiye == "8" || yiliaofufei.equals("8")){
			yiliaofufei = "全自费";
		}else if(yiliaofufei == "9" || yiliaofufei.equals("9")){
			yiliaofufei = "其他";
		}
		if(fatherInfo.trim().equals("") || fatherInfo.trim().length()==0){
			return;
		}
		//父亲患病情况
		String[] a=fatherInfo.split(",");
		int m;
		StringBuffer sb = new StringBuffer();
		for(String s : a){
			try {
				m=Integer.valueOf(s);
				if(m == 1){
					sb.append("高血压,");
				}
				if(m == 2){
					sb.append("糖尿病,");
				}
				if(m == 3){
					sb.append("冠心病,");
				}
				if(m == 4){
					sb.append("恶性肿瘤 ,");
				}
				if(m == 5){
					sb.append("精神分裂症,");
				}
				if(m == 6){
					sb.append("结核病,");
				}
				if(m == 7){
					sb.append("肝炎,");
				}
				if(m == 8){
					sb.append("脑卒中,");
				}
				if(m == 9){
					sb.append("脑卒中,");
				}
				if(m == 10){
					sb.append("先天畸形,");
				}
				if(m == 11){
					sb.append("其他,");
				}
				if(m == 12){
					sb.append("慢性阻塞性肺疾病");
				}
				fatherInfo = sb.toString();
			} catch (Exception e) {  
				return ;
			}
		}
		//母亲患病情况
		if(motherInfo.trim().equals("") || motherInfo.trim().length()==0){
			return ;
		}
		a=motherInfo.split(",");
		sb = new StringBuffer();
		for(String s : a){
			try {
				m=Integer.valueOf(s);
				if(m == 1){
					sb.append("高血压,");
				}
				if(m == 2){
					sb.append("糖尿病,");
				}
				if(m == 3){
					sb.append("冠心病,");
				}
				if(m == 4){
					sb.append("恶性肿瘤 ,");
				}
				if(m == 5){
					sb.append("精神分裂症,");
				}
				if(m == 6){
					sb.append("结核病,");
				}
				if(m == 7){
					sb.append("肝炎,");
				}
				if(m == 8){
					sb.append("脑卒中,");
				}
				if(m == 9){
					sb.append("脑卒中,");
				}
				if(m == 10){
					sb.append("先天畸形,");
				}
				if(m == 11){
					sb.append("其他,");
				}
				if(m == 12){
					sb.append("慢性阻塞性肺疾病");
				}
				motherInfo = sb.toString();
			} catch (Exception e) {  
				return ;
			}
		}
		//兄弟姐妹患病情况
		if(broAnSisInfo.trim().equals("") || broAnSisInfo.trim().length()==0){
			return ;
		}
		a=broAnSisInfo.split(",");
		sb = new StringBuffer();
		for(String s : a){
			try {
				m=Integer.valueOf(s);
				if(m == 1){
					sb.append("高血压,");
				}
				if(m == 2){
					sb.append("糖尿病,");
				}
				if(m == 3){
					sb.append("冠心病,");
				}
				if(m == 4){
					sb.append("恶性肿瘤 ,");
				}
				if(m == 5){
					sb.append("精神分裂症,");
				}
				if(m == 6){
					sb.append("结核病,");
				}
				if(m == 7){
					sb.append("肝炎,");
				}
				if(m == 8){
					sb.append("脑卒中,");
				}
				if(m == 9){
					sb.append("脑卒中,");
				}
				if(m == 10){
					sb.append("先天畸形,");
				}
				if(m == 11){
					sb.append("其他,");
				}
				if(m == 12){
					sb.append("慢性阻塞性肺疾病");
				}
				broAnSisInfo = sb.toString();
			} catch (Exception e) {  
				return ;
			}
		}
		//子女患病情况
		if(sonInfo.trim().equals("") || sonInfo.trim().length()==0){
			return ;
		}
		a=sonInfo.split(",");
		sb = new StringBuffer();
		for(String s : a){
			try {
				m=Integer.valueOf(s);
				if(m == 1){
					sb.append("高血压,");
				}
				if(m == 2){
					sb.append("糖尿病,");
				}
				if(m == 3){
					sb.append("冠心病,");
				}
				if(m == 4){
					sb.append("恶性肿瘤 ,");
				}
				if(m == 5){
					sb.append("精神分裂症,");
				}
				if(m == 6){
					sb.append("结核病,");
				}
				if(m == 7){
					sb.append("肝炎,");
				}
				if(m == 8){
					sb.append("脑卒中,");
				}
				if(m == 9){
					sb.append("脑卒中,");
				}
				if(m == 10){
					sb.append("先天畸形,");
				}
				if(m == 11){
					sb.append("其他,");
				}
				if(m == 12){
					sb.append("慢性阻塞性肺疾病");
				}
				sonInfo = sb.toString();
			} catch (Exception e) {  
				return ;
			}
		}
	}
}
