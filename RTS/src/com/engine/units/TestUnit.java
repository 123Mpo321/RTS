package com.engine.units;

import com.engine.graphics.sprite.Sprite;

public class TestUnit extends Unit{
	
	public TestUnit(String id, int spawnX, int spawnY){
		super(id, spawnX, spawnY);
		sprite = Sprite.void_;
		//setDestination(64, 64);
	}
	
}
