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
  Runner runner1, runner2;
  
    GameScreen(BlowrunningGame blowrunningGame) {
        world = new World(blowrunningGame);
        batch = blowrunningGame.batch;
        runner1 = world.getRunner(1);
        runner2 = world.getRunner(2);
    }
  
	@Override
	public void render (float delta) {
    input(delta);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
    world.render(delta);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
  
    private void input (float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.A)) { //runner1 run
            runner1.updatePosition();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.L)) { //runner2 run
            runner2.updatePosition();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) { //activate lane1 item
      
        }
        if (Gdx.input.isKeyPressed(Input.Keys.K)) { //activate lane2 item
      
        }
        if (Gdx.input.isKeyPressed(Input.Keys.G)) { //runner1 activate global item
      
        }
        if (Gdx.input.isKeyPressed(Input.Keys.H)) { //runner2 activate global item
      
        }
    }
}
