package main;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.BookDAO;
import model.Book;

@WebServlet("/books")
public class BookListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	
    	System.out.println("ĐÃ VÀO /books servlet");

        BookDAO dao = new BookDAO();
        List<Book> list = dao.getAllBooks();

        req.setAttribute("books", list);
        req.getRequestDispatcher("/WEB-INF/book-list.jsp").forward(req, resp);
    }
}

//them danh sach khach hang gom : ten,ngay dk ,ma kh ,sdt
