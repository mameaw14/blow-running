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
    addObj();
  } 
  
  private String randomItem(){
    if (Math.random()<0.5) {
      return "lane_item1";
    }
    else {
      return "lane_item2";
    }
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
  
  public void addObj() {
    System.out.println("addobj");
    for (float i = 0; i < 1000 ;i += 11) {
      map.add(new Props("grass", i));
    }
    map.add(new Props("flag", 200F));
    map.add(new Props("flag", 400F));
    map.add(new Props("flag", 600F));
    map.add(new Props("flag", 800F));
    map.add(new Props("flag", 1000F));
    map.add(new Props(randomItem(), 200F));
    map.add(new Props(randomItem(), 400F));
    map.add(new Props(randomItem(), 600F));
    map.add(new Props(randomItem(), 800F));
  }
}
