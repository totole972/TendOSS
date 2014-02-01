<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>TendOSS Application</title>
    <!--<style type="text/css" media="screen">
			#status {
				background-color: #eee;
				border: .2em solid #fff;
				margin: 2em 2em 1em;
				padding: 1em;
				width: 12em;
				float: left;
				-moz-box-shadow: 0px 0px 1.25em #ccc;
				-webkit-box-shadow: 0px 0px 1.25em #ccc;
				box-shadow: 0px 0px 1.25em #ccc;
				-moz-border-radius: 0.6em;
				-webkit-border-radius: 0.6em;
				border-radius: 0.6em;
			}

			.ie6 #status {
				display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
			}

			#status ul {
				font-size: 0.9em;
				list-style-type: none;
				margin-bottom: 0.6em;
				padding: 0;
			}

			#status li {
				line-height: 1.3;
			}

			#status h1 {
				text-transform: uppercase;
				font-size: 1.1em;
				margin: 0 0 0.3em;
			}

			#page-body {
				margin: 2em 1em 1.25em 18em;
			}

			h2 {
				margin-top: 1em;
				margin-bottom: 0.3em;
				font-size: 1em;
			}

			p {
				line-height: 1.5;
				margin: 0.25em 0;
			}

			#controller-list ul {
				list-style-position: inside;
			}

			#controller-list li {
				line-height: 1.3;
				list-style-position: inside;
				margin: 0.25em 0;
			}

			@media screen and (max-width: 480px) {
				#status {
					display: none;
				}

				#page-body {
					margin: 0 1em 1em;
				}

				#page-body h1 {
					margin-top: 0;
				}
			}
		</style>
        <style type='text/css' media='screen'>
        #login {
            margin: 15px 0px;
            padding: 0px;
            text-align: center;
        }

        #login .inner {
            width: 340px;
            padding-bottom: 6px;
            margin: 60px auto;
            text-align: left;
            border: 1px solid #aab;
            background-color: #f0f0fa;
            -moz-box-shadow: 2px 2px 2px #eee;
            -webkit-box-shadow: 2px 2px 2px #eee;
            -khtml-box-shadow: 2px 2px 2px #eee;
            box-shadow: 2px 2px 2px #eee;
        }

        #login .inner .fheader {
            padding: 18px 26px 14px 26px;
            background-color: #f7f7ff;
            margin: 0px 0 14px 0;
            color: #2e3741;
            font-size: 18px;
            font-weight: bold;
        }

        #login .inner .cssform p {
            /*clear: left;*/
            margin: 0;
            padding: 4px 0 3px 0;
            padding-left: 105px;
            margin-bottom: 20px;
            height: 1%;
        }

        #login .inner .cssform input[type='text'] {
            width: 120px;
        }

        #login .inner .cssform label {
            font-weight: bold;
            /*float: left;*/
            text-align: right;
            margin-left: -80px;
            width: 110px;
            padding-top: 3px;
            padding-right: 10px;
        }

        #login #remember_me_holder {
            padding-left: 120px;
        }

        #login #submit {
            margin-left: 15px;
        }

        #login #remember_me_holder label {
            float: none;
            margin-left: 0;
            text-align: left;
            width: 200px
        }

        #login .inner .login_message {
            padding: 6px 25px 20px 25px;
            color: #c33;
        }

        #login .inner .text_ {
            width: 120px;
        }

        #login .inner .chk {
            height: 12px;
        }
        </style>-->
</head>
<body>
    <div class="jumbotron">
        <h2></h><div class='fheader'><g:message code="springSecurity.login.header"/></div></h2>

        <g:if test='${flash.message}'>
            <div class='login_message'>${flash.message}</div>
        </g:if>

        <g:form controller="j_spring_security_check" method="POST">
            <div class="input-group">
                <span class="input-group-addon"><g:message code="springSecurity.login.username.label"/></span>
                <input type="text" class="form-control" placeholder="Username" name='j_username' id='username'>
            </div>

            <div class="input-group">
                <input type="password" class="form-control" placeholder="Password" name='j_password' id='password'>
                <span class="input-group-addon"><g:message code="springSecurity.login.password.label"/></span>
            </div>

            <p id="remember_me_holder">
                <input type='checkbox' class='form-control' name='${rememberMeParameter}' id='remember_me' <g:if test='${hasCookie}'>checked='checked'</g:if>/>
                <label for='remember_me'><g:message code="springSecurity.login.remember.me.label"/></label>
            </p>

            <button type="submit" class="btn btn-success " id="submit">
                <g:message code="springSecurity.login.button"/>
            </button>
        </g:form>
    </div>
    <script type='text/javascript'>
        <!--
        (function() {
            document.forms['loginForm'].elements['j_username'].focus();
        })();
        // -->
    </script>
%{--<div class="jumbotron">
    <h1>TendOSS</h1>
    <sec:ifNotLoggedIn>
    %{--<div id='login'>
        <div class='inner'>
            <div class='fheader'><g:message code="springSecurity.login.header"/></div>

            <g:if test='${flash.message}'>
                <div class='login_message'>${flash.message}</div>
            </g:if>
            <!--postUrl-->

            <form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><g:message code="springSecurity.login.username.label"/>:</span>
                        <input type="text" class="form-control" name='j_username' id='username' placeholder="Username">
                    </div>

                    <div class="input-group">
                        <span class="input-group-addon"><g:message code="springSecurity.login.password.label"/>:</span>
                        <input type="text" class="form-control" name='j_password' id='password'>
                    </div>

                    <div class="input-group">
                        <span class="input-group-addon"><g:message code="springSecurity.login.remember.me.label"/></span>
                        <input type='checkbox' class='form-control' name='${rememberMeParameter}' id='remember_me' <g:if test='${hasCookie}'>checked='checked'</g:if>/>
                    </div>
                </div>
                <input type='submit' id="submit" value='${message(code: "springSecurity.login.button")}'/>
            </form>
%{--
            <form action='${createLink(controller:"j_spring_security_check")}' method='POST' id='loginForm' class='cssform' autocomplete='on' style="height:150px; ">
                <p>
                    <label for='username'><g:message code="springSecurity.login.username.label"/>:</label>
                    <input type='text' class='text_' name='j_username' id='username'/>
                </p>

                <p>
                    <label for='password'><g:message code="springSecurity.login.password.label"/>:</label>
                    <input type='password' class='text_' name='j_password' id='password'/>
                </p>

                <p id="remember_me_holder">
                    <input type='checkbox' class='form-control' name='${rememberMeParameter}' id='remember_me' <g:if test='${hasCookie}'>checked='checked'</g:if>/>
                    <label for='remember_me'><g:message code="springSecurity.login.remember.me.label"/></label>
                </p>

                <p>
                    <input type='submit' id="submit" value='${message(code: "springSecurity.login.button")}'/>
                </p>
            </form>

        </div>
    </div>
        <script type='text/javascript'>
            <!--
            (function() {
                document.forms['loginForm'].elements['j_username'].focus();
            })();
            // -->
        </script>
    </sec:ifNotLoggedIn>
</div>--}%
</body>
</html>
