package com.nightmare.Pew;

import java.awt.geom.Point2D;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

import it.randomtower.engine.ME;
import it.randomtower.engine.actors.TopDownActor;
import it.randomtower.engine.entity.Entity;
import it.randomtower.engine.entity.PhysicsEntity;
import com.nightmare.Pew.Portal_Blue;

public class Character extends PhysicsEntity implements InputProcessor {

	public int mySpeed = 100;

	public static final String STAND_LEFT = "stand_left";
	public static final String STAND_RIGHT = "stand_right";
	public static final String BACKWARDS_LEFT = "backwards_left";
	public static final String BACKWARDS_RIGHT = "backwards_right";

	public static Point2D.Float p1;
	public static Point2D.Float p2;

	static int playerHealth;
	int playerEnergy;

	static int lastDir = 1;
	private boolean movement;
	private boolean onGround = false;
	public boolean lastLeft;
	// private int addedDeadText = 0;
	public static int gunDir;
	public boolean noClip;
	public boolean displayInfo;
	public int bulletSpeed = 10;

	public static int mouseAngle;

	public Image healthDrop;

	public SpriteSheet spriteSheet;

	public static int mouseX, mouseY;

	public Character(float x, float y) throws SlickException {
		super(x, y);
		spriteSheet = new SpriteSheet("resources/nightmareSheet.png", 64, 32);
		setupAnimations(spriteSheet);
		setHitBox(8, 0, 18, 64);
		addType(PLAYER);
		playerHealth = 100;
		playerEnergy = 100;
		this.depth = 100;
		this.name = "nCharacter";
		// System.out.println(ME.keyRestart);
		Gdx.input.setInputProcessor(this);
		healthDrop = new Image("resources/bd.png");

		p1 = new Point2D.Float(x, y);
		p2 = new Point2D.Float(mouseX, mouseY);

	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public static void charKill() {
		playerHealth = 0;
	}

	private void setupAnimations(SpriteSheet playerSheet) throws SlickException {
		setGraphic(new SpriteSheet(playerSheet, 32, 64));
		duration = 150;
		addAnimation(ME.WALK_RIGHT, true, 0, 0, 1, 2, 3);
		addAnimation(ME.WALK_LEFT, true, 0, 4, 5, 6, 7);
		addAnimation(BACKWARDS_RIGHT, true, 0, 7, 6, 5, 4);
		addAnimation(BACKWARDS_LEFT, true, 0, 3, 2, 1, 0);
		addAnimation(STAND_RIGHT, false, 0, 0);
		addAnimation(STAND_LEFT, false, 0, 4);
	}

	@Override
	public void render(GameContainer gc, Graphics gr) throws SlickException {
		super.render(gc, gr);
		if (selectBox.invSlot == 4 || selectBox.invSlot == 5) {
			if (p1.distance(p2) < 64) {
				// System.out.println("ye");
				gr.drawRect((int) ((mouseX + 16) / 32) * 32,
						(int) ((mouseY + 16) / 32) * 32, 32, 32);
			}
		}

		// for (int i = 0; i < Quantities.portalblues; i += 1) {
		// gr.drawImage(spriteSheet.getSubImage(240, 64, 16, 16), 1, 32);
		// gr.translate(0, 15);
		// }
		// gr.resetTransform();

		for (int i = 0; i < (int) playerHealth / 10; i += 1) {
			gr.drawImage(spriteSheet.getSubImage(256, 32, 15, 13), 32, 16);
			gr.translate(15, 0);
		}
		gr.resetTransform();

		// for (int i = 0; i < Quantities.portalreds; i += 1) {
		// gr.drawImage(spriteSheet.getSubImage(240, 80, 16, 16), 17, 32);
		// gr.translate(0, 15);
		// }
		// gr.resetTransform();
		//
		// for (int i = 0; i < Quantities.arrows; i += 1) {
		// gr.drawImage(spriteSheet.getSubImage(228, 64, 7, 14), 192, 14);
		// gr.translate(15, 0);
		// }
		// gr.resetTransform();

		if (Gdx.input.isKeyPressed(Keys.A) || Gdx.input.isKeyPressed(Keys.LEFT)) {
			if (collide(SOLID, x - 1, y) == null) {
				if (lastLeft) {
					currentAnim = ME.WALK_LEFT;
				} else if (!lastLeft) {
					currentAnim = BACKWARDS_LEFT;
				}
				x -= Gdx.graphics.getDeltaTime() * mySpeed;
				lastDir = 0;
				movement = true;
			}
		} else if (Gdx.input.isKeyPressed(Keys.D)
				|| Gdx.input.isKeyPressed(Keys.RIGHT)) {
			if (collide(SOLID, x + 1, y) == null) {
				if (!lastLeft) {
					currentAnim = ME.WALK_RIGHT;
				} else if (lastLeft) {
					currentAnim = BACKWARDS_RIGHT;
				}
				x += Gdx.graphics.getDeltaTime() * mySpeed;
				lastDir = 1;
				movement = true;
			}
		} else {
			movement = false;
		}

	}

	@Override
	public void collisionResponse(Entity e) {
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		super.update(gc, delta);

		mouseAngle = Math.abs((int) calculateAngle(this.x + 16, this.y + 32,
				Character.mouseX, Character.mouseY) + 270);
		if (mouseAngle >= 90 && mouseAngle <= 270) {
			Character.gunDir = 0;
		} else {
			Character.gunDir = 1;
		}
		// sc.print(mouseAngle);

		p1.setLocation(x, y);
		p2.setLocation(mouseX, mouseY);

		if (movement == false) {
			if (lastLeft == true) {
				currentAnim = STAND_LEFT;
			} else {
				currentAnim = STAND_RIGHT;
			}
		}

		if (gunDir == 0 && lastLeft == false) {
			currentAnim = STAND_LEFT;
			lastLeft = true;
		} else if (gunDir == 1 && lastLeft == true) {
			currentAnim = STAND_RIGHT;
			lastLeft = false;
		}

		if (noClip) {
			gravity = 0;
		}

		// if (currentAnim == ME.WALK_LEFT) {
		// if (lastDir == 0) {
		// currentAnim = STAND_LEFT;
		// } else if (lastDir == 1) {
		// currentAnim = STAND_RIGHT;
		// }
		// }

		if (collide(Tile_Spike.SPIKE, x, y + 1) != null) {
			playerHealth = playerHealth - 1;
			// PewWorld.system.setPosition(this.x, this.y);
		}
		if (collide(Spring_Up.SU, x, y + 1) != null) {
			Entity SU = this.world.find("nSpring_Up");
			SU.animations.get(Spring_Up.ACTIVE).restart();

			// SU.currentAnim = Spring_Up.ACTIVE;
			Spring_Up.isMoving = true;
			speed.y = -30;
			new java.util.Timer().schedule(new java.util.TimerTask() {
				@Override
				public void run() {
					Spring_Up.isMoving = false;
				}
			}, 360);
			// } else {
			// Spring_Up.isMoving = false;

		}

		if (collide(Launcher.LU, x, y + 1) != null) {
			Entity LU = this.world.find("nLauncher");
			LU.animations.get(Launcher.ACTIVE).restart();

			// SU.currentAnim = Spring_Up.ACTIVE;
			Launcher.isMoving = true;
			speed.x = 10;
			speed.y = -10;
			new java.util.Timer().schedule(new java.util.TimerTask() {
				@Override
				public void run() {
					Launcher.isMoving = false;
				}
			}, 450);
			// } else {
			// Spring_Up.isMoving = false;

		}

		if (collide(Portal_Red.PR, x, y) != null) {
			Entity PortB = this.world.find("nPortal_Blue");
			if (Portal_Blue.border == 1) { // GOOD2GO
				this.x = PortB.x - 16;
				this.y = PortB.y - 31;
				speed.y = 10;
			}
			if (Portal_Blue.border == 2) { // GOOD2GO
				this.x = PortB.x - 2;
				this.y = PortB.y - 32;
				x -= Gdx.graphics.getDeltaTime() * mySpeed;

			}
			if (Portal_Blue.border == 3) {
				this.x = PortB.x - 16;
				this.y = PortB.y - 31;
				speed.y = -10;
			}
			if (Portal_Blue.border == 4) {
				this.x = PortB.x + 2;
				this.y = PortB.y - 32;
				x += Gdx.graphics.getDeltaTime() * mySpeed;
				// speed.x = 0.4f;

			}
		}

		// CURRENT
		// TODO needs bigger radius to catch arrows in walls + needs removal
		// if (collide(Arrow.BULLET, x, y) != null) {
		// Quantities.arrows++;
		// }

		if (collide(Portal_Blue.PB, x, y) != null) {
			Entity PortR = this.world.find("nPortal_Red");
			if (Portal_Red.border == 1) { // GOOD2GO
				this.x = PortR.x - 16;
				this.y = PortR.y - 31;
				speed.y = 10;

			}
			if (Portal_Red.border == 2) { // GOOD2GO

				this.x = PortR.x - 15;
				this.y = PortR.y - 32;
				x -= Gdx.graphics.getDeltaTime() * mySpeed;

			}
			if (Portal_Red.border == 3) {
				this.x = PortR.x - 16;
				this.y = PortR.y - 31;
				speed.y = -10;
				// y -= Gdx.graphics.getDeltaTime() * mySpeed;

			}
			if (Portal_Red.border == 4) {
				this.x = PortR.x - 31;
				this.y = PortR.y - 32;
				x += Gdx.graphics.getDeltaTime() * mySpeed;

			}
		}
		onGround = false;
		if (collide(SOLID, x, y + 1) != null) {
			onGround = true;
		}

		if (Gdx.input.isKeyPressed(Keys.W)) {
			// normal jump
			if (onGround) {
				speed.y = -6;
			}

		}

		if (Gdx.input.isKeyPressed(Keys.SPACE)) {
			// if (Inventory_GUI.moveOn == false) {
			// Inventory_GUI.moveOn = true;
			// }
			// else if (Inventory_GUI.moveOn == true) {
			// Inventory_GUI.moveOn = false;
			// }
			// Inventory_GUI.setVisible();
			Entity gui = this.world.find("nINV_GUI");
			gui.visible = false;
		}

		if (speed.y < 0 && !Gdx.input.isKeyPressed(Keys.W)) {
			gravity(delta);
			gravity(delta);
		}

		// set the gravity
		gravity(delta);

		if (playerHealth <= 0) { // && addedDeadText == 0
			// Text_Entity te = new Text_Entity(this.x, this.y, PewWorld.font,
			// "DEAD!");
			respawn();
			// PewWorld.deathParticles();
		}

	}

	public boolean isRightMoving() {
		if (currentAnim.equalsIgnoreCase(ME.WALK_RIGHT)) {
			return true;
		}

		return false;
	}

	public boolean isLeftMoving() {
		if (currentAnim.equalsIgnoreCase(ME.WALK_LEFT)) {
			return true;
		}

		return false;
	}

	public boolean isRightStanding() {
		if (currentAnim.equalsIgnoreCase(TopDownActor.STAND_RIGHT)) {
			return true;
		}

		return false;
	}

	public boolean isLeftStanding() {
		if (currentAnim.equalsIgnoreCase(TopDownActor.STAND_LEFT)) {
			return true;
		}

		return false;
	}

	@Override
	public boolean keyDown(int keycode) {
		if (keycode == 0) {
			// 0 is the ~ key, found from System.out.println(keycode);
			if (ME.debugEnabled == false) {
				ME.debugEnabled = true;
			} else if (ME.debugEnabled == true) {
				ME.debugEnabled = false;
			}
		}
		if (keycode == 3) {
			respawn();
		}
		// System.out.println(keycode);
		if (keycode == 133) {
			System.out.println("Acceleration: " + this.acceleration.x + ", "
					+ this.acceleration.y);
			System.out.println("Gravity: " + this.gravity);
			System.out.println("Speed: " + this.speed.x + ", " + this.speed.y);

		}
		if (keycode == 8) {
			selectBox.invSlot = 1;
		}
		if (keycode == 9) {
			selectBox.invSlot = 2;
		}
		if (keycode == 10) {
			selectBox.invSlot = 3;
		}
		if (keycode == 11) {
			selectBox.invSlot = 4;
		}
		if (keycode == 12) {
			selectBox.invSlot = 5;
		}
		if (keycode == 13) {
			selectBox.invSlot = 6;
		}
		if (keycode == 14) {
			selectBox.invSlot = 7;
		}
		if (keycode == 15) {
			selectBox.invSlot = 8;
		}
		if (keycode == 16) {
			selectBox.invSlot = 9;
		}
		if (keycode == 7) {
			selectBox.invSlot = 10;
		}

		return false;
	}

	private void respawn() {
		Entity sp = this.world.find("nSpawnPoint");
		x = sp.x;
		y = sp.y;
		playerHealth = 100;
		PewWorld.loadQuantities();
		Entity pb = this.world.find("nPortal_Blue");
		Entity pr = this.world.find("nPortal_Red");
		pb.x = 1000;
		pb.y = 1000;
		pr.x = 1000;
		pr.y = 1000;
	}

	@Override
	public boolean keyTyped(char keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int dir) {
		// Entity gun = this.world.find("nPortal_Gun");
		// // Portal_Blue.myX = ((x + 16) / 32) * 32;
		// // Portal_Blue.myY = ((y + 16) / 32) * 32;
		// pbBullet pbB = null;
		// try {
		// pbB = new pbBullet(x, y, gun.getAngle(), bulletSpeed);
		// } catch (SlickException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// if (pbB != null) {
		// ME.world.add(pbB);
		// } else {
		// sc.print("null");
		// }
		if (dir == 1) {
			if (selectBox.invSlot < 10) {
				// Entity sb = this.world.find("nselectBox");
				// Entity invGUI = this.world.find("nINV_GUI");
				// if (sb.y != invGUI.y + (288 * invGUI.scale)) {
				// sb.y += 32 * invGUI.scale;
				selectBox.invSlot += 1;
			} else {
				// sb.y -= 288 * invGUI.scale;
				selectBox.invSlot = 1;
			}
		} else if (dir == -1) {
			if (selectBox.invSlot > 1) {
				// Entity sb = this.world.find("nselectBox");
				// Entity invGUI = this.world.find("nINV_GUI");
				// if (sb.y > invGUI.y) {
				// sb.y -= 32 * invGUI.scale;
				selectBox.invSlot -= 1;
			} else {
				// sb.y += 288 * invGUI.scale;
				selectBox.invSlot = 10;
			}
		}
		return false;
	}

	@Override
	public boolean touchDown(int x, int y, int finger, int button) {
		if (button == 0) {
			if (selectBox.invSlot == 2 && Quantities.portalblues > 0) {
				Entity gun = this.world.find("nPortal_Gun");
				// Portal_Blue.myX = ((x + 16) / 32) * 32;
				// Portal_Blue.myY = ((y + 16) / 32) * 32;
				mouseX = x;
				mouseY = y;
				Quantities.portalblues -= 1;
				pbBullet pbB = null;
				if (gunDir == 0) {
					try {
						pbB = new pbBullet(this.x, this.y + 27, gun.getAngle(),
								bulletSpeed);
					} catch (SlickException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if (gunDir == 1) {
					try {
						pbB = new pbBullet(this.x, this.y + 27, gun.getAngle(),
								bulletSpeed);
					} catch (SlickException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (pbB != null) {
					ME.world.add(pbB);
				} else {
					sc.print("pbB null in Character class");
				}
			} else if (selectBox.invSlot == 1 && Quantities.portalreds > 0) {
				Entity gun = this.world.find("nPortal_Gun");
				// Portal_Blue.myX = ((x + 16) / 32) * 32;
				// Portal_Blue.myY = ((y + 16) / 32) * 32;
				mouseX = x;
				mouseY = y;
				Quantities.portalreds -= 1;
				prBullet prB = null;
				if (gunDir == 0) {
					try {
						prB = new prBullet(this.x, this.y + 27, gun.getAngle(),
								bulletSpeed);
					} catch (SlickException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if (gunDir == 1) {
					try {
						prB = new prBullet(this.x, this.y + 27, gun.getAngle(),
								bulletSpeed);
					} catch (SlickException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (prB != null) {
					ME.world.add(prB);
				} else {
					sc.print("prB null in Character class");
				}
			}
			if (selectBox.invSlot == 3 && Quantities.arrows > 0) {
				Entity gun = this.world.find("nPortal_Gun");
				// Portal_Blue.myX = ((x + 16) / 32) * 32;
				// Portal_Blue.myY = ((y + 16) / 32) * 32;
				mouseX = x;
				mouseY = y;
				Quantities.arrows -= 1;
				Arrow arrow = null;
				if (gunDir == 0) {
					try {
						arrow = new Arrow(this.x - 32, this.y + 20,
								gun.getAngle(), bulletSpeed);
					} catch (SlickException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if (gunDir == 1) {
					try {
						arrow = new Arrow(this.x + 32, this.y + 20,
								gun.getAngle(), bulletSpeed);
					} catch (SlickException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (arrow != null) {
					ME.world.add(arrow);
				} else {
					sc.print("pbB null in Character class");
				}
			}
		}
		if (button == 1) {
			if (selectBox.invSlot == 1 && Quantities.portalblues > 0) {
				Entity gun = this.world.find("nPortal_Gun");
				// Portal_Blue.myX = ((x + 16) / 32) * 32;
				// Portal_Blue.myY = ((y + 16) / 32) * 32;
				mouseX = x;
				mouseY = y;
				Quantities.portalblues -= 1;
				pbBullet pbB = null;
				if (gunDir == 0) {
					try {
						pbB = new pbBullet(this.x, this.y + 27, gun.getAngle(),
								bulletSpeed);
					} catch (SlickException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if (gunDir == 1) {
					try {
						pbB = new pbBullet(this.x, this.y + 27, gun.getAngle(),
								bulletSpeed);
					} catch (SlickException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (pbB != null) {
					ME.world.add(pbB);
				} else {
					sc.print("pbB null in Character class");
				}
			} else if (selectBox.invSlot == 2 && Quantities.portalreds > 0) {
				Entity gun = this.world.find("nPortal_Gun");
				// Portal_Blue.myX = ((x + 16) / 32) * 32;
				// Portal_Blue.myY = ((y + 16) / 32) * 32;
				mouseX = x;
				mouseY = y;
				Quantities.portalreds -= 1;
				prBullet prB = null;
				if (gunDir == 0) {
					try {
						prB = new prBullet(this.x, this.y + 27, gun.getAngle(),
								bulletSpeed);
					} catch (SlickException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if (gunDir == 1) {
					try {
						prB = new prBullet(this.x, this.y + 27, gun.getAngle(),
								bulletSpeed);
					} catch (SlickException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (prB != null) {
					ME.world.add(prB);
				} else {
					sc.print("prB null in Character class");
				}
			}
		}
		return false;
	}

	@Override
	public boolean touchDragged(int arg0, int arg1, int arg2) {
		return false;
	}

	@Override
	public boolean touchMoved(int x, int y) {
		// Entity PortB = this.world.find("nPortal_Blue");
		// Cursor.x = x;
		// Cursor.y = y;
		mouseX = x;
		mouseY = y;
		// System.out.println("Mouse Coordinates: " + "x = " + mouseX + ", y = "
		// + mouseY);

		return false;
	}

	@Override
	public boolean touchUp(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		return false;
	}

}