<html>
<head>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="form-style-2">
    <div class="form-style-2-heading">
    ${task.name}
    </div>
    <#if noText??>
        <form method="get">
            <label for="newText">Add text to the task
                <input class="input-field" type="text" id="newText" name="newText">
            </label>
        </form>
    <#else>
        ${task.text}
    <br>
    <br>
        <form method="post">Edit task
            <label for="name">Name
                <input class="input-field" type="text" id="name" name="name" value="${task.name}">
            </label>
            <label for="text">Text
                <input class="input-field" type="text" id="text" name="text" value="${task.text}">
            </label>
            <input type="submit" value="Save"/>
        </form>
    </#if>
    <br>
    <br>
    <form method="get">
        <input type="submit" value="Add users to task"/>
    </form>
    <form method="get">
        <input type="submit" value="Archive"/>
    </form>
</div>
</body>
</html>
