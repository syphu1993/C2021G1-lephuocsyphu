package user.infor.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDto implements Validator{
    private Integer id;

    @NotEmpty
    @Size(min = 5, max = 45)
    private String firtName;

    @NotEmpty
    @Size(min = 5, max = 45)
    private String lastName;

    private String numberPhone;

    @NotNull
    @Min(18)
    private Integer age;

    @NotEmpty
    @Pattern(regexp="^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)+$")
    private String email;

    public UserDto() {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        String number = userDto.getNumberPhone();
        ValidationUtils.rejectIfEmpty(errors, "numberPhone", "number.empty");
        if (number.length()>11 || number.length()<10){
            errors.rejectValue("numberPhone", "number.length");
        }
        if (!number.startsWith("0")){
            errors.rejectValue("numberPhone", "number.startsWith");
        }
        if (!number.matches("(^$|[0-9]*$)")){
            errors.rejectValue("numberPhone", "number.matches");
        }
    }
}
