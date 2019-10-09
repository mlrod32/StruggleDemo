package src;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.naming.InitialContext;
import javax.swing.JFrame;

public class Demo extends Canvas implements Runnable, KeyListener, MouseListener, MouseMotionListener {
	
	//movement controll booleans
	boolean left_Pressed = false;
	boolean right_Pressed = false;
	boolean up_Pressed = false;
	boolean down_Pressed = false;
	
	Image off_Screen;
	Thread mainThread;
	Graphics off_Graphics;
	
	Player player;
	
	public static void main(String[] args) {

        Demo game = new Demo();
        JFrame frame = new JFrame("Demo");
        frame.setUndecorated(false);
        frame.requestFocus();
        frame.setSize(1000, 500);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setResizable(false);
        frame.setVisible(true);
        game.init();

    }
	
	
	void init() {
		
		off_Screen = this.createImage(1000,500);
		off_Graphics = off_Screen.getGraphics();
		
		this.setSize(1000,500);
		
		player = new Player(5, 1, 400, 290, 5, 5);
		
		requestFocus();
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		
		mainThread = new Thread(this);
		mainThread.start();
	}
	
	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		while(true) 
		{
			
			if(left_Pressed == true) 
			{
				player.moveBy(-1, 0);
			}
			
			if(right_Pressed == true) 
			{
				player.moveBy(1, 0);			
			}

			if(up_Pressed == true) 
			{
				player.moveBy(0, -1);
			}

			if(down_Pressed == true) 
			{
				player.moveBy(0, 1);
			}
			
			repaint();
			
			try 
			{
				mainThread.sleep(15);
				
			}catch (Exception e) 
			{
				// TODO: handle exception
			}
				
		}
	}
	
	public void update(Graphics g) 
	{
		off_Graphics.clearRect(0, 0, 1000, 500);
		paint(off_Graphics);
		g.drawImage(off_Screen, 0, 0, null);
		
	}
	
	@Override
	public void paint(Graphics g) 
	{
		player.draw(g);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		int code = e.getKeyCode();
		
		if(code == e.VK_RIGHT) right_Pressed = true;
		if(code == e.VK_LEFT)  left_Pressed = true;
		if(code == e.VK_UP)    up_Pressed = true;
		if(code == e.VK_DOWN)  down_Pressed = true;
	
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		int code = e.getKeyCode();
		
		if (code == e.VK_LEFT)  left_Pressed = false;
		if (code == e.VK_RIGHT) right_Pressed = false;
		if (code == e.VK_UP)    up_Pressed = false;
		if (code == e.VK_DOWN)  down_Pressed = false;
		
	}

	

}
