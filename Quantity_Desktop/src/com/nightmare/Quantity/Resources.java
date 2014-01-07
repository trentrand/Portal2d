package com.nightmare.Quantity;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Resources {
	public static SpriteSheet invSheet;
	public static SpriteSheet nightmareSheet;

public static void loadRes() throws SlickException {
	invSheet = new SpriteSheet("resources/guiSheet.png", 32, 32);
	nightmareSheet = new SpriteSheet("resources/nightmareSheet.png", 32, 32);
}

}
