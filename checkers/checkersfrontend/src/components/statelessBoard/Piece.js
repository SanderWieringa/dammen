import React from "react";
import blackMan from "../../black-man.svg";
import whiteMan from "../../white-man.svg";
import "./styles.scss";

export const Piece = (props, { coor, setCoordinates }) => {
  const handleClick = () => {
    setCoordinates(coor);
  };

  const dragStart = (e) => {
    const target = e.target;

    console.log("target: ", target);

    e.dataTransfer.setData("piece_id", target.id);

    const card_id = e.dataTransfer.getData("piece_id");

    const card = document.getElementById(card_id);

    console.log("card: ", card);
    console.log("props: ", props);
    console.log("props.data.column: ", props.data.column);

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
        draggable={props.draggable}
        onDragStart={dragStart}
        onDragOver={dragOver}
        src={blackMan}
        alt={``}
        className={"piece"}
        onClick={() => {
          handleClick();
        }}
      ></img>
    );
  } else {
    return null;
  }
};
