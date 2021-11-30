import React from "react";
import { Piece } from "./Piece";
import "./styles.scss";

export const Square = (props) => {
  const isEvenRow = props.row % 2 === 0;
  const isEvenColumn = props.column.charCodeAt() % 2 !== 0;
  const isLight = (isEvenRow && isEvenColumn) || (!isEvenRow && !isEvenColumn);
  console.log("props: ", props);

  const drop = (e) => {
    e.preventDefault();

    const card_id = e.dataTransfer.getData("piece_id");

    const card = document.getElementById(card_id);
    card.style.display = "block";

    e.target.appendChild(card);
    console.log("e.target: ", e.target);

    console.log("drop: ", card);
  };

  const dragOver = (e) => {
    e.preventDefault();
  };

  if (isLight) {
    // console.log("PieceLight");
    // return <td className="square-light"></td>;
    return (
      <td
        id={props.id}
        onDrop={drop}
        onDragOver={dragOver}
        className="square-light"
      >
        {props.data.color.trim() && (
          <Piece
            id={"piece-" + props.row + props.column}
            className="piece"
            draggable="true"
            data={props.data}
          />
        )}
      </td>
    );
  }

  if (!isLight) {
    console.log("PieceDark");
    return (
      <td
        id={props.id}
        onDrop={drop}
        onDragOver={dragOver}
        className="square-dark"
      >
        {props.data.color.trim() && (
          <Piece
            id={"piece-" + props.row + props.column}
            className="piece"
            draggable="true"
            data={props.data}
          />
        )}
      </td>
    );
  }
};
