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
	private ResultSet personHasCertificationResults;
	
	private PersonCertifications personCertification = new PersonCertifications();
	private int id;
	
	
	public ReadRecordPersonHasCertifications(String dbName, String uname, String pwd, int id){
		
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		this.id = id;
		
		
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
		String query = "select * from person_has_certifications where id=?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, this.id);
		
			
			this.personHasCertificationResults = ps.executeQuery();
			
			this.personHasCertificationResults.next();
			
			personCertification.setid(this.id);
			personCertification.setRadioNumber(this.personHasCertificationResults.getInt("radioNumber"));
			personCertification.setCertificationName(this.personHasCertificationResults.getString("certificationName"));
			personCertification.setIsExpired(this.personHasCertificationResults.getString("isExpired"));
			personCertification.setEarnedDate(this.personHasCertificationResults.getString("earnedDate"));
			personCertification.setRenewalDate(this.personHasCertificationResults.getString("renewalDate"));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public PersonCertifications getPersonCertifications(){
		return this.personCertification;
	}
	
	

}
