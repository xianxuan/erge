package com.jmjk.pojo;


public class PhysicalExamBypersonal {
	//根据 健康档案ID 和 belongsystem 获得的所有体检记录的josn 将其解析成一个对象。 所有记录为 List类型的对象
	private int code;
    private String message;
    private PhysicalExamBypersonalPage page;
    public void setCode(int code) {
         this.code = code;
     }
     public int getCode() {
         return code;
     }

    public void setMessage(String message) {
         this.message = message;
     }
     public String getMessage() {
         return message;
     }

    public void setPage(PhysicalExamBypersonalPage page) {
         this.page = page;
     }
     public PhysicalExamBypersonalPage getPage() {
         return page;
     }
}
