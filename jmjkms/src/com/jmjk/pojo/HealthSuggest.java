package com.jmjk.pojo;
import java.sql.Timestamp;
import java.util.ArrayList;


public class HealthSuggest {

	public int code;
	public String message;
	public Page page;
	
	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
 
	public Page getPage() {
		return page;
	}


	public void setPage(Page page) {
		this.page = page;
	}


	public HealthSuggest() {
		super();
		// TODO Auto-generated constructor stub
	}


	public HealthSuggest(int code, String message,
			com.jmjk.pojo.HealthSuggest.Page page) {
		super();
		this.code = code;
		this.message = message;
		this.page = page;
	}



	@Override
	public String toString() {
		return "HealthSuggest [code=" + code + ", message=" + message
				+ ", page=" + page + "]";
	}


	public class Page{
		public int endRow;
		public int pageNum;
		public int pageSize;
		public int pages;
		public ArrayList<Suggest> result;
		public int startRow;
		public int total;
		
		@Override
		public String toString() {
			return "Page [endRow=" + endRow + ", pageNum=" + pageNum
					+ ", pageSize=" + pageSize + ", pages=" + pages
					+ ", result=" + result + ", startRow=" + startRow
					+ ", total=" + total + "]";
		}
		public Page() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Page(int endRow, int pageNum, int pageSize, int pages,
				ArrayList<Suggest> result, int startRow, int total) {
			super();
			this.endRow = endRow;
			this.pageNum = pageNum;
			this.pageSize = pageSize;
			this.pages = pages;
			this.result = result;
			this.startRow = startRow;
			this.total = total;
		}
		public int getEndRow() {
			return endRow;
		}
		public void setEndRow(int endRow) {
			this.endRow = endRow;
		}
		public int getPageNum() {
			return pageNum;
		}
		public void setPageNum(int pageNum) {
			this.pageNum = pageNum;
		}
		public int getPageSize() {
			return pageSize;
		}
		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}
		public int getPages() {
			return pages;
		}
		public void setPages(int pages) {
			this.pages = pages;
		}
		public ArrayList<Suggest> getResult() {
			return result;
		}
		public void setResult(ArrayList<Suggest> result) {
			this.result = result;
		}
		public int getStartRow() {
			return startRow;
		}
		public void setStartRow(int startRow) {
			this.startRow = startRow;
		}
		public int getTotal() {
			return total;
		}
		public void setTotal(int total) {
			this.total = total;
		}
		
		
		public class Suggest{
			
			public String doctorAdvice;
			public int doctorId;
			public String doctorName;
			public int id;
			public int userId;
			public String userName;
			public String idNum;
			public String belongSystem;
			public String problem;
			public String createTime;
			public Suggest() {
				super();
				// TODO Auto-generated constructor stub
			}

			public Suggest(String doctorAdvice, int doctorId, String doctorName, int id, int userId, String userName,
					String idNum,String belongSyetem,String problem,String createTime) {
				super();
				this.doctorAdvice = doctorAdvice;
				this.doctorId = doctorId;
				this.doctorName = doctorName;
				this.id = id;
				this.userId = userId;
				this.userName = userName;
				this.idNum = idNum;
				this.belongSystem=belongSyetem;
				this.problem=problem;
				this.createTime=createTime;
			}

			@Override
			public String toString() {
				return "Suggest [doctorAdvice=" + doctorAdvice + ", doctorId=" + doctorId + ", doctorName=" + doctorName
						+ ", id=" + id + ", userId=" + userId + ", userName=" + userName + ", idNum=" + idNum + "]";
			}

			public String getDoctorAdvice() {
				return doctorAdvice;
			}

			public void setDoctorAdvice(String doctorAdvice) {
				this.doctorAdvice = doctorAdvice;
			}

			public int getDoctorId() {
				return doctorId;
			}

			public String getProblem() {
				return problem;
			}

			public String getCreateTime() {
				return createTime;
			}

			public void setCreateTime(String createTime) {
				this.createTime = createTime;
			}

			public void setProblem(String problem) {
				this.problem = problem;
			}

			public void setDoctorId(int doctorId) {
				this.doctorId = doctorId;
			}

			public String getDoctorName() {
				return doctorName;
			}

			public void setDoctorName(String doctorName) {
				this.doctorName = doctorName;
			}

			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}

			public int getUserId() {
				return userId;
			}

			public String getBelongSystem() {
				return belongSystem;
			}

			public void setBelongSystem(String belongSystem) {
				this.belongSystem = belongSystem;
			}

			public void setUserId(int userId) {
				this.userId = userId;
			}

			public String getUserName() {
				return userName;
			}

			public void setUserName(String userName) {
				this.userName = userName;
			}

			public String getIdNum() {
				return idNum;
			}

			public void setIdNum(String idNum) {
				this.idNum = idNum;
			}
            
		}
		
	}
	
}
