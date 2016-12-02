package com.blowrunning.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter {
	SpriteBatch batch;
	Texture img;
  World world;
  
  GameScreen(BlowrunningGame blowrunningGame) {
    world = new World(blowrunningGame);
    batch = blowrunningGame.batch;
  }
  
	@Override
	public void render (float delta) {
    input(delta);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
  
  private void input (float delta) {
    if (Gdx.input.isKeyPressed(Input.Keys.A)) { //runner1 run
      
    }
    if (Gdx.input.isKeyPressed(Input.Keys.L)) { //runner2 run
      
    }
    if (Gdx.input.isKeyPressed(Input.Keys.S)) { //activate lane1 item
      
    }
    if (Gdx.input.isKeyPressed(Input.Keys.K)) { //activate lane2 item
      
    }
    if (Gdx.input.isKeyPressed(Input.Keys.H)) { //activate global item
      
    }
  }
}
