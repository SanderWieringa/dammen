import React, {useState} from "react";
import {Login} from "./components/login";
import "./App.css";

export const App = () => {
  const [userInfo, setUserInfo] = useState({  username: "", password: ""  });;
  return (
    <div className="container">
      <Login exact path="/" userinfo={userInfo} setUserInfo={setUserInfo} />
    </div>
  );
};