function addCheckList(event) {
    var taskId = event.target.id;
    var checkList = document.getElementById("checklist");
    $.ajax({
        url: "/ajax/addCheckList",
        type: "post",
        data: {
            "taskId": taskId,
            "check-list": checkList.value
        },

        success: function (list) {
            var ul = document.getElementById("ul");
            var li = document.createElement("li");

            var item = document.createElement("div");
            item.innerHTML = list.name;

            var btnAddElem = document.createElement("button");
            btnAddElem.className = "closebtn";
            btnAddElem.innerHTML = "Add element";
            btnAddElem.onclick = function addElem() {
                var elemName = document.getElementById("elem-name");
                var ul = document.getElementById("ul-elem");

                $.ajax({
                    url: "/ajax/addElem",
                    type: "post",
                    data: {
                        "list-id": list.id,
                        "elem-name": elemName.value
                    },
                    success: function (elem) {
                        var li = document.createElement("li");
                        li.innerHTML = elem.content;

                        //add btn
                        elemName.value = "";
                        ul.appendChild(li);
                    }
                });
            };

            var btnDelete = document.createElement("button");
            btnDelete.className = "button-add";
            btnDelete.innerHTML = "Delete";

            var inputElem = document.createElement("input");
            var br = document.createElement("br");

            item.appendChild(inputElem);
            item.appendChild(btnAddElem);
            item.appendChild(btnDelete);

            li.appendChild(item);
            ul.appendChild(li);
            ul.appendChild(br);
        }
    })
}

function addElem(event) {
    var checkList = event.target.id;
    var elemName = document.getElementById("elem-name");
    var ul = document.getElementById("ul-elem");

    $.ajax({
        url: "/ajax/addElem",
        type: "post",
        data: {
            "list-id": checkList,
            "elem-name": elemName.value
        },
        success: function (elem) {
            var li = document.createElement("li");
            li.innerHTML = elem.content;

            //add btn

            ul.appendChild(li);
            elemName.value = "";
        }
    });
}

function deleteCheckList(event) {
    var id = event.target.id;
    $.ajax({
        url: "/ajax/deleteCheckList",
        type: "post",
        data: {
            "id": id,
        },
        success: function () {
            var listLi = document.getElementById(id);
            listLi.remove();
        }
    });
}