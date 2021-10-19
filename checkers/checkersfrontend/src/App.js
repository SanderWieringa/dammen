import React, { useState } from "react";
import { Login } from "./components/login";
import { Signup } from "./components/signup";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

import "./App.css";
import { CheckersBoard } from "./components/statelessBoard";

export const App = () => {
  const express = require('express');
  const app = express();
  const http = require('http');
  const server = http.createServer(app);
  const { Server } = require("socket.io");
  const io = new Server(server);
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
          <Route exact path="/home" component={CheckersBoard}/>
        </Switch>
      </Router>
    </div>
  );
};
