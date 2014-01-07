package com.nightmare.Quantity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

import it.marteEngine.entity.PhysicsEntity;

public class PushCube extends PhysicsEntity{

	public PushCube(float x, float y) {
		super(x, y);
		this.name = "nPushCube";
		setGraphic(Resources.nightmareSheet.getSprite(0, 2));
		addType(SOLID);
		setHitBox(0, 0, 32, 32);
		this.gravity = 1.3f;
	}
	
	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		super.update(gc, delta); 
	if (collide(Character.PLAYER, x + 3, y) != null) {
		if (collide(SOLID, x - 2, y) == null) {
			x -= 1;

		}
	
	}
	if (collide(Character.PLAYER, x - 3, y) != null) {
		if (collide(SOLID, x + 2, y) == null) {
			x += 1;

		}
	
	}
	}
	

}
