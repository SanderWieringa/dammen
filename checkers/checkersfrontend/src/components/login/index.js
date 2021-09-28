import React from "react";
import axios from 'axios';
import "./styles.scss";

export const Login = ({ userinfo, setUserInfo }) => {
    const inputChange = (e) => {
      setUserInfo({ ...userinfo, [e.target.name]: e.target.value });
  };
  const submit = (e) => {
    e.preventDefault();

    axios.post(`https://localhost:8080/register`, { userinfo })
      .then(res => {
        console.log(res);
        console.log(res.data);
      })
    

    console.log(userinfo);
  };

  
  
  return (
    <div className="body">
      <form className="form" onSubmit={(e) => submit(e) }>
        <h1 className="login-title">Login</h1>
        <input
          name="username"
          type="text"
          className="input"
          placeholder="Username"
          onChange={(e) => inputChange(e)}
        ></input>
        <input
          type="password"
          className="input"
          name="password"
          onChange={(e) => inputChange(e)}
          placeholder="Password"
        ></input>
        <button className="button" type="submit">
          Sign in
        </button>
        <p className="p">Lost your password?</p>
      </form>
      <div className="register">
        Don't have an account? <u>Sign up here!</u>
      </div>
    </div>
  );
};