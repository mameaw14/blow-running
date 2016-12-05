package com.blowrunning.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Runner implements Entity {
    private Vector2 position;
    Sprite sprite;
    SpriteBatch batch;
    Texture runnerImg;
    
    
    public Runner (int x, int y, World world, int number) {
        position = new Vector2 (x, y);
        this.batch = BlowrunningGame.batch;
        if (number == 1) {
            runnerImg = new Texture("runner1.png");
        }
        else {
            runnerImg = new Texture("runner2.png");
        }
        sprite = new Sprite(runnerImg);
        sprite.setOriginCenter();
        sprite.setPosition(position.x, position.y);
        sprite.setSize(20, 20);
    }
    
    
    public void updatePosition() {
        position.x++;
    }
    
    public void render(float delta) {
        sprite.setPosition(position.x, position.y);
        sprite.draw(batch);
    }
    
    public Vector2 getPosition() {
        return position;
    }
}
