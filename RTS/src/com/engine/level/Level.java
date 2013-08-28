package com.engine.level;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.engine.tile.Tile;

public class Level{
	
	public final String ID;
	public Tile[] tiles;
	public int[] elevations;
	private String path;
	public int height, width;
	
	public Level(String ID, String level){
		this.ID = ID;
		path = level;
		loadLevel(level);
	}
	
	private void loadLevel(String level){
		Scanner input = null;
		File f = new File(level);
		try{
			input = new Scanner(f);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		width = Integer.parseInt(input.next());
		height = Integer.parseInt(input.next());
		String[] s = new String[height * width];
		elevations = new int[height * width];
		for(int i = 0; i < s.length; i++){
			try{
				s[i] = input.next();
			}catch(NoSuchElementException e){
				e.printStackTrace();
				s[i] = "Grass";
			}
		}
		tiles = new Tile[s.length];
		for(int x = 0; x < s.length; x++){
			tiles[x] = Tile.getTile(s[x]);
		}
		
		input.close();
	}
	
	public void write(){
		try{
			Formatter f = new Formatter(path);
			for(int i = 0; i < tiles.length; i += 15){
				f.format("%s %s %s %s %s %s %s %s %s %s %s %s %s %s %s\n", tiles[i].id, tiles[i + 1].id, tiles[i + 2].id, tiles[i + 3].id, tiles[i + 4].id, tiles[i + 5].id, tiles[i + 6].id, tiles[i + 7].id, tiles[i + 8].id, tiles[i + 9].id, tiles[i + 10].id, tiles[i + 11].id, tiles[i + 12].id, tiles[i + 13].id, tiles[i + 14].id);
			}
			f.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
	
}
