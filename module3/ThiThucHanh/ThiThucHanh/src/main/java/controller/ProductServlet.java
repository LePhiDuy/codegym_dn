package controller;

import model.Category;
import model.Product;
import service.CategoryService;
import service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    private static ProductService productService = new ProductService();
    private static CategoryService categoryService = new CategoryService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            default:
                showListProduct(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "edit":
                updateProduct(request, response);
                break;
            case "search":
                searchProduct(request, response);
                break;
        }
    }


    private void showListProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = productService.getAll();
        List<Category> categories = categoryService.getAll();
        request.setAttribute("products", products);
        request.setAttribute("categories", categories);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = categoryService.getAll();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("product/create.jsp").forward(request, response);
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String desc = request.getParameter("desc");
        String idCategory = request.getParameter("idCategory");

        boolean checkSuccess = true;
        String addSuccess = "Add new product successful !!!";

        if(price <= 10000000 || quantity <= 0) {
            checkSuccess = false;
        }

        Product product = null;
        product = new Product(name, price, quantity, color, desc, Integer.parseInt(idCategory));
        if(checkSuccess) {
            productService.add(product);
            request.setAttribute("addSuccess", addSuccess);
            request.setAttribute("products", productService.getAll());
            request.setAttribute("categories", categoryService.getAll());
            request.getRequestDispatcher("product/list.jsp").forward(request, response);
        }
        else {
            addSuccess = "Add new product failure";
            request.setAttribute("product", product);
            request.setAttribute("addSuccess", addSuccess);
            request.setAttribute("categories", categoryService.getAll());
            request.getRequestDispatcher("product/create.jsp").forward(request, response);
        }

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.selectProductByID(id);
        List<Category> categories = categoryService.getAll();

        request.setAttribute("product", product);
        request.setAttribute("categories", categories);

        request.getRequestDispatcher("product/edit.jsp").forward(request, response);
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = null;
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String desc = request.getParameter("desc");
        String idCategory = request.getParameter("idCategory");
        product = new Product(id, name, price, quantity, color, desc, Integer.parseInt(idCategory));
        productService.update(product);

        response.sendRedirect("/products");
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String category = request.getParameter("category");
        String color = request.getParameter("color");

        if(name == "" && price == "" && category == "" && color == "") {
            response.sendRedirect("/products");
            return;
        }

        List<Product> products = productService.search(name, price, category, color);
        List<Category> categories = categoryService.getAll();

        request.setAttribute("search", "search");
        request.setAttribute("products", products);
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("product/list.jsp").forward(request, response);
    }


    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.delete(id);

        response.sendRedirect("/products");
    }
}
