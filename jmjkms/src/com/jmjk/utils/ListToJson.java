package com.jmjk.utils;

import java.lang.reflect.Field;
import java.util.List;


/**
 * 将实体或实体list某些字段转换为json串
 * @author 李利聪      
 */
public class ListToJson<T> {

	 

	/**
	 * 将实体List某些字段转换为json串
	 * @param list       实体list
	 * @param fieldList  需要输出的字段
	 * @return           json字符串
	 */
	public String listToJson(List<T> list, List<String> fieldList) {

		// 拼接json的串
		StringBuffer jsonStr = new StringBuffer();

		// 数据为空直接返回空
		if (null == list || 0 == list.size()) {

			return null;
		}
		
		// class对象
		Class<?> classType = list.get(0).getClass();

		jsonStr.append("[");

		// 此JavaBean中所声明的所有字段

		Field[] fields = classType.getDeclaredFields();

		for (int i = 0; i < list.size(); i++) {

			jsonStr.append("{");

			for (Field field : fields) {
				
					// 得到字段名
					String fieldName = field.getName();

					if (fieldList.contains(fieldName)) {
						
					field.setAccessible(true);

					// 得到指定对象上此 Field 表示的字段的值
					Object fieldValue;

					try {

						fieldValue = field.get(list.get(i));

						jsonStr.append("\"").append(fieldName.toLowerCase())
								.append("\":").append("\"").append(fieldValue)
								.append("\"").append(",");

					} catch (IllegalArgumentException e) {

						e.printStackTrace();

					} catch (IllegalAccessException e) {

						e.printStackTrace();
					}
				}
			}
				jsonStr.deleteCharAt(jsonStr.length() - 1);

				jsonStr.append("},");
		}

		jsonStr.deleteCharAt(jsonStr.length() - 1);

		jsonStr.append("]");

		return jsonStr.toString();
	}
	
	
	/**
	 * 将实体某些字段转换为json串
	 * @param T          实体
	 * @param fieldList  需要输出的字段
	 * @return           json字符串
	 */
	public String entityToJson(T entity, List<String> fieldList) {

		// 拼接json的串
		StringBuffer jsonStr = new StringBuffer();

		// 数据为空直接返回空
		if (null == entity) {

			return null;
		}
		
		// class对象
		Class<?> classType = entity.getClass();

		// 此JavaBean中所声明的所有字段
		Field[] fields = classType.getDeclaredFields();
		
			jsonStr.append("{");

			for (Field field : fields) {
				
					// 得到字段名
					String fieldName = field.getName();

					if (fieldList.contains(fieldName)) {
						
					field.setAccessible(true);

					// 得到指定对象上此 Field 表示的字段的值
					Object fieldValue;

					try {

						fieldValue = field.get(entity);
						if(fieldValue instanceof Integer|| fieldValue==null){
							jsonStr.append("\"").append(fieldName.toLowerCase())
							.append("\":").append(fieldValue).append(",");
						}
						else{
							jsonStr.append("\"").append(fieldName.toLowerCase())
							.append("\":").append("\"").append(fieldValue)
							.append("\"").append(",");
						}
						

					} catch (IllegalArgumentException e) {

						e.printStackTrace();

					} catch (IllegalAccessException e) {

						e.printStackTrace();
					}
				}
			}
				jsonStr.deleteCharAt(jsonStr.length() - 1);

				jsonStr.append("},");

		jsonStr.deleteCharAt(jsonStr.length() - 1);

		return jsonStr.toString();
	}
	
}