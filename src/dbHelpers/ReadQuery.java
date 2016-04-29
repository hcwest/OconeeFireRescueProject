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
	private ResultSet expiredCertsResults;
	

	
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
	
	public void doListMembers(){
		String query = "select firstName, lastName, radioNumber, stationNumber, email FROM person"; //**********************************************************
		
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			this.personResults = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doExpiredCerts(){
		String query = "SELECT person.radioNumber, firstName, lastName, certificationName, isExpired FROM person, person_has_certifications WHERE person.radioNumber = person_has_certifications.radioNumber AND isExpired = 'true';"; //**********************************************************
		
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			this.expiredCertsResults= ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doExpiredCertsFilter(String certificationName){
		String query = "SELECT person.radioNumber, firstName, lastName, certificationName, isExpired FROM person, person_has_certifications WHERE person.radioNumber = person_has_certifications.radioNumber AND isExpired = 'true' AND certificationName =?;"; //**********************************************************
		
		try {
			
			PreparedStatement ps = this.connection.prepareStatement(query);
			ps.setString(1, certificationName);
			this.expiredCertsResults= ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public String getPersonTable(){

		String personTable ="";
		personTable += "<table border=1>";
		
		personTable +="<tr>";
		personTable +="<th>";
		personTable +="Radio Number";
		personTable +="</th>";
		personTable +="<th>";
		personTable +="First Name";
		personTable +="</th>";
		personTable +="<th>";
		personTable +="Last Name";
		personTable +="</th>";
		personTable +="<th>";
		personTable +="Position";
		personTable +="</th>";
		personTable +="<th>";
		personTable +="Gender";
		personTable +="</th>";
		personTable +="<th>";
		personTable +="Date Of Birth";
		personTable +="</th>";
		personTable +="<th>";
		personTable +="Address";
		personTable +="</th>";
		personTable +="<th>";
		personTable +="Work Phone";
		personTable +="</th>";
		personTable +="<th>";
		personTable +="Mobile Phone";
		personTable +="</th>";
		personTable +="<th>";
		personTable +="Station Number";
		personTable +="</th>";
		personTable +="<th>";
		personTable +="Email";
		personTable +="</th>";
		personTable +="<th>";
		personTable +="Edit";
		personTable +="</th>";
		personTable +="</tr>";
		
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
		
		personHasCertificationTable +="<tr>";
		personHasCertificationTable +="<th>";
		personHasCertificationTable +="Radio Number";
		personHasCertificationTable +="</th>";
		personHasCertificationTable +="<th>";
		personHasCertificationTable +="Certification Name";
		personHasCertificationTable +="</th>";
		personHasCertificationTable +="<th>";
		personHasCertificationTable +="Expired?";
		personHasCertificationTable +="</th>";
		personHasCertificationTable +="<th>";
		personHasCertificationTable +="Date Earned";
		personHasCertificationTable +="</th>";
		personHasCertificationTable +="<th>";
		personHasCertificationTable +="Renewal Date";
		personHasCertificationTable +="</th>";
		personHasCertificationTable +="<th>";
		personHasCertificationTable +="Edit";
		personHasCertificationTable +="</th>";
		personHasCertificationTable +="</tr>";
		
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
		
		certificationTable +="<tr>";
		certificationTable +="<th>";
		certificationTable +="Certification Name";
		certificationTable +="</th>";
		certificationTable +="<th>";
		certificationTable +="Expiration Period";
		certificationTable +="</th>";
		certificationTable +="<th>";
		certificationTable +="Certifying Agency";
		certificationTable +="</th>";
		certificationTable +="<th>";
		certificationTable +="Edit";
		certificationTable +="</th>";
		certificationTable +="</tr>";
		
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
	
	public String getMemberList(){

		String memberList ="";
		memberList += "<table border=1>";
		
		memberList +="<tr>";
		memberList +="<th>";
		memberList +="First Name";
		memberList +="</th>";
		memberList +="<th>";
		memberList +="Last Name";
		memberList +="</th>";
		memberList +="<th>";
		memberList +="Radio Number";
		memberList +="</th>";
		memberList +="<th>";
		memberList +="Station Number";
		memberList +="</th>";
		memberList +="<th>";
		memberList +="Email";
		memberList +="</th>";
		memberList +="</tr>";		
		
		try {
			while(this.personResults.next()){
				Person person = new Person();
				person.setFirstName(this.personResults.getString("firstName"));
				person.setLastName(this.personResults.getString("lastName"));
				person.setRadioNumber(this.personResults.getInt("radioNumber"));
				person.setStationNumber(this.personResults.getInt("stationNumber"));
				person.setEmail(this.personResults.getString("email"));
				
				
				memberList +="<tr>";
				memberList +="<td>";
				memberList += person.getFirstName();
				memberList +="</td>";
				memberList +="<td>";
				memberList += person.getLastName();
				memberList +="</td>";
				memberList +="<td>";
				memberList += person.getRadioNumber();
				memberList +="</td>";
				memberList +="<td>";
				memberList += person.getStationNumber();
				memberList +="</td>";
				memberList +="<td>";
				memberList += person.getEmail();
				memberList +="</td>";
				memberList +="</tr>";		
	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		memberList += "</table>";
		return memberList;
//		return test;
	}
	
	public String getExpiredCerts(){

		String expiredCerts ="";
		expiredCerts += "<table border=1>";
		
		expiredCerts +="<tr>";
		expiredCerts +="<th>";
		expiredCerts +="First Name";
		expiredCerts +="</th>";
		expiredCerts +="<th>";
		expiredCerts +="Last Name";
		expiredCerts +="</th>";
		expiredCerts +="<th>";
		expiredCerts +="Certification Name";
		expiredCerts +="</th>";
		expiredCerts +="<th>";
		expiredCerts +="Expired?";
		expiredCerts +="</th>";
		expiredCerts +="</tr>";		
		
		try {
			while(this.expiredCertsResults.next()){
				Person person = new Person();
				PersonCertifications personCertification = new PersonCertifications();
				person.setFirstName(this.expiredCertsResults.getString("firstName"));
				person.setLastName(this.expiredCertsResults.getString("lastName"));
				personCertification.setCertificationName(this.expiredCertsResults.getString("certificationName"));
				personCertification.setIsExpired(this.expiredCertsResults.getString("IsExpired"));
				
				
				
				
				expiredCerts +="<tr>";
				expiredCerts +="<td>";
				expiredCerts += person.getFirstName();
				expiredCerts +="</td>";
				expiredCerts +="<td>";
				expiredCerts += person.getLastName();
				expiredCerts +="</td>";
				expiredCerts +="<td>";
				expiredCerts += personCertification.getCertificationName();
				expiredCerts +="</td>";
				expiredCerts +="<td>";
				expiredCerts += personCertification.getIsExpired();
				expiredCerts +="</td>";
				expiredCerts +="</tr>";		
	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		expiredCerts += "</table>";
		return expiredCerts;
//		return test;
	}
	
	public String getExpiredCertsFilter(){

		String expiredCertsFilter ="";
		expiredCertsFilter += "<table border=1>";
		
		expiredCertsFilter +="<tr>";
		expiredCertsFilter +="<th>";
		expiredCertsFilter +="First Name";
		expiredCertsFilter +="</th>";
		expiredCertsFilter +="<th>";
		expiredCertsFilter +="Last Name";
		expiredCertsFilter +="</th>";
		expiredCertsFilter +="<th>";
		expiredCertsFilter +="Certification Name";
		expiredCertsFilter +="</th>";
		expiredCertsFilter +="<th>";
		expiredCertsFilter +="Expired?";
		expiredCertsFilter +="</th>";
		expiredCertsFilter +="</tr>";		
		
		try {
			while(this.expiredCertsResults.next()){
				Person person = new Person();
				PersonCertifications personCertification = new PersonCertifications();
				person.setFirstName(this.expiredCertsResults.getString("firstName"));
				person.setLastName(this.expiredCertsResults.getString("lastName"));
				personCertification.setCertificationName(this.expiredCertsResults.getString("certificationName"));
				personCertification.setIsExpired(this.expiredCertsResults.getString("IsExpired"));
				
				
				
				
				expiredCertsFilter +="<tr>";
				expiredCertsFilter +="<td>";
				expiredCertsFilter += person.getFirstName();
				expiredCertsFilter +="</td>";
				expiredCertsFilter +="<td>";
				expiredCertsFilter += person.getLastName();
				expiredCertsFilter +="</td>";
				expiredCertsFilter +="<td>";
				expiredCertsFilter += personCertification.getCertificationName();
				expiredCertsFilter +="</td>";
				expiredCertsFilter +="<td>";
				expiredCertsFilter += personCertification.getIsExpired();
				expiredCertsFilter +="</td>";
				expiredCertsFilter +="</tr>";		
	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		expiredCertsFilter += "</table>";
		return expiredCertsFilter;
//		return test;
	}


	
	

}
