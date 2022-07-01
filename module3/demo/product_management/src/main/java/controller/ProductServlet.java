package controller;

import module.Product;
import service.IProductService;
import service.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ProductServlet", urlPatterns = {"/products", ""})
public class ProductServlet extends HttpServlet {
    IProductService productService = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "save":
                showCreateForm(request, response);
                break;
            case "delete":
                try {
                    deleteProduct(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    showProductList(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        String sId = request.getParameter("id");
        int id = sId.isEmpty() ? 0 : Integer.parseInt(sId);
        boolean isDeleteSuccess = productService.remove(id);
        showProductList(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.searchByID(id);
        request.setAttribute("product", product);
        request.getRequestDispatcher("/product/save.jsp").forward(request, response);
    }

    private void showProductList(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        request.setAttribute("productList", productService.findAll()); //đẩy data vào jsp
        request.getRequestDispatcher("/product/list.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "save":
                saveProduct(request, response);
                try {
                    showProductList(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    showProductList(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

    private void saveProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String sId = request.getParameter("id");
        int id = sId.isEmpty() ? 0 : Integer.parseInt(sId);
        String productName = request.getParameter("productName");
        double productPrice = Double.parseDouble(request.getParameter("productPrice"));
        String procductColor = request.getParameter("productColor");
        Product product = new Product(id, productName, productPrice, procductColor);
        productService.save(product);
    }
}
