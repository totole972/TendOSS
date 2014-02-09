<html>
	<head>
		<meta name="layout" content="main">
	</head>
	<body>
		<!-- SIGN IN HEADER -->
		<div id="blue">
			<div class="container">
				<div class="row centered">
					<div class="col-lg-8 col-lg-offset-2">
						<h4>SIGN IN TO TENDOSS</h4>
						<p>TAKE PART IN THE LARGEST OPEN SOURCE COMMUNITY</p>
					</div>
				</div>
			</div>
		</div>
		
		<!-- SIGN IN SECTION -->
		<div class="container wb">
			<br><br>
			<g:if test='${flash.message}'>
				<div class="alert alert-danger">
					<strong>Error!</strong> ${flash.message}
				</div>
				<br><br>
			</g:if>
			<div class="col-lg-6 col-lg-offset-3">
				<g:form class="form-signin" controller="j_spring_security_check" method="post">
					<label for="j_username">Username</label>
					<input type="text" class="form-control" name="j_username" id="j_username" required autofocus><br>
					<label for="j_username">Password</label>
					<input type="password" class="form-control" name="j_password" id="j_password" required>
					<br><button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
				</g:form>
				<p><br><br></p>
			</div>
		</div>
	</body>
</html>