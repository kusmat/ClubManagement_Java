import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionToDB {

	//Connection variables

	private final String url = "jdbc:postgresql://isilo.db.elephantsql.com:5432/";
	private final String user = "mahzcfsd";
	private final String password = "HtvYrzp7cPq7q5DKOeLXoLeLZ6M6X7lq";

	//variable to store query output 
	
	private ResultSet rs;
	
	 static {
		    try {
		      Class.forName("org.postgresql.Driver");
		    } catch (ClassNotFoundException e) {
		      throw new IllegalStateException("BaseDataSource is unable to load org.postgresql.Driver. Please check if you have proper PostgreSQL JDBC Driver jar on the classpath", e);
		    }
		  }
	/**
	 * Connect to the PostgreSQL database
	 *
	 * @return a Connection object
	 */

	public Connection connect() {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url, user, password);
			//System.out.println("Connected to the PostgreSQL server successfully.");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return conn;
	}

	//function to return result set

	public ResultSet getResultSet() {
		return rs;

	}

}
