import React from "react";
import blackMan from "../../black-man.svg";
import whiteMan from "../../white-man.svg";
import "./styles.scss";

export const Piece = (props) => {
  console.log("props.data: ", props.data);
  const player = props.data === "WHITE" ? "white" : "black";

  return (
    <img
      src={player === "white" ? whiteMan : blackMan}
      alt={`A ${player} man.`}
      className={"piece"}
    />
  );
};
