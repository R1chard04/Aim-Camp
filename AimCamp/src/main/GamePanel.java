package main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.*;

public class GamePanel extends JPanel implements Runnable{

	static final int GAME_WIDTH = 1500;
	static final int GAME_HEIGHT = 1000;
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
	
	Thread gameThread;
	Image image;
	Graphics graphics;
	Random random;
	Player player;
	Target target;
	
	GamePanel(){
		newPlayer();
		newTarget();
		
		this.setFocusable(true);
		this.addMouseListener(new AL());
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	void newPlayer() {
		player = new Player(GAME_WIDTH/2, 900, 30, 30);
	}
	
	void newTarget() {
		random = new Random();
		target = new Target(random.nextDouble(1500), random.nextDouble(800), 20, 20);
	}
	public void paint(Graphics g) {
		image = createImage(getWidth(),getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image, 0, 0, this);
	}
	
	public void draw(Graphics g) {
		target.draw(g);
		player.draw(g);
	}
	
	int counter = 0;
	
	void regenerateTarget() {
		if (target.hasClicked && counter <= 10) {
			newTarget();
			counter++;
		}
		else {
			
		}
		
	
	}
	
	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks =60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		while(true) {
			long now = System.nanoTime();
			delta += (now -lastTime)/ns;
			lastTime = now;
			if(delta >=1) {
				
				regenerateTarget();
				repaint();
				delta--;
				
			}
		}
	}
	
	public class AL extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			target.mouseClicked(e);
		}
		
		public void mouseReleased(MouseEvent e) {
			target.mouseReleased(e);
		}
	}
		
}


