package contract.controller;

import contract.model.bean.Contract;
import contract.model.bean.ContractDetail;
import contract.model.bean.ContractUseAttachService;
import contract.model.service.IContract;
import contract.model.service.Impl.ContractImpl;
import customer.model.bean.Customer;
import employee.model.bean.Employee;
import service.model.bean.Service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "ContractServlet", urlPatterns = {"/contract","/contract_detail"})
public class ContractServlet extends HttpServlet {
    IContract contractServlet = new ContractImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request, response);
                break;
            case "createCD":
                createAttachContract(request, response);
                break;
        }
    }

    private void createAttachContract(HttpServletRequest request, HttpServletResponse response) {
        int mainContractId = Integer.parseInt(request.getParameter("idContract"));
        int attachServiceId = Integer.parseInt(request.getParameter("aContract"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        ContractDetail contractDetail = new ContractDetail(mainContractId,attachServiceId,quantity);
        try {
            contractServlet.creatContractDetail(contractDetail);
            request.setAttribute("message", "A new contract detail was created!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("furama_management/contract_detail/create.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException s){
            s.getMessage();
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
       String startDate = request.getParameter("startDate");
       String endDate = request.getParameter("endDate");
       double deposit = Double.parseDouble(request.getParameter("deposit"));
       double total = Double.parseDouble(request.getParameter("total"));
       int employeeId = Integer.parseInt(request.getParameter("employeeId"));
       int customerId = Integer.parseInt(request.getParameter("customerId"));
       int serviceId = Integer.parseInt(request.getParameter("serviceId"));
       Contract contract = new Contract(startDate,endDate,deposit,total,employeeId,customerId,serviceId);
        try {
            contractServlet.save(contract);
            request.setAttribute("message", "A new contract was created!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("furama_management/contract/create.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException s){
            s.getMessage();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showNewForm(request, response);
                break;
            case "createCD":
                showNewFormCD(request, response);
                break;
            case "user":
                showCustomerUseService(request, response);
                break;
            default:
                showAll(request, response);
                break;
        }
    }

    private void showCustomerUseService(HttpServletRequest request, HttpServletResponse response) {
        List<ContractUseAttachService> contractUseAttachServices = contractServlet.findAllCustomerUseService();
        request.setAttribute("contracts", contractUseAttachServices);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("furama_management/customer_use/list_user.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showNewFormCD(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Contract contract = contractServlet.findContractByID(id);
        List<String[]> attachServices = contractServlet.findAttachService();
        request.setAttribute("contract",contract);
        request.setAttribute("aContracts",attachServices);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("furama_management/contract_detail/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employees = contractServlet.findEmployee();
        List<Customer> customers = contractServlet.findCustomer();
        List<Service> services = contractServlet.findService();
        request.setAttribute("employees",employees);
        request.setAttribute("customers",customers);
        request.setAttribute("services",services);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("furama_management/contract/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAll(HttpServletRequest request, HttpServletResponse response) {
        List<Contract> contracts = contractServlet.findAll();
        request.setAttribute("contracts", contracts);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("furama_management/contract/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
