package main;

import java.awt.*;

public class Bullet extends Rectangle{

	private static final long serialVersionUID = 1L;
	
	Bullet(double x, double y, int width, int height){
		super((int)x, (int)y, width, height);
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillOval(x, y, width, height);
	}
}
