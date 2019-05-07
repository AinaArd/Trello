function addUsers(event) {
    var id = event.target.id;
    var users = document.getElementById("usersto" + id);
    $.ajax({
        url: "/ajax/adduser",
        type: "post",
        data: {
            "users": users
        },
        success: function (users) {
            console.log("success");
            var text = document.createElement()
        }
    })
}