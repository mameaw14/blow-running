package com.blowrunning.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class Maps implements Entity {
  private int type = 0;
  ArrayList<Props> map;
  SpriteBatch batch;
  Sprite sprite;
  World world;
  
  Maps(World world) {
    this.world = world;
    batch = BlowrunningGame.batch;
    map = new ArrayList<Props>();
    map.add(new Props("grass", 100F));
    map.add(new Props("grass", 340F));
    map.add(new Props("grass", 270F));
    map.add(new Props("grass", 500F));
    map.add(new Props("grass", 700F));
    map.add(new Props("flag", 200F));
    map.add(new Props("flag", 400F));
    map.add(new Props("flag", 600F));
    map.add(new Props("flag", 800F));
    map.add(new Props("flag", 1000F));
    map.add(new Props("lane_item1", 200F));
    //map.add(new Props("lane_item1", 400F));
    //map.add(new Props("lane_item1", 600F));
    
//    if (Math.random()<0.5) {
//      map.add(new Props("lane_item1", 200F));
//    }
//    else {
//      map.add(new Props("lane_item2", 200F));
//    }
  } 
  
  @Override
  public void render(float delta) {
    float dis1, dis2;
    dis1 = world.getRunner(1).getDistance();
    dis2 = world.getRunner(2).getDistance();
    for (Props prop : map) {
      prop.render(delta, dis1, dis2);
    }
  }
}
