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
		            <a class="navbar-brand">TEND<i class="fa fa-circle"></i>SS</a>
		        </div>
		        <div class="navbar-collapse collapse">
		            <ul class="nav navbar-nav navbar-right">
		            	<li class="active"><a href="${createLink(uri: '/')}">HOME</a></li>
		                <sec:ifLoggedIn>
		                    <li class="dropdown">
		                    	<a href="#" class="dropdown-toggle" data-toggle="dropdown">
		                    		<font style="text-transform: uppercase;"><sec:username/></font> <b class="caret"></b>
		                    	</a>
		                    	<ul class="dropdown-menu">
		                    		<li><g:link controller="user" action="edit" id="${sec.loggedInUserInfo(field: 'id')}">ACCOUNT</g:link></li>
		                    		<li class="divider"></li>
		                    		<li><g:link controller="logout">LOGOUT</g:link></li>
		                    	</ul>
		                    </li>
		                </sec:ifLoggedIn>
		                <sec:ifNotLoggedIn>
		                	<li><a href="#signUp">SIGN UP</a></li>
		                	<li><g:link controller="login" action="auth">SIGN IN</g:link></li>
		                </sec:ifNotLoggedIn>
		            </ul>
		        </div>
		    </div>
		</div>
		
		<g:layoutBody/>
		
		<!-- ABOUT SECTION -->
		<div id="r">
			<div class="container">
				<div class="row centered">
					<div class="col-lg-8 col-lg-offset-2">
						<h4>WE ARE THE STEWARDS OF THE OPEN SOURCE DEFINITION.</h4>
						<p>The Open Source Initiative (OSI) is a non-profit corporation with global scope formed to educate about and advocate for the benefits of open source and to build bridges among different constituencies in the open source community.</p>
					</div>
				</div><!-- row -->
			</div><!-- container -->
		</div>
		
		<!-- COPYRIGHT SECTION -->
		<div id="f">
			<div class="container">
				<div class="row centered">
					<p style="color: white">Copyright © TendOSS, 2014</p>
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
