package Module4;

import java.awt.Color;

import javax.swing.JOptionPane;
/*
 * Name: Maria Sitkovets and Saadia
 * Date: 4/5/2018
 * Teacher: Mr. Naccarato 
 * Course: ICS 4U
 * Summary: The ball class of the game Pong makes the ball move at a certain speed, handles collisions with the borders and paddles, and increments player points
*/

public class Ball extends GameObject 
{
	double xSpeed, ySpeed;
	
	Ball()
	{
		this.sprite = new Sprite(Color.white, 425, 190, 20, 20);
		this.x = 425;
		this.y = 190;
		this.xSpeed = 5;
		this.ySpeed = 5;
	}
	
	//updates the speed of the ball in both directions
	@Override
	public void update() 
	{
		this.x += xSpeed;
		this.y += ySpeed;
		if(y > 430 || y < 0)
		{
			ySpeed *= -1;
		}
		if(x > 860) 
		{
			xSpeed = 5;
			this.x = 425;
			this.y = 190;
			Draw.leftPoints++;
			//increments the number of times the ball was hit back and forth between paddles
			Draw.rally = 0;
		}
		if (x < -10)
		{
			xSpeed = -5;
			this.x = 425;
			this.y = 190;
			Draw.rightPoints++;
			Draw.rally = 0;
		}
		
		if(Draw.leftPoints == 10)
		{
			JOptionPane.showMessageDialog(null, "Left Paddle won!");
			Draw.leftPoints = 0;
			Draw.rightPoints = 0;
			Draw.rally = 0;
		}
		if(Draw.rightPoints == 10)
		{
			JOptionPane.showMessageDialog(null, "Right Paddle won!");
			Draw.leftPoints = 0;
			Draw.rightPoints = 0;
			Draw.rally = 0;
		}
		
		if(x> 15 && x < 25 && (Draw.leftPaddle.y - 10) <= this.y && (Draw.leftPaddle.y + 110) >= this.y)
		{
			xSpeed *= -1.1;
			Draw.rally++;
		}
		if((x+20) < 850 && (x+20) > 830 && (Draw.rightPaddle.y - 10) <= this.y && (Draw.rightPaddle.y + 110) >= this.y)
		{
			xSpeed *= -1.1;
			Draw.rally++;
		}
		
		//the maximum speed of the ball is 11 / -11 so change the speed if it becomes greater
		if(xSpeed > 11)
		{
			xSpeed = 11;
		}
		else if (xSpeed < -11)
		{
			xSpeed = -11;
		}
		Main.label.setText(String.format("Player 1:  %d    |    Player 2:  %d", Draw.leftPoints, Draw.rightPoints));
		this.sprite.update((int)Math.round(x),(int)Math.round(y));

	}

	
}
