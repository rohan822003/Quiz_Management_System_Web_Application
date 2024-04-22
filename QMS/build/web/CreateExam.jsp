<%@page import="java.sql.*"%>   
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Exam</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.5.0/semantic.min.css" integrity="sha512-KXol4x3sVoO+8ZsWPFI/r5KBVB/ssCGB5tsv2nVOKwLg33wTFP3fmnXa47FdSVIshVTgsYk/1734xSk9aFIa4A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.js" integrity="sha512-+k1pnlgt4F1H8L7t3z95o3/KO+o78INEcXTbnoJQ/F2VqDVhWoaiVml/OEHv9HsVgxUaVW+IbiZPUJQfF/YxZw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <link href="home.css" rel="stylesheet" type="text/css"/>
        <style>
            .exam{
                margin-top: 60px;
            }
            #save{
                text-align: center;
            }
            .footer {
               
                left: 0;
                bottom: 0;
                width: 100%;
                background-color: #006666;
                color: white;
                text-align: center;
                padding: 20px 0;
            }
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
            <div class="exam">
                <div class="ui middle aligned center aligned grid">  
                    <div class="ui stacked segment" id="CreateEx">
                        <%@include file="message.jsp" %>
                        <form action="CExamServlet" method="post" class="ui large form">
                            <h1 class="ui center aligned header">Create Exam</h1>
                            <div class="ui divider"></div>
                            <label class="ui teal label">Exam Name:</label><input type="text" name="examName" placeholder="Enter exam name" required/><br><br>
                            <label class="ui teal label">Exam Date:</label><input type="date" name="examDate" required /><br><br>
                            <div id="save">
                            <button type="submit" class="ui positive button">Save</button> 
                            </div>
                        </form> 
                    </div>
                </div>
            </div> 
        </div>
        <div class="footer">
            <div class="ui container">
                <p>Created on 10 April 2024 - All Rights Reserved.</p>
            </div>
        </div>
    </body>
</html>
