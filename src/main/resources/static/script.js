var socket = new SockJS('/chat-websocket');
var stompClient = Stomp.over(socket);
stompClient.connect({}, function (frame) {
    stompClient.subscribe('/topic/messages', function (message) {
        var messagesDiv = document.getElementById("messages");
        var messageSection = document.createElement("section");
        var data = message.body
        var username = data.split(":")[0]
        var userMessage = data.split(":")[1]
        messageSection.innerHTML = `
                <section class="message">
                    <img src="https://avatar.iran.liara.run/public/boy?username=${username}" alt="avatar" class="avatar">
                    <div class="nes-balloon from-left">
                        <p>${userMessage}</p>
                    </div>
                </section>
            `
        messagesDiv.appendChild(messageSection)
        scrollToBottom()
    });
});

window.onload = scrollToBottom;

function scrollToBottom() {
    var anchor = document.getElementById("scroll-anchor");
    anchor.scrollIntoView({ behavior: "smooth"})
}