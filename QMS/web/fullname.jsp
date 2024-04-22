<%
   String fullname = (String)session.getAttribute("fullname");
   
   if(fullname != null)
   {
 %>
 
  <div class="ui green message"><%= fullname%></div>
 
 
 <%
       session.removeAttribute("fullname");
    }

%>