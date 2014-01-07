package com.nightmare.Quantity;

import it.marteEngine.entity.Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
//import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import com.badlogic.gdx.InputProcessor;

public class Portal_Gun extends Entity implements InputProcessor {

	// parent is Tank reference
	private Character parent;
	public int Direction;
	public static Image iPortal_Gun;
	public static Image iBow_Full;
	public static Image iBow_Empty;
	public static Image iLauncher;
	public static Image iSpring;
	public static Image iHand;

	public SpriteSheet NightmareSheet;

	public Portal_Gun(Character parent) throws SlickException {
		super(parent.x, parent.y);
		// position turret on top of parent position
		this.parent = parent;
		SpriteSheet NightmareSheet = new SpriteSheet(
				"resources/nightmareSheet.png", 32, 32);
		iPortal_Gun = NightmareSheet.getSprite(8, 0);
		iBow_Full = NightmareSheet.getSprite(9, 3);
		iBow_Empty = NightmareSheet.getSprite(9, 2);
		iLauncher = NightmareSheet.getSprite(7, 3);
		iSpring = NightmareSheet.getSprite(6, 3);
		iHand = NightmareSheet.getSprite(8, 3);
		this.name = "nPortal_Gun";
		this.setCentered(true);
		this.depth = 101;

		// define(FIRE, Input.MOUSE_LEFT_BUTTON);
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		if (Character.gunDir == 0) {
			this.setCenterOfRotation(25, 18);
		} else {
			this.setCenterOfRotation(6, 18);
		}
		angle = Math.abs((int) calculateAngle(this.x, this.y, Character.mouseX,
				Character.mouseY) + 270);
		if (Character.mouseAngle >= 90 && Character.mouseAngle <= 270) {
			if (selectBox.invSlot == 1 || selectBox.invSlot == 2) {
				this.setGraphic(iPortal_Gun.getFlippedCopy(true, false));
			} else if (selectBox.invSlot == 3) {
				if (Quantities.arrows > 0) {
					this.setGraphic(iBow_Full.getFlippedCopy(true, true));
				} else {
					this.setGraphic(iBow_Empty.getFlippedCopy(true, true));
				}
			} else if (selectBox.invSlot == 4) {
				if (Quantities.launchers > 0) {
					this.setGraphic(iLauncher.getFlippedCopy(true, false));
				} else {
					this.setGraphic(iHand.getFlippedCopy(true, false));
				}
			} else if (selectBox.invSlot == 5) {
				if (Quantities.springsup > 0) {
					this.setGraphic(iSpring.getFlippedCopy(true, false));
				} else {
					this.setGraphic(iHand.getFlippedCopy(true, false));
				}
			}	

			// setGraphic(iPortal_Gun.getFlippedCopy(true, false));
			angle -= 180;
			x = parent.x + 12;
			y = parent.y + 29;
		} else {
			if (selectBox.invSlot == 1 || selectBox.invSlot == 2) {
				this.setGraphic(iPortal_Gun);
			} else if (selectBox.invSlot == 3) {
				if (Quantities.arrows > 0) {
					this.setGraphic(iBow_Full);
				} else {
					this.setGraphic(iBow_Empty);
				}
			} else if (selectBox.invSlot == 4) {
				if (Quantities.launchers > 0) {
					this.setGraphic(iLauncher);
				} else {
					setGraphic(iHand);
				}
			} else if (selectBox.invSlot == 5) {
				if (Quantities.springsup > 0) {
					this.setGraphic(iSpring);
				} else {
					setGraphic(iHand);
				}
			}

			x = parent.x + 21;
			y = parent.y + 29;
		}

		super.update(container, delta);
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

	public boolean touchMoved(int x, int y) {
		// Entity PortB = this.world.find("nPortal_Blue");
		// Cursor.x = x;
		// Cursor.y = y;

		return false;
	}

	@Override
	public boolean touchUp(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		return false;
	}

}
