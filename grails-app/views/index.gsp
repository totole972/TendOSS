<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
	</head>
	<body>
		<!-- HEADER SECTION -->
		<div id="headerwrap">
			<div class="container wb" style="padding-top: 25px;">
				<h2>Join TendOSS today</h2>
				<br><br>
				<div class="col-lg-6 col-lg-offset-3">
					<g:form controller="user" action="subscribe">
						<fieldset>
							<label style="color: white;" for="username">Pick a username</label>
							<input type="text" class="form-control" name="username" id="username" required autofocus><br>
							<label style="color: white;" for="emailAddress">Email address</label>
							<input type="text" class="form-control" name="emailAddress" id="emailAddress" required><br>
							<label style="color: white;" for="password">Create a password</label>
							<input type="password" class="form-control" name="password" id="password" required>
							<br><button type="submit" class="btn btn-lg btn-warning btn-block">Create my account</button>
						</fieldset>
					</g:form>
				</div>
			</div>
		</div>
		
		<!-- OPEN SOURCE INITIATIVE SECTION -->
		<div class="container wb">
			<div class="row centered">
				<br><br>
				<div class="col-lg-8 col-lg-offset-2">
					<h4>THE OPEN SOURCE INITIATIVE</h4>
					<p>Open source software is software that can be freely used, changed, and shared (in modified or unmodified form) by anyone. Open source software is made by many people, and distributed under <a href="http://opensource.org/licenses">licenses</a> that comply with the <a href="http://opensource.org/definition">Open Source Definition</a>.</p>
				<p><br/><br/></p>
				</div>
				<div class="col-lg-2"></div>
				<div class="col-lg-10 col-lg-offset-1">
					<img class="img-responsive" src="images/munter.png" alt="">
				</div>
			</div>
		</div>
	</body>
</html>