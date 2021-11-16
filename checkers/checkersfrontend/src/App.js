import React, { useState } from "react";
import { Login } from "./components/login";
import { Signup } from "./components/signup";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

import "./App.css";
import { CheckersBoard } from "./components/statelessBoard";
import { Home } from "./components/home";

export const App = () => {
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
          <Route exact path="/" component={CheckersBoard} />
          <Route exact path="/Home" component={Home} />
        </Switch>
      </Router>
    </div>
  );
};
  