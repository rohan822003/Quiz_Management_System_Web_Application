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

/**
 *
 * @author Rohan Shinde
 */
public class EditQuestion extends HttpServlet {

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
            out.println("<title>Servlet EditQuestion</title>");
            out.println("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.5.0/semantic.min.css\" integrity=\"sha512-KXol4x3sVoO+8ZsWPFI/r5KBVB/ssCGB5tsv2nVOKwLg33wTFP3fmnXa47FdSVIshVTgsYk/1734xSk9aFIa4A==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />");
            out.println("<style>#updateEx{margin-top:40px; width:500px;} </style>");
            out.println("</head>");
            out.println("<body style='background-color:orange;'><div class=\"ui middle aligned center aligned grid\">  \n"
                    + "                <div class=\"ui stacked segment\" id=\"updateEx\">\n"
                    + "                   \n");
                    int id = Integer.parseInt(request.getParameter("id"));
            Student s = StudentDb.getQuestionById(id);
                    out.println("<form action=\"EditQuestion2\" method=\"post\" class=\"ui large form\">\n"
                    + "                        <h1 class=\"ui center aligned header\">Edit Questions</h1>\n"
                    + "                        \n"
                    + "                        \n");
                            out.print("<input type='hidden' name='id' value='"+s.getId3()+"'/>"  
                    + "                        <label class=\"ui left label\">Enter question:</label><input type=\"text\" name=\"question\" value='"+s.getQuestion()+"' placeholder=\"Enter your question\" required /><br><br>\n"
                    + "                        <label class=\"ui left label\">Option 1:</label><input type=\"text\" name=\"option1\" value='"+s.getOption1()+"' placeholder=\"Enter Option 1\" required/> <br><br>\n"
                    + "                        <label class=\"ui left label\">Option 2:</label><input type=\"text\" name=\"option2\" value='"+s.getOption2()+"' placeholder=\"Enter Option 2\" required/> <br><br>\n"
                    + "                        <label class=\"ui left label\">Option 3:</label><input type=\"text\" name=\"option3\" value='"+s.getOption3()+"' placeholder=\"Enter Option 3\" required/> <br><br>\n"
                    + "                        <label class=\"ui left label\">Option 4:</label><input type=\"text\" name=\"option4\" value='"+s.getOption4()+"' placeholder=\"Enter Option 4\" required/><br><br> \n"
                    + "                        <label class=\"ui left label\">Correct Answer:</label><input type=\"text\" name=\"answer\" value='"+s.getAnswer()+"' placeholder=\"Enter Correct Answer\" required/> <br><br>\n"
                    + "                        <div class=\"addQ\"> <button type=\"submit\" class=\"ui positive button\">Update</button></div>\n"
                    + "                    </form> \n"
                    + "                </div>\n"
                    + "            </div> ");
            
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
