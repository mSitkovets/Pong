package Module4;

/*
 * Name: Maria Sitkovets and Saadia
 * Date: 4/5/2018
 * Teacher: Mr. Naccarato 
 * Course: ICS 4U
 * Summary: The class for player controlled paddles
*/

public class PlayerPaddle extends GameObject 
{
	//saving the field for the controls
	private Controls controls;

	PlayerPaddle(Controls con, Sprite spr, int x, int y)
	{
		this.controls = con;
		this.sprite = spr;
		this.x = x;
		this.y = y;
		super.create();
	}

	@Override
	public void update()
	{
		if (pressed.contains(controls.up))
		{
			this.y-=20;
		}
		if (pressed.contains(controls.down))
		{
			this.y+=20;
		}
		
		//Bounds checking so paddles do not fall off the screen
		this.y = Math.max(Math.min(350, this.y), 0);
		sprite.update((int)this.x, (int)this.y);
	}
	
}
