package com.engine.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.TimerTask;

import com.engine.game.Base;

public class Input extends TimerTask implements KeyListener, MouseListener, MouseMotionListener{
	
	private int mapMovementSpeed = 4;
	private boolean keyMapMove = false;
	private boolean mouseMapMove = false;
	private int x, y;
	
	public void run(){
		update();
		utilities();
		keyMapMovement();
		mouseMapMovement();
		mapEdge();
	}
	
	private void utilities(){
		if(center) Base.render.center();
		if(quit) System.exit(0);
	}
	
	private void keyMapMovement(){
		if(!up || !down || !left || !right) keyMapMove = false;
		if(!mouseMapMove){
		if(up || down || left || right) keyMapMove = true;
		if(up) Base.render.yOffset -= mapMovementSpeed;
		if(down) Base.render.yOffset += mapMovementSpeed;
		if(left) Base.render.xOffset -= mapMovementSpeed;
		if(right) Base.render.xOffset += mapMovementSpeed;
		}
	}
	
	private void mouseMapMovement(){
		if(x >= 160 && x <= Base.width - 160 && y >= 160 && y <= Base.height - 16) mouseMapMove = false;
		if(!keyMapMove){
		if(x < 160 || x > Base.width - 160 || y < 160 || y > Base.height - 160) mouseMapMove = true;
		if(x < 160) Base.render.xOffset -= mapMovementSpeed;
		if(x > Base.windowWidth - 160) Base.render.xOffset += mapMovementSpeed;
		if(y < 160) Base.render.yOffset -= mapMovementSpeed;
		if(y > Base.windowHeight - 160) Base.render.yOffset += mapMovementSpeed;
		}
	}
	
	private void mapEdge(){
		if(Base.render.yOffset < 0) Base.render.yOffset += mapMovementSpeed;
		if(Base.render.yOffset > (Base.level.height * 32) - Base.height) Base.render.yOffset -= mapMovementSpeed;
		if(Base.render.xOffset < 0) Base.render.xOffset += mapMovementSpeed;
		if(Base.render.xOffset > (Base.level.width * 32) - Base.width) Base.render.xOffset -= mapMovementSpeed;
	}
	
	/*************Key Listener******************/
	
	private boolean[] keys = new boolean[65536];
	public boolean up, down, left, right, quit, center;
	
	public void update(){
		up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
		center = keys[KeyEvent.VK_ENTER];
		quit = keys[KeyEvent.VK_ESCAPE];
	}
	
	public void keyPressed(KeyEvent e){
		keys[e.getKeyCode()] = true;
	}
	
	public void keyReleased(KeyEvent e){
		keys[e.getKeyCode()] = false;
	}
	
	public void keyTyped(KeyEvent e){
	}
	
	/*************Mouse Listeners***************/
	
	public void mouseDragged(MouseEvent e){
		
	}
	
	public void mouseMoved(MouseEvent e){
		x = e.getX();
		y = e.getY();
	}
	
	public void mouseClicked(MouseEvent e){
		
	}
	
	public void mouseEntered(MouseEvent e){
		
	}
	
	public void mouseExited(MouseEvent e){
		
	}
	
	public void mousePressed(MouseEvent e){
		
	}
	
	public void mouseReleased(MouseEvent e){
		
	}
	
}
