/**
 * 
 */
package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Person;
import model.PersonCertifications;
import model.Certifications;

/**
 * @author craigpiercy and hannahwestbrook/kesslerbarlow/chriscarpentier
 *
 */
public class UpdateQuery {
	
	private Connection connection;
	
	
	public UpdateQuery(String dbName, String uname, String pwd){
		
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
	
	public void doUpdatePerson(Person person){
		String query = "update person set firstName=?, lastName=?, position=?, gender=?, dateOfBirth=?, address=?, workPhone=?, mobilePhone=?, stationNumber=?, isActive=?, email=? where radioNumber=?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, person.getFirstName());
			ps.setString(2, person.getLastName());
			ps.setString(3, person.getPosition());
			ps.setString(4, person.getGender());
			ps.setString(5, person.getDateOfBirth());
			ps.setString(6, person.getAddress());
			ps.setString(7, person.getWorkPhone());
			ps.setString(8, person.getMobilePhone());
			ps.setInt(9, person.getStationNumber());
			ps.setString(10, person.getActive());
			ps.setString(11, person.getEmail());
			ps.setInt(12, person.getRadioNumber());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void doUpdatePersonHasCert(PersonCertifications personCertification){
		String query = "update person_has_certifications set radioNumber=?, certificationName=?, isExpired=?, earnedDate=?, renewalDate=? where id=?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			
			ps.setInt(1, personCertification.getRadioNumber());
			ps.setString(2, personCertification.getCertificationName());
			ps.setString(3, personCertification.getIsExpired());
			ps.setString(4, personCertification.getEarnedDate());
			ps.setString(5, personCertification.getRenewalDate());
			ps.setInt(6, personCertification.getid());
			
			
			
			
			
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void doUpdateCertification(Certifications certification){
		String query = "update certifications set expirationPeriod=?, certifyingAgency=? where certificationName=?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, certification.getExpirationPeriod());
			ps.setString(2, certification.getCertifyingAgency());
			ps.setString(3, certification.getCertificationName());
		
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}