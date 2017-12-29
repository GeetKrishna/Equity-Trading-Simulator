<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Broker Login</title>

	<!--     Bootstrap Core CSS -->
    <link href="<c:out value="${pageContext.request.contextPath}"/>/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

	<!--     MetisMenu CSS -->
    <link href="<c:out value="${pageContext.request.contextPath}"/>/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

	<!--     Custom CSS -->
    <link href="<c:out value="${pageContext.request.contextPath}"/>/dist/css/sb-admin-2.css" rel="stylesheet">

	<!--     Custom Fonts -->
    <link href="<c:out value="${pageContext.request.contextPath}"/>/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body style="border-color: green; background-image: url('${pageContext.request.contextPath}/images/greenstripe.jpg'); background-repeat: no-repeat; background-attachment: fixed; background-size: 100% 100%;">
	<div class="container" align="center">
		<img align="middle" alt="Baba Broker" style="padding-top: 17px"
			src="<c:out value="${pageContext.request.contextPath}"/>/images/BabaBrokerGreenLogoDecent.png">
	</div>

	
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default" style="border-color: #E7DD23;">
                    <div class="panel-heading"  style="background-color: rgb(24, 183, 73); color: white; font-size: 16px">
                        <h3 class="panel-title"><b>Please Sign In</b></h3>
                    </div>
                    <div class="panel-body">
                        <form role="form" action="<c:out value="${pageContext.request.contextPath}"/>/login.htm" method="post">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Username" name="username"  autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="password" type="password" value="">
                                </div>
                                <label style="color: red">
                                    <c:out value="${message}"></c:out>
                                    </label>
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                    </label>
                                    
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                             <input type="submit" value="Login" class="btn btn-lg btn-success btn-block">
                               <%--  <a href="<c:out value="${pageContext.request.contextPath}"/>/jsp/viewfills.jsp" class="btn btn-lg btn-success btn-block">Login</a>
                         --%>    </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

<!--     jQuery -->
    <script src="<c:out value="${pageContext.request.contextPath}"/>/bower_components/jquery/dist/jquery.min.js"></script>

<!--     Bootstrap Core JavaScript -->
    <script src="<c:out value="${pageContext.request.contextPath}"/>/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!--     Metis Menu Plugin JavaScript -->
    <script src="<c:out value="${pageContext.request.contextPath}"/>/bower_components/metisMenu/dist/metisMenu.min.js"></script>

<!--     Custom Theme JavaScript -->
    <script src="<c:out value="${pageContext.request.contextPath}"/>/dist/js/sb-admin-2.js"></script>

</body>

</html>