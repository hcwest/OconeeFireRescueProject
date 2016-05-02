/**
 * 
 */
package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author craigpiercy and hannahwestbrook/kesslerbarlow/chriscarpentier
 *
 */
public class DeleteQuery {
	
	private Connection connection;
	
	public DeleteQuery(String dbName, String uname, String pwd){
		
		String url = "jdbc:mysql://localhost:3306/"+dbName;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doDeletePerson(String radioNumber){
		// set up a String to hold our query
		String query = "delete from person where radioNumber = ?";
		
		// create a preparedstatement using our query string
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			// fill in the preparedstatement
			ps.setString(1, radioNumber);
			
			// execute the query
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void doDeletePersonHasCert(int id){
		// set up a String to hold our query
		String query = "delete from person_has_certifications where id = ?";
		
		// create a preparedstatement using our query string
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			// fill in the preparedstatement
			ps.setInt(1, id);
			
			
			// execute the query
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doDeleteCertification(String certificationName){
		// set up a String to hold our query
		String query = "delete from certifications where certificationName = ?";
		
		// create a preparedstatement using our query string
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			// fill in the preparedstatement
			ps.setString(1, certificationName);
			
			// execute the query
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

