package controller;

import dao.BooksDAO;
import model.Books;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/books"})
public class BooksServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "/books.jsp";
        BooksDAO dao = new BooksDAO();
        List<Books> books = dao.findAll();
        req.setAttribute("books", books);

        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
}
