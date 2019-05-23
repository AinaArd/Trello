function addTask(event) {
    var id = event.target.id;
    var card = document.getElementById("card" + id);
    var name = document.getElementById("input" + id);
    var state = document.getElementById("state" + id);
    var date = document.getElementById("date" + id);
    var ul = document.getElementById("ul-id" + id);
    $.ajax({
        url: "/ajax/addtask",
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
            li.appendChild(a);
            text.innerHTML = "State: " + task.state;
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
    var id = event.target.id;
    var comment = document.getElementById("comment");
    var ul = document.getElementById("ul-id" + id);
    if (comment.value.length > 0) {
        $.ajax({
            url: "/ajax/addcomment",
            type: "post",
            data: {
                "id": id,
                "comment": comment.value
            },
            success: function (data) {
                var li = document.createElement("li");
                li.innerHTML = data.author + ": ";
                if (data.mentioned.length > 0) {
                    var a = document.createElement("a");
                    a.href = "/profile/" + data.id;
                    a.innerHTML = data.mentioned + " ";
                    console.log(data.mentioned);
                    li.appendChild(a);
                }
                var text = document.createTextNode(data.commentText);
                li.appendChild(text);
                ul.appendChild(li);
                comment.value = "";
            }
        })
    } else
        alert("Comment can't be empty! Write something in the form")
}

function returnTask(event) {
    var id = event.target.id;
    $.ajax({
        url: "/ajax/returntask",
        type: "post",
        data: {
            "id": id
        },
        success: function (id) {
            console.log(id)
        }
    })
}

// function checkForEmptiness() {
//     var text = document.getElementById("comment");
//     var button = document.getElementsByName("comment-btn");
//     if (text.value > 0) {
//         button.prop('disabled', false);
//     } else {
//         alert("Comment can't be empty!");
//     }
// }