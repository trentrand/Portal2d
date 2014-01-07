package com.nightmare.Quantity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import it.marteEngine.entity.Entity;

public class invSpring extends Entity {

	public invSpring(float x, float y) {
		super(x, y);
		this.name = "nInvSU";
		this.scale = 3;
		setGraphic(Resources.nightmareSheet.getSubImage(208, 80, 16, 16));
	}

	@Override
	public void render(GameContainer gc, Graphics gr) throws SlickException {
		super.render(gc, gr);
		Entity gui = this.world.find("nINV_GUI");
		gr.drawString(Quantities.springsup.toString(), gui.x + 45, gui.y + 296);
	}
}
