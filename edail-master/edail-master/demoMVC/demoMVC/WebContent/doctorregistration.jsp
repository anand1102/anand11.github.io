<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.cognizant.edialgonsis.model.Medicare_Services"%>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<style>
.nav-item
{
color:white;
}
.bg-img {
  /* The image used */
  background-image: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)),url("docpic.jpg");

  min-height:1347px;

  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;

  /* Needed to position the navbar */
  position: relative;
}
.class1 .class2 {
  position: absolute;
  top: 0;
  background: rgb(0, 0, 0); /* Fallback color */
  background: rgba(0, 0, 0, 0); /* Black background with 0.5 opacity */
  width: 100%;
  padding: 5px;
}
</style>
<meta charset="ISO-8859-1">
<!-- Font Awesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Bootstrap core CSS -->

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<title></title>
</head>
<body>

<div class="row">
<div class="col-6">
<div class="class1">
 <div class="bg-img"></div>
<div class="class2">
<nav class="navbar navbar-expand-lg">
  <a class="navbar-brand" href="#" style="color:white">E-Diagnosis</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="#" style="color:white">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#" style="color:white">Features</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#" style="color:white">Contact Us</a>
      </li>
    </ul>
  </div>
</nav>
</div>
</div>
</div>
<div class="col-6">

<!-- Default form contact -->
<form class="text-center border border-light p-5" method="post" action="RegistrationController_Doctor">

    <p class="h4 mb-4">Doctor Registration</p>

    <!-- Name -->
    <input type="text" id="defaultContactFormName" class="form-control mb-4" placeholder="FirstName" name="firstname">
    <input type="text" id="defaultContactFormName" class="form-control mb-4" placeholder="LastName" name="lastname">
    <input type="text" id="defaultContactFormName" class="form-control mb-4" placeholder="Age" name="age">
    
 <!-- Subject -->
   
    <select class="browser-default custom-select mb-4" placeholder="Gender" name="gender">
        <option value="" selected disabled>Gender</option>
        <option value="male">Male</option>
         <option value="female">Female</option>
     
    </select>

 <input type="date" id="defaultContactFormName" class="form-control mb-4" placeholder="DOB" name="dob">
 <input type="text" id="defaultContactFormName" class="form-control mb-4" placeholder="Contact Number" name="contactnumber">
 <input type="text" id="defaultContactFormName" class="form-control mb-4" placeholder="Alt Contact Number" name="alt_contact_number">
    <!-- Email -->
    <input type="email" id="defaultContactFormEmail" class="form-control mb-4" placeholder="E-mail" name="email">

     <input type="password" id="defaultContactFormEmail" class="form-control mb-4" placeholder="Password" name="password">
    <!-- Message -->
    <div class="form-group">
        <textarea class="form-control rounded-0" id="exampleFormControlTextarea2" rows="2" placeholder="Address Line 1" name="addressline1"></textarea>
    </div>
     <div class="form-group">
        <textarea class="form-control rounded-0" id="exampleFormControlTextarea2" rows="2" placeholder="Address Line 2" name="addressline2"></textarea>
    </div>
    <input type="text" id="defaultContactFormName" class="form-control mb-4" placeholder="City" name="city">
<input type="text" id="defaultContactFormName" class="form-control mb-4" placeholder="State" name="state">
<input type="text" id="defaultContactFormName" class="form-control mb-4" placeholder="Zipcode" name="zipcode">
<input type="text" id="defaultContactFormName" class="form-control mb-4" placeholder="Degree" name="degree">
<input type="text" id="defaultContactFormName" class="form-control mb-4" placeholder="Speciality" name="speciality">
 

    <select class="browser-default custom-select mb-4" placeholder="Work Hours" name="workhours">
        <option value="" selected disabled>Select Working Hours</option>
        <option value="9.00am-12.00pm">9.00am-12.00pm</option>
         <option value="4.00pm-10.00pm">4.00pm-10.00pm</option>
    </select>
  
    <input type="text" id="defaultContactFormName" class="form-control mb-4" placeholder="Hospital/Clinic Name" name="hospital_name">
    <%  List<Medicare_Services> list=(List<Medicare_Services>)request.getAttribute("doclist"); %>
 <select class="browser-default custom-select mb-4" name="medicare_Services">
        <option value="" selected disabled>Select medicare Services</option>
        <% for(Medicare_Services m: list) 
        {
        %>
        	<option value= "<%= m.getId() %>"><%= m.getName() %></option>
       <%} %> 
         
    </select>
  
    <!-- Send button -->
    <button class="btn btn-info btn-block" type="submit">Register</button>

</form>
<!-- Default form contact -->
</div>
</div>

</body>
</html>