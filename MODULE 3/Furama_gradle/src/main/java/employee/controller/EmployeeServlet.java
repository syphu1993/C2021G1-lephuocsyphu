package employee.controller;

import employee.model.bean.Employee;
import employee.model.service.IEmployee;
import employee.model.service.impl.EmployeeImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = {"/employee"})
public class EmployeeServlet extends HttpServlet {
    IEmployee employeeServlet = new EmployeeImpl();
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
        String  nameFind = request.getParameter("nameFind");
        List<Employee> listSearch = employeeServlet.findByName(nameFind);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("furama_management/employee/list.jsp");
        request.setAttribute("employees",listSearch);
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
        employeeServlet.delete(id);
        List<Employee> newList = employeeServlet.findAll();
        request.setAttribute("employees",newList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("furama_management/employee/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String  name = request.getParameter("name");
        String  birthday = request.getParameter("birthday");
        String  idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String  phone = request.getParameter("phone");
        String  email = request.getParameter("email");
        String  address = request.getParameter("address");
        String  position = request.getParameter("position");
        String  degree = request.getParameter("degree");
        String  division = request.getParameter("division");
        String  user = request.getParameter("user");
        Employee employee = new Employee(id,name,birthday,idCard,salary,phone,email,address,position,degree,division,user);
        boolean check = employeeServlet.update(employee);
        if (check) {
            request.setAttribute("message", "A employee was updated");

        } else {
            request.setAttribute("message", "Update fail!");
        }
        request.setAttribute("employee", employee);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("furama_management/employee/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String position = request.getParameter("position");
        String degree = request.getParameter("degree");
        String division = request.getParameter("division");
        String user = request.getParameter("user");
        Employee employee = new Employee(name,birthday,idCard,salary,phone,email,address,position,degree,division,user);
        try {
            employeeServlet.save(employee);
            List<String> listPosition = employeeServlet.findNamePosition();
            List<String> listDegree = employeeServlet.findNameDegree();
            List<String> listDivision = employeeServlet.findNameDivision();
            request.setAttribute("listPosition",listPosition);
            request.setAttribute("listDegree",listDegree);
            request.setAttribute("listDivision",listDivision);
            request.setAttribute("message", "A new employee was created!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("furama_management/employee/create.jsp");
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

    private void showAll(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employees = employeeServlet.findAll();
        request.setAttribute("employees", employees);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("furama_management/employee/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id =Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeServlet.findById(id);
        List<String> positions = employeeServlet.findNamePosition();
        List<String> degrees = employeeServlet.findNameDegree();
        List<String> divisions = employeeServlet.findNameDivision();
        RequestDispatcher requestDispatcher;
        requestDispatcher = request.getRequestDispatcher("furama_management/employee/update.jsp");
        request.setAttribute("employee",employee);
        request.setAttribute("positions",positions);
        request.setAttribute("degrees",degrees);
        request.setAttribute("divisions",divisions);
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
        List<String> listPosition = employeeServlet.findNamePosition();
        List<String> listDegree = employeeServlet.findNameDegree();
        List<String> listDivision = employeeServlet.findNameDivision();
        RequestDispatcher requestDispatcher;
        requestDispatcher = request.getRequestDispatcher("furama_management/employee/create.jsp");
        request.setAttribute("listPosition",listPosition);
        request.setAttribute("listDegree",listDegree);
        request.setAttribute("listDivision",listDivision);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
