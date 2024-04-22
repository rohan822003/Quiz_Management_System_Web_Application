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
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Rohan Shinde
 */
public class ExamRegister extends HttpServlet {

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
            out.println("<head> ");
            out.println("<title>Servlet ExamRegister</title><link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.5.0/semantic.min.css\" integrity=\"sha512-KXol4x3sVoO+8ZsWPFI/r5KBVB/ssCGB5tsv2nVOKwLg33wTFP3fmnXa47FdSVIshVTgsYk/1734xSk9aFIa4A==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" /><link href=\"home.css\" rel=\"stylesheet\" type=\"text/css\"/>");
            out.println("<style>\n"
                    + "            #reg{\n"
                    + "                margin-top: 100px;\n"
                    + "                width: 500px;\n"
                    + "                box-shadow: rgba(0, 0, 0, 0.3) 0px 19px 38px, rgba(0, 0, 0, 0.22) 0px 15px 12px;\n"
                    + "            }\n"
                    + "            #regbtn{\n"
                    + "                text-align: center;\n"
                    + "            }\n"
                    + "        </style></head>");
            out.println("<body><div class=\"navbar\">\n"
                    + "            <div class=\"nav\">\n"
                    + "                <h1 class=\"logo\">QuizOn</h1>\n"
                    + "                <ul>\n"
                    + "                    <li><a href=\"StudentHome.html\">Home</a></li>\n"
                    + "                    <li><a href=\"StudentExam\">Exams</a></li>\n"
                    + "                    <li><a href=\"Results\">Results</a></li>\n"
                    + "                    <li><a href=\"index.html\">Logout</a></li>\n"
                    + "                </ul>\n"
                    + "            </div>\n"
                    + "            <div class=\"reg\">\n"
                    + "                <div class=\"ui middle aligned center aligned grid\">\n"
                    + "                    <div class=\"ui piled segment\" id=\"reg\">\n"
                    + "                        <form action=\"ResultServlet\" method=\"post\" class=\"ui large form\">\n"
                    + "                            <h1 class=\"ui center aligned header\">To See Ther Result Please Fill The Form</h1>\n"
                    + "                            <div class=\"ui divider\"></div>\n"
                    + "                            <br>\n"
                    + "                            <label class=\"ui teal label\">Full Name:</label>\n"
                    + "                            <input type=\"text\" name=\"fullname\" placeholder=\"Enter Full Name\" required/>\n"
                    + "                            <br><br>\n"
                    + "                            <label class=\"ui teal label\">Contact No:</label>\n"
                    + "                            <input type=\"tel\" name=\"contact\" placeholder=\"Contact No\" required/>\n"
                    + "                            <br><br>\n"
                    + "                            <div id=\"regbtn\">\n"
                    + "                                <button type=\"submit\" value=\"register\" class=\"ui positive button\" >Register</button>\n"
                    + "                            </div>\n"
                    + "                           \n"
                    + "                        </form>\n"
                    + "                    </div>\n"
                    + "\n"
                    + "                </div>\n"
                    + "\n"
                    + "            </div>\n"
                    + "        </div>");

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
