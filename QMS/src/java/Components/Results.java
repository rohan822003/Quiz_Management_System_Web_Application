/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Components;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author Rohan Shinde
 */
public class Results extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* Output your page here */
            String searchName = request.getParameter("searchName"); // Get the value from the search box
            List<Student> list;

            if (searchName != null && !searchName.isEmpty()) {
                // Perform search based on the provided exam name
                list = StudentDb.getSearchResults(searchName);
            } else {
                // If no search name provided, fetch all exams
                list = StudentDb.getResults();
            }

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StudentExam</title> <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.5.0/semantic.min.css\" integrity=\"sha512-KXol4x3sVoO+8ZsWPFI/r5KBVB/ssCGB5tsv2nVOKwLg33wTFP3fmnXa47FdSVIshVTgsYk/1734xSk9aFIa4A==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />");
            out.println("<link href=\"home.css\" rel=\"stylesheet\" type=\"text/css\"/>");
             out.println("<style>.footer {\n"
                    + "               \n"
                    + "                left: 0;\n"
                    + "                bottom: 0;\n"
                    + "                width: 100%;\n"
                    + "                background-color: #006666;\n"
                    + "                color: white;\n"
                    + "                text-align: center;\n"
                    + "                padding: 20px 0;\n"
                    + "            }</style");
            out.println("</head>");
            out.println("<body> <div class=\"navbar\">\n"
                    + "            <div class=\"nav\">\n"
                    + "                <h1 class=\"logo\">QuizOn</h1>\n"
                    + "                <ul>\n"
                    + "                    <li><a href=\"StudentLog.jsp\">Home</a></li>\n"
                    + "                    <li><a href=\"StudentExam\">Exams</a></li>\n"
                    + "                    <li><a href=\"Results\">Results</a></li>\n"
                    + "                    <li><a href=\"index.html\">Logout</a></li>\n"
                    + "                </ul>\n"
                    + "            </div>\n"
                    + "\n"
                    + "          <div class='ui container'>\n"
                    + "            <h1 class=\"ui center aligned header\" style='color: white'>List of all Results </h1><br>\n"
                      + "<div style='margin-bottom: 20px; text-align: center;'>"
                    + "<form method='get' action='Results' class='ui small form'>"
                    + "<div style='display: inline-block;'>"
                    + "<input type='text' name='searchName' placeholder='Enter Student Name' style='width: 300px;'>"
                    + "<button type='submit' class='ui green button'>Search</button>"
                    + "</form>"
                    + "</div>"
                    + "            <table border='1' width='100%' class='ui celled table'>\n"
                    + "                <thead>\n"
                    + "                    <tr>\n"
                    + "                        <th class='center aligned' style='padding: 30px'>Student Name</th>\n"
                    + "                        <th class='center aligned' style='padding: 30px'>Contact No</th>\n"
                    + "                        <th class='center aligned' style='padding: 30px'>Exam Name</th>\n"
                    + "                        <th class='center aligned' style='padding: 30px'>Total Question</th>\n"
                    + "                        <th class='center aligned' style='padding: 30px'>Correct Answers</th>\n"
                    + "                        <th class='center aligned' style='padding: 30px'>Result</th>\n"
                    + "                    </tr>\n"
                    + "                </thead>");

            
            for (Student s : list) {
                        out.print("<tr class='center aligned'><td>" + s.getsName() + "</td><td>" + s.getContact() + "</td><td>"
                        + s.geteName() + "</td><td>" + s.gettQuestions() + "</td><td>" + s.getcQuestions()
                        + "</td><td>" + s.getResults() + "</td></tr>");
            }

            out.print("</table>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("<div> <div class=\"footer\">\n"
                    + "    <div class=\"ui container\">\n"
                    + "      <p>Created on 10 April 2024 - All Rights Reserved.</p>\n"
                    + "    </div>\n"
                    + "  </div></div>");
            out.println("</body>");
            out.println("</body>");
            out.println("</html>");
        }

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    // Generate HTML table
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        try ( PrintWriter out = response.getWriter()) {

        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
