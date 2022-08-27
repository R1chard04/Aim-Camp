package main;

import java.util.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Target extends Rectangle{
	
	public Color color = Color.red;
	boolean hasClicked = false;
	boolean hasReleased = true;
	Random random = new Random();
	
	Target(double x, double y, int width, int height){
		super((int)x, (int)y, width, height);
		
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, width, height);
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getX() >= this.x && e.getX() <= this.x + 20 && e.getY() >= this.y && e.getY() <= this.y+20) {
			System.out.println("You clicked the button");
			color = Color.green;
			hasClicked = true;
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		System.out.println("You released the button");
		hasReleased = true;
	}
}
