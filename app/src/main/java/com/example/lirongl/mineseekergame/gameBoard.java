package com.example.lirongl.mineseekergame;

public class gameBoard {
    private square[][] board;
    private int rows;
    private int cols;

    public gameBoard() {
    }
    public gameBoard(int rows, int cols) {
        this.board = new square[rows][cols];
        this.rows = rows;
        this.cols = cols;
    }

    public square[][] getBoard() {
        return board;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public square getItem(int x_coord, int y_coord){
        return this.board[x_coord][y_coord];
    }
    public void setBoard(int x_coord, int y_coord, square item) {
        this.board[x_coord][y_coord] = item;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }
}
