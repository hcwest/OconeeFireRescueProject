package model;

public class Certifications {
	private String certificationName;
	private int expirationPeriod;
	private String certifyingAgency;
	
public Certifications() {
	
}

public Certifications(String certificationName, int expirationPeriod, String certifyingAgency) {
	this.certificationName = certificationName;
	this.expirationPeriod = expirationPeriod;
	this.certifyingAgency = certifyingAgency;
}

public String getCertificationName() {
	return certificationName;
}

public void setCertificationName(String certificationName) {
	this.certificationName = certificationName;
}

public int getExpirationPeriod() {
	return expirationPeriod;
}

public void setExpirationPeriod(int expirationPeriod) {
	this.expirationPeriod = expirationPeriod;
}

public String getCertifyingAgency() {
	return certifyingAgency;
}

public void setCertifyingAgency(String certifyingAgency) {
	this.certifyingAgency = certifyingAgency;
}

@Override
public String toString() {
	return "Certifications [certificationName=" + certificationName + ", expirationPeriod=" + expirationPeriod
			+ ", certifyingAgency=" + certifyingAgency + "]";
}



}
