# Aggregation
Pre-requisites:
1. JDK(jdk>=1.8)
2. MySQL(>v5.8)
3. Eclipse
4. JDBC-MySQL connector


Run Procedure:
1. Open Eclipse and select Import Existing Project into workspace from File menu
2. Select the downloaded project from appropriate location
3. Compile the project for any errors or compatibility issues
4. If any compatibility issues arise upgrade the version of jdk to 1.8
5. Run the project as a java application(CTRL+F11)
6. Select Enter at home screen of application to enter details into the databse
7. Select View to enter query to be executed or for viewing sum and average of the marks 
8. After choosing View enter the query in the provided text field to run a custom query

Note:
1. Please check the schema of database before entering query into the query field
2. Enter your MySQL username and password in SQLAcess.java at line number 20

Description of source files:
AggregationMain.java:
Starting point of the application providing options to select either entering the data or viewing the required data using queries

EnterDetails.java:
User Interface to enter details into the MySQL database. MySQL database connectivity is done using SQLAcess class

Query.java:
Giving user the interface to enter his naive and dumb query which will be later converted into application related one in SQLAcess class

ViewDetails.java:
UserInterface to show the results of the query entered by the user in Query class

SQLAcess.java:
The most important class of the project containing the database connectivity and query transformation as well as insertion functions

Crypt.java:
The class used to encrypt the data i.e., marks using AES encryption
