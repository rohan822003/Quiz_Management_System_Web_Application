<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.5.0/semantic.min.css" integrity="sha512-KXol4x3sVoO+8ZsWPFI/r5KBVB/ssCGB5tsv2nVOKwLg33wTFP3fmnXa47FdSVIshVTgsYk/1734xSk9aFIa4A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link href="home.css" rel="stylesheet" type="text/css"/>
        <style>
            #log{
                margin-top: 100px;
                width: 500px;
                box-shadow: rgba(0, 0, 0, 0.3) 0px 19px 38px, rgba(0, 0, 0, 0.22) 0px 15px 12px;
            }
            #danger{
                text-align: center;
            }
            #loginbtn{
                text-align: center;
            }
        </style>
    </head>
    <body>
        <div class="navbar">
            <div class="nav">
                <h1 class="logo">QuizOn</h1>
                <ul>
                    <li><a href="index.html">Home</a></li>
                    <li><a href="Login.jsp">Login</a></li>
                    <li><a href="Register.jsp">Register</a></li>
                </ul>
            </div>
            <div class="login">
                <div class="ui middle aligned center aligned grid">
                    <div class="ui piled segment" id="log">
                        <%@include file="message.jsp" %>
                        <form action="loginServlet" method="post" class="ui large form">
                            <h1 class="ui center aligned header">Login</h1>
                            <div class="ui divider"></div>
                            <br>
                            <label class="ui teal label">Username:</label>
                            <input type="email" name="username" placeholder="Enter username" required/>
                            <br><br>
                            <label class="ui teal label">Password:</label>
                            <input type="password" name="password" placeholder="Enter Password" required/>
                            <br><br>
                            <div id="loginbtn">
                                <button type="submit" value="login" class="ui positive button" >Login</button>
                            </div>
                           
                            <div class="ui divider"></div>
                            <div class='ui danger message' id='danger'>
                                New here? <a href="Register.jsp">Sign Up</a>
                            </div>
                        </form>
                    </div>

                </div>

            </div>
        </div>
        
    </body>
</html>

