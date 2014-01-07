package com.nightmare.Quantity;

import it.marteEngine.entity.Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Portal_Red extends Entity {
	public static String PR = "portal_red";
	public static Image portal;
	public SpriteSheet tiles;
	static int border; // for now until wall directional portal snap works

	// 1 north, 2 east, 3 south, 4 west

	public Portal_Red(float x, float y, int direction) throws SlickException {
		super(x, y);
		SpriteSheet tiles = new SpriteSheet("resources/nightmareSheet.png", 64,
				64);
		portal = tiles.getSprite(1, 2);
		// Portal_Blue.border = direction;
		this.depth = 105;
		this.name = "nPortal_Red";
		this.centered = true;
		setGraphic(portal);
		addType(PR);
	}

	public void update(GameContainer gc, int delta) throws SlickException {
		super.update(gc, delta);
	}

	@Override
	public void collisionResponse(Entity a) {
	}

}

// ~ Formatted by Jindent --- http://www.jindent.com
