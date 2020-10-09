# ClubManagement_Java (v. 2020-10-09)

### This is the Java program to manage a list of players in the sport's club or hobbyist club.
---
## Purpose: 
This program is made to demonstrate some abilities of the programmer and is to be used to qualify the candidate for a job position. 

Specifically, the aim of the program is to demonstrate the following competencies:
	
	- Basic Java knowledge and use of classes.
	- Use of database to manage project (searching / editing).
	- Use of SQL to manage database queries.
	- Use of Graphical User interface to manage operations and to display results, with properly programmed buttons for ease of use.
	- Use of tables, to display data queried from the database(used row set).

---
## Basic information

When user starts the program, the database is automatically populated with 10 players' data. Program then allows to display the list of players, edit details, add new players or delete existing players. Database is created in PostgreSQL on the hosting server (Elephantsql.com), so it does not have downtime and is ready to use anytime by anyone. Password and user name are entered into the code to allow for easy login. 

Once selection criteria is entered on the main page (Player's list tab), the Search button is to be pushed to. If mistakes is made, the Reset form will reset all data from cells.

---
### Options:

	- Add new players/members
	- Edit players/members data
	- Delete players/members
	- Select players/members from the database (selection criteria are: First name, Last name, Country, Age, Date of Birth.

---
## Setup
  

Follow download instructions, here: <a href="https://github.com/mail4rayo/ClubManagement_Java/blob/main/ClubManagement - Download instructions.pdf" target="_blank">Club Management - Download instructions.pdf</a>

USER GUID is located in the repository here:
<a href="https://github.com/mail4rayo/ClubManagement_Java/blob/main/Club Management - User guide.pdf" target="_blank">Club Management - User guide.pdf</a>

---
## Files (Classes) Used:

- <a href ="https://github.com/mail4rayo/ClubManagement_Java/blob/main/ClubManagement/src/TeamApp.java">TeamApp.java</a> - main file used as the GUI and to initialize the program.
- <a href="https://github.com/mail4rayo/ClubManagement_Java/blob/main/ClubManagement/src/ConnectionToDB.java">ConnectionToDB.java</a> - used to manage only the connection the database.
- <a href="https://github.com/mail4rayo/ClubManagement_Java/blob/main/ClubManagement/src/OperationsOnDB.java">OperationsOnDB.java</a> - used to manage all operations in the database
---
## Files (Classes) not currently used:

- <a href = "https://github.com/mail4rayo/ClubManagement_Java/blob/main/ClubManagement/src/Run.java">Run.java</a> - Test file used to add players and check data consistency. Used during development.
- <a href = "https://github.com/mail4rayo/ClubManagement_Java/blob/main/ClubManagement/src/PlayerCounter.java">PlayerCounter.java</a> -  Test file used to add players and check data consistency. Used during development.
- <a href = "https://github.com/mail4rayo/ClubManagement_Java/blob/main/ClubManagement/src/Team.java">Team.java</a> -  Test file used to add players and check data consistency. Used during development.
- <a href = "https://github.com/mail4rayo/ClubManagement_Java/blob/main/ClubManagement/src/Players.java">Players.java</a> -  Test file used to add players and check data consistency. Used during development.
- <a href = "https://github.com/mail4rayo/ClubManagement_Java/blob/main/ClubManagement/src/EditPlayer.java">EditPlayer.java</a> - not used currently ( will be used to have separate editing window for player's data.
- <a href = "https://github.com/mail4rayo/ClubManagement_Java/blob/main/ClubManagement/src/Person.java">Person.java</a> - not used currently (will be used to generalize data, and separate Personal and Player's data)

---
## Challenges / Interesting solutions:
	- Created DB user as the  table owner, for proper testing of the model's functionality.
	- When new user opens the program, data is always refreshed to original state. If table already exists,  on startup, the program will delete the table and then add all columns and original data into it. New user will always receive new (fresh) table with data. If table does not exist, it will be created.
	- Each player/member is represented by the "number", to be able to identify each record unanimously.
	- When record is updated, the data will always be sorted by the user "number", so new records will be displayed at the end and edited records in their proper order.

---
## Know bugs to be fixed in future releases:

	- Not possible to search by Country or the Date of Birth: Not programmed yet as initial release focused on filtering by first name, last name and age.
---
## Improvements considered in the future releases:

	- Automatic refresh of the table after updating the record or entering new record: Currently, user need to go to Player's list tab and push Search to refresh data in the table.
	- Some of the .java files are not used at the moment due to their role in future release of the program to make it more general (i.e. Add persons with more personal information than what is needed in the club, and to be able to better manage player's list).
---
## Versions:

	1. 2020-10-06 Initial release
	2. 2020-10-09 Fixed the following issues: 
	- Fixed edit function which was not working for new entries. This was due to the fact that when entering the record, the "start date" was not being saved in the database. When editing record, this data is required to be used, so program would have crashed. The check was added if this data is entered or not and editing records entered by user is now possible.
	-  Removed all unnecessary comments from classes to make them more clear and easy to understand.

---
## Technologies used:
	- IDE: Eclipse
	- GUI: Java AWT 
	- DB: PostgreSQL (Elephantsql.com hosting)
	- DB API: Java JDBC
---
## Glossary:
	- IDE - Integrated Development Environment
	- GUI - Graphical User Interface
	- AWT - Abstract Window Toolkit
	- DB - Database
	- API - Application Programming Interface 
	- JDBC - Java Database Connectivity
