import React from "react";
import "./styles.scss";

// var Statistics = React.createClass({
// 	render: function() {
// 		return(
// 			<div  className="stats" >
// 				<div className="half" style={{color: '#e26b6b'}}>
// 					Red(Player):<br/>
// 					{ (this.props.board.map( function(row){return(row.join(''))} ).join('').match(/r/g) || []).length} Soldiers<br/>
// 					{ (this.props.board.map( function(row){return(row.join(''))} ).join('').match(/r\sk/g) || []).length} Kings
// 				</div>
// 				<div className="half">
// 					Black(AI):<br/>
// 					{ (this.props.board.map( function(row){return(row.join(''))} ).join('').match(/b/g) || []).length} Soldiers<br/>
// 					{ (this.props.board.map( function(row){return(row.join(''))} ).join('').match(/b\sk/g) || []).length} Kings
// 				</div>
// 			</div>
// 		)
// 	}
// });

export const Statistics = () => {
    

    return(
        <div  className="stats" >
            <div className="half" style={{color: '#e26b6b'}}>
                Red(Player):<br/>
                { (this.props.board.map( function(row){return(row.join(''))} ).join('').match(/r/g) || []).length} Soldiers<br/>
                { (this.props.board.map( function(row){return(row.join(''))} ).join('').match(/r\sk/g) || []).length} Kings
            </div>
            <div className="half">
                Black(AI):<br/>
                { (this.props.board.map( function(row){return(row.join(''))} ).join('').match(/b/g) || []).length} Soldiers<br/>
                { (this.props.board.map( function(row){return(row.join(''))} ).join('').match(/b\sk/g) || []).length} Kings
            </div>
        </div>
    );
  };
  