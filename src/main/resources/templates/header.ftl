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

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <span class="navbar-brand">Trello</span>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item ">
                    <a class="nav-link" href="/profile">Profile
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/desks">Desks</a>
                </li>
                <li class="nav-item">
                    <form action="/logout" class="form-logout">
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