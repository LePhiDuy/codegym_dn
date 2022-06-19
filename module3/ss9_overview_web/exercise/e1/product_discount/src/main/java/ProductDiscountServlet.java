import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

@WebServlet(name = "ProductDiscountServlet", urlPatterns = "/discount")
public class ProductDiscountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("listPrice"));
        double percent = Double.parseDouble(request.getParameter("discountPercent"));

        PrintWriter w = response.getWriter();
        w.println("<html>");
        w.println("Product description is " + description);
        w.println("List price is " + price);
        w.println("Discount percent is " + percent );
        w.println("</html>");
    }
}
