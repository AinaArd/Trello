<html>
<head>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
    <link href="/css/deskStyles.css" rel="stylesheet" type="text/css">
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

</head>
<body>
<#include "header.ftl">
<div class="background-style container" style="margin:0 auto; width: fit-content">
    <div class="form-style-2">
        <div class="form-style-2-heading">
            <#if selectedDesk??>
                <div style="font-size: xx-large" data-id="${selectedDesk.id}" id="desk-id">
                    ${selectedDesk.name}&nbsp;&nbsp;
                </div>
                <br>
<<<<<<< HEAD
                <#if selectedDesk.users??>
                    <#list selectedDesk.users as member>
                        <div id="${member.id}">
                            <a href="/profile/${member.id}">${member.name}</a>
                            <button class="button-add" id="${member.id}" onclick="deleteUserFromDesk(event)">Delete
                            </button>
                            <br>
                            <div id="member"></div>
                            <br>
                        </div>
                    </#list>
                </#if>
            </div>
            <br>
            <label class="label-infol" for="input">Invite
                <input class="input-field" type="text" id="input" name="users" oninput="addUsersToDesk()">
            </label>
            <br>
            <div id="result"></div>

            <form action="/chat/${selectedDesk.id}">
                <input type="submit" value="Chat">
            </form>
        <#else>User desks
        </#if>
    </div>
    <ul>
        <#if userDesks ??>
            <#list userDesks.ownDesks as desk>
                <li id="${desk.id}">
                    <a href="/desks/${desk.id}">${desk.name}</a>&nbsp;&nbsp;
                    ${desk.state}
=======
                Creator: ${selectedDesk.owner.name}
                <#if public??>
                    <div> Members:
                        <br>
                        <#if selectedDesk.users??>
                            <#list selectedDesk.users as member>
                                <div id="${member.id}">
                                    <a href="/profile/${member.id}">${member.name}</a>
                                    <button class="button-add" id="${member.id}" onclick="deleteUserFromDesk(event)">
                                        Delete
                                    </button>
                                    <br>
                                    <br>
                                </div>
                            </#list>
                        </#if>
                        <div id="member"></div>
                    </div>
>>>>>>> mongoDB
                    <br>

                    <label class="label-infol" for="input">Invite
                        <input class="input-field" type="text" id="input" name="users" oninput="addUsersToDesk()">
                    </label>

                    <br>
<<<<<<< HEAD
                    <input class="button-add" id="${desk.id}" name="delete" onclick="deleteDesk(event)" type="submit"
                           value="Delete">
                </li>
            </#list>
            <br>
        </#if>
    </ul>
=======
                    <div id="result"></div>
>>>>>>> mongoDB

                    <form action="/chat/${selectedDesk.id}">
                        <input type="submit" value="Chat">
                    </form>
                </#if>
            <#else>User desks
            </#if>
        </div>
        <ul>
            <#if userDesks ??>
                Own desks:
                <#list userDesks.ownDesks as desk>
                    <li id="${desk.id}">
                        <a href="/desks/${desk.id}">${desk.name}</a>&nbsp;&nbsp;
                        ${desk.state}
                        <br>
                        <br>
                        <input class="button-add" id="${desk.id}" name="delete" onclick="deleteDesk(event)"
                               type="submit"
                               value="Delete">
                    </li>
                    <br>
                </#list>

                <#if userDesks.desks??>
                    <#list userDesks.desks as desk>
                        <li id="${desk.id}">
                            <a href="/desks/${desk.id}">${desk.name}</a>&nbsp;&nbsp;
                            ${desk.state}
                            <br>
                            <br>
                            <input class="button-add" id="${desk.id}" name="delete" onclick="deleteDesk(event)"
                                   type="submit"
                                   value="Delete">
                        </li>
                        <br>
                    </#list>
                </#if>
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
                    <select id="state" name="state" class="mdb-select md-form" required="required">
                        <option value="" disabled selected>Choose desk state</option>
                        <option value="PUBLIC">PUBLIC</option>
                        <option value="PRIVATE">PRIVATE</option>
                    </select>
                </label>

                <br>
                <input type="submit" name="saveDesc" value="Save">
            </form>
            <br>
        </#if>

        <#if cards??>
            <ul id="cards">
                <#list cards as card>
                    <li id="oneCard">
                        <div class="dropdown" id=card${card.id}>
                            Card:<span id="name${card.id}" class="card-name"> ${card.name}
                    </span>
                            &nbsp;&nbsp
                            <a id="menu${card.id}" class="dropdown-toggle" data-toggle="dropdown" href="#">Actions</a>
                            <br>
                            <br>
                            <ul class="dropdown-menu">
                                <li><a href="#" onclick="show(document.getElementById('addTaskTo${card.id}'))">Add
                                        task</a>
                                </li>
                                <li><a href="#" id="${card.id}" onclick="changeType(event)">Edit name</a></li>
                            </ul>
                        </div>
                        <ul id="ul-id${card.id}">
                            <#list card.cardTasks as task>
                                <#if task.flag == false>
                                    <li>
                                        <div id="task${task.id}" data-cardId="${card.id}">
                                            <a href="/tasks/${task.id}">${task.name}</a>
                                            State: ${task.state}
                                            Term: ${task.term}
                                        </div>
                                        <br>
                                    </li>
                                <#elseif task.flag == true>
                                    <li>
                                        Task is archived
                                        <br>
                                        <form method="post">
                                            <input type="hidden" value="${task.id}" name="task-id">
                                            <input type="submit" class="button-add" <#--onclick="returnTask(event)"-->
                                                   name="return"
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
                            <label for="date">Term: </label>
                            <input type="date" id="date${card.id}" name="date"/>
                            <br>
                            <br>
                            <button class="button-add" onclick="addTask(event)" id="${card.id}">Add task</button>
                        </div>
                        <br>
                        <br>
                    </li>
                </#list>
            </ul>
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
    </div>

    <script>
        function show(div) {
            if (div.style.display === "none") {
                div.style.display = "block";
            } else
                div.style.display = "none"
        }
    </script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <script type="application/javascript" src="/js/jquery-1.9.1.js"></script>
    <script type="application/javascript" src="/js/users.js"></script>
    <script type="application/javascript" src="/js/tasks.js"></script>
    <script type="application/javascript" src="/js/cards.js"></script>
    <script type="application/javascript" src="/js/desks.js"></script>
</body>
</html>
