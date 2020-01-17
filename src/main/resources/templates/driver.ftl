<#import "parts/common.ftl" as c>
<@c.page>
<div>
    <form method="post">
        <input name="_csrf" type="hidden" value="${_csrf.token}"/>
        <input name="driverName" placeholder="Введите имя водителя" type="text">
        <input name="driverLicense" placeholder="Введите номер удостоверения" type="text">


        <button type="submit">Добавить</button>
    </form>
</div>

<div> Список водителей</div>

<#list drivers as driver>
<div>

    <span>${driver.name}</span>
    <span>${driver.driverLicense}</span>


</div>
<#else>
No drivers
</#list>

</@c.page>