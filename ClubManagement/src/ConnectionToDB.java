import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionToDB {

	private final String url = "jdbc:postgresql://localhost/postgres";
	private final String user = "tester";
	private final String password = "retset@123";

	private ResultSet rs;

	/**
	 * Connect to the PostgreSQL database
	 *
	 * @return a Connection object
	 */
	public Connection connect() {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to the PostgreSQL server successfully.");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return conn;
	}



	// public void selectDataFromDB(String filter){

	/*public void selectDataFromDB() {
		String SQL = "SELECT * "
				// + "FROM public.\"Players\"";
				+ "FROM public.\"Players\"" + "WHERE \"PlayerName\" IS NOT NULL ";

		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {

			// pstmt.setString(1, filter);
			rs = pstmt.executeQuery();
			displayQueryResults(rs);
			// finishing connection

			conn.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
*/
	
	/*public void displayQueryResults(ResultSet rs) throws SQLException {

		System.out.println("\nList of all players is as follows:\n");

		while (rs.next()) {

			System.out.println("Player: " + rs.getString("PlayerName") + "\t");

		}
	}
	*/

	public ResultSet getResultSet() {
		return rs;

	}

}
