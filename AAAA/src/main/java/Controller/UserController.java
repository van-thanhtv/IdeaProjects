package Controller;

import Constant.SessionAttr;
import Entity.User;
import Entity.Video;
import Servlet.Impl.UserServiceImpl;
import Servlet.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/login", "/logout", "/register"})
public class UserController extends HttpServlet {
    private static final long serialVersionUID = -5860351843059541642L;
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();//lấy path ví dụ localhost:8080/asm_java4/login --> path="/login"
        HttpSession session = req.getSession();
        switch (path) {
            case "/login":
                doGetLogin(req, resp);
                break;
            case "/register":
                doGetRegister(req, resp);
                break;
                case "/logout":
                doGetlogout(session,req, resp);
                break;
        }
    }

    private void doGetLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/Views/Users/login.jsp").forward(req, resp);
    }

    private void doGetRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/Views/Users/register.jsp").forward(req, resp);
    }
    private void doGetlogout(HttpSession session,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        session.removeAttribute(SessionAttr.CURRENT_USER);
        resp.sendRedirect("index");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String path = req.getServletPath();//lấy path ví dụ localhost:8080/asm_java4/login --> path="/login"
        switch (path) {
            case "/login":
                doPostLogin(session, req, resp);
                break;
                case "/register":
                doPostRegister(session, req, resp);
                break;
        }
    }

    private void doPostLogin(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println(username + password);
        User user = userService.login(username, password);

        if (user != null) {
            session.setAttribute(SessionAttr.CURRENT_USER, user);
            resp.sendRedirect("index");
        } else {
            resp.sendRedirect("login");
        }
    }
    private void doPostRegister(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        System.out.println(username + password);
        User user = userService.create(username, password,email);

        if (user != null) {
            session.setAttribute(SessionAttr.CURRENT_USER, user);
            resp.sendRedirect("index");
        } else {
            resp.sendRedirect("register");
        }
    }
}
