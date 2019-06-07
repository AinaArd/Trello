<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="/css/style.css" rel="stylesheet">
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
</head>
<body>
<h1>Сhat</h1>
<div class="chat_window">
    <div class="top_menu">
        <div class="buttons">
            <div class="button close"></div>
            <div class="button minimize"></div>
            <div class="button maximize"></div>
        </div>
        <div class="title">Chat</div>
    </div>
    <ul class="messages"></ul>
    <div class="bottom_wrapper clearfix">
        <div class="message_input_wrapper">
            <input id="message_input_value" class="message_input" placeholder="Type your message here..."/>
        </div>
        <div class="send_message">
            <button onclick="sendMessage()" class="button-add">Send</button>
        </div>
        <br>
        <button onclick="connect()" class="button-add">Connect to chat</button>
        <button onclick="disconnect()" class="button-add">Disconnect from chat</button>
    </div>
</div>
<div id="message_template" class="message_template">
    <li class="message">
        <div class="avatar"></div>
        <div class="text_wrapper">
            <div class="text"></div>
        </div>
    </li>
</div>
<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
<script src="http://cdn.bootcss.com/stomp.js/2.3.3/stomp.js"></script>
<script src="http://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script type="application/javascript" src="/js/script.js"></script>
</body>
</html>