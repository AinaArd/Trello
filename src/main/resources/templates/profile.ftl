<html>
<head>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Bai+Jamjuree" rel="stylesheet">
</head>
<body>
<div onclick="show('none')" id="gray"></div>
<div id="window">
    <div class="form">
        <form method="post">
            <input type="text" name="name" placeholder="Name"/>
            <input type="text" name="login" placeholder="Login"/>
            <input type="password" name="password" placeholder="Password"/>
            <button type="submit" class="btn btn-primary btn-block btn-large">EDIT</button>
        </form>
    </div>
</div>
<div class="mainBlock">
    <div>
        <table>
            <tr>
                <td style="
	vertical-align: middle;
	text-align: center;">
                    <div class="profile">
                        <img src="/css/Auth.png" height="130px" width="130px">
                    </div>
                    <div class="profile2">Name: ${user.name}<br>@${user.login}<br><br>
                        <button id="Rec" onclick="show('block')">EDIT</button>
                        <form action="/logout">
                            <button id="Rec">LOG OUT</button>
                        </form>
                    </div>

                </td>
            </tr>

        </table>
    </div>

    <ul>
        <#if cards ??>
            <#list cards as card>
                        <li>
                            <p>${card.name}</p>
                            <p>${card.state}</p>
                            <p>${card.date}</p>
                            <br>
                            <br>
                            <br>
                        </li>
            </#list>
        </#if>
    </ul>

</div>
<script>
    //Функция показа
    function show(state) {
        document.getElementById('window').style.display = state;
        document.getElementById('gray').style.display = state;
    }
</script>
</body>
</html>
