<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
		<title>TENDOSS - Tender Open Source Software</title>
		
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
          			<a class="navbar-brand" href="#">TEND<i class="fa fa-circle"></i>SS</a>
				</div>
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav navbar-right">
						<li class="active"><a href="#">HOME</a></li>
						<li><a data-toggle="modal" data-target="#myModal" href="#myModal">LOGIN</a></li>
					</ul>
				</div>
			</div>
		</div>
		
		<!-- HEADER SECTION -->
		<div id="headerwrap">
			<div class="container">
				<div class="row centered">
					<div class="col-lg-8 col-lg-offset-2">
						<h1>Be part of the <b>Open Source Initiative</b></h1>
						<h2>Grow Up and Join Us</h2>
					</div>
				</div>
			</div>
		</div>
		
		<!-- WEB APPLICATION SECTION -->
		<div class="container w">
			<div class="row centered">
				<br><br>
				<div class="col-lg-4">
					<i class="fa fa-laptop"></i>
					<h4>APPLICATION STATUS</h4>
					<ul>
						<li>App version: <g:meta name="app.version"/></li>
						<li>Grails version: <g:meta name="app.grails.version"/></li>
						<li>Groovy version: ${GroovySystem.getVersion()}</li>
						<li>JVM version: ${System.getProperty('java.version')}</li>
						<li>Reloading active: ${grails.util.Environment.reloadingAgentEnabled}</li>
						<li>Controllers: ${grailsApplication.controllerClasses.size()}</li>
						<li>Domains: ${grailsApplication.domainClasses.size()}</li>
						<li>Services: ${grailsApplication.serviceClasses.size()}</li>
						<li>Tag Libraries: ${grailsApplication.tagLibClasses.size()}</li>
					</ul>
				</div>
				<div class="col-lg-4">
					<i class="fa fa-laptop"></i>
					<h4>INSTALLED PLUGINS</h4>
					<g:each var="plugin" in="${applicationContext.getBean('pluginManager').allPlugins}">
						<li>${plugin.name} - ${plugin.version}</li>
					</g:each>
				</div>
			</div>
			<br>
			<br>
		</div>
		
		<!-- SIGN UP SECTION -->
		<div id="dg">
			<div class="container wb">
				<div class="row centered">
					<br><br>
					<div class="col-lg-8 col-lg-offset-2">
						<h4>CREATE AN ACCOUNT</h4>
						<p>TO DO</p>
					</div>
				</div>
			</div>
		</div>
		
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
					<div class="modal-body">
						<div class="row centered">
							<p>TO DO</p>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal">Connexion</button>
					</div>
				</div>
			</div>
		</div>
		
		<!-- Bootstrap core JavaScript
	    ================================================== -->
	    <!-- Placed at the end of the document so the pages load faster -->
	    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	    <script src="js/bootstrap.min.js"></script>

		<r:layoutResources/>
	</body>
</html>