package com.blowrunning.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Runner implements Entity {
  private Vector2 position;
  Sprite sprite, runnerSprite;
  SpriteBatch batch;
  Sprite p1onFire = new Sprite(new Texture("bg1onfire.png"));
  Sprite p2onFire = new Sprite(new Texture("bg2onfire.png"));
  Sprite p1Froze = new Sprite(new Texture("bg1froze.png"));
  Sprite p2Froze = new Sprite(new Texture("bg2froze.png"));
  Sprite p1JumpBack = new Sprite(new Texture("bg1jumpback.png"));
  Sprite p2JumpBack = new Sprite(new Texture("bg2jumpback.png"));
  Sound itemSound = Gdx.audio.newSound(Gdx.files.internal("item.wav"));
  Sound fireSound = Gdx.audio.newSound(Gdx.files.internal("fire.mp3"));
  Sound freezeSound = Gdx.audio.newSound(Gdx.files.internal("freeze.mp3"));
  Sound jumpSound = Gdx.audio.newSound(Gdx.files.internal("jumpback.wav"));
  World world;
  int number;
  int type;
  final int STARTPX = 36, FINISHPX = 622;
  int count;
  int countGb;
  boolean usingItem;
  boolean isSlow;
  boolean globalItem;
  boolean finish;
  LaneItem laneitem;
  boolean isSpriteUp;
  
  public Runner (int x, int y, World world, int number) {
    count = 0;
    countGb = 0;
    this.number = number;
    this.world = world;
    position = new Vector2 (x, y);
    usingItem = false;
    isSlow = false;
    globalItem = false;
    finish = false;
    isSpriteUp = true;
    this.batch = BlowrunningGame.batch;
    if (number == 1) {
      sprite = new Sprite(new Texture("runner1.png"));
      runnerSprite = new Sprite(new Texture("blue.png"));
    }
    else {
      sprite = new Sprite(new Texture("runner2.png"));
      runnerSprite = new Sprite(new Texture("red.png"));
    }
    sprite.setOriginCenter();
    sprite.setSize(17, 17);
  }
  
  public void updatePosition(float speed) {
    int checkDistance = checkDistance();
    if(checkDistance == 3) {
      position.x = STARTPX;
    }
    if (checkDistance != 2) {
      if (!usingItem && isSlow) {
        speed *= 0.5;
        count++;
      }
      else if (usingItem) {
        if (type ==1) {
          speed *= 2;
        }
        count++;
      }
      position.x += speed;
      if(isSpriteUp){   //animate runner
        runnerSprite.translateY(speed / 2);
        if (runnerSprite.getY() > 0) isSpriteUp = false;
      } else {
        runnerSprite.translateY(- speed / 2);
        if (runnerSprite.getY() < -3) isSpriteUp = true;
      }
    }
    
    if (count >= 200) {
      isSlow = false;
      usingItem = false;
      count = 0;
      type = 0;
    }
  }
  
  @Override
  public void render(float delta) {
    sprite.setPosition(position.x, position.y);
    sprite.draw(batch);
    runnerSprite.draw(batch);
    updateLaneItem(delta);
    if (usingItem) {
      if (type == 1) {
        if(number == 1) p1onFire.draw(batch);
        if(number == 2) p2onFire.draw(batch);
      }
      else if (type == 2) {
        if(number == 1) p2Froze.draw(batch);
        if(number == 2) p1Froze.draw(batch);
      }
    }
    if (globalItem) {
      if(number == 1) p1JumpBack.draw(batch);
      if(number == 2) p2JumpBack.draw(batch);
      countGb++;
      if(countGb >= 15) {
        globalItem = false;
        countGb = 0;
      }
    }
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
      finish = true;
      world.playerWin(number);
      return 2;
    }
    else if (position.x < STARTPX) {
      return 3;
    }
    else {                              //do nothing
      return 0;
    }
  }
  
  public void setDistance(int dis) {
    position.x = dis / 1.428F;
  }
  
  void initLaneItem(int type) {
    itemSound.play();
    this.type = type;
    laneitem = new LaneItem(number, "lane_item"+type);
  }
  
  public void activateLaneItem() {
    if (laneitem != null) {
      usingItem = true;
      if (type == 2) {
        world.activateLaneItem(number);
        freezeSound.play();
      } else {
        fireSound.play();
      }
      System.out.println("runner " + number + " activate lane item");
      laneitem = null;
    }
  }
  
  public void activateGlobalItem() {
    jumpSound.play();
    globalItem = true;
    if (position.x < 100 + STARTPX) {
      position.x = STARTPX;
    }
    else {
      position.x -= 100;
    }
    System.out.println("runner " + number + " activate global item");
  }
  
  public void changeSlowStatus() {
    isSlow = true;
    count = 0;
  }
  
  public boolean checkFinished(){
    return finish;
  }
  
  public void reset() {
    count = 0;
    isSlow = false;
    position.x = STARTPX;
    type = 0;
    countGb = 0;
    usingItem = false;
    globalItem = false;
    finish = false;
    laneitem = null;
  }
}