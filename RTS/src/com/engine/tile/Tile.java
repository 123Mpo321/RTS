package com.engine.tile;

import com.engine.graphics.sprite.Sprite;

public class Tile{
	
	public Sprite sprite;
	public int x, y;
	
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile flowers = new FlowersTile(Sprite.flowers);
	public static Tile rock = new RockTile(Sprite.rock);
	public static Tile door_closed = new DoorTile(Sprite.door_closed);
	public static Tile door_open = new DoorTile(Sprite.door_open);
	public static Tile floor_wooden = new FloorTile(Sprite.floor_wooden);
	public static Tile void_ = new FloorTile(Sprite.void_);
	
	public Tile(Sprite sprite){
		this.sprite = sprite;
	}
	
	public void render(int x, int y){
		
	}
	
	public boolean isLayered(){
		return false;
	}
	
	public boolean isInteractable(){
		return false;
	}
	
	public boolean isSolid(){
		return false;
	}
	
}
