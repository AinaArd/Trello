document.addEventListener("DOMContentLoaded", function (ev) {
    var a = document.body.querySelectorAll("[data-contain-user-tags]");
    for (var i = 0; i < a.length; i++) {
        a[i].innerHTML = checkForLogin(a[i].innerHTML);
    }
});

