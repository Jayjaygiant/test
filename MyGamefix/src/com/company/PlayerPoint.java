package com.company;
// setting x and y Position for every Playerpoint
public class PlayerPoint extends Point{
    private RGBColor colGreen = new RGBColor((short) 0,(short) 255,(short) 255);
    private int playerX;
    private int playerY;

    public PlayerPoint(RGBColor colGreen) {
        super(5, 5, colGreen);
        this.playerX= 5;
        this.playerY= 5;
    }


    public int getPlayerX() {return playerX;}
    public int getPlayerY() {return playerY;}




    }
