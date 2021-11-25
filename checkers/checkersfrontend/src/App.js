import React, { useState } from "react";
import { Login } from "./components/login";
import { Signup } from "./components/signup";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

import "./App.css";
import { CheckersBoard } from "./components/statelessBoard";
import { Chat } from "./components/chat";
import { Home } from "./components/home";

export const App = () => {
  const [boardData, setBoardData] = useState({
    data: [
      [
        { color: "WHITE", king: false },
        { color: "WHITE", king: false },
        { color: "WHITE", king: false },
        { color: "WHITE", king: false },
        { color: "BLACK", king: false },
        { color: "BLACK", king: false },
        { color: "BLACK", king: false },
        { color: "BLACK", king: false },
      ],
      [
        { color: "WHITE", king: false },
        { color: "WHITE", king: false },
        { color: "WHITE", king: false },
        { color: "WHITE", king: false },
        { color: "BLACK", king: false },
        { color: "BLACK", king: false },
        { color: "BLACK", king: false },
        { color: "BLACK", king: false },
      ],
      [
        { color: "WHITE", king: false },
        { color: "WHITE", king: false },
        { color: "WHITE", king: false },
        { color: "WHITE", king: false },
        { color: "BLACK", king: false },
        { color: "BLACK", king: false },
        { color: "BLACK", king: false },
        { color: "BLACK", king: false },
      ],
      [
        { color: "WHITE", king: false },
        { color: "WHITE", king: false },
        { color: "WHITE", king: false },
        { color: "WHITE", king: false },
        { color: "BLACK", king: false },
        { color: "BLACK", king: false },
        { color: "BLACK", king: false },
        { color: "BLACK", king: false },
      ],
      [
        { color: "WHITE", king: false },
        { color: "WHITE", king: false },
        { color: "WHITE", king: false },
        { color: "WHITE", king: false },
        { color: "BLACK", king: false },
        { color: "BLACK", king: false },
        { color: "BLACK", king: false },
        { color: "BLACK", king: false },
      ],
      [
        { color: "WHITE", king: false },
        { color: "WHITE", king: false },
        { color: "WHITE", king: false },
        { color: "WHITE", king: false },
        { color: "BLACK", king: false },
        { color: "BLACK", king: false },
        { color: "BLACK", king: false },
        { color: "BLACK", king: false },
      ],
      [
        { color: "WHITE", king: false },
        { color: "WHITE", king: false },
        { color: "WHITE", king: false },
        { color: "WHITE", king: false },
        { color: "BLACK", king: false },
        { color: "BLACK", king: false },
        { color: "BLACK", king: false },
        { color: "BLACK", king: false },
      ],
      [
        { color: "WHITE", king: false },
        { color: "WHITE", king: false },
        { color: "WHITE", king: false },
        { color: "WHITE", king: false },
        { color: "BLACK", king: false },
        { color: "BLACK", king: false },
        { color: "BLACK", king: false },
        { color: "BLACK", king: false },
      ],
    ],
  });
  const [userInfo, setUserInfo] = useState({
    username: "",
    password: "",
    confPass: "",
    email: "",
    confEmail: "",
  });
  return (
    <div className="container">
      <Router>
        <Switch>
          <Route exact path="/login">
            <Login userinfo={userInfo} setUserInfo={setUserInfo} />
          </Route>
          <Route exact path="/register">
            <Signup userinfo={userInfo} setUserInfo={setUserInfo} />
          </Route>
          <Route exact path="/">
            <CheckersBoard boardData={boardData} setBoardData={setBoardData} />
          </Route>
          <Route exact path="/Home" component={Home} />
        </Switch>
      </Router>
    </div>
  );
};
