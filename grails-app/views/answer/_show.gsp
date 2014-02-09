<g:each in="${tenderInstance.answers}" status="i" var="a">
    <div class="${(i % 2) == 0 ? 'even' : 'odd'}" style="margin:30px">
        <h4>${a.author.username} &nbsp; : &nbsp; ${a.answerDate} </h4>
        <p><i>${a.content}</i></p>
        <hr />
    </div>
%{--}<span class="property-value" aria-labelledby="answers-label"><g:link controller="answer" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></span>--}%
</g:each>
