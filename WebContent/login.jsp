<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap-them.min.css">
<link href="bootstrap/css/formpage.css" rel="stylesheet">
</head>
<body>
	<div class="container-fluid col-sm-10 col-sm-push-1"
		style="background-color: #FAFAFA">
		<div class="panel panel-primary col-sm-4 col-sm-push-4">
			<form method="post" action="check-login">
				<input type="text" name="tfPhonenumber" class="form-control"
					placeholder="Phone number" autofocus> <input
					type="password" name="tfPassword" class="form-control"
					placeholder="Password" required>
				<p id="thongbao" style="color: red; margin-top: 15px"></p>
				<div class="#">
					<button class="btn btn-primary col-sm-12" name="btLogin"
						type="submit">Login</button>
				</div>
			</form>
		</div>
	</div>

	<script type="text/javascript" src="bootstrap/js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>