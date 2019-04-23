<html>
<head>
    <link href="/css/deskStyles.css" rel="stylesheet" type="text/css">
</head>
<body>

<div>
    <h2>User desks</h2>
</div>
        <#list desks as desk>
            <tr>
                <td><a href="/desks/${desk.id}">${desk.name} </a></td>

                <td>${desk.state}</td>
                <br>
            </tr>
        </#list>

<br>
<#if cards??>
    <#list cards as card>
        <tr>
            <td><a href="/cards/${card.id}">${card.name}</td><br>
        </tr>
    </#list>
</#if>
</div>

</body>
</html>
