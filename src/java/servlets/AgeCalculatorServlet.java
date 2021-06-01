package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        int newAge = 0;

        // set the attributes for the JSP
        request.setAttribute("age", age);

        try {
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

        } catch (NumberFormatException e) {
            request.setAttribute("message", "You must enter a number");
            // displaying the form again
            getServletContext().getRequestDispatcher("/WEB-INF/ageCalculator.jsp").forward(request, response);
        }
    }
}
