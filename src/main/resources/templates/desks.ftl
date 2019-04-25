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
        </#list><br>
        <#--<#if flag??>
        <button onclick="show('block')">Add desk</button>
        <br>
        </#if>-->

<#if cards??>
    <#list cards as card>
        ${card.name}<br>
        <#list card.card_tasks as task>
                    <ul>
                        <li><#--<a href="/tasks/${task.id}">-->${task.text}</li>
                        <br>
                    </ul>
        </#list>
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
