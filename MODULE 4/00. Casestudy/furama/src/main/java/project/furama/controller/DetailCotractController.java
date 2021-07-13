package project.furama.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import project.furama.model.AttachService;
import project.furama.model.Contract;
import project.furama.model.DetailContract;
import project.furama.service.IAttachService;
import project.furama.service.IContractService;
import project.furama.service.IDetailContracService;

@Controller
public class DetailCotractController {
    @Autowired
    IDetailContracService detailContracService;
    @Autowired
    IAttachService attachService;
    @Autowired
    IContractService contractService;

    @ModelAttribute("attachServices")
    public Iterable<AttachService> showAttachServices(){
        return attachService.findAll();
    }
    @ModelAttribute("contracts")
    public Iterable<Contract> showContracts(){
        return contractService.findAll();
    }

    @GetMapping(value = "/create-detail-contract/{id}")
    public String showNewForamCreateDetailContract(@PathVariable Integer id, Model model){
        model.addAttribute("detailContract",new DetailContract());
        Integer idContrac = id;
        model.addAttribute("idContract",id);
        return "contract/create_detail_contract";
    }
    @PostMapping(value = "/create-detail-contract")
    public String createDetailContract(@ModelAttribute DetailContract detailContract,Model model){
        detailContract.setFlag(1);
        this.detailContracService.save(detailContract);
        model.addAttribute("message","A detail contract was created!");
        return "contract/create_detail_contract";
    }
}
