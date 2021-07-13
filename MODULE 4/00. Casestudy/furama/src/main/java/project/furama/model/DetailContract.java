package project.furama.model;

import javax.persistence.*;

@Entity
@Table(name = "detail_contracts")
public class DetailContract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int quantity;
    private int flag;
    @ManyToOne
    @JoinColumn(name = "contract_id",referencedColumnName ="id" )
    private Contract contract;
    @ManyToOne
    @JoinColumn(name = "attach_service_id",referencedColumnName ="id" )
    private AttachService attachService;

    public DetailContract() {
    }

    public DetailContract(int quantity, Contract contract, AttachService attachService) {
        this.quantity = quantity;
        this.contract = contract;
        this.attachService = attachService;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }
}
