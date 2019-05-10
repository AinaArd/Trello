function addUsers(event) {
    var id = event.target.id;
    var search = document.getElementById("usersto" + id);
    $.ajax({
        url: "/ajax/adduser",
        type: "post",
        data: {
            "id": id,
            "search": search.value
        },
        success: function (users) {
            var usersNames = document.createElement("p");
            usersNames.forEach(function (user, index, users) {
            })
        }
    })
}