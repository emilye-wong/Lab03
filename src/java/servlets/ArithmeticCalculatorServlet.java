/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author emily
 */
public class ArithmeticCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticCalculator.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // getting the parameters from the JSP
        String firstNum = request.getParameter("firstNum");
        String secondNum = request.getParameter("secondNum");
        String add = request.getParameter("add");
        String minus = request.getParameter("minus");
        String multiply = request.getParameter("multiply");
        String divide = request.getParameter("divide");

        if (firstNum == null || firstNum.equals("") || secondNum == null || secondNum.equals("")) {
            request.setAttribute("result", "Invalid");
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticCalculator.jsp").forward(request, response);

            return;
        }

        // parsing into ints
        int num1 = Integer.parseInt(firstNum);
        int num2 = Integer.parseInt(secondNum);
        int result = 0;

        if (add != null) {
            result = num1 + num2;
        } else if (minus != null) {
            result = num1 - num2;
        } else if (multiply != null) {
            result = num1 * num2;
        } else if (divide != null) {
            result = num1 / num2;
        }
        request.setAttribute("result", result);
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticCalculator.jsp").forward(request, response);
    }

}
