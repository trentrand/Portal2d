package com.nightmare.Quantity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

import it.marteEngine.entity.Entity;

public class itemPB extends Entity{

	public itemPB(float x, float y) {
		super(x, y);
		this.name = "nitemPB";
		setGraphic(Resources.nightmareSheet.getSubImage(240, 65, 16, 16));
		setHitBox(0, 0, 16, 16);
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		super.update(gc, delta);
		// DEBUG
		// if (Inv.inv.get("Launcher") != null) {
		// sc.print(Inv.inv.get("Launcher"));
		// }
		if (collide(SOLID, x, y) == null) {
			y += 1;
		}
		if (collide(Character.PLAYER, x, y) != null) {
			this.world.remove(this);
			Quantities.portalblues++;
//			Inv.inv.clear();
//			Inv.setupInv();
//			System.out.println(Inv.inv);
		}
	}
}
