
<%@ page import="tendoss.Tender" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'tender.label', default: 'Tender')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-tender" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-tender" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'tender.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="submissionDate" title="${message(code: 'tender.submissionDate.label', default: 'Submission Date')}" />
					
						<g:sortableColumn property="closed" title="${message(code: 'tender.closed.label', default: 'Closed')}" />
					
						<g:sortableColumn property="answerDeadline" title="${message(code: 'tender.answerDeadline.label', default: 'Answer Deadline')}" />
					
						<g:sortableColumn property="delivaryDeadline" title="${message(code: 'tender.delivaryDeadline.label', default: 'Delivary Deadline')}" />
					
						<g:sortableColumn property="detailedDescription" title="${message(code: 'tender.detailedDescription.label', default: 'Detailed Description')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${tenderInstanceList}" status="i" var="tenderInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${tenderInstance.id}">${fieldValue(bean: tenderInstance, field: "name")}</g:link></td>
					
						<td><g:formatDate date="${tenderInstance.submissionDate}" /></td>
					
						<td><g:formatBoolean boolean="${tenderInstance.closed}" /></td>
					
						<td><g:formatDate date="${tenderInstance.answerDeadline}" /></td>
					
						<td><g:formatDate date="${tenderInstance.delivaryDeadline}" /></td>
					
						<td>${fieldValue(bean: tenderInstance, field: "detailedDescription")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${tenderInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
