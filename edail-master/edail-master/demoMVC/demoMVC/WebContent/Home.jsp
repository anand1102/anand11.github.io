<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.cognizant.edialgonsis.model.Medicare_Services"%>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Bootstrap core CSS -->

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>
<h1>welcome</h1>
Welcome <%=session.getAttribute("username") %>




<a href="add_medicare_services.jsp">Add new Medicare Services</a>
<!--Table-->
 <%  List<Medicare_Services> list=(List<Medicare_Services>)request.getAttribute("medlist"); %>
  <form action="MedicareListController" method="post" id="medform">      
<table class="table table-striped w-auto">

  <!--Table head-->
  <thead>
    <tr>
      <th>Medicare_service_id</th>
      <th>Name</th>
      <th>Amount</th>
    </tr>
  </thead>
  <!--Table head-->

  <!--Table body-->
     
  <tbody>

     <% for(Medicare_Services m: list) 
        {%>
         <tr class="table-info">
      <td><%= m.getId() %></td>
     
      <td><input type="hidden" name="medicare" value="<%=m.getId()%>" ></td>
      <td><a href="FetchController?mid=<%=m.getId()%>"><%= m.getName() %></a></td>
      <td><%=m.getAmount() %></td>
       </tr>
     <%} %>
  
  </tbody>
  <!--Table body-->


</table>
</form>


<!--Table-->
</body>
</html>