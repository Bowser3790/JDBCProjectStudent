
// class to create student object (entity, domain) class
public class Student {
    private int id;
    private String name;
    private String lastname;
    private String city;
    private int age;

    // now we need constructor

    public Student(int id, String name, String lastname, String city, int age) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.city = city;
        this.age = age;
    }

    // Getters and Setters -> generate
    public Student(){} // empty constructor

    public Student(String name, String lastname, String city, int age) {
    }
    // -> remember, if we don't create this method we will not be able to create an object without parameters
    // such as Student student1 = new Student(); we will not be able to create this. We create empty method so by
    // chance if we need to create an object without parameters we can complete the task.

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //toString() -> generate

    @Override
    public String toString() {
        return
                "id=" + id +
                ", name='" + name +
                ", lastname='" + lastname +
                ", city='" + city +
                ", age=" + age;
    }
}
