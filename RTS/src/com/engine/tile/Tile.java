package com.engine.tile;

import com.engine.graphics.sprite.Sprite;

public class Tile{
	
	public Sprite sprite;
	public int x, y;
	public String id;
	
	public static Tile grass = new GrassTile(Sprite.grass, "Grass");
	public static Tile flowers = new FlowersTile(Sprite.flowers, "Flowers");
	public static Tile rock = new RockTile(Sprite.rock, "Rock");
	public static Tile door_closed = new DoorTile(Sprite.door_closed, "Door_Closed");
	public static Tile door_open = new DoorTile(Sprite.door_open, "Door_Open");
	public static Tile floor_wooden = new FloorTile(Sprite.floor_wooden, "Floor_Wooden");
	public static Tile void_ = new FloorTile(Sprite.void_, "Void_");
	
	public Tile(Sprite sprite, String id){
		this.sprite = sprite;
		this.id = id;
	}
	
	public boolean isSolid(){
		return false;
	}
	
	public static Tile getTile(String s){
		if(s.equals(grass.id)) return Tile.grass;
		else if(s.equals(rock.id)) return Tile.rock;
		else if(s.equals(flowers.id)) return Tile.flowers;
		else if(s.equals(floor_wooden.id)) return Tile.floor_wooden;
		else if(s.equals(door_closed.id)) return Tile.door_closed;
		else if(s.equals(door_open.id)) return Tile.door_open;
		return Tile.void_;
	}
	
}
