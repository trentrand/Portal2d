package com.nightmare.Quantity;

import it.marteEngine.entity.Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Tile_BlkFloor extends Entity{
	public static String TILE = "tile_blkfloor";
	public static String STICKY = "sticky";

	  public Image         tile;
	  public SpriteSheet tiles;

	  public Tile_BlkFloor(float x, float y) throws SlickException {
	        super(x, y);

	        SpriteSheet tiles = new SpriteSheet("resources/nightmareSheet.png", 32, 32);
	        Image tile       = tiles.getSprite(0, 2);
	        
			this.name = "nTile_BlkFloor";

	        setGraphic(tile);
	        setHitBox(0, 0, 32, 32);
	        addType(SOLID, STICKY);
	    }

	    public void update(GameContainer gc, int delta) throws SlickException {
	        super.update(gc, delta);
	        
	    }

	    @Override
	    public void collisionResponse(Entity a) {
//	        sc.print("collision report on " + this.name);
	    }
	}


	//~ Formatted by Jindent --- http://www.jindent.com
