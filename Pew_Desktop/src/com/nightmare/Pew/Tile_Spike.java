package com.nightmare.Pew;

import it.randomtower.engine.entity.Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Tile_Spike extends Entity{
	public static String SPIKE = "tile_spike";
	public static String DAMAGE = "damage";
	  public Image         tile;
	  public SpriteSheet tiles;

	  public Tile_Spike(float x, float y) throws SlickException {
	        super(x, y);

	        SpriteSheet tiles = new SpriteSheet("resources/nightmareSheet.png", 32, 32);
	        Image tile       = tiles.getSprite(1, 2);
			this.name = "nTile_Spike";
	        this.depth = 104;
	        setGraphic(tile);
	        setHitBox(0, 25, 32, 7);
	        addType(SOLID, SPIKE);
	    }

	    public void update(GameContainer gc, int delta) throws SlickException {
	        super.update(gc, delta);
	        
	    }

	    @Override
	    public void collisionResponse(Entity a) {
//	    	Character.charKill();
//	    	sc.print("ouch.. much?");
	    }
	}


	//~ Formatted by Jindent --- http://www.jindent.com
