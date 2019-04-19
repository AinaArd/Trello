<html>
<head>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">
    </div>

    <table>
        <#list desks as desk>
            <tr>
                <td>${desk.name}</td>
                <td>${desk.state}</td>
            </tr>
        </#list>
    </table>

</div>

</body>
</html>
