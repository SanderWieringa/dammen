import React from "react";
import "./styles.scss";

//cell is passed a single item in a row, and renders it out, it also calls it's grand-parent's swapper function on click 
// var Popup = React.createClass({
// 	render: function() {
// 		if (this.props.shown) {
// 			return(
// 				<div className="pop" onClick={this.props.close} >
// 					<div className="internal" >
// 						{this.props.copy}
// 						<button onClick={this.props.close} className="close">x</button>
// 					</div>
// 				</div>
// 			)
// 		}
// 		else {
// 			return(
// 				<div style={{display: 'none'}}></div>
// 			)
// 		}
// 	}
// });

//cell is passed a single item in a row, and renders it out, it also calls it's grand-parent's swapper function on click 
export const Popup = () => {
    
    if (this.props.shown) {
        return(
            <div className="pop" onClick={this.props.close} >
                <div className="internal" >
                    {this.props.copy}
                    <button onClick={this.props.close} className="close">x</button>
                </div>
            </div>
        );
    }
    else {
        return(
            <div style={{display: 'none'}}></div>
        )
    }
  };
  