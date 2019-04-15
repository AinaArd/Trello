<html>
<head>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="form-style-2">
    <div class="form-style-2-heading">
        Users
    </div>
    <table>
        <#list users as user>
            <tr>
                <td>${user.name}</td>
                <td>${user.login}</td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>
