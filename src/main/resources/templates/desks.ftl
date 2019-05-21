<html>
<head>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

</head>
<body>
<#--<div onclick="show('none')" id="gray"></div>-->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<#include "header.ftl">
<div class="form-style-2">
    <div class="form-style-2-heading">
        <#if selectedDesk??>
            <div style="font-size: xx-large" data-id="${selectedDesk.id}" id="desk-id">
                ${selectedDesk.name}&nbsp;&nbsp;
            </div>
            Creator: ${selectedDesk.owner.name}
            <div> Members:
                <#if selectedDesk.users??>
                    <#list selectedDesk.users as member>
                        <a href="/profile/${member.id}">${member.name}</a>
                        <div id="member"></div>
                    </#list>
                <#else> no users in this desk yet
                </#if>
            </div>
            <br>
            <label class="label-infol" for="input">Invite
                <input class="input-field" type="text" id="input" name="users" oninput="addUsersToDesk()">
            </label>
            <br>
            <div id="result"></div>
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
                <input class="input-field" type="text" id="name" name="name" required="required">
            </label>
            <label for="state">State
                <input class="input-field" type="text" id="state" name="state" required="required">
            </label>
            <br>
            <input type="submit" name="saveDesc" value="Save">
        </form>
        <br>
    </#if>

    <#if cards??>
        <#list cards as card>
            <div class="dropdown" id=card${card.id}>
            <span class="card-name">Card: ${card.name}
            </span>
                &nbsp;&nbsp;
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">Actions<span class="caret"></span></a>
                <br>
                <br>
                <ul class="dropdown-menu">
                    <li><a href="#" onclick="show(document.getElementById('addTaskTo${card.id}'))">Add task</a></li>
                    <li><a href="#">Edit name</a></li>
                </ul>
            </div>
            <ul id="ul-id${card.id}">
                <#list card.cardTasks as task>
                    <#if task.flag == false>
                        <li>
                            <div id="task${task.id}" data-cardId="${card.id}">
                                <a href="/tasks/${task.id}">${task.name}</a>
                                State: ${task.state}
                            </div>
                            <br>
                        </li>
                    <#elseif task.flag == true>
                        <li>
                            Task is archived
                            <br>
                            <form method="post">
                                <input type="hidden" value="${task.id}" name="task-id">
                                <input type="submit" class="button-add" <#--onclick="returnTask(event)"--> name="return"
                                       value="Return"/>
                            </form>
                        </li>
                    </#if>

                </#list>
            </ul>
            <div id="addTaskTo${card.id}" style="display: none;">
                Enter task name
                <input class="input-field" type="text" name="name" id="input${card.id}" required="required">
                <br>
                <br>
                <label for="taskState">State
                    <select id="state${card.id}" name="state" class="mdb-select md-form">
                        <option value="" disabled selected>Choose task state</option>
                        <option value="TODO">TODO</option>
                        <option value="IN_PROCESS">IN_PROCESS</option>
                        <option value="DONE">DONE</option>
                        <option value="FOR_CHECK">FOR_CHECK</option>
                    </select>
                </label>
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
                    <input class="input-field" type="text" id="name" name="name" required="required">
                </label>
                <br>
                <input type="submit" name="saveCard" value="Save">
            </form>
            <br>
        </#if>
    </#if>
    <script>
        function show(div) {
            if (div.style.display === "none") {
                div.style.display = "block";
            } else
                div.style.display = "none"
        }
    </script>

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
    <script type="application/javascript" src="/js/users.js"></script>
</body>
</html>
