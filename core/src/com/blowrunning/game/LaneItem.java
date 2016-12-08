package com.blowrunning.game;

public class LaneItem extends Item{
  int lane;
  
  LaneItem(int lane, String type) {
    super(type+".png");
    
    this.lane = lane;
    
    if (lane == 1) {
      sprite.translate(-BlowrunningGame.WIDTH / 4, -80);
    } else {
      sprite.translate(BlowrunningGame.WIDTH / 4, -80);
    }
  }
}
