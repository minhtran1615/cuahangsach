package main;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.BookDAO;

@WebServlet("/deleteBook")
public class DeleteBookServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        BookDAO dao = new BookDAO();
        dao.deleteBook(id);

        resp.sendRedirect(req.getContextPath() + "/books");
    }
}