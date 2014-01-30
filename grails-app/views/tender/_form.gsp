<%@ page import="tendoss.Tender" %>



<div class="fieldcontain ${hasErrors(bean: tenderInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="tender.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${tenderInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: tenderInstance, field: 'submissionDate', 'error')} required">
	<label for="submissionDate">
		<g:message code="tender.submissionDate.label" default="Submission Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="submissionDate" precision="day"  value="${tenderInstance?.submissionDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: tenderInstance, field: 'closed', 'error')} ">
	<label for="closed">
		<g:message code="tender.closed.label" default="Closed" />
		
	</label>
	<g:checkBox name="closed" value="${tenderInstance?.closed}" />
</div>

<div class="fieldcontain ${hasErrors(bean: tenderInstance, field: 'answerDeadline', 'error')} required">
	<label for="answerDeadline">
		<g:message code="tender.answerDeadline.label" default="Answer Deadline" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="answerDeadline" precision="day"  value="${tenderInstance?.answerDeadline}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: tenderInstance, field: 'answers', 'error')} ">
	<label for="answers">
		<g:message code="tender.answers.label" default="Answers" />
		
	</label>
	<g:select name="answers" from="${tendoss.Answer.list()}" multiple="multiple" optionKey="id" size="5" value="${tenderInstance?.answers*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: tenderInstance, field: 'attachements', 'error')} ">
	<label for="attachements">
		<g:message code="tender.attachements.label" default="Attachements" />
		
	</label>
	<g:select name="attachements" from="${tendoss.File.list()}" multiple="multiple" optionKey="id" size="5" value="${tenderInstance?.attachements*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: tenderInstance, field: 'delivaryDeadline', 'error')} required">
	<label for="delivaryDeadline">
		<g:message code="tender.delivaryDeadline.label" default="Delivary Deadline" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="delivaryDeadline" precision="day"  value="${tenderInstance?.delivaryDeadline}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: tenderInstance, field: 'detailedDescription', 'error')} ">
	<label for="detailedDescription">
		<g:message code="tender.detailedDescription.label" default="Detailed Description" />
		
	</label>
	<g:textField name="detailedDescription" value="${tenderInstance?.detailedDescription}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: tenderInstance, field: 'lightDescription', 'error')} ">
	<label for="lightDescription">
		<g:message code="tender.lightDescription.label" default="Light Description" />
		
	</label>
	<g:textField name="lightDescription" value="${tenderInstance?.lightDescription}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: tenderInstance, field: 'participants', 'error')} ">
	<label for="participants">
		<g:message code="tender.participants.label" default="Participants" />
		
	</label>
	
</div>

<div class="fieldcontain ${hasErrors(bean: tenderInstance, field: 'requirements', 'error')} ">
	<label for="requirements">
		<g:message code="tender.requirements.label" default="Requirements" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${tenderInstance?.requirements?}" var="r">
    <li><g:link controller="tenderTechno" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="tenderTechno" action="create" params="['tender.id': tenderInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'tenderTechno.label', default: 'TenderTechno')])}</g:link>
</li>
</ul>

</div>

