package com.nightmare.Quantity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import it.marteEngine.entity.Entity;

public class invPR extends Entity {

	public invPR(float x, float y) {
		super(x, y);
		this.name = "nInvPR";
		this.scale = 3;
		setGraphic(Resources.nightmareSheet.getSubImage(240, 80, 16, 16));
	}

	@Override
	public void render(GameContainer gc, Graphics gr) throws SlickException {
		super.render(gc, gr);
		Entity gui = this.world.find("nINV_GUI");
		gr.drawString(Quantities.portalreds.toString(), gui.x + 45, gui.y + 40);
	}
}
