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
    <form>
        ${user.name}

        <br>

            @${user.login}

        <br>
        <br>
        <br>
        <form action="/edit">
            <input type="submit" value="EDIT"/>
        </form>
        <form action="/logout">
            <input type="submit" value="LOG OUT"/>
        </form>
        <form action="/desks">
            <input type="submit" value="DESKS"/>
        </form>
    </form>
</div>
</body>
</html>

