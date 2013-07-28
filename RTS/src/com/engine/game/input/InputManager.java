package com.engine.game.input;

import java.util.Timer;

import com.engine.game.Base;

public class InputManager implements Runnable{
	
	private Timer t;
	
	public InputManager(){
		t = new Timer();
		t.schedule(Base.in, 0, 1000 / 60);
	}
	
	public void run(){
	}
	
}
