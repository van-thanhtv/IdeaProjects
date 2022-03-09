package Lab3;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "StaffServlet", value = "/StaffServlet")
public class StaffServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Views/Lab3/formb2.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Định dạng thời gian nhập vào
            DateTimeConverter dtc = new DateConverter();
            dtc.setPattern("MM/dd/yyyy");
            ConvertUtils.register(dtc, Date.class);
            Staff staff = new Staff();
            // Đọc tham số vào các thuộc tính của bean staff
            BeanUtils.populate(staff, request.getParameterMap());
            // Chia sẻ với result.jsp
            request.setAttribute("bean", staff);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/Views/Lab3/resultb2.jsp").forward(request,response);
    }
}
