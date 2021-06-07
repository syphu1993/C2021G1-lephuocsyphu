package contract.model.bean;

public class ContractUseAttachService {
    private int id;
    private int idCustomer;
    private String nameCustomer;
    private String nameService;
    private String nameAttachService;

    public ContractUseAttachService() {
    }

    public ContractUseAttachService(int id, int idCustomer, String nameCustomer, String nameService, String nameAttachService) {
        this.id = id;
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.nameService = nameService;
        this.nameAttachService = nameAttachService;
    }

    public ContractUseAttachService(int idCustomer, String nameCustomer, String nameService, String nameAttachService) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.nameService = nameService;
        this.nameAttachService = nameAttachService;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getNameAttachService() {
        return nameAttachService;
    }

    public void setNameAttachService(String nameAttachService) {
        this.nameAttachService = nameAttachService;
    }

    @Override
    public String toString() {
        return "ContractUseAttachService{" +
                "id=" + id +
                ", idCustomer=" + idCustomer +
                ", nameCustomer='" + nameCustomer + '\'' +
                ", nameService='" + nameService + '\'' +
                ", nameAttachService='" + nameAttachService + '\'' +
                '}';
    }
}
