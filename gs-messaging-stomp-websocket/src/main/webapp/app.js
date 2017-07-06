var stompClient = null;
var stompClientTwo = null

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/gs-guide-websocket');
    var socketTwo = new SockJS('/gs-guide-websocket');
    
    stompClient = Stomp.over(socket);
    stompClientTwo = Stomp.over(socketTwo);
    
    stompClient.connect({}, function (frame) {	
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetings', function (greeting) {
            showGreeting(JSON.parse(greeting.body).fileName);
        });
    });
    
    stompClientTwo.connect({}, function (frame) {	
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClientTwo.subscribe('/change-file', function (greeting) {
        	showReceivedMessage(greeting.body);
        });
    })
}

function disconnect() {
    if (stompClient != null) {
    	stompClient.disconnect();
    	stompClientTwo.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
	stompClientTwo.send("/app/hello", {}, JSON.stringify({'name': $("#name").val(), 'rename': $("#rename").val()}));
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

function showReceivedMessage(message) {
	var message = JSON.parse(message).content;
    $("#greetings").append("<tr><td>File: " + message.name + " -> " + message.rename + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});

