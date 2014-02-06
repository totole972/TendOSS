<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
	</head>
	<body>
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
	</body>
</html>