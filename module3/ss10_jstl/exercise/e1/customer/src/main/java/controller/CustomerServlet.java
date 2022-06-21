package controller;

import model.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customer", ""})
public class CustomerServlet extends HttpServlet {
    private static List<Customer> customerList;
    static {
        customerList = new ArrayList<>();
        customerList.add(new Customer("Mai Văn Hoàng", "1983-10-21", "Hà Nội", "avatar.png"));
        customerList.add(new Customer("Mai Văn Phến", "1980-10-21", "Hà Nội", "avatar.png1"));
        customerList.add(new Customer("Mai Văn Tri", "1985-10-22", "Hà Nội", "avatar.png2"));
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
