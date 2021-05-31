/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author emily
 */
public class AgeCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // displays the JSP
        getServletContext().getRequestDispatcher("/WEB-INF/ageCalculator.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // getting the parameters from the JSP
        String age = request.getParameter("age");
        String button = request.getParameter("calculate");
        int newAge = 0;

        // set the attributes for the JSP
        request.setAttribute("age", age);

        // if the input is invalid/left blank
        if (age == null || age.equals("")) {
            request.setAttribute("message", "You must give your current age");
            // displaying the form again 
            getServletContext().getRequestDispatcher("/WEB-INF/ageCalculator.jsp").forward(request, response);
        } else {
            // calculating the next birthday age
            newAge = Integer.parseInt(age);
            // next birthday age, increased
            newAge++;
            // display result
            request.setAttribute("newAge", "Your age next birthday will be " + newAge);
            getServletContext().getRequestDispatcher("/WEB-INF/ageCalculator.jsp").forward(request, response);
        }
    }
}
