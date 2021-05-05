package Models;

public class Room extends Services {
    private FreeServies freeServices;

    public Room() {
    }

    public Room(String id, String nameServices, double areaUser, double rentFee, int numberOfPeople, String typeRent, FreeServies freeServices) {
        super(id, nameServices, areaUser, rentFee, numberOfPeople, typeRent);
        this.freeServices = freeServices;
    }

    @Override
    public String toString() {
        return "Room{" +
                "freeServices=" + freeServices +
                '}'+super.toString();
    }

    @Override
    public void showInfor() {
        System.out.println(this.toString());
    }

    public FreeServies getFreeServices() {
        return freeServices;
    }

    public void setFreeServices(FreeServies freeServices) {
        this.freeServices = freeServices;
    }
}
