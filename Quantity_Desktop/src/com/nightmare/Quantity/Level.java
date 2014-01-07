package com.nightmare.Quantity;

import it.marteEngine.World;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.ResourceLoader;

public class Level {
	public final static char SPIKE = '*';
	public final static char BLK_FLOOR = '=';
	public final static char PORTAL_BLUE = 'B';
	public final static char PORTAL_RED = 'R';
	public final static char SPRING_UP = 'Z';
	public final static char LAUNCHER = 'L';
	public final static char SPAWNPOINT = '@';
	public final static char ITEMPR = '1';
	public final static char ITEMPB = '2';
	public final static char ITEMARROW = '3';
	public final static char ITEMLAUNCHER = '4';
	public final static char ITEMSPRING = '5';
	public final static char PUSHCUBE = 'C';
	public final static char WOBOT = 'W';
	public final static char ENDPOINT = 'O';

	private ArrayList<String> lines = null;
	public int levelNum;
	private static String startingXCoord = null;
	private static String startingYCoord = null;

	public static boolean levelExists(int levelNum) {
		String level = "resources/level" + levelNum + ".dat";
		try {
			ResourceLoader.getResourceAsStream(level);
		} catch (RuntimeException e) {
			return false;
		}
		return true;
	}

	public static Level load(int levelNum, World PewWorld)
			throws SlickException {
		String level = "resources/level" + levelNum + ".dat";

		Level levelLoaded = null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				ResourceLoader.getResourceAsStream(level)));
		levelLoaded = new Level();
		levelLoaded.lines = new ArrayList<String>();
		levelLoaded.levelNum = levelNum;
		int width = 0;
		int height = 0;

		try {
			int count = 0;
			while (reader.ready()) {
				String line = reader.readLine();
				count++;
				if (count == 1) {
					startingXCoord = line;
				}
				if (count == 2) {
					startingYCoord = line;
				}
				if (line == null) {
					break;
				}
				if (count > 2) {
					width = Math.max(line.length(), width);
					levelLoaded.lines.add(line);
				}
			}
		} catch (IOException ex) {
			sc.print("Failed to load level");
		}
		height = levelLoaded.lines.size();
		levelLoaded.createEntites(levelLoaded, width - 1, height - 1, PewWorld);
		sc.print("level loaded succesfullly");
		return levelLoaded;
	}

	private void createEntites(Level levelLoaded, int width, int height,
			World world) throws SlickException {
		int a = Integer.parseInt(startingXCoord);
		int b = Integer.parseInt(startingYCoord);
		for (int i = width; i >= 0; i--) {
			for (int j = height; j >= 0; j--) {
				char c = lines.get(j).charAt(i);

				float x = (i * 32) + a;
				float y = (j * 32) + b;
				switch (c) {
				case SPIKE:
					world.add(new Tile_Spike(x, y));
					break;
				case BLK_FLOOR:
					world.add(new Tile_BlkFloor(x, y));
					break;
				case PORTAL_BLUE:
					world.add(new Portal_Blue(x, y, 2));
					break;
				case PORTAL_RED:
					world.add(new Portal_Red(x, y, 4));
					break;
				case SPRING_UP:
					world.add(new Spring_Up(x, y));
					break;
				case SPAWNPOINT:
					world.add(new SpawnPoint(x, y));
					break;
				case LAUNCHER:
					world.add(new Launcher(x, y));
					break;
				case ITEMPR:
					world.add(new itemPR(x, y));
					break;
				case ITEMPB:
					world.add(new itemPB(x, y));
					break;
				case ITEMARROW:
					world.add(new itemArrow(x, y));
					break;
				case ITEMLAUNCHER:
					world.add(new itemLauncher(x, y));
					break;
				case ITEMSPRING:
					world.add(new itemSpring(x, y));
					break;
				case PUSHCUBE:
					world.add(new PushCube(x, y));
					break;
				case ENDPOINT:
					world.add(new Endpoint(x, y));
					break;
				case WOBOT:
					world.add(new Wobot(x, y, 1000));
					break;
				}
			}
		}
	}
}
