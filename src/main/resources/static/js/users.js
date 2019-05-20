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

function addUsersToDesk() {
    var search = document.getElementById("input");
    var result = document.getElementById("result");
    var desk = document.getElementById("desk-id");

    if (search.value.length > 0) {
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

                    var buttonAdd = document.createElement("button");
                    buttonAdd.innerText = "Add";
                    // buttonAdd.name = "Add";
                    buttonAdd.onclick = function add() {
                        buttonAdd.innerHTML = "Added";
                        var userName = userCandidates[user].name;
                        var deskId = desk.dataset.id;
                        $.ajax({
                                url: "/ajax/adduser",
                                type: "post",
                                data: {
                                    "userName": userName,
                                    "deskId": deskId
                                },
                                success: function (user) {
                                    var members = document.getElementById("member");

                                    members.innerHTML = user.name;
                                    console.log(user.name);

                                }
                            }
                        )
                    }
                    ;

                    var a = document.createElement("a");
                    a.href = "../profile/" + userCandidates[user].id;
                    a.innerHTML = userCandidates[user].name;

                    textNode.appendChild(buttonAdd);
                    textNode.appendChild(a);
                    result.appendChild(textNode);
                }
            }

        })
    } else {
        result.innerHTML = "";
    }
}

// function add() {
//     buttonAdd.innerHTML = "Added";
//     var userName = userCandidate[user].name;
//     var deskId = document.getElementById("desk-id");
//     console.log("added");
//     $.ajax({
//         url: "/ajax/adduser",
//         type: "post",
//         data: {
//             "userName": userName,
//             "deskId": deskId
//         },
//         success: function (text) {
//             console.log(text);
//         }
//     })
// }
