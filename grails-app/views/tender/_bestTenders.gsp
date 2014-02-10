<h1><g:message code="tender.top10"></g:message> </h1>
<g:each in="${bestTenders}" status="i" var="tenderInstance">
    <div class="${(i % 2) == 0 ? 'even' : 'odd'}" style="margin:30px">
        <h2><g:link controller="tender" action="show" id="${tenderInstance.id}">${tenderInstance.name}</g:link></h2>
        <h3>
            <g:message code="tender.nbVotes" args="${tenderInstance.nbvotes> 0?tenderInstance.nbvotes:"0"}"></g:message>
        </h3>
        <h3>
            <g:message code="tender.note" args="${tenderInstance.note > 0?tenderInstance.note:"0"}"></g:message>
        </h3>
        <hr />
    </div>
</g:each>