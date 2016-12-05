package com.blowrunning.game;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

public class Maps implements Entity {
  
  Maps() {
    Map<Integer, String> map = new TreeMap<Integer, String>();
    map.put(100, "Grass");
    map.put((int)200, "Grass");
    map.put((int)140, "150");
    for(int key: map.keySet()) {
      System.out.println(key + " - " + map.get(key));
    }
  }
  @Override
  public void render(float delta) {
    
  }
}
