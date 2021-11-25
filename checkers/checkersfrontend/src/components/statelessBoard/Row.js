import React from "react";
import { Square } from "./Square";
import "./styles.scss";

export const Row = (props) => {
  return (
    <tr>
      <th>{props.number}</th>

      {props.data.map((squareData, index) => {
        console.log(props);
        const column = String.fromCharCode(97 + index);
        return (
          <Square
            key={column + props.number}
            row={props.number}
            column={column}
            data={squareData}
          />
        );
      })}
      <th>{props.number}</th>
    </tr>
  );
};
