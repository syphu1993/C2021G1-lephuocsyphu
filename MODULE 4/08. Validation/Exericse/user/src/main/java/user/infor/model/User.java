package user.infor.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firtName;
    private String lastName;
    private String numberPhone;
    private Integer age;
    private String email;

    public User() {
    }

    public User(Integer id, String firtName, String lastName, String numberPhone, Integer age, String email) {
        this.id = id;
        this.firtName = firtName;
        this.lastName = lastName;
        this.numberPhone = numberPhone;
        this.age = age;
        this.email = email;
    }

    public User(String firtName, String lastName, String numberPhone, Integer age, String email) {
        this.firtName = firtName;
        this.lastName = lastName;
        this.numberPhone = numberPhone;
        this.age = age;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirtName() {
        return firtName;
    }

    public void setFirtName(String firtName) {
        this.firtName = firtName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
