package com.nightmare.Quantity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

import it.marteEngine.entity.Entity;

public class itemArrow extends Entity{

	public itemArrow(float x, float y) {
		super(x, y);
		this.name = "nitemArrow";
		setGraphic(Resources.nightmareSheet.getSubImage(224, 64, 16, 16));
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
			Quantities.arrows++;
//			Inv.inv.clear();
//			Inv.setupInv();
//			System.out.println(Inv.inv);
		}
	}
}
