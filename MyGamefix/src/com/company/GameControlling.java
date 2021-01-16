package com.company;

public class GameControlling {
    public static final int KEYPRESSEDUP = 1;
    public static final int KEYPRESSEDDOWN = 0;
    public static final int KEYPRESSEDRIGHT = 2;
    public static final int KEYPRESSEDLEFT = 3;
    private PlayerPoint playerPoint;
    private Screen s;
    private EnemyPoint enemyPoint;
    private Point enemyOldPoint;
    private Point p1;
    private Point p2;
    private EnemyPoint enemyPoint2;
    private Point enemyOldPoint2;
    private EnemyPoint enemyPoint3;
    private EnemyPoint enemyPoint4;
    private Point enemyOldPoint4;
    private Point enemyOldPoint3;
    private RGBColor colRed;
    private RGBColor col;
    private int score = 0;
    private int highscore = 0;
    protected static int NO_COLLISION_DETECTED = 0;
    protected static int COLLISION_DETECTED = -1;



    public GameControlling(){
        RGBColor colGreen = new RGBColor((short) 0, (short) 255, (short) 0);
        playerPoint = new PlayerPoint(colGreen);
        s = new Screen(new short[24 * 48 * 3]);
        colRed = new RGBColor((short) 255, (short) 0, (short) 0);
        enemyPoint = new EnemyPoint(colRed);
        col = new RGBColor((short) 0, (short) 128, (short) 255);
        enemyPoint2 = new EnemyPoint(colRed);
        enemyPoint3 = new EnemyPoint(colRed);
        enemyPoint4 = new EnemyPoint(colRed);


    }
    //Method for setting background
    public void screenBackground() {
        System.out.println("Please wait for three seconds until the LED shows purple color, then you can use the cursor keys in order to move a green dot over the LED display");

        for (int i = 3; i < Screen.maxSizeX ; i += 1) {
            for (int j = 3; j < Screen.maxSizeY ; j += 1) {
                RGBColor col = new RGBColor((short) 0, (short) 128, (short) 255);
                p1 = new Point(i, j, col);
                s.showPoint(p1);

                s.showPoint(playerPoint);
            }
        }
         }


    public short[] getImage(){

                return s.getImage();
            }
            // if Key pressed Move Playerpoint by one
            public void keyPressed(int keypressed){

        RGBColor col = new RGBColor((short) 0, (short) 128, (short) 255);
        Point oldPoint = new Point(playerPoint.getX(), playerPoint.getY(), col);

        switch (keypressed) {

                case GameControlling.KEYPRESSEDDOWN:
                playerPoint.movebyOne(Point.SOUTH);
                break;

                case GameControlling.KEYPRESSEDUP:
                playerPoint.movebyOne(Point.NORTH);
                break;

                case GameControlling.KEYPRESSEDLEFT:
                playerPoint.movebyOne(Point.WEST);
                break;

                case GameControlling.KEYPRESSEDRIGHT:
                playerPoint.movebyOne(Point.OST);
                break;

        }
        s.showPoint(oldPoint);
        s.showPoint(playerPoint);
    }
    // if no key pressed Initialize Enemy's and move left
    public void tick() {
        enemyOldPoint = new Point(enemyPoint.getX(), enemyPoint.getY(), col);
        s.showPoint(enemyOldPoint);
        enemyOldPoint2 = new Point(enemyPoint2.getX(), enemyPoint2.getY(), col);
        s.showPoint(enemyOldPoint2);
        enemyOldPoint3 =  new Point(enemyPoint3.getX(),enemyPoint3.getY(),col);
        s.showPoint(enemyOldPoint3);
        enemyOldPoint4 =  new Point(enemyPoint4.getX(),enemyPoint4.getY(),col);
        s.showPoint(enemyOldPoint4);

        if (enemyPoint.getX() >= 4 && enemyPoint2.getX() >= 4 && enemyPoint3.getX() >=4 && enemyPoint4.getX() >=4) {
            enemyPoint.movebyOne(Point.WEST);
            enemyPoint2.movebyOne(Point.WEST);
            enemyPoint3.movebyOne(Point.WEST);
            enemyPoint4.movebyOne(Point.WEST);
            s.showPoint(enemyPoint);
            s.showPoint(enemyOldPoint);
            s.showPoint(enemyPoint2);
            s.showPoint(enemyOldPoint2);
            s.showPoint(enemyPoint3);
            s.showPoint(enemyOldPoint3);
            s.showPoint(enemyPoint4);
            s.showPoint(enemyOldPoint4);
        } else {
            enemyPoint = new EnemyPoint(colRed);
            enemyPoint2 = new EnemyPoint(colRed);
            enemyPoint3 = new EnemyPoint(colRed);
            enemyPoint4 = new EnemyPoint(colRed);
        }
    }
    // if PlayerPoint has same Position as Enemy Point return Collision true
    public int Collisiondetector(){
        if ((playerPoint.getX() == enemyPoint.getX() && playerPoint.getY() == enemyPoint.getY()) || (playerPoint.getX() == enemyPoint2.getX() && playerPoint.getY() == enemyPoint2.getY()) ||(playerPoint.getX() == enemyPoint3.getX() && playerPoint.getY() == enemyPoint3.getY()) || playerPoint.getX() == enemyPoint4.getX() && playerPoint.getY() == enemyPoint4.getY()){
        System.out.println("Game Over");
            return COLLISION_DETECTED;
        } else {
            return NO_COLLISION_DETECTED;
        }
    }
    // if Enemy Point at left Bound Score +1 and if Highscore higher than score at the end replace Highscore with Score
    public void Score(){
        if (enemyPoint.getX() == 4 || enemyPoint2.getX() == 4 || enemyPoint3.getX() == 4){
            score ++;
            System.out.println("Your current score =" + " " + score);
        }

        if (score>highscore){
            highscore = score;
        }
    }
    public int getScore(){
        return score;
    }
    public void setScore(int x){score =x;}

    public int getHighscore(){
        return highscore;
    }


}



