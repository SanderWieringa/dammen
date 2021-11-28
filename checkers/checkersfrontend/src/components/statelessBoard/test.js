//row is passed a single row from the board, returns a container and a Cell for each item in the array
var Row = React.createClass({
  render: function () {
    return (
      <div className="row">
        {this.props.rowArr.map(function (cell, index) {
          return (
            <Cell
              rowIndex={this.props.rowIndex}
              index={index}
              cell={cell}
              handlePieceClick={this.props.handlePieceClick}
            />
          );
        }, this)}
      </div>
    );
  },
});

//cell is passed a single item in a row, and renders it out, it also calls it's grand-parent's swapper function on click
var Cell = React.createClass({
  render: function () {
    return (
      <div className={"cell cell-" + this.props.cell}>
        <div
          onClick={this.props.handlePieceClick}
          data-row={this.props.rowIndex}
          data-cell={this.props.index}
          className="gamePiece"
        ></div>
      </div>
    );
  },
});

//game board calls row for each item in the board array
var GameBoard = React.createClass({
  handlePieceClick: function (e) {
    var rowIndex = parseInt(e.target.attributes["data-row"].nodeValue);
    var cellIndex = parseInt(e.target.attributes["data-cell"].nodeValue);
    if (
      this.state.board[rowIndex][cellIndex].indexOf(this.state.activePlayer) >
      -1
    ) {
      //this is triggered if the piece that was clicked on is one of the player's own pieces, it activates it and highlights possible moves
      this.state.board = this.state.board.map(function (row) {
        return row.map(function (cell) {
          return cell.replace("a", "");
        });
      }); //un-activate any previously activated pieces
      this.state.board[rowIndex][cellIndex] =
        "a" + this.state.board[rowIndex][cellIndex];
      this.highlightPossibleMoves(rowIndex, cellIndex);
    } else if (this.state.board[rowIndex][cellIndex].indexOf("h") > -1) {
      //this is activated if the piece clicked is a highlighted square, it moves the active piece to that spot.
      this.state.board = this.executeMove(
        rowIndex,
        cellIndex,
        this.state.board,
        this.state.activePlayer
      );
      //is the game over? if not, swap active player
      this.setState(this.state);
      if (this.winDetection(this.state.board, this.state.activePlayer)) {
        console.log(this.state.activePlayer + " won the game!");
      } else {
        this.state.activePlayer = this.state.activePlayer == "r" ? "b" : "r";
        if (this.state.activePlayer == "b") {
          setTimeout(
            function () {
              this.ai();
            }.bind(this),
            50
          );
        }
      }
    }
    this.setState(this.state);
  },
  executeMove: function (rowIndex, cellIndex, board, activePlayer) {
    var activePiece;
    for (var i = 0; i < board.length; i++) {
      //for each row
      for (var j = 0; j < board[i].length; j++) {
        if (board[i][j].indexOf("a") > -1) {
          activePiece = board[i][j];
        }
      }
    }
    //make any jump deletions
    var deletions = board[rowIndex][cellIndex].match(/d\d\d/g);
    if (
      typeof deletions !== undefined &&
      deletions !== null &&
      deletions.length > 0
    ) {
      for (var k = 0; k < deletions.length; k++) {
        var deleteCoords = deletions[k].replace("d", "").split("");
        board[deleteCoords[0]][deleteCoords[1]] = "-";
      }
    }
    //remove active piece from it's place
    board = board.map(function (row) {
      return row.map(function (cell) {
        return cell.replace(activePiece, "-");
      });
    });
    //unhighlight
    board = board.map(function (row) {
      return row.map(function (cell) {
        return cell.replace("h", "-").replace(/d\d\d/g, "").trim();
      });
    });
    //place active piece, now unactive, in it's new place
    board[rowIndex][cellIndex] = activePiece.replace("a", "");
    if (
      (activePlayer == "b" && rowIndex == 7) ||
      (activePlayer == "r" && rowIndex == 0)
    ) {
      board[rowIndex][cellIndex] += " k";
    }
    return board;
  },
});

//render the gameboard on the board element
ReactDOM.render(<GameBoard />, document.getElementById("board"));
