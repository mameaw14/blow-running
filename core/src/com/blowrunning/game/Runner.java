package com.blowrunning.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Runner implements Entity {
    private int pos;
    private Vector2 position;
    Sprite sprite1, sprite2;
    SpriteBatch batch;
    Texture runnerImg;
    
    
    public Runner (int x, int y, World world, int number) {
        position = new Vector2 (x, y);
        this.batch = BlowrunningGame.batch;
        if (number == 1) {
            runnerImg = new Texture("runner1.png");
            pos = 35;
        }
        else {
            runnerImg = new Texture("runner2.png");
            pos = 395;
        }
        sprite1 = new Sprite(runnerImg);
        sprite1.setOriginCenter();
        sprite2 = new Sprite(runnerImg);
        sprite2.setOriginCenter();
        sprite1.setSize(20, 20);
    }
    
    
    public void updatePosition() {
        position.x++;
    }
    
    public void render(float delta) {
        sprite1.setPosition(position.x, position.y);
        sprite2.setPosition(pos, -50);
        sprite1.draw(batch);
        sprite2.draw(batch);
    }
    
    public Vector2 getPosition() {
        return position;
    }
}
