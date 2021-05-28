package caculator_simple;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CaculatorServlet", urlPatterns = {"/calculate"})
public class CaculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    double a = Double.parseDouble(request.getParameter("a"));
    double b = Double.parseDouble(request.getParameter("b"));
    String operator = request.getParameter("operator");
    try{
        Double result = Caculator.caculator(a,b,operator);
        request.setAttribute("result",result);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    } catch (Exception e){
        e.getMessage();
        response.sendRedirect("indefined.jsp");
    }
    }
}
