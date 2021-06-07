package contract.model.bean;

public class Contract {
    private int id;
    private String startDay;
    private String endDay;
    private double deposit;
    private double totalMoney;
    private int idEmployee;
    private int idCustomer;
    private int idService;

    public Contract(int id, String startDay, String endDay, double deposit, double totalMoney, int idEmployee, int idCustomer, int idService) {
        this.id = id;
        this.startDay = startDay;
        this.endDay = endDay;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
        this.idEmployee = idEmployee;
        this.idCustomer = idCustomer;
        this.idService = idService;
    }

    public Contract(String startDay, String endDay, double deposit, double totalMoney, int idEmployee, int idCustomer, int idService) {
        this.startDay = startDay;
        this.endDay = endDay;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
        this.idEmployee = idEmployee;
        this.idCustomer = idCustomer;
        this.idService = idService;
    }

    public Contract(int id, String startDay, String endDay, double deposit, double totalMoney) {
        this.id = id;
        this.startDay = startDay;
        this.endDay = endDay;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
    }

    public Contract() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", startDay='" + startDay + '\'' +
                ", endDay='" + endDay + '\'' +
                ", deposit=" + deposit +
                ", totalMoney=" + totalMoney +
                ", idEmployee=" + idEmployee +
                ", idCustomer=" + idCustomer +
                ", idService=" + idService +
                '}';
    }
}
