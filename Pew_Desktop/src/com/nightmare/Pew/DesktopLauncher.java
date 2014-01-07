package com.nightmare.Pew;

import org.newdawn.slick.ApplicationGDXContainer;
import org.newdawn.slick.SlickException;

public class DesktopLauncher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ApplicationGDXContainer gc = new ApplicationGDXContainer(
					new Main(), 1024, 768, 1024, 768);
			gc.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

}
