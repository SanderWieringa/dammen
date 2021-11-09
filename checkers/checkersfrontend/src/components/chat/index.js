import * as SockJS from "sockjs-client";
import Stomp from "stompjs";
import "./styles.scss";
import React from "react";

export const Chat = ({ userinfo, setUserInfo }) => {
  const inputChange = (e) => {
    setUserInfo({ ...userinfo, [e.target.name]: e.target.value });
  };
  let stompClient;
  let username;
  const connect = (e) => {
    e.preventDefault();
    console.log("here 1");

    username = document.getElementById("username");
    console.log(username.value);

    if (username) {
      console.log("here 2");
      const login = document.getElementById("login");
      login.classList.add("hide");

      const chatPage = document.getElementById("chat-page");
      chatPage.classList.remove("hide");

      //ToDo:

      const socket = new WebSocket("ws://localhost:8080/chat-example");

      console.log("here 8");

      stompClient = Stomp.over(socket);
      console.log("here 9");
      stompClient.connect({}, onConnected, onError);
      console.log("here 10");
    }
    console.log("here 3");
  };

  const onConnected = () => {
    console.log("here 4");
    stompClient.subscribe("/app/topic", onMessageReceived);
    console.log("here 5");
    stompClient.send(
      "/app/chat.newUser",
      {},
      JSON.stringify({ sender: username, type: "CONNECT" })
    );
    console.log("here 6");
    const status = document.querySelector("#status");
    status.className = "hide";
  };

  const onError = (error) => {
    console.log("here 7");
    const status = document.querySelector("#status");
    status.innerHTML =
      "Could not find the connection you were looking for. Move along. Or, Refresh the page!";
    status.style.color = "red";
  };

  const hashCode = (str) => {
    let hash = 0;
    for (let i = 0; i < str.length; i++) {
      hash = str.charCodeAt(i) + ((hash << 5) - hash);
    }
    return hash;
  };

  const getAvatarColor = (messageSender) => {
    const colours = ["#2196F3", "#32c787", "#1BC6B4", "#A1B4C4"];
    const index = Math.abs(hashCode(messageSender) % colours.length);
    return colours[index];
  };

  const onMessageReceived = (payload) => {
    const message = JSON.parse(payload.body);

    const chatCard = document.createElement("div");
    chatCard.className = "card-body";

    const flexBox = document.createElement("div");
    flexBox.className = "d-flex justify-content-end mb-4";
    chatCard.appendChild(flexBox);

    const messageElement = document.createElement("div");
    messageElement.className = "msg_container_send";

    flexBox.appendChild(messageElement);

    if (message.type === "CONNECT") {
      messageElement.classList.add("event-message");
      message.content = message.sender + " connected!";
    } else if (message.type === "DISCONNECT") {
      messageElement.classList.add("event-message");
      message.content = message.sender + " left!";
    } else {
      messageElement.classList.add("chat-message");

      const avatarContainer = document.createElement("div");
      avatarContainer.className = "img_cont_msg";
      const avatarElement = document.createElement("div");
      avatarElement.className = "circle user_img_msg";
      const avatarText = document.createTextNode(message.sender[0]);
      avatarElement.appendChild(avatarText);
      avatarElement.style["background-color"] = getAvatarColor(message.sender);
      avatarContainer.appendChild(avatarElement);

      messageElement.style["background-color"] = getAvatarColor(message.sender);

      flexBox.appendChild(avatarContainer);

      const time = document.createElement("span");
      time.className = "msg_time_send";
      time.innerHTML = message.time;
      messageElement.appendChild(time);
    }

    messageElement.innerHTML = message.content;

    const chat = document.querySelector("#chat");
    chat.appendChild(flexBox);
    chat.scrollTop = chat.scrollHeight;
  };

  return (
    <div>
      <div>
        <title>App</title>
        <div className="container-fluid h-100">
          <div id="status" className="login"></div>
          <div id="login">
            <div className="main row justify-content-center h-100">
              <form
                id="login-form"
                name="login-form"
                onSubmit={(e) => connect(e)}
              >
                <div className="input-group">
                  <input
                    id="username"
                    type="text"
                    className="form-control all-input"
                    autoComplete="off"
                    placeholder="Username"
                    onChange={(e) => inputChange(e)}
                  />
                  <div className="input-group-append">
                    <button className="fas fa-location-arrow" type="submit">
                      X
                    </button>
                  </div>
                </div>
              </form>
            </div>
          </div>
          <div id="chat-page" className="hide main">
            <div className="row justify-content-center h-100">
              <div className="col-md-8 col-xl-6">
                <div className="card">
                  <div className="card-header">
                    <div className="d-flex bd-highlight">
                      <div className="chat-summary">
                        <span>Web Sockets with Spring Boot Chat</span>
                      </div>
                    </div>
                  </div>

                  <div className="card-body">
                    <div id="chat"></div>
                  </div>

                  <form
                    id="message-controls"
                    name="message-controls"
                    className="card-footer"
                  >
                    <div className="input-group">
                      <textarea
                        id="message"
                        className="form-control all-input"
                        placeholder="Type your message..."
                      ></textarea>
                      <div className="input-group-append">
                        <button className="fas fa-location-arrow" type="submit">
                          X
                        </button>
                      </div>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};
