<%@ page import="tendoss.UserTechno; tendoss.Techno; tendoss.User" %>

<!-- personnal informaton-->
<fieldset class="personnal_informaton" legend="personnal informatons" style="border: 1px, #000000, solid">
    <legend>personnal informations</legend>
    <div class="fieldcontain ${hasErrors(bean: userInstance, field: 'username', 'error')} required">
        <label for="username">
            <g:message code="user.username.label" default="Username" />
            <span class="required-indicator">*</span>
        </label>
        <g:textField name="username" required="" value="${userInstance?.username}"/>
    </div>

    <div class="fieldcontain ${hasErrors(bean: userInstance, field: 'password', 'error')} required">
        <label for="password">
            <g:message code="user.password.label" default="Password" />
            <span class="required-indicator">*</span>
        </label>
        <g:textField name="password" required="" value="${userInstance?.password}"/>
    </div>

    <div class="fieldcontain ${hasErrors(bean: userInstance, field: 'emailAddress', 'error')} required">
	<label for="emailAddress">
		<g:message code="user.emailAddress.label" default="Email Address" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="email" name="emailAddress" required="" value="${userInstance?.emailAddress}"/>
</div>

    <div class="fieldcontain ${hasErrors(bean: userInstance, field: 'skills', 'error')} " >
        <label for="skills">
            <g:message code="user.skills.label" default="Skills" />

        </label>
        <ul class="one-to-many" id="usr_techno_list">
            d   ${userInstance}d
            <g:each in="${userInstance?.skills?}" var="s">
                <li>
                    ${s.techno.libelle}&nbsp;${s.level.name}
                </li>
            </g:each>
        </ul>
        <!-- associate techno and level(for current user)-->
        <g:form >
            <g:select optionValue="libelle" optionKey="id" name="skills" from="${Techno.list()}" ></g:select>
            <g:select optionValue="name" optionKey="id" name="level" from="${tendoss.Level.list()}" ></g:select>
            <g:submitToRemote  update="user_personnal_information" url="[controller: 'UserTechno', action: 'create']" method="POST" value="Add to skills"></g:submitToRemote>
        </g:form>
        <!-- creating techno-->
        <br>
        <g:link controller="userTechno" action="create" params="['user.id': userInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'userTechno.label', default: 'UserTechno')])}</g:link>
    </div>
</fieldset>
<!-- end of personnal informaton-->


<!-- admin informaton-->
<fieldset class="administration_informaton" style="display: none;">
    <div class="fieldcontain ${hasErrors(bean: userInstance, field: 'accountExpired', 'error')} ">
        <label for="accountExpired">
            <g:message code="user.accountExpired.label" default="Account Expired" />

        </label>
        <g:checkBox name="accountExpired" value="${userInstance?.accountExpired}" />
    </div>

    <div class="fieldcontain ${hasErrors(bean: userInstance, field: 'accountLocked', 'error')} ">
        <label for="accountLocked">
            <g:message code="user.accountLocked.label" default="Account Locked" />

        </label>
        <g:checkBox name="accountLocked" value="${userInstance?.accountLocked}" />
    </div>

    <div class="fieldcontain ${hasErrors(bean: userInstance, field: 'enabled', 'error')} ">
        <label for="enabled">
            <g:message code="user.enabled.label" default="Enabled" />

        </label>
        <g:checkBox name="enabled" value="${userInstance?.enabled}" />
    </div>

    <div class="fieldcontain ${hasErrors(bean: userInstance, field: 'passwordExpired', 'error')} ">
    <label for="passwordExpired">
        <g:message code="user.passwordExpired.label" default="Password Expired" />

    </label>
    <g:checkBox name="passwordExpired" value="${userInstance?.passwordExpired}" />
</div>
</fieldset>
<!-- end of admin informaton-->