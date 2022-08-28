package main;

import java.util.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Target extends Rectangle{
	
	private static final long serialVersionUID = 1L;
	
	public Color color = Color.red;
	boolean hasClicked = false;
	boolean hasReleased = true;
	Random random = new Random();
	
	Target(double x, double y, int width, int height){
		super((int)x, (int)y, width, height);
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x, y, width, height);
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getX() >= this.x && e.getX() <= this.x + this.width && e.getY() >= this.y && e.getY() <= this.y + this.height) {
			hasClicked = true;
		}
	}
	
}
