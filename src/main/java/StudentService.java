import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

// To handle the business logic
public class StudentService {

    // this Object is to have access to the methods in the repository (I think Maven)

    StudentRepository repository = new StudentRepository();

    Scanner inp = new Scanner(System.in);

    // TASK 9 -- method to create table
    public void createTable(){
        repository.createTable();

        // next -> runner class needs to talk to the service class
    }
    // Task 10 -- method to register student to database

    public void saveStudent(){

        System.out.println("Name: ");
        String name = inp.nextLine();
        System.out.println("Lastname: ");
        String lastname = inp.nextLine();
        System.out.println("City: ");
        String city = inp.nextLine();
        System.out.println("Age: ");
        int age = inp.nextInt();

        inp.nextLine(); // teacher said to put this here because we may run into a phase issue???

        // next step is to create student object when you complete the --TASK 10--

        Student newStudent = new Student(name, lastname, city, age);
        repository.save(newStudent);

    }
        // --TASK 12-- Method to list/display all students
    public void getAllStudents() throws SQLException {
        repository.findAll();
    }

    // TASK 14 Method to delete student
    public void deleteStudent(int id){
        repository.delete(id);

    }
    // TASK 16 -- Method to find student by id

    public Student findStudentByID(int id){
        Student student = repository.searchById(id);
        return student;
    }

}
