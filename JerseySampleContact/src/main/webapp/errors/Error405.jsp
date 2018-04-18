<%@ page isErrorPage="true" import="java.io.*" contentType="text/plain"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="stylesheets/global.css" rel="stylesheet"  type='text/css'>
<link href="stylesheets/style.css" rel="stylesheet"  type='text/css'>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Message Error 405: </h3>
	 <div class="container">
		Message:
		<%=exception.getMessage()%>
		
		StackTrace:
		<%
			StringWriter stringWriter = new StringWriter();
			PrintWriter printWriter = new PrintWriter(stringWriter);
			exception.printStackTrace(printWriter);
			out.println(stringWriter);
			printWriter.close();
			stringWriter.close();
		%>
	</div>
	
</body>
</html>