package controller;

import model.Product;
import service.IProductService;
import service.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

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
            case "create":
                showFormCreate(request, response);
                break;
            case "edit":
                showFormEdit(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            case "view":
                break;
            default:
                listProduct(request, response);
                break;
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        request.setAttribute("product", product);
        try {
            request.getRequestDispatcher("edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("create.jsp");
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productService.findAll();
        request.setAttribute("products", products);
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createNewProduct(request, response);
                break;
            case "edit":
                editProduct(request, response);
                break;
            case "view":
                break;
            default:
                listProduct(request, response);
                break;
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        Product product = productService.findById(id);
        if (product == null) {
            request.getRequestDispatcher("error-404.jsp").forward(request, response);
        } else {
            product.setName(name);
            product.setPrice(price);
            productService.update(id, product);
            listProduct(request, response);
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        productService.remove(id, product);
        try {
            listProduct(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createNewProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int id = (int)Math.random() * 1000;
        Product product = new Product(id, name, price);
        productService.save(product);
        request.setAttribute("message", "New product was created");
        request.getRequestDispatcher("create.jsp").forward(request, response);
    }
}
