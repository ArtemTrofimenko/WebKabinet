<#import "parts/common.ftl" as c>
<@c.page>

<div>ТТН</div>
<form method="get" action="/main">

    <input type="text" name="filter" class="form-control" value="${filter?ifExists}" placeholder="Search by tag">
    <button type="submit">Пошук</button>
</form>
<#list ttns as ttn>
<div>

    <#-- <b>${ttn.date}</b>-->
    <#-- <b>${ttn.number}</b>-->
    <#-- <strong>${ttn.contragent|| ttn.operation} </strong>-->
    <#-- <strong>${ttn.contragent|| ttn.operation} </strong>-->
    <strong>${ttn.humidity} </strong>
    <strong>${ttn.rubbish} </strong>
    <strong>${ttn.weight} </strong>
    <strong>${ttn.percentByHumidity} </strong>
     <strong>${ttn.percentByRubbish} </strong>
    <b>${ttn.driverName}</b>
    <b>${ttn.contragentName}</b>
    <b>${ttn.carrier}</b>
    <b>${ttn.elevatorName}</b>
    <b>${ttn.nomenclatureName}</b>
    <b>${ttn.vehicleName}</b>
</div>
<#else>
No ttn
</#list>

</@c.page>