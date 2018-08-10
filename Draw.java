package Module4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

/*
 * Name: Maria Sitkovets and Saadia Mendil
 * Date: 4/5/2018
 * Teacher: Mr. Naccarato 
 * Course: ICS 4U
 * Summary: The draw class of the game pong handles some of the logic and mostly the drawing of the objects.
*/
public class Draw extends JPanel implements KeyListener
{
	Sprite background = new Sprite(Color.black, 0, 0, 850, 480);
	static GameObject leftPaddle = new PlayerPaddle(Controls.WS,new Sprite(Color.white, 0, 190, 20, 100),0,190);
	static GameObject rightPaddle = new AIPaddle(new Sprite(Color.white, 830, 190, 20, 100),830,190);
	static Ball ball = new Ball();
	static int leftPoints, rightPoints, rally = 0;
	
	Draw()
	{
		super();
		this.addKeyListener(this);
		this.setFocusable(true);
	}
	
	public void paint(Graphics g)
	{
		g.clearRect(0, 0, getWidth(), getHeight());
		background.drawSprite(g);
		leftPaddle.drawSprite(g);
		rightPaddle.drawSprite(g);
		ball.drawSprite(g);
	}
	
	@Override
	public void keyPressed(KeyEvent arg0)
	{
		leftPaddle.keyPressed(arg0.getKeyCode());
		rightPaddle.keyPressed(arg0.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent arg0) 
	{
		leftPaddle.keyReleased(arg0.getKeyCode());
		rightPaddle.keyReleased(arg0.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent arg0){}
	
	public void update() 
	{
		//gives ostrich new coordinates
		background.update();
		leftPaddle.update();
		rightPaddle.update();
		ball.update();
		//tells it to draw again
		repaint();
	}

	public void reset() {
		Draw.leftPoints = 0;
		Draw.rightPoints = 0;
		Draw.rally = 0;
		
	}
	
}
