import React from "react";
import history from "../../history";
import auth from "../../util/auth";
import "./styles.scss";

export const Login = ({ userinfo, setUserInfo }) => {
  const inputChange = (e) => {
    setUserInfo({ ...userinfo, [e.target.name]: e.target.value });
  };
  const submit = (e) => {
    e.preventDefault();

    const requestOptions = {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },    
      mode: 'cors',
      body: JSON.stringify(userinfo),
    };

    fetch('http://localhost:8080/authenticate', requestOptions)
    .then(function(response){return response.json();})
    .then(function(data) {
        if(data.jwt) {
            localStorage.setItem('jwtToken', data.jwt)
            auth.login(() => {
              history.push("/home")
          })
        }
    }).catch(function(error) {
        console.log(error)
    })
    
  };

  return (
    <div className="body">
      <form className="form" onSubmit={(e) => submit(e)}>
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
        Don't have an account? <a href="/register">Sign up!</a>
      </div>
    </div>
  );
};
