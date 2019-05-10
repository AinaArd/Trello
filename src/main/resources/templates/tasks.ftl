<html>
<head>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<#include "header.ftl">
<div class="form-style-2">
    <div class="form-style-2-heading">
    ${task.name}
    </div>
    State: ${task.state}
    <br>
    <br>
    <#if noText??>
        <form method="post">
            <label for="text">Add text to the task
                <input class="input-field" type="text" id="text" name="text">
            </label>
            <input type="submit" value="Save"/>
        </form>
    <#else>
        Description: ${task.text}
    <br>
    <br>
    Comments:
        <br>
        <br>
         <ul id="ul-id${task.id}" typeof="">
            <#list task.comments as comment>
                <li>${comment.author.name}:  ${comment.content}</li>
            </#list>
         </ul>
     <br>

    <div id="commentTask">
        <label for="comment">Comment
            <textarea class="textarea-field" id="comment" name="comment"></textarea>
        </label>
        <button class="button-add" onclick="commentTask(event)" id="${task.id}">Comment</button>
    </div>
    <br>

    <input type="submit" value="Edit task" onclick="show(document.getElementById('edit'))""/>
    <br>
    <br>

        <form method="post" id="edit" style="display: none;">
            <div class="edit">Edit task</div>
            <label for="name">Name
                <input class="input-field" type="text" id="name" name="name" value="${task.name}">
            </label>
            <label for="text">Text
                <textarea class="textarea-field" id="text" name="text">${task.text}</textarea>
            </label>
            <label for="state">State
                <select id="state" name="state" class="mdb-select md-form">
                    <option value="" disabled selected>Choose task state</option>
                    <option value="TODO">TODO</option>
                    <option value="IN_PROCESS">IN_PROCESS</option>
                    <option value="DONE">DONE</option>
                    <option value="FOR_CHECK">FOR_CHECK</option>
                </select>
            </label>
            <input type="submit" value="Save"/>
        </form>
    </#if>

    <label for="user-name">
        <input type="submit" id="user-name" name="user-name" value="Add users to task"
               onclick="show(document.getElementById('findUser'))"/>
    </label>
    <br>

    <div id="findUser" style="display: none;">
        <div id="div-users">
            <label for="users">Find user
                <input class="input-field" type="text" id="usersto${task.id}" name="users">
            </label>
            <button class="button-add" id="${task.id}" onclick="addUsers(event)">Search</button>
            <br>
            <br>
        </div>
    </div>

    <form method="post">
        <input type="submit" name="archive" value="Archive"/>
    </form>
</div>

<script>
    function show(div) {
        if (div.style.display === "none") {
            div.style.display = "block";
        } else
            div.style.display = "none"
    }
</script>
<script type="application/javascript" src="/js/users.js"></script>
<script type="application/javascript" src="/js/tasks.js"></script>
</body>
</html>
