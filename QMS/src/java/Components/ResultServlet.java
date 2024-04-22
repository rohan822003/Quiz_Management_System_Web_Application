/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Components;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author Rohan Shinde
 */
public class ResultServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ResultServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ResultServlet at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {

            int totalQuestions = Integer.parseInt(request.getParameter("questionCount"));
            String examName = request.getParameter("examName");
            List<Student> allQuestions = StudentDb.getExamQuestions(examName);

            // Display the result
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head> <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.5.0/semantic.min.css\" integrity=\"sha512-KXol4x3sVoO+8ZsWPFI/r5KBVB/ssCGB5tsv2nVOKwLg33wTFP3fmnXa47FdSVIshVTgsYk/1734xSk9aFIa4A==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />");
            out.println("<title>Exam Result</title>");
            out.println("<style> #resultForm{width:700px; margin-top:30px; box-shadow: rgba(0, 0, 0, 0.3) 0px 19px 38px, rgba(0, 0, 0, 0.22) 0px 15px 12px;}h2{text-align:center;}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body style='background-color:#00FA9A'>");
            out.println("<div class='ui middle aligned center aligned grid'>");
            out.println("<div class='ui piled segment' id='resultForm'> ");

            out.println("<b><h2>Exam Name: " + examName + "</h2></b>");
            String name = request.getParameter("fullName");

            out.println("<h3>Student Name: " + name + "</h3>");
            out.println("<div class='ui divider'></div>");
            // Calculate the number of correct answers
            int correctAnswers = 0;

            for (int i = 0; i < totalQuestions; i++) {
                String selectedOption = request.getParameter("question_" + i);

                Student currentQuestion = allQuestions.get(i);

                String correctAnswer = currentQuestion.getAnswer();

                if (selectedOption != null && selectedOption.equals(correctAnswer)) {
                    out.println("<b>Question No:" + (i + 1) + "</b><h4 Style=color:green>Selected Answers: " + selectedOption + "</h4>");
                    out.println("<h4 Style=color:green>corrected Answers: " + correctAnswer + "</h4>");
                    correctAnswers++;
                    out.println("<div class='ui divider'></div>");
                } else {
                    out.println("<b>Question No:" + (i + 1) + "</b><h4 Style=color:red>Selected Answers: " + selectedOption + "</h4>");
                    out.println("<h4 Style=color:green  >corrected Answers: " + correctAnswer + "</h4>");
                    out.println("<div class='ui divider'></div>");
                }
            }

            // Determine if the user passed or failed
            out.println("<div class='ui divider'></div>");
            String result = (correctAnswers >= totalQuestions * 0.6) ? "Passed" : "Failed"; // Assuming passing grade is 60%
            out.println("<h3>Total Number of Questions: " + totalQuestions + "</h3>");
            out.println("<h3>Correct Answers: " + correctAnswers + "</h3>");

            out.println("<h3>Result: " + result + "</h3>");
            out.println("<div style='text-align: center; margin-top: 20px;'>");
            out.println("<form action='Results' method='get'>");
            out.println("<button type='submit' class='ui orange button'>Close</button>");
            out.println("</form>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            String contacts = request.getParameter("contact");

            Student s = new Student();
            s.setsName(name);
            s.setContact(contacts);
            s.seteName(examName);
            s.settQuestions(totalQuestions);
            s.setcQuestions(correctAnswers);
            s.setResults(result);
            int status = StudentDb.saveExamResult(s);
            out.println("</body>");
            out.println("</html>");
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
