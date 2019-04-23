<html>
<head>
</head>
<body>


<#if tasks??>
    <#list tasks as task>
        <tr>
            <td><a href="#">${task.text}</td><br>
        </tr>
    </#list>
</#if>
</body>
</html>
