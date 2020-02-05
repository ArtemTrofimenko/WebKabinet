<#import "parts/common.ftl" as c>
<@c.page>
<div class="table-responsive">

<table class="table-striped">
    <thead>
    <tr>
        <th scope="col">Дата</th>
        <th scope="col">Номер ТТН</th>
        <th scope="col">Контрагент</th>
        <th scope="col">Влажность,%</th>
        <th scope="col">Сор, %</th>
        <th scope="col">Масса, кг</th>
        <th scope="col">По влажности, %</th>
        <th scope="col">По сору, %</th>
        <th scope="col">ФИО водителя</th>
        <th scope="col">Перевозчик</th>
        <th scope="col">Элеватор</th>
        <th scope="col">Номенклатура</th>
        <th scope="col">Транспорт</th>
    </tr>
    </thead>
<#list ttns as ttn>

<tbody>

        <td>${ttn.ttnDate}</td>
        <td>${ttn.number}</td>
        <td>${ttn.contragentName}</td>
        <td>${ttn.humidity}</td>
        <td>${ttn.rubbish}</td>
        <td>${ttn.weight}</td>
        <td>${ttn.percentByHumidity}</td>
        <td>${ttn.percentByRubbish}</td>
        <td>${ttn.driverName}</td>
        <td>${ttn.carrier}</td>
        <td>${ttn.elevatorName}</td>
        <td>${ttn.nomenclatureName}</td>
        <td>${ttn.vehicleName}</td>
<#else>
No ttn
</#list>
    </tbody></table></div>
</@c.page>