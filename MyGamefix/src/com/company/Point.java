package com.company;

public class Point {

    private int x;
    private int y;
    public static int maxSizeX = 45;
    public static int maxSizeY = 21;
    public static int minSizeX = 3;
    public static int minSizeY = 3;
    public final static int NORTH= 0;
    public final static int OST= 1;
    public final static int SOUTH= 2;
    public final static int WEST= 3;
    private RGBColor colorRgb;

    public Point(int actx, int acty){
        x=actx % maxSizeX;
        y=acty % maxSizeY;
        colorRgb=new RGBColor((short)0,(short)0,(short)0);
    }

    public Point(int actx, int acty, RGBColor pColor){
        x=actx % maxSizeX ;
        y=acty % maxSizeY ;
        colorRgb=pColor;
    }

    public RGBColor getColorRgb(){
        return colorRgb;
    }

    public void setColorRgb(RGBColor pColor){
        colorRgb = pColor;
    }
    //move Point by one by adding another Point with add method
    public void movebyOne(int direction) {
        switch (direction) {
            case Point.NORTH:
                Point p1 = new Point(0, 1);
                add(p1);
                break;
            case Point.OST:
                Point p2 = new Point(1, 0);
                add(p2);
                break;
            case Point.SOUTH:
                Point p3 = new Point(0, -1);
                add(p3);
                break;
            case Point.WEST:
                Point p4 = new Point(-1, 0);
                add(p4);
                break;
        }
    }




    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    //Method to add two Points and setting boundary's
    public void add(Point p2){
        x = x + p2.getX();
        y = y + p2.getY();
        x = x % maxSizeX;
        if (x <3) x = maxSizeX ;
        y = y % maxSizeY;
        if (y <3) y = maxSizeY ;
        if (x >44) x = minSizeX;
        if (y >20) y = minSizeY;
    }

    public String toString()
    {
        return "(X:" + getX() + ",Y:" + getY() + "), Color:"+getColorRgb();
    }
}

