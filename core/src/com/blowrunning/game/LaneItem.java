package com.blowrunning.game;

public class LaneItem extends Item{
  int lane;
  
  LaneItem(int lane) {
    super("lane_item.png");
    this.lane = lane;
    
    sprite.setScale(0.5F);
    if (lane == 1) {
      sprite.translate(-BlowrunningGame.WIDTH / 4, -150);
    } else {
      sprite.translate(BlowrunningGame.WIDTH / 4, -150);
    }
  }
}
