<%
   
   String message2 = (String)session.getAttribute("message2");
   String message3 = (String)session.getAttribute("message3");
   String message4 = (String)session.getAttribute("message4");
   String message5 = (String)session.getAttribute("message5");
   String message6 = (String)session.getAttribute("message6");
   String message7 = (String)session.getAttribute("message7");
   String message8 = (String)session.getAttribute("message8");
  
 %>
 
 
 <%
      
 if(message2 != null)
{
%>

<div class="ui red message"><%= message2%></div>

<%
    session.removeAttribute("message2");
}
%>
<%
 if(message3 != null)
{
%>

<div class="ui green message"><%= message3%></div>

<%
    session.removeAttribute("message3");
}
%>
<%
 if(message4 != null)
{
%>

<div class="ui red message"><%= message4%></div>

<%
    session.removeAttribute("message4");
}
%>
<%
 if(message5 != null)
{
%>

<div class="ui green message"><%= message5%></div>

<%
    session.removeAttribute("message5");
}
%>
<%
 if(message6 != null)
{
%>

<div class="ui red message"><%= message6%></div>

<%
    session.removeAttribute("message6");
}
%>
<%
 if(message7 != null)
{
%>

<div class="ui green message"><%= message7%></div>

<%
    session.removeAttribute("message7");
}
%>
<%
 if(message8 != null)
{
%>

<div class="ui red message"><%= message8%></div>

<%
    session.removeAttribute("message8");
}
%>
