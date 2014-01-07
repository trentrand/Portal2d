package com.nightmare.Quantity;

import it.marteEngine.entity.Entity;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;



public class Background extends Entity {

	Image background;
	
	public Background(float x, float y) throws SlickException {
		super(x, y);
		Image bg = new Image("resources/bg.png");
		if (PewWorld.levelNum == 0) {
			setGraphic(bg.getSubImage(0, 0, 1024, 768));
		}
		this.depth = -100;
	}
}
