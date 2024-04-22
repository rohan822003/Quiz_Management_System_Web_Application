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
public class AlterQuestion extends HttpServlet {

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
            String searchName = request.getParameter("searchName"); // Get the value from the search box
            List<Student> list;

            if (searchName != null && !searchName.isEmpty()) {
                // Perform search based on the provided exam name
                list = StudentDb.getSearchExamQuestions(searchName);
            } else {
                // If no search name provided, fetch all exams
                list = StudentDb.getAllQuestion();
            }

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StudentExam</title> <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.5.0/semantic.min.css\" integrity=\"sha512-KXol4x3sVoO+8ZsWPFI/r5KBVB/ssCGB5tsv2nVOKwLg33wTFP3fmnXa47FdSVIshVTgsYk/1734xSk9aFIa4A==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />");
            out.println("<link href=\"home2.css\" rel=\"stylesheet\" type=\"text/css\"/>");
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
                    + "                    <li><a href=\"AdminLog.jsp\">Home</a></li>\n"
                    + "                    <li><a href=\"CreateExam.jsp\">Create Exam</a></li>\n"
                    + "                    <li><a href=\"ManageQuestion.jsp\">Add Questions</a></li>\n"
                    + "                    <li><a href=\"AlterQuestion\">Manage Questions</a></li>\n"
                    + "                    <li><a href=\"AdminExam\">Exam</a></li>\n"
                    + "                    <li><a href=\"AdminResults\">Result</a></li>\n"
                    + "                    <li><a href=\"index.html\">Logout</a></li>\n"
                    + "                </ul>\n"
                    + "            </div>\n"
                    + "\n"
                    + "          <div class='ui container'>\n"
                    + "            <h1 class=\"ui center aligned header\" style='color: white'>List of all Questions </h1><br>\n"
                    + "<div style='margin-bottom: 20px; text-align: center;'>"
                    + "<form method='get' action='AlterQuestion' class='ui small form'>"
                    + "<div style='display: inline-block;'>"
                    + "<input type='text' name='searchName' placeholder='Enter Exam Name' style='width: 300px;'>"
                    + "<button type='submit' class='ui green button'>Search</button>"
                    + "</form>"
                    + "</div>");
            String message11 = (String) request.getSession().getAttribute("message11");
            String message12 = (String) request.getSession().getAttribute("message12");
            String message13 = (String) request.getSession().getAttribute("message13");
            String message14 = (String) request.getSession().getAttribute("message14");

            if (message11 != null) {
                out.println("<div class=\"ui green message\">" + message11 + "</div>");
                request.getSession().removeAttribute("message11");
            }
            if (message12 != null) {
                out.println("<div class=\"ui red message\">" + message12 + "</div>");
                request.getSession().removeAttribute("message12");
            }
            if (message13 != null) {
                out.println("<div class=\"ui green message\">" + message13 + "</div>");
                request.getSession().removeAttribute("message13");
            }
            if (message14 != null) {
                out.println("<div class=\"ui red message\">" + message14 + "</div>");
                request.getSession().removeAttribute("message14");
            }
            out.println("<table border='1' width='100%' class='ui celled table'>\n"
                    + "                <thead>\n"
                    + "                    <tr>\n"
                    + "                        <th class='center aligned' style='padding: 30px'>Exam Name</th>\n"
                    + "                        <th class='center aligned' style='padding: 30px'>Question</th>\n"
                    + "                        <th class='center aligned' style='padding: 30px'>Option_1</th>\n"
                    + "                        <th class='center aligned' style='padding: 30px'>Option_2</th>\n"
                    + "                        <th class='center aligned' style='padding: 30px'>Option_3</th>\n"
                    + "                        <th class='center aligned' style='padding: 30px'>Option_4</th>\n"
                    + "                        <th class='center aligned' style='padding: 30px'>Answer</th>\n"
                    + "                        <th class='center aligned' style='padding: 30px'>Edit</th>\n"
                    + "                        <th class='center aligned' style='padding: 30px'>Delete</th>\n"
                    + "                    </tr>\n"
                    + "                </thead>");

            for (Student s : list) {
                out.print("<tr class='center aligned'><td>" + s.getExamName() + "</td><td>" + s.getQuestion() + "</td><td>"
                        + s.getOption1() + "</td><td>" + s.getOption2() + "</td><td>" + s.getOption3() + "</td><td>" + s.getOption4() + "</td><td>" + s.getAnswer() + "</td>"
                        + "<td><a class='ui yellow button' href='EditQuestion?id=" + s.getId3() + "'>Edit Question</a></td>" + "<td><a class='ui red button' href='DeleteQuestion?id=" + s.getId3() + "'>Delete Question</a></td></tr>");

            }
            out.print("</table>");
            out.print("</div>");
            out.print("</div>");
            out.print("</div>");
            out.println("<div> <div class=\"footer\">\n"
                    + "    <div class=\"ui container\">\n"
                    + "      <p>Created on 10 April 2024 - All Rights Reserved.</p>\n"
                    + "    </div>\n"
                    + "  </div></div>");
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
