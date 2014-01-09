<%@ page import="tendoss.User" %>

<!-- tend informaton-->
<fieldset class="tend">
    <legend>tender informations</legend>
    <div class="fieldcontain ${hasErrors(bean: userInstance, field: 'answers', 'error')} ">
        <label for="answers">
            <g:message code="user.answers.label" default="Answers" />

        </label>

        <ul class="one-to-many">
            <g:each in="${userInstance?.answers?}" var="a">
                <li><g:link controller="answer" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></li>
            </g:each>
            <li class="add">
                <g:link controller="answer" action="create" params="['user.id': userInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'answer.label', default: 'Answer')])}</g:link>
            </li>
        </ul>

    </div>

    <div class="fieldcontain ${hasErrors(bean: userInstance, field: 'assignedTenders', 'error')} ">
        <label for="assignedTenders">
            <g:message code="user.assignedTenders.label" default="Assigned Tenders" />

        </label>
        <g:select name="assignedTenders" from="${tendoss.Tender.list()}" multiple="multiple" optionKey="id" size="5" value="${userInstance?.assignedTenders*.id}" class="many-to-many"/>
    </div>

    <div class="fieldcontain ${hasErrors(bean: userInstance, field: 'proposals', 'error')} ">
        <label for="proposals">
            <g:message code="user.proposals.label" default="Proposals" />

        </label>
        <g:select name="proposals" from="${tendoss.Tender.list()}" multiple="multiple" optionKey="id" size="5" value="${userInstance?.proposals*.id}" class="many-to-many"/>
    </div>

    <div class="fieldcontain ${hasErrors(bean: userInstance, field: 'votes', 'error')} ">
        <label for="votes">
            <g:message code="user.votes.label" default="Votes" />

        </label>
        <g:select name="votes" from="${tendoss.Vote.list()}" multiple="multiple" optionKey="id" size="5" value="${userInstance?.votes*.id}" class="many-to-many"/>
    </div>
</fieldset>
<!-- end of tend informaton-->