import React from "react";
import blackMan from "../../black-man.svg";
import whiteMan from "../../white-man.svg";
import "./styles.scss";

export const Piece = (props) => {
  const handleClick = () => {
    props.setCoordinates(props.id);
  };

  if (props.data.color === "WHITE") {
    return (
      <img
        id={props.id}
        className="piece"
        src={whiteMan}
        alt={``}
        onClick={() => {
          handleClick();
        }}
      />
    );
  }
  if (props.data.color === "BLACK") {
    return (
      <img
        id={props.id}
        className="piece"
        src={blackMan}
        alt={``}
        onClick={() => {
          handleClick();
        }}
      ></img>
    );
  } else {
    return null;
  }
};
