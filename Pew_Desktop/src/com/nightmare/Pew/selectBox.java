package com.nightmare.Pew;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import it.randomtower.engine.entity.Entity;

public class selectBox extends Entity {

	public Image outLine;
	public static int invSlot = 1;

	public selectBox(float x, float y) throws SlickException {
		super(x, y);
		this.name = "nselectBox";
		this.depth = 10000;
		this.scale = 1;
		SpriteSheet guiSheet = new SpriteSheet("resources/guiSheet.png", 82, 82);
		outLine = guiSheet.getSprite(0, 0);
		setGraphic(outLine);
	}

	@Override
	public void render(GameContainer gc, Graphics gr) throws SlickException {
		super.render(gc, gr);
		// gr.translate(-4, -4);
		// gr.drawImage(outLine, this.x, this.y);
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		super.update(gc, delta);
		if (invSlot == 1) {
			Entity gui = this.world.find("nINV_GUI");
			this.y = gui.y - 9;
		}
		if (invSlot == 2) {
			Entity gui = this.world.find("nINV_GUI");
			this.y = gui.y + 55;
		}
		if (invSlot == 3) {
			Entity gui = this.world.find("nINV_GUI");
			this.y = gui.y + 119;
		}
		if (invSlot == 4) {
			Entity gui = this.world.find("nINV_GUI");
			this.y = gui.y + 183;
		}
		if (invSlot == 5) {
			Entity gui = this.world.find("nINV_GUI");
			this.y = gui.y + 247;
		}
		if (invSlot == 6) {
			Entity gui = this.world.find("nINV_GUI");
			this.y = gui.y + 311;
		}
		if (invSlot == 7) {
			Entity gui = this.world.find("nINV_GUI");
			this.y = gui.y + 375;
		}
		if (invSlot == 8) {
			Entity gui = this.world.find("nINV_GUI");
			this.y = gui.y + 439;
		}
		if (invSlot == 9) {
			Entity gui = this.world.find("nINV_GUI");
			this.y = gui.y + 503;
		}
		if (invSlot == 10) {
			Entity gui = this.world.find("nINV_GUI");
			this.y = gui.y + 567;
		}
	}
}
