package main;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.BookDAO;
import model.Book;

@WebServlet("/searchBook")
public class SearchBookServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String keyword = req.getParameter("keyword");

        BookDAO dao = new BookDAO();
        List<Book> list = dao.searchBooks(keyword);

        req.setAttribute("books", list);
        req.getRequestDispatcher("/WEB-INF/book-list.jsp").forward(req, resp);
    }
}