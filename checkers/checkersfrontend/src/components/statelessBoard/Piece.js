import React from "react";
import blackMan from "../../black-man.svg";
import whiteMan from "../../white-man.svg";

export const Piece = (props) => {
    const player = props.data === 'O' ? 'white' : 'black'

    return (
        <img src={player === 'white' ? whiteMan : blackMan} alt={`A ${player} man.`} className={'piece'} />
    )
};

  
  