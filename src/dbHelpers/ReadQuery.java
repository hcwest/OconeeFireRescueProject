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
	private ResultSet results;
	
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
			this.results= ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doReadPersonHasCert(){
		String query = "select * from person_has_certifications"; //**********************************************************
		
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			this.results= ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doReadCertification(){
		String query = "select * from certifications"; //**********************************************************
		
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			this.results= ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getPersonTable(){
		String personTable ="";
		personTable += "<table border=1>";
		
		try {
			while(this.results.next()){
				Person person = new Person();
				person.setRadioNumber(this.results.getInt("radioNumber"));
				person.setFirstName(this.results.getString("firstName"));
				person.setLastName(this.results.getString("lastName"));
				person.setPosition(this.results.getString("position"));
				person.setGender(this.results.getString("gender"));
				person.setDateOfBirth(this.results.getString("dateOfBirth"));
				person.setAddress(this.results.getString("address"));
				person.setWorkPhone(this.results.getString("workPhone"));
				person.setMobilePhone(this.results.getString("mobilePhone"));
				person.setStationNumber(this.results.getInt("stationNumber"));
				person.setActive(this.results.getString("isActive"));
				
				

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
				   personTable += "<a href=update?radioNumber=" + person.getRadioNumber() + " >update</a> <a href=delete?radioNumber=" + person.getRadioNumber() + " >delete</a>";
				personTable +="</td>";
				personTable +="</tr>";
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		personTable += "</table>";
		return personTable;
	}
	
	public String getPersonHasCertTable(){
		String table ="";
		table += "<table border=1>";
		
		try {
			while(this.results.next()){
				PersonCertifications personCertification = new PersonCertifications();
				personCertification.setRadioNumber(this.results.getInt("radioNumber"));
				personCertification.setCertificationName(this.results.getString("certificationName"));
				personCertification.setIsExpired(this.results.getString("isExpired"));
				personCertification.setEarnedDate(this.results.getString("earnedDate"));
				personCertification.setRenewalDate(this.results.getString("renewalDate"));
				
				
				

				table +="<tr>";
				table +="<td>";
				table += personCertification.getRadioNumber();
				table +="</td>";
				table +="<td>";
				table += personCertification.getCertificationName();
				table +="</td>";
				table +="<td>";
				table += personCertification.getIsExpired();
				table +="</td>";
				table +="<td>";
				table += personCertification.getEarnedDate();
				table +="</td>";
				table +="<td>";
				table += personCertification.getRenewalDate();
				table +="</td>";
				table +="<td>";
				   table += "<a href=update?radioNumber=" + personCertification.getRadioNumber() + " , certificationName=" + personCertification.getCertificationName() + " >update</a> <a href=delete?radioNumber=" + personCertification.getRadioNumber() + " , certificationName=" + personCertification.getCertificationName() + " >delete</a>";
				table +="</td>";
				table +="</tr>";
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		table += "</table>";
		return table;
	}
	
	public String getCertificationTable(){
		String table ="";
		table += "<table border=1>";
		
		try {
			while(this.results.next()){
				Certifications certification = new Certifications();
				certification.setCertificationName(this.results.getString("certificationName"));
				certification.setExpirationPeriod(this.results.getInt("expirationPeriod"));
				certification.setCertifyingAgency(this.results.getString("certifyingAgency"));
				
				

				table +="<tr>";
				table +="<td>";
				table += certification.getCertificationName();
				table +="</td>";
				table +="<td>";
				table += certification.getExpirationPeriod();
				table +="</td>";
				table +="<td>";
				table += certification.getCertifyingAgency();
				table +="</td>";
				table +="<td>";
				   table += "<a href=update?radioNumber=" + certification.getCertificationName() + " >update</a> <a href=delete?radioNumber=" + certification.getCertificationName() + " >delete</a>";
				table +="</td>";
				table +="</tr>";
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		table += "</table>";
		return table;
	}
	
	
	

}
