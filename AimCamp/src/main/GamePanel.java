package main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.*;

public class GamePanel extends JPanel implements Runnable{

	private static final long serialVersionUID = 1L;
	
	static final int GAME_WIDTH = 1500;
	static final int GAME_HEIGHT = 1000;
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
	int targetCounter = 0;
	boolean running = true;
	double startTime;
	double endTime;
	double totalTime;
	double finalScore;
	
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
		target = new Target(random.nextDouble(1400), random.nextDouble(900), 20, 20);
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

	
	void regenerateTarget() {
		if (target.hasClicked && targetCounter < 5) {
			newTarget();
			targetCounter++;
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
				if(targetCounter >= 5) {
					endTime = System.nanoTime();
					totalTime = endTime/1_000_000_000 - startTime/1_000_000_000;
					finalScore = 1600 * Math.pow(Math.E, (-totalTime)/21.0) - 600.0;
					delta = -100;
					running = false;
					return;
				}
				else if (targetCounter == 0) {
					startTime = lastTime;
				}
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
	}
		
}


