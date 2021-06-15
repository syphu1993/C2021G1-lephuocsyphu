package mamagement_student.controller;

import mamagement_student.model.bean.Student;
import mamagement_student.model.service.IStudent;
import mamagement_student.model.service.impl.StudentImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "StudentServlet", urlPatterns = {"/student"})
public class StudentServlet extends HttpServlet {
    IStudent studentServlet = new StudentImpl();
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
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        studentServlet.delete(id);
        List<Student> newList = studentServlet.findAll();
        request.setAttribute("students",newList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("management_student/student/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        int id  = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthday= request.getParameter("birthday");
        Student student = new Student(id,name,birthday);
        Map<String,String> mapMesg = studentServlet.update(student);
        if (mapMesg.isEmpty()){
            request.setAttribute("message","A student was updated.");
        } else {
            request.setAttribute("nameMesg",mapMesg.get("name"));
            request.setAttribute("birthMesg",mapMesg.get("year"));
        }
        request.setAttribute("student",student);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("management_student/student/update.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String birthday= request.getParameter("birthday");
        Student student = new Student(name,birthday);
        Map<String,String> mapMesg= studentServlet.save(student);
        if (mapMesg.isEmpty()){
            if (student!=null){
                request.setAttribute("message","A student was created.");
            }
        }else {
            request.setAttribute("nameMesg",mapMesg.get("name"));
            request.setAttribute("birthMesg",mapMesg.get("year"));
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("management_student/student/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
        List<Student> students = studentServlet.findAll();
        request.setAttribute("students",students);
        RequestDispatcher requestDispatcher;
        requestDispatcher = request.getRequestDispatcher("management_student/student/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentServlet.findById(id);
        request.setAttribute("student",student);
        RequestDispatcher requestDispatcher;
        requestDispatcher = request.getRequestDispatcher("management_student/student/update.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher;
        requestDispatcher = request.getRequestDispatcher("management_student/student/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
