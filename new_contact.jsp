<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <title>Java engineering Test</title>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <!-- Include CSS File Here -->
 <link href="stylesheets/style.css" rel="stylesheet"  type='text/css'>

 </head>
<body>
		<div id="first">
				 <div id="dHeader">
				 		<h4>Welcome  - Java engineering Test<br>
						    Here at Save the Children we currently rely on an API engine to take our donations and make sure <br>
						    that the data can then be consumed by our third part systems .<br><br>
						    A simple Java REST API service with an end point that will be able to take a users <br>
						    information and then store that information.</h4>
				 </div>
				 <div id="dForm">
					 <form action="buindServlet"  method="post" >
						        <div id="dId" class="row">
									 <p><label for="id">Customer ID </label>:</p>
									 <p><input id="id" type="text" name="id" placeholder="Customer ID"/></p>
								 </div>
								<div id="dName" class="row">
									<p><label for="name">Customer Name</label>:</p>
									<p><input id="name" type="text" name="name" placeholder="Your name.."/></p>
								</div>
								<div id="dCompany" class="row">
									<p><label for="company">Company</label>:</td>
									<p><input id="company" type="text" name="company" placeholder="Your company name.."/></td>
								</div>
						         
								<table align="center">
									<tr> 
									<td colspan="1" align="left"> <input id="submit" name="submit" type="submit" value="Save Consumer" /> </td>
									<td colspan="1" align="right"><input id="reset" name="reset" type="reset" value="Reset" /></td>
								    </tr>
								</table>
					</form>
				</div>
				<div id="sLogo">
					   <img id="logo" src="./images/logo.png">
				</div>
	</div>
</body>
</html>