package com.nightmare.Quantity;

//
import it.marteEngine.entity.Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class pbBullet extends Entity {

	// private Tweener tweener;
	public int myX, myY;
	private double velosity_X;
	private double velosity_Y;
	private double bSpeed;
	public static final String BULLET = "bullet";

	public pbBullet(float x, float y, int angle, int bSpeed)
			throws SlickException {
		super(x, y);
		this.angle = angle;
		this.bSpeed = bSpeed;
		SpriteSheet NightmareSheet = new SpriteSheet(
				"resources/nightmareSheet.png", 32, 32);
		setGraphic(NightmareSheet.getSprite(9, 0));
		this.depth = 99;
		// addType(SOLID);
		addType(BULLET);
		// tweener = new Tweener();
		this.setCentered(true);

		setHitBox(16, 16, 1, 1);
		// myX = Character.mouseX;
		// myY = Character.mouseY;
		if (Character.gunDir == 0) {
			this.angle -= 90;
		} else if (Character.gunDir == 1) {
			this.angle -= 270;
		}
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		// Entity PG = this.world.find("nPortal_Gun");
		// velosity_X = Math.sin(angle) * bSpeed;
		// velosity_Y = Math.cos(angle) * bSpeed;
		velosity_X = Math.sin(Math.toRadians(angle));
		velosity_Y = Math.cos(Math.toRadians(angle));
		// System.out.println(velosity_X + "   " + velosity_Y);
		velosity_X *= bSpeed;
		velosity_Y *= bSpeed;
		// System.out.println(velosity_X + "   " + velosity_Y);

		this.x += velosity_X;
		this.y -= velosity_Y;
		// float dx = 0;
		// float dy = 0;
		// Vector2f vectorSpeed = calculateVector(Portal_Gun.alteredAngle, 25);
		// dx += vectorSpeed.x;
		// dy += vectorSpeed.y;
		// x += dx;
		// y += dy;
		// collide(SOLID, x, y);
		// move bullet in straight line, and affect with angle
		if (collide(Tile_BlkFloor.STICKY, x, y + 10) != null) {
			// Portal_Blue pb3 = new Portal_Blue(x, y - 22, 3);
			// world.add(pb3);
			Entity pBi = this.world.find("nPortal_Blue");
			pBi.x = x;
			pBi.y = (int)((y + 16) / 32) * 32;
			Portal_Blue.border = 3;
			pBi.setHitBox(-32, 31, 64, 1);
			Portal_Blue.portal.setRotation(90);
		} else if (collide(Tile_BlkFloor.STICKY, x, y - 10) != null) {
			// Portal_Blue pb1 = new Portal_Blue(x, y, 1);
			// world.add(pb1);
			Entity pBi = this.world.find("nPortal_Blue");
			pBi.x = x;
			pBi.y = (int)((y + 16) / 32) * 32 + 32;
			Portal_Blue.border = 1;
			pBi.setHitBox(-32, -32, 64, 1);
			Portal_Blue.portal.setRotation(270);
		} else if (collide(Tile_BlkFloor.STICKY, x + 10, y) != null) {
			// Portal_Blue pb2 = new Portal_Blue(x, y, 2);
			Entity pBi = this.world.find("nPortal_Blue");
			// pBi.x = x - 22;
			pBi.x = (int)((x + 16) / 32) * 32;
			pBi.y = y;
			Portal_Blue.border = 2;
			pBi.setHitBox(31, -32, 1, 64);
			Portal_Blue.portal.setRotation(0);
		} else if (collide(Tile_BlkFloor.STICKY, x - 10, y) != null) {
			// Portal_Blue pb4 = new Portal_Blue(x, y, 4);
			// world.add(pb4);
			Entity pBi = this.world.find("nPortal_Blue");
			pBi.x = (int)((x + 16) / 32) * 32 + 32;
			pBi.y = y;
			Portal_Blue.border = 4;
			pBi.setHitBox(-32, -32, 1, 64);
			Portal_Blue.portal.setRotation(180);
		}

		super.update(container, delta);
	}

	@Override
	public void collisionResponse(Entity SOLID) {
		world.remove(this);
	}
}
