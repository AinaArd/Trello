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

<form method="post">
    <input type="text" id="text" name="text">
    <button type="submit" id="save" value="Add task"></button>
</form>

</body>
</html>
