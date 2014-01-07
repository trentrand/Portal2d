package com.nightmare.Pew;

import it.randomtower.engine.entity.Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Launcher extends Entity {
	public static final String ACTIVE = "active";
	public static final String NONACTIVE = "nonactive";
	public static final String LU = "launcher";
	public Image launcher;
	public SpriteSheet tiles;
	public static boolean isMoving;
	
	public Launcher(float x, float y) throws SlickException {
		super(x, y);

		SpriteSheet tiles = new SpriteSheet("resources/nightmareSheet.png", 32,
				32);
		this.depth = 115;
		this.name = "nLauncher";
		setHitBox(15, 32, 2, 1);
		setupAnimations(tiles);
		addType(LU, SOLID);
	}

	private void setupAnimations(SpriteSheet tiles) throws SlickException {
		setGraphic(new SpriteSheet(tiles, 32, 32));
		duration = 50;
		addAnimation(ACTIVE, true, 2, 2, 3, 4, 5);
		animations.get(ACTIVE).setPingPong(true);
		addAnimation(NONACTIVE, true, 2, 2);
		currentAnim = NONACTIVE;

	}

	public void update(GameContainer gc, int delta) throws SlickException {
		super.update(gc, delta);
		if (isMoving == true) {
			currentAnim = ACTIVE;
		} else {
			currentAnim = NONACTIVE;
		}
	}

	public boolean isMoving() {
		if (currentAnim.equalsIgnoreCase(ACTIVE)) {
			return true;
		}

		return false;
	}
	
	
//	@Override
//	public void collisionResponse(Entity a) {
//	}
	

}

// ~ Formatted by Jindent --- http://www.jindent.com
