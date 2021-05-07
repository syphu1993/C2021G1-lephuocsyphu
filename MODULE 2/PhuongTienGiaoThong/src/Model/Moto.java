package Model;

public class Moto extends Transport {
    private int congSuat;

    public Moto() {
    }

    public Moto(String bienKiemSoat, String tenHangSanXuat, String chuSoHuu, int congSuat) {
        super(bienKiemSoat, tenHangSanXuat, chuSoHuu);
        this.congSuat = congSuat;
    }

    public int getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(int congSuat) {
        this.congSuat = congSuat;
    }

    @Override
    public String toString() {
        return "XeMay{" +
                "congSuat=" + congSuat +
                '}'+super.toString();
    }
}
