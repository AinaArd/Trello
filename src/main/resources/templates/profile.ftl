<#--<html>
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
<!------ Include the above in your HEAD tag ---------->
</head>
<body>
<div onclick="show('none')" id="gray"></div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                <h4 class="modal-title" id="myModalLabel">More About Joe</h4>
            </div>
            <div class="modal-body">
                <center>
                    <img src="https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRbezqZpEuwGSvitKy3wrwnth5kysKdRqBW54cAszm_wiutku3R" name="aboutme" width="140" height="140" border="0" class="img-circle"></a>
                    <h3 class="media-heading">Joe Sixpack <small>USA</small></h3>
                    <span><strong>Skills: </strong></span>
                    <span class="label label-warning">HTML5/CSS</span>
                    <span class="label label-info">Adobe CS 5.5</span>
                    <span class="label label-info">Microsoft Office</span>
                    <span class="label label-success">Windows XP, Vista, 7</span>
                </center>
                <hr>
                <center>
                    <p class="text-left"><strong>Bio: </strong><br>
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut sem dui, tempor sit amet commodo a, vulputate vel tellus.</p>
                    <br>
                </center>
            </div>
            <div class="modal-footer">
                <center>
                    <button type="button" class="btn btn-default" data-dismiss="modal">I've heard enough about Joe</button>
                </center>
            </div>
        </div>
    </div>
</div>

<div id="window">
<div class="container">
    <div class="span3 well">
        <center>
            <a href="#" onclick="show('block')" data-toggle="modal" data-target="#myModal">
                <img src="https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRbezqZpEuwGSvitKy3wrwnth5kysKdRqBW54cAszm_wiutku3R" name="aboutme" width="140" height="140" class="img-circle">
            </a>
            <h3>${user.name}</h3>
            <h5>@${user.login}</h5>
            <em>click my face for more</em>
        </center>
    </div>

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
</html>