package Controllers;

import Commons.ConverUtils;
import Commons.FileUtils;
import Commons.StringUtils;
import Commons.Validator;
import Exeption.*;
import Models.*;

import java.util.*;

public class MainController {
    public static void main(String[] args) {
        displayMainMenu();
    }

    private static Scanner scanner = new Scanner(System.in);
    private static boolean isExit;
    private static boolean isBackToMenu;
    private static String VILLA = "Villa";
    private static String HOUSE = "House";
    private static String ROOM = "Room";
    private static String CUSTOMER = "customer";

    public static void displayMainMenu() {
        int choose = 0;
        do {
            System.out.println("1. Add New Services");
            System.out.println("2. Show Services");
            System.out.println("3. Add New Customer");
            System.out.println("4. Show Information of Customer");
            System.out.println("5. Add New Booking");
            System.out.println("6. Show Information of Employee");
            System.out.println("7. Exit");
            System.out.println("Choose 1-6, please!!");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    addNewServies();
                    break;
                case 2:
                    showServices();
                    break;
                case 3:
                    addNewCustomer(CUSTOMER);
                    break;
                case 4:
                    showInformationCustomer(CUSTOMER);
                    break;
                case 5:
                    addNewBooking();
                    break;
                case 6:
                    showInformationEmployee();
                    break;
                case 7:
                    isExit = true;
            }
            if (isExit) {
                break;
            }
        } while (choose >= 1 && choose <= 7);
    }

    private static void showInformationEmployee() {
    }

    private static void addNewBooking() {
    }

    private static void showInformationCustomer(String fileName) {
        System.out.println("----------------------");
        System.out.println("View list Customer:");
        for (Customer x : readInforCustomer(fileName)) {
            x.showInfor();
        }
    }

    private static List<Customer> readInforCustomer(String fileName) {
        FileUtils.setFullPath(fileName);
        List<String> propertiesCustomer = FileUtils.readFile();
        List<Customer> listCustomer = new ArrayList<>();
        String[] propertiesElement = null;
        Customer customer = null;
        for (String properties : propertiesCustomer) {
            propertiesElement = properties.split(StringUtils.COMMA);
            customer = new Customer();
            customer.setNameCustomer(propertiesElement[0]);
            customer.setBirthdayCustomer(propertiesElement[1]);
            customer.setGenderCustomer(propertiesElement[2]);
            customer.setCnmdCustomer(propertiesElement[3]);
            customer.setNumberPhoneCustomer(propertiesElement[4]);
            customer.setEmailCustomer(propertiesElement[5]);
            customer.setTypeCustomer(propertiesElement[6]);
            customer.setAdressCustomer(propertiesElement[7]);
            listCustomer.add(customer);
        }
        return listCustomer;
    }

    private static void addNewCustomer(String nameFile) {
        boolean check;
        String nameCustomer = null;
        do {
            check=true;
            System.out.println("Input name customer:");
            nameCustomer = scanner.nextLine();
            try {
                Validator.isValiNameCustomer(nameCustomer);
            } catch (NameException e) {
                check=false;
                e.printStackTrace();
            }
        }while (!check);

        String birthdayCustomer = null;
        do {
            check=true;
            System.out.println("Input birthday customer:");
            birthdayCustomer = scanner.nextLine();
            try {
                Validator.isBirthDayCustomer(birthdayCustomer);
            } catch (BirthdayException e) {
                check=false;
                e.printStackTrace();
            }
        }while (!check);

        String genderCustomer = null;
        do {
            check = true;
            System.out.println("Input genger customer:");
            genderCustomer = scanner.nextLine();
            genderCustomer = ConverUtils.nomallizeString(genderCustomer);
            try {
                Validator.isValiGender(genderCustomer);
            } catch (GenderException e) {
                check = false;
                e.printStackTrace();
            }
        }while (!check);

        String cmndCustomer = null;
        do {
            check = true;
            System.out.println("Input cmnd customer:");
            cmndCustomer = scanner.nextLine();
            try {
                Validator.isIdCardCustomer(cmndCustomer);
            } catch (IdCardException e) {
                check=false;
                e.printStackTrace();
            }
        }while (!check);

        String numberPhoneCustomer = null;
        System.out.println("Input number phone customer:");
        numberPhoneCustomer = scanner.nextLine();

        String emailCustomer = null;
        do {
            check = true;
            System.out.println("Input email customer:");
            emailCustomer = scanner.nextLine();
            try {
                Validator.isValiEmailCustomer(emailCustomer);
            } catch (EmailException e) {
                check = false;
                e.printStackTrace();
            }
        }while (!check);

        String typeCustomer = null;
        System.out.println("Input type of customer:");
        typeCustomer = scanner.nextLine();

        String addressCustomer = null;
        System.out.println("Input address of customer:");
        addressCustomer = scanner.nextLine();
        FileUtils.setFullPath(nameFile);
        FileUtils.writeFile(new String[]{nameCustomer, birthdayCustomer, genderCustomer, cmndCustomer, numberPhoneCustomer, emailCustomer,
                typeCustomer, addressCustomer});
    }

    private static void showServices() {
        int choose = 0;
        do {
            System.out.println("1.\tShow all Villa\n" +
                    "2.\tShow all House\n" +
                    "3.\tShow all Room\n" +
                    "4.\tShow All Name Villa Not Duplicate\n" +
                    "5.\tShow All Name House Not Duplicate\n" +
                    "6.\tShow All Name Room Not Duplicate\n" +
                    "7.\tBack to menu\n" +
                    "8.\tExit\n");
            System.out.println("choose 1-8,please!!");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    showAllServices(VILLA);
                    isBackToMenu = false;
                    break;
                case 2:
                    showAllServices(HOUSE);
                    isBackToMenu = false;
                    break;
                case 3:
                    showAllServices(ROOM);
                    isBackToMenu = false;
                    break;
                case 4:
                    ShowAllNotDum(VILLA);
                    isBackToMenu = true;
                    break;
                case 5:
                    ShowAllNotDum(HOUSE);
                    isBackToMenu = true;
                    break;
                case 6:
                    ShowAllNotDum(ROOM);
                    isBackToMenu = true;
                    break;
                case 7:
                    isBackToMenu = true;
                    break;
                case 8:
                    isExit = true;
                    break;
            }
            if (isBackToMenu || isExit) {
                return;
            }
        } while (choose >= 1 && choose <= 8);
    }

    private static void ShowAllNotDum(String fileName) {
        Set<String> listSetService = new TreeSet<>();
        System.out.println("-----------------------------------");
        System.out.println("Result list Set Service:");
        for (Services service : readAllServicies(fileName)) {
            listSetService.add(service.getNameServices());
        }
        System.out.println(listSetService);
    }

    private static List<Services> readAllServicies(String fileName) {
        FileUtils.setFullPath(fileName);
        List<String> propertiesServie = FileUtils.readFile();
        List<Services> listOfService = new ArrayList<>();
        String[] propertiesElement = null;
        Services services = null;
        for (String properties : propertiesServie) {
            propertiesElement = properties.split(StringUtils.COMMA);
            if (fileName.equals(VILLA)) {
                services = new Villa();
                ((Villa) services).setStandardRoom(propertiesElement[6]);
                ((Villa) services).setOtherDescription(propertiesElement[7]);
                ((Villa) services).setAreaPool(Double.parseDouble(propertiesElement[8]));
                ((Villa) services).setNumberOfFloor(Integer.parseInt(propertiesElement[9]));
            } else if (fileName.equals(HOUSE)) {
                services = new House();
                ((House) services).setStandardRoom(propertiesElement[6]);
                ((House) services).setOtherDescription(propertiesElement[7]);
                ((House) services).setNumberOfFloor(Integer.parseInt(propertiesElement[8]));
            } else if (fileName.equals(ROOM)) {
                FreeServies freeServies = new FreeServies(propertiesElement[6], propertiesElement[7], Double.parseDouble(propertiesElement[8]));
                services = new Room();
                ((Room) services).setFreeServices(freeServies);
            }
            services.setId(propertiesElement[0]);
            services.setNameServices(propertiesElement[1]);
            services.setAreaUser(Double.parseDouble(propertiesElement[2]));
            services.setRentFee(Double.parseDouble(propertiesElement[3]));
            services.setNumberOfPeople(Integer.parseInt(propertiesElement[4]));
            services.setTypeRent(propertiesElement[5]);
            listOfService.add(services);
        }
        return listOfService;
    }

    private static void showAllServices(String fileName) {
        System.out.println("-----------------------------------");
        System.out.println("Result Read file:");
        for (Services service : readAllServicies(fileName)) {
            service.showInfor();
        }
    }

    private static void addNewServies() {
        int choose = 0;
        do {
            System.out.println("1.\tAdd New Villa\n" +
                    "2.\tAdd New House\n" +
                    "3.\tAdd New Room\n" +
                    "4.\tBack to menu\n" +
                    "5.\tExit\n");
            System.out.println("choose 1-5, please!!");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    addNewServie(VILLA);
                    break;
                case 2:
                    addNewServie(HOUSE);
                    break;
                case 3:
                    addNewServie(ROOM);
                    break;
                case 4:
                    isBackToMenu = true;
                    break;
                case 5:
                    isExit = true;
                    break;
            }
            if (isExit || isBackToMenu) {
                return;
            }
        } while (choose >= 1 && choose <= 5);
    }

    private static void addNewServie(String fileName) {
        String id = null;
        do {
            System.out.println("Input id:");
            id = scanner.nextLine();
        } while (!Validator.isValidator(id, Validator.SERVICE_CODE_REGEX));

        String nameServices = null;
        do {
            System.out.println("Input name Services:");
            nameServices = scanner.nextLine();
        } while (!Validator.isValidator(nameServices, Validator.SERVICE_NAME_REGEX));

        double areaUser = 0;
        do {
            try {
                System.out.println("Input area User:");
                areaUser = Double.parseDouble(scanner.nextLine());
            } catch (Exception o) {
                o.getMessage();
            }
        } while (!Validator.isThanMore(areaUser, 30));

        double rentFee = 0;
        do {
            System.out.println("Input rent Fee:");
            rentFee = Double.parseDouble(scanner.nextLine());
        } while (!Validator.isThanMore(rentFee, 0));

        int numberOfPeople = 0;
        do {
            try {
                System.out.println("Input number Of People:");
                numberOfPeople = Integer.parseInt(scanner.nextLine());
            } catch (Exception o) {
                o.getMessage();
            }

        } while (!Validator.isThanMore(numberOfPeople, 0, 20));

        String typeRent = null;
        do {
            System.out.println("Input type Rent:");
            typeRent = scanner.nextLine();
        } while (!Validator.isValidator(typeRent, Validator.SERVICE_NAME_REGEX));

        if (fileName.equals(VILLA)) {
            String standardRoom = null;
            do {
                System.out.println("Input standard Room:");
                standardRoom = scanner.nextLine();
            } while (!Validator.isValidator(standardRoom, Validator.SERVICE_NAME_REGEX));
            System.out.println("Input other Description:");
            String otherDescription = scanner.nextLine();

            double areaPool = 0;
            do {
                System.out.println("Input area Pool:");
                areaPool = Double.parseDouble(scanner.nextLine());
            } while (!Validator.isThanMore(areaPool, 30));

            int numberOfFloor = 0;
            do {
                System.out.println("Input number Of Floor:");
                numberOfFloor = Integer.parseInt(scanner.nextLine());
            } while (!Validator.isThanMore(numberOfFloor, 0));

            FileUtils.setFullPath(fileName);
            FileUtils.writeFile(new String[]{id, nameServices, String.valueOf(areaUser), String.valueOf(rentFee), String.valueOf(numberOfPeople),
                    typeRent, standardRoom, otherDescription, String.valueOf(areaPool), String.valueOf(numberOfFloor)});
        } else if (fileName.equals(HOUSE)) {
            String standardRoom = null;
            do {
                System.out.println("Input standard Room:");
                standardRoom = scanner.nextLine();
            } while (!Validator.isValidator(standardRoom, Validator.SERVICE_NAME_REGEX));
            System.out.println("Input other Description:");
            String otherDescription = scanner.nextLine();

            int numberOfFloor = 0;
            do {
                System.out.println("Input number Of Floor:");
                numberOfFloor = Integer.parseInt(scanner.nextLine());
            } while (!Validator.isThanMore(numberOfFloor, 0));

            FileUtils.setFullPath(fileName);
            FileUtils.writeFile(new String[]{id, nameServices, String.valueOf(areaUser), String.valueOf(rentFee), String.valueOf(numberOfPeople),
                    typeRent, standardRoom, otherDescription, String.valueOf(numberOfFloor)});
        } else if (fileName.equals(ROOM)) {
            String freeServiesName = null;
            do {
                System.out.println("Input free Servies  Name:");
                freeServiesName = scanner.nextLine();
            } while (!Validator.isValiExtraService(freeServiesName));

            System.out.println("Input unit:");
            String unit = scanner.nextLine();
            System.out.println("Input money:");
            double money = Double.parseDouble(scanner.nextLine());

            FileUtils.setFullPath(fileName);
            FileUtils.writeFile(new String[]{id, nameServices, String.valueOf(areaUser), String.valueOf(rentFee), String.valueOf(numberOfPeople),
                    typeRent, freeServiesName, unit, String.valueOf(money)});
        }
    }
}
