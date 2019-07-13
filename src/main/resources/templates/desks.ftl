<html>
<head>
    <title>Desks</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
    <link href="/css/deskStyles.css" rel="stylesheet" type="text/css">
    <link href="/css/dragDemo.css" rel="stylesheet" type="text/css">
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="//ajax.aspnetcdn.com/ajax/jquery.ui/1.10.3/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.10.3/themes/sunny/jquery-ui.css">
    <script type="application/javascript" src="/js/DragManager.js"></script>

</head>
<body>
<#include "header.ftl">
<div class="form-style-2">
    <div class="form-style-2-heading">
        <div class="col-md-6 background-style">
            <#if selectedDesk??>
            <div style="font-size: xx-large" data-id="${selectedDesk.id}" id="desk-id">
                ${selectedDesk.name}&nbsp;&nbsp;
            </div>
            <br>
            Creator: ${selectedDesk.owner.name}
            <#if public??>
                <div> Members:
                    <br>
                    <#if selectedDesk.users??>
                        <#list selectedDesk.users as member>
                            <div id="${member.id}">
                                <a href="/profile/${member.id}">${member.name}</a>
                                <button class="button-add" id="${member.id}"
                                        onclick="deleteUserFromDesk(event)">
                                    Delete
                                </button>
                                <br>
                                <br>
                            </div>
                        </#list>
                    </#if>
                </div>
                <div id="member"></div>
                <br>

                <label class="label-infol" for="input">Invite
                    <input class="input-field" type="text" id="input" name="users" oninput="addUsersToDesk()">
                </label>

                <br>
                <div id="result"></div>

                <form action="/chat/${selectedDesk.id}">
                    <input type="submit" value="Chat">
                </form>

                <br>

                <button class="button-add" onclick="show(document.getElementById('addCard'))">Add card
                </button>
            </#if>
            <div id="addCard" style="display: none;">
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
            </div>
        </div>
        <#else>User desks
        </#if>

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
        <input type="button" onclick="show(document.getElementById('addDesk'))" value="Add desk">
        <br>

        <div id="addDesk" style="display: none;">
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
        </div>
</#if>
    </div>
    <div class="col-md-6 cards-style">
        <#if cards??>
            <div id="cards">
                <#list cards as card>
                    <div id="сard_${card.id}" data-id="${card.name}" class="droppable div-class"
                         style="height: fit-content; width: fit-content">
                        <div class="dropdown header" id=card${card.id}>
                            Card:<span id="name${card.id}" class="card-name"> ${card.name}</span>
                            &nbsp;&nbsp
                            <a id="menu${card.id}" class="dropdown-toggle" data-toggle="dropdown"
                               href="#">Actions</a>
                            <br>
                            <br>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="#"
                                       onclick="show(document.getElementById('addTaskTo${card.id}'))">Add
                                        task</a>
                                </li>
                                <li>
                                    <a href="#" id="${card.id}" onclick="changeType(event)">Edit name</a>
                                </li>
                            </ul>
                        </div>

                        <ul id="ul-id${card.id}" class="list">
                            <#list card.cardTasks as task>
                                <#if task.flag == false>

                                    <li class="draggable">
                                        <div id="task${task.id}" data-cardId="${card.id}"
                                             style="text-align: left">
                                            <a href="/tasks/${task.id}" id="1">${task.name}</a>
                                        </div>
                                    </li>

                                <#elseif task.flag == true>
                                    <li>
                                        Task is archived
                                        <br>
                                        <form method="post">
                                            <input type="hidden" value="${task.id}" name="task-id">
                                            <input type="submit"
                                                   class="button-add" onclick="returnTask(event)"
                                                   name="return"
                                                   value="Return"/>
                                        </form>
                                    </li>
                                </#if>
                            </#list>
                        </ul>
                        <div id="addTaskTo${card.id}" style="display: none;">
                            Enter task name
                            <input class="input-field" type="text" name="name" id="input${card.id}"
                                   required="required">
                            <br>
                            <br>
                            <#--<label for="taskState">State
                                <select id="state${card.id}" name="state" class="mdb-select md-form">
                                    <option value="" disabled selected>Choose task state</option>
                                    <option value="TODO">TODO</option>
                                    <option value="IN_PROCESS">IN_PROCESS</option>
                                    <option value="DONE">DONE</option>
                                    <option value="FOR_CHECK">FOR_CHECK</option>
                                </select>
                            </label>-->
                            <br>
                            <label for="date">Term: </label>
                            <input type="date" id="date${card.id}" name="date"/>
                            <br>
                            <br>
                            <button class="button-add" onclick="addTask(event)" id="${card.id}">Add task
                            </button>
                        </div>
                        <br>
                        <br>
                    </div>
                </#list>
            </div>
        </#if>
    </div>
    <br>
    <br>

</div>

<script>
    function show(div) {
        if (div.style.display === "none") {
            div.style.display = "block";
        } else
            div.style.display = "none"
    }
</script>

<script>
    function onDrag() {
        var DragManager = new DragManagerFunc();
        DragManager.onDragCancel = function (dragObject) {
            dragObject.avatar.rollback();
        };

        DragManager.onDragEnd = function (dragObject, dropElem) {
            var ul1 = dropElem.querySelector('.list');

            //ajax
            changeState(dragObject, dropElem);
            var myLi = dragObject.elem.firstElementChild;
            var href = $("a#1").attr('href');

            var li = document.createElement("li");
            var a = document.createElement("a");
            a.href = href;
            a.innerHTML = dragObject.elem.innerText;

            li.className = "draggable";
            li.style = "text-align:left";
            dragObject.elem.hidden = true;
            li.appendChild(a);
            ul1.appendChild(li);
        };
    }

    onDrag();
</script>

<script>
    //Make the DIV element draggable:
    <#if cards??>
    <#list cards as card>
    dragElement(document.getElementById(("сard_${card.id}")));
    </#list>
    </#if>


    function dragElement(elmnt) {
        // console.log(elmnt);
        var pos1 = 0, pos2 = 0, pos3 = 0, pos4 = 0;
        var elemName = elmnt.querySelector(".header");
        if (elemName) {
            elemName.onmousedown = dragMouseDown;
        }

        function dragMouseDown(e) {
            e = e || window.event;
            // get the mouse cursor position at startup:
            pos3 = e.clientX;
            pos4 = e.clientY;
            document.onmouseup = closeDragElement;
            // call a function whenever the cursor moves:
            document.onmousemove = elementDrag;

            document.ondragstart = function () {
                return false
            };
            document.body.onselectstart = function () {
                return false
            }

        }

        function elementDrag(e) {
            e = e || window.event;
            // calculate the new cursor position:
            pos1 = pos3 - e.clientX;
            pos2 = pos4 - e.clientY;
            pos3 = e.clientX;
            pos4 = e.clientY;
            // set the element's new position:
            elmnt.style.top = (elmnt.offsetTop - pos2) + "px";
            elmnt.style.left = (elmnt.offsetLeft - pos1) + "px";
        }

        function closeDragElement() {
            /* stop moving when mouse button is released:*/
            document.onmouseup = null;
            document.onmousemove = null;
            onDrag();
        }
    }
</script>

<script src="https://cdn.polyfill.io/v1/polyfill.js?features=Element.prototype.closest"></script>
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
