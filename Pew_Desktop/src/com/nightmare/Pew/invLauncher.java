package com.nightmare.Pew;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import it.randomtower.engine.entity.Entity;

public class invLauncher extends Entity {

	public invLauncher(float x, float y) {
		super(x, y);
		this.scale = 3;
		setGraphic(Resources.nightmareSheet.getSubImage(224, 80, 16, 16));
	}

	@Override
	public void render(GameContainer gc, Graphics gr) throws SlickException {
		super.render(gc, gr);
		Entity gui = this.world.find("nINV_GUI");
		gr.drawString(Quantities.launchers.toString(), gui.x + 45, gui.y + 232);
	}
}
