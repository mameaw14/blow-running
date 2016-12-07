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
  boolean isOut;
  static final SpriteBatch batch = BlowrunningGame.batch;
  
  Obj(String str, int lane) {
    isOut = false;
    this.str = str;
    this.lane = lane;
    
    Texture texture = new Texture(str + ".png");
    sprite = new Sprite(texture);
    sprite.setOriginCenter();
    direction = new Vector2(1,1);
    
    setupLane(lane);
  }
  
  public void render(float delta, float scale) {
    float CONST = 250F;
    if (isOut) return;
    if (("lane_item1".equals(str) || "lane_item2".equals(str) ) && sprite.getY() <= 250) {
      if ("lane_item1".equals(str)) {
        World.getRunner(lane - 2).initLaneItem(1);
      }
      else if ("lane_item2".equals(str)) {
        World.getRunner(lane - 2).initLaneItem(2);
      }
      isOut = true;
      return;
    }
    sprite.setScale(1 - scale);
    sprite.setPosition((1-scale) * direction.x * (XCONST + 200) + Xpoint, scale * CONST + 130);
    sprite.draw(batch);
    
    if ( ("lane_item1".equals(str) ) && (sprite.getY() <= 250F) ) {
      World.getRunner(lane - 2).initLaneItem(1);
      isOut = true;
    }
  }
  
  public final void setupLane(int lane){
    scale = 0.1F;
    if(lane == 1) {
      direction.setAngle(-160F);
      Xpoint = BlowrunningGame.WIDTH / 2 - sprite.getOriginX() - 50;
      XCONST = Xpoint;
    } else if (lane == 2) {
      direction.setAngle(220F - 180F);
      Xpoint = BlowrunningGame.WIDTH / 2 - sprite.getOriginX() + 50;
      XCONST = 700 - Xpoint;
    } else if (lane == 3) {
      System.out.println("lane3");
      direction.setAngle(-100F);
      Xpoint = BlowrunningGame.WIDTH / 2 - sprite.getOriginX() - 20;
      XCONST = Xpoint;
    } else if (lane == 4) {
      direction.setAngle(100F - 180F);
      Xpoint = BlowrunningGame.WIDTH / 2 - sprite.getOriginX() + 20;
      XCONST = 700 - Xpoint;
    }
  }
}
