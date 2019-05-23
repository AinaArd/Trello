function addUsersToTask() {
    var search = document.getElementById("search");
    var result = document.getElementById("user-candidates");
    var task = document.getElementById("task-id");
    var taskId = task.dataset.id;
    if (search.value.length > 0) {
        $.ajax({
            url: "/ajax/inviteuserstotask",
            type: "post",
            data: {
                "search": search.value
            },
            success: function (userCandidates) {
                for (var user in userCandidates) {
                    var textNode = document.createElement("p");

                    var buttonAdd = document.createElement("button");
                    buttonAdd.innerText = "Add";
                    buttonAdd.onclick = function add() {
                        buttonAdd.innerHTML = "Added";
                        var userName = userCandidates[user].name;
                        $.ajax({
                                url: "/ajax/addusertotask",
                                type: "post",
                                data: {
                                    "userName": userName,
                                    "taskId": taskId
                                },
                                success: function (user) {
                                    var members = document.getElementById("member");
                                    var a = document.createElement("a");
                                    a.href = "../profile/" + user.id;
                                    a.innerHTML = user.name + " ";
                                    members.appendChild(a);
                                }
                            }
                        )
                    };

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

function addUsersToDesk() {
    var search = document.getElementById("input");
    var result = document.getElementById("result");
    var desk = document.getElementById("desk-id");

    if (search.value.length > 0) {
        $.ajax({
            url: "/ajax/inviteuserstodesk",
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
                    buttonAdd.onclick = function add() {
                        buttonAdd.innerHTML = "Added";
                        var userName = userCandidates[user].name;
                        var deskId = desk.dataset.id;
                        $.ajax({
                                url: "/ajax/addusertodesk",
                                type: "post",
                                data: {
                                    "userName": userName,
                                    "deskId": deskId
                                },
                                success: function (user) {
                                    var members = document.getElementById("member");
                                    var a = document.createElement("a");
                                    a.href = "../profile/" + user.id;
                                    a.innerHTML = user.name + " ";
                                    members.appendChild(a);
                                }
                            }
                        )
                    };

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

// TODO: fix illegal invocation error
function deleteUser(event) {
    var id = event.target.id;
    var deskId = document.getElementById("desk-id");
    // $.ajax({
    //     url: "/ajax/deleteuser",
    //     type: "post",
    //     data: {
    //         "id": id,
    //         "desk-id": deskId
    //     },
    //     success: function () {
    //         console.log("success")
    //     }
    // })

    postRequest('/ajax/deleteuser', {'id': id, 'desk-id': deskId})
        .catch(error => console.error(error));

    function postRequest(url, data) {
        return fetch(url, {
            credentials: 'same-origin', // 'include', default: 'omit'
            method: 'POST', // 'GET', 'PUT', 'DELETE', etc.
            body: JSON.stringify(data), // Coordinate the body type with 'Content-Type'
            headers: new Headers({
                'Content-Type': 'application/json'
            }),
        })
            .then(response => response.json())
    }
}
