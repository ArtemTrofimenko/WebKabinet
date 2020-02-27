<#include "security.ftl">
<#import "login.ftl" as l>
<#macro ttnEditor>
<div xmlns="http://www.w3.org/1999/html"> <form method="post">
        <input name="_csrf" type="hidden" value="${_csrf.token}"/>
        <input name="vehicle_id" placeholder="Автомобиль" type="text">
        <input name="driver_id" placeholder="Водитель" type="text">
        <input name="contragent_id" placeholder="Контрагент" type="text">
        <input name="carrier_id" placeholder="Перевозчик" type="text">
        <input name="nomenclature_id" placeholder="Номенклатура" type="text">
        <input name="weight" placeholder="Масса, кг" type="text">
        <input name="humidity" placeholder="Влажность, %" type="text">
        <input name="rubbish" placeholder="Сор, %" type="text">
        <input id="coming" name="operation" type="radio" value="COMING">
        Приход
        <input id="consumption" name="operation" type="radio" value="CONSUMPTION">
         Расход
        <input id="drying" name="operation" type="radio" value="DRYING">
       Сушка
        <input id="cleaning_drying" name="operation" type="radio" value="CLEANING_DRYING">
      Сушка-очистка
        <button type="submit">Добавить</button>
        <p>Date: <input id="datepicker" name="datepicker" type="text"></p>
    </form>
</div>
</#macro>