package com.blowrunning.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import java.util.Timer;
import java.util.TimerTask;

public class Runner implements Entity {
  private Timer timer;
  private Vector2 position;
  Sprite sprite;
  SpriteBatch batch;
  Texture runnerImg;
  int number;
  int type;
  int count;
  boolean usingItem;
  World world;
  LaneItem laneitem;
  
  public Runner (int x, int y, World world, int number) {
    count = 0;
    timer = new Timer();
    this.number = number;
    this.world = world;
    position = new Vector2 (x, y);
    usingItem = false;
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
    if (number == 1)
      System.out.println(usingItem);
    if (checkDistance() != 2) {
      if (!usingItem) {
        position.x += speed;
      }
      else if (usingItem && type ==1){
        position.x += speed*2;
      }
    }
    count++;
    if (count >= 200) {
      usingItem = false;
      System.out.println(count);
      count = 0;
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
  
  public void setDistance(int dis) {
    position.x = dis / 1.428F;
  }
  
  void initLaneItem(int type) {
    this.type = type;
    laneitem = new LaneItem(number, "lane_item"+type);
  }
  
  public void activateLaneItem() {
    if (laneitem != null) {
      usingItem = true;
      //timer.schedule(new fasterTask(),0,3000000);
      System.out.println("runner " + number + " activate lane item");
      laneitem = null;
    }
  }
  
  public void activateGlobalItem() {
    //... what to do
    System.out.println("runner " + number + " activate global item");
  }

  private class fasterTask extends TimerTask {

    @Override
    public void run() {
      usingItem = false;
      System.out.println("Do");
    }
  }
  
  
}
