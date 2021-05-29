package controller;

import model.bean.Product;
import model.service.IProductManager;
import model.service.lmpl.ProductManagerlmpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = {"","/product"})
public class ProductServlet extends HttpServlet {
    IProductManager productManager = new ProductManagerlmpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "add":
                create(request,response);
                break;
            case "edit":
                update(request,response);
                break;
            case "delete":
                delete(request,response);
                break;
            default:
                break;
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Product product = productManager.findById(id);
        RequestDispatcher dispatcher;
        if(product == null){
            dispatcher = request.getRequestDispatcher("/view/error-404.jsp");
        } else {
           productManager.remove(id);
            try {
                response.sendRedirect("/product");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        double price = Double.parseDouble(request.getParameter("price"));
        Product product = new Product(id,name,type,price);
        productManager.add(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/product/create.jsp");
        request.setAttribute("message", "New product was created");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        double price = Double.parseDouble(request.getParameter("price"));
        Product product = productManager.findById(id);
        RequestDispatcher requestDispatcher;
        if (product == null){
            requestDispatcher = request.getRequestDispatcher("/view/error-404.jsp");
        }else {
            product.setName(name);
            product.setType(type);
            product.setPrice(price);
            productManager.update(id, product);
            request.setAttribute("product",product);
            request.setAttribute("message","Finished updating!");
            requestDispatcher =  request.getRequestDispatcher("/view/product/edit.jsp");
        }
        try {
            requestDispatcher.forward(request,response);
        }catch (ServletException s){
            s.printStackTrace();
        } catch (IOException i){
            i.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "add":
                showFormcCreate(request,response);
                break;
            case "edit":
                showFormEdit(request,response);
                break;
            case "delete":
                showFormDel(request,response);
                break;
            case "view":
                showFormView(request,response);
                break;
            case "search":
                showFormSearch(request,response);
                break;
            default:
                showStudentList(request,response);
                break;
        }
    }

    private void showFormSearch(HttpServletRequest request, HttpServletResponse response) {
        String search = request.getParameter("search");
        List<Product> products = productManager.findByAll();
        List<Product> listSearch = new ArrayList<>();
        RequestDispatcher requestDispatcher;
        for (int i = 0; i < products.size() ; i++) {
            if (products.get(i).getName().contains(search)){
                listSearch.add(products.get(i));
            }
        }
        if (listSearch.size()==0){
            requestDispatcher = request.getRequestDispatcher("/view/error-404.jsp");
        } else {
            request.setAttribute("product",listSearch);
            requestDispatcher = request.getRequestDispatcher("/view/product/list.jsp");
        }
        try {
            requestDispatcher.forward(request,response);
        }catch (ServletException s){
            s.printStackTrace();
        } catch (IOException i){
            i.printStackTrace();
        }
    }

    private void showFormView(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Product product = productManager.findById(id);
        RequestDispatcher requestDispatcher;
        if (product == null){
            requestDispatcher = request.getRequestDispatcher("/view/error-404.jsp");
        }else {
            requestDispatcher = request.getRequestDispatcher("/view/product/view.jsp");
            request.setAttribute("product",product);
        }
        try {
            requestDispatcher.forward(request,response);
        }catch (ServletException s){
            s.printStackTrace();
        } catch (IOException i){
            i.printStackTrace();
        }
    }

    private void showFormDel(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Product product = productManager.findById(id);
        RequestDispatcher requestDispatcher;
        if (product == null){
            requestDispatcher = request.getRequestDispatcher("/view/error-404.jsp");
        }else {
            requestDispatcher = request.getRequestDispatcher("/view/product/delete.jsp");
            request.setAttribute("product",product);
        }
        try {
            requestDispatcher.forward(request,response);
        }catch (ServletException s){
            s.printStackTrace();
        } catch (IOException i){
            i.printStackTrace();
        }
    }

    private void showFormcCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher= request.getRequestDispatcher("/view/product/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        }catch (ServletException s){
            s.printStackTrace();
        } catch (IOException i){
            i.printStackTrace();
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Product product = productManager.findById(id);
        RequestDispatcher requestDispatcher;
        if (product == null){
            requestDispatcher = request.getRequestDispatcher("/view/error-404.jsp");
        }else {
            requestDispatcher = request.getRequestDispatcher("/view/product/edit.jsp");
            request.setAttribute("product",product);
        }
        try {
            requestDispatcher.forward(request,response);
        }catch (ServletException s){
            s.printStackTrace();
        } catch (IOException i){
            i.printStackTrace();
        }
    }

    private void showStudentList(HttpServletRequest request, HttpServletResponse response) {
        List<Product> list = productManager.findByAll();
        request.setAttribute("products", list);
        RequestDispatcher requestDispatcher  =request.getRequestDispatcher("/view/product/list.jsp");
        try{
            requestDispatcher.forward(request,response);
        }catch (ServletException s){
            s.printStackTrace();
        } catch (IOException i){
            i.printStackTrace();
        }
    }
}
