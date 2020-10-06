import java.util.Calendar;
import java.time.*;

public class Players extends Person{

//********** variables needed to execute the program **************//
	private LocalDate birthdate;
	private int startDay;
	private int startMonth;
	private int startYear;
	private double seniority;	
	
		
//*******************constructor of the class Players************************//
	
	//no parameters constructor
	
	public Players() {
		
		System.out.println("\nWelcome Stranger!");
		System.out.println("Please set your name so we can recognize you!");
		
	}
	public Players(String name, int age) {
		
		System.out.println("\nWelcome " + name + "(your age is set to:" + age + ")");
		this.setName(name);
		this.setAge(age);
		
	}
	public Players(int weight, int height) {
		
		super(weight, height);
		System.out.println("\nWelcome Stranger!");
		System.out.println("Please set your name so we can recognize you!");
		
	}
	//one parameter constructor - setting the name of the player	
	
	public Players(String text) {
		
		System.out.println("\nYou will be called as you wish " + text);
		
		this.setName(text);
		
		System.out.println(this.getName() + ", you will have a lot of fun here!");		
	}
	
//************** Creating new Player manually *************//
	
	//New player with name as the parameter
	public void newPlayer(String name) {
		
		System.out.println("\nNew player created!");
		GreetPlayer(name);
		this.setName(name);
	}
	//New player with name as the manual entry from the user input
	public void newPlayer() {
		
		System.out.println("\nNew player created!");
		System.out.println("Please enter name for the new player:");
		
	}
	
	//This is the greeting of the player by name, with entering actual name, but soon this will be replaced by function, getName.
	public void GreetPlayer(String name) {
		System.out.println("Hello " + name);
	}
//*************** other methods ************************//
	//seniority calculation
	protected void setStartDate(int startDay, int startMonth, int startYear) {
		this.startDay = startDay;
		this.startMonth = startMonth;
		this.startYear = startYear;
		birthdate = LocalDate.of(startYear, startMonth, startDay);
		System.out.println("Birthdate is: " + birthdate);
		}
	
	
	//calculating seniority using Calendar instance and Year, MOnth, Day values as integers
	private void calculateSeniority() {
		Calendar now = Calendar.getInstance();
		 int currentYear = now.get(Calendar.YEAR);
		 int currentMonth = now.get(Calendar.MONTH) + 1;
		 int currentDay = now.get(Calendar.DATE);
		    // month start from 0 to 11
		 this.seniority = (currentYear-startYear)+((double)currentMonth-(double)startMonth)/12;
	}
	
	//returning player's seniority if less than 50 years, otherwise return default value to indicate error.
	public double getSeniority() {
		calculateSeniority();
		if (seniority > 50){
			return 9999;}
		else {
			return seniority;
		}		
	}

}

