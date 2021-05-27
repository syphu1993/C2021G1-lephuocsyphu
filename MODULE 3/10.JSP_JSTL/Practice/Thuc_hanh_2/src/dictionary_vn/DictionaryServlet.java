package dictionary_vn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "DictionaryServlet",urlPatterns = {"/search"})
public class DictionaryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,String> list = new HashMap();
        list.put("how","thế nào");
        list.put("hello", "Xin chào");
        list.put("book", "Quyển vở");
        list.put("computer", "Máy tính");
        String search = request.getParameter("search");
        String result = list.get(search);
        if (result!=null){
            request.setAttribute("result",result);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        } else {
            response.sendRedirect("result.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
