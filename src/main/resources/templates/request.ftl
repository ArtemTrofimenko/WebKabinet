<#import "parts/common.ftl" as c>

<@c.page>
<#if requests??>
<div class="table-responsive">
    <table align="center" class="table-bordered " id="outter" >
        <thead align="center" class="">
        <tr>
            <th scope="col">Дата</th>
            <th scope="col">Номер заявки</th>
            <th scope="col">Контрагент</th>
            <th scope="col">Масса, кг</th>
            <th scope="col">Элеватор</th>
            <th scope="col">Номенклатура</th>
            <th scope="col">Статус</th>
        </tr>
        </thead>
<#--    </#if>-->
        <tbody>
        <#list requests?sort_by("nomenclatureName")?sort_by("reqDate")?sort_by("reqNumber")?sort_by("contragentName") as request>

        <td>${request.getReqDate()}</td>
        <td>${request.getReqNumber()}</td>
        <td>${request.contragentName}</td>
        <td>${request.weight}</td>
        <td>${request.nomenclatureName}</td>
        <td>${request.getCheckedString()}</td>
        </tr>

    </#list>
</#if>
</tbody>
</table>
</div>
</@c.page>