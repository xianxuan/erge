package com.jmjk.utils;
/**
 * 
 * @author 刘凤双
 *
 */
public class HtmlEscape {
	/**
	 * 将string中的特殊字符进行转义,用于pageHtml
	 * @param str
	 * @return
	 */
	public static String escapeHtml(String str){
		str = str.replace("<script>", "");
		str = str.replace("</script>", "");
		str = str.replace("\"", "&quot;");
		str = str.replace("<", "&lt;");
		str = str.replace(">", "&gt;");
		return str;
	}
	
	/**
	 * HTML 字符反转义
	 * @param str
	 * @return
	 */
	public static String unEscapeHtml(String str){
		str = str.replace("&lt;", "<");
		str = str.replace("&gt;", ">");
		str = str.replace("&quot;", "\"");
		return str;
	}
}
