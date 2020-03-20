package controller;

import dao.BooksDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/add-book"})
public class AddBookServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "/manage";
        BooksDAO dao = new BooksDAO();
        String bookName = req.getParameter("bookName");
        String author = req.getParameter("author");
        int category = Integer.parseInt(req.getParameter("category"));
        int pages = Integer.parseInt(req.getParameter("pages"));;
        int date = Integer.parseInt(req.getParameter("date"));;
        double price = Double.parseDouble(req.getParameter("price"));;
        dao.addBook(bookName, author, category, pages, date, price);

        resp.sendRedirect(req.getContextPath() + url);
    }
}
