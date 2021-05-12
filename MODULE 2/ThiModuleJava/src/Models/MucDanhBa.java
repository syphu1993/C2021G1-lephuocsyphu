package Models;

public class MucDanhBa {
    private  String soDienThoai;
    private String nhomDanhBa;
    private String hoten;
    private String gioiTinh;
    private String diaChi;
    private String ngaySinh;
    private String email;

    public MucDanhBa() {
    }

    public MucDanhBa(String soDienThoai, String nhomDanhBa, String hoten, String gioiTinh, String diaChi, String ngaySinh, String email) {
        this.soDienThoai = soDienThoai;
        this.nhomDanhBa = nhomDanhBa;
        this.hoten = hoten;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getNhomDanhBa() {
        return nhomDanhBa;
    }

    public void setNhomDanhBa(String nhomDanhBa) {
        this.nhomDanhBa = nhomDanhBa;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return soDienThoai + "," + nhomDanhBa + "," + hoten + "," + gioiTinh + "," + diaChi + "," + ngaySinh + "," + email;
    }
    public String showInfor() {
        return "MucDanhBa{" +
                "soDienThoai='" + soDienThoai + '\'' +
                ", nhomDanhBa='" + nhomDanhBa + '\'' +
                ", hoten='" + hoten + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
