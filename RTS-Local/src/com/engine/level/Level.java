package com.engine.level;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import com.engine.tile.Tile;

public class Level{
	
	public final String ID;
	public Tile[] tiles;
	public String[] tilenames;
	public int width, height;
	
	public Level(int locX, int locY, String ID, String level){
		this.ID = ID;
		loadLevel(level);
	}
	
	private void loadLevel(String level){
		Scanner input = null;
		try{
			input = new Scanner(new File(level));
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		width = input.nextInt();
		height = input.nextInt();
		input.nextLine();
		
		tiles = new Tile[width * height];
		tilenames = new String[width * height];
		
		for(int x = 0; x < width * height; x++){
			try{
				tilenames[x] = input.nextLine();
			}catch(NoSuchElementException e){
				System.out.println("Tile Missing!");
				tilenames[x] = "void_";
			}
		}
		
		input.close();
		
		for(int x = 0; x < tilenames.length; x++){
			tiles[x] = getTile(tilenames[x]);
		}
	}
	
	private Tile getTile(String s){
		if(s.equals("grass")) return Tile.grass;
		else if(s.equals("rock")) return Tile.rock;
		else if(s.equals("flowers")) return Tile.flowers;
		else if(s.equals("floor_wooden")) return Tile.floor_wooden;
		else if(s.equals("door_closed")) return Tile.door_closed;
		else if(s.equals("door_open")) return Tile.door_open;
		return Tile.void_;
	}
	
}
