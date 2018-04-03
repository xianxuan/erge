package com.jmjk.entity;
// default package

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TIncompleteRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_INCOMPLETE_RECORD2", catalog = "jmjk")
public class TIncompleteRecord2 implements java.io.Serializable {

	// Fields

	private Integer incompleteRecordId;
	private THealthFile THealthFile;
	private Timestamp incompleteRecordDate;
	private String incompleteDoctor;
	private String subInfor;
	private String ZDJG;
	private String disposalPlan;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;
	private String sg;

    private String tz;

    private String tizhi;

    private String tw;

    private String xl;

    private String ssy;

    private String szy;

    private String other;

    private String gms;

    private Timestamp fbsj;
	// Constructors

	/** default constructor */
	public TIncompleteRecord2() {
	}

	/** minimal constructor */
	public TIncompleteRecord2(THealthFile THealthFile) {
		this.THealthFile = THealthFile;
	}

	/** full constructor */
	public TIncompleteRecord2(THealthFile THealthFile,
			Timestamp incompleteRecordDate, String incompleteDoctor,
			String subInfor, String assess,
			String disposalPlan, String one, String two, String three,
			String four, String five) {
		this.THealthFile = THealthFile;
		this.incompleteRecordDate = incompleteRecordDate;
		this.incompleteDoctor = incompleteDoctor;
		this.subInfor = subInfor;
		this.disposalPlan = disposalPlan;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "INCOMPLETE_RECORD_ID", unique = true, nullable = false)
	public Integer getIncompleteRecordId() {
		return this.incompleteRecordId;
	}

	public void setIncompleteRecordId(Integer incompleteRecordId) {
		this.incompleteRecordId = incompleteRecordId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HEALTH_FILE_ID", nullable = false)
	public THealthFile getTHealthFile() {
		return this.THealthFile;
	}

	public void setTHealthFile(THealthFile THealthFile) {
		this.THealthFile = THealthFile;
	}

	@Column(name = "INCOMPLETE_RECORD_DATE", length = 19)
	public Timestamp getIncompleteRecordDate() {
		return this.incompleteRecordDate;
	}

	
	public void setIncompleteRecordDate(Timestamp incompleteRecordDate) {
		this.incompleteRecordDate = incompleteRecordDate;
	}

	@Column(name = "INCOMPLETE_DOCTOR")
	public String getIncompleteDoctor() {
		return this.incompleteDoctor;
	}

	public void setIncompleteDoctor(String incompleteDoctor) {
		this.incompleteDoctor = incompleteDoctor;
	}

	@Column(name = "SUB_INFOR", length = 65535)
	public String getSubInfor() {
		return this.subInfor;
	}

	public void setSubInfor(String subInfor) {
		this.subInfor = subInfor;
	}


	@Column(name = "DISPOSAL_PLAN", length = 65535)
	public String getDisposalPlan() {
		return this.disposalPlan;
	}

	public void setDisposalPlan(String disposalPlan) {
		this.disposalPlan = disposalPlan;
	}

	@Column(name = "ONE", length = 1000)
	public String getOne() {
		return this.one;
	}

	public void setOne(String one) {
		this.one = one;
	}

	@Column(name = "TWO", length = 1000)
	public String getTwo() {
		return this.two;
	}

	public void setTwo(String two) {
		this.two = two;
	}

	@Column(name = "THREE", length = 1000)
	public String getThree() {
		return this.three;
	}

	public void setThree(String three) {
		this.three = three;
	}

	@Column(name = "FOUR", length = 1000)
	public String getFour() {
		return this.four;
	}

	public void setFour(String four) {
		this.four = four;
	}

	@Column(name = "FIVE", length = 1000)
	public String getFive() {
		return this.five;
	}

	public void setFive(String five) {
		this.five = five;
	}

	 public String getSg() {
	        return sg;
	    }

	    public void setSg(String sg) {
	        this.sg = sg == null ? null : sg.trim();
	    }

	    public String getTz() {
	        return tz;
	    }

	    public void setTz(String tz) {
	        this.tz = tz == null ? null : tz.trim();
	    }

	    public String getTizhi() {
	        return tizhi;
	    }

	    public void setTizhi(String tizhi) {
	        this.tizhi = tizhi == null ? null : tizhi.trim();
	    }

	    public String getTw() {
	        return tw;
	    }

	    public void setTw(String tw) {
	        this.tw = tw == null ? null : tw.trim();
	    }

	    public String getXl() {
	        return xl;
	    }

	    public void setXl(String xl) {
	        this.xl = xl == null ? null : xl.trim();
	    }

	    public String getSsy() {
	        return ssy;
	    }

	    public void setSsy(String ssy) {
	        this.ssy = ssy == null ? null : ssy.trim();
	    }

	    public String getSzy() {
	        return szy;
	    }

	    public void setSzy(String szy) {
	        this.szy = szy == null ? null : szy.trim();
	    }

	    public String getOther() {
	        return other;
	    }

	    public void setOther(String other) {
	        this.other = other == null ? null : other.trim();
	    }

	    public String getGms() {
	        return gms;
	    }

	    public void setGms(String gms) {
	        this.gms = gms == null ? null : gms.trim();
	    }

	    public Timestamp getFbsj() {
	        return fbsj;
	    }

	    public void setFbsj(Timestamp fbsj) {
	        this.fbsj = fbsj;
	    }

		public String getZDJG() {
			return ZDJG;
		}

		public void setZDJG(String zDJG) {
			ZDJG = zDJG;
		}
	    
	    
}
