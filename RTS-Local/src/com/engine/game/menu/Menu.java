package com.engine.game.menu;

import java.awt.Color;

import com.engine.game.Base;
import com.engine.graphics.Image;

public class Menu{
	
	public boolean pic;
	public int[] BackgroundImage;
	public Image bg;
	public Button[] buttons;
	
	public Menu(Color c){
		pic = false;
		buttons = new Button[0];
		BackgroundImage = new int[Base.width * Base.height];
		for(int i = 0; i < BackgroundImage.length; i++){
			BackgroundImage[i] = c.getRGB();
		}
	}
	
	public Menu(Image bg){
		this.bg = bg;
		pic = true;
		buttons = new Button[0];
		BackgroundImage = new int[bg.pixels.length];
		for(int i = 0; i < BackgroundImage.length; i++){
			BackgroundImage[i] = bg.pixels[i];
		}
	}
	
}
