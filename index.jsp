<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login form</title>
<link rel="stylesheet" href="css-file/login.css">
</head>
<body>
	<div class="container">
		<h1>Login Page</h1>
		<!-- Heading -->
		<hr>
		<form action="LoginServlet" method="get">
			<!-- Main content of login form -->
			<p>
				Username:* <input type="text" name="Username" required
					placeholder="example@gmail.com">
			</p>
			<p>
				Password:* <input type="password" name="Password" required
					placeholder="abz253">
			</p>

			<!-- submit details -->
			<p>
				Terms: <input type="checkbox" required>
			</p>
			<p>
				<button type="submit">Login in</button>
			</p>
			<p>
				<a href="reg.jsp">
					<button type="button">Sign Up</button>
				</a>
			</p>
		</form>
	</div>
</body>
</html>