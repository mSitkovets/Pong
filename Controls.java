package Module4;

import java.awt.event.KeyEvent;

/*
 * Name: Maria Sitkovets and Saadia 
 * Date: 4/5/2018
 * Teacher: Mr. Naccarato 
 * Course: ICS 4U
 * Summary: The enum that holds Keycodes for the controls for player paddles.
 */

public enum Controls 
{
	WS(KeyEvent.VK_W, KeyEvent.VK_S),
	Arrows(KeyEvent.VK_UP, KeyEvent.VK_DOWN);

	public int up,down;
	
	//Constructor for the enum. It sets the W and UP key to the up variable and the S and DOWN keys to the down variable
	Controls(int up, int down)
	{
		this.up=up;
		this.down=down;
	}
}
