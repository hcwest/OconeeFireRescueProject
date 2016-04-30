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
	
	public ResultSet doListMembers(){
		String query = "select firstName, lastName, radioNumber, stationNumber, email FROM person"; //**********************************************************
		
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			this.personResults = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return personResults;
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
		personTable +="<td>";
		personTable +="Radio Number";
		personTable +="</td>";
		personTable +="<td>";
		personTable +="First Name";
		personTable +="</td>";
		personTable +="<td>";
		personTable +="Last Name";
		personTable +="</td>";
		personTable +="<td>";
		personTable +="Position";
		personTable +="</td>";
		personTable +="<td>";
		personTable +="Gender";
		personTable +="</td>";
		personTable +="<td>";
		personTable +="Date Of Birth";
		personTable +="</td>";
		personTable +="<td>";
		personTable +="Address";
		personTable +="</td>";
		personTable +="<td>";
		personTable +="Work Phone";
		personTable +="</td>";
		personTable +="<td>";
		personTable +="Mobile Phone";
		personTable +="</td>";
		personTable +="<td>";
		personTable +="Station Number";
		personTable +="</td>";
		personTable +="<td>";
		personTable +="Email";
		personTable +="</td>";
		personTable +="<td>";
		personTable +="Edit";
		personTable +="</td>";
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
		personHasCertificationTable +="<td>";
		personHasCertificationTable +="Radio Number";
		personHasCertificationTable +="</td>";
		personHasCertificationTable +="<td>";
		personHasCertificationTable +="Certification Name";
		personHasCertificationTable +="</td>";
		personHasCertificationTable +="<td>";
		personHasCertificationTable +="Expired?";
		personHasCertificationTable +="</td>";
		personHasCertificationTable +="<td>";
		personHasCertificationTable +="Date Earned";
		personHasCertificationTable +="</td>";
		personHasCertificationTable +="<td>";
		personHasCertificationTable +="Renewal Date";
		personHasCertificationTable +="</td>";
		personHasCertificationTable +="<td>";
		personHasCertificationTable +="Edit";
		personHasCertificationTable +="</td>";
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
		certificationTable +="<td>";
		certificationTable +="Certification Name";
		certificationTable +="</td>";
		certificationTable +="<td>";
		certificationTable +="Expiration Period";
		certificationTable +="</td>";
		certificationTable +="<td>";
		certificationTable +="Certifying Agency";
		certificationTable +="</td>";
		certificationTable +="<td>";
		certificationTable +="Edit";
		certificationTable +="</td>";
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
		memberList +="<td>";
		memberList +="First Name";
		memberList +="</td>";
		memberList +="<td>";
		memberList +="Last Name";
		memberList +="</td>";
		memberList +="<td>";
		memberList +="Radio Number";
		memberList +="</td>";
		memberList +="<td>";
		memberList +="Station Number";
		memberList +="</td>";
		memberList +="<td>";
		memberList +="Email";
		memberList +="</td>";
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
		expiredCerts +="<td>";
		expiredCerts +="First Name";
		expiredCerts +="</td>";
		expiredCerts +="<td>";
		expiredCerts +="Last Name";
		expiredCerts +="</td>";
		expiredCerts +="<td>";
		expiredCerts +="Certification Name";
		expiredCerts +="</td>";
		expiredCerts +="<td>";
		expiredCerts +="Expired?";
		expiredCerts +="</td>";
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
		expiredCertsFilter +="<td>";
		expiredCertsFilter +="First Name";
		expiredCertsFilter +="</td>";
		expiredCertsFilter +="<td>";
		expiredCertsFilter +="Last Name";
		expiredCertsFilter +="</td>";
		expiredCertsFilter +="<td>";
		expiredCertsFilter +="Certification Name";
		expiredCertsFilter +="</td>";
		expiredCertsFilter +="<td>";
		expiredCertsFilter +="Expired?";
		expiredCertsFilter +="</td>";
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
	
	public String getCSVTable(ResultSet personResults){
		String memberList ="";
		
		try {
			while(personResults.next()) {

				Person person = new Person(
						personResults.getInt("radioNumber"),
						personResults.getString("firstName"),
						personResults.getString("lastName"),
						personResults.getInt("stationNumber"),
						personResults.getString("email")
						);
				
				// Because we can't put the " character easily inside a 
				// String, we "escape" it by using a backslash sequence.
				// The \" sequence is resolved by Java to mean the " character
				
				// The CSV format wraps strings in double quotes.
				// Any double quotes already part of the string need to be
				// doubled up according to the CSV specification.
				// Thus, " turns in to "" in CSV to indicate the field contains
				// a double quote character.

				memberList += "\"";
				memberList += person.getFirstName().replaceAll("\"", "\"\"");
				memberList +="\", \"";
				memberList += person.getLastName().replaceAll("\"", "\"\"");
				memberList +="\",";
				memberList += person.getRadioNumber();
				memberList +="\",";
				memberList += person.getStationNumber();
				memberList +="\", \"";
				memberList += person.getEmail().replaceAll("\"", "\"\"");
				memberList +="\",";
				memberList +="\n";  // Important!

				// Just as \" is resolved as a " character, \n resolves
				// as a new line. Each record in a CSV file is a new line.
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memberList;
	}


	
	

}
