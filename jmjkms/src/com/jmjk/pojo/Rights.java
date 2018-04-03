package com.jmjk.pojo;

import java.util.ArrayList;

public class Rights {

	private ArrayList<Right> rights;
	
	
	@Override
	public String toString() {
		return "Rights [rights=" + rights + "]";
	}

	public Rights() {
		super();
	}

	public ArrayList<Right> getRights() {
		return rights;
	}

	public void setRights(ArrayList<Right> rights) {
		this.rights = rights;
	}
	
	
	public class Right{
		
		public String module;
		public String rightsName;
		public String rightsCode;
		public String rightsValue;
		
		@Override
		public String toString() {
			return "Right [module=" + module + ", rightsName=" + rightsName
					+ ", rightsCode=" + rightsCode + ", rightsValue="
					+ rightsValue + "]";
		}
		public Right() {
			super();
		}
		public String getModule() {
			return module;
		}
		public void setModule(String module) {
			this.module = module;
		}
		public String getRightsName() {
			return rightsName;
		}
		public void setRightsName(String rightsName) {
			this.rightsName = rightsName;
		}
		public String getRightsCode() {
			return rightsCode;
		}
		public void setRightsCode(String rightsCode) {
			this.rightsCode = rightsCode;
		}
		public String getRightsValue() {
			return rightsValue;
		}
		public void setRightsValue(String rightsValue) {
			this.rightsValue = rightsValue;
		}
	}
}
