package com.example.lirongl.mineseekergame;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

public class GameActivity extends AppCompatActivity {

    private static final int NUM_ROWS = 5;
    private static final int NUM_COLS = 6;
    Button buttons[][] = new Button[NUM_ROWS][NUM_COLS];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        populateButtons();
    }//end of onCreate



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
                        gridButtonClicked(TEMP_ROW, TEMP_COL);
                    }
                });
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
        button.setBackgroundResource(R.drawable.mine_2);
//        int newWidth = button.getWidth();
//        int newHeight = button.getHeight();
//        Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.mine_2);
//        Bitmap scaledBitmap = Bitmap.createScaledBitmap(originalBitmap, newWidth, newHeight, true);
//        Resources resource = getResources();
//        button.setBackground(new BitmapDrawable(resource, scaledBitmap));
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
