package main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.BookDAO;
import model.Book;

@WebServlet("/editBook")
public class EditBookServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        BookDAO dao = new BookDAO();
        Book b = dao.getBookById(id);

        req.setAttribute("book", b);
        req.getRequestDispatcher("/WEB-INF/book-edit.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String category = req.getParameter("category");
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        Book b = new Book(id, title, author, category, quantity);

        BookDAO dao = new BookDAO();
        dao.updateBook(b);

        resp.sendRedirect(req.getContextPath() + "/books");
    }
}