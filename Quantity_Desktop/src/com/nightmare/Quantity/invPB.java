package com.nightmare.Quantity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import it.marteEngine.entity.Entity;

public class invPB extends Entity {

	public invPB(float x, float y) {
		super(x, y);
		this.name = "nInvPB";
		this.scale = 3;
		setGraphic(Resources.nightmareSheet.getSubImage(240, 64, 16, 16));
	}

	@Override
	public void render(GameContainer gc, Graphics gr) throws SlickException {
		super.render(gc, gr);
		Entity gui = this.world.find("nINV_GUI");
		gr.drawString(Quantities.portalblues.toString(), gui.x + 45, gui.y + 102);
	}
}
