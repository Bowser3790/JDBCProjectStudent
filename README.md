# JDBC Project README

Welcome to the JDBC Project! This project is a simple Java application that demonstrates the use of 
Java Database Connectivity (JDBC) to interact with a database. It provides functionality to manage student 
records and showcases the fundamental concepts of database interactions in Java.


## Introduction

Java Database Connectivity (JDBC) is an essential API that allows Java applications to interact with relational databases. This project leverages JDBC to demonstrate basic CRUD (Create, Read, Update, Delete) operations on a student records database.

## Project Structure

The project directory has the following structure:

- `.idea`: This directory contains configuration files for the IntelliJ IDEA IDE (Integrated Development Environment). It's not essential for the project's functionality but is specific to the IDE settings.

- `src/main/java`: The main Java source code directory contains the following files:

    - `Runner.java`: This is the main class of the project. It contains the `main` method where the application starts its execution.

    - `Student.java`: This class represents the model for the Student entity. It defines the attributes of a student and their getters and setters.

    - `StudentRepository.java`: The StudentRepository class handles the database operations related to students. It includes methods to add, update, retrieve, and delete student records.

    - `StudentService.java`: The StudentService class acts as an intermediary between the Runner class and the StudentRepository class. It provides a high-level interface for interacting with the student records.

- `target/classes`: This directory contains the compiled class files after building the project. It's created automatically when you build the project using Maven.

- `pom.xml`: The POM (Project Object Model) is an XML file that defines the project's configuration and dependencies. It's used by the Maven build tool to manage the project.


