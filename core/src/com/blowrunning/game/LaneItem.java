package com.blowrunning.game;

public class LaneItem extends Item{
  int lane;
  
  LaneItem(int lane) {
    super("lane_item.png");
    this.lane = lane;
  }
}
