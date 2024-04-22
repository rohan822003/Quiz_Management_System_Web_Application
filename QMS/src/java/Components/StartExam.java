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
public class StartExam extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StartExam</title>");
            out.println("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.5.0/semantic.min.css\" integrity=\"sha512-KXol4x3sVoO+8ZsWPFI/r5KBVB/ssCGB5tsv2nVOKwLg33wTFP3fmnXa47FdSVIshVTgsYk/1734xSk9aFIa4A==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />");
            out.println("<style> #examForm{width:700px; margin-top:30px; box-shadow: rgba(0, 0, 0, 0.3) 0px 19px 38px, rgba(0, 0, 0, 0.22) 0px 15px 12px;}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body style='background-color:#40E0D0'>");
            
            String examName=request.getParameter("examName");
            List<Student> list = StudentDb.getExamQuestions(examName);
            
            out.println("<form action='ResultServlet' method='post' class='ui large form'>");
            out.println("<input type='hidden' name='examName' value='" + examName + "'>");
            
            
            out.println("<div class='ui middle aligned center aligned grid'>");
            out.println("<div class='ui piled segment' id='examForm'>");
            out.println("<h1 class='ui center aligned header'>" +examName + "</h1>");
            out.println("<label class='ui left label'>Name:</label><input type='text' name='fullName' placeholder='Enter Full Name' required />");
            out.println("<label class='ui left label'>Contact No:</label><input type='tel' name='contact' pattern='[7-9][0-9]{9}' placeholder='Enter Contact No' required />");
            out.println("<div class='ui divider'></div>");
            for (int i = 0; i < list.size(); i++) {
                Student s = list.get(i);
                // Output the question text
                out.println("<div id='examform'>");
                out.println("<div class='ui container'>");
                out.println( "<h3>"+"Q"+(i+1)+"  " + s.getQuestion() + "</h3>");
                // Output radio buttons for each option
                
                out.println("<i style='font-size:17px;'>");
                out.println("A) <input type='radio' name='question_" + i + "' value='" + s.getOption1() + "'>" + s.getOption1() + "<br>");
                out.println("B) <input type='radio' name='question_" + i + "' value='" + s.getOption2() + "'>" + s.getOption2() + "<br>");
                out.println("C) <input type='radio' name='question_" + i + "' value='" + s.getOption3() + "'>" + s.getOption3() + "<br>");
                out.println("D) <input type='radio' name='question_" + i + "' value='" + s.getOption4() + "'>" + s.getOption4() + "<br><br>");
                out.println("</i>");
                out.println("<div class='ui divider'></div>");
                out.println("<input type='hidden' name='ans_" + s.getId2() + "' value='" + s.getAnswer() + "'>");
            }
            // Hidden input to store the total number of questions
            out.println("<input type='hidden' name='questionCount' value='" + list.size() + "'>");
            out.println("<input class='ui positive button' type='submit' value='Submit'>");
            out.println("</div>");
            out.println("</div>");
            out.println("</form>");
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
