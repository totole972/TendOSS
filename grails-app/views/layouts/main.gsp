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
		<title><g:layoutTitle default="TendOss"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
		<link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">
        <script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
		<g:layoutHead/>
		<g:javascript library="application"/>		
		<r:layoutResources />
	</head>
	<body>
		<div id="Logo">
            <a href="${createLink(uri: '/')}"><img src="${resource(dir: 'images', file: 'TendOSS_logo.png')}" alt="TendOSS"/></a>

            <span id="logger" style="float: right;margin-right: 10%;">
                <sec:ifLoggedIn>
                    Welcome <sec:username/>
                    <a href="${createLink(controller:"logout")}">Logout</a>&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="${createLink(controller:"user", action: 'edit', id: sec.loggedInUserInfo(field: 'id'))}">Edit profile</a>
                </sec:ifLoggedIn>
                <sec:ifNotLoggedIn>
                    <a href="${createLink(controller:"login" ,action: 'auth')}">Login</a>&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="${createLink(controller:"User" ,action: 'create')}">Sign up</a>

                </sec:ifNotLoggedIn>
            </span>
        </div>

        <sec:ifNotLoggedIn>
            <!--TODO :  render login-->

            <g:layoutBody/>
        </sec:ifNotLoggedIn>
        <sec:ifLoggedIn>
    		<g:layoutBody/>
        </sec:ifLoggedIn>
		<div class="footer" role="contentinfo"></div>
		<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
		<r:layoutResources />
	</body>
</html>
