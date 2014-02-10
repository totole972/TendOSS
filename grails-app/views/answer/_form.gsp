<%@ page import="tendoss.Answer" %>


<g:form controller="answer" action="save">
    <g:hiddenField name="tender" value="${tenderInstance.id}"></g:hiddenField>
<div class="fieldcontain ${hasErrors(bean: answerInstance, field: 'content', 'error')} required">
	<label for="content">
		<g:message code="answer.content.label" default="Content" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="content" cols="75" rows="10" required="" value="${answerInstance?.content}"/>
</div>
<g:submitButton name="Submit" class="btn-success btn-lg"></g:submitButton>
</g:form>