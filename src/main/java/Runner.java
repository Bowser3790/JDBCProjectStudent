import java.sql.SQLException;
import java.util.Scanner;

public class Runner {

    /*
    Mini Project: Student Management System
    1. Create Student Management System that can be used by any Educational Institution.
    2. User (Admin) can: CRUD (Create, Read, Update, Delete). (part of DML)
        - register user (id, firstname, lastname, city, age fields)
        - list/display student/students
        - update student by id
        - delete student by id

     Steps:
     1. Create Control Menu for the application
     2. Create Student Class
     3. Create Service Class to write codes and create business logic
     4. Create Repository Class -> communicate with DB


     */
    public static void main(String[] args) throws SQLException {
        start();
    }
    private static void start() throws SQLException {
        Scanner inp = new Scanner(System.in); //-Part of step 1-

        // -Part of STEP 9- is to connect the Runner class to the StudentService class - WHY? because the runner class
        // -Part of STEP 9-needs to talk to the service class (this is where the logic is) so we need the main method to talk with service class.
        StudentService service = new StudentService();
        // -Part of STEP 9-every time we start() this application the application will create a table
        service.createTable();
        //-Part of STEP 9-The issue we are going to run into is if we already have a table created this will give an error.
        // -Part of STEP 9- Go to StudentRepository --> (STEP 8) IF NOT EXISTS after CREATE TABLE (we will make changes there to fix this error)
        System.out.println("Table has been created successfully");
        int select; //-Part of step 1- continue below...
        do {
            System.out.println("=====================================");
            System.out.println("********Student Admin Panel**********");
            System.out.println("1-Student Register");
            System.out.println("2-List All Students");
            System.out.println("3-Update Student");
            System.out.println("4-Delete Student");
            System.out.println("5-Display Student Detail");
            System.out.println("0-To Exit Application");

            select = inp.nextInt();
            inp.nextLine(); // to call next enter
            int id;
            switch (select) {
                case 1:
                    // register
                    service.saveStudent();
                    break;
                case 2:
                    // list all students
                    service.getAllStudents();
                    break;
                case 3:
                    // update student
                    id = getStudentId(inp);
                    break;
                case 4:
                    // Delete student
                    id = getStudentId(inp);
                    service.deleteStudent(id);
                    break;
                case 5:
                    // find student by id.
                    id = getStudentId(inp);
                    Student student = service.findStudentByID(id);
                    System.out.println(student); // this will print student information on the console.


                    break;
                case 0:
                    // exit
                    System.out.println("Thank you for using this application! Have a nice day!");

                    break;
                default:
                    System.out.println("Please enter valid number");
            }
        } while (select != 0);
    }

            // method to ask user to enter student id.
            private static int getStudentId(Scanner input){
                System.out.println("Enter Student id");
                int id = input.nextInt();
                input.nextLine();
                return id;

        }
    }

