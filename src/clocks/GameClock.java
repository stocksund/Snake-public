package clocks;

import actions.Collision;
import game.Snake;

public class GameClock extends Thread
{

    public static boolean running = true;

    @Override
    public void run()
    {
        while (running)
        {
            try
            {
                sleep(200);
                Snake.move();
                Snake.waitToMove = false;
                Collision.collidePickUp();
                if (Collision.collideSelf())
                {
                    Snake.tails.clear();
                    Snake.score = 0;
                }
                if (Collision.collideWall())
                {
                    Snake.head.setX(7);
                    Snake.head.setY(7);
                    Snake.tails.clear();

                    Snake.score = 0;

                }
            }
            catch (final InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
