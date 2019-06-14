<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Bai+Jamjuree" rel="stylesheet">
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>
    <#--    <link href="/css/header.css" rel="stylesheet"/>-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
</head>
<body>
<#--<nav class="navbar navbar-expand-lg navbar-light bg-light">-->
<#--    <div class="collapse navbar-collapse" id="navbarSupportedContent">-->
<#--        <ul style="list-style-type:none">-->
<#--            <li><a href="/profile">Profile</a></li>-->
<#--            <li><a href="/desks">Desks</a></li>-->

<#--            <li>-->
<#--                <form action="/logout">-->
<#--                    <p><input type="submit" value="Log out"-->
<#--                              class="btn btn-primary btn-learn"/></p>-->
<#--                </form>-->
<#--            </li>-->
<#--        </ul>-->

<#--    </div>-->
<#--</nav>-->

<#--<nav class="navbar navbar-dark bg-dark">-->
<#--    <form class="form-inline">-->
<#--        <a href="/profile" class="btn btn-outline-success" type="button">Profile</a>-->
<#--        <a href="/desks" class="btn btn-outline-success" type="button">Desks</a>-->
<#--        <form action="/logout">-->
<#--            <p><input type="submit" value="Log out"-->
<#--                      class="btn btn-primary btn-learn"/></p>-->
<#--        </form>-->
<#--    </form>-->
<#--</nav>-->

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="#">Trello</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Profile
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Desks</a>
                </li>
                <li class="nav-item">
                    <form action="/logout">
                        <p><input type="submit" value="Log out"
                                  class="btn btn-primary btn-learn"/></p>
                    </form>
                </li>
            </ul>
        </div>
    </div>
</nav>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</body>
</html>