package Models;

public class Customer implements Comparable<Customer> {
    private  String nameCustomer;
    private  String birthdayCustomer;
    private  String genderCustomer;
    private  String cnmdCustomer;
    private  String numberPhoneCustomer;
    private  String emailCustomer;
    private  String typeCustomer;
    private  String adressCustomer;
    private  Services useServices;

    public Customer() {
    }

    public Customer(String nameCustomer, String birthdayCustomer, String genderCustomer, String cnmdCustomer, String numberPhoneCustomer, String emailCustomer, String typeCustomer, String adressCustomer, Services useServices) {
        this.nameCustomer = nameCustomer;
        this.birthdayCustomer = birthdayCustomer;
        this.genderCustomer = genderCustomer;
        this.cnmdCustomer = cnmdCustomer;
        this.numberPhoneCustomer = numberPhoneCustomer;
        this.emailCustomer = emailCustomer;
        this.typeCustomer = typeCustomer;
        this.adressCustomer = adressCustomer;
        this.useServices = useServices;
    }
    public void showInfor(){
        System.out.println(this.toString());
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getBirthdayCustomer() {
        return birthdayCustomer;
    }

    public void setBirthdayCustomer(String birthdayCustomer) {
        this.birthdayCustomer = birthdayCustomer;
    }

    public String getGenderCustomer() {
        return genderCustomer;
    }

    public void setGenderCustomer(String genderCustomer) {
        this.genderCustomer = genderCustomer;
    }

    public String getCnmdCustomer() {
        return cnmdCustomer;
    }

    public void setCnmdCustomer(String cnmdCustomer) {
        this.cnmdCustomer = cnmdCustomer;
    }

    public String getNumberPhoneCustomer() {
        return numberPhoneCustomer;
    }

    public void setNumberPhoneCustomer(String numberPhoneCustomer) {
        this.numberPhoneCustomer = numberPhoneCustomer;
    }

    public String getEmailCustomer() {
        return emailCustomer;
    }

    public void setEmailCustomer(String emailCustomer) {
        this.emailCustomer = emailCustomer;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAdressCustomer() {
        return adressCustomer;
    }

    public void setAdressCustomer(String adressCustomer) {
        this.adressCustomer = adressCustomer;
    }

    public Services getUseServices() {
        return useServices;
    }

    public void setUseServices(Services useServices) {
        this.useServices = useServices;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "nameCustomer='" + nameCustomer + '\'' +
                ", birthdayCustomer='" + birthdayCustomer + '\'' +
                ", genderCustomer='" + genderCustomer + '\'' +
                ", cnmdCustomer='" + cnmdCustomer + '\'' +
                ", numberPhoneCustomer='" + numberPhoneCustomer + '\'' +
                ", emailCustomer='" + emailCustomer + '\'' +
                ", typeCustomer='" + typeCustomer + '\'' +
                ", adressCustomer='" + adressCustomer + '\'' +
                ", useServices=" + useServices +
                '}';
    }

    @Override
    public int compareTo(Customer sencond) {
        int result = this.nameCustomer.compareTo(sencond.nameCustomer);
        if (result==0){
            int yearFirstCustomer = Integer.parseInt(this.birthdayCustomer.split("/")[2]);
            int yearSecondCustomer = Integer.parseInt(sencond.birthdayCustomer.split("/")[2]);
            result = yearFirstCustomer-yearSecondCustomer;
        }
        return result;
    }
}
