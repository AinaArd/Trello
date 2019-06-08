<html>
<head>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>

<div class="form-style-2">
    <div class="form-style-2-heading">
        ${user.name}
    </div>

    <br>

    @${user.login}<br>
    <div class="form-style-2">
        Tasks:
    </div>

    <#list user.tasks as task>
        <ul>
            <li>${task.name}&nbsp;&nbsp;${task.state}</li>
        </ul>
    </#list>

</div>
</body>
</html>

