import React, { useEffect } from "react";
import { Popup } from "./Popup";
import { Row } from "./Row";
import { Statistics } from "./Statistics";
import "./styles.scss";

// var GameBoard = React.createClass({
// 	getInitialState: function() {
// 		return {
// 			board: [
// 				['b','-','b','-','b','-','b','-'],
// 				['-','b','-','b','-','b','-','b'],
// 				['b','-','b','-','b','-','b','-'],
// 				['-','-','-','-','-','-','-','-'],
// 				['-','-','-','-','-','-','-','-'],
// 				['-','r','-','r','-','r','-','r'],
// 				['r','-','r','-','r','-','r','-'],
// 				['-','r','-','r','-','r','-','r']
// 			],
// 			activePlayer: 'r',
// 			aiDepthCutoff: 3,
// 			count: 0,
// 			popShown: false
// 		}
// 	},
// 	render: function() {
// 		var rowIndex;
// 		return (
// 			<div className="container">
// 				<div className={'board '+this.state.activePlayer}>
// 					{
// 						this.state.board.map(function(row, index) {
// 							return (<Row rowArr={row} handlePieceClick={this.handlePieceClick.bind(this)} rowIndex={index}/>)
// 						},this)
// 					}
// 				</div>
// 				<div className="clear"></div>
// 				<button onClick={this.reset}>Reset</button>
// 				<button onClick={this.aboutPopOpen}>About</button>
// 				<Statistics board={this.state.board}/>
// 				<Popup shown={this.state.popShown} close={this.aboutPopClose} copy="
// 					Hey! Thanks for checking out my checkers game. I know that the title says 'React Checkers', but there isn't a ton of React in use here, it's only handling the display (that's its job, huh?). Essentially React displays our board array, and most of the moving and detection are just accessing that array. The AI is built out using a limited version of the minimax algorithm (see http://neverstopbuilding.com/minimax for a nice explanation of what that means), simply it means that the program forecasts futures, assumes you'll play as if you were doing the same, and picks the route that it thinks will result in the best for itself if you also play 'perfeclty', and I use that word loosely because this AI currently only looks 3 turns in to the future. It uses a point system to determine 'good' and 'bad' stuff that could happen, for example, if it can win in the next 3 turns, thats a 100 point outcome. If it will lose in the next 3 turns, thats worth -100 points, losing a king or killing an enemy king are worth -25 or 25 points respectively, and killing/losing regular pieces are worth +-10 points. Lastly, classifies making a new king of it's own as worth 15 points, so slightly better than killing 1 opponent. The bot looks through something like 1000-1500 possible futures before each move.
// 				"/>
// 			</div>
// 		);
// 	},
// })


//game board calls row for each item in the board array
export const NewHome = () => {
    useEffect(() => {
        return {
            board: [
                ['b','-','b','-','b','-','b','-'],
                ['-','b','-','b','-','b','-','b'],
                ['b','-','b','-','b','-','b','-'],
                ['-','-','-','-','-','-','-','-'],
                ['-','-','-','-','-','-','-','-'],
                ['-','r','-','r','-','r','-','r'],
                ['r','-','r','-','r','-','r','-'],
                ['-','r','-','r','-','r','-','r']
            ],
            activePlayer: 'r',
            aiDepthCutoff: 3,
            count: 0,
            popShown: false
        }
        
    })

    function aboutPopOpen(e) {
    //aboutPopOpen: function(e) {
		this.setState({popShown: true});
    };
    function aboutPopClose(e){
	//aboutPopClose: function(e) {
		this.setState({popShown: false});
	};
    function executeMove(rowIndex, cellIndex, board, activePlayer){
        //executeMove: function(rowIndex, cellIndex, board, activePlayer) {
        var activePiece;
        for (var i = 0; i < board.length; i++) {
            //for each row
            for (var j = 0; j < board[i].length; j++) {
                if (board[i][j].indexOf('a')>-1) {
                    activePiece = board[i][j];
                }
            }
        }
        //make any jump deletions
        var deletions = board[rowIndex][cellIndex].match(/d\d\d/g);
        if (typeof deletions !== undefined && deletions !== null && deletions.length > 0) {
            for (var k = 0; k < deletions.length; k++) {
                var deleteCoords = deletions[k].replace('d', '').split('');
                board[deleteCoords[0]][deleteCoords[1]] = '-';
            }
        }
        //remove active piece from it's place
        board = board.map(function(row){return row.map(function(cell){return cell.replace(activePiece, '-')});});
        //unhighlight
        board = board.map(function(row){return row.map(function(cell){return cell.replace('h', '-').replace(/d\d\d/g, '').trim()});}); 
        //place active piece, now unactive, in it's new place
        board[rowIndex][cellIndex] = activePiece.replace('a', '');
        if ( (activePlayer === 'b' && rowIndex === 7) || (activePlayer === 'r' && rowIndex === 0) ) {
            board[rowIndex][cellIndex]+= ' k';
        }		
        return board;
    };
    function handlePieceClick(e){
	//handlePieceClick: function(e) {
		var rowIndex = parseInt(e.target.attributes['data-row'].nodeValue);
		var cellIndex = parseInt(e.target.attributes['data-cell'].nodeValue);
		if (this.state.board[rowIndex][cellIndex].indexOf(this.state.activePlayer) > -1) {
			//this is triggered if the piece that was clicked on is one of the player's own pieces, it activates it and highlights possible moves
			this.state.board = this.state.board.map(function(row){return row.map(function(cell){return cell.replace('a', '')});}); //un-activate any previously activated pieces
			this.state.board[rowIndex][cellIndex] = 'a'+this.state.board[rowIndex][cellIndex];
			this.highlightPossibleMoves(rowIndex, cellIndex);
		}
		else if(this.state.board[rowIndex][cellIndex].indexOf('h') > -1) {
			//this is activated if the piece clicked is a highlighted square, it moves the active piece to that spot.
			this.state.board = executeMove(rowIndex, cellIndex, this.state.board, this.state.activePlayer);
			//is the game over? if not, swap active player
			this.setState(this.state);
			if (this.winDetection(this.state.board, this.state.activePlayer)) {
				console.log(this.state.activePlayer+ ' won the game!');
			}
			else {
				this.state.activePlayer = (this.state.activePlayer === 'r' ? 'b' : 'r');
				if (this.state.activePlayer === 'b') {
					setTimeout(function() {this.ai();}.bind(this), 50);
				}
			}
		}
		this.setState(this.state);
	};
    

    return (
        <div className="container">
            <div className={'board '+this.state.activePlayer}>
                {
                    this.state.board.map(function(row, index) {
                        return (<Row rowArr={row} handlePieceClick={handlePieceClick.bind(this)} rowIndex={index}/>)
                    },this)
                }
            </div>
            <div className="clear"></div>
            <button onClick={aboutPopOpen}>About</button>
            <Statistics board={this.state.board}/>
            <Popup shown={this.state.popShown} close={aboutPopClose} copy="
                Hey! Thanks for checking out my checkers game. I know that the title says 'React Checkers', but there isn't a ton of React in use here, it's only handling the display (that's its job, huh?). Essentially React displays our board array, and most of the moving and detection are just accessing that array. The AI is built out using a limited version of the minimax algorithm (see http://neverstopbuilding.com/minimax for a nice explanation of what that means), simply it means that the program forecasts futures, assumes you'll play as if you were doing the same, and picks the route that it thinks will result in the best for itself if you also play 'perfeclty', and I use that word loosely because this AI currently only looks 3 turns in to the future. It uses a point system to determine 'good' and 'bad' stuff that could happen, for example, if it can win in the next 3 turns, thats a 100 point outcome. If it will lose in the next 3 turns, thats worth -100 points, losing a king or killing an enemy king are worth -25 or 25 points respectively, and killing/losing regular pieces are worth +-10 points. Lastly, classifies making a new king of it's own as worth 15 points, so slightly better than killing 1 opponent. The bot looks through something like 1000-1500 possible futures before each move.
            "/>
        </div>
    );
  };
  