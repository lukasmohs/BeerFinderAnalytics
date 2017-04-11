<%-- 
    Document   : dashboard.jsp
    Created on : Apr 1, 2017, 3:14:53 PM
    Author     : lukasmohs
--%>

<%@page import="edu.cmu.lukasmohs.beerfinderanalytics.Activity"%>
<%@page import="java.util.Date"%>
<%@page import="edu.cmu.lukasmohs.beerfinderanalytics.DashboardModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BeerFinder Analytics</title>
        <%-- CSS Styling --%>
        <style>
            table, th, td {
                border-bottom: 1px solid black;
                padding: 15px;
            }
            table {
                width: 100%;
                border-spacing: 0px;
                font-size: 15px;
            }
            tr:nth-child(even) {background-color: #f5f5f5}
            tr:hover {background-color: #8e81fb}
        </style>
    </head>
    <body>
        <h1>Dashboard of BeerFinder: </h1>
        <h3> Map of the last 25 user locations </h3>
        <div style="height:400px;" id="map"></div>

        <br/>
        <h3> Detail list of the last 25 users </h3>
        <table>
            <tr style="font-size: 20px; text-align:center;">
                <th>Number</th>
                <th>Date</th>
                <th>Location</th>
                <th>Radius </th>
                <th>Device</th>
                <th>Operating System</th>
                <th>Number of Answers</th>
            </tr>
        <%-- Iterate over the last 25 activitites provided by the model --%>
        <% int count = 1; %>
        <% for(Activity activity : DashboardModel.getActivities()) { %>
            <%-- Add each activity to one row and separate the information by fields --%>
            <tr >
                <td><%= count %></td>
                <td><%= new Date(new Long(activity.getTimeStamp())) %></td>
                <td><%= activity.getLatitude() %>; <%= activity.getLongitude() %></td>
                <td> <%= activity.getRadius() %> </td>
                <td><%= activity.getDevice() %></td>
                <td><%= activity.getOs() %></td>
                <td><%= activity.getNumberOfAnswers() %></td>
            </tr>
             <% count++; %>
        <% } %>
        </table>
        <%-- Use Google Maps API to display the location of the last requests --%>
        <script>
            
          function initMap() {
            var myLatLng = {lat: 40.426195, lng: -3.687090};

        // Create a map object and specify the DOM element for display.
        var map = new google.maps.Map(document.getElementById('map'), {
          center: myLatLng,
          scrollwheel: false,
          zoom: 2
        });
        
        <%-- Add labels on the map for each request --%>
        <% int total = count; %>
        <%  count = 1; %>
        <% for(Activity activity : DashboardModel.getActivities()) { %>
            var marker<%= count  %> = new google.maps.Marker({
                map: map,
                position: {lat: <%= activity.getLatitude() %>, lng: <%= activity.getLongitude() %>},
                label: '<%= count %>',
                opacity: 1.0,
                zIndex: <%= total - count %>
            });
            <% count++; %>
        <% } %>
      }

    </script>
    <script src="https://maps.googleapis.com/maps/api/js?key=<%=DashboardModel.getGoogleMapsAPIKey() %>&callback=initMap"
        async defer></script>
    </body>
</html>
