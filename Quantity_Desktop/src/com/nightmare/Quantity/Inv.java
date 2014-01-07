package com.nightmare.Quantity;

import it.marteEngine.entity.Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;


public class Inv extends Entity {

	public SpriteSheet guiSheet;
	public static boolean setVisible;
	public static float thisX, thisY;

	public Inv(float x, float y) throws SlickException {
		super(x, y);
		this.depth = 9999;
		this.scale = 2;
		this.name = "nINV_GUI";
		SpriteSheet guiSheet = new SpriteSheet("resources/guiSheet.png", 32,
				320);
		setGraphic(guiSheet.getSprite(9, 0));
		thisX = x;
		thisY = y;
	}

	public void setVisible() {
		if (setVisible) {
			this.depth = -1;
			// Inventory_GUI.visible = false;
		} else {
			this.depth = 9999;
			// Inventory_GUI.visible = true;
		}
	}

	public static void setupInv() {
		
	}

	// public static void addItem(int itemNumber) {
	// if (itemNumber == 1) {
	// String pb = (("1" + "." + Quantities.portalblues.toString()));
	// inv.add(Float.valueOf(pb));
	// }
	// else if (itemNumber == 2) {
	// String pr = (("2" + "." + Quantities.portalreds.toString()));
	// inv.add(Float.valueOf(pr));
	// }
	// else if (itemNumber == 3) {
	// String ar = (("3" + "." + Quantities.arrows.toString()));
	// inv.add(Float.valueOf(ar));
	// }
	// else if (itemNumber == 4) {
	// String su = (("4" + "." + Quantities.springsup.toString()));
	// inv.add(Float.valueOf(su));
	// }
	// else if (itemNumber == 5) {
	// String lu = (("5" + "." + Quantities.launchers.toString()));
	// inv.add(Float.valueOf(lu));
	// } else {
	// sc.print("One of your items is printing an out of range itemNumber value to Inv.java!");
	// }
	// }
	//
	// public static void removeItem(Integer key) {
	// inv.remove((int) key);
	// }

	@Override
	public void render(GameContainer gc, Graphics gr) throws SlickException {
		super.render(gc, gr);
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		super.update(gc, delta);
		if (Quantities.portalblues > 0) {
		}
		if (Quantities.portalreds > 0) {
		}
		if (Quantities.arrows > 0) {
		}
		if (Quantities.springsup > 0) {
		}
		if (Quantities.launchers > 0) {
		}
	}

	// public static int getMaxInv() {
	// return MaxInv;
	// }

	// public static void setMaxInv(int maxInv) {
	// MaxInv = maxInv;
	// }
}