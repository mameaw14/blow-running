
package com.blowrunning.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class World {
    public SpriteBatch batch;
    private static Runner runner1, runner2;
    private BlowrunningGame blowrunningGame;
    private Maps map;
    ArrayList<Entity> entities; 
    
    World (BlowrunningGame blowrunningGame){
      entities = new ArrayList<Entity>();
      runner1 = new Runner(36, 661, this, 1);
      runner2 = new Runner(36, 661, this, 2);
      map = new Maps(this);
      this.blowrunningGame = blowrunningGame;
      entities.add((Entity) runner1);
      entities.add((Entity) runner2);
      entities.add((Entity) map);
    }
    
    public void render(float delta) {
      updateItem();
      for(Entity x : entities) {
        x.render(delta);
      }
    }
    
    public void updateItem(){ 
        if (runner1.checkDistance() == 1) {
            
        }
        else if (runner2.checkDistance() == 1) {
            
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
}
