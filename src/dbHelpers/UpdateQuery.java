/**
 * 
 */
package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Person;
import model.PersonCertifications;

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
		String query = "update person set firstName=?, lastName=?, position=?, gender=?, dateOfBirth=?, address=?, workPhone=?,mobilePhone?, stationNumber=? isActive=?, email=?, where radioNumber=?";
		
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
			ps.setBoolean(10, person.isActive());
			ps.setString(11, person.getEmail());
			ps.setString(12, person.getRadioNumber());
			
			
			
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void doUpdatePersonHasCert(PersonCertifications personCertification){
		String query = "update person_has_certification set certificationName=?, isExpired=?, earnedDate=?, renewalDate=?, where radioNumber=?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			
			//ps.setString(1, person.getFirstName());
			//ps.setString(2, person.getLastName());
			//ps.setString(3, person.getPosition());
			//ps.setString(4, person.getGender());
			//ps.setString(5, person.getDateOfBirth());
			//ps.setString(6, person.getAddress());
			//ps.setString(7, person.getWorkPhone());
			//ps.setString(8, person.getMobilePhone());
			//ps.setInt(9, person.getStationNumber());
			//ps.setBoolean(10, person.isActive());
			//ps.setString(11, person.getEmail());
			//ps.setString(12, person.getRadioNumber());
			ps.setString(1, personCertification.getCertificationName());
			ps.setBoolean(2, personCertification.getIsExpired());
			ps.setString(3, personCertification.getEarnedDate());
			ps.setString(4, personCertification.getRenewalDate());
			ps.setString(5, personCertification.getRadioNumber());
			
			
			
			
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
