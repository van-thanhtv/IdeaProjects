package Lab2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TamGiacServlet", value ={"/TamGiacServlet","/dienTich","/chuVi"})
public class TamGiacServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Views/Param/tamGiac.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double a = Double.parseDouble(request.getParameter("a"));
        double b = Double.parseDouble(request.getParameter("b"));
        double c = Double.parseDouble(request.getParameter("c"));
        if ((a+b>c)&&(a+c>b)&&(b+c>a)){
            double chuVi = a+b+c;
            String uri = request.getRequestURI();
            if (uri.contains("dienTich")){
                double dienTich = Math.sqrt(chuVi*(a+b-c)*(a+c-b)*(b+c-a))/4;
                request.setAttribute("message","Diện tích của tam giác là : "+dienTich);
            }else {
                request.setAttribute("message","Chu vi của tam giác là : "+chuVi);
            }
        }else {
            request.setAttribute("message","Không thỏa mãn chác cạnh của 1 tam giác!");
        }
        request.getRequestDispatcher("/Views/Param/tamGiac.jsp").forward(request,response);

    }
}
