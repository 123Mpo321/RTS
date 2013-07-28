package com.engine.graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Image{
	
	private String path;
	public int[] pixels;
	int width, height;
	
	public Image(String path){
		this.path = path;
		load();
	}
	
	private void load(){
		try{
			BufferedImage img = ImageIO.read(new File(path));
			width = img.getWidth();
			height = img.getHeight();
			pixels = new int[height * width];
			img.getRGB(0, 0, width, height, pixels, 0, width);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
