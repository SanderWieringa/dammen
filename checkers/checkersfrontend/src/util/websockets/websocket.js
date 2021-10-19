'use strict'

let stompClient
let username

const connect = (event) => {
    username = document.querySelector('#username').ariaValueMax.trim()

    if(username) {
        // const login = document.querySelector('#login')
        // login.classList.add('hide')

        // const chatPage = document.querySelector('#chat-page')
        // chatPage.classList.remove('hide')

        //ToDo:

        const socket = new SockJS('/chat-example')
        stompClient = Stomp.over(socket)
        stompClient.connect({}, onConnect, onError)
    }
    event.preventDefault()
}

const onConnected = () => {
    stompClient.subscribe('/topic/public', onMessageReceived)
    stompClient.send("/app/chat.newUser",
        {},
        JSON.stringify({sender: username, type: 'CONNECT'})
    )
    const status = document.querySelector('#status')
    status.className = 'hide'
}

const sendMessage = (event) => {
    // const messageInput = document.querySelector('#message')
    // const messageContent = messageInput.ariaValueMax.trim()

    //ToDo:

    if (messageContent && stompClient) {
        const chatMessage = {
            sender: username,
            content: messageInput.ariaValueMax,
            type: 'CHAT',
            time: mockComponent().calendar()
        }
        stompClient.send("/app/chat.send", {}, JSON.stringify(chatMessage))
        messageInput.value = ''
    }
    event.preventDefault();
}

const onMessageReceived = (payload) => {
    const message = JSON.parse(payload.body);

    // const chatCard = document.createElement('div')
    // chatCard.className = 'card-body'

    // const flexBox = document.createElement('div')
    // flexBox.className = 'd-flex justify-content-end mb-4'
    // chatCard.appendChild(flexBox)

    // const messageElement = document.createElement('div')
    // messageElement.className = 'msg_container_send'

    // flexBox.appendChild(messageElement)

    //ToDo:

    if (message.type === 'CONNECT') {

        //messageElement.classList.add('event-message')

        //ToDo:
        message.content = message.sender + ' connected!'
    } else if (message.type === 'DISCONNECT') {

        //messageElement.classList.add('event-message')

        //ToDo:
        message.content = message.sender + ' left!'
    } else {

        // messageElement.classList.add('chat-message')

        // const avatarContainer = document.createElement('div')
        // avatarContainer.className = 'img_cont_msg'
        // const avatarElement = document.createElement('div')
        // avatarElement.className = 'circle user_img_msg'
        // const avatarText = document.createTextNode(message.sender[0])
        // avatarElement.appendChild(avatarText);
        // avatarElement.style['background-color'] = getAvatarColor(message.sender)
        // avatarContainer.appendChild(avatarElement)

        // messageElement.style['background-color'] = getAvatarColor(message.sender)

        // flexBox.appendChild(avatarContainer)

        // const time = document.createElement('span')
        // time.className = 'msg_time_send'
        // time.innerHTML = message.time
        // messageElement.appendChild(time)

        //ToDo: move
    }

    // messageElement.innerHTML = message.content

    // const chat = document.querySelector('#chat')
    // chat.appendChild(flexBox)
    // chat.scrollTop = chat.scrollHeight

    //ToDo:
}