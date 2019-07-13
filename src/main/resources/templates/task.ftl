<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Bootstrap core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="//ajax.aspnetcdn.com/ajax/jquery.ui/1.10.3/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.10.3/themes/sunny/jquery-ui.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <link href="/css/taskStyles.css" rel="stylesheet" type="text/css">
</head>

<body>
<#include "header.ftl">
<!-- Page Content -->
<div class="container form-style-2 background-style">

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
                            <br>
                        </div>
                    </#list>
                </#if>
                <div id="member"></div>
            </div>

            <#if noText??>
                <form method="post">
                    <label for="text">Add text to the task
                        <input class="input-field" type="text" id="text" name="text" required="required">
                    </label>
                    <input type="submit" value="Save"/>
                </form>
            <#else>

                <!-- Term -->
                <p>Created on ${task.term}</p>
                <p>State: ${task.state}</p>

                <br>

                <#if picture??>
                    <!-- Preview Image -->
                    <img class="task-pic img-thumbnail" src="/load/${task.getPicturePath()}" alt="">
                <#else>
                    <img class="task-pic img-thumbnail" src="/images/default.png" alt="">
                </#if>

                <br>
                <br>

                <!-- Post Content -->
                <p class="lead">${task.text}</p>


                <form method="post">
                    <input type="submit" name="archive" value="Archive"/>
                </form>


                <form method="post">
                    <input type="submit" name="delete" value="Delete"/>
                </form>


                <label for="user-name">
                    <input class="button-add" type="submit" id="user-name" name="user-name" value="Add users to task"
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

            <!-- Checklists -->
            <ul id="ul">
                <div class="form-style-2-heading">
                CheckLists
                </div>
                <#if task.checkLists??>
                    <div>
                        <#list task.checkLists as list>
                            <li id="${list.id}">
                                ${list.name}&nbsp;
                                <#if list.elems??>
                                    <ul id="ul-elem">
                                        <#list list.elems as elem>
                                            <li>
                                                ${elem.content}
                                            </li>
                                        </#list>
                                    </ul>
                                </#if>
                                <input type="text" id="elem-name">&nbsp;
                                <button class="button-add" id="${list.id}"
                                        onclick="addElem(event)">
                                    Add element
                                </button>
                                <a class="delete" id="${list.id}"
                                        onclick="deleteCheckList(event)">
                                    <img src="/images/cross.png" height="5%" width="5%"/>
                                </a>
                            </li>
                        </#list>
                    </div>
                </#if>
            </ul>

            <div id="checkItem"></div>
            <br>

            <input type="submit" value="Add checklist" onclick="show(document.getElementById('addCheckList'))"/>

            <div id="addCheckList" style="display: none;">
                <br>
                <label for="users">CheckList
                    <input class="input-field" type="text" id="checklist">
                </label>
                <button type="submit" id="${task.id}" class="button-add" onclick="addCheckList(event)">Save</button>
            </div>
            <br>


            <#-- <div class="form-check">
                 <input type="checkbox" class="form-check-input" id="checkbox">
                 <label class="form-check-label" for="checkbox"></label>
             </div>-->
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
<script type="application/javascript" src="/js/checkLists.js"></script>
<script src="https://code.jquery.com/jquery-migrate-1.4.1.min.js"></script>
</body>
</html>
