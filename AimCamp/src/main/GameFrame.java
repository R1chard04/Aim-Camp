package main;

import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame implements Runnable{

	private static final long serialVersionUID = 1L;
	
	ImageIcon imageIcon;
	GamePanel panel;
	Thread thread = new Thread(this);
	public String name;
	
	GameFrame(String name){
		
		this.name = name;
		
		panel = new GamePanel();
		this.add(panel);
		this.setTitle("Aim Camp");
		this.setSize(1500, 1000);
		this.setResizable(false);
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		//icon for jframe
		imageIcon = new ImageIcon("imageicon.png");
		this.setIconImage(imageIcon.getImage());
		
		thread.start();
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
				System.out.println(); //adding of print statement allows setting of GamePanel's thread to be visible by this thread
				if(!panel.running) {
					new EndFrame(name, panel.totalTime, panel.finalScore);
					this.dispose();
					return;
				}
				delta--;
			}
		}
		
		
	}

}
