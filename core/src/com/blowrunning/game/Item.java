package com.blowrunning.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Item implements Entity {
  
  int VALID_TIME = 3;
  protected Sprite sprite;
  SpriteBatch batch;
  float elapse_time;
  
  Item(String imgStr) {
    this.batch = BlowrunningGame.batch;
    Texture img = new Texture(imgStr);
    
    sprite = new Sprite(img);
    sprite.setOriginCenter();
    sprite.setPosition(BlowrunningGame.WIDTH / 2 - sprite.getOriginX(), 400);
    elapse_time = VALID_TIME;
  }
  
  @Override
  public void render(float delta) {
    if (elapse_time <= 2 && (int)(elapse_time * 10) % 5 == 0) ;
    else {
      sprite.draw(batch);
    }
    elapse_time -= delta;
  }
  
  public boolean isValid() {
    return elapse_time > 0;
  }

}
