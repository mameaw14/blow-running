package com.blowrunning.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Obj{
  final float SPEED = 1F;
  Sprite sprite;
  float scale;
  private Vector2 direction;
  String str;
  int lane;
  float Xpoint;
  float XCONST;
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
  
  public void render(float delta, float scale) {
    float CONST = 380F;
    if (isOut) return;
    if (("lane_item1".equals(str) || "lane_item2".equals(str) ) && sprite.getY() <= 250) {
      World.getRunner(lane - 2).initLaneItem(1);
      isOut = true;
      return;
    }
    //System.out.println(direction.x);
    sprite.setScale(1 - scale);
    sprite.setPosition((1-scale) * direction.x * (XCONST+100) + Xpoint, scale * CONST);
    sprite.draw(batch);
    
    
    if (sprite.getY() <= 0) setupLane(lane);
  }
  
  public final void setupLane(int lane){
    scale = 0.1F;
    if(lane == 1) {
      direction.setAngle(-155F);
      Xpoint = BlowrunningGame.WIDTH / 2 - sprite.getOriginX() - 50;
      XCONST = Xpoint;
    } else if (lane == 2) {
      direction.setAngle(160F - 180F);
      Xpoint = BlowrunningGame.WIDTH / 2 - sprite.getOriginX() + 50;
      XCONST = 700 - Xpoint;
    } else if (lane == 3) {
      direction.setAngle(-130F);
      Xpoint = BlowrunningGame.WIDTH / 2 - sprite.getOriginX() - 20;
      XCONST = Xpoint;
    } else if (lane == 4) {
      direction.setAngle(130F - 180F);
      Xpoint = BlowrunningGame.WIDTH / 2 - sprite.getOriginX() + 20;
      XCONST = 700-Xpoint;
    }
  }
}
