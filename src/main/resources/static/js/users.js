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
        success: function (userCandidates) {
            for(var user in userCandidates) {
                var textNode = document.createElement("p");
                // var a = document.createElement("a");
                // a.href = "profile/" + userCandidates[user].
                // usersNames.innerHTML = userCandidates[user];
                textNode.innerHTML = userCandidates[user];
                document.body.appendChild(textNode);
                console.log(userCandidates[user]);
            }
            // TODO: clean previous variants
            // var line = document.createElement('p');
            // line.innerHTML = "variants: ";
            // userCandidates.forEach(function (user, index, userCandidates) {
            //     var text = document.createTextNode(user);
            //     line.innerHTML = user;
            //     line.appendChild(text);
            // })

        }
    })
}