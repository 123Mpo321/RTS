package com.engine.graphics;

import com.engine.game.Base;
import com.engine.level.Level;
import com.engine.game.menu.Menu;
import com.engine.tile.Tile;

public class Render{
	
	public final int MAP_HEIGHT, MAP_WIDTH;
	
	public int xOffset;
	public int yOffset;
	public int[] pixels;
	private int height, width;
	
	public Render(int height, int width){
		MAP_HEIGHT = Base.level.height;
		MAP_WIDTH = Base.level.width;
		xOffset = ((Base.level.width * 32) / 2) - (width / 2);
		yOffset = ((Base.level.height * 32) / 2) - (height / 2);
		this.height = height;
		this.width = width;
		pixels = new int[height * width];
	}
	
	public void center(){
		xOffset = ((Base.level.width * 32) / 2) - (width / 2);
		yOffset = ((Base.level.height * 32) / 2) - (height / 2);
	}
	
	public void clear(){
		for(int i = 0; i < pixels.length; i++){
			pixels[i] = 0;
		}
	}
	
	public void render(Level level){
		for(int y = 0; y < MAP_HEIGHT; y++){
			for(int x = 0; x < MAP_WIDTH; x++){
				renderTile(x, y, level.tiles[x + y * MAP_WIDTH]);
			}
		}
	}
	
	public void render(Menu menu){
		if(!menu.pic) for(int i = 0; i < pixels.length; i++) pixels[i] = menu.BackgroundImage[i];
		else
		for(int y = 0; y < menu.bg.height; y++){
			for(int x = 0; x < menu.bg.width; x++){
				pixels[x + y * width] = menu.BackgroundImage[x + y * menu.bg.width];
			}
		}
		if(menu.buttons.length == 0) return;
		System.out.println("Test");
	}
	
	public void renderTile(int xx, int yy, Tile tile){
		xx *= 32;
		yy *= 32;
		for(int y = 0; y < tile.sprite.SIZE; y++){
			int ya = y + yy - yOffset;
			for(int x = 0; x < tile.sprite.SIZE; x++){
				int xa = x + xx - xOffset;
				if(xa < 0 || xa >= width || ya < 0 || ya >= height) continue;
				pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
			}
		}
	}
}
