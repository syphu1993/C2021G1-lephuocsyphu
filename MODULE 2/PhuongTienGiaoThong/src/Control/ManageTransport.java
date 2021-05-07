package Control;

import Common.FileUtils;
import Common.Validator;
import Exeption.ExceptionCodeTransport;
import Model.Car;
import Model.Moto;
import Model.Transport;
import Model.Truck;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TransferQueue;

public class ManageTransport {
    public static void main(String[] args) {
        displayMainMenu();
    }

    private static Scanner scanner = new Scanner(System.in);
    private static boolean isExit;
    private static boolean isBackMenu;
    private static String truck = "truck";
    private static String car = "car";
    private static String moto = "moto";

    public static void displayMainMenu() {
        String chon = null;
        do {
            System.out.println("1. Thêm mới phương tiện.\n" +
                    "2. Hiện thị phương tiện\n" +
                    "3. Xóa phương tiện\n" +
                    "4. Thoát\n");
            System.out.println("Chon chuc nang: ");
            chon = scanner.nextLine();
            switch (chon) {
                case "1":
                    addNewTransport();
                    break;
                case "2":
                    displayTransport();
                    break;
                case "3":
                    delTransport();
                    break;
                case "4":
                    isExit = true;
                    System.out.println("Kết thúc chọn.");
                    break;
                default:
                    System.out.println("Vui lòng nhập lại:");
                    break;
            }
        } while (!isExit);
    }

    private static void addNewTransport() {
        String chon = null;
        do {
            System.out.println("1. Thêm xe tải,\n" +
                    "2. Thêm ôtô, \n" +
                    "3. Thêm  xe máy, \n" +
                    "4. Quay lại menu, \n" +
                    "5. Thoát.");
            System.out.println("Chon phuong tien:");
            chon = scanner.nextLine();
            switch (chon) {
                case "1":
                    themLoaiPhuongTien(truck);
                    isBackMenu = false;
                    break;
                case "2":
                    themLoaiPhuongTien(car);
                    isBackMenu = false;
                    break;
                case "3":
                    themLoaiPhuongTien(moto);
                    isBackMenu = false;
                    break;
                case "4":
                    isBackMenu = true;
                    break;
                case "5":
                    System.out.println("Kết thúc chọn.");
                    isExit = true;
                    break;
                default:
                    System.out.println("Xin vui lòng nhập lại");
                    break;
            }
            if (isExit || isBackMenu) {
                return;
            }
        } while (true);
    }

    private static void themLoaiPhuongTien(String nameTransport) {
        String bienKiemSoat = null;
        if (nameTransport.equals(truck)) {
            List<Transport> listTruck = readAllTransport(truck);
            do {
                try {
                    System.out.println("Nhập biển kiểm soát xe tai:");
                    bienKiemSoat = scanner.nextLine();
                } catch (Exception o) {
                    o.getMessage();
                }
            } while (!Validator.isValidator(bienKiemSoat, Validator.CODE_TRUCK_REGET) || Validator.isSameCode(listTruck, bienKiemSoat));
        }
        if (nameTransport.equals(car)) {
            List<Transport> listCar = readAllTransport(car);
            do {
                try {
                    System.out.println("Nhập biển kiểm soát oto:");
                    bienKiemSoat = scanner.nextLine();
                } catch (Exception o) {
                    o.getMessage();
                }
            } while (!Validator.isValidator(bienKiemSoat, Validator.CODE_CAR_REGET) || Validator.isSameCode(listCar, bienKiemSoat));
        }
        if (nameTransport.equals(moto)) {
            List<Transport> listMoto = readAllTransport(moto);
            do {
                try {
                    System.out.println("Nhập biển kiểm soát moto:");
                    bienKiemSoat = scanner.nextLine();
                } catch (Exception o) {
                    o.getMessage();
                }
            } while (!Validator.isValidator(bienKiemSoat, Validator.CODE_MOTO_REGET) || Validator.isSameCode(listMoto, bienKiemSoat));
        }


        String tenHangSanXuat = null;
        System.out.println("Nhập tên hảng sản xuất theo danh sách dưới:");
        FileUtils.setFullPath("hangSanXuat");
        List<String> listHangSanXuat = FileUtils.readFile();
        for (int i = 0; i < listHangSanXuat.size(); i++) {
            System.out.println(i + 1);
            System.out.println(listHangSanXuat.get(i));
        }
        int choose = 0;
        choose = Integer.parseInt(scanner.nextLine());
        switch (choose) {
            case 1:
                tenHangSanXuat = listHangSanXuat.get(0).split(",")[1];
                break;
            case 2:
                tenHangSanXuat = listHangSanXuat.get(1).split(",")[1];
                break;
            case 3:
                tenHangSanXuat = listHangSanXuat.get(2).split(",")[1];
                break;
            case 4:
                tenHangSanXuat = listHangSanXuat.get(3).split(",")[1];
                break;
            case 5:
                tenHangSanXuat = listHangSanXuat.get(4).split(",")[1];
                break;
            case 6:
                tenHangSanXuat = listHangSanXuat.get(5).split(",")[1];
                break;
            case 7:
                tenHangSanXuat = listHangSanXuat.get(6).split(",")[1];
                break;
        }

        String chuSoHuu;
        System.out.println("Nhập chủ sở hữu:");
        chuSoHuu = scanner.nextLine();

        if (nameTransport.equals(truck)) {
            double taiTrong;
            System.out.println("Nhập tải trọng:");
            taiTrong = Double.parseDouble(scanner.nextLine());
            FileUtils.setFullPath(nameTransport);
            FileUtils.wirteFile(new String[]{bienKiemSoat, tenHangSanXuat, chuSoHuu, String.valueOf(taiTrong)},true);
        } else if (nameTransport.equals(car)) {
            int soChoNgoi;
            System.out.println("Nhập số chổ ngồi:");
            soChoNgoi = Integer.parseInt(scanner.nextLine());
            String kieuXe = null;
            if (bienKiemSoat.contains("A")) {
                kieuXe = "Du Lịch";
            } else if (bienKiemSoat.contains("B")) {
                kieuXe = "Xe Khách";
            }
            FileUtils.setFullPath(nameTransport);
            FileUtils.wirteFile(new String[]{bienKiemSoat, tenHangSanXuat, chuSoHuu, String.valueOf(soChoNgoi), kieuXe},true);
        } else if (nameTransport.equals(moto)) {
            int congSuat;
            System.out.println("Nhập công suất:");
            congSuat = Integer.parseInt(scanner.nextLine());
            FileUtils.setFullPath(nameTransport);
            FileUtils.wirteFile(new String[]{bienKiemSoat, tenHangSanXuat, chuSoHuu, String.valueOf(congSuat)},true);
        }
    }

    public static List<Transport> readAllTransport(String nameTransport) {
        FileUtils.setFullPath(nameTransport);
        List<String> list = FileUtils.readFile();
        List<Transport> listTransport = new ArrayList<>();
        Transport transport = null;
        for (String content : list) {
            if (nameTransport.equals(truck)) {
                transport = new Truck();
                ((Truck) transport).setTaiTrong(Double.parseDouble(content.split(",")[3]));
            } else if (nameTransport.equals(car)) {
                transport = new Car();
                ((Car) transport).setSoChoNgoi(Integer.parseInt(content.split(",")[3]));
                ((Car) transport).setKieuXe(content.split(",")[4]);
            } else if (nameTransport.equals(moto)) {
                transport = new Moto();
                ((Moto) transport).setCongSuat(Integer.parseInt(content.split(",")[3]));
            }
            transport.setBienKiemSoat(content.split(",")[0]);
            transport.setTenHangSanXuat(content.split(",")[1]);
            transport.setChuSoHuu(content.split(",")[2]);
            listTransport.add(transport);
        }
        return listTransport;
    }

    public static void displayAllTransport(String nameTransport) {
        System.out.println("---------------------------");
        System.out.println("Danh sách " + nameTransport);
        List<Transport> listTransport = readAllTransport(nameTransport);
        for (int i = 0; i < listTransport.size(); i++) {
            System.out.println(i + 1);
            System.out.println(listTransport.get(i).toString());
        }
    }

    private static void displayTransport() {
        String chon = null;
        do {
            System.out.println("1. Xem xe tải,\n" +
                    "2. Xem ôtô, \n" +
                    "3. Xem  xe máy, \n" +
                    "4. Quay lại menu, \n" +
                    "5. Thoát.");
            System.out.println("Chon xem phương tiện:");
            chon = scanner.nextLine();
            switch (chon) {
                case "1":
                    displayAllTransport(truck);
                    isBackMenu = false;
                    break;
                case "2":
                    displayAllTransport(car);
                    isBackMenu = false;
                    break;
                case "3":
                    displayAllTransport(moto);
                    isBackMenu = false;
                    break;
                case "4":
                    isBackMenu = true;
                    break;
                case "5":
                    System.out.println("Kết thúc chọn.");
                    isExit = true;
                    break;
                default:
                    System.out.println("Xin vui lòng nhập lại!");
                    break;
            }
            if (isExit || isBackMenu) {
                return;
            }
        } while (true);
    }


    private static int findCodeTransport(List<Transport> list, String code) {
        int indexCode = -1;
        for (int i = 0; i < list.size(); i++) {
            if (((list.get(i)).getBienKiemSoat()).equals(code)) {
                indexCode = i;
                break;
            }
        }
        return indexCode;
    }

    private static void delTransport() {
        String choose =null;
        do{
            System.out.println("1. Xoa xe tải,\\n\" +\n" +
                    "2. Xoa ôtô, \n" +
                    "3. Xoa  xe máy,\n" +
                    "4. Quay lại menu,\n" +
                    "5. Thoát.");
            System.out.println("Chon xe can xoa: ");
            choose = scanner.nextLine();
            switch (choose){
                case "1":
                    String bienKiemSoatTruck = null;
                    boolean check = true;
                    do{
                        check=true;
                        System.out.println("nhap BKS:");
                        bienKiemSoatTruck = scanner.nextLine();
                        try {
                            Validator.isCodeTruck(bienKiemSoatTruck);
                        } catch (ExceptionCodeTransport exceptionCodeTransport) {
                            check =false;
                            exceptionCodeTransport.printStackTrace();
                        }
                    }while (!check);

                    List<Transport> listTruck = readAllTransport(truck);
                    int indexTruck = findCodeTransport(listTruck, bienKiemSoatTruck);
                    if (indexTruck != -1) {
                        listTruck.remove(listTruck.get(indexTruck));
                        FileUtils.setFullPath(car);
                        FileUtils.wirteFileSpace();
                        for (int i = 0; i < listTruck.size(); i++) {
                            String[] contentAfterDel = new String[4];
                            contentAfterDel[0] = listTruck.get(i).getBienKiemSoat();
                            contentAfterDel[1] = listTruck.get(i).getTenHangSanXuat();
                            contentAfterDel[2] = listTruck.get(i).getChuSoHuu();
                            contentAfterDel[3] = String.valueOf(((Truck) listTruck.get(i)).getTaiTrong());
                            FileUtils.setFullPath(truck);
                            FileUtils.wirteFile(contentAfterDel, true);
                        }
                    }
                    isBackMenu = false;
                    break;
                case "2":
                    String bienKiemSoatCar = null;
                    System.out.println("nhap BKS:");
                    bienKiemSoatCar = scanner.nextLine();
                    List<Transport> listCar = readAllTransport(car);
                    int indexCar = findCodeTransport(listCar, bienKiemSoatCar);
                    if (indexCar != -1) {
                        listCar.remove(listCar.get(indexCar));
                        FileUtils.setFullPath(car);
                        FileUtils.wirteFileSpace();
                        for (int i = 0; i < listCar.size(); i++) {
                            String[] contentAfterDel = new String[5];
                            contentAfterDel[0] = listCar.get(i).getBienKiemSoat();
                            contentAfterDel[1] = listCar.get(i).getTenHangSanXuat();
                            contentAfterDel[2] = listCar.get(i).getChuSoHuu();
                            contentAfterDel[3] = String.valueOf(((Car) listCar.get(i)).getSoChoNgoi());
                            contentAfterDel[4] = ((Car) listCar.get(i)).getKieuXe();
                            FileUtils.setFullPath(car);
                            FileUtils.wirteFile(contentAfterDel,true);
                        }
                    }
                    isBackMenu = false;
                    break;
                case "3":
                    String bienKiemSoatMoto = null;
                    System.out.println("nhap BKS:");
                    bienKiemSoatMoto = scanner.nextLine();
                    List<Transport> listMoto = readAllTransport(moto);
                    int indexMoto = findCodeTransport(listMoto, bienKiemSoatMoto);
                    if (indexMoto != -1) {
                        listMoto.remove(listMoto.get(indexMoto));
                        FileUtils.setFullPath(moto);
                        FileUtils.wirteFileSpace();
                        for (int i = 0; i < listMoto.size(); i++) {
                            String[] contentAfterDel = new String[4];
                            contentAfterDel[0] = listMoto.get(i).getBienKiemSoat();
                            contentAfterDel[1] = listMoto.get(i).getTenHangSanXuat();
                            contentAfterDel[2] = listMoto.get(i).getChuSoHuu();
                            contentAfterDel[3] = String.valueOf(((Moto) listMoto.get(i)).getCongSuat());
                            FileUtils.setFullPath(moto);
                            FileUtils.wirteFile(contentAfterDel,true);
                        }
                    }
                    isBackMenu = false;
                    break;
                case "4":
                    isBackMenu = true;
                    break;
                case "5":
                    isExit = true;
                    break;
                default:
                    System.out.println("xin vui long chon lai!!");
                    isBackMenu = false;
                    break;
            }
            if (isBackMenu||isExit){
                return;
            }
        } while (true);
    }
}
