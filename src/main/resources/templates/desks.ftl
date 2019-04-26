<html>
<head>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div onclick="show('none')" id="gray"></div>

<div class="form-style-2">
    <div class="form-style-2-heading">
        <#if deskName??>
            This desk cards
        <#else>User desks
        </#if>
    </div>
    <ul>
        <#if userDesks ??>
            <#list userDesks.ownDesks as desk>
                <li>
                    <a href="/desks/${desk.id}">${desk.name} </a>
                    <br>
                    ${desk.state}
                    <br>
                </li>
            </#list>
            <br>
        </#if>
    </ul>

<#if addDesk??>
 <div class="form-style-2-heading">
     If you want to add new desk, enter the name
 </div>
    <form method="post">
        <label for="name">Name
            <input class="input-field" type="text" id="name" name="name">
        </label>
        <label for="state">State
            <input class="input-field" type="text" id="state" name="state">
        </label>
        <br>
        <input type="submit" value="Save">
    </form>
<br>
</#if>

<#if cards??>
    <#list cards as card>
        ${card.name}<br>
        <#list card.cardTasks as task>
                    <ul>
                        <li><#--<a href="/tasks/${task.id}">-->${task.text}</li>
                        <br>
                    </ul>
        </#list>
    </#list>

    <#if addCard??>
     <div class="form-style-2-heading">
         If you want to add new card, enter the name
     </div>
    <form method="post">
        <label for="name">Name
            <input class="input-field" type="text" id="name" name="name">
        </label>
        <br>
        <input type="submit" value="Save">
    </form>
<br>
    </#if>
</#if>
</div>

<div id="window">
    <input type="text" name="login" placeholder="Login"/><br>
    <button class="btn btn-primary btn-block btn-large">Search</button>
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
