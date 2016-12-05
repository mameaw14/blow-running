package com.blowrunning.game;

import com.badlogic.gdx.math.Vector2;

public class Runner implements Entity {
    private Vector2 position;
    
    public Runner (int x, int y, World world) {
        position = new Vector2 (x, y);
    }
    
    public void updatePosition() {
        position.x++;
    }
    
    public void render(float delta) {
      
    }
    public Vector2 getPosition() {
        return position;
    }
}
