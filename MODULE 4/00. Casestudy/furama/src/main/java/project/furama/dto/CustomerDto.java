package project.furama.dto;

import project.furama.model.TypeCustomer;

import javax.persistence.Column;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class CustomerDto {
    private Integer id;
    @NotEmpty(message = "Input code please!")
    @Pattern(regexp="^KH-[\\d]{4}$",message = "Code is not format KH-0000")
    private String code;
    private String name;
    private String birthday;
    private String gender;
    @NotEmpty(message = "Input id card please!")
    @Pattern(regexp="^(([\\d]{9})|([\\d]{12}))$",message = "Id card is not format!")
    private String idCard;
    @NotEmpty(message = "Input number phone please!")
    @Pattern(regexp="^((\\(84\\)\\+90)|(\\(84\\)\\+91)|(090)|(091))[\\d]{7}$",message = "Number phone is not format!")
    private String phone;
    @NotEmpty(message = "Input email please!")
    @Pattern(regexp = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)+$",message = "Email is not format!")
    private String email;
    private String address;
    private int flag;
    private TypeCustomer typeCustomer;

    public CustomerDto() {
    }

    public CustomerDto(Integer id, String code, String name, String birthday, String gender, String idCard, String phone, String email, String address, int flag, TypeCustomer typeCustomer) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.flag = flag;
        this.typeCustomer = typeCustomer;
    }

    public CustomerDto(String code, String name, String birthday, String gender, String idCard, String phone, String email, String address, int flag, TypeCustomer typeCustomer) {
        this.code = code;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.flag = flag;
        this.typeCustomer = typeCustomer;
    }

    public CustomerDto(String code, String name, String birthday, String gender, String idCard, String phone, String email, String address, TypeCustomer typeCustomer) {
        this.code = code;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.typeCustomer = typeCustomer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public TypeCustomer getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(TypeCustomer typeCustomer) {
        this.typeCustomer = typeCustomer;
    }
}
