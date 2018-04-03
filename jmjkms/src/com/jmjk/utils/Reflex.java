package com.jmjk.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.poi.ss.formula.functions.T;

/**
 *  利用反射将 t实体 的属性值   放入 newt中
 *   用于 实体 拥有大量 属性时 对每一个属性值 获取与  对同种实体相同属性赋值
 * @author 郑富良
 *
 */
public class Reflex{
	/**
	 * 仅用于实体属性值 为： String, Integer, Boolean,Date,Double, Character, Timestamp
	 * 
	 * @param newt	被赋值的实体
	 * @param t     需要取出 属性值的实体
	 * @return 		被赋值的 最终实体
	 */
	
	public static <T>T getNewT(T newt , T t){
		
		Field[] field = t.getClass().getDeclaredFields();
		try {
		 
			for (int j = 0; j < field.length; j++) {  
           
            String name = field[j].getName();  // 属性的名字  
            														  
            name = name.substring(0, 1).toUpperCase() + name.substring(1);// 将属性的首字符大写，
            
            String type = field[j].getGenericType().toString(); // 属性的类型
            if (type.equals("class java.lang.String")) { 		// 判断属性类型
                Method m = t.getClass().getMethod("get" + name);
                String value = (String) m.invoke(t);		 // get方法获取属性值
                if (value != null) {
                    m = newt.getClass().getMethod("set"+name,String.class);
                    m.invoke(newt, value);
                }
            }
            if (type.equals("class java.lang.Integer")) {
                Method m = t.getClass().getMethod("get" + name);
                Integer value = (Integer) m.invoke(t);
                if (value != null) {
                    m = newt.getClass().getMethod("set"+name,Integer.class);
                    m.invoke(newt, value);
                }
            }
            if (type.equals("class java.lang.Boolean")) {
                Method m = t.getClass().getMethod("get" + name);
                Boolean value = (Boolean) m.invoke(t);
                if (value != null) {
                    m = newt.getClass().getMethod("set"+name,Boolean.class);
                    m.invoke(newt, value);
                }
            }
            if (type.equals("class java.util.Date")) {
                Method m = t.getClass().getMethod("get" + name);
                Date value = (Date) m.invoke(t);
                if (value!= null) {
                    m = newt.getClass().getMethod("set"+name,Date.class);
                    m.invoke(newt, value);
                }
            }
            
            if(type.equals("class java.lang.Double")){
            	Method m = t.getClass().getMethod("get" + name);
            	Double value = (Double) m.invoke(t);
                if (value!= null) {
                    m = newt.getClass().getMethod("set"+name,Double.class);
                    m.invoke(newt, value);
                }
            }
            if(type.equals("class java.lang.Character")){
            	Method m=t.getClass().getMethod("get"+name);
            	Character value = (Character) m.invoke(t);
                if (value!= null) {
                    m = newt.getClass().getMethod("set"+name,Character.class);
                    m.invoke(newt, value);
                }
            	
            }
            if(type.equals("class java.sql.Timestamp")){
            	Method m=t.getClass().getMethod("get"+name);
            	Timestamp value = (Timestamp) m.invoke(t);
                if (value!= null) {
                    m = newt.getClass().getMethod("set"+name,Timestamp.class);
                    m.invoke(newt, value);
                }
            	
            }
          
		 }
		} catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
		 
		return newt;		
	}
}
