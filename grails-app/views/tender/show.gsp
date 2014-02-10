
<%@ page import="tendoss.Tender" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'tender.label', default: 'Tender')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>

		<div id="show-tender" class="content scaffold-show" role="main">
			<h1><g:fieldValue bean="${tenderInstance}" field="name"/></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<div class="property-list tender">
				<b>Asked by </b> ${tenderInstance.postOwner.username}<br />	
				<b>Submitted :</b> <g:formatDate date="${tenderInstance.submissionDate}" format="dd/MM/yyyy"/><br />
				<b>Answer deadline :</b> <g:formatDate date="${tenderInstance.answerDeadline}" format="dd/MM/yyyy" /><br />
			</div>
			
			<div class="property-list tender">	
				<p><b>Requirements</b></p>
				<g:if test="${tenderInstance?.requirements}">
				<p class="fieldcontain">					
					<g:each in="${tenderInstance.requirements}" var="r">
					<li><span class="property-value">${r?.techno.libelle.encodeAsHTML()} (${r?.minimalLevel.name.encodeAsHTML()})</span></li>
					</g:each>
				</p>
				</g:if>
				
				<div style="margin:20px;padding:10px;border:1px solid #ccc">
					<p>${fieldValue(bean: tenderInstance, field: "description")}</p>
				</div>
			
				<g:if test="${tenderInstance?.closed}">
				<li class="fieldcontain">
					<span id="closed-label" class="property-label"><g:message code="tender.closed.label" default="Closed" /></span>
					
						<span class="property-value" aria-labelledby="closed-label"><g:formatBoolean boolean="${tenderInstance?.closed}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${tenderInstance?.attachements}">
				<li class="fieldcontain">
					<span id="attachements-label" class="property-label"><g:message code="tender.attachements.label" default="Attachements" /></span>
					
						<g:each in="${tenderInstance.attachements}" var="a">
						<span class="property-value" aria-labelledby="attachements-label"><g:link controller="file" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
	
			
			</div>
			
			<hr />
            <sec:ifLoggedIn>
		        <g:render template="/answer/form"></g:render>
            </sec:ifLoggedIn>
            <sec:ifNotLoggedIn>
                You must be logged In to post an answer
            </sec:ifNotLoggedIn>
			<h2>Answers</h2>
				<g:if test="${tenderInstance?.answers}">
				<li class="fieldcontain">
                    <g:render template="/answer/show"  model="${tenderInstance.answers}"></g:render>
				</li>
				</g:if>
				<g:else>
					<p>					
						No answer yet !
					</p>
				</g:else>
			<g:form url="[resource:tenderInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${tenderInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>