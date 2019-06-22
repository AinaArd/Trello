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
        Desks:
    </div>

    <#if user.desks??>
        <#list user.desks as desk>
            <ul>
                <li>
                    <a href="/desks/${desk.id}">${desk.name}&nbsp;&nbsp;</a> ${desk.state}</li>
            </ul>
        </#list>
    <#else>
        User doesn't have any desk!
    </#if>

    <div class="form-style-2">
        Tasks:
    </div>

    <#if user.tasks??>
        <#list user.tasks as task>
            <ul>
                <li><a href="/tasks/${task.id}">${task.name}&nbsp;&nbsp;</a> ${task.state}</li>
            </ul>
        </#list>
    <#else>
        User doesn't have any task!
    </#if>

</div>
</body>
</html>

