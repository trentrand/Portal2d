package com.nightmare.Pew;

import java.io.IOException;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SavedState;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;



/**a demo game that works on both slick and android
 * 
 * bounce the balls as long as you can without
 * letting them hit the ground.
 * the longer you go, the more will be added.
 * High scores will be recorded.*/
public class Main extends StateBasedGame{

	public static final int MenuState=0;
	public static final int PlayState=1;
	public static final int PewWorld=2;
	
	
	private static SavedState highScoreSave;
	
	public static final String highScoreName="highscore";
	
	private static int highScore;
	
	public Main() {
		super("Quantity");
	}

	public static void saveHighscore(int newHigh){
		highScoreSave.setNumber(highScoreName, newHigh);
		try {
			highScoreSave.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
		highScore=newHigh;
	}
	
	public static int getHighScore(){
		return highScore;
	}
	
	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		
		gc.setMaximumLogicUpdateInterval(50);
		gc.setIcon("resources/icon.png");
		highScoreSave=new SavedState(highScoreName);
		try {
			highScoreSave.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		highScore=(int) highScoreSave.getNumber(highScoreName, 0);

		//add the menu
		addState(new MenuState());
		
		
		//add ME level
		addState(new PewWorld(2, gc));
		
		//start with the menu
		enterState(PewWorld);
	}
}
