package contract.model.bean;

public class ContractDetail {
    private int id;
    private  int mainContractId;
    private  int attachServiceId;
    private int quantity;

    public ContractDetail() {
    }

    public ContractDetail(int id, int mainContractId, int attachServiceId, int quantity) {
        this.id = id;
        this.mainContractId = mainContractId;
        this.attachServiceId = attachServiceId;
        this.quantity = quantity;
    }

    public ContractDetail(int mainContractId, int attachServiceId, int quantity) {
        this.mainContractId = mainContractId;
        this.attachServiceId = attachServiceId;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMainContractId() {
        return mainContractId;
    }

    public void setMainContractId(int mainContractId) {
        this.mainContractId = mainContractId;
    }

    public int getAttachServiceId() {
        return attachServiceId;
    }

    public void setAttachServiceId(int attachServiceId) {
        this.attachServiceId = attachServiceId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ContractDetail{" +
                "id=" + id +
                ", mainContractId=" + mainContractId +
                ", attachServiceId=" + attachServiceId +
                ", quantity=" + quantity +
                '}';
    }
}
