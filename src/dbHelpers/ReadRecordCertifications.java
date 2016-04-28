/**
 * 
 */
package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Certifications	;


public class ReadRecordCertifications {
	
	private Connection connection;
	private ResultSet results;
	
	private Certifications certification = new Certifications();
	private String certificationName; 
	
	public ReadRecordCertifications(String dbName, String uname, String pwd, String certificationName){
		
		String url = "jdbc:mysql://localhost:3306/" + dbName;
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
	
	public void doReadCertification(){
		String query = "select * from certifications where certificationName = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, this.certificationName);
			
			this.results = ps.executeQuery();
			
			this.results.next();
			
			certification.setCertificationName(this.results.getString("certificationName"));
			certification.setExpirationPeriod(this.results.getInt("expirationPeriod"));
			certification.setCertifyingAgency(this.results.getString("certifyingAgency"));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Certifications getCertification(){
		return this.certification;
	}
	
	

}
