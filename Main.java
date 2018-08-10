package Module4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;

/*
 * Name: Maria Sitkovets and Saadia 
 * Date: 4/6/2018
 * Teacher: Mr. Naccarato 
 * Course: ICS 4U
 * Summary: The main class of the game Pong that sets up the frame.
*/
public class Main extends JFrame
{
	Draw draw;
	static Sequencer sequencer; // Midi Sequencer (plays music)
	static JLabel label = new JLabel("", SwingConstants.CENTER);
	
	Main()
	{
		super("Pong");

		this.setSize(865, 510);

		this.setJMenuBar(this.createMenu());
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Sequence sequence = null;
		
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		
		this.setResizable(false);
		label.setSize(new Dimension(100, 30));
		this.add(label, BorderLayout.SOUTH);
		this.draw = new Draw();
		this.add(draw);

		try
		{
			sequence = MidiSystem.getSequence(Main.class.getResource("GollumsSong.mid"));
		} catch (InvalidMidiDataException | IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    sequencer = null;
		try
		{
			sequencer = MidiSystem.getSequencer();
		}
		catch (MidiUnavailableException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try
	    {
			sequencer.open();
		}
	    catch (MidiUnavailableException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try
	    {
			sequencer.setSequence(sequence);
		} catch (InvalidMidiDataException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		
		Main main = new Main();

		//updates the draw class every thirty milliseconds
		while(true)
		{
			main.draw.update();
			try
			{
				Thread.sleep(30);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}

	}
	public JMenuBar createMenu()
	{
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("2P Game");
		menuItem.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				//get the JMenuItem associated with this ActionListener
				JMenuItem source = (JMenuItem) e.getSource();
				//Get the parent of this JMenuItem, a JPopupMenu
				Container parent = source.getParent();
				if (parent != null)
				{
					//Get the JComponent that activated the JPopupMenu
					JComponent invoker = (JComponent)((JPopupMenu) parent).getInvoker();
					//Get the Main class, the root of all the components 
					Main top = (Main) invoker.getTopLevelAncestor();
					top.draw.leftPaddle=new PlayerPaddle(Controls.WS,new Sprite(Color.white, 0, 190, 20, 100),0,190);
					top.draw.rightPaddle=new PlayerPaddle(Controls.Arrows,new Sprite(Color.white, 830, 190, 20, 100),830,190);
					top.draw.ball=new Ball();
					top.draw.reset();
				}
				
			}
			
		});
		menu.add(menuItem);
		menuItem = new JMenuItem("1P Game");
		menuItem.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				//get the JMenuItem associated with this ActionListener
				JMenuItem source = (JMenuItem) e.getSource();
				//Get the parent of this JMenuItem, a JPopupMenu
				Container parent = source.getParent();
				if (parent != null)
				{
					//Get the JComponent that activated the JPopupMenu
					JComponent invoker = (JComponent)((JPopupMenu) parent).getInvoker();
					//Get the Main class, the root of all the components 
					Main top = (Main) invoker.getTopLevelAncestor();
					//AI paddle
					top.draw.leftPaddle=new PlayerPaddle(Controls.WS,new Sprite(Color.white, 0, 190, 20, 100),0,190);
					top.draw.rightPaddle=new AIPaddle(new Sprite(Color.white, 830, 190, 20, 100),830,190);
					top.draw.ball=new Ball();
					top.draw.reset();
				}
				
			}
			
		});
		menu.add(menuItem);
		menuItem = new JMenuItem("Toggle Music");
		menuItem.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
			    if (sequencer.isRunning())
			    {
			    	sequencer.stop();
			    }
			    else
			    {
			    	sequencer.start();
			    }
				
			}
			
		});
		menu.add(menuItem);
		menuItem = new JMenuItem("Exit");
		menuItem.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				//get the JMenuItem associated with this ActionListener
				JMenuItem source = (JMenuItem) e.getSource();
				//Get the parent of this JMenuItem, a JPopupMenu
				Container parent = source.getParent();
				if (parent != null)
				{
					//Get the JComponent that activated the JPopupMenu
					JComponent invoker = (JComponent)((JPopupMenu) parent).getInvoker();
					//Get the Main class, the root of all the components
					Main top = (Main) invoker.getTopLevelAncestor();
					//Make it invisible and close the program
				    top.setVisible(false);
				    top.dispose();
				    System.exit(0);
				}
				
			}
			
		});
		menu.add(menuItem);
		return menuBar;
		
	}

}
