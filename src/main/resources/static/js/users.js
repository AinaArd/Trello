function addUsers(event) {
    var id = event.target.id;
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
            for(var user in userCandidates) {
                var textNode = document.createElement("p");
                var a = document.createElement("a");
                a.href = "profile/" + userCandidates[user];
                a.innerHTML = userCandidates[user];
                textNode.appendChild(a);
                // textNode.innerHTML = userCandidates[user];
                result.appendChild(textNode);
                console.log(userCandidates[user]);
            }
            // TODO: clean previous variants
        }

    })
}