/**
 * 
 */
package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Person;
import model.Certifications;
import model.PersonCertifications;
import model.User;

public class AddQuery {
	
	public Connection connection;
	
	public AddQuery(String dbName, String uname, String pwd){
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd); 
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//*****************************************************************************************************************
	public void doAddPerson(Person person){
		String query = "insert into person (radioNumber, firstName, lastName, position, gender, dateOfBirth, address, workPhone, mobilePhone, stationNumber, isActive, email) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
				
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, person.getRadioNumber());
			ps.setString(2, person.getFirstName());
			ps.setString(3, person.getLastName());
			ps.setString(4, person.getPosition());
			ps.setString(5, person.getGender());
			ps.setString(6, person.getDateOfBirth());
			ps.setString(7, person.getAddress());
			ps.setString(8, person.getWorkPhone());
			ps.setString(9, person.getMobilePhone());
			ps.setInt(10, person.getStationNumber());
			ps.setString(11, person.getActive());
			ps.setString(12, person.getEmail());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void doAddCertification(Certifications certification){
		String query = "insert into certifications (certificationName, expirationPeriod, certifyingAgency) values (?, ?, ?)";
				
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, certification.getCertificationName());
			ps.setInt(2, certification.getExpirationPeriod());
			ps.setString(3, certification.getCertifyingAgency());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doAddPersonCertifications(PersonCertifications personCertifications){
		String query = "insert into person_has_certifications (id, radioNumber, certificationName, isExpired, earnedDate, renewalDate) values (?, ?, ?, ?, ?, ?)";
				
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1,personCertifications.getid());
			ps.setInt(2, personCertifications.getRadioNumber());
			ps.setString(3, personCertifications.getCertificationName());
			ps.setString(4, personCertifications.getIsExpired());
			ps.setString(5, personCertifications.getEarnedDate());
			ps.setString(6, personCertifications.getRenewalDate());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void doAddUser(User user) {
		// TODO Auto-generated method stub
		
	}

	
}
