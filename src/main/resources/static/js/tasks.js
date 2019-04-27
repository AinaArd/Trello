function addTask(event) {
    var id = event.target.id;
    var card = document.getElementById("card" + id);
    var name = document.getElementById("input" + id);
    var ul = document.getElementById("ul-id" + id);
    $.ajax({
        url: "/ajax/addtask",
        type: "post",
        data: {
            "id": id,
            "name": name.value
        },
        success: function (id) {
            console.log("success");
            var li = document.createElement("li");
            var a = document.createElement("a");
            a.href = "/tasks/" + id;
            a.innerHTML = name.value;
            li.appendChild(a);
            ul.appendChild(li);
            name.value = "";
        }
    })
}