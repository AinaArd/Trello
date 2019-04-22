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
                <td>${desk.name}</td>
                <td>${desk.state}</td><br>
            </tr>
        </#list>
</div>

</body>
</html>
