package src;

public abstract class Character extends Rect {

	int health;
	int damage;
	
	public Character(int health, int damage, double x, double y, int w, int h) 
	{
		super(x, y, w, h);
		this.health = health;
		this.damage = damage;
	}
	
	void takeDamage(Character c) 
	{
		
	}
	
	void attack() 
	{
		
	}
	
	void movement() 
	{
		
	}
}
