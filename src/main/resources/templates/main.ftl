<#import "parts/common.ftl" as c>
<@c.page>
<div>
    <form method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="text" name="text" placeholder="Введите сообщение">
        <input type="text" name="tag" placeholder="Тэг">
        <button type="submit">Добавить</button>
    </form>
</div>

<div> Список сообщений</div>
<form method="get" action="/main">

    <input type="text" name="filter"class="form-control" value="${filter?ifExists}" placeholder="Search by tag">
    <button type="submit">Пошук</button>
</form>
<#list messages as message>
<div>
    <b>${message.id}</b>
    <span>${message.text}</span>
    <i>${message.tag} </i>
    <strong>${message.authorName} </strong>
</div>
<#else>
No message
</#list>

</@c.page>