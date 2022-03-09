package Lab1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ChuNhatServlet", value = "/ChuNhatServlet")
public class ChuNhatServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Views/ChuNhat/formNhap.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String x = request.getParameter("dai");
        double dai = Double.parseDouble(x);
        String y = request.getParameter("rong");
        double rong = Double.parseDouble(y);
        request.setAttribute("dt",dai*rong);
        request.setAttribute("cv",(dai+rong)*2);
        request.getRequestDispatcher("/Views/ChuNhat/ketQua.jsp").forward(request,response);
    }
}
