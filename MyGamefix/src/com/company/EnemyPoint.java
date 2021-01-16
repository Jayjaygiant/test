package com.company;
// setting x and y Position for every enemyPoint
public class EnemyPoint extends Point {
    private int enemyX;
    private int enemyY;
    RGBColor colRed = new RGBColor((short) 255,(short) 0,(short) 0);

    public EnemyPoint( RGBColor colRed) {
        super(44, (int) (Math.random() * Point.maxSizeY), colRed);
        this.enemyX= 44;
        this.enemyY= (int) (Math.random() * Point.maxSizeY);
    }

}
