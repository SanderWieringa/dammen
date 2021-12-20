import React from "react";
import { Piece } from "./Piece";
import "./styles.scss";

export const Square = (props) => {
  const isEvenRow = props.row % 2 === 0;
  const isEvenColumn = props.column.charCodeAt() % 2 !== 0;
  const isLight = (isEvenRow && isEvenColumn) || (!isEvenRow && !isEvenColumn);

  if (isLight) {
    return (
      <td id={props.id} className="square-light">
        {props.data.color.trim() && (
          <Piece
            id={props.row + props.column}
            class="piece"
            data={props.data}
            coor={props.coor}
            setCoordinates={props.setCoordinates}
          />
        )}
      </td>
    );
  }

  if (!isLight) {
    return (
      <td id={props.id} className="square-dark">
        {props.data.color.trim() && (
          <Piece
            id={props.row + props.column}
            class="piece"
            data={props.data}
            coor={props.coor}
            setCoordinates={props.setCoordinates}
          />
        )}
      </td>
    );
  }
};
