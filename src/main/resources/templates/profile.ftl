<html>
<head>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<#include "header.ftl">
<div class="form-style-2">
    <div class="form-style-2-heading">
        Profile
    </div>

    <#if flag??>
    <div class="alert alert-danger" role="alert">No such user!</div>
    <#else>
        ${user.name}

        <br>

            ${user.login}

        <br>
        <br>
        <br>
        <form action="/edit" method="get">
            <input type="submit" value="Edit"/>
        </form>

        <form action="/logout">
            <input type="submit" value="Log out"/>
        </form>
        <form action="/desks">
            <input type="submit" value="Desks"/>
        </form>
    </#if>
</div>
</body>
</html>

