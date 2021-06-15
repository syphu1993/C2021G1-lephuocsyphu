package management.product.controller;

import management.product.model.bean.Product;
import management.product.model.service.impl.IProduct;
import management.product.model.service.impl.ProductImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet" , urlPatterns = {"/product"})
public class ProductServlet extends HttpServlet {
    IProduct productServlet = new ProductImpl();
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
                deleteP(request, response);
                break;
            case "search":
                search(request, response);
                break;
        }
    }

    private void deleteP(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        productServlet.delete(id);
        List<Product> newList = productServlet.findAll();
        request.setAttribute("products",newList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("management/product/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String nameFind = request.getParameter("nameFind");
        List<Product> products = productServlet.findByName(nameFind);
        request.setAttribute("products",products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("management/product/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quan = Integer.parseInt(request.getParameter("quan"));
        String collor = request.getParameter("collor");
        String decrip = request.getParameter("decrip");
        String cate = request.getParameter("cate");
        Product product = new Product(name,price,quan,collor,decrip,cate);
        try {
//            serviceServlet.save(service);
            productServlet.save(product);
            List<String> cates = productServlet.findCate();
            request.setAttribute("cates",cates);
            request.setAttribute("message", "A new Product was created!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("management/product/create.jsp");
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
        List<Product> products = productServlet.findAll();
        request.setAttribute("products",products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("management/product/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
         List<String > cates = productServlet.findCate();
         request.setAttribute("cates",cates);
        RequestDispatcher requestDispatcher;
        requestDispatcher = request.getRequestDispatcher("management/product/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
