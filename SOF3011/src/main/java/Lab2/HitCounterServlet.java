package Lab2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.file.*;

@WebServlet(name = "HitCounterServlet", value = "/HitCounterServlet")
public class HitCounterServlet extends HttpServlet {
    int count;
    Path path = Paths.get("/home/thanhkali/Downloads/Thanh.txt");
    @Override
    public void init() throws ServletException {
        super.init();
        try {
            count = Integer.parseInt(Files.readAllLines(path).get(0));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        count++;
        request.setAttribute("count",count);
        request.getRequestDispatcher("/Views/HitCounter.jsp").forward(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            Files.write(path,String.valueOf(count).getBytes(), StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
