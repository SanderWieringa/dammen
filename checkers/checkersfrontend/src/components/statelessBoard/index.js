import { Row } from "./Row";

import Stomp from "stompjs";
import "./styles.scss";
import { useState } from "react";
//import SquareModel from "../../models/SquareModel";

export const CheckersBoard = () => {
  let [data, setData] = useState([
    [
      { color: "WHITE", king: false },
      { color: "WHITE", king: false },
      { color: "WHITE", king: false },
      { color: "WHITE", king: false },
      { color: "WHITE", king: false },
      { color: "WHITE", king: false },
      { color: "WHITE", king: false },
      { color: "WHITE", king: false },
    ],
    [
      { color: "WHITE", king: false },
      { color: "WHITE", king: false },
      { color: "WHITE", king: false },
      { color: "WHITE", king: false },
      { color: "WHITE", king: false },
      { color: "WHITE", king: false },
      { color: "WHITE", king: false },
      { color: "WHITE", king: false },
    ],
    [
      { color: "WHITE", king: false },
      { color: "WHITE", king: false },
      { color: "WHITE", king: false },
      { color: "WHITE", king: false },
      { color: "WHITE", king: false },
      { color: "WHITE", king: false },
      { color: "WHITE", king: false },
      { color: "WHITE", king: false },
    ],
    [
      { color: "WHITE", king: false },
      { color: "WHITE", king: false },
      { color: "WHITE", king: false },
      { color: "WHITE", king: false },
      { color: "WHITE", king: false },
      { color: "WHITE", king: false },
      { color: "WHITE", king: false },
      { color: "WHITE", king: false },
    ],
    [
      { color: "WHITE", king: false },
      { color: "WHITE", king: false },
      { color: "WHITE", king: false },
      { color: "WHITE", king: false },
      { color: "WHITE", king: false },
      { color: "WHITE", king: false },
      { color: "WHITE", king: false },
      { color: "WHITE", king: false },
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
      { color: "WHITE", king: false },
      { color: "WHITE", king: false },
      { color: "WHITE", king: false },
      { color: "WHITE", king: false },
      { color: "WHITE", king: false },
      { color: "WHITE", king: false },
      { color: "WHITE", king: false },
      { color: "WHITE", king: false },
    ],
    [
      { color: "BLACK", king: false },
      { color: "BLACK", king: false },
      { color: "BLACK", king: false },
      { color: "BLACK", king: false },
      { color: "BLACK", king: false },
      { color: "BLACK", king: false },
      { color: "BLACK", king: false },
      { color: "BLACK", king: false },
    ],
  ]);

  const transferData = (boardData) => {
    console.log("boardData: ", boardData);
    console.log("boardData[board]: ", boardData["board"]);
    console.log("data1: ", data);

    for (let i = 0; i < 8; i++) {
      setData(boardData["board"][i]);
    }

    //setData((data) => ({ data: [...data, boardData["board"]] }));

    //setData(boardData["board"]);

    //setData((data) => [...data, boardData.board, `${data.length}`]);

    //{ ...userinfo, [e.target.name]: e.target.value }
    // data[0] = boardData["board"][0];
    // data[1] = boardData["board"][1];
    // data[2] = boardData["board"][2];
    // data[3] = boardData["board"][3];
    // tableRow(data);
    //data.map(boardData.board);
    // setData({ ...data, [data]: boardData["board"] });

    //     setData({ for(i = 0, i < d, i++)
    //   }
    // }});

    // for (let i = 0; i < 8; i++) {
    //   data[i] = boardData["board"][i];
    // }
    // setData(data);
    // tableRow(data);
    console.log("data2: ", data);
    //setBoardData({ ...boardData, [messageContent]: boardData });
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
      //setData(boardData);
      //tableRow(message);
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

  const tableRow = (data) => {
    //console.log("boardData.content.board: ", boardData.content.board);
    data.map((rowData, index) => {
      console.log("data3: ", data);
      const number = data.length - index;

      return <Row key={number.toString()} number={number} data={rowData} />;
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
