package com.company;

import com.company.runtime.InternalLedGameThread;

public class GameMain {


    static public void main(String[] passedArgs) throws InterruptedException {

        Screen s = new Screen(new short[24 * 48 * 3]);
        GameControlling controller = new GameControlling();
        int thisKey;



            // This is initialization, do not change this
            InternalLedGameThread.run();
        while (true) {
            // Now we show some introductory message and wait 3s before we switch to purple
            Thread.sleep(300);
            controller.screenBackground(); // Initialize Background
            System.out.println("Sending to displayThread");
            InternalLedGameThread.showImage(s.getImage());
            controller.setScore(0); //Set Score 0 at new Beginning of the Game
            System.out.println("Your current Highscore =" +" " + controller.getHighscore());
            Thread.sleep(500);


            // Now we loop with keyboard input to show the movement of the green dot
            while (true) {
                thisKey = InternalLedGameThread.getKeyboard();
                if (thisKey != -1) {

                    switch (thisKey) {
                        case 0:
                            controller.keyPressed(GameControlling.KEYPRESSEDDOWN);
                            break;
                        case 1:
                            controller.keyPressed(GameControlling.KEYPRESSEDUP);
                            break;
                        case 2:
                            controller.keyPressed(GameControlling.KEYPRESSEDLEFT);
                            break;
                        case 3:
                            controller.keyPressed(GameControlling.KEYPRESSEDRIGHT);
                            break;
                    }

                    InternalLedGameThread.showImage(controller.getImage());


                }


                controller.tick(); //Initialize Tick Loops if no Key Pressed
                // if Collision true break while loop
                if (controller.Collisiondetector() == GameControlling.COLLISION_DETECTED) {
                    break;
                }

                InternalLedGameThread.showImage(controller.getImage());

                Thread.sleep(10);
                controller.Score(); // Initialize Score



            }
            System.out.println("Your new Highscore =" +" " + controller.getHighscore());
        }
    }

}
