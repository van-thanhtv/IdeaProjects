package Controller;


//import Servlet.VideoService;

import Entity.Video;
import Servlet.Impl.VideoServiceImpl;
import Servlet.VideoService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/index")
public class HomeController extends HttpServlet {
    private VideoService videoService = new VideoServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Video> videos = videoService.findAll();

        System.out.println(videos.size());
        request.setAttribute("videos", videos);
        RequestDispatcher fomDispatcher = request.getRequestDispatcher("/Views/Users/index.jsp");
        fomDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
