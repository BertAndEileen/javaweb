import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author Bert
 */
@WebServlet(name = "PrintHTML",value = "/printHtml")
public class PrintHTML extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //回传一个简单的html页面
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        System.out.println("<!DOCTYPE html>\r\n");
        System.out.println("<html lang=\"en\">\r\n");
        System.out.println("<head>\r\n");
        System.out.println("<meta charset=\"UTF-8\">\r\n");
        System.out.println("<title>Title</title>\r\n");
        System.out.println("</head>\r\n");
        System.out.println("<body>\r\n");
        System.out.println("这是HELLO的html页面\r\n");
        System.out.println("</body>\r\n");
        System.out.println("</html>\r\n");










    }
}
