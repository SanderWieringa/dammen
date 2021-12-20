import React from "react";
import { Square } from "./Square";
import "./styles.scss";

export const Row = (props) => {
  return (
    <tr>
      <th>{props.number}</th>

      {props.data.map((squareData, index) => {
        const column = String.fromCharCode(97 + index);
        return (
          <Square
            id={"square-" + props.number + index}
            key={column + props.number}
            row={props.number}
            column={column}
            data={squareData}
            coor={props.coor}
            setCoordinates={props.setCoordinates}
          />
        );
      })}

      <th>{props.number}</th>
    </tr>
  );
};
