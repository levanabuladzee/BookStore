package controller;

import dao.BooksDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/remove-book"})
public class RemoveBookServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "/manage";
        BooksDAO dao = new BooksDAO();
        int bookId = Integer.parseInt(req.getParameter("bookId"));
        dao.removeBook(bookId);

        resp.sendRedirect(req.getContextPath() + url);
    }
}
