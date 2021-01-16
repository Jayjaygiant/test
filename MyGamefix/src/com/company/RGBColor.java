package com.company;
// Color class for simplifying setting colors
public class RGBColor {
    private short r;
    private short g;
    private short b;

    public RGBColor(short r,short g,short b)
    {
        this.r=r;
        this.g=g;
        this.b=b;
    }
    public void setR(short r) {
        this.r = r;
    }
    public void setG(short g) {
        this.g = g;
    }
    public void setB(short b) {
        this.b = b;
    }

    public short getR() {
        return r;
    }

    public short getB() {
        return b;
    }

    public short getG() {
        return g;
    }

    public String toString()
    {
        return "(R:"+r+",G:"+g+",B:"+b+")";
    }

}
