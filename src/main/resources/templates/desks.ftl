<html>
<head>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
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
                    <a href="/desks/${desk.id}">${desk.name}</a>&nbsp;&nbsp;
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

        <div class="dropdown" id=card${card.id}>

            ${card.name}&nbsp;&nbsp;<a class="dropdown-toggle" data-toggle="dropdown" href="#">Actions<span
                class="caret"></span></a>
            <br>
            <br>
            <ul class="dropdown-menu">
                <li><a href="#">Add task</a></li>
                <li><a href="#">Edit name</a></li>
            </ul>
        </div>
        <ul id="ul-id${card.id}">
            <#list card.cardTasks as task>
                <li>
                    <div id="task${task.id}" data-cardId="${card.id}">
                        <a href="/tasks/${task.id}">${task.name}</a>
                        <br>
                    </div>
                    <br>
                    <br>
                </li>
            </#list>
        </ul>
            <div id="addTaskName">
                <input class="input-field" type="text" id="input${card.id}">
                <br>
                <br>
                <button class="button-add" onclick="addTask(event)" id="${card.id}">Add task</button>
            </div>
    <br>
    <br>
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

<#-- <div id="window">
     <input type="text" name="login" placeholder="Login"/><br>
     <button class="btn btn-primary btn-block btn-large">Search</button>
 </div>

 <script>
     //Функция показа
     function show(state) {
         document.getElementById('window').style.display = state;
         document.getElementById('gray').style.display = state;
     }
 </script>-->
    <script type="application/javascript" src="/js/tasks.js"></script>
</body>
</html>
