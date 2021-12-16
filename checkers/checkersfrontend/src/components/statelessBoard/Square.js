import React, { useState } from "react";
import { Piece } from "./Piece";
import "./styles.scss";

export const Square = (props) => {
  const isEvenRow = props.row % 2 === 0;
  const isEvenColumn = props.column.charCodeAt() % 2 !== 0;
  const isLight = (isEvenRow && isEvenColumn) || (!isEvenRow && !isEvenColumn);
  console.log("props: ", props);
  const [coor, setCoordinates] = useState();

  const drop = (e) => {
    e.preventDefault();
    console.log("square.props: ", props);

    const card_id = e.dataTransfer.getData("piece_id");

    const card = document.getElementById(card_id);
    card.style.display = "block";

    e.target.appendChild(card);
    console.log("e.target: ", e.target);

    console.log("drop: ", card);
    console.log("piece id: ", card.id);
    console.log("square id: ", e.target.id);
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
            coor={coor}
            setCoordinates={setCoordinates}
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
            coor={coor}
            setCoordinates={setCoordinates}
          />
        )}
      </td>
    );
  }
};
