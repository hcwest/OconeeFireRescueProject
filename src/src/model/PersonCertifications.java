package model;

public class PersonCertifications {
	private int radioNumber;
	private String certificationName;
	private Boolean isExpired;
	private String earnedDate;
	private String renewalDate;
	
	
	public PersonCertifications() {
		
	}
	
	public PersonCertifications(int radioNumber, String certificationName, Boolean isExpired, String earnedDate,
			String renewalDate) {
	this.radioNumber = radioNumber;
	this.certificationName = certificationName;
	this.isExpired = isExpired;
	this.earnedDate = earnedDate;
	this.renewalDate = renewalDate;
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

	public Boolean getIsExpired() {
		return isExpired;
	}

	public void setIsExpired(Boolean isExpired) {
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
		return "PersonCertifications [radioNumber=" + radioNumber + ", certificationName=" + certificationName
				+ ", isExpired=" + isExpired + ", earnedDate=" + earnedDate + ", renewalDate=" + renewalDate + "]";
	}
	
	

	


}

