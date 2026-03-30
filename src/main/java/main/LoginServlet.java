package main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");


        if(username.equals("admin") && password.equals("123")) {

            HttpSession session = req.getSession();
            session.setAttribute("user", username);

            resp.sendRedirect(req.getContextPath() + "/dashboard");

        } else {
            resp.sendRedirect(req.getContextPath() + "/fail");
        }
    }
}