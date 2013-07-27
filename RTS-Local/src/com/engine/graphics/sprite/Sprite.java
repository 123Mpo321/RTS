package com.engine.graphics.sprite;

public class Sprite{
	
	public static Sprite grass = new Sprite(SpriteSheet.main, 0, 0);
	public static Sprite flowers = new Sprite(SpriteSheet.main, 1, 0);
	public static Sprite rock = new Sprite(SpriteSheet.main, 2, 0);
	public static Sprite door_closed = new Sprite(SpriteSheet.main, 3, 0);
	public static Sprite door_open = new Sprite(SpriteSheet.main, 4, 0);
	public static Sprite floor_wooden = new Sprite(SpriteSheet.main, 5, 0);
	public static Sprite void_ = new Sprite(SpriteSheet.main, 7, 7);
	
	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;
	
	public Sprite(SpriteSheet sheet, int x, int y){
		SIZE = 32;
		this.x = x * SIZE;
		this.y = y * SIZE;
		this.sheet = sheet;
		pixels = new int[SIZE * SIZE];
		load();
	}
	
	public Sprite(SpriteSheet sheet, int x, int y, int size){
		SIZE = size;
		this.x = x * SIZE;
		this.y = y * SIZE;
		this.sheet = sheet;
		pixels = new int[SIZE * SIZE];
		load();
	}
	
	private void load(){
		for(int yy = 0; yy < SIZE; yy++){
			for(int xx = 0; xx < SIZE; xx++){
				pixels[xx + yy * SIZE] = sheet.pixels[(x + xx) + (y + yy) * sheet.SIZE];
			}
		}
	}
}
