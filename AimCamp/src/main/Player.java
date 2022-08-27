package main;

import java.awt.*;

public class Player extends Rectangle{
	
	Player(double x, double y, int width, int height){
		super((int)x, (int)y, width, height);
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, width, height);
	}
}
