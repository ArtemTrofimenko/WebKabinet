<#import "parts/common.ftl" as c>
<@c.page>
<div>
    <form method="post">
        <input name="_csrf" type="hidden" value="${_csrf.token}"/>
        <input name="elevatorName" placeholder="Введите название элеватора" type="text">
        <input name="elevatorEDRPOU" placeholder="ЕДРПОУ" type="text">
        <button type="submit">Добавить</button>
    </form>
</div>

<div> Список элеваторов</div>

<#list elevators as elevator>
<div>

    <span>${elevator.elevatorName}</span>
    <i>${elevator.elevatorEDRPOU} </i>

</div>
<#else>
No elevators
</#list>

</@c.page>