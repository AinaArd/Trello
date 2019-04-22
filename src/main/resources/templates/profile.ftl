<#--<html>
<head>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Bai+Jamjuree" rel="stylesheet">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

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
    <div class="profile">
        <img src="/css/Auth.png" height="130px" width="130px">
    </div>
    <div class="profile2">Name: ${user.name}<br>@${user.login}<br><br>
        <button id="Rec" onclick="show('block')">EDIT</button>
        <form action="/logout">
            <button id="Rec">LOG OUT</button>
        </form>
        <form action="/desks">
            <button id="Rec">DESKS</button>
        </form>
    </div>

</div>


<script>
    //Функция показа
    function show(state) {
        document.getElementById('window').style.display = state;
        document.getElementById('gray').style.display = state;
    }
</script>
</body>
</html>-->

<html>
<head>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>

<body>
<div class="container">
    <div class="span3 well">
        <center>
            <a href="#aboutModal" data-toggle="modal" data-target="#myModal"><img
                    src="https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRbezqZpEuwGSvitKy3wrwnth5kysKdRqBW54cAszm_wiutku3R"
                    name="aboutme" width="140" height="140" class="img-circle"></a>
            <h3>${user.name}</h3>
            <h5>@${user.login}</h5>
            <em>click my face for edit</em><br>
            <a href="/logout">LOG OUT</a>
            <form action="/desks">
                <button id="Rec">DESKS</button>
            </form>

        </center>
    </div>
    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                    <h4 class="modal-title" id="myModalLabel">EDIT</h4>
                </div>
                <div class="modal-body">
                    <div class="modal-body">
                        <form method="post">
                            <input type="text" name="name" placeholder="Name"/>
                            <input type="text" name="login" placeholder="Login"/>
                            <input type="password" name="password" placeholder="Password"/>
                        </form>
                    </div>
                    <hr>

                </div>
                <div class="modal-footer">
                    <center>
                        <button type="button" class="btn btn-default" data-dismiss="modal">DONE
                        </button>
                    </center>
                </div>
            </div>
        </div>
    </div>
</div>
</body>


</html>