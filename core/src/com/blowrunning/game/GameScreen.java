package com.blowrunning.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import practicum.PeriBoard;

public class GameScreen extends ScreenAdapter {
  SpriteBatch batch;
  Sprite sprite, sttb;
  Texture img, bg, statusbar;
  World world;
  Runner runner1, runner2;
  Sound themeSound, startSound;
  PeriBoard peri;

  GameScreen(BlowrunningGame blowrunningGame) {
    peri = new PeriBoard();
    world = new World(blowrunningGame);
    batch = blowrunningGame.batch;
    runner1 = world.getRunner(1);
    runner2 = world.getRunner(2);
    bg = new Texture("bg.png");
    statusbar = new Texture("statusbar.png");
    sprite = new Sprite(bg);
    sttb = new Sprite(statusbar);
    sprite.setOriginCenter();
    startSound = Gdx.audio.newSound(Gdx.files.internal("start.wav"));
    startSound.play();
    themeSound = Gdx.audio.newSound(Gdx.files.internal("sound.mp3"));
    themeSound.loop();
  }

  @Override
  public void render (float delta) {
    peri.update();
    input(delta);
    Gdx.gl.glClearColor((float)204/256, (float)102/256, 0, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    batch.begin();
    batch.draw(bg, 0, 0);
    world.render(delta);
    batch.end();
  }

  @Override
  public void dispose () {
    batch.dispose();
    img.dispose();
  }

  private void input (float delta) {
    runner1.updatePosition(peri.getSpeed(1));
    runner2.updatePosition(peri.getSpeed(2));
    if (Gdx.input.isKeyPressed(Input.Keys.A)) { //runner1 run
      runner1.updatePosition(1);
    }
    if (Gdx.input.isKeyPressed(Input.Keys.L)) { //runner2 run
      runner2.updatePosition(1);
    }
    if (Gdx.input.isKeyPressed(Input.Keys.S)) { //activate lane1 item
      runner1.activateLaneItem();
    }
    if (Gdx.input.isKeyPressed(Input.Keys.K)) { //activate lane2 item
      runner2.activateLaneItem();
    }
    if (peri.getSwitch(1)) { //runner1 activate global item
      world.activateGlobalItem(1);
    }
    if (peri.getSwitch(2)) { //runner2 activate global item
      world.activateGlobalItem(2);
    }
  }
}

