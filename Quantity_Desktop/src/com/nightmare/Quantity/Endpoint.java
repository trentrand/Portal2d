package com.nightmare.Quantity;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import it.marteEngine.entity.Entity;



public class Endpoint extends Entity {

public Image spawnPoint;
public static float spawnX, spawnY;
public final static String END = "endpoint"; 
	public Endpoint(float x, float y) throws SlickException {
		super(x, y);
		this.name = "nEndpoint";
//		spawnPoint = new Image("resources/tile.png");
//		setGraphic(spawnPoint);
		spawnX = this.x;
		spawnY = this.y;
		setGraphic(Resources.nightmareSheet.getSprite(1, 1));
		setHitBox(0, 0, 32, 64);
		isType(END);
	}
	
}
