/**
 * 
 */
package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.*;


public class ReadQuery {
	
	private Connection connection;
	private ResultSet personResults;
	private ResultSet certificationResults;
	private ResultSet personHasCertificationResults;
	
	public ReadQuery(String dbName, String uname, String pwd){
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		
		// set up the driver
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doReadPerson(){
		String query = "select * from person"; //**********************************************************
		
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			this.personResults= ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doReadPersonHasCert(){
		String query = "select * from person_has_certifications"; //**********************************************************
		
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			this.personHasCertificationResults= ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doReadCertification(){
		String query = "select * from certifications"; //**********************************************************
		
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			this.certificationResults= ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getPersonTable(){
//		String test = "test";
		String personTable ="";
		personTable += "<table border=1>";
		
		try {
			while(this.personResults.next()){
				Person person = new Person();
				person.setRadioNumber(this.personResults.getInt("radioNumber"));
				person.setFirstName(this.personResults.getString("firstName"));
				person.setLastName(this.personResults.getString("lastName"));
				person.setPosition(this.personResults.getString("position"));
				person.setGender(this.personResults.getString("gender"));
				person.setDateOfBirth(this.personResults.getString("dateOfBirth"));
				person.setAddress(this.personResults.getString("address"));
				person.setWorkPhone(this.personResults.getString("workPhone"));
				person.setMobilePhone(this.personResults.getString("mobilePhone"));
				person.setStationNumber(this.personResults.getInt("stationNumber"));
				person.setActive(this.personResults.getString("isActive"));
				person.setEmail(this.personResults.getString("email"));
				
				personTable +="<tr>";
				personTable +="<td>";
				personTable += person.getRadioNumber();
				personTable +="</td>";
				personTable +="<td>";
				personTable += person.getFirstName();
				personTable +="</td>";
				personTable +="<td>";
				personTable += person.getLastName();
				personTable +="</td>";
				personTable +="<td>";
				personTable += person.getPosition();
				personTable +="</td>";
				personTable +="<td>";
				personTable += person.getGender();
				personTable +="</td>";
				personTable +="<td>";
				personTable += person.getDateOfBirth();
				personTable +="</td>";
				personTable +="<td>";
				personTable += person.getAddress();
				personTable +="</td>";
				personTable +="<td>";
				personTable += person.getWorkPhone();
				personTable +="</td>";
				personTable +="<td>";
				personTable += person.getMobilePhone();
				personTable +="</td>";
				personTable +="<td>";
				personTable += person.getStationNumber();
				personTable +="</td>";
				personTable +="<td>";
				personTable += person.getEmail();
				personTable +="</td>";
				personTable +="<td>";
				   personTable += "<a href=updatePersonForm?radioNumber=" + person.getRadioNumber() + " >update</a> <a href=deletePerson?radioNumber=" + person.getRadioNumber() + " >delete</a>";
				personTable +="</td>";
				personTable +="</tr>";		
	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		personTable += "</table>";
		return personTable;
//		return test;
	}
	
	public String getPersonHasCertTable(){
		String personHasCertificationTable ="";
		personHasCertificationTable += "<table border=1>";
		
		try {
			while(this.personHasCertificationResults.next()){
				PersonCertifications personCertification = new PersonCertifications();
				personCertification.setRadioNumber(this.personHasCertificationResults.getInt("radioNumber"));
				personCertification.setCertificationName(this.personHasCertificationResults.getString("certificationName"));
				personCertification.setIsExpired(this.personHasCertificationResults.getString("isExpired"));
				personCertification.setEarnedDate(this.personHasCertificationResults.getString("earnedDate"));
				personCertification.setRenewalDate(this.personHasCertificationResults.getString("renewalDate"));
				
				personHasCertificationTable +="<tr>";
				personHasCertificationTable +="<td>";
				personHasCertificationTable += personCertification.getRadioNumber();
				personHasCertificationTable +="</td>";
				personHasCertificationTable +="<td>";
				personHasCertificationTable += personCertification.getCertificationName();
				personHasCertificationTable +="</td>";
				personHasCertificationTable +="<td>";
				personHasCertificationTable += personCertification.getIsExpired();
				personHasCertificationTable +="</td>";
				personHasCertificationTable +="<td>";
				personHasCertificationTable += personCertification.getEarnedDate();
				personHasCertificationTable +="</td>";
				personHasCertificationTable +="<td>";
				personHasCertificationTable += personCertification.getRenewalDate();
				personHasCertificationTable +="</td>";
				personHasCertificationTable +="<td>";
				   personHasCertificationTable += "<a href=updatePersonHasCertForm?radioNumber=" + personCertification.getRadioNumber() + " , certificationName=" + personCertification.getCertificationName() + " >update</a> <a href=deletePersonHasCert?radioNumber=" + personCertification.getRadioNumber() + " , certificationName=" + personCertification.getCertificationName() + " >delete</a>";
				personHasCertificationTable +="</td>";
				personHasCertificationTable +="</tr>";
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		personHasCertificationTable += "</table>";
		return personHasCertificationTable;
	}
	
	public String getCertificationTable(){
		String certificationTable ="";
		certificationTable += "<table border=1>";
		
		try {
			while(this.certificationResults.next()){
				Certifications certification = new Certifications();
				certification.setCertificationName(this.certificationResults.getString("certificationName"));
				certification.setExpirationPeriod(this.certificationResults.getInt("expirationPeriod"));
				certification.setCertifyingAgency(this.certificationResults.getString("certifyingAgency"));
				
				

				certificationTable +="<tr>";
				certificationTable +="<td>";
				certificationTable += certification.getCertificationName();
				certificationTable +="</td>";
				certificationTable +="<td>";
				certificationTable += certification.getExpirationPeriod();
				certificationTable +="</td>";
				certificationTable +="<td>";
				certificationTable += certification.getCertifyingAgency();
				certificationTable +="</td>";
				certificationTable +="<td>";
				   certificationTable += "<a href=updateCertForm?radioNumber=" + certification.getCertificationName() + " >update</a> <a href=deleteCert?radioNumber=" + certification.getCertificationName() + " >delete</a>";
				certificationTable +="</td>";
				certificationTable +="</tr>";
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		certificationTable += "</table>";
		return certificationTable;
	}
	
	
	

}
