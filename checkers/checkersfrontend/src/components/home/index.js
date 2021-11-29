import React from "react";
import "./styles.scss";
import { useHistory } from "react-router-dom";

export const Home = () => {
  let history = useHistory();
    
  const logout = () => {
    localStorage.clear();
    history.push("/login")
  }

  const game = () => {
    history.push("/")
  }

    return (
      <div>
        <nav>
          <h2>Welcome</h2> 
          <button onClick = {logout}>Log Out</button>
          <button onClick = {game}>Game</button>
        </nav>
      </div>
    );
  
  };
  