<html>
<head>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>

<div class="form-style-2">
    <div class="form-style-2-heading">
        User profile
    </div>

${user.name}

    <br>

    @${user.login}<br>
    <div class="form-style-2">
        Tasks:
    </div>

        <#list user.tasks as task>
            <ul>
                <li>${task.name}</li>
            </ul>
        </#list>

</div>
</body>
</html>
