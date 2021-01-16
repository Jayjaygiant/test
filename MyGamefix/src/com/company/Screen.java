package com.company;
// Screen class for simplifying set new image
public class Screen {

    public static final int maxSizeX = 45;
    public static final int maxSizeY = 21;

    private short[] internalImage;

    public Screen()
    {
        internalImage = new short[24*48*3];
    }

    public Screen(short[] myImage)
    {
        internalImage = myImage;
    }

    public short[] getImage() {
        return internalImage;
    }

    public void setImage(short[] internalImage) {
        this.internalImage = internalImage;
    }

    public void showPoint(Point p1){
        internalImage[(p1.getY() * 48 + p1.getX()) * 3 + 0] = p1.getColorRgb().getR();
        internalImage[(p1.getY() * 48 + p1.getX()) * 3 + 1] = p1.getColorRgb().getG();
        internalImage[(p1.getY() * 48 + p1.getX()) * 3 + 2] = p1.getColorRgb().getB();
    }

}
