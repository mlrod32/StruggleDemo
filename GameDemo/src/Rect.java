package src;

import java.awt.Graphics;

public class Rect 
{

	double x;
	double y;
	
	int w;
	int h;
	
	int Angle;
	
	double xVelocity;
	double yVelocity;
	
	double xAcceleration;
	double yAcceleration;
	
	public Rect(double x, double y, int w, int h)
{
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		
	}
	
	public void draw(Graphics g) 
	{
		g.drawRect((int)x, (int)y, w, h);
	}
	
	public void setLocation(double x, double y) 
	{
		this.x = x;
		this.y = y;
	}
	
	
	//Movement Fucntions
	
	public void moveBy(double dx, double dy) 
	{
		x += dx;
		y += dy;
	}
	
	public void setVelocity(double xVel, double yVel)
	{
		xVelocity = xVel;
		yVelocity = yVel;
	}
	
	public void setAcceleration(double xAccel, double yAccel)
	{
		xAcceleration = xAccel;
		yAcceleration = yAccel;
	}
	
	public void move() {
		xVelocity += xAcceleration;
		yVelocity += yAcceleration;
		
		x += xVelocity;
		y += yVelocity;
		
	}
	
	public void rotateRight(int angle) 
	{
		Angle -= angle;
		if(Angle < 0) Angle += 360;
		
	}
	
	public void rotateLeft(int angle) {
		Angle += angle;
		if(Angle >= 360) Angle -= 360; 
	}
	
	//Collision Detection Functions
	public boolean collides(Rect r) 
	{
		return (x < r.x + r.w) && (x + w > r.x) && (y < r.y + r.h) && (y + h > r.y);
	}
	
}
