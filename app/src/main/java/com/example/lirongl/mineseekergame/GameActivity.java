package com.example.lirongl.mineseekergame;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.Arrays;
import java.util.Collections;

public class GameActivity extends AppCompatActivity {

    private static final int NUM_ROWS = 5;
    private static final int NUM_COLS = 6;
    private static final int Size = NUM_ROWS * NUM_COLS;
    private static final int Num_MINES = 10;
    private int revealed = 0;
    Button buttons[][] = new Button[NUM_ROWS][NUM_COLS];

    square board[][] = new square[NUM_ROWS][NUM_COLS];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        generateNewBoard();
        //printBoard();
        populateButtons();
    }//end of onCreate

    public void printBoard() {
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                square a = board[i][j];
                String theMessage = " " + a.getIndex();
                Log.i("MyApp", theMessage);
            }//end of for loop
        }//end of for loop
    }

    private void generateNewBoard() {
        int temp = 0;
        //FIRST ROUND: Set the frame and set the index to each square.
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                board[i][j] = new square(i, j);
                board[i][j].setIndex(temp);
                temp++;
            }//end of for loop
        }//end of for loop

        //SECOND ROUND: Set the square.existence randomly.
        Integer[] shuffle_List = new Integer[Size];//make a array of integers of length of total index
        for (int i = 0; i < shuffle_List.length; i++) {shuffle_List[i] = i;}
        Collections.shuffle(Arrays.asList(shuffle_List));//Using shuffle to prevent repeated generated random number

        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                for (int k = 0; k < Num_MINES; k++){
                    if (board[i][j].getIndex() == shuffle_List[k])
                        board[i][j].setExistence(true);//set Existence to true if this square meets the random number
                }//end of for loop
            }//end of for loop
        }//end of for loop
    }//End of generateNewBoard()



    private void populateButtons() {
        //initiating the new table
        TableLayout table = (TableLayout) findViewById(R.id.tableID);
        for (int i = 0; i < NUM_ROWS; i++){
            final int TEMP_ROW = i;
            //make rows
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT, 1.0f));
            table.addView(tableRow);
            //fill up the rows with buttons
            for (int j = 0; j < NUM_COLS; j++) {
                final int TEMP_COL = j;
                Button button = new Button(this);
                button.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT, 1.0f));
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (board[TEMP_ROW][TEMP_COL].isExistence()) {
                            gridButtonClicked(TEMP_ROW, TEMP_COL);
                            revealed++;
                            board[TEMP_ROW][TEMP_COL].setExistence(false);
                            for (int i = 0; i < NUM_COLS; i++){
                                if (board[TEMP_ROW][i].isChecked())
                                    gridButtonClickedMineFree(TEMP_ROW, i);
                            }
                            for (int j = 0; j < NUM_ROWS; j++){
                                if (board[j][TEMP_COL].isChecked())
                                    gridButtonClickedMineFree(j, TEMP_COL);
                            }
                        }
                        else{
                            gridButtonClickedMineFree(TEMP_ROW, TEMP_COL);
                            board[TEMP_ROW][TEMP_COL].setChecked(true);
                        }
                    }//end of onClick
                });//end of setOnClickListener
                tableRow.addView(button);
                buttons[TEMP_ROW][TEMP_COL] = button;
            }//end of for loop
        }//end of for loop
    }//end of the populateButtons function

    private void gridButtonClicked(int temp_row, int temp_col) {
        Button button = buttons[temp_row][temp_col];
        //lock size
        lockButtonSizes();
        //set background image
        //button.setBackgroundResource(R.drawable.mine_2);
        int newWidth = button.getWidth();
        int newHeight = button.getHeight();
        Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.mine_2);
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(originalBitmap, newWidth, newHeight, true);
        Resources resource = getResources();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            button.setBackground(new BitmapDrawable(resource, scaledBitmap));
        }
    }

    private void gridButtonClickedMineFree(int temp_row, int temp_col) {
        Button button = buttons[temp_row][temp_col];
        int scan_check = scanCheck(temp_row, temp_col);
        button.setText("" + scan_check);
    }

    private int scanCheck(int temp_row, int temp_col) {
        int scan_check = 0;
        for (int i = 0; i < NUM_COLS; i++){       //check horizontally
            if (board[temp_row][i].isExistence())
                scan_check++;
        }
        for (int j = 0; j < NUM_ROWS; j++){       //check vertically
            if (board[j][temp_col].isExistence())
                scan_check++;
        }
        return scan_check;
    }

    private void lockButtonSizes() {
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                Button button = buttons[row][col];

                int width = button.getWidth();
                button.setMinWidth(width);
                button.setMaxWidth(width);

                int height = button.getHeight();
                button.setMinHeight(height);
                button.setMaxHeight(height);
            }
        }
    }

    public static Intent newIntent(Context context){
        return new Intent(context, GameActivity.class);
    }

}//end of GameActivity Class
