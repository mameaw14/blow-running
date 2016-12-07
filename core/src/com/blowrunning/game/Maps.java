package com.blowrunning.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Map;
import java.util.TreeMap;

public class Maps implements Entity {
  Map<Integer, Props> map;
  SpriteBatch batch;
  Sprite sprite;
  World world;
  
  Maps(World world) {
    this.world = world;
    batch = BlowrunningGame.batch;
    map = new TreeMap<Integer, Props>();
    map.put(100, new Props("grass"));
    map.put(340, new Props("grass"));
    map.put(270, new Props("grass"));
    map.put(500, new Props("grass"));
    map.put(700, new Props("grass"));
    map.put(200, new Props("flag"));
    map.put(400, new Props("flag"));
    map.put(600, new Props("flag"));
    map.put(800, new Props("flag"));
    map.put(1000, new Props("flag"));
    map.put(200, new Props("lane_item1"));
  }
  
  @Override
  public void render(float delta) {
    float speed = 1F;
    int dis1, dis2;
    dis1 = world.getRunner(1).getDistance();
    dis2 = world.getRunner(2).getDistance();
    for (int key : map.keySet()) {
      if(key < dis1 + 100) {
        Props props = map.get(key);
        props.getObj(1).render(delta, speed);
      } 
      if (key < dis2 + 100) {
        Props props = map.get(key);
        props.getObj(2).render(delta, speed);
      }
    }
  }
}
