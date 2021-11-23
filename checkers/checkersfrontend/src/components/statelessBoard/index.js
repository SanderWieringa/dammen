import { Row } from "./Row";
import Stomp from "stompjs";
import "./styles.scss";

export const CheckersBoard = (
  { userinfo, setUserInfo },
  { boardData, setBoardData }
) => {
  const setData = (messageContent) => {
    data = messageContent;
  };
  const inputChange = (e) => {
    setUserInfo({ ...userinfo, [e.target.name]: e.target.value });
  };
  let data = [
    [" ", "", " ", "", " ", "", " ", ""],
    ["", " ", "", " ", "", " ", "", " "],
    [" ", "", " ", "", " ", "", " ", ""],
    [" ", " ", " ", " ", " ", " ", " ", " "],
    [" ", " ", " ", " ", " ", " ", " ", " "],
    ["", " ", "", " ", "", " ", "", " "],
    [" ", "", " ", "", " ", "", " ", ""],
    ["", " ", "", " ", "", " ", "", " "],
  ];

  let stompClient;
  let username;
  const connect = (e) => {
    e.preventDefault();

    username = userinfo.username;
    console.log("username: ", username);

    if (username) {
      // const login = document.getElementById("login");
      // login.classList.add("hide");

      // const chatPage = document.getElementById("chat-page");
      // chatPage.classList.remove("hide");

      //ToDo:

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
      setData(message.content);
      //setBoardData(message.content);
      console.log("data", message.content);
      //message.content = message.sender + " connected!";
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
