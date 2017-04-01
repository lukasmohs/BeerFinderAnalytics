<%-- 
    Document   : dashboard.jsp
    Created on : Apr 1, 2017, 3:14:53 PM
    Author     : lukasmohs
--%>

<%@page import="edu.cmu.lukasmohs.beerfinderanalytics.DashboardModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello to the Beer World!</h1>
        <%= DashboardModel.getActivities() %>
    </body>
</html>
