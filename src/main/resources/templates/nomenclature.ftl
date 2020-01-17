<#import "parts/common.ftl" as c>
<@c.page>
<div>
    <form method="post">
        <input name="_csrf" type="hidden" value="${_csrf.token}"/>
        <input name="name" placeholder="Введите название номенклатуры" type="text">

        <button type="submit">Добавить</button>
    </form>
</div>

<div> Список номенклатуры</div>

<#list nomenclatures as nomenclature>
<div>

    <span>${nomenclature.name}</span>


</div>
<#else>
No nomenclature
</#list>

</@c.page>