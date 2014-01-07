package com.nightmare.Quantity;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class MenuState extends BasicGameState{
	
	/**the image for the play button*/
	Image play;
	/**the location of the play button*/
	Vector2f playLocation;
	
	/**the image for the exit button*/
	Image exit;
	/**the location of the exit button*/
	Vector2f exitLocation;
	
	/**marks which state to go to next.
	 * if nextState==getID(), then do not
	 * change states.*/
	int nextState;
	
	/**a lovely background*/
	private Image brickBackground;
	
	@Override
	public int getID() {
		return Main.MenuState;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		
		brickBackground=new Image("resources/brickBack.png");
		
		play=new Image("resources/playButton.png");
		playLocation=new Vector2f(
				(gc.getWidth()-play.getWidth())/2,
				(gc.getHeight()-play.getHeight())/2-64);
		
		exit=new Image("resources/exitButton.png");
		exitLocation=new Vector2f(
				(gc.getWidth()-exit.getWidth())/2,
				(gc.getHeight()-exit.getHeight())/2+64);
		
		nextState=getID();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics gr)
			throws SlickException {
		
		//tile the background image to get a full background
		for (int x=0;x<gc.getWidth();x+=brickBackground.getWidth()){
			for (int y=0;y<gc.getHeight();y+=brickBackground.getHeight()){
				brickBackground.draw(x, y);
			}
		}
		
		//show the high score
		gr.setColor(new Color(0,0,0,0.5f));
		gr.fillRect((gc.getWidth()-gr.getFont().getWidth("High Score: "+Main.getHighScore()/1000f))/2, 
				128, gr.getFont().getWidth("High Score: "+Main.getHighScore()/1000f), 
				gr.getFont().getHeight("High Score: "+Main.getHighScore()/1000f));
		gr.setColor(Color.white);
		gr.drawString("High Score: "+Main.getHighScore()/1000f, 
				(gc.getWidth()-gr.getFont().getWidth("High Score: "+Main.getHighScore()/1000f))/2,
				128);
		
		//show buttons
		play.draw(playLocation.getX(),playLocation.getY());
		exit.draw(exitLocation.getX(),exitLocation.getY());
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		
		//see if it's time to change states
		if (nextState!=getID()){
			sbg.enterState(nextState,new FadeOutTransition(),new FadeInTransition());
			nextState=getID();
		}
	}

	@Override
	public void mousePressed(int button, int x, int y) {
		
		//see if one of the buttons are pressed
		if (x>playLocation.x&&x<playLocation.x+play.getWidth()&&
				y>playLocation.y&&y<playLocation.y+play.getHeight()){
			//start the game
			nextState=Main.PlayState;
		}
		if (x>exitLocation.x&&x<exitLocation.x+exit.getWidth()&&
				y>exitLocation.y&&y<exitLocation.y+exit.getHeight()){
			//exit
			System.exit(0);
		}
	}
}
