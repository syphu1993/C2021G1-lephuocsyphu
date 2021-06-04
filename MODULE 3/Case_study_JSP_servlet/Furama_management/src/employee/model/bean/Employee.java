package employee.model.bean;

public class Employee {
    private int id;
    private String name;
    private String birthday;
    private String idCard;
    private double salary;
    private String phone;
    private String email;
    private String address;
    private String position;
    private String degree;
    private String division;
    private String username;

    public Employee(int id, String name, String birthday, String idCard, double salary, String phone, String email, String address, String position, String degree, String division, String username) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.position = position;
        this.degree = degree;
        this.division = division;
        this.username = username;
    }

    public Employee(String name, String birthday, String idCard, double salary, String phone, String email, String address, String position, String degree, String division, String username) {
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.position = position;
        this.degree = degree;
        this.division = division;
        this.username = username;
    }

    public Employee(int id, String name, String phone, String address, String position, String degree, String division) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.position = position;
        this.degree = degree;
        this.division = division;
    }

    public Employee() {
    }

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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", idCard='" + idCard + '\'' +
                ", salary=" + salary +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", position='" + position + '\'' +
                ", degree='" + degree + '\'' +
                ", division='" + division + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
