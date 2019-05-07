<html>
<head>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Edit user info
    </div>
    <form method="post">
        <label for="name">Name
            <input class="input-field" type="text" id="name" name="name" value="${user.name}">
        </label>
        <br>
        <label for="oldLogin">Old login
            <input class="input-field" type="text" id="oldLogin" name="oldLogin" value="${user.login}">
        </label>
        <label for="newLogin">New login
            <input class="input-field" type="text" id="newLogin" name="newLogin">
        </label>
        <br>
        <label for="OldPassword">Old password
            <input class="input-field" type="password" id="OldPassword" name="OldPassword">
        </label>
        <label for="NewPassword">New password
            <input class="input-field" type="password" id="NewPassword" name="NewPassword">
        </label>

        <br>
        <input type="submit" value="Save">
    </form>
</div>

</body>
</html>
