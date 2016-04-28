/**
 * 
 */
package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.PersonCertifications;


public class ReadRecordPersonHasCertifications {
	
	private Connection connection;
	private ResultSet results;
	
	private PersonCertifications personCertification = new PersonCertifications();
	private int radioNumber;
	private String certificationName;
	
	public ReadRecordPersonHasCertifications(String dbName, String uname, String pwd, int radioNumber, String certificationName){
		
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		this.radioNumber = radioNumber;
		this.certificationName = certificationName;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void doReadPersonHasCertification(){
		String query = "select * from person_has_certifications where radioNumber = ?, certificationName = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, this.radioNumber);
			ps.setString(2, this.certificationName);
			
			this.results = ps.executeQuery();
			
			this.results.next();
			
			personCertification.setRadioNumber(this.radioNumber);
			personCertification.setCertificationName(this.results.getString("certificationName"));
			personCertification.setIsExpired(this.results.getString("isExpired"));
			personCertification.setEarnedDate(this.results.getString("earnedDate"));
			personCertification.setRenewalDate(this.results.getString("renewalDate"));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public PersonCertifications getPersonCertifications(){
		return this.personCertification;
	}
	
	

}
