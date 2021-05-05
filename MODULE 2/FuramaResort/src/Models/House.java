package Models;
//-	Riêng House sẽ có thêm thông tin: Tiêu chuẩn phòng, Mô tả tiện nghi khác, Số tầng.
public class House extends Services {
    private String standardRoom;
    private String otherDescription;
    private int  numberOfFloor;

    public House() {
    }

    public House(String id, String nameServices, double areaUser, double rentFee, int numberOfPeople, String typeRent, String standardRoom, String otherDescription, int numberOfFloor) {
        super(id, nameServices, areaUser, rentFee, numberOfPeople, typeRent);
        this.standardRoom = standardRoom;
        this.otherDescription = otherDescription;
        this.numberOfFloor = numberOfFloor;
    }

    @Override
    public String toString() {
        return "House{" +
                "standardRoom='" + standardRoom + '\'' +
                ", otherDescription='" + otherDescription + '\'' +
                ", numberOfFloor=" + numberOfFloor +
                '}'+super.toString();
    }

    @Override
    public void showInfor() {
        System.out.println(this.toString());
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getOtherDescription() {
        return otherDescription;
    }

    public void setOtherDescription(String otherDescription) {
        this.otherDescription = otherDescription;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }
}
