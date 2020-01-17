<#import "parts/common.ftl" as c>
<@c.page>
<div>
    <form method="post">
        <input name="_csrf" type="hidden" value="${_csrf.token}"/>
        <input name="carrierName" placeholder="Введите название перевозчика" type="text">
        <button type="submit">Добавить</button>
    </form>
</div>

<div> Список перевозчиков</div>

<#list carriers as carrier>
<div>
    <b>${carrier.carrierId}</b>
    <span>${carrier.carrierName}</span>


</div>
<#else>
No carriers
</#list>

</@c.page>