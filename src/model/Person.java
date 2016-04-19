package model;

public class Person {

	public String radioNumber; //pk
	public String firstName;
	public String lastName;
	public String position;
	public String gender;
	public String dateOfBirth;
	public String address;
	public String workPhone;
	public String mobilePhone;
	public int stationNumber;
	public boolean isActive;
	
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Person(String radioNumber, String firstName, String lastName, String position, String gender, String dateOfBirth, String address, String workPhone, String mobilePhone, int stationNumber, boolean isActive) {
		this.radioNumber = radioNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.workPhone = workPhone;
		this.mobilePhone = mobilePhone;
		this.stationNumber = stationNumber;
		this.isActive = isActive;
	}


	public String getRadioNumber() {
		return radioNumber;
	}


	public void setRadioNumber(String radioNumber) {
		this.radioNumber = radioNumber;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getWorkPhone() {
		return workPhone;
	}


	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}


	public String getMobilePhone() {
		return mobilePhone;
	}


	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}


	public int getStationNumber() {
		return stationNumber;
	}


	public void setStationNumber(int stationNumber) {
		this.stationNumber = stationNumber;
	}


	public boolean isActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
	
}
