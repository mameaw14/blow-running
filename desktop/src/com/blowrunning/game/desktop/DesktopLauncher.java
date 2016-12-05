package com.blowrunning.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.blowrunning.game.BlowrunningGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = BlowrunningGame.WIDTH;
    config.height = BlowrunningGame.HEIGHT; 
    new LwjglApplication(new BlowrunningGame(), config);
	}
}
