package com.blowrunning.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BlowrunningGame extends Game {
	public static SpriteBatch batch;
        public static final int WIDTH = 700;
        public static final int HEIGHT = 700;
	
	@Override
	public void create () {
          batch = new SpriteBatch();
          setScreen(new GameScreen(this));
	}

	@Override
	public void render () {
          super.render();
	}
	
	@Override
	public void dispose () {
          batch.dispose();
	}
}
