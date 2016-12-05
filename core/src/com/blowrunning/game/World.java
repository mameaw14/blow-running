
package com.blowrunning.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class World {
    public SpriteBatch batch;
    private Runner runner1, runner2;
    private BlowrunningGame blowrunningGame;
    private Map map;
    ArrayList<Entity> entities; 
    
    World (BlowrunningGame blowrunningGame){
      entities = new ArrayList<Entity>();
      runner1 = new Runner(10, 600, this);
      runner2 = new Runner(10, 600, this);
      map = new Map();
      Item global = new GlobalItem();
      this.blowrunningGame = blowrunningGame;
      entities.add((Entity) runner1);
      entities.add((Entity) runner2);
      entities.add((Entity) map);
      entities.add((Entity) global);
    }
    
    public void render(float delta) {
      for(Entity x : entities) {
        x.render(delta);
      }
    }
    
    Runner getRunner(int x) {
        if (x == 1) {
            return runner1;
        }
        else {
            return runner2;
        }
    }

}
