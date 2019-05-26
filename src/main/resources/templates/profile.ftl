<#--<html>-->
<#--<head>-->
<#--    <link href="/css/styles.css" rel="stylesheet" type="text/css">-->
<#--    <link href="/css/bootstrap.min.css" rel="stylesheet"/>-->
<#--</head>-->
<#--<body>-->
<#--<#include "header.ftl">-->
<#--<div class="form-style-2">-->
<#--    <div class="form-style-2-heading">-->
<#--        Profile-->
<#--    </div>-->

<#--    <#if flag??>-->
<#--    <div class="alert alert-danger" role="alert">No such user!</div>-->
<#--    <#else>-->
<#--        ${user.name}-->

<#--        <br>-->

<#--            ${user.login}-->

<#--        <br>-->
<#--        <br>-->
<#--        <br>-->
<#--        <form action="/edit" method="get">-->
<#--            <input type="submit" value="Edit"/>-->
<#--        </form>-->

<#--        <form action="/logout">-->
<#--            <input type="submit" value="Log out"/>-->
<#--        </form>-->
<#--        <form action="/desks">-->
<#--            <input type="submit" value="Desks"/>-->
<#--        </form>-->
<#--    </#if>-->
<#--</div>-->
<#--</body>-->
<#--</html>-->

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Profile</title>
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
                <div class="author-img" style="background-image: url(images/about.jpg);"></div>
                <h1 id="colorlib-logo"><a href="/profile">${user.name}</a></h1>
            </div>
            <nav id="colorlib-main-menu" role="navigation" class="navbar">
                <div id="navbar" class="collapse">
                    <ul>
                        <li class="active"><a href="#" data-nav-section="home">Home</a></li>
                        <li><a href="#" data-nav-section="about">About</a></li>
                        <li><a href="/desks" data-nav-section="services">Statistics</a></li>
                        <li><a>Log out</a></li>
                    </ul>
                </div>
            </nav>

            <#--            <div class="colorlib-footer">-->
            <#--                <p><small>&copy; <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. &ndash;&gt;-->
            <#--                        Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>-->
            <#--                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. &ndash;&gt; </span> <span>Demo Images: <a href="https://unsplash.com/" target="_blank">Unsplash.com</a></span></small></p>-->
            <#--                <ul>-->
            <#--                    <li><a href="#"><i class="icon-facebook2"></i></a></li>-->
            <#--                    <li><a href="#"><i class="icon-twitter2"></i></a></li>-->
            <#--                    <li><a href="#"><i class="icon-instagram"></i></a></li>-->
            <#--                    <li><a href="#"><i class="icon-linkedin2"></i></a></li>-->
            <#--                </ul>-->
            <#--            </div>-->

        </aside>

        <div id="colorlib-main">
            <section id="colorlib-hero" class="js-fullheight" data-section="home">
                <div class="flexslider js-fullheight">
                    <ul class="slides">
                        <li style="background-image: url(images/img_bg_2.jpg);">
                            <div class="overlay"></div>
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-md-6 col-md-offset-3 col-md-pull-3 col-sm-12 col-xs-12 js-fullheight slider-text">
                                        <div class="slider-text-inner js-fullheight">
                                            <div class="desc">
                                                <h1>Hi, <br>${user.name}</h1>
                                                <h2>${user.login}</h2>
<#--                                                <form action="/desks">-->
<#--                                                    <p><input type="submit" value="My desks"-->
<#--                                                              class="btn btn-primary btn-learn"/></p>-->
<#--                                                </form>-->
                                                <form action="/logout">
                                                    <p><input type="submit" value="Log out"
                                                              class="btn btn-primary btn-learn"/></p>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <#--                        <li style="background-image: url(images/img_bg_2.jpg);">-->
                        <#--                            <div class="overlay"></div>-->
                        <#--                            <div class="container-fluid">-->
                        <#--                                <div class="row">-->
                        <#--                                    <div class="col-md-6 col-md-offset-3 col-md-pull-3 col-sm-12 col-xs-12 js-fullheight slider-text">-->
                        <#--                                        <div class="slider-text-inner">-->
                        <#--                                            <div class="desc">-->
                        <#--                                                <h1>I am <br>a Designer</h1>-->
                        <#--                                                <h2>100% html5 bootstrap templates Made by <a-->
                        <#--                                                            href="https://colorlib.com/"-->
                        <#--                                                            target="_blank">colorlib.com</a></h2>-->
                        <#--                                                <p><a class="btn btn-primary btn-learn">View Portfolio <i-->
                        <#--                                                                class="icon-briefcase3"></i></a></p>-->
                        <#--                                            </div>-->
                        <#--                                        </div>-->
                        <#--                                    </div>-->
                        <#--                                </div>-->
                        <#--                            </div>-->
                        <#--                        </li>-->
                    </ul>
                </div>
            </section>

                        <section class="colorlib-about" data-section="about">
                            <div class="colorlib-narrow-content">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="row row-bottom-padded-sm animate-box" data-animate-effect="fadeInLeft">
                                            <div class="col-md-12">
                                                <div class="about-desc">
                                                    <span class="heading-meta">About Us</span>
                                                    <h2 class="colorlib-heading">Who Am I?</h2>
                                                    <p><strong>Hi I'm Jackson Ford</strong> On her way she met a copy. The copy
                                                        warned the Little Blind Text, that where it came from it would have been
                                                        rewritten a thousand times and everything that was left from its origin
                                                        would be the word "and" and the Little Blind Text should turn around and
                                                        return to its own, safe country.</p>
                                                    <p>Even the all-powerful Pointing has no control about the blind texts it is an
                                                        almost unorthographic life One day however a small line of blind text by the
                                                        name of Lorem Ipsum decided to leave for the far World of Grammar.</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-3 animate-box" data-animate-effect="fadeInLeft">
                                                <div class="services color-1">
                                                    <span class="icon2"><i class="icon-bulb"></i></span>
                                                    <h3>Graphic Design</h3>
                                                </div>
                                            </div>
                                            <div class="col-md-3 animate-box" data-animate-effect="fadeInRight">
                                                <div class="services color-2">
                                                    <span class="icon2"><i class="icon-globe-outline"></i></span>
                                                    <h3>Web Design</h3>
                                                </div>
                                            </div>
                                            <div class="col-md-3 animate-box" data-animate-effect="fadeInTop">
                                                <div class="services color-3">
                                                    <span class="icon2"><i class="icon-data"></i></span>
                                                    <h3>Software</h3>
                                                </div>
                                            </div>
                                            <div class="col-md-3 animate-box" data-animate-effect="fadeInBottom">
                                                <div class="services color-4">
                                                    <span class="icon2"><i class="icon-phone3"></i></span>
                                                    <h3>Application</h3>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12 animate-box" data-animate-effect="fadeInLeft">
                                                <div class="hire">
                                                    <h2>I am happy to know you <br>that 300+ projects done sucessfully!</h2>
                                                    <a href="#" class="btn-hire">Hire me</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </section>


                        <section class="colorlib-services" data-section="services">
                            <div class="colorlib-narrow-content">
                                <div class="row">
                                    <div class="col-md-6 col-md-offset-3 col-md-pull-3 animate-box"
                                         data-animate-effect="fadeInLeft">
                                        <h2 class="colorlib-heading">Here are statistics of my desks, tasks, comments and partners</h2>
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
                                        <span class="colorlib-counter js-counter" data-from="0" data-to=${desksNumber} data-speed="2500"
                                              data-refresh-interval="5"></span>
                                        <span class="colorlib-counter-label">Desks</span>
                                    </div>
                                    <div class="col-md-3 text-center animate-box">
                                        <span class="colorlib-counter js-counter" data-from="0" data-to=${tasksNumber} data-speed="2500"
                                              data-refresh-interval="5"></span>
                                        <span class="colorlib-counter-label">Tasks</span>
                                    </div>
                                    <div class="col-md-3 text-center animate-box">
                                        <span class="colorlib-counter js-counter" data-from="0" data-to=${commentsNumber} data-speed="2500"
                                              data-refresh-interval="5"></span>
                                        <span class="colorlib-counter-label">Comments</span>
                                    </div>
                                    <div class="col-md-3 text-center animate-box">
                                        <span class="colorlib-counter js-counter" data-from="0" data-to="10" data-speed="2500"
                                              data-refresh-interval="5"></span>
                                        <span class="colorlib-counter-label">Partners</span>
                                    </div>
                                </div>
                            </div>
                        </div>

            <#--            <section class="colorlib-skills" data-section="skills">-->
            <#--                <div class="colorlib-narrow-content">-->
            <#--                    <div class="row">-->
            <#--                        <div class="col-md-6 col-md-offset-3 col-md-pull-3 animate-box"-->
            <#--                             data-animate-effect="fadeInLeft">-->
            <#--                            <span class="heading-meta">My Specialty</span>-->
            <#--                            <h2 class="colorlib-heading animate-box">My Skills</h2>-->
            <#--                        </div>-->
            <#--                    </div>-->
            <#--                    <div class="row">-->
            <#--                        <div class="col-md-12 animate-box" data-animate-effect="fadeInLeft">-->
            <#--                            <p>The Big Oxmox advised her not to do so, because there were thousands of bad Commas, wild-->
            <#--                                Question Marks and devious Semikoli, but the Little Blind Text didn’t listen. She packed-->
            <#--                                her seven versalia, put her initial into the belt and made herself on the way.</p>-->
            <#--                        </div>-->
            <#--                        <div class="col-md-6 animate-box" data-animate-effect="fadeInLeft">-->
            <#--                            <div class="progress-wrap">-->
            <#--                                <h3>Photoshop</h3>-->
            <#--                                <div class="progress">-->
            <#--                                    <div class="progress-bar color-1" role="progressbar" aria-valuenow="75"-->
            <#--                                         aria-valuemin="0" aria-valuemax="100" style="width:75%">-->
            <#--                                        <span>75%</span>-->
            <#--                                    </div>-->
            <#--                                </div>-->
            <#--                            </div>-->
            <#--                        </div>-->
            <#--                        <div class="col-md-6 animate-box" data-animate-effect="fadeInRight">-->
            <#--                            <div class="progress-wrap">-->
            <#--                                <h3>jQuery</h3>-->
            <#--                                <div class="progress">-->
            <#--                                    <div class="progress-bar color-2" role="progressbar" aria-valuenow="60"-->
            <#--                                         aria-valuemin="0" aria-valuemax="100" style="width:60%">-->
            <#--                                        <span>60%</span>-->
            <#--                                    </div>-->
            <#--                                </div>-->
            <#--                            </div>-->
            <#--                        </div>-->
            <#--                        <div class="col-md-6 animate-box" data-animate-effect="fadeInLeft">-->
            <#--                            <div class="progress-wrap">-->
            <#--                                <h3>HTML5</h3>-->
            <#--                                <div class="progress">-->
            <#--                                    <div class="progress-bar color-3" role="progressbar" aria-valuenow="85"-->
            <#--                                         aria-valuemin="0" aria-valuemax="100" style="width:85%">-->
            <#--                                        <span>85%</span>-->
            <#--                                    </div>-->
            <#--                                </div>-->
            <#--                            </div>-->
            <#--                        </div>-->
            <#--                        <div class="col-md-6 animate-box" data-animate-effect="fadeInRight">-->
            <#--                            <div class="progress-wrap">-->
            <#--                                <h3>CSS3</h3>-->
            <#--                                <div class="progress">-->
            <#--                                    <div class="progress-bar color-4" role="progressbar" aria-valuenow="90"-->
            <#--                                         aria-valuemin="0" aria-valuemax="100" style="width:90%">-->
            <#--                                        <span>90%</span>-->
            <#--                                    </div>-->
            <#--                                </div>-->
            <#--                            </div>-->
            <#--                        </div>-->
            <#--                        <div class="col-md-6 animate-box" data-animate-effect="fadeInLeft">-->
            <#--                            <div class="progress-wrap">-->
            <#--                                <h3>WordPress</h3>-->
            <#--                                <div class="progress">-->
            <#--                                    <div class="progress-bar color-5" role="progressbar" aria-valuenow="70"-->
            <#--                                         aria-valuemin="0" aria-valuemax="100" style="width:70%">-->
            <#--                                        <span>70%</span>-->
            <#--                                    </div>-->
            <#--                                </div>-->
            <#--                            </div>-->
            <#--                        </div>-->
            <#--                        <div class="col-md-6 animate-box" data-animate-effect="fadeInRight">-->
            <#--                            <div class="progress-wrap">-->
            <#--                                <h3>SEO</h3>-->
            <#--                                <div class="progress">-->
            <#--                                    <div class="progress-bar color-6" role="progressbar" aria-valuenow="80"-->
            <#--                                         aria-valuemin="0" aria-valuemax="100" style="width:80%">-->
            <#--                                        <span>80%</span>-->
            <#--                                    </div>-->
            <#--                                </div>-->
            <#--                            </div>-->
            <#--                        </div>-->
            <#--                    </div>-->
            <#--                </div>-->
            <#--            </section>-->



            <#--            <section class="colorlib-experience" data-section="experience">-->
            <#--                <div class="colorlib-narrow-content">-->
            <#--                    <div class="row">-->
            <#--                        <div class="col-md-6 col-md-offset-3 col-md-pull-3 animate-box"-->
            <#--                             data-animate-effect="fadeInLeft">-->
            <#--                            <span class="heading-meta">Experience</span>-->
            <#--                            <h2 class="colorlib-heading animate-box">Work Experience</h2>-->
            <#--                        </div>-->
            <#--                    </div>-->
            <#--                    <div class="row">-->
            <#--                        <div class="col-md-12">-->
            <#--                            <div class="timeline-centered">-->
            <#--                                <article class="timeline-entry animate-box" data-animate-effect="fadeInLeft">-->
            <#--                                    <div class="timeline-entry-inner">-->

            <#--                                        <div class="timeline-icon color-1">-->
            <#--                                            <i class="icon-pen2"></i>-->
            <#--                                        </div>-->

            <#--                                        <div class="timeline-label">-->
            <#--                                            <h2><a href="#">Full Stack Developer</a> <span>2017-2018</span></h2>-->
            <#--                                            <p>Tolerably earnestly middleton extremely distrusts she boy now not. Add-->
            <#--                                                and offered prepare how cordial two promise. Greatly who affixed suppose-->
            <#--                                                but enquire compact prepare all put. Added forth chief trees but rooms-->
            <#--                                                think may.</p>-->
            <#--                                        </div>-->
            <#--                                    </div>-->
            <#--                                </article>-->


            <#--                                <article class="timeline-entry animate-box" data-animate-effect="fadeInRight">-->
            <#--                                    <div class="timeline-entry-inner">-->
            <#--                                        <div class="timeline-icon color-2">-->
            <#--                                            <i class="icon-pen2"></i>-->
            <#--                                        </div>-->
            <#--                                        <div class="timeline-label">-->
            <#--                                            <h2><a href="#">Front End Developer at Google Company</a>-->
            <#--                                                <span>2017-2018</span></h2>-->
            <#--                                            <p>Even the all-powerful Pointing has no control about the blind texts it is-->
            <#--                                                an almost unorthographic life One day however a small line of blind text-->
            <#--                                                by the name of Lorem Ipsum decided to leave for the far World of-->
            <#--                                                Grammar.</p>-->
            <#--                                        </div>-->
            <#--                                    </div>-->
            <#--                                </article>-->

            <#--                                <article class="timeline-entry animate-box" data-animate-effect="fadeInLeft">-->
            <#--                                    <div class="timeline-entry-inner">-->
            <#--                                        <div class="timeline-icon color-3">-->
            <#--                                            <i class="icon-pen2"></i>-->
            <#--                                        </div>-->
            <#--                                        <div class="timeline-label">-->
            <#--                                            <h2><a href="#">System Analyst</a> <span>2017-2018</span></h2>-->
            <#--                                            <p>Even the all-powerful Pointing has no control about the blind texts it is-->
            <#--                                                an almost unorthographic life One day however a small line of blind text-->
            <#--                                                by the name of Lorem Ipsum decided to leave for the far World of-->
            <#--                                                Grammar.</p>-->
            <#--                                        </div>-->
            <#--                                    </div>-->
            <#--                                </article>-->

            <#--                                <article class="timeline-entry animate-box" data-animate-effect="fadeInTop">-->
            <#--                                    <div class="timeline-entry-inner">-->
            <#--                                        <div class="timeline-icon color-4">-->
            <#--                                            <i class="icon-pen2"></i>-->
            <#--                                        </div>-->
            <#--                                        <div class="timeline-label">-->
            <#--                                            <h2><a href="#">Creative Designer</a> <span>2017-2018</span></h2>-->
            <#--                                            <p>Even the all-powerful Pointing has no control about the blind texts it is-->
            <#--                                                an almost unorthographic life One day however a small line of blind text-->
            <#--                                                by the name of Lorem Ipsum decided to leave for the far World of-->
            <#--                                                Grammar.</p>-->
            <#--                                        </div>-->
            <#--                                    </div>-->
            <#--                                </article>-->

            <#--                                <article class="timeline-entry animate-box" data-animate-effect="fadeInLeft">-->
            <#--                                    <div class="timeline-entry-inner">-->
            <#--                                        <div class="timeline-icon color-5">-->
            <#--                                            <i class="icon-pen2"></i>-->
            <#--                                        </div>-->
            <#--                                        <div class="timeline-label">-->
            <#--                                            <h2><a href="#">UI/UX Designer at Envato</a> <span>2017-2018</span></h2>-->
            <#--                                            <p>Even the all-powerful Pointing has no control about the blind texts it is-->
            <#--                                                an almost unorthographic life One day however a small line of blind text-->
            <#--                                                by the name of Lorem Ipsum decided to leave for the far World of-->
            <#--                                                Grammar.</p>-->
            <#--                                        </div>-->
            <#--                                    </div>-->
            <#--                                </article>-->

            <#--                                <article class="timeline-entry begin animate-box" data-animate-effect="fadeInBottom">-->
            <#--                                    <div class="timeline-entry-inner">-->
            <#--                                        <div class="timeline-icon color-none">-->
            <#--                                        </div>-->
            <#--                                    </div>-->
            <#--                                </article>-->
            <#--                            </div>-->
            <#--                        </div>-->
            <#--                    </div>-->
            <#--                </div>-->
            <#--            </section>-->

            <#--            <section class="colorlib-work" data-section="work">-->
            <#--                <div class="colorlib-narrow-content">-->
            <#--                    <div class="row">-->
            <#--                        <div class="col-md-6 col-md-offset-3 col-md-pull-3 animate-box"-->
            <#--                             data-animate-effect="fadeInLeft">-->
            <#--                            <span class="heading-meta">My Work</span>-->
            <#--                            <h2 class="colorlib-heading animate-box">Recent Work</h2>-->
            <#--                        </div>-->
            <#--                    </div>-->
            <#--                    <div class="row row-bottom-padded-sm animate-box" data-animate-effect="fadeInLeft">-->
            <#--                        <div class="col-md-12">-->
            <#--                            <p class="work-menu"><span><a href="#" class="active">Graphic Design</a></span> <span><a-->
            <#--                                            href="#">Web Design</a></span> <span><a href="#">Software</a></span>-->
            <#--                                <span><a href="#">Apps</a></span></p>-->
            <#--                        </div>-->
            <#--                    </div>-->
            <#--                    <div class="row">-->
            <#--                        <div class="col-md-6 animate-box" data-animate-effect="fadeInLeft">-->
            <#--                            <div class="project" style="background-image: url(images/img-1.jpg);">-->
            <#--                                <div class="desc">-->
            <#--                                    <div class="con">-->
            <#--                                        <h3><a href="work.html">Work 01</a></h3>-->
            <#--                                        <span>Website</span>-->
            <#--                                        <p class="icon">-->
            <#--                                            <span><a href="#"><i class="icon-share3"></i></a></span>-->
            <#--                                            <span><a href="#"><i class="icon-eye"></i> 100</a></span>-->
            <#--                                            <span><a href="#"><i class="icon-heart"></i> 49</a></span>-->
            <#--                                        </p>-->
            <#--                                    </div>-->
            <#--                                </div>-->
            <#--                            </div>-->
            <#--                        </div>-->
            <#--                        <div class="col-md-6 animate-box" data-animate-effect="fadeInRight">-->
            <#--                            <div class="project" style="background-image: url(images/img-2.jpg);">-->
            <#--                                <div class="desc">-->
            <#--                                    <div class="con">-->
            <#--                                        <h3><a href="work.html">Work 02</a></h3>-->
            <#--                                        <span>Animation</span>-->
            <#--                                        <p class="icon">-->
            <#--                                            <span><a href="#"><i class="icon-share3"></i></a></span>-->
            <#--                                            <span><a href="#"><i class="icon-eye"></i> 100</a></span>-->
            <#--                                            <span><a href="#"><i class="icon-heart"></i> 49</a></span>-->
            <#--                                        </p>-->
            <#--                                    </div>-->
            <#--                                </div>-->
            <#--                            </div>-->
            <#--                        </div>-->
            <#--                        <div class="col-md-6 animate-box" data-animate-effect="fadeInTop">-->
            <#--                            <div class="project" style="background-image: url(images/img-3.jpg);">-->
            <#--                                <div class="desc">-->
            <#--                                    <div class="con">-->
            <#--                                        <h3><a href="work.html">Work 03</a></h3>-->
            <#--                                        <span>Illustration</span>-->
            <#--                                        <p class="icon">-->
            <#--                                            <span><a href="#"><i class="icon-share3"></i></a></span>-->
            <#--                                            <span><a href="#"><i class="icon-eye"></i> 100</a></span>-->
            <#--                                            <span><a href="#"><i class="icon-heart"></i> 49</a></span>-->
            <#--                                        </p>-->
            <#--                                    </div>-->
            <#--                                </div>-->
            <#--                            </div>-->
            <#--                        </div>-->
            <#--                        <div class="col-md-6 animate-box" data-animate-effect="fadeInBottom">-->
            <#--                            <div class="project" style="background-image: url(images/img-4.jpg);">-->
            <#--                                <div class="desc">-->
            <#--                                    <div class="con">-->
            <#--                                        <h3><a href="work.html">Work 04</a></h3>-->
            <#--                                        <span>Application</span>-->
            <#--                                        <p class="icon">-->
            <#--                                            <span><a href="#"><i class="icon-share3"></i></a></span>-->
            <#--                                            <span><a href="#"><i class="icon-eye"></i> 100</a></span>-->
            <#--                                            <span><a href="#"><i class="icon-heart"></i> 49</a></span>-->
            <#--                                        </p>-->
            <#--                                    </div>-->
            <#--                                </div>-->
            <#--                            </div>-->
            <#--                        </div>-->
            <#--                        <div class="col-md-6 animate-box" data-animate-effect="fadeInLeft">-->
            <#--                            <div class="project" style="background-image: url(images/img-5.jpg);">-->
            <#--                                <div class="desc">-->
            <#--                                    <div class="con">-->
            <#--                                        <h3><a href="work.html">Work 05</a></h3>-->
            <#--                                        <span>Graphic, Logo</span>-->
            <#--                                        <p class="icon">-->
            <#--                                            <span><a href="#"><i class="icon-share3"></i></a></span>-->
            <#--                                            <span><a href="#"><i class="icon-eye"></i> 100</a></span>-->
            <#--                                            <span><a href="#"><i class="icon-heart"></i> 49</a></span>-->
            <#--                                        </p>-->
            <#--                                    </div>-->
            <#--                                </div>-->
            <#--                            </div>-->
            <#--                        </div>-->
            <#--                        <div class="col-md-6 animate-box" data-animate-effect="fadeInRight">-->
            <#--                            <div class="project" style="background-image: url(images/img-6.jpg);">-->
            <#--                                <div class="desc">-->
            <#--                                    <div class="con">-->
            <#--                                        <h3><a href="work.html">Work 06</a></h3>-->
            <#--                                        <span>Web Design</span>-->
            <#--                                        <p class="icon">-->
            <#--                                            <span><a href="#"><i class="icon-share3"></i></a></span>-->
            <#--                                            <span><a href="#"><i class="icon-eye"></i> 100</a></span>-->
            <#--                                            <span><a href="#"><i class="icon-heart"></i> 49</a></span>-->
            <#--                                        </p>-->
            <#--                                    </div>-->
            <#--                                </div>-->
            <#--                            </div>-->
            <#--                        </div>-->
            <#--                    </div>-->
            <#--                    <div class="row">-->
            <#--                        <div class="col-md-12 animate-box">-->
            <#--                            <p><a href="#" class="btn btn-primary btn-lg btn-load-more">Load more <i-->
            <#--                                            class="icon-reload"></i></a></p>-->
            <#--                        </div>-->
            <#--                    </div>-->
            <#--                </div>-->
            <#--            </section>-->

            <#--            <section class="colorlib-blog" data-section="blog">-->
            <#--                <div class="colorlib-narrow-content">-->
            <#--                    <div class="row">-->
            <#--                        <div class="col-md-6 col-md-offset-3 col-md-pull-3 animate-box"-->
            <#--                             data-animate-effect="fadeInLeft">-->
            <#--                            <span class="heading-meta">Read</span>-->
            <#--                            <h2 class="colorlib-heading">Recent Blog</h2>-->
            <#--                        </div>-->
            <#--                    </div>-->
            <#--                    <div class="row">-->
            <#--                        <div class="col-md-4 col-sm-6 animate-box" data-animate-effect="fadeInLeft">-->
            <#--                            <div class="blog-entry">-->
            <#--                                <a href="blog.html" class="blog-img"><img src="images/blog-1.jpg" class="img-responsive"-->
            <#--                                                                          alt="HTML5 Bootstrap Template by colorlib.com"></a>-->
            <#--                                <div class="desc">-->
            <#--                                    <span><small>April 14, 2018 </small> | <small> Web Design </small> | <small> <i-->
            <#--                                                    class="icon-bubble3"></i> 4</small></span>-->
            <#--                                    <h3><a href="blog.html">Renovating National Gallery</a></h3>-->
            <#--                                    <p>Separated they live in Bookmarksgrove right at the coast of the Semantics, a-->
            <#--                                        large language ocean.</p>-->
            <#--                                </div>-->
            <#--                            </div>-->
            <#--                        </div>-->
            <#--                        <div class="col-md-4 col-sm-6 animate-box" data-animate-effect="fadeInRight">-->
            <#--                            <div class="blog-entry">-->
            <#--                                <a href="blog.html" class="blog-img"><img src="images/blog-2.jpg" class="img-responsive"-->
            <#--                                                                          alt="HTML5 Bootstrap Template by colorlib.com"></a>-->
            <#--                                <div class="desc">-->
            <#--                                    <span><small>April 14, 2018 </small> | <small> Web Design </small> | <small> <i-->
            <#--                                                    class="icon-bubble3"></i> 4</small></span>-->
            <#--                                    <h3><a href="blog.html">Wordpress for a Beginner</a></h3>-->
            <#--                                    <p>Separated they live in Bookmarksgrove right at the coast of the Semantics, a-->
            <#--                                        large language ocean.</p>-->
            <#--                                </div>-->
            <#--                            </div>-->
            <#--                        </div>-->
            <#--                        <div class="col-md-4 col-sm-6 animate-box" data-animate-effect="fadeInLeft">-->
            <#--                            <div class="blog-entry">-->
            <#--                                <a href="blog.html" class="blog-img"><img src="images/blog-3.jpg" class="img-responsive"-->
            <#--                                                                          alt="HTML5 Bootstrap Template by colorlib.com"></a>-->
            <#--                                <div class="desc">-->
            <#--                                    <span><small>April 14, 2018 </small> | <small> Inspiration </small> | <small> <i-->
            <#--                                                    class="icon-bubble3"></i> 4</small></span>-->
            <#--                                    <h3><a href="blog.html">Make website from scratch</a></h3>-->
            <#--                                    <p>Separated they live in Bookmarksgrove right at the coast of the Semantics, a-->
            <#--                                        large language ocean.</p>-->
            <#--                                </div>-->
            <#--                            </div>-->
            <#--                        </div>-->
            <#--                    </div>-->
            <#--                    <div class="row">-->
            <#--                        <div class="col-md-12 animate-box">-->
            <#--                            <p><a href="#" class="btn btn-primary btn-lg btn-load-more">Load more <i-->
            <#--                                            class="icon-reload"></i></a></p>-->
            <#--                        </div>-->
            <#--                    </div>-->
            <#--                </div>-->
            <#--            </section>-->

            <#--            <section class="colorlib-contact" data-section="contact">-->
            <#--                <div class="colorlib-narrow-content">-->
            <#--                    <div class="row">-->
            <#--                        <div class="col-md-6 col-md-offset-3 col-md-pull-3 animate-box"-->
            <#--                             data-animate-effect="fadeInLeft">-->
            <#--                            <span class="heading-meta">Get in Touch</span>-->
            <#--                            <h2 class="colorlib-heading">Contact</h2>-->
            <#--                        </div>-->
            <#--                    </div>-->
            <#--                    <div class="row">-->
            <#--                        <div class="col-md-5">-->
            <#--                            <div class="colorlib-feature colorlib-feature-sm animate-box"-->
            <#--                                 data-animate-effect="fadeInLeft">-->
            <#--                                <div class="colorlib-icon">-->
            <#--                                    <i class="icon-globe-outline"></i>-->
            <#--                                </div>-->
            <#--                                <div class="colorlib-text">-->
            <#--                                    <p><a href="#">info@domain.com</a></p>-->
            <#--                                </div>-->
            <#--                            </div>-->

            <#--                            <div class="colorlib-feature colorlib-feature-sm animate-box"-->
            <#--                                 data-animate-effect="fadeInLeft">-->
            <#--                                <div class="colorlib-icon">-->
            <#--                                    <i class="icon-map"></i>-->
            <#--                                </div>-->
            <#--                                <div class="colorlib-text">-->
            <#--                                    <p>198 West 21th Street, Suite 721 New York NY 10016</p>-->
            <#--                                </div>-->
            <#--                            </div>-->

            <#--                            <div class="colorlib-feature colorlib-feature-sm animate-box"-->
            <#--                                 data-animate-effect="fadeInLeft">-->
            <#--                                <div class="colorlib-icon">-->
            <#--                                    <i class="icon-phone"></i>-->
            <#--                                </div>-->
            <#--                                <div class="colorlib-text">-->
            <#--                                    <p><a href="tel://">+123 456 7890</a></p>-->
            <#--                                </div>-->
            <#--                            </div>-->
            <#--                        </div>-->
            <#--                        <div class="col-md-7 col-md-push-1">-->
            <#--                            <div class="row">-->
            <#--                                <div class="col-md-10 col-md-offset-1 col-md-pull-1 animate-box"-->
            <#--                                     data-animate-effect="fadeInRight">-->
            <#--                                    <form action="">-->
            <#--                                        <div class="form-group">-->
            <#--                                            <input type="text" class="form-control" placeholder="Name">-->
            <#--                                        </div>-->
            <#--                                        <div class="form-group">-->
            <#--                                            <input type="text" class="form-control" placeholder="Email">-->
            <#--                                        </div>-->
            <#--                                        <div class="form-group">-->
            <#--                                            <input type="text" class="form-control" placeholder="Subject">-->
            <#--                                        </div>-->
            <#--                                        <div class="form-group">-->
            <#--                                            <textarea name="" id="message" cols="30" rows="7" class="form-control"-->
            <#--                                                      placeholder="Message"></textarea>-->
            <#--                                        </div>-->
            <#--                                        <div class="form-group">-->
            <#--                                            <input type="submit" class="btn btn-primary btn-send-message"-->
            <#--                                                   value="Send Message">-->
            <#--                                        </div>-->
            <#--                                    </form>-->
            <#--                                </div>-->

            <#--                            </div>-->
            <#--                        </div>-->
            <#--                    </div>-->
            <#--                </div>-->
            <#--            </section>-->

        </div><!-- end:colorlib-main -->
    </div><!-- end:container-wrap -->
</div><!-- end:colorlib-page -->

<!-- jQuery -->
<script src="js/jquery.min.js"></script>
<!-- jQuery Easing -->
<script src="js/jquery.easing.1.3.js"></script>
<!-- Bootstrap -->
<script src="js/bootstrap.min.js"></script>
<!-- Waypoints -->
<script src="js/jquery.waypoints.min.js"></script>
<!-- Flexslider -->
<script src="js/jquery.flexslider-min.js"></script>
<!-- Owl carousel -->
<script src="js/owl.carousel.min.js"></script>
<!-- Counters -->
<script src="js/jquery.countTo.js"></script>


<!-- MAIN JS -->
<script src="js/main.js"></script>

</body>
</html>

