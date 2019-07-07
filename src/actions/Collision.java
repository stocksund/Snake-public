package actions;

import game.Snake;

public class Collision
{

    public static boolean collideSelf()
    {
        for (int i = 1; i < Snake.tails.size(); i++)
        {
            if (Snake.head.getX() == Snake.tails.get(i).getX() && Snake.head.getY() == Snake.tails.get(i).getY())
            {
                return true;
            }

        }
        return false;
    }

    public static boolean collideWall()
    {
        return (Snake.head.getX() < 0 || Snake.head.getX() > 15 || Snake.head.getY() < 0 || Snake.head.getY() > 15);
    }

    public static void collidePickUp()
    {
        if (Snake.head.getX() == Snake.pickUp.getX() && Snake.head.getY() == Snake.pickUp.getY())
        {
            Snake.pickUp.reset();
            Snake.addTail();
            Snake.score += 1;
            if (Snake.score > Snake.bestscore)
                Snake.bestscore = Snake.score;
        }
    }
    
    public static void collidePlum()
    {
    	if (Snake.head.getX() == Snake.plum.getX() && Snake.head.getY() == Snake.plum.getY())
    		{
    		Snake.tails.clear();
    		Snake.head.setX(7);
    		Snake.head.setY(7);
    		}
   
         }
    }


