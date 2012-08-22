<!--
  Java Programming
  Chapter 12
  Debugging Assignment
-->
<HTML>
<HEAD>
<TITLE>JSP Debugging</TITLE>
</HEAD>

<BODY>
<% import java.io.*; %>
<% import java.util.Date; %>
<% import java.util.Enumeration; %>

<%
    response.setContentType("MIME");
    Date today = new Date(12,20,2004);

    Date created = new Date(session.getCreationTime());
    Date lastAccessed = new Date(session.getLastAccessedTime());

    out.print("<h1>Today is " );
    out.print(today); 
    out.print("</h1>" );
    out.print("This session has the following characteristics:<br>" );
    out.println("<br>ID: ");
    <%= session.getId(); %>
    out.println("Created: " + created);
    out.println("Last Accessed: " + lastAccessed);
    out.println("<br>Max Inactive Interval: " +
                    session.getMaxInactiveInterval());
%>
</BODY>
</HTML>
