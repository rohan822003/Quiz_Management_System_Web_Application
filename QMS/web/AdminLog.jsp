<!DOCTYPE html>
<%@ page import="java.util.List" %>
<%@ page import="Components.Student" %>
<%@ page import="Components.StudentDb" %>
<html>
    <head>
        <title>Quiz Management System</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.5.0/semantic.min.css" integrity="sha512-KXol4x3sVoO+8ZsWPFI/r5KBVB/ssCGB5tsv2nVOKwLg33wTFP3fmnXa47FdSVIshVTgsYk/1734xSk9aFIa4A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link href="home.css" rel="stylesheet" type="text/css"/>
        <style>

        </style>
    </head>
    <body>
        <div class="navbar">
            <div class="nav">
                <h1 class="logo">QuizOn</h1>
                <ul>
                    <li><a href="AdminLog.jsp">Home</a></li>
                    <li><a href="CreateExam.jsp">Create Exam</a></li>
                    <li><a href="ManageQuestion.jsp">Add Questions</a></li>
                    <li><a href="AlterQuestion">Manage Questions</a></li>
                    <li><a href="AdminExam">Exam</a></li>
                    <li><a href="AdminResults">Result</a></li>
                    <li><a href="index.html">Logout</a></li>
                </ul>
            </div>
            <div class="content">
                <h1>Welcome to QuizOn</h1>



            </div>
        </div>
        <br><br>
        <div>
            <%
                String searchName = request.getParameter("searchName"); // Get the value from the search box
        List<Student> list;

        if (searchName != null && !searchName.isEmpty()) {
            // Perform search based on the provided exam name
            list = StudentDb.getSearchAllResponse(searchName);
        } else {
            // If no search name provided, fetch all exams
            list = StudentDb.getAllResponse();
        }
            %>
            <div style='margin-bottom: 20px; text-align: center;'>
                <form method='get' action='AdminLog.jsp' class='ui small form'>
                    <div style='display: inline-block;'>
                        <input type='text' name='searchName' placeholder='Enter Student Name' style='width: 300px;'>
                        <button type='submit' class='ui green button'>Search</button>
                    </div>
                </form>
            </div>
            <div class="ui container">
                <%@include file="message.jsp" %>
                <table border='1' width='100%' class='ui celled table'>
                    <thead>
                        <tr>
                            <th class='center aligned' style='padding: 30px'>Student Name</th>
                            <th class='center aligned' style='padding: 30px'>Contact No</th>
                            <th class='center aligned' style='padding: 30px'>Response</th>
                            <th class='center aligned' style='padding: 30px'>Delete Response</th>
                        </tr>
                    </thead>
                    <%
    for (Student s : list) {
    out.print("<tr class='center aligned'><td>" + s.getStuName() + "</td><td>" + s.getStuContact() + "</td><td>" + s.getResponse()
    + "</td><td><a class='ui red button' href='DeleteResponse?id=" + s.getId5() + "'>Delete Response</a></td></tr>");
    }
                    %>

                </table>
            </div>
        </div><br><br>
        <div class="footer">
            <%@include file="Footer.html" %>
        </div>
    </body>
</html>
