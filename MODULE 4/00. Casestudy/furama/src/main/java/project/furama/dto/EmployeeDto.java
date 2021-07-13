package project.furama.dto;

import project.furama.model.Degree;
import project.furama.model.Division;
import project.furama.model.Position;
import project.furama.model.AppUser;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class EmployeeDto {
    private Integer id;
    private String name;
    private String birthday;
    @NotEmpty(message = "Input id card please!")
    @Pattern(regexp="^(([\\d]{9})|([\\d]{12}))$",message = "Id card is not format!")
    private String idCard;
    @NotNull(message = "Input salary please!")
    @DecimalMin("0.00")
    private double salary;
    @NotEmpty(message = "Input number phone please!")
    @Pattern(regexp="^((\\(84\\)\\+90)|(\\(84\\)\\+91)|(090)|(091))[\\d]{7}$",message = "Number phone is not format!")
    private String phone;
    @NotEmpty(message = "Input email please!")
    @Pattern(regexp = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)+$",message = "Email is not format!")
    private String email;
    private String address;
    private Position position;
    private Degree degree;
    private Division division;
    private AppUser user;
    private int flag;
    public EmployeeDto() {
    }

    public EmployeeDto(String name, String birthday, String idCard, double salary, String phone, String email, String address, Position position, Degree degree, Division division, AppUser user, int flag) {
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
        this.user = user;
        this.flag = flag;
    }

    public EmployeeDto(String name, String birthday, String idCard, double salary, String phone, String email, String address, Position position, Degree degree, Division division, AppUser user) {
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
        this.user = user;
    }

    public EmployeeDto(String name, String birthday, String idCard, double salary, String phone, String email, String address, Position position, Degree degree, Division division) {
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
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}

