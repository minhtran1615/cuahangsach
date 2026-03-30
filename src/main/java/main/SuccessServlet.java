package main;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/success")
public class SuccessServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

      
        HttpSession session = req.getSession(false);

        if(session == null || session.getAttribute("user") == null) {
            resp.sendRedirect(req.getContextPath() + "/hello");
            return;
        }

        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().println("<h1>Đăng nhập thành công!</h1>");
    }
}