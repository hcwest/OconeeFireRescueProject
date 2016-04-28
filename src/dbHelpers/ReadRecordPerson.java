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


public class ReadRecordPerson {
	
	private Connection connection;
	private ResultSet results;
	
	private Person person = new Person();
	private int radioNumber;
	
	public ReadRecordPerson(String dbName, String uname, String pwd, int radioNumber){
		
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		this.radioNumber = radioNumber;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void doReadPerson(){
		String query = "select * from person where radioNumber = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, this.radioNumber);
			
			this.results = ps.executeQuery();
			
			this.results.next();
			
			person.setRadioNumber(this.radioNumber);
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
			person.setEmail(this.results.getString("email"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Person getPerson(){
		return this.person;
	}
	
	

}
