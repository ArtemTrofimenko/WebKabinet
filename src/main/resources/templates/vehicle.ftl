<#import "parts/common.ftl" as c>
<@c.page>
<div>
    <form method="post">
        <input name="_csrf" type="hidden" value="${_csrf.token}"/>
        <input name="carModel" placeholder="Введите марку и модель" type="text">
        <input name="carNumber" placeholder="Введите номер автомобиля" type="text">


        <button type="submit">Добавить</button>
    </form>
</div>

<div> Список автотранспортных средств</div>

<#list vehicles as vehicle>
<div>

    <span>${vehicle.carModel}</span>
    <span>${vehicle.carNumber}</span>


</div>
<#else>
No vehicles
</#list>

</@c.page>