<html>
<head>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script></head>
<body>

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
            <input type="submit" value="Save"/>
        </form>
    </#if>
    <input type="submit" value="Add users to task" onclick="show(document.getElementById('findUser'))""/>
    <br>
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

    <form method="get">
        <input type="submit" value="Archive"/>
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
</body>
</html>
