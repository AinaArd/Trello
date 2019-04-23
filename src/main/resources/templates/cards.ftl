<html>
<head>
</head>
<body>

<#if cards??>
    <#list cards as card>
        <tr>
            <td><a href="/cards/${card.id}">${card.name}</td><br>
        </tr>
    </#list>
</#if>
</body>
</html>
