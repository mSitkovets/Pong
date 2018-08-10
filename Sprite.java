package Module4;

import java.awt.Color;
import java.awt.Graphics;

/*
 * Name: Maria Sitkovets and Saadia Mendil
 * Date: 4/5/2018
 * Teacher: Mr. Naccarato 
 * Course: ICS 4U
 * Summary: The sprite class of the game Pong that sets up the sprites onto the frame.
*/
public class Sprite 
{
	private int height;
	private int width;
	private int y;
	private int x;
	private Color color;

	public Sprite(Color color, int x, int y, int width, int height)
	{
		this.color = color;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	//updating without changing x and y coordinates
	public void update() 
	{
		this.update(this.x, this.y); 
	}

	public void drawSprite(Graphics g) 
	{
		g.setColor(this.color);
		g.fillRect(this.x, this.y, this.width, this.height);
		
	}
	
	//updating with changing x and y coordinates
	public void update(int x2, int y2) 
	{
		this.x = x2;
		this.y = y2;
	}

}
