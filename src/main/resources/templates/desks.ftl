<html>
<head>
<link href="/css/deskStyles.css" rel="stylesheet" type="text/css">
    <#--<link href="/css/styles.css" rel="stylesheet" type="text/css">-->

</head>
<body>
<div onclick="show('none')" id="gray"></div>

<div>
    <h2>User desks</h2>
</div>
        <#list desks as desk>
            <tr>
                <td><a href="/desks/${desk.id}">${desk.name} </a></td>
                <br>
                <td>${desk.state}</td>
                <br>
            </tr>
        </#list>

<br>

<#if cards??>
    <#list cards as card>
        ${card.name}<br>
        <#if tasks??>
            <#list tasks as task>
                <#list task as item>
                    <tr>
                        <td><#--<a href="/tasks/${task.id}">-->${item.text}</td>
                        <br>
                    </tr>
                </#list>
            </#list>
        </#if>
    </#list>
</#if>

<div id="window">
    <form method="post">
        <input type="text" name="name" placeholder="Name"/><br>
        <input type="text" name="state" placeholder="State"/>
        <button type="submit" class="btn btn-primary btn-block btn-large">Add desk</button>
    </form>
</div>

<script>
    //Функция показа
    function show(state) {
        document.getElementById('window').style.display = state;
        document.getElementById('gray').style.display = state;
    }
</script>
</body>
</html>
