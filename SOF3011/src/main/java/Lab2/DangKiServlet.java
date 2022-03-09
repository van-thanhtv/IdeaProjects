package Lab2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

@WebServlet(name = "DangKiServlet", value = "/DangKiServlet")
public class DangKiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Views/DangKi/form.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        boolean gender = Boolean.parseBoolean(request.getParameter("gt1"));
        boolean married = (request.getParameter("married")!=null);
        String country = request.getParameter("country");
        String[] hobbeies = request.getParameterValues("hobbeies");

        System.out.println(">>username :"+username);
        System.out.println(">>gender :"+gender);
        System.out.println(">>married :"+married);
        System.out.println(">>hobbeies :"+ Arrays.toString(hobbeies));
        System.out.println(">>country :"+country);

        request.getRequestDispatcher("/Views/DangKi/result.jsp").forward(request,response);
    }
}
