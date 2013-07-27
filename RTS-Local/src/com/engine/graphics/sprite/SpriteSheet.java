package com.engine.graphics.sprite;

import com.engine.graphics.Image;

public class SpriteSheet{
	
	public static SpriteSheet main = new SpriteSheet("main.png", 256);
	
	public final int SIZE;
	public int[] pixels;
	
	public SpriteSheet(String path, int size){
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		Image i = new Image(path);
		for(int x = 0; x < pixels.length; x++){
			pixels[x] = i.pixels[x];
		}
	}
}
