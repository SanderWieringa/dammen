import React from "react";
import blackMan from "../../black-man.svg";
import "./styles.scss";

export const Blackman = () => {
  return <img src={blackMan} alt={"A black man."} className={"piece"} />;
};
