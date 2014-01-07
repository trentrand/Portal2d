package com.nightmare.Pew;

import it.randomtower.engine.entity.Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.badlogic.gdx.InputProcessor;

public class BulletTester extends Entity implements InputProcessor{

	public Image bulletTester;
	
	public BulletTester(float x, float y) throws SlickException {
		super(x, y);
		Image bulletTester = new Image("resources/bulletTester.png");
		setGraphic(bulletTester);
		setHitBox(0,0,5, 5);
		this.name = "nBulletTester";
		addType(SOLID);
	}
	
	public void update(GameContainer gc, int delta) throws SlickException {
		super.update(gc, delta);
	}

	@Override
	public boolean keyDown(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchMoved(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int x, int y, int pointer, int button) {
		return false;
	}

}
