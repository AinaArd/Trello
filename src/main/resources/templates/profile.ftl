<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <meta name="author" content=""/>

    <!-- Facebook and Twitter integration -->
    <meta property="og:title" content=""/>
    <meta property="og:image" content=""/>
    <meta property="og:url" content=""/>
    <meta property="og:site_name" content=""/>
    <meta property="og:description" content=""/>
    <meta name="twitter:title" content=""/>
    <meta name="twitter:image" content=""/>
    <meta name="twitter:url" content=""/>
    <meta name="twitter:card" content=""/>

    <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
    <link rel="shortcut icon" href="favicon.ico">

    <link href="https://fonts.googleapis.com/css?family=Quicksand:300,400,500,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,400i,700" rel="stylesheet">

    <!-- Animate.css -->
    <link rel="stylesheet" href="css/animate.css">
    <!-- Icomoon Icon Fonts-->
    <link rel="stylesheet" href="css/icomoon.css">
    <!-- Bootstrap  -->
    <link rel="stylesheet" href="css/bootstrap.css">
    <!-- Flexslider  -->
    <link rel="stylesheet" href="css/flexslider.css">
    <!-- Flaticons  -->
    <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">
    <!-- Owl Carousel -->
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <!-- Theme style  -->
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/styles.css">

    <!-- Modernizr JS -->
    <script src="js/modernizr-2.6.2.min.js"></script>
    <!-- FOR IE9 below -->
    <!--[if lt IE 9]>
    <script src="js/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<div id="colorlib-page">
    <div class="container-wrap">
        <a href="#" class="js-colorlib-nav-toggle colorlib-nav-toggle" data-toggle="collapse" data-target="#navbar"
           aria-expanded="false" aria-controls="navbar"><i></i></a>
        <aside id="colorlib-aside" role="complementary" class="border js-fullheight">
            <div class="text-center">
                <h1 id="colorlib-logo"><a href="/profile">${user.name}</a></h1>
            </div>
            <nav id="colorlib-main-menu" role="navigation" class="navbar">
                <div id="navbar" class="collapse">
                    <ul>
                        <li class="active"><a href="#" data-nav-section="home">Home</a></li>
                        <li><a href="/desks" data-nav-section="services">Statistics</a></li>
                        <li><a data-nav-section="map">Location</a></li>
                        <li><a data-nav-section="actions">Actions</a></li>
                    </ul>
                </div>
            </nav>
        </aside>

        <div id="colorlib-main">
            <section id="colorlib-hero" class="js-fullheight" data-section="home">
                <div class="flexslider js-fullheight">
                    <ul class="slides">
                        <li style="background-image: url(images/blog-3.jpg);">
                            <div class="overlay"></div>
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-md-6 col-md-offset-3 col-md-pull-3 col-sm-12 col-xs-12 js-fullheight slider-text">
                                        <div class="slider-text-inner js-fullheight">
                                            <div class="desc">
                                                <h1>Hi, <br>${user.name}</h1>
                                                <h2>${user.login}</h2>
                                                <input type="text" hidden id="x" name="x">
                                                <input type="text" hidden id="y" name="y">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </section>

            <section class="colorlib-services" data-section="services">
                <div class="colorlib-narrow-content">
                    <div class="row">
                        <div class="col-md-6 col-md-offset-3 col-md-pull-3 animate-box"
                             data-animate-effect="fadeInLeft">
                            <h2 class="colorlib-heading">Here are statistics of desks, tasks, comments and partners</h2>
                        </div>
                    </div>
                </div>
            </section>

            <div id="colorlib-counter" class="colorlib-counters" style="background-image: url(images/cover_bg_1.jpg);"
                 data-stellar-background-ratio="0.5">
                <div class="overlay"></div>
                <div class="colorlib-narrow-content">
                    <div class="row">
                    </div>
                    <div class="row">
                        <div class="col-md-3 text-center animate-box">
                                        <span class="colorlib-counter js-counter" data-from="0"
                                              data-to=${desksNumber} data-speed="2500"
                                              data-refresh-interval="5"></span>
                            <span class="colorlib-counter-label">Desks</span>
                        </div>
                        <div class="col-md-3 text-center animate-box">
                                        <span class="colorlib-counter js-counter" data-from="0"
                                              data-to=${tasksNumber} data-speed="2500"
                                              data-refresh-interval="5"></span>
                            <span class="colorlib-counter-label">Tasks</span>
                        </div>
                        <div class="col-md-3 text-center animate-box">
                                        <span class="colorlib-counter js-counter" data-from="0"
                                              data-to=${commentsNumber} data-speed="2500"
                                              data-refresh-interval="5"></span>
                            <span class="colorlib-counter-label">Comments</span>
                        </div>
                    </div>
                </div>
            </div>

            <section id="colorlib-hero" class="js-fullheight" data-section="map">
                <#if user.coordinateX?has_content && user.coordinateY?has_content>
                    <button onclick="showOnMap(event)" data-id="${user.id}" data-x="${user.coordinateX}"
                            data-y="${user.coordinateY}"
                            class="button-add">Show on map
                    </button>
                    <div style="display: none" id="map${user.id}" class="map"></div>
                </#if>
                <div id="map" class="map"></div>
            </section>

            <section class="colorlib-contact" data-section="actions">
                <div class="colorlib-narrow-content">
                    <div class="row">
                        <div class="col-md-6 col-md-offset-3 col-md-pull-3 animate-box"
                             data-animate-effect="fadeInLeft">
                            <span class="heading-meta">What do you want to do?</span>
                            <h2 class="colorlib-heading">Actions</h2>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-5">
                            <div class="colorlib-feature colorlib-feature-sm animate-box"
                                 data-animate-effect="fadeInLeft">
                                <div class="colorlib-icon">
                                    <i class="icon-user"></i>
                                </div>
                                <div class="colorlib-text">
                                    <p>Edit private info</p>
                                </div>
                            </div>

                            <div class="colorlib-feature colorlib-feature-sm animate-box"
                                 data-animate-effect="fadeInLeft">
                                <div class="colorlib-icon">
                                    <i class="icon-map"></i>
                                </div>
                                <div class="colorlib-text">
                                    <p>Show user desks</p>
                                </div>
                            </div>

                            <div class="colorlib-feature colorlib-feature-sm animate-box"
                                 data-animate-effect="fadeInLeft">
                                <div class="colorlib-icon">
                                    <i class="icon-cancel"></i>
                                </div>
                                <div class="colorlib-text">
                                    <p>Log out from the system</p>
                                </div>
                            </div>

                            <div class="colorlib-feature colorlib-feature-sm animate-box"
                                 data-animate-effect="fadeInLeft">
                                <div class="colorlib-icon">
                                    <i class="icon-link"></i>
                                </div>
                                <div class="colorlib-text">
                                    <p>Check telegram bot</p>
                                </div>
                            </div>

                        </div>
                        <div class="col-md-7 col-md-push-1">
                            <div class="row">
                                <div class="col-md-10 col-md-offset-1 col-md-pull-1 animate-box"
                                     data-animate-effect="fadeInRight">

                                    <br>
                                    <br>

                                    <form action="/edit">
                                        <p><input type="submit" value="Edit"
                                                  class="btn btn-primary btn-learn"/></p>
                                    </form>

                                    <br>
                                    <br>

                                    <form action="/desks">
                                        <p><input type="submit" value="My desks"
                                                  class="btn btn-primary btn-learn"/></p>
                                    </form>

                                    <br>
                                    <br>

                                    <form action="/logout">
                                        <p><input type="submit" value="Log out"
                                                  class="btn btn-primary btn-learn"/></p>
                                    </form>

                                    <br>
                                    <br>

                                    <form action="http://t.me/aina_trello_bot">
                                        <p><input type="submit" value="Telegram Bot"
                                                  class="btn btn-primary btn-learn"/></p>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

        </div><!-- end:colorlib-main -->
    </div><!-- end:container-wrap -->
</div><!-- end:colorlib-page -->
<script src="https://api-maps.yandex.ru/2.1/?lang=ru_RU&amp;apikey=ba0d1ebb-c4a5-4a00-af89-2882eb642996"
        type="text/javascript"></script>
<script src="js/maps.js"></script>
<script src="js/jquery.min.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.waypoints.min.js"></script>
<script src="js/jquery.flexslider-min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/jquery.countTo.js"></script>
<script src="js/main.js"></script>
</body>
</html>

