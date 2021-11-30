import React from "react";
import "./styles.scss";
import { useHistory } from "react-router-dom";

export const Signup = ({ userinfo, setUserInfo }) => {
  let history = useHistory();
  const inputChange = (e) => {
    setUserInfo({ ...userinfo, [e.target.name]: e.target.value });
  };

  const requestOptions = {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    mode: "cors",
    body: JSON.stringify(userinfo),
  };

  const submit = (e) => {
    e.preventDefault();

    if (!userinfo.username.trim()) {
      alert('Please Enter Name');
      return;
    }
    else if(!userinfo.password.trim()){
      alert('Please Enter Password');
      return;
    }
    fetch("http://localhost:8080/account/register", requestOptions)
      .then(function (response) {
        console.log(response);
        if(response.ok == true)
        {
          history.push("/");
        }
        return response.json();
      })
      .catch(function (error) {
        console.log(error);
      });
  };

  return (
    <div className="body">
      <form className="form" onSubmit={(e) => submit(e)}>
        <h1 className="login-title">Registration</h1>
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
        <input
          type="password"
          className="input"
          name="confPass"
          onChange={(e) => inputChange(e)}
          placeholder="Confirm password"
        ></input>
        <input
          type="email"
          className="input"
          name="email"
          onChange={(e) => inputChange(e)}
          placeholder="Enter your email"
        ></input>
        <input
          type="email"
          className="input"
          name="confEmail"
          onChange={(e) => inputChange(e)}
          placeholder="confirm your email"
        ></input>
        <button className="button" type="submit">
          Sign up!
        </button>
      </form>
      <div className="register">
        Already have an account? <a href="/">Log in!</a>
      </div>
    </div>
  );
};
