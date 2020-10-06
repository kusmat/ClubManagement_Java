import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;


public class Run {
	
	private static String[] PlayerCounter = new String[8];
	
	public static void main(String[] args) {

	// Connecting to the Database
		ConnectionToDB connection = new ConnectionToDB();
        connection.connect();

    //Welcome to the team and team creation + Player counter initialization
		System.out.println("Hello, welcome to the team 'Blasters' my fiends!");
		
		Team team = new Team();
		PlayerCounter counter = new PlayerCounter();
		
	// Player 0	
		Players player = new Players(10,20);
		counter.increasePlayerNumber();
		counter.toString();
		player.newPlayer("MK");
		System.out.println(player.getName());
		System.out.println(player.getHeight());
		//Inserting data into array
		PlayerCounter[counter.getArrayIndex()] = player.getName();
		//Inserting data into the database
		//connection.insertIntoDB(player.getName());
		
	// Player 1
		Players player1 = new Players();
		counter.increasePlayerNumber();
		counter.toString();
		player1.setName("Matek");
		System.out.println(player1.getName());
		player1.setWeight(100);
		
		
		System.out.println(player1.calculateAge(1,1,2013));

		//Inserting data into array
		PlayerCounter[counter.getArrayIndex()] = player1.getName();
		//Inserting data into the database
		//connection.insertIntoDB(player1.getName());
		
	// Player 2
		Players player2 = new Players("Oli", 8);
		counter.increasePlayerNumber();
		counter.toString();
		player2.setStartDate(31,12,2013);
		System.out.println("Player '" + player2.getName() + "' has a Club seniority of " + player2.getSeniority() + " years.");

		//Inserting data into array
		PlayerCounter[counter.getArrayIndex()] = player2.getName();
		//Inserting data into the database
		//connection.insertIntoDB(player2.getName());
	
		//team COLOR CHECK FOR A PLAYER
		team.setTeamColor(player2);
		System.out.println("The team color for player: " + player2.getName() + " is : " + team.getTeamColor() + " and the team code is: " + team.getTeamCode());
	
	// Player 3
		Players player3 = new Players("Natki", 6);
		counter.increasePlayerNumber();
		counter.toString();
		player3.setStartDate(1,1,2018);
		System.out.println("Player '" + player3.getName() + "' has a Club seniority of " + player3.getSeniority() + " years.");
	
		//team COLOR CHECK FOR A PLAYER
		team.setTeamColor(player3);
		System.out.println("The team color for player " + player3.getName() + " is " + team.getTeamColor() + ", and the team code is: " + team.getTeamCode());
	
		//Inserting data into array
		PlayerCounter[counter.getArrayIndex()] = player3.getName();
		
		
		
		//Printing out all players (= records) from the team (=Player counter array) from ARRAY
		
		for (int i = 0; i < 8; i++) {
			int j = i + 1 ;
			System.out.println("\nWelcome Player no " + j + ": " + PlayerCounter[i] + "\n");
		}
		
		

//Printing out all players from Database
	/*	System.out.println("PRINTING: ");
	   
		connection.selectDataFromDB();
	    ResultSet rs = connection.getResultSet();
	    System.out.println("Printing from main class:\n");
	  */
	    
	    
	 /*   try {
			while (rs.next()) {
				
				System.out.println("Player: " + rs.getString("PlayerName") + "\t");
			            
 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   */ 
		
		//Running operation on the database from separate class OperationsOnDB.java

		// selecting data from database
		
	/*	System.out.println("\n*********************************************\n");
		System.out.println("This is a query result from a default query:\n");
		
		OperationsOnDB selection1 = new OperationsOnDB();
        selection1.selectDataFromDB();
        
        System.out.println("\n*********************************************\n");
        //selecting filtered data from DB as a function
        System.out.println("This is a query result from a function:\n");
        
        String filter = "Oli"; 
        
        selection1.selectFilteredDataFromDB(filter);
        
        System.out.println("\n*********************************************\n");
        
      //Inserting data into the database
        OperationsOnDB insertion1 = new OperationsOnDB();
/*        insertion1.insertIntoDB(player3.getName());
        insertion1.insertIntoDB(player2.getName());
        insertion1.insertIntoDB(player1.getName());
  */      
		
	  }

}


