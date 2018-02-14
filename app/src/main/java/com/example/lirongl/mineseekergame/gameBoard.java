package com.example.lirongl.mineseekergame;

import java.util.Arrays;
import java.util.Collections;

public class gameBoard {
    private square[][] board;
    private int rows;
    private int cols;
    private int Num_mines;

    public gameBoard() {
    }
    public gameBoard(int rows, int cols, int Num_mines) {
        this.board = new square[rows][cols];
        this.rows = rows;
        this.cols = cols;
        this.Num_mines = Num_mines;
        int temp = 0;
        //FIRST ROUND: Set the frame and set the index to each square.
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                this.board[i][j].setX_coordinate(i);
                this.board[i][j].setY_coordinate(j);
                this.board[i][j].setIndex(temp);
                temp++;
            }//end of for loop
        }//end of for loop

        /*
        //SECOND ROUND: Set the square.existence randomly.
        Integer[] shuffle_List = new Integer[this.rows * this.cols];//make a array of integers of length of total index
        for (int i = 0; i < shuffle_List.length; i++) {shuffle_List[i] = i;}
        Collections.shuffle(Arrays.asList(shuffle_List));//Using shuffle to prevent repeated generated random number


        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                for (int k = 0; k < Num_mines; k++){
                    if (this.board[i][j].getIndex() == shuffle_List[k])
                        this.board[i][j].setExistence(true);//set Existence to true if this square meets the random number
                }//end of for loop
            }//end of for loop
        }//end of for loop

        */




    }

//    public square[][] getBoard() {
//        return board;
//    }

    public int getRows() {return rows;}

    public int getCols() {
        return cols;
    }

    public square getItem(int x_coordinate, int y_coordinate){
        return this.board[x_coordinate][y_coordinate];
    }
    public void setBoard(int x_coordinate, int y_coordinate, square item) {
        this.board[x_coordinate][y_coordinate] = item;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }
}
