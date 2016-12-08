
package com.blowrunning.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class World {
    public SpriteBatch batch;
    private static Runner runner1, runner2;
    private BlowrunningGame blowrunningGame;
    private Maps map;
    Sound popSound = Gdx.audio.newSound(Gdx.files.internal("pop.mp3"));
    GlobalItem globalItem;
    ArrayList<Entity> entities; 
    int num;
    
    World (BlowrunningGame blowrunningGame){
      num = 0;
      entities = new ArrayList<Entity>();
      runner1 = new Runner(36, 661, this, 1);
      runner2 = new Runner(36, 661, this, 2);
      map = new Maps(this);
      this.blowrunningGame = blowrunningGame;
      entities.add(map);
      entities.add(runner1);
      entities.add(runner2);
    }
    
    public void render(float delta) {
      
      if (globalItem != null) {
        if (!globalItem.isValid() || !(!checkFinish(1) && !checkFinish(2))) {
          entities.remove(globalItem);
          globalItem = null;
        }
        //return;
      } 
      else {
        randomGlobalItem();
      }
      for (Entity x : entities) {
        x.render(delta);
      }
    }
    
    public void randomGlobalItem(){
      if (!checkFinish(1) && !checkFinish(2)) {
        if (Math.random() < 0.005F ) {
          popSound.play();
          System.out.println("init Glob item");
          globalItem = new GlobalItem();
          entities.add(globalItem);
        }
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
      int num;
      if (globalItem != null) {
        if (number == 1) {
          num = 2;
        }
        else {
          num = 1;
        }
        getRunner(num).activateGlobalItem();
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
    
    public boolean checkFinish(int number) {
      if (number == 1) return runner2.checkFinished();
      else return runner1.checkFinished();
    }
}
