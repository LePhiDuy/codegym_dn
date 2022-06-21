package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = {"/calculator", ""})
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("calculator.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float firstOperand = Float.parseFloat(request.getParameter("firstOperand"));
        float secondOperand = Float.parseFloat(request.getParameter("secondOperand"));
        String operator = request.getParameter("operator");
        try {
            float result = calculate(firstOperand, secondOperand, operator);
            request.setAttribute("result", result);
            request.getRequestDispatcher("result.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public float calculate(float firstOperand, float secondEOperand, String operator) throws Exception {
        float result = 0;
        switch (operator) {
            case "Addition":
                result = firstOperand + secondEOperand;
                break;
            case "Sub":
                result = firstOperand - secondEOperand;
                break;
            case "Multi":
                result = firstOperand * secondEOperand;
                break;
            case "Division":
                if (secondEOperand == 0) {
                    throw new Exception("Cannot division by zero");
                }
                result = firstOperand / secondEOperand;
                break;
        }
        return result;
    }
}
