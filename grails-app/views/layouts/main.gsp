<%@ page import="tendoss.User; grails.plugin.springsecurity.SpringSecurityService" %>
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="fr" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="fr" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="fr" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="fr" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    
	    <title>TENDOSS - Tender Open Source Software</title>
	    
	    <link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
	    <link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
	    <link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">
	    
	    <!-- Bootstrap core CSS -->
	   	<link href="${resource(dir: 'css', file: 'bootstrap.css')}" rel="stylesheet">
	   	<link href="${resource(dir: 'css', file: 'font-awesome.min.css')}" rel="stylesheet">
	
		<!-- Custom styles for this template -->
	   	<link href="${resource(dir: 'css', file: 'mainstyle.css')}" rel="stylesheet">
	   	
	   	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	    <!--[if lt IE 9]>
	      	<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	      	<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
	    <![endif]-->
	    
	    <g:layoutHead/>
		<r:layoutResources/>
	</head>
	<body>
		<!-- NAVIGATION SECTION -->
		<div class="navbar navbar-inverse navbar-fixed-top">
		    <div class="container">
		        <div class="navbar-header">
		            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
		                <span class="icon-bar"></span>
		                <span class="icon-bar"></span>
		                <span class="icon-bar"></span>
		            </button>
		            <a class="navbar-brand" href="${createLink(uri: '/')}">TEND<i class="fa fa-circle"></i>SS</a>
		        </div>
		        <div class="navbar-collapse collapse">
		            <ul class="nav navbar-nav navbar-right">
		                <sec:ifLoggedIn>
		                    <li class="active"><a href="#">WELCOME <font style="text-transform: uppercase;"><sec:username/></font></a></li>
		                    <li><a href="${createLink(controller: 'logout')}">LOGOUT</a></li>
		                    <li><a href="${createLink(controller: 'user', action: 'edit', id: sec.loggedInUserInfo(field: 'id'))}">EDIT PROFILE</a></li>
		                </sec:ifLoggedIn>
		                <sec:ifNotLoggedIn>
		                    <li class="active"><a href="${createLink(controller: 'index')}">LOGIN</a></li>
		                    <li><a data-toggle="modal" data-target="#myModal" href="#myModal">MODAL LOGIN</a></li>
		                    <li><a href="${createLink(controller: 'user',action: 'create')}">SIGN UP</a></li>
		                </sec:ifNotLoggedIn>
		            </ul>
		        </div>
		    </div>
		</div>
		
		<g:layoutBody/>
		<!-- COPYRIGHT SECTION -->
		<div id="r">
			<div class="container">
				<div class="row centered">
					<div class="col-lg-8 col-lg-offset-2">
						<h4>© 2014 TendOSS</h4>
					</div>
				</div>
			</div>
		</div>
		
		<!-- MODAL FOR LOGIN -->
		<!-- Modal -->
		<div class="modal fade" id="myModal" tabIndex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">Sign in</h4>
					</div>
					<g:form controller="j_spring_security_check" method="POST">
						<div class="modal-body">
							<div class="form-group">
								<input type="text" class="form-control" name="j_username" id="j_username" placeholder="Enter your username">
							</div>
							<div class="form-group">
								<input type="password" class="form-control" name="j_password" id="j_password" placeholder="Enter your password">
							</div>
						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-danger">Connexion</button>
						</div>
					</g:form>
				</div>
			</div>
		</div>
		
		<!-- Bootstrap core JavaScript
	    ================================================== -->
	    <!-- Placed at the end of the document so the pages load faster -->
	    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	    <script src="js/bootstrap.min.js"></script>
		
		<r:layoutResources />
	</body>
</html>
