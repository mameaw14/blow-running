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
        sprite.setSize(17, 17);
    }
    
    
    public void updatePosition() {
        if (checkDistance() != 2) {
            position.x++;
        }
    }
    
    public void render(float delta) {
        sprite.setPosition(position.x, position.y);
        sprite.draw(batch);
    }
    
    public Vector2 getPosition() {
        return position;
    }
    
    public int getDistance() {
        return (int)(position.x * 1.428);
    }
    
    public int checkDistance() {
        if (getDistance() % 200 == 0) {     //add item   
            return 1;
        }
        else if (position.x == 622) {            //finished line
            return 2;
        }
        else {                                   //do nothing
            return 0;
        }
    }
}
