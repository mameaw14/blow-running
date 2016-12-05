package com.blowrunning.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Obj{
  final float SPEED = 1F;
  Sprite sprite;
  float scale = 0.1F;
  Vector2 direction;
  static final SpriteBatch batch = BlowrunningGame.batch;
  
  Obj(String str, int lane) {
    Texture texture = new Texture(str + ".png");
    sprite = new Sprite(texture);
    sprite.setOriginCenter();
    direction = new Vector2(1,1);
    
    setupLane(lane);
  }
  
  public void render(float delta, float speed) {
    sprite.setScale(scale);
    sprite.translate(direction.x * speed, direction.y * speed);
    sprite.draw(batch);
    
    if(scale <= 1) {
    scale += speed / 250F;
    }
  }
  
  public final void setupLane(int lane){
    if(lane == 1) {
      direction.setAngle(-155F);
      sprite.setPosition(BlowrunningGame.WIDTH / 2 - 100, 380);
    } else {
      direction.setAngle(155F - 180F);
      sprite.setPosition(BlowrunningGame.WIDTH / 2, 380);
    }
  }
}
