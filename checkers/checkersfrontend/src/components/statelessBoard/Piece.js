import React from "react";
import Draggable from "react-draggable";
import blackMan from "../../black-man.svg";
import whiteMan from "../../white-man.svg";
import "./styles.scss";

export const Piece = (props) => {
  const player = props.data === "O" ? "white" : "black";

  return (
    <Draggable>
      <img
        src={player === "white" ? whiteMan : blackMan}
        alt={`A ${player} man.`}
        className={"piece"}
      />
    </Draggable>
  );
};
