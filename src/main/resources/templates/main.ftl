<#import "parts/common.ftl" as c>
<#import "parts/ttnSearch.ftl" as t>

<@c.page>
<@t.ttnSearch></@t.ttnSearch>
<div class="table-responsive">
    <#assign nomenclatureNull = ".">
    <#assign lastNomenclature = nomenclatureNull>
    <#assign lastContragent = nomenclatureNull>
<table align="center" class="table-bordered " id="outter" >
    <thead align="center" class="">
    <tr>
        <th scope="col">Дата</th>
        <th scope="col">Номер ТТН</th>
        <th scope="col">Операция</th>
<#--    <th scope="col">Контрагент</th>-->
        <th scope="col">Влажность,%</th>
        <th scope="col">Сор, %</th>
        <th scope="col">Масса, кг</th>
        <th scope="col">По влажности, %</th>
        <th scope="col">По сору, %</th>
        <th scope="col">ФИО водителя</th>
        <th scope="col">Перевозчик</th>
        <th scope="col">Элеватор</th>
<#--    <th scope="col">Номенклатура</th>-->
        <th scope="col">Транспорт</th>
    </tr>
    </thead>
    <#list ttns?sort_by("nomenclatureName")?reverse?sort_by("contragentName") as ttn>
            <tbody>
            <tr>
                <#if lastContragent!=ttn.contragentName>
                <#assign lastNomenclature=nomenclatureNull>
            </#if>
            <#if lastNomenclature != ttn.nomenclatureName>
            <tr id="alpha">
                <td colspan="12" id="nested">
                    <table class="table table-striped" id="inner">
                        <tbody>
                        <tr class="table-secondary" >
                            <td><b>Контрагент:</b> ${ttn.getContragentName()}</td>
                            <td><b>Номенклатура:</b> ${ttn.nomenclatureName}</td>
                            <td><b>Количество суммарное:</b> <#assign myMap = ttnComponent>
                                <#assign myMap2 = myMap[ttn.getContragentName()]>
                                ${myMap2[ttn.getNomenclatureName()]}
                           </td>
                        </tbody>
                    </table>
            </tr></td>
        </#if> <#assign lastNomenclature = ttn.nomenclatureName>
        <#assign lastContragent = ttn.contragentName>
            <td>${ttn.ttnDate}</td>
            <td>${ttn.number}</td>
            <td>${ttn.operation}</td>
<#--        <td>${ttn.contragentName}</td>-->
            <td>${ttn.humidity}</td>
            <td>${ttn.rubbish}</td>
            <td>${ttn.weight}</td>
            <td>${ttn.percentByHumidity}</td>
            <td>${ttn.percentByRubbish}</td>
            <td>${ttn.driverName}</td>
            <td>${ttn.carrier}</td>
            <td>${ttn.elevatorName}</td>
<#--        <td>${ttn.nomenclatureName}</td>-->
            <td>${ttn.vehicleName}</td>
            </tr>

    <#else>
    No ttn
    </#list>
        </tbody>
        </table>
</div>
</@c.page>