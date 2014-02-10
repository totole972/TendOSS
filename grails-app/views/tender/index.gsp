
<%@ page import="tendoss.Tender" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'tender.label', default: 'Tender')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
    <div class="container wb">
		<div class="nav" role="navigation">
			<g:link class="btn-success btn-lg create" action="create"><g:message code="default.new.label" args="[entityName]" />
            </g:link>
		</div>
		<div id="list-tender" class="col-lg-7" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			
			<g:each in="${tenderInstanceList}" status="i" var="tenderInstance">
				<div class="${(i % 2) == 0 ? 'even' : 'odd'}" style="margin:30px">
					
					<h2><g:link action="show" id="${tenderInstance.id}">${fieldValue(bean: tenderInstance, field: "name")}</g:link></h2>
				
					<b>Submitted :</b> <g:formatDate date="${tenderInstance.submissionDate}" format="dd/MM/yyyy"/><br />
					<b>Answer deadline :</b> <g:formatDate date="${tenderInstance.answerDeadline}" format="dd/MM/yyyy" /><br />
					
					<p><i>${fieldValue(bean: tenderInstance, field: "lightDescription")}</i></p>
					<hr />
				</div>
			</g:each>
			
			<div class="pagination">
				<g:paginate total="${tenderInstanceCount ?: 0}" />
			</div>
		</div>
        <div  class="col-lg-4 col-lg-offset-1">
            <g:render template="bestTenders" model="bestTenders"></g:render>
        </div>
    </div>
	</body>
</html>