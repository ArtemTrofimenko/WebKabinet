<#include "security.ftl">
<#import "login.ftl" as l>
<#macro ttnSearch>
<div xmlns="http://www.w3.org/1999/html">
    <form action="/ttnSearch" method="get">
    <input name="_csrf" type="hidden" value="${_csrf.token}"/>

    <input name="contragent_id" placeholder="Контрагент" type="text">
    <input name="nomenclature_id" placeholder="Номенклатура" type="text">

    <button type="submit">Поиск</button>
</form>
</div>
</#macro>