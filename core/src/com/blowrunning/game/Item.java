package com.blowrunning.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Item implements Entity {
  
  int VALID_TIME = 5;
  Sprite sprite;
  boolean is_activated = false;
  SpriteBatch batch;
  
  Item(String imgStr) {
    this.batch = BlowrunningGame.batch;
    Texture img = new Texture(imgStr);
    
    sprite = new Sprite(img);
    sprite.setOriginCenter();
    sprite.setPosition(400,500);
  }
  
  @Override
  public void render(float delta) {
    sprite.draw(batch);
  }

}
