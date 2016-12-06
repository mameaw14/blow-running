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
    if (laneitem != null) laneitem.render(delta);
  }
  
  public Vector2 getPosition() {
    return position;
  }
  
  public int getDistance() {
    return (int)(position.x * 1.428);
  }
  
  public int checkDistance() {
    
    if (position.x >= 622) {       //finished line
      return 2;
    }
    else {                              //do nothing
      return 0;
    }
  }
  
  void getLaneItem() {
    laneitem = new LaneItem(number);
  }
  
  public void activateLaneItem() {
    if (laneitem != null) {
      world.entities.remove(laneitem);
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
