import { Row } from "./Row";

import Stomp from "stompjs";
import "./styles.scss";
import { useState } from "react";

export const CheckersBoard = () => {
  let stompClient;
  let username;

  let [data, setData] = useState([
    [
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
    ],
    [
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
    ],
    [
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
    ],
    [
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
    ],
    [
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
    ],
    [
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
    ],
    [
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
    ],
    [
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
      { color: "EMPTY", king: false },
    ],
  ]);

  const transferData = (boardData) => {
    setData(boardData.board);
  };

  const parseJwt = (token) => {
    if (!token) {
      return;
    }
    const base64Url = token.split(".")[1];
    const base64 = base64Url.replace("-", "+").replace("_", "/");
    return JSON.parse(window.atob(base64));
  };

  const connect = (e) => {
    e.preventDefault();

    let token = localStorage.getItem("jwtToken");
    let parsedToken = parseJwt(token);
    global.username = parsedToken.sub;

    if (global.username) {
      const login = document.getElementById("login");
      login.classList.add("hide");

      const chatPage = document.getElementById("checkers-page");
      chatPage.classList.remove("hide");

      const socket = new WebSocket("ws://localhost:8080/checkers-websocket");

      global.stompClient = Stomp.over(socket);

      global.stompClient.connect({}, onConnected, onError);
    }
  };

  const onConnected = () => {
    global.stompClient.subscribe("/topic/public", onMessageReceived);
    global.stompClient.send(
      "/app/checkers.newUser",
      {},
      JSON.stringify({ sender: global.username, type: "CONNECT" })
    );
    const status = document.getElementById("status");
    status.className = "hide";
  };

  const onError = (error) => {
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

  const sendMessage = (event) => {
    event.preventDefault();
    let messageContent = data;

    if (messageContent && global.stompClient) {
      const chatMessage = {
        sender: global.username,
        content: { board: messageContent },
        type: "CHAT",
      };
      global.stompClient.send(
        "/app/checkers.send",
        {},
        JSON.stringify(chatMessage)
      );
      messageContent = data;
    }
  };

  const messageControls = document.createElement("message-controls");
  messageControls.addEventListener("submit", sendMessage, true);

  const onMessageReceived = (payload) => {
    const message = JSON.parse(payload.body);

    const messageElement = document.createElement("div");
    messageElement.className = "msg_container_send";

    if (message.type === "CONNECT") {
      messageElement.classList.add("event-message");
      transferData(message.content);
    } else if (message.type === "DISCONNECT") {
      messageElement.classList.add("event-message");
      message.content = message.sender + " left!";
    } else {
      messageElement.classList.add("chat-message");

      transferData(message.content);

      const avatarContainer = document.createElement("div");
      avatarContainer.className = "img_cont_msg";
      const avatarElement = document.createElement("div");
      avatarElement.className = "circle user_img_msg";
      const avatarText = document.createTextNode(message.sender[0]);
      avatarElement.appendChild(avatarText);
      avatarElement.style["background-color"] = getAvatarColor(message.sender);
      avatarContainer.appendChild(avatarElement);

      messageElement.style["background-color"] = getAvatarColor(message.sender);
    }

    messageElement.innerHTML = message.content;
  };

  return (
    <div>
      <div>
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
                  <div className="input-group-append">
                    <button className="fas fa-location-arrow" type="submit">
                      Join Lobby
                    </button>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
        <div id="checkers-page" className="hide main">
          <div className="row justify-content-center h-100">
            <div className="col-md-8 col-xl-6">
              <div className="card-header">
                <div className="d-flex bd-highlight"></div>
              </div>

              <div className="card-body">
                <div id="chat"></div>
              </div>

              <form
                id="message-controls"
                name="message-controls"
                className="card-footer"
                onSubmit={(e) => sendMessage(e)}
              >
                <div className="input-group">
                  <div className="input-group-append">
                    <button className="fas fa-location-arrow" type="submit">
                      Send Message
                    </button>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
        <table className="no-border">
          <thead>
            <tr>
              <th></th>
              <th>a</th>
              <th>b</th>
              <th>c</th>
              <th>d</th>
              <th>e</th>
              <th>f</th>
              <th>g</th>
              <th>h</th>
              <th></th>
            </tr>
          </thead>
          <tbody>
            {data.map((rowData, index) => {
              const number = data.length - index;

              return (
                <Row key={number.toString()} number={number} data={rowData} />
              );
            })}
          </tbody>
          <tfoot>
            <tr>
              <th></th>
              <th>a</th>
              <th>b</th>
              <th>c</th>
              <th>d</th>
              <th>e</th>
              <th>f</th>
              <th>g</th>
              <th>h</th>
              <th></th>
            </tr>
          </tfoot>
        </table>
      </div>
    </div>
  );
};
