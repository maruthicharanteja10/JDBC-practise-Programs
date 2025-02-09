# JDBC Practise codes

This repository contains a collection of Java programs that demonstrate various JDBC operations using MySQL. The examples are organized into two parts:

1. **jdbcDemo** – Basic JDBC operations such as:
   - Loading and registering the MySQL driver.
   - Establishing a database connection.
   - Creating statements.
   - Creating databases and tables.
   - Inserting, updating, deleting, and fetching records.
   - Demonstrating both Statement and PreparedStatement usage.
   - Simple login validation using phone number and password.

2. **jdbcAssignment** – Additional JDBC examples focused on deleting and fetching records by different criteria (e.g., name, phone, ID, password combinations).

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Setup and Running the Examples](#setup-and-running-the-examples)
- [Future Enhancements](#future-enhancements)
- [License](#license)
- [Contact](#contact)

## Overview

This project demonstrates a wide range of basic JDBC operations for learning and practice. The examples cover:
- How to load and register the JDBC driver (using both direct registration and `Class.forName`).
- How to establish and close connections properly.
- How to create a database and a table.
- How to perform CRUD (Create, Read, Update, Delete) operations using both `Statement` and `PreparedStatement`.
- Examples of fetching specific fields and validating login credentials.

## Features

- **Driver Registration:**  
  Demonstrates two methods to load and register the MySQL driver.
- **Connection Management:**  
  Shows how to open and close database connections safely.
- **Database/Table Creation:**  
  Creates a new database (`jdbc_demo`) and a table (`person`).
- **Record Manipulation:**  
  Inserts, updates, deletes, and fetches records using various SQL queries.
- **Multiple Criteria Operations:**  
  Examples include operations based on employee ID, phone number, name, and password.

## Project Structure

Below is a diagram of the project structure:

```plaintext
org/
 └─ jsp/
     ├─ jdbcDemo/                          # Basic JDBC examples
     │   ├── _01_LoadAndRegisterDriver.java         // Loads and registers driver explicitly
     │   ├── _02_LoadAndRegisterDriver2.java          // Loads driver using Class.forName
     │   ├── _03_EstablishConnection.java             // Establishes connection to MySQL
     │   ├── _04_CreateStatement.java                 // Demonstrates creation of Statement
     │   ├── _05_CreateDatabase.java                  // Creates a new database
     │   ├── _06_CreatePersonTable.java               // Creates the 'person' table
     │   ├── _07_InsertRecordsInPerson.java           // Inserts a record into the table
     │   ├── _08_UpdatePerson.java                    // Updates a record in the table
     │   ├── _09_DeletePerson.java                    // Deletes a record from the table
     │   ├── _10_FetchAllRecords.java                 // Fetches all records from the table
     │   ├── _11_InsertMultipleRecordsByStatement.java// Inserts multiple records using Statement
     │   ├── _12_InsertMultipleRecordsByPreparedStatement.java // Inserts multiple records using PreparedStatement
     │   ├── _13_UpdatePersonByPS.java                // Updates record using PreparedStatement
     │   ├── _14_DeletePersonByPS.java                // Deletes record using PreparedStatement
     │   ├── _15_FetchRecordsByPS.java                // Fetches records using PreparedStatement
     │   └── _16_LoginValidationByUsingPhonenoAndPsswd.java // Login validation example
     └─ jdbcAssignment/                      # Additional JDBC examples
         ├── _01_deleteRecordWithThisName.java       // Delete record by name
         ├── _02_deleteRecordWithThePhoneno.java       // Delete record by phone number
         ├── _03_deleteRecordwithIdAndPsswd.java       // Delete record by ID and password
         ├── _04_deleteRecordwithphonenoAndPsswd.java    // Delete record by phone and password
         ├── _05_deleteRecordwithNameAndPsswd.java       // Delete record by name and password
         ├── _06_fetchrecordWhereName.java             // Fetch record where name matches
         ├── _07_FetchtheRecordWherePhoneno.java         // Fetch record where phone matches
         ├── _08_fetchTheNames.java                    // Fetch only the names
         ├── _09_FetchThePhonenos.java                 // Fetch only the phone numbers
         └── _10_FetchTheIds.java                      // Fetch only the IDs
```
## Prerequisites

- **Java Development Kit (JDK):** Version 8 or higher.
- **MySQL Server:** Ensure MySQL is installed and running.
- **MySQL JDBC Driver:** (e.g., `mysql-connector-java.jar`) must be added to the classpath.

## Setup and Running the Examples

### 1. Database Setup

- **Create Database:**  
  Run `_05_CreateDatabase.java` to create the database named `jdbc_demo`.

- **Create Table:**  
  Run `_06_CreatePersonTable.java` to create the `person` table.

### 2. Compiling and Running

Compile and run each example as needed. For example, to compile from the command line:

```bash
# Compile all Java files (adjust paths as needed)
javac -d bin -cp .;path/to/mysql-connector-java.jar org/jsp/jdbcDemo/*.java org/jsp/jdbcAssignment/*.java
```

Then, run a specific class:

```bash
# For example, to run the connection test:
java -cp bin;path/to/mysql-connector-java.jar org.jsp.jdbcDemo._03_EstablishConnection
```

*(Note: Replace `;` with `:` in the classpath on Unix-based systems.)*

### 3. Running the Assignment Examples

The files in the `jdbcAssignment` package provide additional deletion and fetching examples based on different criteria. Run them individually as needed, following the same steps for compiling and executing.

## Future Enhancements

- **External Configuration:**  
  Use a properties file or environment variables to manage database credentials instead of hardcoding them.

- **Error Handling:**  
  Improve exception management and add logging using a framework like Log4j or SLF4J.

- **GUI Interface:**  
  Develop a graphical user interface for easier interaction with the application.

## License

This project is licensed under the [MIT License](LICENSE).

## Contact

For any questions or feedback, please contact:
- **Email:** [charantej@@gmail.com](mailto:charantej@gmail.com)
```.
