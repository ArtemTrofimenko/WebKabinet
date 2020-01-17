<#include "security.ftl">
<#import "login.ftl" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Kernel Web Kabinet</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse bg-light" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/main">Messages</a>
            </li>
            <#if isAdmin>
            <li class="nav-item">
                <a class="nav-link" href="/user">User list</a>
            </li>
            <div class="dropdown">
                <a aria-expanded="false" aria-haspopup="true" class="btn btn-secondary dropdown-toggle"
                   data-toggle="dropdown" href="#" id="dropdownMenuLink" role="button">
                    Справочники
                </a>

                <div aria-labelledby="dropdownMenuLink" class="dropdown-menu">
                    <a class="dropdown-item" href="/carrier">Перевозчики</a>
                    <a class="dropdown-item" href="/driver">Водитель</a>
                    <a class="dropdown-item" href="/vehicle">Транспортные средства</a>
                    <a class="dropdown-item" href="/nomenclature">Номенклатура</a>
                    <a class="dropdown-item" href="/elevator">Места хранения</a>
                </div>
            </
            #if>
        </ul>

        <div class="navbar-text mr-3">${name}</div>
        <#if name !="unknown"><@l.logout/></#if>
    </div>
</nav>
