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
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet">
    <script src="http//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
    <script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
    <g:layoutHead/>
    <g:javascript library="application"/>
    <r:layoutResources />
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${createLink(uri: '/')}">TendOSS</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">

            </ul>
            <ul class="nav navbar-nav navbar-right">
                <sec:ifLoggedIn>
                    <li><a href="#">Welcome <sec:username/></a></li>
                    <li><a href="${createLink(controller:"logout")}">Logout</a></li>
                    <li><a href="${createLink(controller:"user", action: 'edit', id: sec.loggedInUserInfo(field: 'id'))}">Edit profile</a></li>
                </sec:ifLoggedIn>
                <sec:ifNotLoggedIn>
                    <li><a href="${createLink(controller:"index")}">Login</a></li>
                    <li><a href="${createLink(controller:"User" ,action: 'create')}">Sign up</a></li>
                </sec:ifNotLoggedIn>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>

<div class="container">
    <div class="starter-template">
        <g:layoutBody/>
    </div>
</div>

%{--<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="${createLink(uri: '/')}"><img src="${resource(dir: 'images', file: 'TendOSS_logo.png')}" alt="TendOSS"/></a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <sec:ifLoggedIn>
                    Welcome <sec:username/>
                    <a href="${createLink(controller:"logout")}">Logout</a>&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="${createLink(controller:"user", action: 'edit', id: sec.loggedInUserInfo(field: 'id'))}">Edit profile</a>
                </sec:ifLoggedIn>
                <sec:ifNotLoggedIn>
                    <a href="${createLink(controller:"login" ,action: 'auth')}">Login</a>&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="${createLink(controller:"User" ,action: 'create')}">Sign up</a>
                </sec:ifNotLoggedIn>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
%{--
<sec:ifNotLoggedIn>
    <!--TODO :  render login-->
    <g:layoutBody/>
</sec:ifNotLoggedIn>
<sec:ifLoggedIn>
    <g:layoutBody/>
</sec:ifLoggedIn>
-->--}%
<div class="footer" role="contentinfo"></div>
<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
<r:layoutResources />
</body>
</html>
