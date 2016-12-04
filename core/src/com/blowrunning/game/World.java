
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
        runner1 = new Runner(10, 600, this);
        runner2 = new Runner(10, 600, this);
        map = new Map();
        this.blowrunningGame = blowrunningGame;
        entities.add((Entity) runner1);
        entities.add((Entity) runner2);
        entities.add((Entity) map);
    }
    
    public void render(float delta) {
      for(Entity x : entities) {
        x.render(delta);
      }
    }
}
