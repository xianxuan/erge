package com.jmjk.utils;

import javax.servlet.http.HttpServletRequest;

public  class Resubmit {
	  public static boolean isRepeatSubmit(HttpServletRequest request,String client_token) {
		               //String client_token = request.getParameter("token");
		              //1、如果用户提交的表单数据中没有token，则用户是重复提交了表单
		              if(client_token==null){
		                  return true;
		               }
		               //取出存储在Session中的token
		               String server_token = (String) request.getSession().getAttribute("token");
		             //2、如果当前用户的Session中不存在Token(令牌)，则用户是重复提交了表单
		               if(server_token==null){
		                  return true;
		              }
		               //3、存储在Session中的Token(令牌)与表单提交的Token(令牌)不同，则用户是重复提交了表单
		               if(!client_token.equals(server_token)){
		                  return true;
		               }
		               
		               return false;
		         }
	  
	  /**
	   * 根据令牌名称  获取令牌 
	   * zfl
	   */
	  public static boolean isRepeatSubmit(HttpServletRequest request,String client_token,String tokenName) {
          //String client_token = request.getParameter("token");
         //1、如果用户提交的表单数据中没有token，则用户是重复提交了表单
         if(client_token==null){
             return true;
          }
          //取出存储在Session中的token
          String server_token = (String) request.getSession().getAttribute(tokenName);
        //2、如果当前用户的Session中不存在Token(令牌)，则用户是重复提交了表单
          if(server_token==null){
             return true;
         }
          //3、存储在Session中的Token(令牌)与表单提交的Token(令牌)不同，则用户是重复提交了表单
          if(!client_token.equals(server_token)){
             return true;
          }
          
          return false;
    }
}
