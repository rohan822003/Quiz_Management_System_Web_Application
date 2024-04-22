<!DOCTYPE html>

<html>
    <head>
        <title>Quiz Management System</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.5.0/semantic.min.css" integrity="sha512-KXol4x3sVoO+8ZsWPFI/r5KBVB/ssCGB5tsv2nVOKwLg33wTFP3fmnXa47FdSVIshVTgsYk/1734xSk9aFIa4A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link href="home.css" rel="stylesheet" type="text/css"/>
        <style>
            #save{
                text-align: center;
                
            } 
        </style>
    </head>
    <body>
        <div class="navbar">
            <div class="nav">
                <h1 class="logo">QuizOn</h1>
                <ul>
                    <li><a href="StudentLog.jsp">Home</a></li>
                    <li><a href="StudentExam">Exams</a></li>
                    <li><a href="Results">Results</a></li>
                    <li><a href="index.html">Logout</a></li>
                </ul>
            </div>
            <div class="content">
                <h1>Welcome to QuizOn</h1>
   
        </div>
        </div>
        <br><br>
        <div class="response">
                <div class="ui middle aligned center aligned grid">  
                    <div class="ui stacked segment" id="resp">
                        <%@include file="message.jsp" %>
                        <form action="StudentResponse" method="post" class="ui large form">
                            <h1 class="ui center aligned header">Send Response or Query</h1>
                            <div class="ui divider"></div>
                            <label class="ui teal label">Student Name:</label><input type="text" name="stuName" placeholder="Enter your name" required/><br><br>
                            <label class="ui teal label">Contact No:</label><input type="tel" name="contact" pattern="[7-9][0-9]{9}" placeholder="Enter your contact No" required /><br><br>
                            <label class="ui teal label">Response/Query:</label><input type="text" name="response" placeholder="Enter your Response/Query" required/><br><br>
                            <div id="save">
                            <button type="submit" class="ui positive button">Save</button> 
                            </div>
                        </form> 
                    </div>
                </div>
            </div>
        <br><br><br><br>
           <div class="footer">
        <%@include file="Footer2.html" %>
            </div>
    </body>
</html>
