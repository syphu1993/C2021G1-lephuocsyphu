package Models;

public class BillElectronic {
    private String codeBill;
    private String idCustomer;
    private String dateMade;
    private double countPoinKW;
    private double priceOfone;
    private double sumPayingBill;
    private Customer customer;

    public BillElectronic() {
    }

    public BillElectronic(String codeBill, String idCustomer, String dateMade, double countPoinKW, double priceOfone, double sumPayingBill) {
        this.codeBill = codeBill;
        this.idCustomer = idCustomer;
        this.dateMade = dateMade;
        this.countPoinKW = countPoinKW;
        this.priceOfone = priceOfone;
        this.sumPayingBill = sumPayingBill;
    }

    public String getCodeBill() {
        return codeBill;
    }

    public void setCodeBill(String codeBill) {
        this.codeBill = codeBill;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getDateMade() {
        return dateMade;
    }

    public void setDateMade(String dateMade) {
        this.dateMade = dateMade;
    }

    public double getCountPoinKW() {
        return countPoinKW;
    }

    public void setCountPoinKW(int countPoinKW) {
        this.countPoinKW = countPoinKW;
    }

    public double getPriceOfone() {
        return priceOfone;
    }

    public void setPriceOfone(double priceOfone) {
        this.priceOfone = priceOfone;
    }

    public double getSumPayingBill() {
        return sumPayingBill;
    }

    public void setSumPayingBill(double sumPayingBill) {
        this.sumPayingBill = sumPayingBill;
    }
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return codeBill + ","+ idCustomer + "," + dateMade + "," + countPoinKW +"," + priceOfone + ","+ sumPayingBill;
    }

    public String showIforBill(){
        return "BillElectronic{" +
                "codeBill='" + codeBill + '\'' +
                ", idCustomer='" + idCustomer + '\'' +
                ", dateMade='" + dateMade + '\'' +
                ", countPoinKW=" + countPoinKW +
                ", priceOfone=" + priceOfone +
                ", sumPayingBill=" + sumPayingBill +
                '}';
    }
    public String showIforBillAndCustomer(){
        return "BillElectronic{" +
                "codeBill='" + codeBill + '\'' +
                ", dateMade='" + dateMade + '\'' +
                ", countPoinKW=" + countPoinKW +
                ", priceOfone=" + priceOfone +
                ", sumPayingBill=" + sumPayingBill +
                ", iforOfCustomer=" + customer +
                '}';
    }
}
