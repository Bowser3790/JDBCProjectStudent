import java.sql.*;

// this class will communicate with Database
public class StudentRepository {

    //STEP 4: create connection to the Database
    private Connection con;
    private Statement stmt;
    private PreparedStatement prepS;

    // STEP 5: method to create connection with database
    private void getConnection(){
        try {
            this.con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db",
                    "dev_user","password");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    // STEP 6: Method to create Statement
    private void getStatement(){
        try {
            this.stmt = con.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    // STEP 7: Method to create PreparedStatement
    private void getPreparedStatement(String query){
        try {
            this.prepS = con.prepareStatement(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    // STEP 8: Method to create Table
    public void createTable(){
        // this method is connecting with the StudentService class in --TASK 9-- this will create table with the code below.
        getConnection(); // create connection
        getStatement(); // need to be able to run query
        try {
            stmt.execute("CREATE TABLE IF NOT EXISTS t_student(id SERIAL,name VARCHAR(50)," +
                    "lastname VARCHAR(50),city VARCHAR(50),age INT)"); // IF NOT EXIST means that if there is not a table create it.
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    // --TASK 11--method to save newStudent or new registrations to database.

    public void save(Student newStudent) {
        getConnection();
        String query = "INSERT INTO t_student (name, lastname, city, age) VALUES(?, ?, ?, ?)";
        getPreparedStatement(query);
        try {
            prepS.setString(1, newStudent.getName());
            prepS.setString(2, newStudent.getLastname());
            prepS.setString(3, newStudent.getCity());
            prepS.setInt(4, newStudent.getAge());
            int numOfUpdatedRows = prepS.executeUpdate();
            System.out.println(numOfUpdatedRows + " Executed Successfully!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }finally {
            try {
                prepS.close();
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());

            }

        }

    }

    // TASK 13-- Method to get all students from database
    public void findAll() throws SQLException {
        getConnection();
        String query = "SELECT * FROM t_student";
        getStatement();
        try {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                System.out.println("id: " + rs.getString("id"));
                System.out.println("name: " + rs.getString("name"));
                System.out.println("lastname: " + rs.getString("lastname"));
                System.out.println("city: " + rs.getString("city"));
                System.out.println("age: " + rs.getString("age"));
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            try{
                stmt.close();
                con.close();

            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
    // TASK 15 -- METHOD to delete student from database
    public void delete(int id) {
        getStatement();
        String query = "DELETE FROM t_student WHERE id = ?";
        getPreparedStatement(query);
        try {
            prepS.setInt(1, id);
            int deleted = prepS.executeUpdate();// returns row counts if 1 row was delete it would report 1.
            if (deleted>0){
                System.out.println("Student with id: " +id+ " deleted successfully!");
            }else {
                System.out.println("Student id " +id+ " not found.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                stmt.close();
                con.close();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }

    }
    // TASK 17 Method to find student by ID
    public Student searchById(int id) {
        Student student = null;
        getConnection();
        String query = "SELECT * FROM t_student WHERE id = ?";
        getPreparedStatement(query);
        try {
            prepS.setInt(1, id);
            ResultSet rs = prepS.executeQuery(); // returns result set
            while (rs.next()){
                student = new Student(); // new student object to get the result set from ResultSet save the data in the object
                // this student object is using the empty constructor we created in student class.
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setLastname(rs.getString("lastname"));
                student.setCity(rs.getString("city"));
                student.setAge(rs.getInt("age"));
                // note that we are searching for a student with a certain id... we need to return all the data from the
                // table, we need to set all the information so when we return the student we get all of their info.
                // if we only set name and lastname then that is all the info that we will be able to return.
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return student;
    }
}
