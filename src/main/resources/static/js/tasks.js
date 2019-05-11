function addTask(event) {
    var id = event.target.id;
    var card = document.getElementById("card" + id);
    var name = document.getElementById("input" + id);
    var state = document.getElementById("taskState");
    var ul = document.getElementById("ul-id" + id);
    $.ajax({
        url: "/ajax/addtask",
        type: "post",
        data: {
            "id": id,
            "name": name.value,
            "state": state.value
        },
        success: function (id) {
            var li = document.createElement("li");
            var liState = document.createElement("li");
            var a = document.createElement("a");
            a.href = "/tasks/" + id;
            a.innerHTML = name.value;
            li.appendChild(a);
            ul.appendChild(li);
            ul.appendChild(liState);
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
    $.ajax({
        url: "/ajax/addcomment",
        type: "post",
        data: {
            "id": id,
            "comment": comment.value
        },
        success: function (name) {
            var li = document.createElement("li");
            var text = document.createTextNode(comment.value);
            li.innerHTML = name + ": ";
            li.appendChild(text);
            ul.appendChild(li);
            comment.value = "";
        }
    })
}