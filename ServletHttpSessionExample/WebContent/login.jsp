<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
</head>
<body bgcolor="#E6E6FA">
<form action="LoginServlet" method="post">
<table align="center">
<tr><th>Welcome To Capgemini</th></tr>
<tr><td span style="color:red">Username: <input type="text" name="user"></td></tr>
<tr><td span style="color:red">Password : <input type="password" name="pwd"></td></tr>
<tr><td span style="color:red"><input type="submit" value="Login"></td></tr>
<tr><td span style="color:yellow"><a href="LoginServlet?" method="GET">Sign IN with GoogleAccount</a></td></tr>
<%-- <% 
	
		
		String user = null;
		if(session.getAttribute("user") != null){
			session.invalidate();
		}
%> --%>
<tr><td>
<script>
var data = { UserPoolId : 'us-east-1_8RwtJVc3O',
        ClientId : '4t1qbq1nno40la3fhprc18rmff'
    };
    var userPool = new AmazonCognitoIdentity.CognitoUserPool(data);
    var cognitoUser = userPool.getCurrentUser();

    if (cognitoUser != null) {
        cognitoUser.getSession(function(err, session) {
            if (err) {
                alert(err);
                return;
            }
            console.log('session validity: ' + session.isValid());
        });
    }
</script>
</td></tr>
<tr><td span style="color:yellow"><a href="https://signin.auth.us-east-1.amazoncognito.com/login?response_type=code&client_id=4t1qbq1nno40la3fhprc18rmff&redirect_uri=http://localhost:8021/ServletHttpSessionExample/LoginServlet3">Sign IN with AWS</a></td></tr>
<!-- <tr><td span style="color:red">Create a new account</td></tr> -->
</table>
</form>
</body>
</html>