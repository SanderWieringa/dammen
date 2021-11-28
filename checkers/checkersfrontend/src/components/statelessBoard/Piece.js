import React from "react";
import blackMan from "../../black-man.svg";
import whiteMan from "../../white-man.svg";
import "./styles.scss";

export const Piece = (props) => {
  const dragStart = (e) => {
    const target = e.target;

    e.dataTransfer.setData("card_id", target.id);

    setTimeout(() => {
      target.style.display = "none";
    }, 0);
  };

  const dragOver = (e) => {
    e.stopPropagation();
  };

  if (props.data.color === "WHITE") {
    return (
      <img
        id={props.id}
        draggable={props.draggable}
        onDragStart={dragStart}
        onDragOver={dragOver}
        src={whiteMan}
        alt={``}
        className={"piece"}
      />
    );
  }
  if (props.data.color === "BLACK") {
    return (
      <img
        id={props.id}
        className={props.className}
        draggable={props.draggable}
        onDragStart={dragStart}
        onDragOver={dragOver}
        src={blackMan}
        alt={``}
        className={"piece"}
      />
    );
  } else {
    return null;
  }
};
