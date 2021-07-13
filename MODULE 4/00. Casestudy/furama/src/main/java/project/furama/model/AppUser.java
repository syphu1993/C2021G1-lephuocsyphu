package project.furama.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class AppUser {
    @Id
    private String userName;

    private String passWord;

    @OneToOne(mappedBy = "user")
    private Employee employee;

    public AppUser() {
    }

    public AppUser(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
