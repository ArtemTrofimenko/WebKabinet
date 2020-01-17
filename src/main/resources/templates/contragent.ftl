<#import "parts/common.ftl" as c>
<@c.page>
<div>
    <form method="post">
        <input name="_csrf" type="hidden" value="${_csrf.token}"/>
        <input name="contragentName" placeholder="Введите название контрагента" type="text">

        <button type="submit">Добавить</button>
    </form>
</div>

<div> Список контрагента</div>

<#list contragents as contragent>
<div>

    <span>${contragent.contragentName}</span>


</div>
<#else>
No contragents
</#list>

</@c.page>