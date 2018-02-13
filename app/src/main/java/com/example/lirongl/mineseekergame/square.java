package com.example.lirongl.mineseekergame;



public class square {
    private int x_coordinate;
    private int y_coordinate;
    private boolean existence;

    //constructors
    public square() {
    }
    public square(int x_coordinate, int y_coordinate, boolean existence) {
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
        this.existence = existence;
    }

    //getters
    public int getX_coordinate() {
        return x_coordinate;
    }

    public int getY_coordinate() {
        return y_coordinate;
    }

    public boolean isExistence() {
        return existence;
    }

    //setters

    public void setX_coordinate(int x_coordinate) {
        this.x_coordinate = x_coordinate;
    }

    public void setY_coordinate(int y_coordinate) {
        this.y_coordinate = y_coordinate;
    }

    public void setExistence(boolean existence) {
        this.existence = existence;
    }
}
