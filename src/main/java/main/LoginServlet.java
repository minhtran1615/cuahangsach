package main;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.UserDAO;
import model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            String username = req.getParameter("username");
            String password = req.getParameter("password");

            Connection conn = DBConnection.getConnection();
            UserDAO dao = new UserDAO(conn);

            User user = dao.login(username, password);

            if (user != null) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);

                resp.sendRedirect(req.getContextPath() + "/books");
            } else {
                req.setAttribute("error", "Sai tài khoản hoặc mật khẩu!");
                req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
            }

        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println("Lỗi đăng nhập: " + e.getMessage());
        }
    }
}