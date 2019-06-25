<#--<html>-->
<#--<head>-->
<#--    <link href="/css/styles.css" rel="stylesheet" type="text/css">-->
<#--    <link href="/css/bootstrap.min.css" rel="stylesheet"/>-->
<#--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">-->
<#--    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>-->
<#--    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>-->
<#--</head>-->
<#--<body>-->
<#--<#include "header.ftl">-->
<#--<div class="form-style-2">-->
<#--    <div id="task-id" data-id="${task.id}" class="form-style-2-heading">-->
<#--        ${task.name}-->
<#--    </div>-->
<#--    <div> Members:-->
<#--        <#if task.users??>-->
<#--            <#list task.users as member>-->
<#--                <a href="/profile/${member.id}">${member.name}</a>-->
<#--                <div id="member"></div>-->
<#--            </#list>-->
<#--        </#if>-->
<#--    </div>-->
<#--    <br>-->
<#--    State: ${task.state}-->
<#--    <br>-->
<#--    <#if noPic??>-->
<#--        <img src="/static/images/default.png" alt="Default picture">-->
<#--        <#else><img src="${task.picturePath}" height="130px" width="130px" alt="Task picture">-->
<#--    </#if>-->
<#--    <br>-->
<#--    <br>-->
<#--    <#if noText??>-->
<#--        <form method="post">-->
<#--            <label for="text">Add text to the task-->
<#--                <input class="input-field" type="text" id="text" name="text" required="required">-->
<#--            </label>-->
<#--            <input type="submit" value="Save"/>-->
<#--        </form>-->
<#--    <#else>-->
<#--        Description: ${task.text}-->
<#--        <br>-->
<#--        <br>-->
<#--        Term: ${task.term}-->
<#--        <br>-->
<#--        <br>-->
<#--        Comments:-->
<#--        <br>-->
<#--        <br>-->
<#--        <ul id="ul-id${task.id}">-->
<#--            <#list task.comments as comment>-->
<#--                <li>-->
<#--                    <div id="${comment.id}">-->
<#--                        <a href="/profile/${comment.author.id}">${comment.author.name}: </a>-->
<#--                        <b data-contain-user-tags>${comment.content}</b>-->
<#--                    </div>-->
<#--                </li>-->
<#--            </#list>-->
<#--        </ul>-->
<#--        <br>-->

<#--        <div id="commentTask" class="form-group purple-border">-->
<#--            <label for="comment">Comment-->
<#--                <textarea class="form-control" id="comment" name="comment" rows="3"></textarea>-->
<#--            </label>-->
<#--            <button class="button-add" onclick="commentTask(event)" id="${task.id}" name="comment-btn">Comment</button>-->
<#--        </div>-->
<#--        <br>-->

<#--        <input type="submit" value="Edit task" onclick="show(document.getElementById('editCardName'))""/>-->
<#--        <br>-->
<#--        <br>-->

<#--        <form method="post" id="editCardName" style="display: none;" enctype="multipart/form-data">-->
<#--            <div class="editCardName">Edit task</div>-->
<#--            <label for="name">Name-->
<#--                <input class="input-field" type="text" id="name" name="name" value="${task.name}" required="required">-->
<#--            </label>-->
<#--            <label for="text">Text-->
<#--                <input class="textarea-field" id="text" name="text" required="required" value="${task.text}">-->
<#--            </label>-->
<#--            <label for="state">State-->
<#--                <select id="state" name="state" class="mdb-select md-form" required="required">-->
<#--                    <option value="" disabled selected>Choose task state</option>-->
<#--                    <option value="TODO">TODO</option>-->
<#--                    <option value="IN_PROCESS">IN_PROCESS</option>-->
<#--                    <option value="DONE">DONE</option>-->
<#--                    <option value="FOR_CHECK">FOR_CHECK</option>-->
<#--                </select>-->
<#--            </label>-->
<#--            <input type="file" name="file" id="file">-->
<#--            <br>-->
<#--            <input type="submit" value="Save"/>-->
<#--        </form>-->
<#--    </#if>-->

<#--    <label for="user-name">-->
<#--        <input type="submit" id="user-name" name="user-name" value="Add users to task"-->
<#--               onclick="show(document.getElementById('findUser'))"/>-->
<#--    </label>-->

<#--    <div id="findUser" style="display: none;">-->
<#--        <div id="div-users">-->
<#--            <label for="users">Find user-->
<#--                <input class="input-field" type="text" id="search" name="users" oninput="addUsersToTask()">-->
<#--            </label>-->
<#--            <div id="result"></div>-->
<#--            <br>-->
<#--            <br>-->
<#--            <div id="user-candidates"></div>-->
<#--        </div>-->
<#--    </div>-->

<#--    <form method="post">-->
<#--        <input type="submit" name="archive" value="Archive"/>-->
<#--    </form>-->
<#--</div>-->

<#--<script>-->
<#--    function show(div) {-->
<#--        if (div.style.display === "none") {-->
<#--            div.style.display = "block";-->
<#--        } else-->
<#--            div.style.display = "none"-->
<#--    }-->
<#--</script>-->
<#--&lt;#&ndash;<script type="application/javascript" src="/js/users-mentions.js"></script>&ndash;&gt;-->
<#--<script type="application/javascript" src="/js/users.js"></script>-->
<#--<script type="application/javascript" src="/js/tasks.js"></script>-->
<#--</body>-->
<#--</html>-->

<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Bootstrap core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/styles.css" rel="stylesheet" type="text/css">

</head>

<body>
<#include "header.ftl">
<!-- Page Content -->
<div class="container form-style-2">

    <div class="row">

        <!-- Post Content Column -->
        <div class="col-lg-8">

            <!-- Title -->
            <h1 id="task-id" data-id="${task.id}" class="mt-4">${task.name}</h1>

            <!-- Author -->
            <div> Members:
                <br>
                <#if task.users??>
                    <#list task.users as member>
                        <div id="${member.id}">
                            <a href="/profile/${member.id}">${member.name}</a>
                            <button class="button-add" id="${member.id}" onclick="deleteUserFromTask(event)">Delete
                            </button>
                            <br>
                            <div id="member"></div>
                            <br>
                        </div>
                    </#list>
                </#if>
            </div>

            <hr>

            <#if noText??>
                <form method="post">
                    <label for="text">Add text to the task
                        <input class="input-field" type="text" id="text" name="text" required="required">
                    </label>
                    <input type="submit" value="Save"/>
                </form>
            <#else>

                <!-- Date/Time -->
                <p>Created on ${task.term}</p>

                <hr>

                <!-- Preview Image -->
                <img class="img-fluid rounded" src="${task.picturePath}" alt="">

                <hr>

                <!-- Post Content -->
                <p class="lead">${task.text}</p>

                <hr>

                <form method="post">
                    <input type="submit" name="archive" value="Archive"/>
                </form>

                <hr>

                <form method="post">
                    <input type="submit" name="delete" value="Delete"/>
                </form>

                <hr>

                <label for="user-name">
                    <input type="submit" id="user-name" name="user-name" value="Add users to task"
                           onclick="show(document.getElementById('findUser'))"/>
                </label>

                <div id="findUser" style="display: none;">
                    <div id="div-users">
                        <label for="users">Find user
                            <input class="input-field" type="text" id="search" name="users" oninput="addUsersToTask()">
                        </label>
                        <div id="result"></div>
                        <br>
                        <br>
                        <div id="user-candidates"></div>
                    </div>
                </div>

                <hr>

                <input type="submit" value="Edit task" onclick="show(document.getElementById('edit'))""/>
                <br>
                <br>

                <form method="post" id="edit" style="display: none;" enctype="multipart/form-data">
                    <div class="edit">Edit task</div>
                    <label for="name">Name
                        <input class="input-field" type="text" id="name" name="name" value="${task.name}"
                               required="required">
                    </label>
                    <label for="text">Text
                        <input class="textarea-field" id="text" name="text" required="required" value="${task.text}">
                    </label>
                    <label for="state">State
                        <select id="state" name="state" class="mdb-select md-form" required="required">
                            <option value="" disabled selected>Choose task state</option>
                            <option value="TODO">TODO</option>
                            <option value="IN_PROCESS">IN_PROCESS</option>
                            <option value="DONE">DONE</option>
                            <option value="FOR_CHECK">FOR_CHECK</option>
                        </select>
                    </label>
                    <input type="file" name="file" id="file">
                    <br>
                    <input type="submit" value="Save"/>
                </form>
            </#if>

            <!-- Single Comment -->
            <ul id="ul-id${task.id}">
                <#if task.comments??>
                    <#list task.comments as comment>
                            <li>
                                <div class="media mb-4">
                                    <div class="media-body" id="${comment.id}">

                                         <a href="/profile/${comment.author.id}">${comment.author.name}: </a>

                                        <b data-contain-user-tags>${comment.content}</b>
                                    </div>
                                </div>
                            </li>
                    </#list>
                </#if>
            </ul>

            <!-- Comments Form -->
            <div class="card my-4" id="commentTask">
                <h5 class="card-header">Leave a Comment:</h5>
                <div class="card-body">
                    <div class="form-group">
                        <textarea class="form-control" id="comment" name="comment" rows="3"></textarea>
                    </div>
                    <button type="submit" onclick="commentTask(event)" id="${task.id}" name="comment-btn"
                            class="button-add">Comment
                    </button>
                </div>
            </div>

        </div>

    </div>

</div>

<script>
    function show(div) {
        if (div.style.display === "none") {
            div.style.display = "block";
        } else
            div.style.display = "none"
    }
</script>
<!-- Bootstrap core JavaScript -->
<script type="application/javascript" src="/js/jquery.min.js"></script>
<script type="application/javascript" src="/js/bootstrap.bundle.js"></script>
<script type="application/javascript" src="/js/bootstrap.min.js"></script>
<script type="application/javascript" src="/js/users.js"></script>
<script type="application/javascript" src="/js/tasks.js"></script>

</body>

</html>
