
package com.blowrunning.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class World {
    public SpriteBatch batch = BlowrunningGame.batch;
    private static Runner runner1, runner2;
    private BlowrunningGame blowrunningGame;
    Sprite p2Finish = new Sprite(new Texture("bg2win.png"));
    Sprite p1Finish = new Sprite(new Texture("bg1win.png"));
    private Maps map;
    Sound popSound = Gdx.audio.newSound(Gdx.files.internal("pop.mp3"));
    GlobalItem globalItem;
    ArrayList<Entity> entities; 
    int gameFinished; // 0 = not finish, 1/2 = player i win
    
    World (BlowrunningGame blowrunningGame){
      gameFinished = 0;
      entities = new ArrayList<Entity>();
      runner1 = new Runner(36, 661, this, 1);
      runner2 = new Runner(36, 661, this, 2);
      map = new Maps(this);
      this.blowrunningGame = blowrunningGame;
      entities.add(map);
      entities.add(runner2);
      entities.add(runner1);
    }
    
    public void render(float delta) {
      if (gameFinished == 0) {
        randomGlobalItem();
        for (Entity x : entities) {
          x.render(delta);
        }
      } else {
        if (gameFinished == 1) {
          p1Finish.draw(batch);
        } else {
          p2Finish.draw(batch);
        }
      }
      
    }
    
    public void randomGlobalItem(){
      if (globalItem != null) {
        if (!globalItem.isValid()) {
          entities.remove(globalItem);
          globalItem = null;
        }
      } else if (Math.random() < 0.005F ) {
          popSound.play();
          System.out.println("init Glob item");
          globalItem = new GlobalItem();
          entities.add(globalItem);
        }
    }
    
    public static Runner getRunner(int x) {
      if (x == 1) {
        return runner1;
      }
      else {
        return runner2;
      }
    }
    
    public void activateGlobalItem(int number) {
      if (globalItem != null) {
        if (number == 1) {
          getRunner(2).activateGlobalItem();
        }
        else {
          getRunner(1).activateGlobalItem();
        }
        entities.remove(globalItem);
        globalItem = null;
      }
    }
    
    public void activateLaneItem(int player) {      //only lane_item2
      if (player == 1) {
        runner2.changeSlowStatus();
      }
      else {
        runner1.changeSlowStatus();
      }
    }
    public boolean isFinished() {
      return gameFinished != 0;
    }
    
    public void playerWin(int i) {
      gameFinished = i;
    }
    
    public void reset() {
      gameFinished = 0;
      map.addObj();
    }
}
