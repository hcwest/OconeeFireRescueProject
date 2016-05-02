package model;

public class PersonCertifications {
	private int radioNumber;
	private String certificationName;
	private String isExpired;
	private String earnedDate;
	private String renewalDate;
	private int id;
	
	
	public PersonCertifications() {
		
	}
	
	public PersonCertifications(int id, int radioNumber, String certificationName, String isExpired, String earnedDate,
			String renewalDate) {
	this.id = id;
	this.radioNumber = radioNumber;
	this.certificationName = certificationName;
	this.isExpired = isExpired;
	this.earnedDate = earnedDate;
	this.renewalDate = renewalDate;
	}
	
	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public int getRadioNumber() {
		return radioNumber;
	}

	public void setRadioNumber(int radioNumber) {
		this.radioNumber = radioNumber;
	}

	public String getCertificationName() {
		return certificationName;
	}

	public void setCertificationName(String certificationName) {
		this.certificationName = certificationName;
	}

	public String getIsExpired() {
		return isExpired;
	}

	public void setIsExpired(String isExpired) {
		this.isExpired = isExpired;
	}

	public String getEarnedDate() {
		return earnedDate;
	}

	public void setEarnedDate(String earnedDate) {
		this.earnedDate = earnedDate;
	}

	public String getRenewalDate() {
		return renewalDate;
	}

	public void setRenewalDate(String renewalDate) {
		this.renewalDate = renewalDate;
	}

	@Override
	public String toString() {
		return "PersonCertifications [id="+ id + ", radioNumber=" + radioNumber + ", certificationName=" + certificationName
				+ ", isExpired=" + isExpired + ", earnedDate=" + earnedDate + ", renewalDate=" + renewalDate + "]";
	}
	
	

	


}
