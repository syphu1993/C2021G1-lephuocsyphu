package service.controller;

import service.model.bean.Service;
import service.model.services.IService;
import service.model.services.impl.ServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = {"/service"})
public class ServiceServlet extends HttpServlet {
    IService serviceServlet = new ServiceImpl();
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
                update(request, response);
                break;
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        int area  = Integer.parseInt(request.getParameter("area"));
        double  cost = Double.parseDouble(request.getParameter("cost"));
        int maxPeople  = Integer.parseInt(request.getParameter("maxPeople"));
        String rentType =request.getParameter("rentType");
        String  serviceType = request.getParameter("serviceType");
        String standard =request.getParameter("standard");
        String decription =request.getParameter("decription");
        double  pool = Double.parseDouble(request.getParameter("pool"));
        int floor  = Integer.parseInt(request.getParameter("floor"));
        Service service = new Service(name,area,cost,maxPeople,rentType,serviceType,standard,decription,pool,floor);
        boolean check =serviceServlet.update(service);
        if (check) {
            request.setAttribute("message","A service was updated");

        } else {
            request.setAttribute("message", "Update fail!");
        }
        try {

            RequestDispatcher dispatcher = request.getRequestDispatcher("furama_management/service/create.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException s){
            s.getMessage();
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name =request.getParameter("name");
        int area  = Integer.parseInt(request.getParameter("area"));
        double  cost = Double.parseDouble(request.getParameter("cost"));
        int maxPeople  = Integer.parseInt(request.getParameter("maxPeople"));
        String rentType =request.getParameter("rentType");
        String  serviceType = request.getParameter("serviceType");
        String standard =request.getParameter("standard");
        String decription =request.getParameter("decription");
        double  pool = Double.parseDouble(request.getParameter("pool"));
        int floor  = Integer.parseInt(request.getParameter("floor"));
        Service service = new Service(id,name,area,cost,maxPeople,rentType,serviceType,standard,decription,pool,floor);
        try {
            serviceServlet.save(service);
            List<String[]> rents = serviceServlet.findNameRentType();
            List<String[]> types = serviceServlet.findNameServiceType();
            request.setAttribute("rents",rents);
            request.setAttribute("types",types);
            request.setAttribute("message", "A new service was created!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("furama_management/service/create.jsp");
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
        String name = request.getParameter("name");
        Service service = serviceServlet.finByName(name);
        List<String[]> rents = serviceServlet.findNameRentType();
        List<String[]> types = serviceServlet.findNameServiceType();
        request.setAttribute("service",service);
        request.setAttribute("rents",rents);
        request.setAttribute("types",types);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("furama_management/service/update.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showAll(HttpServletRequest request, HttpServletResponse response) {
        List<Service> services  = serviceServlet.findAll();
        request.setAttribute("services", services);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("furama_management/service/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
        List<String[]> rents = serviceServlet.findNameRentType();
        List<String[]> types = serviceServlet.findNameServiceType();
        request.setAttribute("rents",rents);
        request.setAttribute("types",types);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("furama_management/service/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
