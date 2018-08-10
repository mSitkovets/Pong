package Module4;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

/*
 * Name: Maria Sitkovets and Saadia Mendil
 * Date: 4/5/2018
 * Teacher: Mr. Naccarato 
 * Course: ICS 4U
 * Summary: The parent class of all moving objects
*/

public abstract class GameObject 
{
	//create a set to store the integer values of the keys pressed
	protected Set<Integer> pressed;
	protected Sprite sprite;
	double x, y;
	public void keyPressed(int arg0)
	{
		pressed.add(arg0);
	}

	public void keyReleased(int arg0) 
	{
		pressed.remove(arg0);
	}
	
	public void create()
	{
		this.pressed = new HashSet<Integer>();
	}
	
	public abstract void update();
	
	public void drawSprite(Graphics g)
	{
		sprite.drawSprite(g);
	}
	
}
