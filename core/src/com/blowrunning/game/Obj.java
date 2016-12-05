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
  String str;
  int lane;
  boolean isOut = false;
  static final SpriteBatch batch = BlowrunningGame.batch;
  
  Obj(String str, int lane) {
    this.str = str;
    this.lane = lane;
    
    Texture texture = new Texture(str + ".png");
    sprite = new Sprite(texture);
    sprite.setOriginCenter();
    direction = new Vector2(1,1);
    
    setupLane(lane);
  }
  
  public void render(float delta, float speed) {
    if (isOut) return;
    if ("lane_item".equals(str) && sprite.getY() <= 250) {
      new LaneItem(lane - 2);
      isOut = true;
      return;
    }
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
      sprite.setPosition(BlowrunningGame.WIDTH / 2 - sprite.getOriginX() - 50, 380);
    } else if (lane == 2) {
      direction.setAngle(160F - 180F);
      sprite.setPosition(BlowrunningGame.WIDTH / 2 - sprite.getOriginX() + 50, 380);
    } else if (lane == 3) {
      direction.setAngle(-130F);
      sprite.setPosition(BlowrunningGame.WIDTH / 2 - sprite.getOriginX() - 20, 380);
    } else if (lane == 4) {
      direction.setAngle(130F - 180F);
      sprite.setPosition(BlowrunningGame.WIDTH / 2 - sprite.getOriginX() + 20, 380);
      
    }
  }
}
