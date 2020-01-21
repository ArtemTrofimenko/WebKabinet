<#import "parts/common.ftl" as c>

<@c.page>
User Editor
<form action="/user" method="post">

    <input type="text" name="username" value="${user.username}">
        <input name="fullname" type="text">
        <input type="email" name="userEmail" >
        <input type="number" name="userPhoneNumber" >
    <input type="hidden" value="${user.id}" name="userId">
    <#list roles as role>
    <div>
        <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
    </div>
</#list>
    <input type="checkbox"  name ="activeUs" ${user.active?string("checked", "")}>ACTIVITY
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
<button type="submit">Save</button>
</form>
</@c.page>