package Lab3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
@MultipartConfig
@WebServlet(name = "UploadServlet", value = "/UploadServlet")
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Views/Lab3/form.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // đường dẫn thư mục tính từ gốc của website
        File dir = new File(request.getServletContext().getRealPath("/files"));
        if(!dir.exists()) { // tạo nếu chưa tồn tại
            dir.mkdirs();
//            System.out.println("tao mới");
        }
//        System.out.println(dir.getParent());
        // lưu các file upload vào thư mục files
        Part photo = request.getPart("poto"); // file hình
        File photoFile = new File(dir, photo.getSubmittedFileName());
        photo.write(photoFile.getAbsolutePath());
        Part doc = request.getPart("doc_file"); // file tài liệu
        File docFile = new File(dir, doc.getSubmittedFileName());
        doc.write(docFile.getAbsolutePath());
        // chia sẻ cho result.jsp để hiển thị
        request.setAttribute("img", photoFile);
        request.setAttribute("doc", docFile);
        request.getRequestDispatcher("/Views/Lab3/result.jsp").forward(request,response);
    }
}
