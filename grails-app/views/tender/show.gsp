
<%@ page import="tendoss.Tender" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'tender.label', default: 'Tender')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-tender" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-tender" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list tender">
			
				<g:if test="${tenderInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="tender.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${tenderInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${tenderInstance?.submissionDate}">
				<li class="fieldcontain">
					<span id="submissionDate-label" class="property-label"><g:message code="tender.submissionDate.label" default="Submission Date" /></span>
					
						<span class="property-value" aria-labelledby="submissionDate-label"><g:formatDate date="${tenderInstance?.submissionDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${tenderInstance?.closed}">
				<li class="fieldcontain">
					<span id="closed-label" class="property-label"><g:message code="tender.closed.label" default="Closed" /></span>
					
						<span class="property-value" aria-labelledby="closed-label"><g:formatBoolean boolean="${tenderInstance?.closed}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${tenderInstance?.answerDeadline}">
				<li class="fieldcontain">
					<span id="answerDeadline-label" class="property-label"><g:message code="tender.answerDeadline.label" default="Answer Deadline" /></span>
					
						<span class="property-value" aria-labelledby="answerDeadline-label"><g:formatDate date="${tenderInstance?.answerDeadline}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${tenderInstance?.answers}">
				<li class="fieldcontain">
					<span id="answers-label" class="property-label"><g:message code="tender.answers.label" default="Answers" /></span>
					
						<g:each in="${tenderInstance.answers}" var="a">
						<span class="property-value" aria-labelledby="answers-label"><g:link controller="answer" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></span>
						</g:each>
					
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
			
				<g:if test="${tenderInstance?.delivaryDeadline}">
				<li class="fieldcontain">
					<span id="delivaryDeadline-label" class="property-label"><g:message code="tender.delivaryDeadline.label" default="Delivary Deadline" /></span>
					
						<span class="property-value" aria-labelledby="delivaryDeadline-label"><g:formatDate date="${tenderInstance?.delivaryDeadline}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${tenderInstance?.detailedDescription}">
				<li class="fieldcontain">
					<span id="detailedDescription-label" class="property-label"><g:message code="tender.detailedDescription.label" default="Detailed Description" /></span>
					
						<span class="property-value" aria-labelledby="detailedDescription-label"><g:fieldValue bean="${tenderInstance}" field="detailedDescription"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${tenderInstance?.lightDescription}">
				<li class="fieldcontain">
					<span id="lightDescription-label" class="property-label"><g:message code="tender.lightDescription.label" default="Light Description" /></span>
					
						<span class="property-value" aria-labelledby="lightDescription-label"><g:fieldValue bean="${tenderInstance}" field="lightDescription"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${tenderInstance?.participants}">
				<li class="fieldcontain">
					<span id="participants-label" class="property-label"><g:message code="tender.participants.label" default="Participants" /></span>
					
						<g:each in="${tenderInstance.participants}" var="p">
						<span class="property-value" aria-labelledby="participants-label"><g:link controller="user" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${tenderInstance?.requirements}">
				<li class="fieldcontain">
					<span id="requirements-label" class="property-label"><g:message code="tender.requirements.label" default="Requirements" /></span>
					
						<g:each in="${tenderInstance.requirements}" var="r">
						<span class="property-value" aria-labelledby="requirements-label"><g:link controller="tenderTechno" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:tenderInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${tenderInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
