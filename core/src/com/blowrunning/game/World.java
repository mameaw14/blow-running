
package com.blowrunning.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class World {
    public SpriteBatch batch;
    private static Runner runner1, runner2;
    private BlowrunningGame blowrunningGame;
    private Maps map;
    GlobalItem globalItem;
    ArrayList<Entity> entities; 
    
    World (BlowrunningGame blowrunningGame){
      entities = new ArrayList<Entity>();
      runner1 = new Runner(36, 661, this, 1);
      runner2 = new Runner(36, 661, this, 2);
      map = new Maps(this);
      this.blowrunningGame = blowrunningGame;
      entities.add(runner1);
      entities.add(runner2);
      entities.add(map);
    }
    
    public void render(float delta) {
      randomGlobalItem();
      for (Entity x : entities) {
        x.render(delta);
      }
    }
    
    public void randomGlobalItem(){ 
      if (globalItem != null) {
        if (!globalItem.isValid()) {
          globalItem = null;
        }
        return;
      }
      if (Math.random() < 0.01 ) {
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
        getRunner(number).activateGlobalItem();
        entities.remove(globalItem);
        globalItem = null;
      }
    }
}
