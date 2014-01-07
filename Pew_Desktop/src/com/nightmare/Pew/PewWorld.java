package com.nightmare.Pew;



import it.randomtower.engine.World;
import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.InputProcessor;
import com.nightmare.Pew.Character;

public class PewWorld extends World implements ApplicationListener,
		InputProcessor {

	public static int levelNum = 0;
	public static Level level;
	public static Image bg;
	public static Font font;
	public int myX, myY;
	public static int screenX, screenY;
	
	
	
	public PewWorld(int id, GameContainer gc) throws SlickException {
		super(id, gc);

	}

	@Override
	public int getID() {
		return Main.PewWorld;
	}

	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		super.init(gc, sbg);
		Resources.loadRes();
		screenX = this.getWidth();
		screenY = this.getHeight();
		Character player = new Character(100, 100);
		add(player);
		
		
		// setCameraOn(player);
		font = new AngelCodeFont("resources/defaultfont.fnt",
				"resources/defaultfont.png");

		Text_Entity te = new Text_Entity(5, this.height - 22, font, "Quantity Beta 0.3");
		add(te);
		te.depth = 1000;

		Text_Entity instructions = new Text_Entity(
				35,
				35,
				font,
				"Use the mouse to aim, and WASD to move. Mouse scroller or 0-9 to select inventory. HOME key restarts");
		add(instructions);
		te.depth = 1000;
		Background bg = new Background(0, 0);
		add(bg);

		Inv gui = new Inv(PewWorld.screenX - 96,
				PewWorld.screenY / 12);
		// this.getWidth() - 64, this.getHeight() / 2);
		this.add(gui);
		
		selectBox sb = new selectBox(gui.x - 9, gui.y - 9);
		this.add(sb);
		
		itemLauncher il = new itemLauncher(200, 650);
		add(il);
		
		itemPR ipr = new itemPR(250, 650);
		add(ipr);

		invPR iPR = new invPR(gui.x + 8, gui.y + 8);
		add(iPR);
		
		invPB iPB = new invPB(gui.x + 8, gui.y + 70);
		add(iPB);
		
		invArrow iAR = new invArrow(gui.x + 6, gui.y + 134);
		add(iAR);
		
		invLauncher iLU = new invLauncher(gui.x + 8, gui.y + 200);
		add(iLU);
		
		invSpring iSU = new invSpring(gui.x + 8, gui.y + 264);
		add(iSU);
		
		// Stops the first shot from reading null!
		Portal_Red prS = new Portal_Red(1000, 1000, 3);
		add(prS);
		Portal_Blue pbS = new Portal_Blue(1000, 1000, 3);
		add(pbS);
		
		Portal_Gun pb = new Portal_Gun(player);
		add(pb);

//		 setCameraOn(player);
		/* added by level generator + cleared from levelLoad method */
		// BulletTester tile = new BulletTester(50, 50);
		// add(tile);

	}
	
	private void loadLevel(StateBasedGame sbg) throws SlickException {
		levelNum++;
		if (Level.levelExists(levelNum)) {
			// this.clear();
			level = Level.load(levelNum, this);
		}
		loadQuantities();
//		Inv.setupInv();
	}
	
	
	public static void loadQuantities() {
		if (levelNum == 1) {
			Quantities.portalblues = 2;
			Quantities.portalreds = 2;
			Quantities.arrows = 2;
			Quantities.springsup = 0;
			Quantities.launchers = 0;
		}
	}
	
	public void enter(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		super.enter(gc, sbg);
		// gr.setColor(Color.white);
		// gr.fillRect(0, 0, 300, 300);
		loadLevel(sbg);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		super.update(gc, sbg, delta);
	}
	
	public static void deathParticles(){
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics gr)
			throws SlickException {
		super.render(gc, sbg, gr);
		// Image bg = new Image("resources/bg.png");
		// gr.scale(3, 3);
		// bg.draw(0, 0);
		// SpriteSheet ss = new SpriteSheet("resources/nightmareSheet.png", 32,
		// 32);
		// gr.drawImage(ss.getSprite(0, 0), 0, 0);
	}
	
	@Override
	public void create() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean keyDown(int keycode) {
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
	public boolean touchDown(int x, int y, int pointer, int button) {
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

	public static void touch(int x, int y) {
	}

	public static void TPr2b() {
		// TODO Make Teleport method

	}
}
