package com.nightmare.Quantity;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import it.marteEngine.entity.Entity;



public class SpawnPoint extends Entity {

public Image spawnPoint;
public static float spawnX, spawnY;

	public SpawnPoint(float x, float y) throws SlickException {
		super(x, y);
		this.name = "nSpawnPoint";
//		spawnPoint = new Image("resources/tile.png");
//		setGraphic(spawnPoint);
		spawnX = this.x;
		spawnY = this.y;
	}

	
}
