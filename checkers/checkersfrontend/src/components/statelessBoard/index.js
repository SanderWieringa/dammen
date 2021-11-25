import { Row } from "./Row";

import Stomp from "stompjs";
import "./styles.scss";
import { useState } from "react";

export const CheckersBoard = ({ boardData, setBoardData }) => {
  const [test, setTest] = useState({ test: [] });
  let data = [
    ["WHITE", "BLACK", "", "", " ", "", " ", ""],
    ["", " ", "", " ", "", " ", "", " "],
    [" ", "", " ", "", " ", "", " ", ""],
    [" ", " ", " ", " ", " ", " ", " ", " "],
    [" ", " ", " ", " ", " ", " ", " ", " "],
    ["", " ", "", " ", "", " ", "", " "],
    [" ", "", " ", "", " ", "", " ", ""],
    ["", " ", "", " ", "", " ", "", " "],
  ];
  // let [boardData, setBoardData] = useState([
  //   [{}, {}, {}, {}, {}, {}, {}, {}],
  //   [{}, {}, {}, {}, {}, {}, {}, {}],
  //   [{}, {}, {}, {}, {}, {}, {}, {}],
  //   [{}, {}, {}, {}, {}, {}, {}, {}],
  //   [{}, {}, {}, {}, {}, {}, {}, {}],
  //   [{}, {}, {}, {}, {}, {}, {}, {}],
  //   [{}, {}, {}, {}, {}, {}, {}, {}],
  //   [{}, {}, {}, {}, {}, {}, {}, {}],
  // ]);

  // setResult(result => [...result, response]);

  const transferData = (messageContent) => {
    //setData({ ...data, [messageContent.name]: messageContent["board"] });
    console.log("setDataLog: ", messageContent);
    console.log("setDataLog[board]: ", messageContent["board"]);
    console.log("setDataLog.board: ", messageContent.board);
    console.log("test: ", test);
    setTest(messageContent.board);
    console.log("test: ", test);
    setBoardData({ ...boardData, [messageContent]: boardData });
    console.log("setDataDataLog: ", data);
  };

  const parseJwt = (token) => {
    if (!token) {
      return;
    }
    const base64Url = token.split(".")[1];
    const base64 = base64Url.replace("-", "+").replace("_", "/");
    return JSON.parse(window.atob(base64));
  };

  let stompClient;
  let username;
  const connect = (e) => {
    e.preventDefault();

    let token = localStorage.getItem("jwtToken");
    let parsedToken = parseJwt(token);
    username = parsedToken.sub;

    if (username) {
      const login = document.getElementById("login");
      login.classList.add("hide");

      const socket = new WebSocket("ws://localhost:8080/checkers-websocket");

      stompClient = Stomp.over(socket);
      stompClient.connect({}, onConnected, onError);
    }
  };

  const onConnected = () => {
    stompClient.subscribe("/topic/public", onMessageReceived);
    stompClient.send(
      "/app/checkers.newUser",
      {},
      JSON.stringify({ sender: username, type: "CONNECT" })
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
      transferData(message.content);
      setTest(message.content);
      console.log("message.content: ", message.content);
      console.log("message.content[board]: ", message.content["board"]);
      tableRow(message);
    } else if (message.type === "DISCONNECT") {
      messageElement.classList.add("event-message");
      message.content = message.sender + " left!";
    } else {
      messageElement.classList.add("checkers-message");

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
  };

  const tableRow = (message) => {
    console.log("message: ", message);
    console.log("message.content.board: ", message.content.board);
    message.content.board.map((rowData, index) => {
      console.log("boardData: ", boardData);
      const number = boardData.length - index;
      console.log("rowData: ", rowData);

      return <Row key={number.toString()} number={number} data={rowData} />;
      //return <CheckersBoard data={rowData} />;
    });
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
                      X
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
