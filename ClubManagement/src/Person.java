import java.time.LocalDate;
import java.time.Period;

public class Person {

	private String firstName;
	private String lastName;
	private double age;
	private int birthMonth;
	private int birthDay;
	private int birthYear;
	private LocalDate dateOfBirth;
	private String sex;
	protected int height;
	protected int weight;
	private String hairColor;
	private String eyeColor;

//	*************** constructors for the Person class ************************//

	/* default */
	public Person() {
		System.out.println("This is a Person");
	}

	/* weight height constructor */
	public Person(int weight, int height) {

		// using setters
		this.setWeight(weight);
		this.setHeight(height);
	}

	public Person(String firstName, String lastName, LocalDate birthdate,  String address, String sex, LocalDate startDate, int age) {

		//empty
	}
	
	public Person(String firstName, String lastName, LocalDate birthdate,  String address) {
		
		OperationsOnDB addData = new OperationsOnDB();
		addData.insertIntoDB(firstName, lastName, address, birthdate);

		
	}



	// *************** setting basic information about the player
	// ************************//

	// setters for height and weight
	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	// setters for name and age
	public void setName(String name) {
		this.firstName = name;
	}

	public void setAge(double age) {
		this.age = age;
	}

	// *************** getting basic information about the player
	// ************************//

	// getting weight and height

	public int getWeight() {
		return weight;
	}

	public int getHeight() {
		return weight;
	}

	// getting name and age
	public String getName() {
		return firstName;
	}

	public double getAge() {
		return age;
	}

	// calculating proper birth date as the LocalDate type and then string
	protected String setBirthDate(int birthDay, int birthMonth, int birthYear) {
		this.birthDay = birthDay;
		this.birthMonth = birthMonth;
		this.birthYear = birthYear;
		dateOfBirth = LocalDate.of(birthYear, birthMonth, birthDay);
		
		return dateOfBirth.toString();
		// System.out.println("Birthdate is: " + dateOfBirth);
	}

	// Method to calculate age using the LocalDate date type.
	public double calculateAge(int birthDay, int birthMonth, int birthYear) {

		this.birthDay = birthDay;
		this.birthMonth = birthMonth;
		this.birthYear = birthYear;
		LocalDate todaysdate = LocalDate.now();
		LocalDate birthdate = LocalDate.of(birthYear, birthMonth, birthDay);

		Period agePeriod = Period.between(birthdate, todaysdate);

		// get age in years
		double ageCalc = agePeriod.getYears() + (agePeriod.getMonths() / 12.0);// Used 0.5 to correctly get value to the nearest int
		int age = (int) ageCalc; 
		
		System.out.println("Age is: " + ageCalc);
		
		return ageCalc;
		
		// System.out.println("Birthdate is: " + dateOfBirth);
	}
}
