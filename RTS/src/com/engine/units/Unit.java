package com.engine.units;

import com.engine.game.Base;
import com.engine.game.input.Input;
import com.engine.graphics.sprite.Sprite;

public class Unit{
	
	public final String ID;
	public Sprite sprite;
	public double x, y;
	private int health;
	private int damage;
	private boolean isFlying;
	private int elevation; 	
	private int speed = 3;
	
	protected double xd, yd;
	protected double xStart, yStart;
	protected double destinationX, destinationY;
	protected boolean selected = true;
	
	public Unit(String id, int spawnX, int spawnY){
		ID = id;
		x = spawnX;
		y = spawnY;
	}
	
	public void update(){
		if(selected){
			if(Input.mouse){
				setDestination((double) (Input.x + Base.render.xOffset), (double) (Input.y + Base.render.yOffset));
			}
		}
		move();
	}
	
	public void setDestination(double x, double y){
		xStart = this.x;
		yStart = this.y;
		
		destinationX = x;
		destinationY = y;
		
		if(destinationX > this.x){
			destinationX -= sprite.SIZE / 2;
		}else if(destinationX < this.x){
			destinationX += sprite.SIZE / 2;
		}
		
		if(destinationY > this.y){
			destinationY -= sprite.SIZE / 2;
		}else if(destinationY < this.y){
			destinationY += sprite.SIZE / 2;
		}
		
		double dx = x - (1024);
		double dy = y - (768);
		double dir = Math.atan2(dy, dx);
		
		if(destinationX > this.x){
			xd = -speed * Math.cos(dir);
		}else if(destinationX < this.x){
			xd = speed * Math.cos(dir);
		}
		
		if(destinationY > this.y){
			yd = -speed * Math.sin(dir);
		}else if(destinationY < this.y){
			yd = speed * Math.sin(dir);
		}
	}
	
	public void move(){
		x += xd;
		y += yd;
		if(destinationX > xStart){
			if(x >= destinationX){
				xd = 0;
				xStart = x;
			}
		}else if(destinationX < xStart){
			if(x <= destinationX){
				xd = 0;
				xStart = x;
			}
		}
		if(destinationY > yStart){
			if(y >= destinationY){
				yd = 0;
				yStart = y;
			}
		}else if(destinationY < yStart){
			if(y <= destinationY){
				yd = 0;
				yStart = y;
			}
		}
	}
	
}
