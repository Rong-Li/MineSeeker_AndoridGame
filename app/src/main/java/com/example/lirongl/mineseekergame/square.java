package com.example.lirongl.mineseekergame;



public class square {
    private int x_coordinate;
    private int y_coordinate;
    private int index;
    private boolean existence;
    private boolean checked;
    //private int scan;


    //constructors
    public square()
    {
        this.y_coordinate = 123;
        this.x_coordinate = 123;
        this.index = 0;
        this.existence = true;
        this.checked = false;
    }
    public square(int x_coordinate, int y_coordinate) {
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
    }

    //getters
    public int getX_coordinate() {
        return x_coordinate;
    }

    public int getY_coordinate() {
        return y_coordinate;
    }

    public int getIndex() {return index;}

    public boolean isExistence() {
        return existence;
    }

    public boolean isChecked() {
        return checked;
    }
    //public int getScan() {return scan;}


    //setters

    public void setX_coordinate(int x_coordinate) {
        this.x_coordinate = x_coordinate;
    }

    public void setY_coordinate(int y_coordinate) {
        this.y_coordinate = y_coordinate;
    }

    public void setIndex(int index) {this.index = index;}

    public void setExistence(boolean existence) {
        this.existence = existence;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    //public void setScan(int scan) {this.scan = scan;}

}
