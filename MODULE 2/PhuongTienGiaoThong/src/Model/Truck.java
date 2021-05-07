package Model;

public class Truck extends Transport {
    private double taiTrong;

    public Truck() {
    }

    public Truck(String bienKiemSoat, String tenHangSanXuat, String chuSoHuu, double taiTrong) {
        super(bienKiemSoat, tenHangSanXuat, chuSoHuu);
        this.taiTrong = taiTrong;
    }

    public double getTaiTrong() {
        return taiTrong;
    }

    public void setTaiTrong(double taiTrong) {
        this.taiTrong = taiTrong;
    }

    @Override
    public String toString() {
        return "XeTai{" +
                "taiTrong=" + taiTrong +
                '}'+super.toString();
    }
}
