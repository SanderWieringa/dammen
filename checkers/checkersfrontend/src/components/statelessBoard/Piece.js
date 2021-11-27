import React from "react";
import blackMan from "../../black-man.svg";
import whiteMan from "../../white-man.svg";
import "./styles.scss";

export const Piece = (props) => {
  console.log("props.data: ", props.data);
  if (props.data.color === "WHITE") {
    return <img src={whiteMan} alt={``} className={"piece"} />;
  }
  if (props.data.color === "BLACK") {
    return <img src={blackMan} alt={``} className={"piece"} />;
  } else {
    return null;
  }
};
