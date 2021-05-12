package Controller;

import Commons.ReadWriteFile;
import Commons.Validator;
import Models.MucDanhBa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLyDanhBa {
    public static void main(String[] args) {
        diplayMenu();
    }

    private static Scanner scanner = new Scanner(System.in);
    private static List<MucDanhBa> listDanhBaFileGhi;
    //    private static List<MucDanhBa> listDanhBaFiledoc;
    private static boolean isExit;
    private static boolean isBackMenu;

    public static void diplayMenu() {
        String choose = null;
        do {
            System.out.println("Chọn chức năng:\n" +
                    "1. Xem danh sách.\n" +
                    "2. Thêm mới.\n" +
                    "3. Cập nhật.\n" +
                    "4. Xóa.\n" +
                    "5. Tìm kiếm.\n" +
                    "6. Đọc từ file.\n" +
                    "7. Ghi từ file.\n" +
                    "8. Thoát\n");
            System.out.println(" Vui lòng chọn :");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    xemDanhSachs();
                    break;
                case "2":
                    themMoiDanhBa();
                    break;
                case "3":
                    capNhatDanhBa();
                    break;
                case "4":
                    xoaDanhBa();
                    break;
                case "5":
                    timKiemDanhBa();
                    break;
                case "6":
                    docFile();
                    break;
                case "7":
                    ghiFile();
                    break;
                case "8":
                    isExit = true;
                    System.out.println("Kết thúc chọn.");
                    break;
                default:
                    System.out.println("Vui lòng nhập lại:");
                    break;
            }
        } while (!isExit);
    }

    private static void xemDanhSachs() {
        List<MucDanhBa> lisDoc = new ArrayList<>();
        lisDoc = ReadWriteFile.readFile(ReadWriteFile.path1);
        for (int i = 0; i < lisDoc.size(); i++) {
            System.out.println("Muc:" + (i + 1));
            System.out.println(lisDoc.get(i).showInfor());
        }
        System.out.println("chọn mục cần hiển thị:");
        int chon = 0;
        int chonThongTin = 0;
        boolean check=true;
        chon = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < lisDoc.size(); i++) {
            if (chon - 1 == i) {
                do{
                    System.out.println("chọn thông tin hiển thị");
                    System.out.println("1. số điện thoại. \n 2.nhóm. \n 3.Họ tên.\n 4. Gioi tinh. \n 5. Đại chỉ.");
                    chonThongTin = Integer.parseInt(scanner.nextLine());
                    switch (chonThongTin) {
                        case 1:
                            System.out.println(lisDoc.get(i).getSoDienThoai());
                            break;
                        case 2:
                            System.out.println(lisDoc.get(i).getNhomDanhBa());
                            break;
                        case 3:
                            System.out.println(lisDoc.get(i).getHoten());
                            break;
                        case 4:
                            System.out.println(lisDoc.get(i).getGioiTinh());
                            break;
                        case 5:
                            System.out.println(lisDoc.get(i).getDiaChi());
                            break;
                        case 6:
                            check =false;
                            break;
                    }
                }while (check);
            }
        }
    }

    private static void themMoiDanhBa() {
        String soDienThoai;
        do{
            System.out.println("Thêm số điện thoại:");
            soDienThoai = scanner.nextLine();
        }while (!Validator.isValidatorID(soDienThoai,Validator.SDT_REGET));

        String nhomDanhBa;
        System.out.println("Thêm nhóm danh bạ:");
        nhomDanhBa = scanner.nextLine();

        String hoten;
        System.out.println("Thêm nhóm họ tên:");
        hoten = scanner.nextLine();

        String gioiTinh;
        System.out.println("Thêm giới tính:");
        gioiTinh = scanner.nextLine();

        String diaChi;
        System.out.println("Thêm địa chỉ:");
        diaChi = scanner.nextLine();

        String ngaySinh;
        System.out.println("Thêm ngày sinh:");
        ngaySinh = scanner.nextLine();

        String email;
        do{
            System.out.println("Thêm email:");
            email = scanner.nextLine();
        }while (!Validator.isValidatorID(email,Validator.EMAIL_REGET));

        MucDanhBa mucDanhBa = new MucDanhBa(soDienThoai, nhomDanhBa, hoten, gioiTinh, diaChi, ngaySinh, email);
        listDanhBaFileGhi = new ArrayList<>();
        listDanhBaFileGhi.add(mucDanhBa);
    }

    private static void capNhatDanhBa() {
        String soDienThoai;
        do{
            System.out.println("Thêm số điện thoại:");
            soDienThoai = scanner.nextLine();
        }while (!Validator.isValidatorID(soDienThoai,Validator.SDT_REGET));
        List<MucDanhBa> listDoc = new ArrayList<>();
        listDoc = ReadWriteFile.readFile(ReadWriteFile.path1);
        for (int i = 0; i <listDoc.size() ; i++)  {
            if ((listDoc.get(i).getSoDienThoai()).equals(soDienThoai)){
                listDoc.get(i).showInfor();
                String nhomDanhBa;
                System.out.println("Sửa nhóm danh bạ:");
                nhomDanhBa = scanner.nextLine();
                listDoc.get(i).setNhomDanhBa(nhomDanhBa);

                String hoten;
                System.out.println("Sửa nhóm họ tên:");
                hoten = scanner.nextLine();
                listDoc.get(i).setHoten(nhomDanhBa);

                String gioiTinh;
                System.out.println("Sửa giới tính:");
                gioiTinh = scanner.nextLine();
                listDoc.get(i).setGioiTinh(nhomDanhBa);

                String diaChi;
                System.out.println("Sửa địa chỉ:");
                diaChi = scanner.nextLine();
                listDoc.get(i).setDiaChi(nhomDanhBa);

                String ngaySinh;
                System.out.println("Sửa ngày sinh:");
                ngaySinh = scanner.nextLine();
                listDoc.get(i).setNgaySinh(nhomDanhBa);

                String email;
                do{
                    System.out.println("Sửa email:");
                    email = scanner.nextLine();
                    listDoc.get(i).setEmail(email);
                }while (!Validator.isValidatorID(email,Validator.EMAIL_REGET));
            }
        }
        System.out.println(listDoc);
        ReadWriteFile.writeFileReset(ReadWriteFile.path1);
        ReadWriteFile.writeFile(listDoc,ReadWriteFile.path1,true);
    }

    private static void xoaDanhBa() {
        String soDienThoai;
        do{
            System.out.println("Thêm số điện thoại:");
            soDienThoai = scanner.nextLine();
        }while (!Validator.isValidatorID(soDienThoai,Validator.SDT_REGET));
        List<MucDanhBa> listDoc = new ArrayList<>();
        listDoc = ReadWriteFile.readFile(ReadWriteFile.path1);
        for (int i = 0; i <listDoc.size() ; i++)  {
            if ((listDoc.get(i).getSoDienThoai()).equals(soDienThoai)){
              listDoc.remove(listDoc.get(i));
                System.out.println("Đã Xóa mục danh mục thành công!");
            }
        }
        System.out.println(listDoc);
        ReadWriteFile.writeFileReset(ReadWriteFile.path1);
        ReadWriteFile.writeFile(listDoc,ReadWriteFile.path1,true);
    }

    private static void timKiemDanhBa() {
        String soDienThoaiorTen;
            System.out.println("Nhập số điện thoại hoặc tên cần tìm:");
        soDienThoaiorTen = scanner.nextLine();
        List<MucDanhBa> listDoc = new ArrayList<>();
        System.out.println(listDoc);
        for (MucDanhBa mucDanhBa:listDoc) {
           if (mucDanhBa.getSoDienThoai().equals(soDienThoaiorTen)){
               System.out.println(mucDanhBa.showInfor());
           }
        }
    }

    private static void docFile() {
        List<MucDanhBa> listdoc = new ArrayList<>();
        listdoc= ReadWriteFile.readFile(ReadWriteFile.path1);
        System.out.println(listdoc);
    }

    private static void ghiFile() {
        ReadWriteFile.writeFile(listDanhBaFileGhi, ReadWriteFile.path1, true);
    }
}
