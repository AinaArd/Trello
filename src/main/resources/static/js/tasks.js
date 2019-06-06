function addTask(event) {
    var id = event.target.id;
    var card = document.getElementById("card" + id);
    var name = document.getElementById("input" + id);
    var state = document.getElementById("state" + id);
    var date = document.getElementById("date" + id);
    var ul = document.getElementById("ul-id" + id);
    $.ajax({
        url: "/ajax/addTask",
        type: "post",
        data: {
            "id": id,
            "name": name.value,
            "state": state.value,
            "date": date.value
        },
        success: function (task) {
            var li = document.createElement("li");
            var a = document.createElement("a");
            var text = document.createElement("em");

            a.href = "/tasks/" + task.id;
            a.innerHTML = task.name + " ";

            text.innerHTML = "State: " + task.state;

            li.appendChild(a);
            li.appendChild(text);
            ul.appendChild(li);

            name.value = "";
            state.value = "";
        }
    });

    // TODO: hide add block after insert
    var div = document.getElementById("addTaskTo" + id);
    div.style.display = 'block';
}

function commentTask(event) {
    var taskId = event.target.id;
    var comment = document.getElementById("comment");
    var ul = document.getElementById("ul-id" + taskId);

    if (comment.value.length > 0) {
        $.ajax({
            url: "/ajax/addComment",
            type: "post",
            data: {
                "id": taskId,
                "comment": comment.value,
            },
            success: function (data) {
                var element = document.createElement("li");
                var a = document.createElement("a");
                var text = document.createElement("b");

                a.href = "/profile";
                a.innerHTML = data.author + ": ";

                var str = data.commentText;
                text.innerHTML = checkForLogin(str);

                element.appendChild(a);
                element.appendChild(text);
                ul.appendChild(element);

                comment.value = "";
            }
        })
    } else
        alert("Comment can't be empty! Write something in the form")
}

function returnTask(event) {
    var id = event.target.id;
    $.ajax({
        url: "/ajax/returnTask",
        type: "post",
        data: {
            "id": id
        },
        success: function (id) {
        }
    })
}

function checkForLogin(str) {
    var regexp = /@[A-Za-z-]+/g;
    var userCandidates = str.match(regexp);

    console.log(userCandidates);
    for (var i = 0; i < userCandidates && userCandidates != null; i++) {
        $.ajax({
            async: false,
            url: "/ajax/checkUser",
            method: "get",
            data: {
                "name": userCandidates[i].slice(1)
            },
            success: function (user) {
                console.log(user);
                if (user !== null) {
                    str = str.replace("@" + user.login,
                        "<a href='/profile/" + user.login + "'>@" + user.login + "</a>");
                    // console.log(str);
                }
            },
            error(msg) {
                alert(msg);
            }
        });
    }
    return str;
}