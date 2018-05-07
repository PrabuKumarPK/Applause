<!DOCTYPE html>
<html lang="en">
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <head>
  	<link rel="stylesheet" href="https://unpkg.com/bootstrap-material-design@4.1.1/dist/css/bootstrap-material-design.min.css" integrity="sha384-wXznGJNEXNG1NFsbm0ugrLFMQPWswR3lds2VeinahP8N0zJw9VWSopbjv2x7WCvX" crossorigin="anonymous">
  </head>
  <style type="text/css">
  	.form-input
  	{
  		width: 50%;
  	padding-top: 1%;
  	}
  	.form-group {
    margin-bottom: 0rem;
	}
	.modal {
    top: 142px;
    }
  
  </style>
  <body>
  <nav class="navbar navbar-expand-lg navbar-light bg-light  ">
  		<button type="button" class="btn btn-primary mr-sm-2" data-toggle="modal" data-target="#exampleModal" id="register">
  				Register
		</button>
  </nav>
  	<form:form action="newEmployee" method="post" commandName="userForm">
  <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Register</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      	<div class="form-group">
	    <label for="exampleInputEmail1" class="bmd-label-floating" >Email address</label>
	    <form:input type="email" class="form-control form-input" id="exampleInputEmail1" path="email" onclick='getemail()'></form:input>
	    <span class="bmd-help">We'll never share your email with anyone else.</span>
	  </div>
	  <div class="modal-body">
      	<div class="form-group">
	    <label for="username" class="bmd-label-floating" >UserName</label>
	    <form:input type="text" class="form-control form-input" id="user_name" path="user_name"></form:input>
	  </div>
	  <div class="form-group">
	    <label for="exampleInputPassword1" class="bmd-label-floating">Password</label>
	    <form:input type="password" class="form-control form-input" id="exampleInputPassword1" path="password"></form:input>
	  </div>
	  <input type="submit" class="btn btn-primary btn-raised btn-nrml" value="Register">
      </div>
     
    </div>
  </div>
</div>
</div>
</form:form>
<form:form action="login" method="post" commandName="userForm">
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
<div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
      	<h5 class="modal-title" id="exampleModalLabel">Login</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
		<div class="form-group">
			 <label for="useremail" class="bmd-label-floating" >Email address</label>
			 <form:input type="email" class="form-control form-input" id="exampleInputEmail1" path="email" onclick='getemail()'></form:input>
		</div>
	
		<div class="form-group">
	    	<label for="exampleInputPassword1" class="bmd-label-floating">Password</label>
	    	<form:input type="password" class="form-control form-input" id="exampleInputPassword1" path="password"></form:input>
	  	</div>
	  	</div>
	  	</div>
	  </div>
</div>

</form:form>
  </body>
 
  	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://unpkg.com/popper.js@1.12.6/dist/umd/popper.js" integrity="sha384-fA23ZRQ3G/J53mElWqVJEGJzU0sTs+SvzG8fXVWP+kJQ1lwFAOkcUOysnlKJC33U" crossorigin="anonymous"></script>
<script src="https://unpkg.com/bootstrap-material-design@4.1.1/dist/js/bootstrap-material-design.js" integrity="sha384-CauSuKpEqAFajSpkdjv3z9t8E7RlpJ1UP0lKM/+NdtSarroVKu069AlsRPKkFBz9" crossorigin="anonymous"></script>
<script>$(document).ready(function() { $('body').bootstrapMaterialDesign(); });</script>
<script type="text/javascript">
	$("#register").click(function(){
		$('#exampleModal').modal('show') 
	});
	 
</script>
</html>