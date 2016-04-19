/**
 * 
 */
package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Person;

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
	public void doAdd(Person person){
		String query = "insert into Person (radioNumber, firstName, lastName, position, gender, dateOfBirth, address, workPhone, mobilePhone, stationNumber, isActive) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
				
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, person.getRadioNumber());
			ps.setString(2, person.getFirstName());
			ps.setString(3, person.getLastName());
			ps.setString(4, person.getPosition());
			ps.setString(5, person.getGender());
			ps.setString(6, person.getDateOfBirth());
			ps.setString(7, person.getAddress());
			ps.setString(8, person.getWorkPhone());
			ps.setString(9, person.getMobilePhone());
			ps.setInt(10, person.getStationNumber());
			//ps.setBoolean(11, person.isActive());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}