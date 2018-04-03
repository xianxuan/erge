package com.jmjk.pojo;

import java.util.List;



public class PhysicalExamBypersonalPage {
	 private int endrow;
	    private int pagenum;
	    private int pagesize;
	    private int pages;
	    private List<PhysicalExamBypersonalPageResult> result;
	    private int startrow;
	    private int total;
	    public void setEndrow(int endrow) {
	         this.endrow = endrow;
	     }
	     public int getEndrow() {
	         return endrow;
	     }

	    public void setPagenum(int pagenum) {
	         this.pagenum = pagenum;
	     }
	     public int getPagenum() {
	         return pagenum;
	     }

	    public void setPagesize(int pagesize) {
	         this.pagesize = pagesize;
	     }
	     public int getPagesize() {
	         return pagesize;
	     }

	    public void setPages(int pages) {
	         this.pages = pages;
	     }
	     public int getPages() {
	         return pages;
	     }

	    public void setResult(List<PhysicalExamBypersonalPageResult> result) {
	         this.result = result;
	     }
	     public List<PhysicalExamBypersonalPageResult> getResult() {
	         return result;
	     }

	    public void setStartrow(int startrow) {
	         this.startrow = startrow;
	     }
	     public int getStartrow() {
	         return startrow;
	     }

	    public void setTotal(int total) {
	         this.total = total;
	     }
	     public int getTotal() {
	         return total;
	     }
}
