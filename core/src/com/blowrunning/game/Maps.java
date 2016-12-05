package com.blowrunning.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import javafx.util.Pair;

public class Maps implements Entity {
  Map<Integer, Pair<Obj, Obj> > map;
  SpriteBatch batch;
  Sprite sprite;
  ArrayList<Obj> list;
  
  Maps() {
    batch = BlowrunningGame.batch;
    map = new TreeMap<Integer, Pair<Obj, Obj>>();
    map.put(100, createObj("grass"));
    map.put(150, createObj("grass"));
    map.put(170, createObj("grass"));
    map.put(200, createObj("flag"));
    map.put(300, createObj("flag"));
    map.put(400, createObj("flag"));
    map.put(500, createObj("flag"));
    map.put(600, createObj("flag"));
    map.put(700, createObj("flag"));
    map.put(800, createObj("flag"));
    map.put(900, createObj("flag"));
  }
  
  private Pair createObj(String str) {
    return new Pair<Obj, Obj>(new Obj(str, 1), new Obj(str, 2));
  }
  
  @Override
  public void render(float delta) {
    float speed = 1F;
    int dis1, dis2;
    dis1 = World.getRunner(1).getDistance();
    dis2 = World.getRunner(2).getDistance();
    for (int key : map.keySet()) {
      if(key < dis1) {
        Pair<Obj, Obj> pair = map.get(key);
        pair.getKey().render(delta, speed);
      } 
      if (key < dis2) {
        Pair<Obj, Obj> pair = map.get(key);
        pair.getValue().render(delta, speed);
      }
    }
  }
}
