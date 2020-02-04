<#import "parts/common.ftl" as c>

<@c.page>
User Editor
<form action="/user" method="post">

    <input name="username" placeholder="Username" type="text"value="${user.username}">
        <input name="fullname" placeholder="Fullname" type="text">
        <input name="userEmail" placeholder="UserEmail" type="email">
        <input name="userPhoneNumber" placeholder="User Phone" type="number">
        <input name="contragent_id" placeholder="Contragent" type="text">
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