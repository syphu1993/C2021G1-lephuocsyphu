package customer.controller;

import customer.model.bean.Customer;
import customer.model.service.ICustomer;
import customer.model.service.impl.CustomerImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CustomerServlet",urlPatterns = {"/customer"})
public class CustomerServlet extends HttpServlet {
    ICustomer customerServlet = new CustomerImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "search":
                search(request, response);
                break;
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String nameFind = request.getParameter("nameFind");
        List<Customer> customers = customerServlet.findByName(nameFind);
        request.setAttribute("customers",customers);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("furama_management/customer/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        customerServlet.delete(id);
        List<Customer> newList = customerServlet.findAll();
        request.setAttribute("customers",newList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("furama_management/customer/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        int  id = Integer.parseInt(request.getParameter("id"));
        String typeOfCustomer = request.getParameter("typeOfCustomer");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String code = request.getParameter("code");
        Customer customer = new Customer(id,typeOfCustomer,name,birthday,gender,idCard,phone,email,address,code);
        boolean check = customerServlet.update(customer);
        if (check) {
            request.setAttribute("message", "A customer was updated");

        } else {
            request.setAttribute("message", "Update fail!");
        }
        List<String> listType = customerServlet.findAllTypeCustomer();
        String[] listGender = {"Male","Female"};
        request.setAttribute("customer", customer);
        request.setAttribute("listType",listType);
        request.setAttribute("listGender", listGender);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("furama_management/customer/update.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        try {
            String typeOfCustomer = request.getParameter("typeOfCustomer");
            String name = request.getParameter("name");
            String birthday = request.getParameter("birthday");
//            Date date1=new SimpleDateFormat("MM/dd/yyyy").parse(birthday);
//            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
//            String strDate = dateFormat.format(date1);
            String gender = request.getParameter("gender");
            String idCard = request.getParameter("idCard");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String code = request.getParameter("code");
            Customer newCustomer = new Customer(typeOfCustomer, name,birthday, gender,idCard,phone,email,address,code);
            Map<String,String> mapMesg = customerServlet.save(newCustomer);
            List<String> listType = customerServlet.findAllTypeCustomer();
            if (mapMesg.isEmpty()){
                request.setAttribute("listType",listType);
                request.setAttribute("message", "A new customer was created!");
            }else {
                request.setAttribute("codeMesg",mapMesg.get("CodeCustomer"));
                request.setAttribute("phoneMesg",mapMesg.get("phone"));
                request.setAttribute("cardMesg",mapMesg.get("card"));
                request.setAttribute("emailMesg",mapMesg.get("email"));
                request.setAttribute("listType",listType);
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("furama_management/customer/create.jsp");
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
            case "edit":
                showEditForm(request, response);
                break;
            default:
                showAll(request, response);
                break;
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerServlet.findById(id);
        List<String> listType = customerServlet.findAllTypeCustomer();
        String[] listGender = {"Male","Female"};
        RequestDispatcher requestDispatcher;
        requestDispatcher = request.getRequestDispatcher("furama_management/customer/update.jsp");
        request.setAttribute("customer", customer);
        request.setAttribute("listGender", listGender);
        request.setAttribute("listType", listType);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
        List<String> listType = customerServlet.findAllTypeCustomer();
        request.setAttribute("listType",listType);
        RequestDispatcher requestDispatcher;
        requestDispatcher = request.getRequestDispatcher("furama_management/customer/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAll(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customers = customerServlet.findAll();
        request.setAttribute("customers", customers);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("furama_management/customer/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
