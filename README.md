# ClubManagement_Java
This is the program to manage a list of players/members of sport's club or organization.

Note: This program is made to demonstrate some abilities of the programmer and is to be used to qualify the candidate for a job position. 

Database is automatically populated with 10 players on the start of the program. Program then allows to display the list of players, edit details, add new players or delete existing players. Database is made in Postgres on the server, so it does not have downtime and is ready to use anytime.

Once selection criteria is entered on the main page (Player's list tab), the Search button is to be pushed to. If mistakes is made, the Reset form will reset all data from cells.

Options:
- Add new players/members
- Edit players/members data
- Delete players/members
- Select players/members from the database (selection criteria are: First name, Last name, Country, Age, Date of Birth.


Interesting options


Challenges:
- create user and sql code to make sure when new user opens the program, data is always refreshed to original state: This was done with the used to be the owner of the table. If table is already created, on startup, the program will delete the table and then add all columns and data.



Technologies used:
IDE: Eclipse
GUI: Java AWT 
DB: Postgres,
DB API: Java JDBC

Dictionary:
IDE - Integrated Development Environment
GUI - Graphical User Interface
AWT - Abstract Window Toolkit
DB - Database
API - Application Programming Interface 
JDBC - Java Database Connectivity

