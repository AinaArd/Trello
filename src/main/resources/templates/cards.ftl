<html>
<head>
</head>
<body>
<div onclick="show('none')" id="gray"></div>
<#--
<div id="window">
    <div class="form">
        <form method="get" action="/cards/${card.id}/tasks/${task.id}">
        ${task.text}
            <button>Add users</button>
        </form>
    </div>
</div>-->
<#if oneTask??>
    ${task.text}<br>
            <button>Add users</button>

<#elseif !oneTask??>
    <#if cards??>
        <#list cards as card>
        <tr>
            <td>${card.name}</td>
        <br>
            <#if tasks??>
                <#list tasks as task>
        <tr>
            <td>
                <a href="/cards/${card.id}/tasks/${task.id}">${task.text}</a>
            </td>
            <br>
        </tr>
                </#list>
            </#if>
        </tr>
        </#list>
    </#if>

</#if>
<br>
<br>
<br>
<form method="post">
    <input type="text" id="text" name="text">
    <button type="submit" id="save">Add task</button>
</form>
</body>
</html>
