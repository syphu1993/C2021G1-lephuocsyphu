package customer_table;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customer"})
public class CustomerServlet extends HttpServlet {
    ArrayList<Customer> customers = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        customers.add(new Customer("Mai Van Hoan","26-12-1993","Quang Tri","img/anh1.PNG"));
        customers.add(new Customer("Mai Van Nam","26-12-1994","Quang Nam","img/anh2.PNG"));
        customers.add(new Customer("Mai Van Son","26-12-1995","Quang Tri","img/anh3.PNG"));
        customers.add(new Customer("Mai Van Anh","26-12-1997","Quang Tri","img/anh4.PNG"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("customers",customers);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/customer.jsp");
        requestDispatcher.forward(request,response);
    }
}
