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

<#--        <input type="submit" value="Edit task" onclick="show(document.getElementById('edit'))""/>-->
<#--        <br>-->
<#--        <br>-->

<#--        <form method="post" id="edit" style="display: none;" enctype="multipart/form-data">-->
<#--            <div class="edit">Edit task</div>-->
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
    <link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
<#--    <link href="/css/blog-post.css" rel="stylesheet">-->

</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="#">Start Bootstrap</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Services</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Contact</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Page Content -->
<div class="container">

    <div class="row">

        <!-- Post Content Column -->
        <div class="col-lg-8">

            <!-- Title -->
            <h1 class="mt-4">Post Title</h1>

            <!-- Author -->
            <p class="lead">
                by
                <a href="#">Start Bootstrap</a>
            </p>

            <hr>

            <!-- Date/Time -->
            <p>Posted on January 1, 2019 at 12:00 PM</p>

            <hr>

            <!-- Preview Image -->
            <img class="img-fluid rounded" src="http://placehold.it/900x300" alt="">

            <hr>

            <!-- Post Content -->
            <p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ducimus, vero, obcaecati, aut, error quam sapiente nemo saepe quibusdam sit excepturi nam quia corporis eligendi eos magni recusandae laborum minus inventore?</p>

            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ut, tenetur natus doloremque laborum quos iste ipsum rerum obcaecati impedit odit illo dolorum ab tempora nihil dicta earum fugiat. Temporibus, voluptatibus.</p>

            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eos, doloribus, dolorem iusto blanditiis unde eius illum consequuntur neque dicta incidunt ullam ea hic porro optio ratione repellat perspiciatis. Enim, iure!</p>

            <blockquote class="blockquote">
                <p class="mb-0">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
                <footer class="blockquote-footer">Someone famous in
                    <cite title="Source Title">Source Title</cite>
                </footer>
            </blockquote>

            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Error, nostrum, aliquid, animi, ut quas placeat totam sunt tempora commodi nihil ullam alias modi dicta saepe minima ab quo voluptatem obcaecati?</p>

            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Harum, dolor quis. Sunt, ut, explicabo, aliquam tenetur ratione tempore quidem voluptates cupiditate voluptas illo saepe quaerat numquam recusandae? Qui, necessitatibus, est!</p>

            <hr>

            <!-- Comments Form -->
            <div class="card my-4">
                <h5 class="card-header">Leave a Comment:</h5>
                <div class="card-body">
                    <form>
                        <div class="form-group">
                            <textarea class="form-control" rows="3"></textarea>
                        </div>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
            </div>

            <!-- Single Comment -->
            <div class="media mb-4">
                <img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt="">
                <div class="media-body">
                    <h5 class="mt-0">Commenter Name</h5>
                    Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
                </div>
            </div>

            <!-- Comment with nested comments -->
            <div class="media mb-4">
                <img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt="">
                <div class="media-body">
                    <h5 class="mt-0">Commenter Name</h5>
                    Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.

                    <div class="media mt-4">
                        <img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt="">
                        <div class="media-body">
                            <h5 class="mt-0">Commenter Name</h5>
                            Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
                        </div>
                    </div>

                    <div class="media mt-4">
                        <img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt="">
                        <div class="media-body">
                            <h5 class="mt-0">Commenter Name</h5>
                            Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
                        </div>
                    </div>

                </div>
            </div>

        </div>

    </div>
    <!-- /.row -->

</div>
<!-- /.container -->

<!-- Footer -->
<footer class="py-5 bg-dark">
    <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Your Website 2019</p>
    </div>
    <!-- /.container -->
</footer>

<!-- Bootstrap core JavaScript -->
<script type="application/javascript" src="/vendor/jquery/jquery.min.js"></script>
<script type="application/json" src="/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
