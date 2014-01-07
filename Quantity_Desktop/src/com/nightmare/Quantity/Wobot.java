package com.nightmare.Quantity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import it.marteEngine.entity.Entity;
import it.marteEngine.entity.PhysicsEntity;

public class Wobot extends PhysicsEntity {
	private int frame = 0;
	private int frameTimer = 0;
	private int frameInterval = 1000; // switch frame every 100 ms if walking

	public Wobot(float x, float y, int shootSpeed) {
		super(x, y);
		frameInterval = shootSpeed;
		this.name = "nWobot";
		setGraphic(Resources.nightmareSheet.getSubImage(128, 128, 32, 64));
		setHitBox(0, 0, 32, 64);
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		super.update(container, delta);
	
		frameTimer -= delta;
		while (frameTimer <= 0) {
			frame++;
			frameTimer += frameInterval;
			if (frame > 1) { 
				shoot2Target();
				frame = 0;
			}
		}
	}

	private void shoot2Target() throws SlickException {
		Entity target = this.world.find("nCharacter");
		int angle2 = Math.abs((int) calculateAngle(this.x, this.y, target.x,
				target.y));
		Entity Bullet = new Bullet(x + 16, y, angle2, 1);
		this.world.add(Bullet);
	}
	
	@Override
	public void render(GameContainer gc, Graphics gr) throws SlickException {
		super.render(gc, gr);
	}

}
