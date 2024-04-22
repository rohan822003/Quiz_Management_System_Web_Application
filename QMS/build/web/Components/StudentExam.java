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
public class StudentExam extends HttpServlet {

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
            out.println("<title>Servlet StudentExam</title> <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.5.0/semantic.min.css\" integrity=\"sha512-KXol4x3sVoO+8ZsWPFI/r5KBVB/ssCGB5tsv2nVOKwLg33wTFP3fmnXa47FdSVIshVTgsYk/1734xSk9aFIa4A==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />");
            out.println("</head>");
            out.println("<body> <div class=\"navbar\">\n"
                    + "            <div class=\"nav\">\n"
                    + "                <h1 class=\"logo\">QuizOn</h1>\n"
                    + "                <ul>\n"
                    + "                    <li><a href=\"StudentHome.html\">Home</a></li>\n"
                    + "                    <li><a href=\"/QMS/Components/StudentExam.java\">Exams</a></li>\n"
                    + "                    <li><a href=\"#\">Results</a></li>\n"
                    + "                    <li><a href=\"index.html\">Logout</a></li>\n"
                    + "                </ul>\n"
                    + "            </div>\n"
                    + "            <div class=\"content\">\n"
                    + "                <h1>Welcome to QuizOn</h1>\n"
                    + "                \n"
                    + "            </div>\n"
                    + "\n"
                    + "            \n"
                    + "        </div>\n"
                    + "        <div>\n"
                    + "            <h1 class=\"ui center aligned header\" style='color: green'>List of all Exams </h1>\\\n"
                    + "            <table border='1' width='100%' class='ui celled table'>\n"
                    + "                <thead>\n"
                    + "                    <tr>\n"
                    + "                        <th class='center aligned' style='padding: 30px'>Exam Name</th>\n"
                    + "                        <th class='center aligned' style='padding: 30px'>Exam Date</th>\n"
                    + "                        <th class='center aligned' style='padding: 30px'>Exam Duration</th>\n"
                    + "                        <th class='center aligned' style='padding: 30px'>Start Exam</th>\n"
                    + "                    </tr>\n"
                    + "                </thead>");
            List <Student> list = StudentDb.getAllExams();
            for(Student s : list)
                {
                      out.print("<tr class='center aligned'><td>"+s.getExamName2()+"</td><td>"+s.getExamDate()+"</td><td>"+
                              s.getExamDuration()+"</td><td><td><a class='ui green button' href='#'>Start Exam</a></td></tr>");  
      
                }
               out.print("</table>"); 
            out.println("<h1>Servlet StudentExam at " + request.getContextPath() + "</h1>");
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
