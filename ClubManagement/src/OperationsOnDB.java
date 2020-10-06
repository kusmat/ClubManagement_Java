import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class OperationsOnDB {

	private ConnectionToDB conn;
	private ResultSet rs;
	private ResultSetMetaData rsmd;
	private Object data[];
	private DefaultTableModel dtm;
	StringBuilder SQL;
	private String dbName = "public.\"Players\"";

	public OperationsOnDB() {

		this.initialiseConnectiontoDB();

	}

	public Connection initialiseConnectiontoDB() {

		conn = new ConnectionToDB();
		Connection connection = conn.connect();
		return connection;
	}
	
	public void setupDefaultTable() {
		
	/*
		
		DROP TABLE public."Players";

		CREATE TABLE public."Players"
		(
		    "PlayerName" character varying COLLATE pg_catalog."default",
		    "DateOfBirth" date,
		    "PlayerLastName" character varying COLLATE pg_catalog."default",
		    "Country" character varying COLLATE pg_catalog."default",
		    "Sex" character varying COLLATE pg_catalog."default",
		    "StartDate" date,
		    "Age" integer,
		    "ClubSeniority" integer,
		    "No" SERIAL
		)
		WITH (
		    OIDS = FALSE
		)
		TABLESPACE pg_default;

		ALTER TABLE public."Players"
		    OWNER to postgres;

		COMMENT ON COLUMN public."Players"."No"
		    IS 'Auto generated number';
			
		INSERT INTO public."Players"(
			"PlayerName", "PlayerLastName", "Country", "DateOfBirth", "Sex", "StartDate", "Age", "ClubSeniority")
			VALUES 
		('Chris','Bowman','Canada','1990-01-01','Male','2019-01-01','20','4'),
		('Michael','Jordan','USA','1975-01-01','Male','1980-01-01','20','4'),
		('Farrel','William','France','1984-01-01','Male','1990-01-01','20','4'),
		('Jane','Fonda','USA','1998-01-01','Male','2000-01-01','20','4'),
		('Joan','Franck','Germany','2000-01-01','Male','2015-01-01','20','4'),
		('Neil','Johnson','Japan','1991-01-01','Male','2002-01-01','20','4'),
		('Brock','Black','Spain','1993-01-01','Male','2004-01-01','20','4'),
		('Bryan','Farrat','USA','1999-01-01','Male','2015-01-01','20','4'),
		('Karen','King','Canada','1997-01-01','Male','2007-01-01','20','4'),
		('Louise','Perch','Belgium','1985-01-01','Male','2020-01-01','20','4');
		*/
	
		SQL = new StringBuilder()
				//dropping table
				///*
				.append("DROP TABLE IF EXISTS public.\"Players\";\r\n")
				//*/
				//creating new table
				///*
				.append("CREATE TABLE public.\"Players\"\r\n")
				.append("(\"PlayerName\" character varying COLLATE pg_catalog.\"default\",\r\n") 
				.append("\"PlayerLastName\" character varying COLLATE pg_catalog.\"default\",\r\n")
				.append("\"Country\" character varying COLLATE pg_catalog.\"default\",\r\n")
				.append("\"Sex\" character varying COLLATE pg_catalog.\"default\",\r\n")
				.append("\"DateOfBirth\" date,\r\n")
				.append("\"StartDate\" date,\r\n") 
				.append("\"Age\" integer,\r\n")
				.append("\"ClubSeniority\" integer,\r\n") 
				.append("\"No\" SERIAL)\r\n")
				.append("WITH (OIDS = FALSE)\r\n")
				.append("TABLESPACE pg_default;\r\n")				
				//setting access
				.append("ALTER TABLE public.\"Players\"\r\n") 
				.append("OWNER to tester;\r\n" )
				.append("COMMENT ON COLUMN public.\"Players\".\"No\"\r\n") 
				.append("IS \'Auto generated number\';\r\n" )
				//*/
				//Deleting all rows from database:
				//.append("DELETE FROM public.\"Players\";\r\n")

				
				//inserting initial values.
				
				///*
				.append("INSERT INTO public.\"Players\"\r\n") 
				.append("(\"PlayerName\", \"PlayerLastName\", \"Country\", \"DateOfBirth\", \"Sex\", \"StartDate\", \"Age\", \"ClubSeniority\")\r\n") 
				.append("VALUES \r\n" )
				.append("('Chris','Bowman','Canada','1990-01-01','Male','2019-01-01','20','4'),\r\n") 
				.append("('Michael','Jordan','USA','1975-01-01','Male','1980-01-01','20','4'),\r\n" ) 
				.append("('Farrel','William','France','1984-01-01','Male','1990-01-01','20','4'),\r\n") 
				.append("('Jane','Fonda','USA','1998-01-01','Male','2000-01-01','20','4'),\r\n")
				.append("('Joan','Franck','Germany','2000-01-01','Male','2015-01-01','20','4'),\r\n") 
				.append("('Neil','Johnson','Japan','1991-01-01','Male','2002-01-01','20','4'),\r\n") 
				.append("('Brock','Black','Spain','1993-01-01','Male','2004-01-01','20','4'),\r\n")
				.append("('Bryan','Farrat','USA','1999-01-01','Male','2015-01-01','20','4'),\r\n" ) 
				.append("('Karen','King','Canada','1997-01-01','Male','2007-01-01','20','4'),\r\n") 
				.append("('Louise','Perch','Belgium','1985-01-01','Male','2020-01-01','20','4');\r\n");
				//*/
				///reset the serial 
				//.append("ALTER SEQUENCE \"Players_No_seq\" RESTART;");
		
		System.out.println(SQL);
		
		try (Connection connection = this.initialiseConnectiontoDB();
				PreparedStatement pstmt = connection.prepareStatement(SQL.toString())) {
			pstmt.executeUpdate();
			
			// finishing connection
			connection.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

	}
	
			
	//Default function to get all data from database
	public ArrayList<Object> selectRowDataFromDBforEditing(int playerID) {

		//selecting all data for editing
		SQL = new StringBuilder()
		.append("SELECT ")
		//.append(" * ")
		.append("\"PlayerName\", \"PlayerLastName\",  \"DateOfBirth\", \"Country\", \"Sex\", \"StartDate\", CAST(EXTRACT(YEAR from(AGE(\"DateOfBirth\"))) as int), CAST(EXTRACT(YEAR from(AGE(\"StartDate\"))) as int),  \"No\"")
		.append(" FROM ")
		.append(dbName)
		.append(" WHERE ")
		.append("\"No\" = ?")
		.append("ORDER BY \"No\"");
				
		ArrayList<Object> recordData = new ArrayList<Object>();
		
		try (Connection connection = this.initialiseConnectiontoDB();

				//prepared statement and making the resultset scrollable. 
				PreparedStatement pstmt = connection.prepareStatement(SQL.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,
		                ResultSet.CONCUR_READ_ONLY)) {

			pstmt.setInt(1, playerID);

			//executing the query to get data.
			ResultSet resultSet = pstmt.executeQuery();

			//getting meta data from results set to get column names
			//rsmd = rs.getMetaData();
			
			//displaying query results in the editor using the result set
			//displayQueryResults(rs);
			
			//moving before first row to read result set again.
			//resultSet.beforeFirst();
			
			
			while (resultSet.next()) {

	            // System.out.println("adding row");
	           
	                
	        		//Table columns are as follows: 
				/* 1) \"PlayerName\", 
				 * 2) \"PlayerLastName\", 
				 * 3) \"Country\", 
				 * 4) \"DateOfBirth\", 
				 * 5) \"Sex\", 
				 * 6) \"StartDate\", 
				 * 7) \"Age\", 
				 * 8) \"ClubSeniority\"
				 * 9) \"No\"
				 */
				
				
				for (int i = 0; i<9;i++) {
				recordData.add(i, String.valueOf(resultSet.getObject(i+1)));
				}
				for (int i = 0; i<9;i++) {
					System.out.println(i + ": " + recordData.get(i));
					}				
				System.out.println(resultSet.getObject(1));
	            }
			
				

					
			//creating data model
			//createDataModel(rs);
			
			// finishing connection
			connection.close();
			
				
			
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		//returning object to be used by TeamApp.	
		return recordData;
	}
	
	

	//Default function to get all data from database
	public void selectDataFromDB() {

		// String SQL = "SELECT Players.PlayerName FROM Players WHERE Players.PlayerName
		// IS NOT NULL";

		
		// query to get all rows from DB.
		/*String SQL = "SELECT " + " \"PlayerName\", " + " \"PlayerLastName\", " + " \"DateOfBirth\", " + " \Country"\" "
				+ "FROM public.\"Players\"" + "WHERE " + "\"PlayerName\" IS NOT NULL and "
				+ "\"PlayerLastName\" IS NOT NULL";
		 */
		/*String SQL = "SELECT * "
				+ "FROM public.\"Players\"" + "WHERE " + "\"PlayerName\" IS NOT NULL and "
				+ "\"PlayerLastName\" IS NOT NULL";*/
		SQL = new StringBuilder()
		.append("SELECT ")
		//.append(" * ")
		.append("\"PlayerName\" \"First Name\", \"PlayerLastName\" \"Last Name\",\"Country\" \"Address\", CAST(EXTRACT(YEAR from(AGE(\"DateOfBirth\"))) as int)  \"Age\", \"No\" \"Id\"")
		.append(" FROM ")
		.append(dbName)
		.append(" WHERE ")
		.append("\"PlayerName\" is not null and \"PlayerLastName\" is not null")
		.append("ORDER BY \"No\"");
		
		//System.out.println(SQL.toString());

		try (Connection connection = this.initialiseConnectiontoDB();

				//prepared statement and making the resultset scrollable. 
				PreparedStatement pstmt = connection.prepareStatement(SQL.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,
		                ResultSet.CONCUR_READ_ONLY)) {

			;

			//executing the query to get data.
			ResultSet rs = pstmt.executeQuery();

			//getting meta data from results set to get column names
			rsmd = rs.getMetaData();
			
			//diplaying query results in the editor using the result set
			displayQueryResults(rs);
			
			//moving before first row to read result set again.
			rs.beforeFirst();
			
			//creating data model
			createDataModel(rs);
			
			// finishing connection
			connection.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	// function to get data from database based on selected filters
	public void selectFilteredDataFromDB(String first, String last, String country, int age_from, int age_to) {

		// setting up query string with parametrized data
		/*String SQL = "SELECT " + " \"PlayerName\", " + " \"PlayerLastName\", " + " \"DateOfBirth\", " + " \"Country\" "
				+ "FROM public.\"Players\"" + "WHERE lower(" + "\"PlayerName\") like ? and "
				+ "\"PlayerLastName\" IS NOT NULL" + " and lower(\"PlayerLastName\") like ?";
		 */
		//sql string using lower case values to search.
		/*String SQL = "SELECT * "
				+ "FROM public.\"Players\"" + "WHERE lower(" + "\"PlayerName\") like ? and "
				+ "\"PlayerLastName\" IS NOT NULL" + " and lower(\"PlayerLastName\") like ?";*/
		
		
		SQL = new StringBuilder()
		.append("SELECT ")
		//.append(" * ")
		.append("\"PlayerName\" \"First Name\", \"PlayerLastName\" \"Last Name\",\"Country\" \"Address\", CAST(EXTRACT(YEAR from(AGE(\"DateOfBirth\"))) as int) \"Age\", \"No\" \"Id\"")
		.append(" FROM ")
		.append(dbName)
		.append(" WHERE ")
		.append("lower(\"PlayerName\") like ? and \"PlayerLastName\" is not null and lower(\"PlayerLastName\") like ?")
		.append(" and \"Country\" like ?")
		.append(" and EXTRACT(YEAR from AGE(\"DateOfBirth\")) >= ? and EXTRACT(YEAR from AGE(\"DateOfBirth\")) <= ?")
		//.append(" and EXTRACT(YEAR from (\"DateOfBirth\")) = ").append(year)
		//.append(" and \"Age\" > ").append(age_from).append(" and \"Age\" < ").append(age_to)
		.append(" ORDER BY \"No\";");
		
		try (Connection connection = this.initialiseConnectiontoDB();

				//creating the prepared statements variable and making the resultset scrollable.
				PreparedStatement pstmt = connection.prepareStatement(SQL.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,
		                ResultSet.CONCUR_READ_ONLY)) {

			//Searching for First name that contains with what user entered. Can start and end with any other characters.
			first = "%" + first.toLowerCase() +"%";
			last = "%" + last.toLowerCase() +"%";
			country = "%" + country.toLowerCase() +"%";
			// assigning variable to the search, this is the filter entered by user.
			pstmt.setString(1, first);
			pstmt.setString(2, last);
			pstmt.setString(3, country);
			pstmt.setInt(4, age_from);
			pstmt.setInt(5, age_to);

			//executing query and assigning to variable of type resultSet
			rs = pstmt.executeQuery();
			//getting the metadata like column names 
			rsmd = rs.getMetaData();
			
			//text output of the query in the editor
			displayQueryResults(rs);
			
			//moving cursor of the resultset back to first element to use it again.
			rs.beforeFirst();
			
			//creating data model
			createDataModel(rs);
			

			// finishing connection
			connection.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}


	}
	
	public DefaultTableModel getTableModel() {
		
		return dtm;
	}
	
	/*public Object[] getDatabaseData() {
		
		return data;
	}*/
	
	//function to display query results in the editor for troubleshooting 
	private void displayQueryResults(ResultSet rs) throws SQLException {

		System.out.println("\nList of all players is as follows:\n");

		while (rs.next()) {

			/*System.out.println("Player: " + rs.getString("First Name") + " " + rs.getString("Last Name") + ", DOB:"
					+ rs.getString("Date of birth") + ", from " + rs.getString("Address") + "\t");*/

		}
	}
	
	//function for creating data model for further use.
	private void createDataModel(ResultSet rs) throws SQLException {

		System.out.println("creating data:");
		
		dtm = new DefaultTableModel();
		
        //------------------adding columns to the table
        int colNo = rsmd.getColumnCount();

        data = new Object[colNo];
        
        for (int columnNo = 1; columnNo < colNo + 1; columnNo++) {
            dtm.addColumn(rsmd.getColumnName(columnNo));
        }

        //------------------------adding rows to the table
      

        while (rs.next()) {

            // System.out.println("adding row");
            for (int i = 0; i < colNo; i++) {
                data[i] = rs.getObject(i + 1);

            }
                dtm.addRow(data);
            }
        }
		
	

	//function to insert data into database, to be used while adding new Player to the database.
	public void insertIntoDB(String firstName, String lastName, String country, LocalDate birthdate) {

		SQL = new StringBuilder()
				.append("INSERT INTO ")
				.append(dbName)
				.append(" (\"PlayerName\", \"PlayerLastName\", \"Country\", \"DateOfBirth\")")
				.append(" VALUES (?, ?, ?, ?)");

		try (Connection connection = this.initialiseConnectiontoDB();
				PreparedStatement pstmt = connection.prepareStatement(SQL.toString())) {

			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			pstmt.setString(3, country);
			pstmt.setObject(4, birthdate);
			pstmt.executeUpdate();
			
			// finishing connection
			connection.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

	}
	
	//function to update data into database.
	public void updateEntryFromDB(String firstName, String lastName, String country, LocalDate birthdate, int id) {

		/*String SQL = "UPDATE public.\"Players\" " + 
					 "SET \"PlayerName\" = \'" + firstName +
					 "\', \"PlayerLastName\" = \'" + lastName +
					 "\', \"Country\" = \'" + country +
					 "\', \"DateOfBirth\" = \'" + birthdate +
					 "\' WHERE \"No\" = " + id +";";	*/
		SQL = new StringBuilder()
				.append("UPDATE ")
				.append(dbName)
				.append(" SET ")
				.append(" \"PlayerName\" = '").append(firstName) 
				.append("', \"PlayerLastName\" = '").append(lastName) 
				.append("', \"Country\" = '").append(country) 
				.append("', \"DateOfBirth\" = '").append(birthdate)
				.append("' WHERE ")
				.append("\"No\" = '").append(id)
				.append("';");

		System.out.println(SQL);

		try (Connection connection = this.initialiseConnectiontoDB();
				PreparedStatement pstmt = connection.prepareStatement(SQL.toString())) {

			/*pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			pstmt.setString(3, country);
			pstmt.setObject(4, birthdate);*/
			pstmt.executeUpdate();
			
			// finishing connection
			connection.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

	}
	
	//function to remove record from database.
	public void removeRecordFromDB(int id) {

			SQL = new StringBuilder()
					.append("DELETE FROM ")
					.append(dbName)
					.append(" WHERE ")
					.append("\"No\" = '").append(id)
					.append("';");	
			System.out.println(SQL);

			try (Connection connection = this.initialiseConnectiontoDB();
					PreparedStatement pstmt = connection.prepareStatement(SQL.toString())) {

				pstmt.executeUpdate();
				
				// finishing connection
				connection.close();

			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}

		}

}
