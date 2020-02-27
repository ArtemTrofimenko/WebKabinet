<#import "parts/common.ftl" as c>
<#import "parts/ttnEdit.ftl" as t>
<@c.page>
<#include "parts/security.ftl">
<#import "parts/login.ftl" as l>
Request Editor
<div xmlns="http://www.w3.org/1999/html"> <form method="post">
    <input name="_csrf" type="hidden" value="${_csrf.token}"/>
    <input name="contragent_id" placeholder="Контрагент" type="text">
    <input name="nomenclature_id" placeholder="Номенклатура" type="text">
    <input name="isChecked" type="checkbox" value="true" >Проверено
    <input name="weight" placeholder="Масса, кг" type="text">

    <button type="submit">Добавить</button>
</form>
</div>
</@c.page>