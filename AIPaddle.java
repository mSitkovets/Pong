package Module4;

/*
 * Name: Maria Sitkovets and Saadia Mendil
 * Date: 4/5/2018
 * Teacher: Mr. Naccarato 
 * Course: ICS 4U
 * Summary: The class for the AI controlled paddle. 
*/
public class AIPaddle extends GameObject
{
	AIPaddle(Sprite spr, int x, int y)
	{
		this.sprite = spr;
		this.x = x;
		this.y = y;
		super.create();
	}
	@Override
	public void update() 
	{
		
		if((this.y - Draw.rally) >= Draw.ball.y)
		{
			this.y -= 5;
		}
		if((this.y + 100 + Draw.rally) <= Draw.ball.y)
		{
			this.y += 5;
		}
		//Bounds checking so paddles do not fall off the screen
		this.y = Math.max(Math.min(350, this.y), 0);
		this.sprite.update((int)x,(int)y);
		
	}

}
