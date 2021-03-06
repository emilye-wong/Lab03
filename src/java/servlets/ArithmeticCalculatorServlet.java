package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ArithmeticCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("result", "---");
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticCalculator.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // getting the parameters from the JSP
        String firstNum = request.getParameter("firstNum");
        String secondNum = request.getParameter("secondNum");

        request.setAttribute("firstNum", firstNum);
        request.setAttribute("secondNum", secondNum);
        
        try {
        if (firstNum == null || firstNum.equals("") || secondNum == null || secondNum.equals("")) {
            request.setAttribute("result", "Invalid");
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticCalculator.jsp").forward(request, response);

            return;
        }

        String add = request.getParameter("add");
        String minus = request.getParameter("minus");
        String multiply = request.getParameter("multiply");
        String remainder = request.getParameter("remainder");
        // parsing into ints
        int num1 = Integer.parseInt(firstNum);
        int num2 = Integer.parseInt(secondNum);
        double result = 0;

        if (add != null) {
            result = num1 + num2;
        } else if (minus != null) {
            result = num1 - num2;
        } else if (multiply != null) {
            result = num1 * num2;
        } else if (remainder != null) {
            result = num1 % num2;
        }
        request.setAttribute("result", result);
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticCalculator.jsp").forward(request, response);
        
         } catch (NumberFormatException e) {
               request.setAttribute("result", "Invalid");

            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticCalculator.jsp").forward(request, response);
        }
    }
}
