<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">
<@c.page>

Request Editor
<div xmlns="http://www.w3.org/1999/html">
    <#if request??> <form action="${request.getId()}" method="post">
    <input name="_csrf" type="hidden" value="${_csrf.token}"/>
    <input name="reqId" type="hidden" value="${request.getId()}">
    <input name="contragent_id" placeholder="Контрагент" type="text" value="${request.getContragentId()}">
    <input name="nomenclature_id" placeholder="Номенклатура" type="text" value="${request.getNomenclatureId()}">
    <#if isAdmin>
    <#if request.getChecked()> <input checked disabled name="isChecked" type="checkbox" > Проверено
    <#else>
    <input name="isChecked" type="checkbox"  > Проверено
</#if>
</#if>
<input name="weight" placeholder="Масса, кг" type="text" value="${request.getWeight()}">
<input name="_csrf" type="hidden" value="${_csrf.token}"/>
<button type="submit">Добавить</button>
</form>
<#else> <form action="/request" method="post">
    <input name="contragent_id" placeholder="Контрагент" type="text">
    <input name="nomenclature_id" placeholder="Номенклатура" type="text">
    <#if isAdmin>
    <input name="isChecked" type="checkbox"  > Проверено
</#if>
<input name="weight" placeholder="Масса, кг" type="text">
<input name="_csrf" type="hidden" value="${_csrf.token}"/>
<button type="submit">Добавить</button>
</form>
</#if>




</div>
</@c.page>