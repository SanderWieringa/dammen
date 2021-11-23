import React from "react";
import whiteMan from "../../white-man.svg";
import "./styles.scss";

export const WhiteMan = () => {
  return <img src={whiteMan} alt={"A white man."} className={"piece"} />;
};
