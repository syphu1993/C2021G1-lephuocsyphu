package Models;

public class Employee {
    private String nameEmployee;
    private String ageEmloyee;
    private String adressEmployee;

    public Employee() {
    }

    public Employee(String nameEmployee, String ageEmloyee, String adressEmployee) {
        this.nameEmployee = nameEmployee;
        this.ageEmloyee = ageEmloyee;
        this.adressEmployee = adressEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getAgeEmloyee() {
        return ageEmloyee;
    }

    public void setAgeEmloyee(String ageEmloyee) {
        this.ageEmloyee = ageEmloyee;
    }

    public String getAdressEmployee() {
        return adressEmployee;
    }

    public void setAdressEmployee(String adressEmployee) {
        this.adressEmployee = adressEmployee;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "nameEmployee='" + nameEmployee + '\'' +
                ", ageEmloyee='" + ageEmloyee + '\'' +
                ", adressEmployee='" + adressEmployee + '\'' +
                '}';
    }
}
