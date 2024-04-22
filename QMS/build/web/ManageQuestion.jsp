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
            #CreateEx{
                margin-top: 20px;
                width: 700px;
                box-shadow: rgba(0, 0, 0, 0.3) 0px 19px 38px, rgba(0, 0, 0, 0.22) 0px 15px 12px;
            }
            .addQ{
                text-align: center;
            }
            .options-row {
                display: flex;
                align-items: center;
            }

            .options-row label {
                margin-right: 10px;
            }

            .options-row input {
                margin-right: 20px;
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
            <div class="ui middle aligned center aligned grid">  
                <div class="ui stacked segment" id="CreateEx">
                    <%@include file="message.jsp" %>
                    <form action="ExamServlet" method="post" class="ui large form">
                        <h1 class="ui center aligned header">Add Questions</h1>
                        <div class="ui divider"></div>
                        <label class="ui teal label">Select Exam:</label>
                        <select name="dexam" id="dropdown">
                            <% 
                                // Java code to populate dropdown dynamically from the database
                                try {
                                    // Establish database connection
                                    Class.forName("com.mysql.jdbc.Driver");
                                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qms", "root", "Rohan@123");

                                    // Fetch data from the database
                                    Statement stmt = con.createStatement();
                                    ResultSet rs = stmt.executeQuery("SELECT examName FROM examNames");
                                    while(rs.next()) {
                                        String examName = rs.getString("examName");
                                        out.println("<option value='" + examName + "'>" + examName + "</option>");
                                    }

                                    // Close database connection
                                    con.close();
                                } catch(Exception e) {
                                    out.println("Error: " + e);
                                }
                            %>
                        </select><br>
                        <label class="ui teal label">Enter question:</label>
                        <input type="text" name="question" placeholder="Enter your question" required /><br><br>

                        <div class="options-row">
                            <label class="ui teal label">Option 1:</label>
                            <input type="text" name="option1" placeholder="Enter Option 1" required/>
                            <label class="ui teal label">Option 2:</label>
                            <input type="text" name="option2" placeholder="Enter Option 2" required/>
                        </div><br><br>

                        <div class="options-row">
                            <label class="ui teal label">Option 3:</label>
                            <input type="text" name="option3" placeholder="Enter Option 3" required/>
                            <label class="ui teal label">Option 4:</label>
                            <input type="text" name="option4" placeholder="Enter Option 4" required/>
                        </div><br><br> 

                        <label class="ui teal label">Correct Answer:</label>
                        <input type="text" name="answer" placeholder="Enter Correct Answer" required/> <br><br>

                        <div class="addQ">
                            <button type="submit" class="ui positive button">Add</button>
                        </div>

                    </form> 
                </div>
            </div> 
        </div>
       <div class="footer">
            <div class="ui container">
                <p>Created on 10 April 2024 - All Rights Reserved.</p>
            </div>
    </body>
</html>
