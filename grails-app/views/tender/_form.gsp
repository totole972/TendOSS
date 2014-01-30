<%@ page import="tendoss.Tender" %>



<div class="fieldcontain ${hasErrors(bean: tenderInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="tender.name.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${tenderInstance?.name}"/>
</div>
	
<div class="fieldcontain ${hasErrors(bean: tenderInstance, field: 'requirements', 'error')} ">
	<label for="requirements">
		<g:message code="tender.requirements.label" default="Requirements" />
		
	</label>
	<g:select name="requirements" from="${tendoss.TenderTechno.list()}" multiple="multiple" optionKey="id" size="5" value="${tenderInstance?.requirements*.id}" class="many-to-many"/>
</div>

</div>

<div class="fieldcontain ${hasErrors(bean: tenderInstance, field: 'answerDeadline', 'error')} required">
	<label for="answerDeadline">
		<g:message code="tender.answerDeadline.label" default="Answer Deadline" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="answerDeadline" precision="day"  value="${tenderInstance?.answerDeadline}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: tenderInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="tender.description.label" default="Description" />
		
	</label>
	<g:textArea name="description" rows="20" cols="100" value="${tenderInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: tenderInstance, field: 'attachements', 'error')} ">
	<label for="attachements">
		<g:message code="tender.attachements.label" default="Attachements" />
		
	</label>
	<g:select name="attachements" from="${tendoss.File.list()}" multiple="multiple" optionKey="id" size="5" value="${tenderInstance?.attachements*.id}" class="many-to-many"/>
</div>
