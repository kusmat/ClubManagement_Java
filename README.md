# ClubManagement_Java (v. 2020-20-09)

This is the Java program to manage a list of players in the sport's club or hobbyist club.

1. Purpose: 
This program is made to demonstrate some abilities of the programmer and is to be used to qualify the candidate for a job position. 

Specifically, the aim of the program is to demonstrate the following competencies:
	
	- Basic Java knowledge and use of classes.
	- Use of database to manage project (searching / editing).
	- Use of SQL to manage database queries.
	- Use of Graphical User interface to manage operations and to display results, with properly programmed buttons for ease of use.
	- Use of tables, to display data queried from the database(used row set).

2. Basic information
When user starts the program, the database is automatically populated with 10 players' data. Program then allows to display the list of players, edit details, add new players or delete existing players. Database is created in PostgreSQL on the hosting server (Elephantsql.com), so it does not have downtime and is ready to use anytime by anyone. Password and user name are entered into the code to allow for easy login. 

Once selection criteria is entered on the main page (Player's list tab), the Search button is to be pushed to. If mistakes is made, the Reset form will reset all data from cells.

3. Options:
- Add new players/members
- Edit players/members data
- Delete players/members
- Select players/members from the database (selection criteria are: First name, Last name, Country, Age, Date of Birth.

Follow download instructions, here:  - [Club Management - Download instructions.pdf]("https://github.com/mail4rayo/ClubManagement_Java/blob/main/Club Management - Download instructions.pdf")

USER GUIDE is located in the repository: [Club Management - User guide.pdf ("https://github.com/mail4rayo/ClubManagement_Java/blob/main/Club Management - User guide.pdf")

4. Files ( Classes) Used:
- [TeamApp.java]("https://github.com/mail4rayo/ClubManagement_Java/blob/main/ClubManagement/src/TeamApp.java") - main file used as the GUI and to initialize the program.
- [ConnectionToDB.java]("https://github.com/mail4rayo/ClubManagement_Java/blob/main/ClubManagement/src/ConnectionToDB.java") - used to manage only the connection the database.
- [OperationsOnDB.java]("https://github.com/mail4rayo/ClubManagement_Java/blob/main/ClubManagement/src/OperationsOnDB.java") - used to manage all operations in the database

5. Files ( Classes) not currently used:
- [Run.java]("https://github.com/mail4rayo/ClubManagement_Java/blob/main/ClubManagement/src/Run.java") - Test file used to add players and check data consistency. Used during development.
- [PlayerCounter.java]("https://github.com/mail4rayo/ClubManagement_Java/blob/main/ClubManagement/src/PlayerCounter.java") -  Test file used to add players and check data consistency. Used during development.
- [Team.java]("https://github.com/mail4rayo/ClubManagement_Java/blob/main/ClubManagement/src/Team.java") -  Test file used to add players and check data consistency. Used during development.
- [Players.java]("https://github.com/mail4rayo/ClubManagement_Java/blob/main/ClubManagement/src/Players.java") -  Test file used to add players and check data consistency. Used during development.
- [EditPlayer.java]("https://github.com/mail4rayo/ClubManagement_Java/blob/main/ClubManagement/src/EditPlayer.java") - not used currently ( will be used to have separate editing window for player's data.
- [Person.java]("https://github.com/mail4rayo/ClubManagement_Java/blob/main/ClubManagement/src/Person.java")) - not used currently (will be used to generalize data, and separate Personal and Player's data)

6. Challenges / Interesting solutions:
	- Created DB user as the  table owner, for proper testing of the model's functionality.
	-  When new user opens the program, data is always refreshed to original state. If table already exists,  on startup, the program will delete the table and then add all columns and original data into it. New user will always receive new (fresh) table with data. If table does not exist, it will be created.
	- Each player/member is represented by the "number", to be able to identify each record unanimously.
	- When record is updated, the data will always be sorted by the user "number", so new records will be displayed at the end and edited records in their proper order.


Know bugs to be fixed in future releases:

	1. Not possible to search by Country or the Date of Birth: Not programmed yet as initial release focused on filtering by first name, last name and age.

7. Improvements considered in the future releases:
- Automatic refresh of the table after updating the record or entering new record: Currently, user need to go to Player's list tab and push Search to refresh data in the table.
- Some of the .java files are not used at the moment due to their role in future release of the program to make it more general (i.e. Add persons with more personal information than what is needed in the club, and to be able to better manage player's list).

8. Versions:
	1. 2020-10-06 Initial release
	2. 2020-10-09 Fixed the following issues: 
	- Fixed edit function which was not working for new entries. This was due to the fact that when entering the record, the "start date" was not being saved in the database. When editing record, this data is required to be used, so program would have crashed. The check was added if this data is entered or not and editing records entered by user is now possible.
	-  Removed all unnecessary comments from classes to make them more clear and easy to understand.


9. Technologies used:
	- IDE: Eclipse
	- GUI: Java AWT 
	- DB: PostgreSQL (Elephantsql.com hosting)
	- DB API: Java JDBC

10. Glossary:
	- IDE - Integrated Development Environment
	- GUI - Graphical User Interface
	- AWT - Abstract Window Toolkit
	- DB - Database
	- API - Application Programming Interface 
	- JDBC - Java Database Connectivity