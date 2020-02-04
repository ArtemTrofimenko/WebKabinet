<#include "security.ftl">
<#import "login.ftl" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Kernel Web Kabinet</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/main">Ttns</a>
            </li>
            <#if isAdmin>
            <li class="nav-item">
                <a class="nav-link" href="/user">User list</a>
            </li>

        </#if>

        </ul>
        <ul class="navbar-nav mr-10 ml-3">
            <li class="nav-item mr-3 ml-3">
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
            </li>
            <li class="nav-item">

                <div class="dropdown">
                    <a aria-expanded="false" aria-haspopup="true" class="btn btn-secondary dropdown-toggle"
                       data-toggle="dropdown" href="#" id="dropdownMenuLink" role="button">
                        ${name}
                    </a>

                    <div aria-labelledby="dropdownMenuLink" class="dropdown-menu">
                        <#if name !="unknown"><@l.logout/><#else>
                        <a class="dropleft-item" href="/login">Войти</a>
                        <a class="dropleft-item" href="/registration">Зарегистрироваться</a>
                    </#if>
                </div>
            </li>
        </ul>


    </div>
</nav>
