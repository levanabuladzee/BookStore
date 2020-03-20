package controller;

import dao.CartDAO;
import model.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/cart"})
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "/cart.jsp";
        CartDAO dao = new CartDAO();
        List<Cart> carts = dao.findAll();
        req.setAttribute("carts", carts);

        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
}
