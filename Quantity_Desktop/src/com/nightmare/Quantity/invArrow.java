	package com.nightmare.Quantity;

	import it.marteEngine.entity.Entity;

import org.newdawn.slick.GameContainer;
	import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;


	public class invArrow extends Entity {

		public invArrow(float x, float y) {
			super(x, y);
			this.scale = 3;
			this.name = "nInvArrow";
			setGraphic(Resources.nightmareSheet.getSubImage(224, 64, 16, 16));
		}

		@Override
		public void render(GameContainer gc, Graphics gr) throws SlickException {
			super.render(gc, gr);
			Entity gui = this.world.find("nINV_GUI");
			gr.drawString(Quantities.arrows.toString(), gui.x + 45, gui.y + 166);
		}
	}