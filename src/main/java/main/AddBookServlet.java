package main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.BookDAO;
import model.Book;

@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/book-add.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String category = req.getParameter("category");
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        Book b = new Book();
        b.setTitle(title);
        b.setAuthor(author);
        b.setCategory(category);
        b.setQuantity(quantity);

        BookDAO dao = new BookDAO();
        dao.addBook(b);

        resp.sendRedirect(req.getContextPath() + "/books");
    }
}