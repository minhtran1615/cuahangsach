package main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if(session == null || session.getAttribute("user") == null) {
            resp.sendRedirect(req.getContextPath() + "/hello");
            return;
        }

        req.setAttribute("user", session.getAttribute("user"));
        req.getRequestDispatcher("/WEB-INF/dashboard.jsp").forward(req, resp);
    }
}