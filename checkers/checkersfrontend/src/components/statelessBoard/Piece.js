import React from "react";
import blackMan from "../../black-man.svg";
import whiteMan from "../../white-man.svg";
import "./styles.scss";

export const Piece = (props) => {
  const player = props.data.Board.Piece.Color === "BLACK" ? "white" : "black";

  return (
    <img
      src={player === "white" ? whiteMan : blackMan}
      alt={`A ${player} man.`}
      className={"piece"}
    />
  );
};
