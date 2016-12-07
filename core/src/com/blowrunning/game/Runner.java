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
  int number;
  int type;
  final int STARTPX = 36, FINISHPX = 622;
  World world;
  LaneItem laneitem;
  
  public Runner (int x, int y, World world, int number) {
    this.number = number;
    this.world = world;
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
  
  public void updatePosition(float speed) {
    if (checkDistance() != 2) {
        position.x += speed;
    }
  }
  
  @Override
  public void render(float delta) {
    sprite.setPosition(position.x, position.y);
    sprite.draw(batch);
    updateLaneItem(delta);
  }
  
  void updateLaneItem(float delta) {
    if (laneitem != null) {
        if (!laneitem.isValid()) {
          laneitem = null;
        }
        else laneitem.render(delta);
    }
  }
  public Vector2 getPosition() {
    return position;
  }
  
  public float getDistance() {
    return (position.x - STARTPX) / 0.586F;
  }
  
  public int checkDistance() {
    
    if (position.x >= FINISHPX) {       //finished line
      return 2;
    }
    else {                              //do nothing
      return 0;
    }
  }
  
  public void setDistance(int dis) {
    position.x = dis / 1.428F;
  }
  
  void initLaneItem(int type) {
    this.type = type;
    laneitem = new LaneItem(number, "lane_item"+type);
  }
  
  public void activateLaneItem() {
    if (laneitem != null) {
      //.... what to do
      
      System.out.println("runner " + number + " activate lane item");
      laneitem = null;
    }
  }
  
  public void activateGlobalItem() {
    //... what to do
    System.out.println("runner " + number + " activate global item");
  }
}
