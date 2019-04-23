<html>
<head>
    <link href="/css/deskStyles.css" rel="stylesheet" type="text/css">
</head>
<body>

<div>
    <h2>User desks</h2>
</div>
        <#list desks as desk>
            <tr>
                <a href="/desks/${desk.id}">
                    <td>${desk.name}</td>
                </a>
                <td>${desk.state}</td>
                <br>
            </tr>
        </#list>
</div>

</body>
</html>
