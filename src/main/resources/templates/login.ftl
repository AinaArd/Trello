<!DOCTYPE html>
<html lang="en" >

<head>
    <meta charset="UTF-8">
    <title>Login Form</title>
    <link rel="stylesheet" type="text/css" href="/css/login.css">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>

</head>

<body>

<div class="login">
    <h1>Login</h1>
    <form method="post"> <#--onsubmit="return validate_form();"-->
        <input id="login" type="text" name="login" placeholder="Username" required/>
        <input id="password" type="password" name="password" placeholder="Password" required />
        <center style="color: white;">Remember me<input class="c" type="checkbox" name="c"/></center>
        <input type="submit" class="btn btn-primary btn-block btn-large"/>
    </form>
</div>
<#--<script type="text/javascript">-->
    <#--var validate_form = function () {-->
        <#--var l = document.getElementById("login");-->
        <#--var p = document.getElementById("password");-->
        <#--var re = /^(?=.*[A-Za-z0-9]$)[A-Za-z][A-Za-z\d.-]{1,19}$/;-->
        <#--if (!re.test(l.value)) {-->
            <#--alert("wrong login");-->
        <#--}-->
        <#--;-->
        <#--var re2 = /(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{6,}/;-->
        <#--if (!re2.test(p.value)) {-->
            <#--alert("wrong password");-->
        <#--}-->
        <#--;-->
        <#--return re.test(l.value) && re2.test(p.value);-->
    <#--}-->
<#--</script>-->
</body>

</html>
