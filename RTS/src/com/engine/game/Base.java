package com.engine.game;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;

import com.engine.graphics.Image;
import com.engine.graphics.Render;
import com.engine.game.input.Input;
import com.engine.game.input.InputManager;
import com.engine.level.Level;
import com.engine.game.menu.Menu;

public class Base extends Canvas implements Runnable{
	
	private static final long serialVersionUID = 1L;
	
	private static boolean debug = true;
	private static boolean windowed = true;
	
	public static boolean running = false;
	public static int width = 1024;
	public static int windowWidth, windowHeight;
	public static int height = 768;
	public static int state;
	private String title = "TestEngine (RTS) | Alpha V0.0.1";
	
	private Thread core;
	private Thread input;
	
	public static Render render;
	public static Level level;
	public static Menu menu;
	public static Input in = new Input();
	private JFrame frame = new JFrame();
	
	BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	
	public Base(){
		state = 1;
		level = new Level("Temp", "Testing.txt");
		menu = new Menu(new Image("bg.png"));
		Dimension size = new Dimension(width, height);
		setPreferredSize(size);
		
		addKeyListener(in);
		addMouseListener(in);
		addMouseMotionListener(in);
		
		render = new Render(height, width);
	}
	
	public void start(){
		running = true;
		core = new Thread(this, "Core");
		input = new Thread(new InputManager(), "Input");
		core.run();
		input.run();
	}
	
	public void stop(){
		running = false;
		try{
			core.join();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public void run(){
		requestFocus();
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 0.0){
				update();
				updates++;
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				if(debug) frame.setTitle(title + "  |  " + updates + " ups, " + frames + " fps");
				frames = 0;
				updates = 0;
			}
		}
	}
	
	private void update(){
		
	}
	
	private void render(){
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		
		render.clear();
		if(state == 0) render.render(menu);
		if(state == 1) render.render(level);
		
		for(int i = 0; i < pixels.length; i++){
			pixels[i] = render.pixels[i];
		}
		Graphics g = bs.getDrawGraphics();
		windowWidth = getWidth();
		windowHeight = getHeight();
		g.drawImage(image, 0, 0, windowWidth, windowHeight, null);
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args){
		Base game = new Base();
		if(!windowed){
			game.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			game.frame.setUndecorated(true);
		}
		game.frame.setResizable(false);
		game.frame.setTitle(game.title);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		
		game.start();
	}
	
}
