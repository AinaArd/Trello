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
    <div id="task-id" data-id="${task.id}" class="form-style-2-heading">
        ${task.name}
    </div>
    <div> Members:
        <#if task.users??>
            <#list task.users as member>
                <a href="/profile/${member.id}">${member.name}</a>
                <div id="member"></div>
            </#list>
        </#if>
    </div>
    <br>
    State: ${task.state}
    <br>
    <#if noPic??>
        <img src="/static/images/default.png" alt="Default picture">
        <#else><img src="/static/images/about.jpg" height="130px" width="130px" alt="Task picture">
    </#if>
    <br>
    <br>
    <#if noText??>
        <form method="post">
            <label for="text">Add text to the task
                <input class="input-field" type="text" id="text" name="text" required="required">
            </label>
            <input type="submit" value="Save"/>
        </form>
    <#else>
        Description: ${task.text}
        <br>
        <br>
        Term: ${task.term}
        <br>
        <br>
        Comments:
        <br>
        <br>
        <ul id="ul-id${task.id}">
            <#list task.comments as comment>
                <li>
                    <div id="${comment.id}">
                        ${comment.author.name}:
                        <b data-contain-user-tags>${comment.content}</b>
                    </div>
                </li>
            </#list>
        </ul>
        <br>

        <div id="commentTask" class="form-group purple-border">
            <label for="comment">Comment
                <textarea class="form-control" id="comment" name="comment" rows="3"></textarea>
            </label>
            <button class="button-add" onclick="commentTask(event)" id="${task.id}" name="comment-btn">Comment</button>
        </div>
        <br>

        <input type="submit" value="Edit task" onclick="show(document.getElementById('edit'))""/>
        <br>
        <br>

        <form method="post" id="edit" style="display: none;" enctype="multipart/form-data">
            <div class="edit">Edit task</div>
            <label for="name">Name
                <input class="input-field" type="text" id="name" name="name" value="${task.name}" required="required">
            </label>
            <label for="text">Text
                <input class="textarea-field" id="text" name="text" required="required" value="${task.text}">
            </label>
            <label for="state">State
                <select id="state" name="state" class="mdb-select md-form" required="required">
                    <option value="" disabled selected>Choose task state</option>
                    <option value="TODO">TODO</option>
                    <option value="IN_PROCESS">IN_PROCESS</option>
                    <option value="DONE">DONE</option>
                    <option value="FOR_CHECK">FOR_CHECK</option>
                </select>
            </label>
            <input type="file" name="file" id="file">
            <br>
            <input type="submit" value="Save"/>
        </form>
    </#if>

    <label for="user-name">
        <input type="submit" id="user-name" name="user-name" value="Add users to task"
               onclick="show(document.getElementById('findUser'))"/>
    </label>

    <div id="findUser" style="display: none;">
        <div id="div-users">
            <label for="users">Find user
                <input class="input-field" type="text" id="search" name="users" oninput="addUsersToTask()">
            </label>
            <div id="result"></div>
            <br>
            <br>
            <div id="user-candidates"></div>
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
<script type="application/javascript" src="/js/users-mentions.js"></script>
<script type="application/javascript" src="/js/users.js"></script>
<script type="application/javascript" src="/js/tasks.js"></script>
</body>
</html>
