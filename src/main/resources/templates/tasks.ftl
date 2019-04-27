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
            <label for="text">Add text to the task
                <input class="input-field" type="text" id="text" name="text">
            </label>
        </form>
    <#else>
        ${task.text}
    <br>
    <br>
        <form method="get">Edit task
            <label for="taskName">Name
                <input class="input-field" type="text" id="taskName" name="taskName" value="${task.name}">
            </label>
            <label for="taskText">Text
                <input class="input-field" type="text" id="taskText" name="taskText" value="${task.text}">
            </label>
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
