function addUsersToTask(event) {
    var search = event.target.id;
    var search = document.getElementById("usersto" + id);
    var result = document.getElementById("result");
    $.ajax({
        url: "/ajax/adduser",
        type: "post",
        data: {
            "id": id,
            "search": search.value
        },
        success: function (userCandidates) {
            result.innerText = "";
            for (var user in userCandidates) {
                console.log(user.id);
                var textNode = document.createElement("div");
                var button = document.createElement("button");
                var a = document.createElement("a");
                result.appendChild(button);
                button.onclick = function () {
                    //    TODO: add user to desk
                }

                a.href = "../profile/" + userCandidates[user].id;
                a.innerHTML = userCandidates[user].name;
                textNode.appendChild(a);
                // textNode.innerHTML = userCandidates[user];
                result.appendChild(textNode);
                console.log(userCandidates[user]);
            }
        }

    })
}

function addUsersToDesk(event) {
    var search = document.getElementById("input");
    var result = document.getElementById("result");
    if(search.value.length > 0) {
        $.ajax({
            url: "/ajax/inviteusers",
            type: "post",
            data: {
                "search": search.value
            },
            success: function (userCandidates) {
                result.innerText = "";
                for (var user in userCandidates) {
                    var textNode = document.createElement("p");
                    var a = document.createElement("a");
                    a.href = "../profile/" + userCandidates[user].id;
                    a.innerHTML = userCandidates[user].name;
                    textNode.appendChild(a);
                    result.appendChild(textNode);
                }
            }

        })
    } else {
        result.innerHTML = "";
    }
}
