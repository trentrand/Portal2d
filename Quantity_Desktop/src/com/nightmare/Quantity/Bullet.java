package com.nightmare.Quantity;


import it.marteEngine.entity.Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Bullet extends Entity{

	public Image bulletTester;
	public int myX, myY;
	private double velosity_X;
	private double velosity_Y;
	private double bSpeed;
	public static final String BULLET = "bullet";

	
	public Bullet(float x, float y, int angle, int bSpeed) throws SlickException {
		super(x, y);
		
		SpriteSheet NightmareSheet = new SpriteSheet(
				"resources/nightmareSheet.png", 32, 32);
		setGraphic(NightmareSheet.getSprite(9, 0));
		setHitBox(0,0,5, 5);
		this.name = "nBullet";
		this.angle = angle;
		this.bSpeed = bSpeed;
		this.depth = 99;

		addType(BULLET);
	}
	
	public void update(GameContainer gc, int delta) throws SlickException {
		super.update(gc, delta);
		velosity_X = Math.sin(Math.toRadians(angle));
		velosity_Y = Math.cos(Math.toRadians(angle));
		velosity_X *= bSpeed;
		velosity_Y *= bSpeed;
		this.x -= velosity_X;
		this.y -= velosity_Y;
		if (collide(Tile_BlkFloor.STICKY, x, y) != null) {
			world.remove(this);
		}
		if (collide(Character.PLAYER, x, y) != null) {
			world.remove(this);
			Character.playerHealth -= 10;
		}
	}
	
	
	@Override
	public void render(GameContainer gc, Graphics gr) throws SlickException {
		super.render(gc, gr);
	}
	
	
	
	public void leftWorldBoundaries() {
		// the player unfortunately left the screen - so we retry
		world.remove(this);
	}
	
//	@Override
//	public void collisionResponse(Entity SOLID) {
//	}
	
	
}
